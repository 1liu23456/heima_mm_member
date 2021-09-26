package com.itheima.service.front;

import com.itheima.domain.front.Member;

/**
 * @Author: 刘旭阳
 * @Date: 2021/9/25 10:17
 * @Package: com.itheima.service.front
 * @ClassName: MemberService
 * @Description: TODO
 * @Version: 2021/9/25
 */
public interface MemberService {
    boolean register(Member member);

    Member login(String email, String password);
}
