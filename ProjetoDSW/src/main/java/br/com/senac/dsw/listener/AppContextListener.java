/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dsw.listener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 *
 * @author vinicius
 */
  @WebListener
public class AppContextListener implements ServletContextListener {

  @Override
  public void contextInitialized(ServletContextEvent sce) {

  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {

  }
  
