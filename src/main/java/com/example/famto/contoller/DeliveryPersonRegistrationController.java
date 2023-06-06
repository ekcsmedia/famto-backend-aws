package com.example.famto.contoller;

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

import com.example.famto.entity.DeliveryPersonRegistration;
import com.example.famto.exception.ResourceNotFoundException;
import com.example.famto.repository.DeliveryPersonRegistrationRepository;

@RestController
@RequestMapping("/api/delivery-person-registration")

public class DeliveryPersonRegistrationController {
	
	@Autowired
	private DeliveryPersonRegistrationRepository deliveryPersonRegistrationRepository;

	// get all logins
	@GetMapping
	public List<DeliveryPersonRegistration> getAllDeliveryLogins() {
		return this.deliveryPersonRegistrationRepository.findAll();
		
	}

	// get login by id
	@GetMapping("/{deliveryUserId}")
	public DeliveryPersonRegistration getDeliveryPersonRegById(@PathVariable (value = "deliveryUserId") long deliveryUserId) {
		return this.deliveryPersonRegistrationRepository.findById(deliveryUserId).orElseThrow(() -> new ResourceNotFoundException("Delivery User not found with deliveryUserId :" + deliveryUserId));
	}
	
	// get delivery person details by phone number
	@GetMapping("/phoneNumber/{phoneNumber}")
	public DeliveryPersonRegistration getDeliveryPersonRegByPhone(@PathVariable (value = "phoneNumber") String phoneNumber) {
				return this.deliveryPersonRegistrationRepository.getDeliveryPersonDetails(phoneNumber).get(0);
	}

	// create login
	@PostMapping
	public DeliveryPersonRegistration createDeliveryPersonReg(@RequestBody DeliveryPersonRegistration deliveryPersonReg) {	
		return this.deliveryPersonRegistrationRepository.save(deliveryPersonReg);
		}
	
	// update login
	@PutMapping("/{deliveryUserId}")
	public DeliveryPersonRegistration updateDeliveryLogin(@RequestBody DeliveryPersonRegistration deliveryLogin, @PathVariable ("deliveryUserId") long deliveryUserId) {
		DeliveryPersonRegistration existingRegistrationDetails = this.deliveryPersonRegistrationRepository.findById(deliveryUserId)
			.orElseThrow(() -> new ResourceNotFoundException("Delivery User not found with deliveryUserId :" + deliveryUserId));
		if (deliveryLogin.getPhoneNumber() != null) {
			existingRegistrationDetails.setPhoneNumber(deliveryLogin.getPhoneNumber());
		}
		if (deliveryLogin.getName() != null) {
			existingRegistrationDetails.setName(deliveryLogin.getName());
		}
		if (deliveryLogin.getAddress() != null) {
			existingRegistrationDetails.setAddress(deliveryLogin.getAddress());
		}
		
		if (deliveryLogin.getAadhaar() != null) {
			existingRegistrationDetails.setAadhaar(deliveryLogin.getAadhaar());
		}
		if (deliveryLogin.getPan() != null) {
			existingRegistrationDetails.setPan(deliveryLogin.getPan());
		}
		if (deliveryLogin.getDrivingLicense() != null) {
			existingRegistrationDetails.setDrivingLicense(deliveryLogin.getAddress());
		}
		if (deliveryLogin.getEmergencyContact() != null) {
			existingRegistrationDetails.setEmergencyContact(deliveryLogin.getEmergencyContact());
		}
		if (deliveryLogin.getVehicleRegistration() != null) {
			existingRegistrationDetails.setVehicleRegistration(deliveryLogin.getVehicleRegistration());
		}
		if (deliveryLogin.getPhoto() != null) {
			existingRegistrationDetails.setPhoto(deliveryLogin.getPhoto());
		}
		if (deliveryLogin.getStatus() != null) {
			existingRegistrationDetails.setStatus(deliveryLogin.getStatus());
		}
		if (deliveryLogin.getAvailability() != null) {
			existingRegistrationDetails.setAvailability(deliveryLogin.getAvailability()); 
			}
		
		 return this.deliveryPersonRegistrationRepository.save(existingRegistrationDetails);
	}
	
	// delete login by id
	@DeleteMapping("/{deliveryUserId}")
	public ResponseEntity<DeliveryPersonRegistration> deleteDeliveryLogin(@PathVariable ("deliveryUserId") long deliveryUserId){
		DeliveryPersonRegistration existingRegistration = this.deliveryPersonRegistrationRepository.findById(deliveryUserId)
					.orElseThrow(() -> new ResourceNotFoundException("Delivery User not found with deliveryUserId :" + deliveryUserId));
		 this.deliveryPersonRegistrationRepository.delete(existingRegistration);
		 return ResponseEntity.ok().build();
	}

}
