package com.example.demo.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.enums.TodoStatus;
import com.example.demo.model.entity.Member;
import com.example.demo.model.entity.Todo;
import com.example.demo.model.vo.ResponseVO;
import com.example.demo.model.vo.TodoRequestVO;
import com.example.demo.service.MemberService;
import com.example.demo.service.TodoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/todos")
public class TodoApiController {
		
	private final TodoService todoService;
	

	/**
	 * todo 작성
	 * @param memberId, content(todo 내용), todo status(todo 상태)
	 * @return
	 */
	@PostMapping(value="/write", produces="application/json")
	public ResponseEntity<ResponseVO> writeTodo(@RequestBody TodoRequestVO todoVO) {
		
		try {
			Todo newTodo = todoService.save(todoVO);
			
			return ResponseEntity.ok(
					ResponseVO.builder()
					.statusCode(200)
					.message("todo 등록이 완료되었습니다.")
					.data(newTodo)
					.build()
			);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	    	            .body(
	    	                ResponseVO.builder()
	    	                    .statusCode(500)
	    	                    .message("내부 문제로 Todo 등록이 실패했습니다.")
	    	                    .build()
            );
		}
	}

	/**
	 * todo 전체 목록 조회
	 * @param 
	 * @return
	 */
	@GetMapping
	public ResponseEntity<ResponseVO> retrieveAllTodos() {
		String flag = "";
		List<Todo> todoList = todoService.retrieveAllTodos(flag);
		
		return ResponseEntity.ok(
				ResponseVO.builder()
				.statusCode(200)
				.message("조회가 완료되었습니다.")
				.data(todoList)
				.build()
		);
	}
	
	/**
	 * todo 가장 최근 1개 조회
	 * @param todoId
	 * @return
	 */
	@GetMapping(value="/latest", produces="application/json")
	public ResponseEntity<ResponseVO> getLatestTodo() {
		String flag ="latest";
		Todo latestTodo = todoService.getLatestTodo(flag);
		
		return ResponseEntity.ok(
				ResponseVO.builder()
				.statusCode(200)
				.message("조회가 완료되었습니다.")
				.data(latestTodo)
				.build()
		);
	}
	
	/**
	 * todo 상태 변경
	 * @param todoId, todoStatusCode
	 * @return
	 */
	@PutMapping(value="/{todoId}/status", produces="application/json")
	public ResponseEntity<ResponseVO> updateTodoStatus(@PathVariable Long todoId, @RequestBody TodoRequestVO todoVO) {
		try {
			todoService.updateTodoStatus(todoId, todoVO);
			
			return ResponseEntity.ok(
					ResponseVO.builder()
					.statusCode(200)
					.message("Todo 상태 변경이 완료되었습니다.")
					.build()
			);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
    	            .body(
    	                ResponseVO.builder()
    	                    .statusCode(500)
    	                    .message("내부 문제로 Todo 등록이 실패했습니다.")
    	                    .build()
    	            		);
		}
		
	}
	
}
