package model;

import java.util.ArrayList;

import dao.ProductDAO;
import javabeans.Product;

public class ProductListLogic {
	public ArrayList<Product> dao(ArrayList<Product> ar){
		ProductDAO dao =new ProductDAO();
		dao.loadingProduct();
		return null;
	}
}
