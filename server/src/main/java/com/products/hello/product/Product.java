package com.products.hello.product;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;

@Entity
@Table(name="products")
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String name;

    @NotNull @Positive
    @Column(nullable = false , precision = 12 ,scale =2)
    private BigDecimal price;

    @Column (nullable = false)
    private boolean selected = false;

    public Long getId() {
        return id;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public String getName() {
        return name;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public boolean isSelected() {
        return selected;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
