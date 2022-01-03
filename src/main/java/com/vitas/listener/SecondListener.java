package com.vitas.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 整合listener
 */
public class SecondListener implements ServletContextListener {
    public void contextDestroyed(ServletContextEvent event){
    }

    public void contextInitialized(ServletContextEvent event){
        System.out.println("Second.... Listener ... Init .....");
    }
}
