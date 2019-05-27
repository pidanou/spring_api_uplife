package com.uplife.api.service;

import com.uplife.api.model.Member;
import com.uplife.api.model.MemberDetailsImpl;
import com.uplife.api.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Member> optionalMember = memberRepository.findByUsername(username);

        optionalMember
                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));
        return optionalMember
                .map(MemberDetailsImpl::new).get();
    }


}
