package com.thinking.machines.store.beans;
public class AdministratorBean implements java.io.Serializable
{
private String username;
private String password;
public AdministratorBean()
{
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
}