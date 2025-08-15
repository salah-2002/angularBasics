package com.products.hello.product;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/products")
@CrossOrigin(origins="http://localhost:4200")
public class ProductController {
    private final ProductService service;
    public ProductController(ProductService service){this.service = service;}

    @GetMapping
    public List<Product> getAll() {
        return service.findAll();
    }
    
    // @GetMapping
    // public List<Product> getAll(@PathVariable Long id){return service.findAll();}

    @GetMapping("/{id}")
    public Product getOne(@PathVariable Long id) {
        return service.findById(id);
    }
    
    @PostMapping
    public ResponseEntity<Product> create(@Valid @RequestBody Product p){
        Product saved = service.create(p);
        return ResponseEntity.created(URI.create("/api/products/"+saved.getId())).body(saved);
    }
    @PutMapping("/{id}")
    public Product update(@PathVariable Long id,@Valid @RequestBody Product p) {
        //TODO: process PUT request
        return service.update(id, p);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
