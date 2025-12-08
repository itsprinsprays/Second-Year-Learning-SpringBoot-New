package SpringbootJDBC1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import SpringbootJDBC1.model.Customer;
import SpringbootJDBC1.service.CustomerService;

@RestController
@RequestMapping("/customer")
@CrossOrigin (origins = "*")

public class CustomerController {
	
	public final CustomerService serv;
	
	@Autowired
	public CustomerController(CustomerService serv) {
		this.serv = serv;
	}
	
	@PostMapping
	public String createCustomer(@RequestBody Customer customer) {
		return serv.addCustomer(customer);
	}
	
	@GetMapping
	public List<Customer> getAllCustomer() {
		return serv.getAll();
	}
	
	@GetMapping("/{id}")
	public Customer getCustomerByID(@PathVariable int id) {
		return serv.getCustomerByID(id);
	}
	
	@PutMapping("/{id}")
	public String updateCustomer(@PathVariable int id, @RequestBody Customer customer) {
		customer.setOrderNumber(id);
		serv.updateCustomer(customer);
		return id + "Updated Succesfully";
	}
	
	@DeleteMapping("/{id}")
	public String deleteCustomerByID(@PathVariable int id) {
		serv.deleteCustomerByID(id);
		return id + " deleted";
	}

}
