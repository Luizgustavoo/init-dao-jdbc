package model.dao;

import model.dao.impl.SellerDaoJDBC;

public class DaoFactory {
	//Retorna um tipo da interface por�m internamente instancia uma implementa��o.
	public static SellerDao creatSellerDao() {
		return new SellerDaoJDBC();
	}

}
