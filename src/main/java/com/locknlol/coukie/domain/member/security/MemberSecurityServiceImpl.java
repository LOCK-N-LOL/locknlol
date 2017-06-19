package com.locknlol.coukie.domain.member.security;

import com.locknlol.coukie.domain.member.Member;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Decoder;

/**
 * Created by coupang on 2017. 6. 16..
 */
@Service
public class MemberSecurityServiceImpl implements MemberSecurityService {

	@Override
	public String cryptPassword(String password) {
		try {
			return Crypto.pbkdf2(password);
		} catch (Exception e) {
			throw new RuntimeException("비밀번호 암호화 실패" + e.getCause());
		}
	}

	@Override
	public Boolean confirmPassword(Member member, String password) {
		BASE64Decoder decoder = new BASE64Decoder();
		String[] token = member.getPassword().split(":");
		try {
			byte[] salt = decoder.decodeBuffer(token[0]);
			String created = Crypto.pbkdf2(password, salt);
			return member.getPassword().equals(created);
		} catch (Exception e) {
			throw new RuntimeException("비밀번호가 틀립니다" + e.getMessage());
		}
	}
}
