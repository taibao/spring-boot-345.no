package com.vitas.servlet;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;

@WebServlet(name="FirstServlet",urlPatterns = "/first")

public class FirstServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response){
//        long start = System.currentTimeMillis();
//
//        long sum = 0;
//        //求10亿数累加
//        for(int i=0;i<1000000000;i++){
//            sum+=i;
//        }
//        long end = System.currentTimeMillis();

        System.out.println("执行 first Servlet .....");
//        System.out.println("一共耗时 ....."+ (end-start));
    }

}
