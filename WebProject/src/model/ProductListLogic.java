package model;

import java.util.ArrayList;

import dao.ProductDAO;
import javabeans.Product;

public class ProductListLogic {
	public ArrayList<Product> execute(ArrayList<Product> productList){
		ProductDAO dao =new ProductDAO();
		productList = dao.loadingProduct();
		return productList;
	}
}
