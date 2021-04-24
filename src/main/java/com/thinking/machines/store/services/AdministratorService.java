package com.thinking.machines.store.services;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;
import com.thinking.machines.store.dl.*;
import com.thinking.machines.store.dl.pojo.*;
import com.thinking.machines.store.beans.*;
@Controller
public class AdministratorService
{
@Autowired
private AdministratorRepository administratorRepository;

@ResponseBody
@PostMapping("/addAdministrator")
public AdministratorBean addAdministrator(AdministratorBean administratorBean)
{
String username=administratorBean.getUsername();
String password=administratorBean.getPassword();
String key=java.util.UUID.randomUUID().toString().replaceAll("-","d");
String encryptedPassword=password; // as now it is not encrypted
Administrator administrator=new Administrator();
administrator.setUsername(username);
administrator.setPassword(password);
administrator.setPasswordKey(key);
administratorRepository.save(administrator);
return administratorBean;
}
}