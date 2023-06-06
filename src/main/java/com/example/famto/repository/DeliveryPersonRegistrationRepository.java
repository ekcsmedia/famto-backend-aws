package com.example.famto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.famto.entity.DeliveryPersonRegistration;;

@Repository

public interface DeliveryPersonRegistrationRepository extends JpaRepository<DeliveryPersonRegistration, Long> {
	
	public final static String GET_DELIVERY_PERSON_DATA = "SELECT d FROM DeliveryPersonRegistration d WHERE phoneNumber = :phoneNumber";


	@Query(GET_DELIVERY_PERSON_DATA)
	List<DeliveryPersonRegistration> getDeliveryPersonDetails(
			@Param("phoneNumber") String phoneNumber);
	
}