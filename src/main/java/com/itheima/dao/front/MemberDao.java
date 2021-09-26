package com.itheima.dao.front;

import com.itheima.domain.front.Member;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: 刘旭阳
 * @Date: 2021/9/25 10:12
 * @Package: com.itheima.dao.front
 * @ClassName: MemberDao
 * @Description: TODO
 * @Version: 2021/9/25
 */
public interface MemberDao {
    int save(Member member);

    Member findByEmailAndPwd(@Param("email") String email, @Param("password") String password);
}
