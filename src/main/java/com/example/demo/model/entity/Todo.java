package com.example.demo.model.entity;

import java.time.LocalDateTime;

import javax.persistence.*;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.example.demo.enums.TodoStatus;

import lombok.*;

@Getter @Setter
@Entity
@NoArgsConstructor
public class Todo extends DateEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "member_id")
    private Member member;
	
	private String content;
	
	@CreatedDate
	private LocalDateTime createDate;
	
	@LastModifiedDate
	private LocalDateTime updateDate;
	
	@Enumerated(EnumType.STRING)
	private TodoStatus status; // todo 상태(TODO, IN_PROGRESS, DONE, PENDING)
	
	
	public void setStatus(TodoStatus status) {
		this.status = status;
	}
	
}
