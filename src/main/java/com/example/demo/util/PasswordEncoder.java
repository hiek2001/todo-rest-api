//package com.example.demo.util;
//
//public interface PasswordEncoder {
//	
//	// 단방향 암호화
//	String encode(CharSequence rawPassword);
//
//	// 암호화되지 않은 비밀번호(raw-)와 암호화된 비밀번호(encoded-) 일치하는지 비교
//	boolean matches(CharSequence rawPassword, String encodedPassword);
//
//	// 암호화된 비밀번호를 다시 암호화하는 경우, true를 return 하게 설정
//	// true : 보안 강화
//	default boolean upgradeEncoding(String encodedPassword) {
//		return false;
//	}
//}
