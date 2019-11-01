package application;

import java.util.Date;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.creatSellerDao(); // Forma de fazer uma injeção de dependencia sem explicitar a
															// implementação.
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);

	}

}
