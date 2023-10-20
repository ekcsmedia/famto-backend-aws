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

	// get all registered delivery person data
	@GetMapping
	public List<DeliveryPersonRegistration> getAllDeliveryLogins() {
		return this.deliveryPersonRegistrationRepository.findAll();
		
	}

	// get delivery person by id
	@GetMapping("/{deliveryUserId}")
	public DeliveryPersonRegistration getDeliveryPersonRegById(@PathVariable (value = "deliveryUserId") long deliveryUserId) {
		return this.deliveryPersonRegistrationRepository.findById(deliveryUserId).orElseThrow(() -> new ResourceNotFoundException("Delivery User not found with deliveryUserId :" + deliveryUserId));
	}
	
	// get delivery person details by phone number
	@GetMapping("/phoneNumber/{phoneNumber}")
	public DeliveryPersonRegistration getDeliveryPersonRegByPhone(@PathVariable (value = "phoneNumber") String phoneNumber) {
				return this.deliveryPersonRegistrationRepository.getDeliveryPersonDetails(phoneNumber).get(0);
	}

	// create delivery person through registration
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
		if (deliveryLogin.getColor() != null) {
			existingRegistrationDetails.setColor(deliveryLogin.getColor()); 
			}		
	
		if (deliveryLogin.getEmail() != null) {
					existingRegistrationDetails.setEmail(deliveryLogin.getEmail()); 
				}		
		if (deliveryLogin.getFirstName() != null) {
					existingRegistrationDetails.setFirstName(deliveryLogin.getFirstName()); 
				}		
		if (deliveryLogin.getGeofence() != null) {
					existingRegistrationDetails.setGeofence(deliveryLogin.getGeofence()); 
				}
		if (deliveryLogin.getGeometry() != null) {
			existingRegistrationDetails.setGeometry(deliveryLogin.getGeometry()); 
		}
		if (deliveryLogin.getLastName() != null) {
			existingRegistrationDetails.setLastName(deliveryLogin.getLastName()); 
		}
		if (deliveryLogin.getLicensePlate() != null) {
			existingRegistrationDetails.setLicensePlate(deliveryLogin.getLicensePlate()); 
		}
		if (deliveryLogin.getPassword() != null) {
			existingRegistrationDetails.setPassword(deliveryLogin.getPassword()); 
		}
		if (deliveryLogin.getRole() != null) {
			existingRegistrationDetails.setRole(deliveryLogin.getRole()); 
		}
		if (deliveryLogin.getTeam() != null) {
			existingRegistrationDetails.setTeam(deliveryLogin.getTeam()); 
		}
		if (deliveryLogin.getTransportDescription() != null) {
			existingRegistrationDetails.setTransportDescription(deliveryLogin.getTransportDescription()); 
		}
		if (deliveryLogin.getTransportType() != null) {
			existingRegistrationDetails.setTransportType(deliveryLogin.getTransportType()); 
		}		
		if (deliveryLogin.getType() != null) {
			existingRegistrationDetails.setType(deliveryLogin.getType()); 
		}
		if (deliveryLogin.getUserName() != null) {
			existingRegistrationDetails.setUserName(deliveryLogin.getUserName()); 
		}
		if (deliveryLogin.getLatitude() != null) {
			existingRegistrationDetails.setLatitude(deliveryLogin.getLatitude()); 
		}
		if (deliveryLogin.getLongitude() != null) {
			existingRegistrationDetails.setLongitude(deliveryLogin.getLongitude()); 
		}
//		if (deliveryLogin.getTags() != null) {
//			existingRegistrationDetails.setTags(deliveryLogin.getTags()); 
//		}
			
		 return this.deliveryPersonRegistrationRepository.save(existingRegistrationDetails);
	}
	
	// delete delivery person by id
	@DeleteMapping("/{deliveryUserId}")
	public ResponseEntity<DeliveryPersonRegistration> deleteDeliveryLogin(@PathVariable ("deliveryUserId") long deliveryUserId){
		DeliveryPersonRegistration existingRegistration = this.deliveryPersonRegistrationRepository.findById(deliveryUserId)
					.orElseThrow(() -> new ResourceNotFoundException("Delivery User not found with deliveryUserId :" + deliveryUserId));
		 this.deliveryPersonRegistrationRepository.delete(existingRegistration);
		 return ResponseEntity.ok().build();
	}

}
