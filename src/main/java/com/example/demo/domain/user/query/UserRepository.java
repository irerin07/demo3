package com.example.demo.domain.user.query;

import com.example.demo.domain.user.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    @Query(value = "select u from User u join fetch u.members where u.userId =:userId")
    User findUserById(@Param(value = "userId") String userId);

}