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
public class accountBean {
    private int customerId,accountId,accountNo,pinCode,balance;
    private String accountType,remarks;
    private java.util.Date dateOfCreate;
    
    public void setCustomerId(int customerId){this.customerId = customerId;}
    public void setAccountId(int accountId){this.accountId = accountId;}
    public void setAccountNo(int accountNo){this.accountNo = accountNo;}
    public void setBalance(int totalAmount){this.balance = balance;}
    public void setPinCode(int pinCode){this.pinCode = pinCode;}
    
    public void setAccountType(String accountType){this.accountType = accountType;}
    public void setRemarks(String remarks){this.remarks = remarks;}
    
    public void setDateOfCreate(java.util.Date dateOfCreate){this.dateOfCreate = dateOfCreate ; }
    
    public int getCustomerId(){return customerId;}
    public int getAccountId(){return accountId;}
    public int getAccountNo(){return accountNo;}
    public int getBalance(){return balance;}
    public int getPinCode(){return pinCode;}
    
    public String getAccountType(){return accountType;}
    public String getRemarks(){return remarks;}
    
    public java.util.Date getDateOfCreate(){return dateOfCreate;}
    
    @Override
    public String toString(){
        return ""+accountNo;
    }
    
}
