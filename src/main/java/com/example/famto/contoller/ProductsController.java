package com.example.famto.contoller;

import java.lang.module.ResolutionException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.famto.entity.ProductsData;
import com.example.famto.exception.ResourceNotFoundException;
import com.example.famto.repository.ProductsRepo;


@RestController
@RequestMapping("/api/products")


public class ProductsController {
	
	@Autowired
	private ProductsRepo productsRepo;

	// get all products
	@GetMapping
	public List<ProductsData> getAllProducts() {
		return this.productsRepo.findAll();
		
	}

	// get products by id
	@GetMapping("/{productId}")
	public ProductsData getProductById(@PathVariable (value = "productId") int productId) {
		return this.productsRepo.findById(productId).
				orElseThrow(() -> new ResourceNotFoundException("User not found with productId"));
	}

	// create login
	@PostMapping
	
	public ProductsData createProduct(@RequestBody ProductsData productsData) {
		return this.productsRepo.save(productsData);
	
	}
	
	// update customer data
	@PutMapping("/{productId}")
	public ProductsData updateLogin(@RequestBody ProductsData productsData, @PathVariable ("productId") int productId) {
		ProductsData existingProduct = this.productsRepo.findById(productId)
			.orElseThrow(() -> new ResourceNotFoundException("User not found with productId"));
		
//		if(customerData.getName() != null) {
//			existingCustomer.setName(customerData.getName());
//		}
		 return this.productsRepo.save(existingProduct);
	}
	
	@DeleteMapping("/{productId}")
	public ResponseEntity<ProductsData> deleteProduct(@PathVariable ("productId") int productId){
		ProductsData existingProduct = this.productsRepo.findById(productId)
					.orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + productId));
		 this.productsRepo.delete(existingProduct);
		 return ResponseEntity.ok().build();
	} 

}
