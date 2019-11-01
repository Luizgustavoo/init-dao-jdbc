package model.dao;

import db.DB;
import model.dao.impl.SellerDaoJDBC;

public class DaoFactory {
	//Retorna um tipo da interface porém internamente instancia uma implementação.
	public static SellerDao creatSellerDao() {
		return new SellerDaoJDBC(DB.getConnection());
	}

}
