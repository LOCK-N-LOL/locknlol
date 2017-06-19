package com.locknlol.coukie.domain.member.security;

import com.locknlol.coukie.domain.member.Member;

/**
 * Created by coupang on 2017. 6. 16..
 */
public interface MemberSecurityService {
    public String cryptPassword(String password);
    public Boolean confirmPassword(Member member, String Password);
}
