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
import com.example.famto.entity.CustomerData;
import com.example.famto.exception.ResourceNotFoundException;
import com.example.famto.repository.CustomerRepo;


@RestController
@RequestMapping("/api/customers")


public class CustomerController {
	
	@Autowired
	private CustomerRepo customerRepo;

	// get all customer
	@GetMapping
	public List<CustomerData> getAllCustomers() {
		return this.customerRepo.findAll();
		
	}

	// get customer by id
	@GetMapping("/{customerId}")
	public CustomerData getCustomerById(@PathVariable (value = "customerId") int customerId) {
		return this.customerRepo.findById(customerId).
				orElseThrow(() -> new ResourceNotFoundException("User not found with customerId"));
	}

	// create login
	@PostMapping
	
	public CustomerData createCustomer(@RequestBody CustomerData customerData) {
		return this.customerRepo.save(customerData);
	
	}
	
	// update customer data
	@PutMapping("/{customerId}")
	public CustomerData updateLogin(@RequestBody CustomerData customerData, @PathVariable ("customerId") int customerId) {
		CustomerData existingCustomer = this.customerRepo.findById(customerId)
			.orElseThrow(() -> new ResourceNotFoundException("User not found with customerId"));
		
		if(customerData.getName() != null) {
			existingCustomer.setName(customerData.getName());
		}
		if(customerData.getEmail() != null) {
			existingCustomer.setEmail(customerData.getEmail());
		}
		if(customerData.getPhone() != null) {
			existingCustomer.setPhone(customerData.getPhone());
		}
		if(customerData.getLastUsedPlatform() != null) {
			existingCustomer.setLastUsedPlatform(customerData.getLastUsedPlatform());
		}
		if(customerData.getRegisterAt() != null) {
			existingCustomer.setRegisterAt(customerData.getRegisterAt());
		}
		if(customerData.getWalletBalance() != null) {
			existingCustomer.setWalletBalance(customerData.getWalletBalance());
		}
		if(customerData.getRateAndReview() != null) {
			existingCustomer.setRateAndReview(customerData.getRateAndReview());
		}
		if(customerData.getCodStatus() != null) {
			existingCustomer.setCodStatus(customerData.getCodStatus());
		}
		if(customerData.getPayLaterStatus() != null) {
			existingCustomer.setPayLaterStatus(customerData.getPayLaterStatus());
		}
		if(customerData.getReferralCode() != null) {
			existingCustomer.setReferralCode(customerData.getReferralCode());
		}
		if(customerData.getVersions() != null) {
			existingCustomer.setVersions(customerData.getVersions());
		}
		if(customerData.getTags() != null) {
			existingCustomer.setTags(customerData.getTags());
		}
		

		 return this.customerRepo.save(existingCustomer);
	}
	
	@DeleteMapping("/{customerId}")
	public ResponseEntity<CustomerData> deleteCustomer(@PathVariable ("customerId") int customerId){
		CustomerData existingCustomer = this.customerRepo.findById(customerId)
					.orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + customerId));
		 this.customerRepo.delete(existingCustomer);
		 return ResponseEntity.ok().build();
	} 

}
