package com.itheima.service.front.impl;

import com.itheima.dao.front.MemberDao;
import com.itheima.domain.front.Member;
import com.itheima.factory.MapperFactory;
import com.itheima.service.front.MemberService;
import com.itheima.utils.MD5Util;
import com.itheima.utils.TransactionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.Date;
import java.util.UUID;

/**
 * @Author: 刘旭阳
 * @Date: 2021/9/25 10:17
 * @Package: com.itheima.service.front.impl
 * @ClassName: MemberServiceImpl
 * @Description: TODO
 * @Version: 2021/9/25
 */
public class MemberServiceImpl implements MemberService {
    @Override
    public boolean register(Member member) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MapperFactory.getSqlSession();
            MemberDao mapper = MapperFactory.getMapper(sqlSession, MemberDao.class);
            //生成UUID作为id值
            String id = UUID.randomUUID().toString().replace("-", "");
            member.setId(id);
            member.setRegisterDate(new Date());
            member.setState("1");

            member.setPassword(MD5Util.md5(member.getPassword()));


            int row = mapper.save(member);
            TransactionUtil.commit(sqlSession);
            return row>0;
        } catch (Exception e) {
            TransactionUtil.rollback(sqlSession);
            throw new RuntimeException(e);
            //TODO 记录日志
        } finally {
            try {
                TransactionUtil.close(sqlSession);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Member login(String email, String password) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MapperFactory.getSqlSession();
            MemberDao mapper = MapperFactory.getMapper(sqlSession, MemberDao.class);
            password = MD5Util.md5(password);
            return mapper.findByEmailAndPwd(email,password);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
            //TODO 记录日志
        } finally {
            try {
                TransactionUtil.close(sqlSession);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
