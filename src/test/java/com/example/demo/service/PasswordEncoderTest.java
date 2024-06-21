package com.example.demo.service;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.util.BCryptPasswordEncoder;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class PasswordEncoderTest {

//	@Autowired
//    private MemberService memberService;

    @Autowired
    private PasswordEncoder passwordEncoder;
  
    @Test
    @DisplayName("패스워드 암호화 테스트")
    public void passwordEncode() throws Exception{
      // given
      String rawPassword = "12345678";

      // when
      String encodedPassword = passwordEncoder.encode(rawPassword);

      // then
      assertAll(
            () -> assertNotEquals(rawPassword, encodedPassword),
            () -> assertTrue(passwordEncoder.matches(rawPassword, encodedPassword))
      );
   } 
}
