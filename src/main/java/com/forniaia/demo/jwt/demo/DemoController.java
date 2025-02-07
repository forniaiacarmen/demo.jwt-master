package com.forniaia.demo.jwt.demo;

import com.forniaia.demo.jwt.model.Producto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class DemoController {

    private final DemoService productService ;

    @PostMapping
    public ResponseEntity<Producto> createProduct(@RequestBody Producto product) {
        Producto createdProduct = productService.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
    }

    @GetMapping
    public ResponseEntity<List<Producto>> getAllProducts() {
        List<Producto> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> getProductById(@PathVariable Long id) {
        Producto product = productService.getProductById(id);
        return ResponseEntity.ok(product);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> updateProduct(@PathVariable Long id, @RequestBody Producto product) {
        Producto updatedProduct = productService.updateProduct(id, product);
        return ResponseEntity.ok(updatedProduct);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
