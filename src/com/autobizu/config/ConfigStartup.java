package com.autobizu.config;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.autobizu.model.Mercadoria;

import com.googlecode.objectify.ObjectifyService;

/**
 * Componente necessário para registrar no Objectify quais são as entidades que ele deve gerenciar.
 * 
 * <p>Código executado durante a inicialização do aplicativo web.</p> 
 * 
 * @author YaW Tecnologia
 */
public class ConfigStartup implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		ObjectifyService.register(Mercadoria.class);
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {}
	
}
