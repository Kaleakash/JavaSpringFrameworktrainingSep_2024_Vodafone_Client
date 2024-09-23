package com.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Orders;
import com.entity.Product;
import com.repository.OrdersRepository;
import com.repository.ProductRepository;

@Service
public class OrdersService {

	@Autowired
	OrdersRepository ordersRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	public String placeOrder(Orders order ) {		// pid, qty 
		Optional<Product> result = productRepository.findById(order.getPid());
		if(result.isPresent()) {
			Product p = result.get();
			p.setQty(p.getQty()-order.getQty());
			productRepository.saveAndFlush(p);
					// oid = auto increment 
				order.setOrderdatatime(LocalDateTime.now());
			ordersRepository.save(order);
			return "order placed successfully";
		}else {
			return "Order not placed";
		}
	}
	
	public List<Orders> findAllOrders() {
		return ordersRepository.findAll();
	}
	
	public Orders findOrderById(int oid) {
		Optional<Orders> result = ordersRepository.findById(oid);
		if(result.isPresent()) {
			Orders o = result.get();
			return o;
		}else {
			return null;
		}
	}
	
	public List<Orders> findOrdersByProductId(int pid){
		return ordersRepository.findOrderByProcuctId(pid);
	}
	
}
