
package com.uplife.api.controller;

import com.uplife.api.exception.MemberNotFoundException;
import com.uplife.api.model.Member;
import com.uplife.api.repository.MemberRepository;
import com.uplife.api.repository.RoleRepository;
import com.uplife.api.service.MemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
public class MemberController {

   @Autowired
   private MemberRepository memberRepository;

   @Autowired
   private MemberServiceImpl memberService;

   @Autowired
   private RoleRepository roleRepository;



    @PostMapping("/registration")
    @ResponseBody
    public void registration(Member member){
        memberService.save(member);
    }

    @PutMapping("/admin/members/toAdmin/{user_id}")
    public void toAdmin(@PathVariable(value = "user_id") long user_id ){
        memberService.updateToAdmin(user_id);
    }



    @GetMapping("/admin/members/getAll")
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }




    // Get a Single member
    @GetMapping("/admin/members/getMember/{id}")
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

