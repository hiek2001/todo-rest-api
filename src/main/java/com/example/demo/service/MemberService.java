package com.example.demo.service;


import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.entity.Member;
import com.example.demo.repository.MemberRepository;
import com.example.demo.util.ObjectUtil;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {
	
	private final MemberRepository memberRepository;
	
	private final BCryptPasswordEncoder passwordEncoder;
	
	/**
	 * 회원가입
	 */
	@Transactional
	public Member join(Member member){
		validateDuplicateMember(member); 
		member.setPassword(passwordEncoder.encode(member.getPassword()));
		
		memberRepository.save(member);
		
		member = memberRepository.find(member.getId());

		return member;
	}
	

	private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findById(member.getId());

        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }
	
	/**
	 * 로그인
	 */
	@Transactional
	public boolean login(Member member) throws Exception {
		Member findMembers = memberRepository.findById(member.getId()).get(0);
		
		if(passwordEncoder.matches(member.getPassword(), findMembers.getPassword())) {
			return true;
		}
		
		return false;
	}

	/**
	 * 회원 탈퇴
	 */
	@Transactional
	public boolean deleteMember(String id) {
		Member findMembers = memberRepository.findById(id).get(0);
		if(!ObjectUtil.isEmpty(findMembers)) {
			memberRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

}
