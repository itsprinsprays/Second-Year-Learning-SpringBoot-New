package SpringbootJPA2.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Pageable;


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
	
	@GetMapping("/AllProduct")
	public ResponseEntity<Page<AllProductResponseDTO>> getAllProduct(
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "5") int size
			) {
		
			Pageable pageable = PageRequest.of(page, size);
			return ResponseEntity.ok().body(serv.getAllProduct(pageable));
	}
	
	@GetMapping("/Product/{Id}")
	public ResponseEntity<AllProductResponseDTO> getProductById(@PathVariable Long Id) {
		return ResponseEntity.ok().body(serv.getProductById(Id));
	}
	
	@DeleteMapping("/DeleteProduct/{Id}")
	public ResponseEntity<DeleteProductResponseDTO> deleteProductById(@PathVariable Long Id) {
		return ResponseEntity.ok().body(serv.deleteProductById(Id));
	}
	
	@PatchMapping("/SoftDelete/{Id}")
	public ResponseEntity<AllProductResponseDTO> softDelete(@RequestBody SoftDeleteRequestDTO dto, @PathVariable Long Id) {
		return ResponseEntity.ok().body(serv.softDeleteProduct(dto, Id));
	}

}
