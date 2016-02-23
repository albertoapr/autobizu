package com.autobizu.dao;

/**
 * Classe que concentra o acesso aos DAOs do sistema
 */
public class DAOFactory
{
	private static IMercadoriaDAO mercadoriaDAO;

	/**
	 * Retorna a instância do DAO para persistência de CDs
	 */
	public static IMercadoriaDAO getMercadoriaDAO()
	{
		if (mercadoriaDAO == null)
			mercadoriaDAO = new MercadoriaDAOMySql();
		
		return mercadoriaDAO;
	}

	/**
	 * Altera a instância do DAO para persistência de CDs - método para ser usado em testes
	 */
	public static void setMercadoriaDAO(IMercadoriaDAO mercadoriaDAO)
	{
		DAOFactory.mercadoriaDAO = mercadoriaDAO;
	}
}