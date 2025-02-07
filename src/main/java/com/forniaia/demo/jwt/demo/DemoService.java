package com.forniaia.demo.jwt.demo;

import com.forniaia.demo.jwt.model.Producto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DemoService {
    private final DemoRepository productRepository;

    public Producto createProduct(Producto product) {
        return productRepository.save(product);
    }

    public List<Producto> getAllProducts() {
        return (List<Producto>) productRepository.findAll();
    }

    public Producto getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Producto updateProduct(Long id, Producto product) {
        if (productRepository.existsById(id)) {
            product.setId(id);
            return productRepository.save(product);
        } else {
            return null;
        }
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

}
