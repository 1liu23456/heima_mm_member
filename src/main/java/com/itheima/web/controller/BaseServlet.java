package com.itheima.web.controller;

import com.alibaba.fastjson.JSON;
import com.itheima.domain.front.Member;
import com.itheima.service.front.MemberService;
import com.itheima.service.front.impl.MemberServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author: 刘旭阳
 * @Date: 2021/9/25 9:56
 * @Package: ${PACKAGE_NAME}
 * @ClassName: ${NAME}
 * @Description: TODO
 * @Version: 2021/9/25
 */
public class BaseServlet extends HttpServlet {

    protected   MemberService memberService;

    @Override
    public void init() throws ServletException {
        memberService = new MemberServiceImpl();
    }

    protected <T> T getData(HttpServletRequest request, Class<T> clazz) throws IOException {
        String json = JSON.parseObject(request.getInputStream(), String.class);
        return JSON.parseObject(json, clazz);
    }

    protected void returnData(HttpServletResponse response, Result result) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        JSON.writeJSONString(response.getOutputStream(), result);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        int lastIndex = uri.lastIndexOf('/');
        String methodName = uri.substring(lastIndex+1);
        try {
            Class clazz = this.getClass();
            Method method = clazz.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            Result result = (Result) method.invoke(this, request, response);
            returnData(response,result);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
