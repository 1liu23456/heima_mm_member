package com.itheima.web.controller.front;

import com.alibaba.fastjson.JSON;
import com.itheima.domain.front.Member;
import com.itheima.web.controller.BaseServlet;
import com.itheima.web.controller.Code;
import com.itheima.web.controller.Result;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: 刘旭阳
 * @Date: 2021/9/25 9:55
 * @Package: com.itheima.web.controller.front
 * @ClassName: MemberServlet
 * @Description: TODO
 * @Version: 2021/9/25
 */
@WebServlet("/member/*")
public class MemberServlet extends BaseServlet {

    public Result register(HttpServletRequest request, HttpServletResponse response) throws IOException {
         Member member = getData(request, Member.class);
        boolean flag = memberService.register(member);
        return new Result("注册成功！", null);
    }

    public Result login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Member member = getData(request, Member.class);
         member = memberService.login(member.getEmail(),member.getPassword());
         if (member!=null) {
             return new Result("登录成功！", member);
         } else {
             return new Result("登录失败！用户名或密码错误！", null,false, Code.LOGIN_FAIL);
         }
    }





}

   /* protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //把前台提交的表单数据转化为字符串
        String json = JSON.parseObject(request.getInputStream(), String.class);
        //把字符串数据转化为指定的实体类
        Member member = JSON.parseObject(json, Member.class);
        boolean flag = memberService.register(member);
        Result result = new Result("注册成功！", null);
        response.setContentType("application/json;charset=utf-8");
        //把封装好的result响应输出流输出数据
        JSON.writeJSONString(response.getOutputStream(), result);
    }*/
