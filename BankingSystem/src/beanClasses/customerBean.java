/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beanClasses;

/**
 *
 * @author HP
 */
public class customerBean {
    private int cutomerId ,cntactNo,cnic ;
    private String firstName ,lastName,city,state,country,adress,email,remrks;
    private java.util.Date dateOfCreate;
    
    public void setCutomerId(int cutomerId){this.cutomerId = cutomerId;}
    public void setCntactNo(int cntactNo ){this.cntactNo = cntactNo ;}
    public void setCnic(int cnic ){this.cnic = cnic ;}
    public void setFirstName(String firstName ){this.firstName =firstName ;}
    public void setLastName(String lastName){this.lastName = lastName ;}
    public void setCity(String city){this.city = city ;}
    public void setState(String state){this.state = state;}
    public void setCountry(String country){this.country = country;}
    public void setAdress(String adress){this.adress = adress ;}
    public void setEmail(String email){this.email = email;}
    public void setRemrks(String remrks){this.remrks = remrks;}
    public void setDateOfCreate(java.util.Date dateOfCreate){this.dateOfCreate = dateOfCreate ; }
    
    public int getCutomerId(){return cutomerId;}
    public int getCntactNo(){return cntactNo;}
    public int getCnic(){return cnic;}
    public String getFirstName(){return firstName;}
    public String getLastName(){return lastName;}
    public String getCity(){return city;}
    public String getState(){return state;}
    public String getCountry(){return country;}
    public String getAdress(){return adress;}
    public String getEmail(){return email;}
    public String getRemrks(){return remrks;}
    public java.util.Date getDateOfCreate(){return dateOfCreate;}
    
    @Override
    public String toString(){
        return firstName;
    }
}
