package com.uplife.api.repository;

import com.uplife.api.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface MembersRepository extends JpaRepository <Member, Long> {

    //List<Member> findAll();



}