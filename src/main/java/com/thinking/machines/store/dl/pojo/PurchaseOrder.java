package com.thinking.machines.store.dl.pojo;
import java.math.*;
import java.util.*;
import javax.persistence.*;
@Entity(name="purchase_order")
public class PurchaseOrder
{
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@Column(name="id")
private Long id;
@Column(name="order_date")
private java.sql.Date orderDate;
@ManyToOne
@JoinColumn(name="customer_code",referencedColumnName="code")
private Customer customer;
@Column(name="total_amount")
private BigDecimal totalAmount;

@OneToMany(mappedBy="purchaseOrder",cascade={CascadeType.PERSIST,CascadeType.MERGE})
private List<PurchaseOrderItem> items;
public PurchaseOrder()
{
}
public PurchaseOrder(java.sql.Date orderDate,Customer customer,BigDecimal totalAmount,List<PurchaseOrderItem> items)
{
this.orderDate=orderDate;
this.customer=customer;
this.totalAmount=totalAmount;
this.items=items;
}
public void setId(Long id)
{
this.id=id;
}
public Long getId()
{
return this.id;
}
public void setOrderDate(java.sql.Date orderDate)
{
this.orderDate=orderDate;
}
public java.sql.Date getOrderDate()
{
return this.orderDate;
}
public void setCustomer(Customer customer)
{
this.customer=customer;
}
public Customer getCustomer()
{
return this.customer;
}
public void setTotalAmount(BigDecimal totalAmount)
{
this.totalAmount=totalAmount;
}
public BigDecimal getTotalAmount()
{
return this.totalAmount;
}
public void setItems(List<PurchaseOrderItem> items)
{
this.items=items;
}
public List<PurchaseOrderItem> getItems()
{
return this.items;
}
}