package product.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import product.model.Product;

public class TestORM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Configuration configuration = new Configuration();
		 configuration.configure("hibernate.cfg.xml");
		 
		 SessionFactory factory = configuration.buildSessionFactory();
		 Session session = factory.openSession();
		 Transaction transaction = session.beginTransaction();
		 
		 Product product = new Product(0,"pen",10.5f);
		 session.save(product);
		 transaction.commit();
		 System.out.println("Product is saved");
	}

}
