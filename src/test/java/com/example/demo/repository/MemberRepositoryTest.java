package com.example.demo.repository;

import javax.transaction.Transactional;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.entity.Member;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {

	@Autowired
	MemberRepository memberRepository;
	
//	@Test
//	@Transactional
//	public void testMember() throws Exception {
//		Member member = new Member();
//		member.setName("memberA");
//		
//		Long savedId = memberRepository.save(member);
//		Member findMember = memberRepository.find(savedId);
//		
//		Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());		
//	}
}
