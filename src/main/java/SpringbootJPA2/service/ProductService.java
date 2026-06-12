package SpringbootJPA2.service;

import org.springframework.stereotype.Service;

import SpringbootJPA2.repository.ProductRepository;

@Service
public class ProductService {
	
		private final ProductRepository prepo;
		
		public ProductService(ProductRepository prepo) {
			this.prepo = prepo;
		}
		
		

}
