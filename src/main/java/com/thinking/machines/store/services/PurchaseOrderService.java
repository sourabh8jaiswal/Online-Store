package com.thinking.machines.store.services;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;
import com.thinking.machines.store.dl.*;
import com.thinking.machines.store.dl.pojo.*;
import com.thinking.machines.store.beans.*;
import java.util.*;
import java.math.*;
@Controller
public class PurchaseOrderService
{
@Autowired
private PurchaseOrderRepository purchaseOrderRepository;

@Autowired
private CustomerRepository customerRepository;

@ResponseBody
@PostMapping("/purchaseOrder/add")
public PurchaseOrder addPurchaseOrder()
{
PurchaseOrderItem i1=new PurchaseOrderItem(null,new Long(1),3,new BigDecimal(20));
PurchaseOrderItem i2=new PurchaseOrderItem(null,new Long(4),4,new BigDecimal(200));
List<PurchaseOrderItem> items=new ArrayList<>();
items.add(i1);
items.add(i2);
Customer customer=customerRepository.findById(1).get();
PurchaseOrder purchaseOrder=new PurchaseOrder(new java.sql.Date(2020,03,02),customer,new BigDecimal("2000"),items);

purchaseOrderRepository.save(purchaseOrder);
return purchaseOrder;
}
}