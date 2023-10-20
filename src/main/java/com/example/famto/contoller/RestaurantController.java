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
import com.example.famto.entity.RestaurantData;
import com.example.famto.exception.ResourceNotFoundException;
import com.example.famto.repository.ProductsRepo;
import com.example.famto.repository.RestaurantRepo;


@RestController
@RequestMapping("/api/restaurants")


public class RestaurantController {
	
	@Autowired
	private RestaurantRepo restaurantRepo;

	// get all restaurants
	@GetMapping
	public List<RestaurantData> getAllRestaurants() {
		return this.restaurantRepo.findAll();
		
	}

	// get restaurants by id
	@GetMapping("/{restaurantId}")
	public RestaurantData getRestaurantById(@PathVariable (value = "restaurantId") int restaurantId) {
		return this.restaurantRepo.findById(restaurantId).
				orElseThrow(() -> new ResourceNotFoundException("User not found with restaurantId"));
	}

	// create restaurant
	@PostMapping
	
	public RestaurantData createRestaurant(@RequestBody RestaurantData restaurantData) {
		return this.restaurantRepo.save(restaurantData);
	
	}
	
	// update restaurant data
	@PutMapping("/{restaurantId}")
	public RestaurantData updateRestaurant(@RequestBody ProductsData restaurantData, @PathVariable ("restaurantId") int restaurantId) {
		RestaurantData existingRestaurant = this.restaurantRepo.findById(restaurantId)
			.orElseThrow(() -> new ResourceNotFoundException("User not found with restaurantId"));
		
//		if(customerData.getName() != null) {
//			existingCustomer.setName(customerData.getName());
//		}
		 return this.restaurantRepo.save(existingRestaurant);
	}
	
	@DeleteMapping("/{restaurantId}")
	public ResponseEntity<RestaurantData> deleteRestaurant(@PathVariable ("restaurantId") int restaurantId){
		RestaurantData existingRestaurant = this.restaurantRepo.findById(restaurantId)
					.orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + restaurantId));
		 this.restaurantRepo.delete(existingRestaurant);
		 return ResponseEntity.ok().build();
	} 

}
