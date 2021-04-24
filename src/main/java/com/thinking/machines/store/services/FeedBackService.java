package com.thinking.machines.store.services;
import com.thinking.machines.store.dl.*;
import com.thinking.machines.store.dl.pojo.*;
import com.thinking.machines.store.beans.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;
import java.util.*;

@Controller
public class FeedBackService
{
@Autowired
private FeedBackRepository feedBackRepository;
@Autowired
private ProductRepository productRepository;
@Autowired
private CustomerRepository customerRepository;

@ResponseBody
@PostMapping("/feedBack/add")
public FeedBackBean addFeedBack(FeedBackBean feedBackBean)
{
Long productCode=feedBackBean.getProductCode();
Long customerCode=feedBackBean.getCustomerCode();
String vFeedBack=feedBackBean.getFeedBack();
java.util.Date utilGivenOn=feedBackBean.getGivenOn();

Optional<Product> productResult=productRepository.findById(productCode);
Optional<Customer> customerResult=customerRepository.findById(customerCode);

Product product=null;
Customer customer=null;

if(productResult.isPresent()) product=productResult.get();
if(customerResult.isPresent()) customer=customerResult.get();

java.sql.Date sqlGivenOn=new java.sql.Date(utilGivenOn.getYear(),utilGivenOn.getMonth(),utilGivenOn.getDate());
FeedBack feedBack=new FeedBack(sqlGivenOn,product,customer,vFeedBack);
feedBackRepository.save(feedBack);
feedBackBean.setId(feedBack.getId());
return feedBackBean;
}

@ResponseBody
@PostMapping("/feedBack/update")
public FeedBackBean updateFeedBack(FeedBackBean feedBackBean)
{
Long id=feedBackBean.getId();
Long productCode=feedBackBean.getProductCode();
Long customerCode=feedBackBean.getCustomerCode();
String vFeedBack=feedBackBean.getFeedBack();
java.util.Date utilGivenOn=feedBackBean.getGivenOn();

Optional<Product> productResult=productRepository.findById(productCode);
Optional<Customer> customerResult=customerRepository.findById(customerCode);

Product product=null;
Customer customer=null;

if(productResult.isPresent()) product=productResult.get();
if(customerResult.isPresent()) customer=customerResult.get();

java.sql.Date sqlGivenOn=new java.sql.Date(utilGivenOn.getYear(),utilGivenOn.getMonth(),utilGivenOn.getDate());
FeedBack feedBack=new FeedBack(sqlGivenOn,product,customer,vFeedBack);
feedBack.setId(id);

feedBackRepository.save(feedBack);
feedBackBean.setId(feedBack.getId());
return feedBackBean;
}

@ResponseBody
@PostMapping("/feedBack/delete")
public Boolean delete(@RequestParam("id") Long id)
{
if(!exists(id)) return false;
feedBackRepository.deleteById(id);
return true;
}

@ResponseBody
@GetMapping("/feedBack/getAll")
public List<FeedBackBean> getAll()
{
List<FeedBackBean> feedBacks=new ArrayList<>();
FeedBackBean feedBackBean=null;
java.sql.Date sqlDate=null;
java.util.Date utilDate=null;
for(FeedBack feedBack : feedBackRepository.findAll())
{
feedBackBean=new FeedBackBean();
feedBackBean.setId(feedBack.getId());
sqlDate=feedBack.getGivenOn();
utilDate=new java.util.Date(sqlDate.getYear(),sqlDate.getMonth(),sqlDate.getDate());
feedBackBean.setGivenOn(utilDate);
feedBackBean.setFeedBack(feedBack.getFeedBack());
feedBackBean.setCustomer(feedBack.getCustomer());
feedBackBean.setProduct(feedBack.getProduct());
feedBacks.add(feedBackBean);
}
return feedBacks;
}


@ResponseBody
@GetMapping("/feedBack/getById")
public FeedBackBean getById(@RequestParam("id") Long id)
{
FeedBack feedBack=null;
Optional<FeedBack> feedBackResult=feedBackRepository.findById(id);
if(feedBackResult.isPresent()) feedBack=feedBackResult.get();
else return null;
FeedBackBean feedBackBean=new FeedBackBean();
feedBackBean.setId(feedBack.getId());
java.sql.Date sqlDate=feedBack.getGivenOn();
java.util.Date utilDate=new java.util.Date(sqlDate.getYear(),sqlDate.getMonth(),sqlDate.getDate());
feedBackBean.setGivenOn(utilDate);
feedBackBean.setFeedBack(feedBack.getFeedBack());
feedBackBean.setCustomer(feedBack.getCustomer());
feedBackBean.setProduct(feedBack.getProduct());
return feedBackBean;
}

@ResponseBody
@GetMapping("/feedBack/exists")
public Boolean exists(@RequestParam("id") Long id)
{
return feedBackRepository.existsById(id);
}

@ResponseBody
@GetMapping("/feedBack/count")
public Long count()
{
return feedBackRepository.count();
}
}