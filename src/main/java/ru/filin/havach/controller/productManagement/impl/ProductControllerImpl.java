package ru.filin.havach.controller.productManagement.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.filin.havach.controller.productManagement.ProductController;
import ru.filin.havach.model.productManagement.entities.Product;
import ru.filin.havach.service.productManagement.ProductService;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductControllerImpl implements ProductController {
    @Autowired
    private ProductService productService;

    @Override
    @GetMapping
    public List<Product> getAll() {
        return productService.getAll();
    }

    @Override
    @GetMapping({"id"})
    public Product getById(@PathVariable long id) {
        return productService.getById(id);
    }

    @Override
    @DeleteMapping({"id"})
    public void delete(long id) {
        productService.delete(id);
    }

    @PutMapping("id")
    public void update(Product obj) {
        productService.update(obj);
    }

    @PostMapping
    public Long save(Product obj) {
        return productService.save(obj);
    }


}
