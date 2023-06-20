package com.example.quan_li_san_pham.controller;

import com.example.quan_li_san_pham.model.Product;
import com.example.quan_li_san_pham.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @GetMapping("")
    public String getAllProduct(Model model) {
        model.addAttribute("products", this.iProductService.getProduct());
        return "/list";
    }

    @GetMapping("{id}")
    public String getDetailsProduct(@PathVariable Integer id, Model model) {
        model.addAttribute("products", this.iProductService.findById(id));
        return "/details";
    }

    @GetMapping("/create-form")
    public String showFormCreate(Model model) {
        model.addAttribute("products", new Product());
        return "/create-form";
    }

    @PostMapping()
    public String createNewProduct(@ModelAttribute Product product) {
        iProductService.createProduct(product);
        return "redirect:/products";
    }

    @GetMapping("delete/{id}")
    public String deleteProduct(@PathVariable Integer id) {
        iProductService.delete(id);
        return "redirect:/products";
    }

    @GetMapping("edit/{id}")
    public String editFormProduct(@PathVariable Integer id, Model model) {
        model.addAttribute("product", this.iProductService.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Product product) {
        iProductService.update(product);
        return "redirect:/products";
    }

    @PostMapping("/search")
    public String search(@RequestParam("name") String name, Model model) {
        List<Product> product = iProductService.findByName(name);
        if (product.size() == 0) {
            return "redirect:/products";
        } else {
            model.addAttribute("products", product);
            return "/list";
        }
    }
}
