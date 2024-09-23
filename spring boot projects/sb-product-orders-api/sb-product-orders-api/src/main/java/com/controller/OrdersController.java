package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Orders;
import com.service.OrdersService;

@RestController
@RequestMapping("orders") // http://localhost:9191/orders
public class OrdersController {

	@Autowired
	OrdersService ordersService;
// curl -X POST http://localhost:9191/orders/place -H "Content-Type:application/json" -d '{"pid":111,"qty":2}'
	
	@PostMapping(value = "place",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String placeOrders(@RequestBody Orders order) {
		return ordersService.placeOrder(order);
	}
	
	// curl -X GET http://localhost:9191/orders/find
	@GetMapping(value = "find",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Orders> findAllOrders() {
		return ordersService.findAllOrders();
	}
	// curl -X GET http://localhost:9191/orders/findbyid/1 path param 
	@GetMapping(value = "findbyid/{oid}",produces = MediaType.APPLICATION_JSON_VALUE)
	public Orders findAllOrderById(@PathVariable("oid") int oid) {
		return ordersService.findOrderById(oid);
	}
	
	// curl -X GET http://localhost:9191/orders/findorderbypid?pid=100 query param
	
	@GetMapping(value = "findorderbypid",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Orders> findOrderDetailsByPId(@RequestParam("pid") int pid) {
		return ordersService.findOrdersByProductId(pid);
	}
}
