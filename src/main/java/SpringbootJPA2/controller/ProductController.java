package SpringbootJPA2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import SpringbootJPA2.service.ProductService;
import SpringbootJPA2.dto.*;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	private final ProductService serv;
	
	public ProductController(ProductService serv) {
		this.serv = serv;
	}
	
	@PostMapping
	public ResponseEntity<CreateProductResponseDTO> createProduct(@RequestBody CreateProductRequestDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(serv.createProduct(dto));
	}

}
