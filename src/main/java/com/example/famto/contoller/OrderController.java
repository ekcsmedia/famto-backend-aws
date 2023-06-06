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

import com.example.famto.entity.Order;
import com.example.famto.exception.ResourceNotFoundException;
import com.example.famto.repository.LoginRepository;
import com.example.famto.repository.OrderRepository;

@RestController
@RequestMapping("/api/orders")

public class OrderController {
	
	@Autowired
	private OrderRepository orderRepository;

	// get all orders
	@GetMapping
	public List<Order> getAllOrders() {
		return this.orderRepository.findAll();
	}

	// get order by id
	@GetMapping("/{newId}")
	public Order getOrderById(@PathVariable (value = "newId") Integer newId) {
		return this.orderRepository.findById(newId).orElseThrow(() -> new ResourceNotFoundException("Order not found with newId :" + newId));
	}

	// create order
	@PostMapping
	public Order createOrder(@RequestBody Order order) {
		return this.orderRepository.save(order);
	}
	
	// update order status
	@PutMapping("/{newId}")
	public Order updateOrder(@RequestBody Order order, @PathVariable ("newId") Integer orderId) {
		
		 Order existingOrder = this.orderRepository.findById(orderId)
			.orElseThrow(() -> new ResourceNotFoundException("Order not found with newId :" + orderId));
		 if (order.getStatus() != null) {
			 existingOrder.setStatus(order.getStatus());

		 }
		 if(order.getDeliveryPerson() != null) {
			 existingOrder.setDeliveryPerson(order.getDeliveryPerson());

		 }

		 if(order.getDeliveryPersonNumber() != null) {
			 existingOrder.setDeliveryPersonNumber(order.getDeliveryPersonNumber());

		 }
		 return this.orderRepository.save(existingOrder);
	}
	
	// delete order by id
	@DeleteMapping("/{id}")
	public ResponseEntity<Order> deleteLogin(@PathVariable ("id") int id){
		Order existingOrder = this.orderRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + id));
		 this.orderRepository.delete(existingOrder);
		 return ResponseEntity.ok().build();
	} 

}
