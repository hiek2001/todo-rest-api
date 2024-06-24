package com.example.demo.model.entity;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter
@ToString
public class Member {
	
	@Id
	private String id;
	
	private String roles; // MEMBER, ADMIN
	
	private String nickname;
	
	@Column(length = 100, unique = true, nullable = false)
	private String password;

	private String name;

	@JsonIgnore
	public List<String> getRoleList() {
        if (this.roles.length() > 0) {
            return Arrays.asList(this.roles.split(","));
        }
        return new ArrayList<>();
    }

}
