package com.example.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.entity.Member;
import com.example.demo.model.entity.Todo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TodoRepositoryTest {

	@Autowired
	TodoRepository todoRepository;
	
	@Autowired
	MemberRepository memberRepository;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@PersistenceContext
	EntityManager em;
	
//	@Test
//	@DisplayName("todo 등록 테스트")
//	@Transactional
//	public void createTodo() throws Exception {
//		Member member = createMember();
//		
//		Todo todo = new Todo();
//		todo.setDescription("오늘도 코딩, 내일도 코딩합시다!");
//		
//		todo = Todo.createTodo(member, todo);
//		todoRepository.save(todo);
//		Todo newTodo = todoRepository.findById(todo.getId());
//		
//		Assertions.assertThat(newTodo.getDescription()).isEqualTo(todo.getDescription());
//	}
//	
//	private Member createMember() {
//		Member member = new Member();
//		member.setId("testes123");
//		member.setPassword(passwordEncoder.encode("8574"));
//		em.persist(member);
//		return member;
//	}
	
}
