package com.products.hello.product;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
@Service
public class ProductService {
    private final ProductRepository repo;
    public ProductService(ProductRepository repo){
        this.repo =repo;
    }
    public List<Product> findAll(){ return repo.findAll(); }
    public Product findById(Long id){
        return repo.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Product not found"));
    }
    public Product create(Product p){p.setId(null);return repo.save(p);}
    public Product update(Long id , Product patch){
        Product p = findById(id);
        p.setName(patch.getName());
        p.setPrice(patch.getPrice());
        p.setSelected(patch.isSelected());
        return repo.save(p);
    }
    public void delete(Long id){
        if(!repo.existsById(id))throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Product not found");
        repo.deleteById(id);
    }
}
