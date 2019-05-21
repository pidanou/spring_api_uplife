
package com.uplife.api.controller;

import com.uplife.api.exception.MemberNotFoundException;
import com.uplife.api.model.Member;
import com.uplife.api.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class MemberController {

   @Autowired
   MemberRepository memberRepository;





    // Get All Member
    /*@GetMapping("/members")

    public Member getMember(){
        return member;
    }*/






    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }






    /*/ Create a new member
    @PostMapping("/members")
    public Member create(@Valid @RequestBody Member member) {
        return MembersRepository.save(member);
    }*/

    // Get a Single member
    @GetMapping("/admin/getMember/{id}")
    public Member getMemberById(@PathVariable(value = "id") Long memberId) throws MemberNotFoundException {
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberNotFoundException(memberId));
    }

    /*/ Update a member
    @PutMapping("/members/{id}")
    public Member updateMember(@PathVariable(value = "id") Long memberId,
                               @Valid @RequestBody Member memberDetails) throws MemberNotFoundException {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberNotFoundException(memberId));
        member.setfirst_name(memberDetails.getfirst_name());
        member.setlast_name(memberDetails.getlast_name());
        Member updatedMember = memberRepository.save(member);
        return updatedMember;
    }*/

    /*/Delete a member
    @DeleteMapping("/members/{id}")
    public ResponseEntity<?> deleteMember(@PathVariable(value = "id") Long memberId) throws MemberNotFoundException {
        Member member = MembersRepository.findById(memberId)
                .orElseThrow(() -> new MemberNotFoundException(memberId));
        membersRepository.delete(member);
        return ResponseEntity.ok().build();
    }*/

}

