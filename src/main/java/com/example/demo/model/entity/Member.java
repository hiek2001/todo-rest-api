package com.example.demo.model.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.*;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter
@ToString
public class Member {
	
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	
//	@Column(unique = true, nullable = false)
//	private String memberId;
	
//	private String role;
	
	private String nickname;
	
	@Column(length = 100, unique = true, nullable = false)
	private String password;

    private String name;
   
    
//    @JsonIgnore 
//    @OneToMany(mappedBy = "member")
//    private List<Todo> todoList = new ArrayList<>();
//    


    //== 확인용 객체에서 비밀번호 제거 ==//
//    public void clearPassword() {
//    	this.password = "";
//    }
    
}
