package com.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.store.bean.Product;
import com.store.service.IProductService;

@RestController
@RequestMapping("product")
public class ProductController {

	@Autowired
	private IProductService productService;

	@PostMapping("/saveProduct")
	public ResponseEntity<?> saveProduct(@RequestBody Product product) {
		ResponseEntity<?> response = null;
		try {
			Product savedProduct = productService.saveProduct(product);
			if (savedProduct == null) {
				response = ResponseEntity.accepted().body("Could not save the product details.");
			} else {
				response = ResponseEntity.ok(savedProduct);
			}
		} catch (Exception ex) {
			response = ResponseEntity.badRequest().body("Exception occurred, try again");
		}
		return response;
	}

	@GetMapping("/getProductList")
	public ResponseEntity<?> getProductList() {
		ResponseEntity<?> response = null;
		try {
			List<Product> productList = productService.getProductList();
			if (productList.isEmpty()) {
				response = ResponseEntity.accepted().body("There are no product's available.");
			} else {
				response = ResponseEntity.ok(productList);
			}
		} catch (Exception ex) {
			response = ResponseEntity.badRequest().body("Exception occurred, try again");
		}
		return response;
	}

	@DeleteMapping("/deleteProduct")
	public ResponseEntity<?> deleteProduct(@RequestParam(required = true) Long id) {
		ResponseEntity<?> response = null;
		try {
			productService.deleteProduct(id);
			List<Product> productList = productService.getProductList();
			if (productList.isEmpty()) {
				response = ResponseEntity.accepted().body("There are no product's available.");
			} else {
				response = ResponseEntity.ok(productList);
			}
		} catch (Exception ex) {
			response = ResponseEntity.badRequest().body("Exception occurred, try again");
		}
		return response;
	}

	@PutMapping("/updateProduct")
	public ResponseEntity<?> updateProduct(@RequestBody Product product) {
		ResponseEntity<?> response = null;
		try {
			productService.updateProduct(product);
			List<Product> productList = productService.getProductList();
			if (productList.isEmpty()) {
				response = ResponseEntity.accepted().body("There are no product's available.");
			} else {
				response = ResponseEntity.ok(productList);
			}
		} catch (Exception ex) {
			response = ResponseEntity.badRequest().body("Exception occurred, try again");
			ex.printStackTrace();
		}
		return response;
	}
}
