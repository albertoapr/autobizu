package com.autobizu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.google.appengine.api.utils.SystemProperty;

/**
 * Classe de suporte à persistência de informações
 * 
 * @author albert.prodrigues
 */
public class SupportDAO {
	/**
	 * Cria uma conexão com o banco de dados
	 */
	public static Connection getConnection()
	{	String url = null;
		try
		{
			
			if (SystemProperty.environment.value() ==  SystemProperty.Environment.Value.Production) {
			        // Load the class that provides the new "jdbc:google:mysql://" prefix.
			        Class.forName("com.mysql.jdbc.GoogleDriver").newInstance();
			        url = "jdbc:google:mysql://173.255.114.228:3306/autobizu";
			      } else {
			        // Local MySQL instance to use during development.
			        Class.forName("com.mysql.jdbc.Driver").newInstance();
			        url = "jdbc:mysql://127.0.0.1:3306/autobizu";
			      }
			
			
			
			
			//Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conexao = DriverManager.getConnection(url, "root", "whiskey2004");
			conexao.setCatalog("autobizu");
			return conexao;
			
		} catch (SQLException e)
		{
			System.out.println("Não foi possível estabelecer uma conexão com o banco de dados - erro de SQL");
			System.out.println(e.getMessage());
			return null;
		} catch (ClassNotFoundException e)
		{
			System.out.println("Não foi possível estabelecer uma conexão com o banco de dados - driver não encontrado");
			return null;
		} catch (InstantiationException e)
		{
			System.out.println("Não foi possível estabelecer uma conexão com o banco de dados - erro de instanciação do driver");
			return null;
		} catch (IllegalAccessException e)
		{
			System.out.println("Não foi possível estabelecer uma conexão com o banco de dados - acesso ilegal no driver");
			return null;
		}
	}

	/**
	 * Apresenta uma mensagem no log do sistema
	 */
	public static void log(String mensagem) {
		System.out.println(mensagem);
	}
}