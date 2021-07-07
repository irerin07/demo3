package com.example.demo.controller;

/**
 * @author 민경수
 * @description membership controller
 * @since 2021.07.04
 **********************************************************************************************************************/

import com.example.demo.dto.request.MembershipPointDTO;
import com.example.demo.dto.request.SaveMembershipDTO;
import com.example.demo.provider.MembershipProvider;
import com.example.demo.response.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;


import lombok.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
public class MembershipController {

    private final MembershipProvider membershipProvider;

    @GetMapping("/api/v1/membership")
    public ResponseEntity<AllMembershipResponse> getAllMemberShip(@Valid @RequestHeader("X-USER-ID") String userId) {
        AllMembershipResponse membershipResponse = membershipProvider.getAllMemberShip(userId);
        return new ResponseEntity<AllMembershipResponse>(membershipResponse, HttpStatus.OK);
    }

    @PostMapping("/api/v1/membership")
    public ResponseEntity<SaveMembershipResponse> saveMembership(@RequestHeader("X-USER-ID") String userId,
                                                                 @Valid @RequestBody SaveMembershipDTO saveMembershipDTO) {
        SaveMembershipResponse membershipResponse = membershipProvider.saveMembership(userId, saveMembershipDTO);
        return new ResponseEntity<SaveMembershipResponse>(membershipResponse, HttpStatus.OK);
    }

    @DeleteMapping("/api/v1/membership/{membershipId}")
    public ResponseEntity<DeleteMembershipResponse> deleteMembership(@RequestHeader("X-USER-ID") String userId, @Valid @PathVariable String membershipId) {
        DeleteMembershipResponse membershipResponse = membershipProvider.deleteMembership(userId, membershipId);
        return new ResponseEntity<DeleteMembershipResponse>(membershipResponse, HttpStatus.OK);
    }

    @GetMapping("/api/v1/membership/{membershipId}")
    public ResponseEntity<MembershipInformationResponse> getMembershipInfomation(
            @RequestHeader("X-USER-ID") String userId, @Valid @PathVariable String membershipId) {
        MembershipInformationResponse membershipResponse = membershipProvider.getMembershipInfomation(userId, membershipId);
        return new ResponseEntity<MembershipInformationResponse>(membershipResponse, HttpStatus.OK);
    }

    @PutMapping("/api/v1/membership/point")
    public ResponseEntity<MembershipPointResponse> membershipPoint(@RequestHeader("X-USER-ID") String userId,
                                                                   @Validated @RequestBody MembershipPointDTO membershipPointDTO) {
        MembershipPointResponse membershipResponse = membershipProvider.membershipPoint(userId, membershipPointDTO);
        return new ResponseEntity<MembershipPointResponse>(membershipResponse, HttpStatus.OK);
    }

}