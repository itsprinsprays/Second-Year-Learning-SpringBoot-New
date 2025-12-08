package SpringbootJDBC1.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import SpringbootJDBC1.model.Customer;

@Repository
public class CustomerRepository implements CustomerImp {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public CustomerRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	private RowMapper<Customer> rowMapper = (rs, row) -> 
			new Customer(rs.getString("CustomerName"), rs.getInt("OrderNumber"), rs.getString("PaymentMethod")
				);
	
	@Override
	public int addCustomer(Customer customer) {
		String sql = "Insert into Customer (CustomerName, OrderNumber, PaymentMethod) values (?,?,?)";
		return jdbcTemplate.update(sql, customer.getCustomerName(), customer.getOrderNumber(), customer.getPaymentMethod());
	}
	
	@Override
	public List<Customer> getAll() {
		String sql = "Select * from customer";
		return jdbcTemplate.query(sql, rowMapper);
	}
	
	@Override
	public Customer getCustomerByID(int id) {
	    String sql = "SELECT * FROM customer WHERE OrderNumber = ?";
	    List<Customer> customers = jdbcTemplate.query(sql, rowMapper, id);
	    return customers.isEmpty() ? null : customers.get(0);
	}

	
	@Override
	public int updateCustomer(Customer customer) {
		String sql = "Update customer set CustomerName = ?, OrderNumber = ?, PaymentMethod = ? ";
		return jdbcTemplate.update(sql, customer.getCustomerName(), customer.getOrderNumber(), customer.getPaymentMethod());
	}
	
	@Override
	public int deleteCustomerByID(int id) {
		String sql = "Delete * from customer";
		return jdbcTemplate.update(sql,id);
	}
	
	
	
	
	

}
