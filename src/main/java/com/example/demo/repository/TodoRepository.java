package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.Member;
import com.example.demo.model.entity.Todo;
import com.example.demo.model.vo.TodoRequestVO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class TodoRepository {
	
	@PersistenceContext
	private final EntityManager em;
	
	public void save(Todo todo) {
		em.persist(todo);
	}
	
	public void update(Todo todo) {
		em.merge(todo);
	}
	
	
	public Todo findById(Long id) {
		return em.find(Todo.class, id);
	}
	
	public List<Todo> findAll(String flag) {
		String jpql = "select t from Todo t where 1=1";
		
		if(flag == "latest") {
			jpql += "order by t.updateDate DESC";
		}
		return em.createQuery(jpql, Todo.class)
				.getResultList();
	}
	
}
