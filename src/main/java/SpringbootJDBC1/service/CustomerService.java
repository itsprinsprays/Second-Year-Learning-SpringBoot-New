package SpringbootJDBC1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SpringbootJDBC1.model.Customer;
import SpringbootJDBC1.repository.CustomerRepository;

@Service
public class CustomerService {
	
	private CustomerRepository repo;
	
	@Autowired
	public CustomerService(CustomerRepository repo) {
		this.repo = repo;
	}
	
	public String addCustomer(Customer customer) {
		 repo.addCustomer(customer);
		 return "Succesfully Added";
	}
	
	public List<Customer> getAll() {
		return repo.getAll();
	}
	
	public Customer getCustomerByID(int id) {
		return repo.getCustomerByID(id);
	}
	
	public String updateCustomer(Customer customer) {
		 repo.updateCustomer(customer);
		 return "Customer info Updated";
	}
	
	public String deleteCustomerByID(int id) {
		 repo.deleteCustomerByID(id);
		 return "Customer ID : " + " deleted";
	}

}
