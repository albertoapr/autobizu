package com.autobizu.dao;

import java.io.Serializable;
import java.util.List;

import com.autobizu.model.Mercadoria;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class MercadoriaDAOMySql implements IMercadoriaDAO, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2504593704657977444L;

	/**
	 * Insere uma mercadoria no sistema
	 */
	@Override
	public Long save(Mercadoria mercadoria) {
		Connection c = SupportDAO.getConnection();
		
		if (c == null)
			return (long) 0;
		
		try
		{
			CallableStatement cs = c.prepareCall("{call InsereMercadoria(?, ?, ?, ?)}");
			cs.setString(1, mercadoria.getNome());
			cs.setString(2, mercadoria.getDescricao());
			cs.setDouble(3, mercadoria.getPreco());
			cs.setDouble(4, mercadoria.getQuantidade());
			cs.registerOutParameter(5, Types.INTEGER);
			cs.execute();
			
			long id = cs.getLong(5);
			mercadoria.setId(id);
			
			c.close();
			return  id;

		} catch (SQLException e)
		{
			SupportDAO.log(e.getMessage());
			return (long)0;
		}
	}

	@Override
	public List<Mercadoria> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean remove(Mercadoria mercadoria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mercadoria findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
