package com.thinking.machines.store.dl.pojo;
import javax.persistence.*;
@Entity(name="administrator")
public class Administrator
{
@Id
@Column(name="username")
private String username;
@Column(name="password")
private String password;
@Column(name="password_key")
private String passwordKey;
public Administrator()
{
}
public Administrator(String username,String password,String passwordKey)
{
this.username=username;
this.password=password;
this.passwordKey=passwordKey;
}
public void setUsername(java.lang.String username)
{
this.username=username;
}
public java.lang.String getUsername()
{
return this.username;
}
public void setPassword(java.lang.String password)
{
this.password=password;
}
public java.lang.String getPassword()
{
return this.password;
}
public void setPasswordKey(java.lang.String passwordKey)
{
this.passwordKey=passwordKey;
}
public java.lang.String getPasswordKey()
{
return this.passwordKey;
}
}