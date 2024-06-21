package com.example.demo.service;



import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.enums.TodoStatus;
import com.example.demo.model.entity.Member;
import com.example.demo.model.entity.Todo;
import com.example.demo.model.vo.TodoRequestVO;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.TodoRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TodoService {
	
	private final TodoRepository todoRepository;
	private final MemberRepository memberRepository;
	

	@Transactional
	public Todo save(TodoRequestVO todoVO) {
		Member todoInMember = memberRepository.find(todoVO.getMemberId());
		Todo newTodo = new Todo();
		newTodo.setMember(todoInMember);
		newTodo.setContent(todoVO.getContent());

		
		if(todoVO.getStatusCode() == null || todoVO.getStatusCode().isEmpty()) {
			newTodo.setStatus(TodoStatus.TODO);
		} 
		
		todoRepository.save(newTodo);
		
		return newTodo;
	}
	
	
	
	/*
	 * @param flag(조건)
	 */
	@Transactional(readOnly=true)
	public List<Todo> retrieveAllTodos(String flag) {
		return todoRepository.findAll(flag);
	}
	
	
	
	@Transactional(readOnly=true)
	public Todo getLatestTodo(String flag) {
		return this.retrieveAllTodos(flag).get(0);
	}
	
		
	
	@Transactional
	public void updateTodoStatus(Long todoId, TodoRequestVO todoVO) {
		TodoStatus updateStatus;
		Todo todo = todoRepository.findById(todoId);
		
		TodoStatus currentStatus = todo.getStatus();
		TodoStatus newStatus = TodoStatus.valueOf(todoVO.getStatusCode());			
		if(newStatus.equals("PENDING") || newStatus.equals("IN_PROGRESS")) {
			updateStatus = currentStatus.changeStatus(newStatus);
		} else {
			updateStatus = newStatus;
		}
		
		todo.setStatus(updateStatus);
		
		todoRepository.update(todo);

	}
		
}
