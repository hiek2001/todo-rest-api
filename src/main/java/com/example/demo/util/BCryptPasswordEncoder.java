package com.example.demo.util;

import java.security.SecureRandom;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder.BCryptVersion;

public class BCryptPasswordEncoder{
	
	private final SecureRandom random = new SecureRandom();
	
	private final BCryptVersion version = BCryptVersion.$2B;
	private final int strength = 10;
	
	
	public String encode(CharSequence rawPassword) {
		if(rawPassword == null) {
			throw new IllegalArgumentException("rawPassword cannot be null");
		}
		String salt = getSalt();
		return BCrypt.hashpw(rawPassword.toString(), salt);
	}
	
	
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
	   if (rawPassword == null) {
	      throw new IllegalArgumentException("rawPassword cannot be null");
	   }
	 
	   return BCrypt.checkpw(rawPassword.toString(), encodedPassword);
	}
	
	
	private String getSalt() {
		if(this.random != null) {
			return BCrypt.gensalt(this.version.getVersion(), this.strength, this.random);
		}
		return BCrypt.gensalt(this.version.getVersion(), this.strength);
	}

//	private final SecureRandom random = new SecureRandom();
//	private final BCryptVersion version;
//	private final int strength;
//	private static final int BCRYPT_SALT_LEN = 16;
//	
//	/*
//	* BCryptPasswordEncoder.encode() : 암호화
//	*/
//	public String encode(CharSequence rawPassword) {
//		if(rawPassword == null) {
//			throw new IllegalArgumentException("rawPassword cannot be null");
//		}
//		
//		String salt;	
//		if(random != null) {
//			salt = BCrypt.gensalt(version.getVersion(), strength, random);
//		} else {
//			salt = BCrypt.gensalt(version.getVersion(), strength);
//		}
//		return BCrypt.hashpw(rawPassword.toString(), salt);
//	}
//	
//	/**
//	* BCrypt.gensalt() : Salt 생성
//	*/
//	public static String gensalt(String prefix, int log_rounds, SecureRandom random) throws IllegalArgumentException {
//	
//		StringBuilder rs = new StringBuilder();
//		byte rnd[] = new byte[BCRYPT_SALT_LEN]; // 16byte(128bit) 크기의 Salt 생성
//	
//		if (!prefix.startsWith("$2") || (prefix.charAt(2) != 'a' && prefix.charAt(2) != 'y' && prefix.charAt(2) != 'b')) {
//		throw new IllegalArgumentException ("Invalid prefix");
//			}
//	
//		if (log_rounds < 4 || log_rounds > 31) {
//		    throw new IllegalArgumentException ("Invalid log_rounds");
//		}
//	
//		random.nextBytes(rnd);
//	
//		rs.append("$2");
//		rs.append(prefix.charAt(2));
//		rs.append("$");
//		if (log_rounds < 10)
//			rs.append("0");
//	
//		rs.append(log_rounds);
//		rs.append("$");
//		encode_base64(rnd, rnd.length, rs);
//	
//		return rs.toString();
//	}
//	
//
//	public BCryptPasswordEncoder(BCryptVersion version, int strength, SecureRandom random) {
//
//		if (strength != -1 && (strength < BCrypt.MIN_LOG_ROUNDS || strength > BCrypt.MAX_LOG_ROUNDS)) {
//			throw new IllegalArgumentException("Bad strength");
//		}
//
//		this.version = version;
//		this.strength = strength == -1 ? 10 : strength; // 지정하지 않으면 강도를 10으로 설정
//		this.random = random;
//	}
//	
//	private static void encode_base64(byte[] input, int length, StringBuilder rs) {
//        Base64.Encoder encoder = Base64.getEncoder().withoutPadding();
//        String encoded = encoder.encodeToString(input, 0, length);
//        rs.append(encoded);
//    }
}
