package com.example.demo.entity;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.enums.TodoStatus;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TodoStatusTest {
	
	TodoStatus status = TodoStatus.TODO;
	
	@Test
	@DisplayName("todo 상태 변경 테스트")
	public void changeTodoStatusTest() {
		
		try {
			status = status.changeStatus(TodoStatus.IN_PROGRESS);
	        System.out.println("상태 변경: " + status.getStatusCode());
	         
	        status = status.changeStatus(TodoStatus.PENDING);
	        System.out.println("상태 변경: " + status.getStatusCode());
	         
	        status = status.changeStatus(TodoStatus.DONE);
	        System.out.println("상태 변경: " + status.getStatusCode());
	         
	        status = status.changeStatus(TodoStatus.TODO); // 잘못된 전환 확인
	        System.out.println("상태 변경: " + status.getStatusCode());
	        
		} catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
		 
	}
}
