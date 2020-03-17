package com.store.service;

import java.util.List;

import com.store.bean.Product;

public interface IProductService {
	public Product saveProduct(Product product);

	public List<Product> getProductList();

	public void updateProduct(Product product);

	public void deleteProduct(Long id);
}
