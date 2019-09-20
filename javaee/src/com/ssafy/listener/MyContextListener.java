package com.ssafy.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyContextListener implements ServletContextListener {
	
    public void contextDestroyed(ServletContextEvent arg0)  {
    	System.out.println("context destroyed...");
    }

    public void contextInitialized(ServletContextEvent arg0)  { 
    	System.out.println("context created...");
    }
	
}
