package com.uplife.api.repository;

import com.uplife.api.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository <Member, Long> {

    List<Member> findAll();

    @Override
    Optional<Member> findById(Long id);

    Optional<Member> findByUsername(String username);

    @Override
    Member save(Member member);
}