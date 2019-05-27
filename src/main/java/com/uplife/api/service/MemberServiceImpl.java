package com.uplife.api.service;

import com.uplife.api.model.Member;
import com.uplife.api.model.Role;
import com.uplife.api.repository.RoleRepository;
import com.uplife.api.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


@Service
public class MemberServiceImpl implements MemberService{

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public void save(Member member) {
        member.setPassword(bCryptPasswordEncoder().encode(member.getPassword()));
        Optional<Role> basicUserRole = roleRepository.findById(Long.valueOf(1));
        Set<Role> roleSet = new HashSet<Role>();
        basicUserRole.ifPresent(roleSet::add);
        member.setRoles(roleSet);
        memberRepository.save(member);
    }


    public void updateToAdmin(long user_id){
        Optional<Member> member = memberRepository.findById(user_id);
        Set<Role> memberRole = new HashSet<>();
        if(member.isPresent()){
            memberRole = member.get().getRoles();
        }
        Optional<Role> adminRole = roleRepository.findById(2L);
        adminRole.ifPresent(memberRole::add);
        final Set<Role> finalMemberRole = new HashSet<>(memberRole);
        member.ifPresent(value -> value.setRoles(finalMemberRole));
        memberRepository.save(member.get());
    }

}
