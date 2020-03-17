package com.store.service;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.store.bean.Product;
import com.store.repository.ProductRepository;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public List<Product> getProductList() {
		return productRepository.findAll();
	}

	@Override
	public void updateProduct(Product product) {
		Product responseProduct = productRepository.findById(product.getId()).get();
//		Hibernate.initialize(responseProduct.getStore());
		responseProduct.setCompany(product.getCompany());
		responseProduct.setExpDate(product.getExpDate());
		responseProduct.setMfgDate(product.getMfgDate());
		responseProduct.setPrice(product.getPrice());
		responseProduct.setQuantity(product.getQuantity());
		responseProduct.setUnitType(product.getUnitType());
		responseProduct.setWeight(product.getWeight());
		responseProduct.setWeightType(product.getWeightType());
//		responseProduct.setStore(responseProduct.getStore());
		productRepository.save(responseProduct);
	}

	@Override
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}

}
