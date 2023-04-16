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
public class transactionBean {
    private int accountId,transactionId,amount,balance,accountNo,cheque;
    private String amountType,transactioType,remarks;
    private String dateOfTransaction;
    public void setAccountId(int accountId){this.accountId =accountId;}
    public void setTransactionId(int transactionId){this.transactionId =transactionId;}
    public void setAmount(int amount){this.amount =amount;}
    public void setCheque(int cheque){this.cheque =cheque;}
    public void setAccountNo(int accountNo){this.accountNo =accountNo;}
    public void setBalance(int balance){this.balance =balance;}
    public void setAmountType(String amountType){this.amountType = amountType ;}
    public void setTransactionType(String transactioType){this.transactioType = transactioType ;}
    public void setDateOfTransaction(String dateOfTransaction){this.dateOfTransaction= dateOfTransaction;}
            
    public void setRemarks(String remarks){this.remarks = remarks;}
    
    public int getAccountId(){return accountId; }
    public int getTransactionId(){return transactionId; }
    public int getAmount(){return amount; }
    public int getCheque(){return cheque; }
    public int getAccountNo(){return accountNo; }
    public int getBalance(){return balance; }
    public String getAmountType(){return amountType;}
    public String getTransactionType(){return transactioType;}
    public String getdateOfTransaction(){return dateOfTransaction;}
    
    public String getRemarks(){return remarks;}
    
    @Override
    public String toString(){        return dateOfTransaction+"   "+amount+   " " +transactioType;
    }


}
