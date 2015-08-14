package com.storemgmt.listener;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;



public class MySpecialListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
        // On Application Startup, please…

        // Usually I'll make a singleton in here, set up my pool, etc.
    }


    public void contextDestroyed(ServletContextEvent sce) {
    	try {
    	      com.mysql.jdbc.AbandonedConnectionCleanupThread.shutdown();
    	   } catch (Throwable t) {}
    	   // This manually deregisters JDBC driver, which prevents Tomcat 7 from complaining about memory leaks
    	   Enumeration<java .sql.Driver> drivers = java.sql.DriverManager.getDrivers();
    	   while (drivers.hasMoreElements()) {
    	      java.sql.Driver driver = drivers.nextElement();
    	      try {
    	         java.sql.DriverManager.deregisterDriver(driver);
    	      } catch (Throwable t) {}
    	   }
    	   try { Thread.sleep(2000L); } catch (Exception e) {}


    }


}