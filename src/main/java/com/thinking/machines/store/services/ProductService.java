package com.thinking.machines.store.services;
import com.thinking.machines.store.dl.*;
import com.thinking.machines.store.dl.pojo.*;
import com.thinking.machines.store.beans.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;
import java.util.*;

@Controller
public class ProductService
{
@Autowired
private ProductRepository productRepository;

@ResponseBody
@PostMapping("/product/add")
public ProductBean add(ProductBean productBean)
{
Product product=new Product(productBean.getName(),productBean.getPrice(),productBean.getIsAvailable());
productRepository.save(product);
productBean.setCode(product.getCode());
return productBean;
}

@ResponseBody
@PostMapping("/product/update")
public ProductBean update(ProductBean productBean)
{
Product product=new Product(productBean.getName(),productBean.getPrice(),productBean.getIsAvailable());
product.setCode(productBean.getCode());
productRepository.save(product);
productBean.setCode(product.getCode());
return productBean;
}

@ResponseBody
@PostMapping("/product/delete")
public Boolean delete(@RequestParam("code") Long code)
{
if(!exists(code)) return false;
productRepository.deleteById(code);
return true;
}

@ResponseBody
@GetMapping("/product/getAll")
public List<Product> getAll()
{
List<Product> products=new ArrayList<>();
productRepository.findAll().forEach(products::add);
return products;
}

@ResponseBody
@GetMapping("/product/getByCode")
public Product getByCode(@RequestParam("code") Long code)
{
Product product=null;
Optional<Product> productResult=productRepository.findById(code);
if(productResult.isPresent()) product=productResult.get();
return product;
}

@ResponseBody
@GetMapping("/product/exists")
public Boolean exists(@RequestParam("code") Long code)
{
return productRepository.existsById(code);
}

@ResponseBody
@GetMapping("/product/count")
public Long count()
{
return productRepository.count();
}

}