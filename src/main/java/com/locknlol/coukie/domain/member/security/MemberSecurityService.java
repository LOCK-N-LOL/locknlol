package com.locknlol.coukie.domain.member.security;

import com.locknlol.coukie.domain.member.entity.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Decoder;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * Created by coupang on 2017. 6. 16..
 */
@Slf4j
@Service
public class MemberSecurityService {
	private static final String MEMBER_SECURITY_SERVICE_CRYPT_ERROR = "cryptPassword 메소드 암호화 실패 : {}";
	private static final String MEMBER_SECURITY_SERVICE_DECODE_ERROR = "decodeBuffer 실패 : {}";
	private static final String MEMBER_SECURITY_SERVICE_CONFIRM_ERROR = "복호화 실패 : {}";

	public String cryptPassword(String password) {
		String result = password;
		try {
			return Crypto.pbkdf2(result);
		} catch (InvalidKeySpecException | NoSuchAlgorithmException e) {
			log.error(MEMBER_SECURITY_SERVICE_CRYPT_ERROR, e.getMessage());
		}
		return result;
	}

	public boolean confirmPassword(Member member, String password) {
		BASE64Decoder decoder = new BASE64Decoder();
		String[] token = member.getPassword().split(":");
		try {
			byte[] salt = decoder.decodeBuffer(token[0]);
			String created = Crypto.pbkdf2(password, salt);
			return member.getPassword().equals(created);
		} catch (IOException e) {
			log.error(MEMBER_SECURITY_SERVICE_DECODE_ERROR, e.getMessage());
		} catch (InvalidKeySpecException | NoSuchAlgorithmException e) {
			log.error(MEMBER_SECURITY_SERVICE_CONFIRM_ERROR, e.getMessage());
		}
		return false;
	}
}
