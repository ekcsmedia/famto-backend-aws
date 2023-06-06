package com.example.famto.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.geo.Point;


@Entity
@Table(name = "delivey_person_registration")

public class DeliveryPersonRegistration {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long deliveryUserId;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "address")
	private String address;
	
	////
	@Column(name = "pan")
	private String pan;
	
	@Column(name = "photo")
	private String photo;
	
	@Column(name = "aadhaar")
	private String aadhaar;
	
	@Column(name = "driving_license")
	private String drivingLicense;
	
	@Column(name = "availability")
	private Boolean availability;
	
	@Column(columnDefinition = "geometry")
	 private Point geometry;
	
	public Point getGeometry() {
		return geometry;
	}

	public void setGeometry(Point geometry) {
		this.geometry = geometry;
	}

	public String getStatus() {
		return status;
	}

	public Boolean getAvailability() {
		return availability;
	}

	public void setAvailability(Boolean availability) {
		this.availability = availability;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public DeliveryPersonRegistration(String phoneNumber, String name, String address,
			String pan, String photo, String aadhaar, String drivingLicense, String status, String vehicleRegistration,
			String emergencyContact, boolean availability) {
		super();
//		this.deliveryUserId = deliveryUserId;
		this.phoneNumber = phoneNumber;
		this.name = name;
		this.address = address;
		this.pan = pan;
		this.photo = photo;
		this.aadhaar = aadhaar;
		this.drivingLicense = drivingLicense;
		this.status = status;
		this.vehicleRegistration = vehicleRegistration;
		this.emergencyContact = emergencyContact;
		this.availability = availability;
	}

	
	@Column(name = "status")
	private String status;
	
	public long getDeliveryUserId() {
		return deliveryUserId;
	}

	public void setDeliveryUserId(long deliveryUserId) {
		this.deliveryUserId = deliveryUserId;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getAadhaar() {
		return aadhaar;
	}

	public void setAadhaar(String aadhaar) {
		this.aadhaar = aadhaar;
	}

	public String getDrivingLicense() {
		return drivingLicense;
	}

	public void setDrivingLicense(String drivingLicense) {
		this.drivingLicense = drivingLicense;
	}

	public String getVehicleRegistration() {
		return vehicleRegistration;
	}

	public void setVehicleRegistration(String vehicleRegistration) {
		this.vehicleRegistration = vehicleRegistration;
	}

	public String getEmergencyContact() {
		return emergencyContact;
	}

	public void setEmergencyContact(String emergencyContact) {
		this.emergencyContact = emergencyContact;
	}

	@Column(name = "vehicle_registration")
	private String vehicleRegistration;
	
	@Column(name = "emergency_contact")
	private String emergencyContact;
	
public DeliveryPersonRegistration() {
		
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}
