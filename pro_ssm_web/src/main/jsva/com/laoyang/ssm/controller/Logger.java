package com.laoyang.ssm.controller;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Method;
import java.util.Date;

@Component
@Aspect
public class Logger {


    private Date visitTime;     //访问的时间
    private Class<?> visitClazz;   //访问的类
    private Method visitMethod;  //访问的方法
    private long dateTime;      //访问时长

    private String url;

    private User user;  //获取当前登录的用户
    private String username;


    /**
     * 记录所有controller的访问
     *  1、访问的时间
     *  2、访问的类
     *  3、访问的方法
     */
    @Before("execution(* com.laoyang.ssm..*.controller*(..))")
    public void doBefore(JoinPoint jp) throws Exception {
        visitTime = new Date();            //获取访问的时间

        visitClazz = jp.getTarget().getClass();      //获取访问的目标类对象

        String methodName = jp.getSignature().getName(); //获取访问的方法的名称

        Object[] args = jp.getArgs();       //方法的参数数组

        if(args == null || args.length == 0){
            //方法无参数
            visitMethod =visitClazz.getMethod(methodName);  //访问的无参方法
        }else {
            Class[] classArgs = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                classArgs[i] = args[i].getClass();
            }
            visitMethod = visitClazz.getMethod(methodName, classArgs);  //访问的有惨方法
        }
    }


    /**
     *
     * @param jp
     * @throws Exception
     */
    @After("execution(* com.laoyang.ssm..*.controller*(..))")
    public void doAfter(JoinPoint jp) throws Exception {
        dateTime = new Date().getTime() - visitTime.getTime();  //获取访问时长

        String clazzUrl = null;
        String methodUrl = null;
        if(visitClazz !=null && visitMethod !=null && visitClazz != Logger.class){
            //1.获取类上的@RequestMapping("/user")
            RequestMapping classAnnotation = (RequestMapping) visitClazz.getAnnotation(RequestMapping.class);
            if(classAnnotation !=null) {
                 clazzUrl = classAnnotation.value()[0];
            }
            //2.获取方法上的@RequestMapping("/xxx")
            RequestMapping methodAnnotation = visitMethod.getAnnotation(RequestMapping.class);
            if (methodAnnotation != null) {
                methodUrl = methodAnnotation.value()[0];
            }

            url = clazzUrl + methodUrl; //获取url

            //获取当前操作的用户
            SecurityContext context = SecurityContextHolder.getContext();   //从上下文中获了当前登录的用户
            user = (User) context.getAuthentication().getPrincipal();  //获取Security提供的User对象
            username = user.getUsername();       //获取用户名


        }

    }
}