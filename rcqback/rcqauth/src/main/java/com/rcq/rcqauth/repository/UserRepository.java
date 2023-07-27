package com.rcq.rcqauth.repository;

import com.rcq.rcqauth.entity.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<user,Long> {
    user findByUserEmail(String useremail);
}
