package controller;

import java.util.*;
import entities.*;

public class ProductWS {
	
	public Product find(){
		return new Product("p1", "Name 1", 1000);
	}
	
	public List<Product> findAll(){
		List<Product> listProducts = new ArrayList<Product>();
		
		listProducts.add(new Product("p1", "Name 1", 1000));
		listProducts.add(new Product("p2", "Name 2", 2000));
		listProducts.add(new Product("p3", "Name 3", 3000));
		
		return listProducts;
	}
}
