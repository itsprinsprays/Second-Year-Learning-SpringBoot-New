package SpringbootJDBC1.repository;
import java.util.List;

import SpringbootJDBC1.model.Customer;
public interface CustomerImp {
	
	int addCustomer(Customer customer);
	List<Customer> getAll();
	Customer getCustomerByID(int id);
	int updateCustomer(Customer customer);
	int deleteCustomerByID(int id);
}
