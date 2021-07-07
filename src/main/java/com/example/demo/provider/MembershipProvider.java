package com.example.demo.provider;

/**
 * @since       2021.07.04
 * @author      민경수
 * @description member provider
 **********************************************************************************************************************/
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


import com.example.demo.Provider;
import com.example.demo.domain.member.Member;
import com.example.demo.domain.member.MembershipService;
import com.example.demo.domain.member.exception.MemberException;
import com.example.demo.domain.user.User;
import com.example.demo.domain.user.UserService;
import com.example.demo.domain.user.exception.UserException;
import com.example.demo.dto.request.MembershipPointDTO;
import com.example.demo.dto.request.SaveMembershipDTO;
import com.example.demo.dto.response.AllMembershipDTO;
import com.example.demo.dto.response.MembershipInfomationDTO;
import com.example.demo.dto.response.SavedMembershipDTO;
import com.example.demo.response.*;
import com.example.demo.util.ListUtils;
import com.example.demo.util.PointCalcUtil;
import lombok.*;
import org.springframework.transaction.annotation.Transactional;

@Provider
@RequiredArgsConstructor
public class MembershipProvider {

    private final MembershipService membershipService;
    private final UserService userService;

    @Transactional(readOnly = true)
    public AllMembershipResponse getAllMemberShip(String userId) {

        RuntimeException error = null;

        List<AllMembershipDTO> allMembershipDTOs = new ArrayList<AllMembershipDTO>();

        User user = getUserByUserId(userId);

        if(user == null){
            error = new UserException("해당 유저를 찾을 수 없습니다.", 404);//TODO Enum 혹은 Error/Exception을 관리하는 클래스로 변경.
            return new AllMembershipResponse(false, allMembershipDTOs, error);
        }

        List<Member> memberList = membershipService.findAllMembershipByUserId(userId);

        if(ListUtils.isEmpty(memberList)){
            return new AllMembershipResponse(true, allMembershipDTOs, error);
        }

        allMembershipDTOs = memberList.stream().map(v -> new AllMembershipDTO(v)).collect(Collectors.toList());//TODO ModelMapper등 사용해서 Entity -> DTO 변경하도록

        return new AllMembershipResponse(true, allMembershipDTOs, error);
    }

    @Transactional
    public SaveMembershipResponse saveMembership(String userId, SaveMembershipDTO saveMembershipDTO) {

        String membershipId = saveMembershipDTO.getMembershipId();
        String membershipName = saveMembershipDTO.getMembershipName();
        int point = saveMembershipDTO.getPoint();

        User user = getUserByUserId(userId);

        if(user == null){
            UserException error = new UserException("해당 유저를 찾을 수 없습니다.", 404);
            return new SaveMembershipResponse(false, null, error);
        }

        Member membershipByMembershipIdAndUserId = membershipService.findMembershipByMembershipIdAndUserId(membershipId, userId);

        if(membershipByMembershipIdAndUserId != null && membershipByMembershipIdAndUserId.getMembershipStatus().equals("N")){
            membershipByMembershipIdAndUserId.updateStatus("Y");
            return new SaveMembershipResponse(true, new SavedMembershipDTO(membershipByMembershipIdAndUserId), null);
        }else if(membershipByMembershipIdAndUserId != null && membershipByMembershipIdAndUserId.getMembershipStatus().equals("Y")){
            MemberException error = new MemberException("이미 등록된 멤버쉽입니다..", 400);
            return new SaveMembershipResponse(false, null, error);
        }

        Member member = Member.of(membershipId, membershipName, point, user);
        try {
            member = membershipService.save(member);
        }catch (Exception e){
            MemberException error = new MemberException("서버 에러.", 500);
            return new SaveMembershipResponse(false, null, error);
        }
        return new SaveMembershipResponse(true, new SavedMembershipDTO(member), null);
    }

    @Transactional
    public DeleteMembershipResponse deleteMembership(String userId, String membershipId) {

        User user = getUserByUserId(userId);

        if(user == null){
            UserException error = new UserException("해당 유저를 찾을 수 없습니다.", 404);
            return new DeleteMembershipResponse(false, false, error);
        }

        Member member = membershipService.findMembershipByMembershipIdAndUserId(membershipId, userId);
        if(member == null){
            return new DeleteMembershipResponse(false, null, new MemberException("해당하는 멤버쉽을 찾을 수 없습니다.", 404));
        }
        if(member.getMembershipStatus().equals("N")){
            return new DeleteMembershipResponse(false, null, new MemberException("이미 비활성화된 멤버쉽입니다.", 404));
        }
        member.updateStatus("N"); //TODO enum과 converter 사용해서 membershipStatus 구분값 관리하도록 변경


        return new DeleteMembershipResponse(true, true, null);
    }

    @Transactional
    public MembershipInformationResponse getMembershipInfomation(String userId, String membershipId) {

        User user = getUserByUserId(userId);

        if(user == null){
            UserException error = new UserException("해당 유저를 찾을 수 없습니다.", 404);
            return new MembershipInformationResponse(false, null, error);
        }

        Member member = membershipService.findActiveMembershipByMembershipIdAndUserId(membershipId, userId);
        if(member == null){
            return new MembershipInformationResponse(false, null, new MemberException("해당하는 멤버쉽을 찾을 수 없습니다.", 404));
        }

        return new MembershipInformationResponse(true, new MembershipInfomationDTO(member), null);
    }

    @Transactional
    public MembershipPointResponse membershipPoint(String userId, MembershipPointDTO membershipPointDTO) {

        String membershipId = membershipPointDTO.getMembershipId();
        int amount = membershipPointDTO.getAmount();

        User user = getUserByUserId(userId);

        if(user == null){
            UserException error = new UserException("해당 유저를 찾을 수 없습니다.", 404);
            return new MembershipPointResponse(false, false, error);
        }

        Member member = membershipService.findActiveMembershipByMembershipIdAndUserId(membershipId, userId);
        if(member == null){
            return new MembershipPointResponse(false, false, new MemberException("해당하는 멤버쉽을 찾을 수 없습니다.", 404));
        }

        int calcPoint = PointCalcUtil.calcPoint(amount);
        member.updatePoint(calcPoint);

        return new MembershipPointResponse(true, true, null);
    }

    private User getUserByUserId(String userId){
        User userByUserId = userService.getUserByUserId(userId);
        return userByUserId;

    }

}