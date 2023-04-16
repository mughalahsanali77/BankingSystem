/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import beanClasses.accountBean;
import beanClasses.customerBean;
import beanClasses.loanBean;
import beanClasses.loanpaymentBean;
import beanClasses.transactionBean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class databaseManager {
    private static Connection con ;
    static{
        try{

            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con=DriverManager.getConnection("jdbc:ucanaccess://D:\\D\\databases\\NetBeansProjects\\BankingSystem\\BankingUzair.accdb");
            System.out.println("connection ");

        }catch(Exception e){JOptionPane.showMessageDialog(null," Error: "+e.getMessage()); e.printStackTrace();}
    }
    public static Vector getCustomer()throws Exception{
    String query= "select * from customer";
    System.out.println(query);
    Statement st= null;
    ResultSet result = null;
    try{
    st=con.createStatement();
    result =st.executeQuery(query);
    Vector v = new Vector();
    while(result.next()){
        customerBean bean = new customerBean();
        bean.setCutomerId(result.getInt("customer_id"));
        bean.setFirstName(result.getString("first_name"));
        bean.setLastName(result.getString("last_name"));
        bean.setCity(result.getString("city"));
        bean.setCountry(result.getString("country"));
        bean.setState(result.getString("state"));
        bean.setAdress(result.getString("address"));
        bean.setCntactNo(result.getInt("contact_no"));
        bean.setEmail(result.getString("email"));
        bean.setRemrks(result.getString("remarks"));
        bean.setCnic(result.getInt("cnic"));
        bean.setDateOfCreate(result.getDate("date_of_create"));
        v.addElement(bean);
    }
    return v;
    }finally {
    if(st!=null);

    if(result != null){
        result.close();
    }
   }



}

    public static Vector getAccount(int customerId)throws Exception{
        String query ="select * from account where customer_id = "+customerId;
        
        System.out.println(query);
        Statement st = null ;
        ResultSet result = null ;
        try{
            st=con.createStatement();
            result=st.executeQuery(query);
            Vector v = new Vector();
            while(result.next()){
                accountBean bean = new accountBean();
                bean.setAccountId(result.getInt("account_id"));
                bean.setAccountNo(result.getInt("account_no"));
                bean.setBalance(result.getInt("balance"));
                bean.setCustomerId(result.getInt("customer_id"));
                bean.setAccountType(result.getString("acount_type"));
                bean.setPinCode(result.getInt("pin_code"));
                bean.setDateOfCreate(result.getDate("date_of_create"));
                v.addElement(bean);
        }
        return v;

        }finally{
            if(result!=null)
                result.close();
            if(st!=null)
                st.close();
        }
    }
     public static Vector getTransaction(int accountNo)throws Exception{
        String query= "select * from transaction , account where amount_no = "+accountNo+" AND account.account_no = "+accountNo  ;
        //String query2= "select balance from account where account_no = "+accountNo;
        System.out.println(query);
        Statement st = null;
        ResultSet result = null ;
        ResultSet result1 = null ;
        try{
            st=con.createStatement();
            result=st.executeQuery(query);
        Vector v = new Vector();
         //Vector v1 = new Vector();
        while(result.next()  ){
            transactionBean bean = new transactionBean();
            //accountBean bean1 = new accountBean();
            bean.setAccountId(result.getInt("account_id"));
            bean.setTransactionId(result.getInt("transaction_id"));
            bean.setAmount(result.getInt("amount"));
            bean.setCheque(result.getInt("cheque"));
            bean.setAccountNo(result.getInt("amount_no"));
            bean.setBalance(result.getInt("account.balance"));
            bean.setTransactionType(result.getString("transaction_type"));
            bean.setAmountType(result.getString("amount_type"));
            bean.setDateOfTransaction(result.getString("date_of_transaction"));
            bean.setRemarks(result.getString("remarks"));
            v.addElement(bean);
        }
        return v ;
        }finally{
            if(result!=null)
                result.close();
            if(st!=null)
                st.close();
        }
    }

    
     public static Vector getLoan(int accountId)throws Exception{
        String query= "select * from loan where account_id = "+accountId;
        System.out.println(query);
        Statement st = null;
        ResultSet result = null ;
        try{
            st=con.createStatement();
            result=st.executeQuery(query);
        Vector v = new Vector();
        while(result.next()){
            loanBean bean = new loanBean();
            bean.setAccountId(result.getInt("account_id"));
            bean.setLoanId(result.getInt("loan_id"));
            bean.setAccountNo(result.getInt("account_no"));
            bean.setAmount(result.getInt("amount"));
            bean.setMonthLimit(result.getString("month_limit"));
            bean.setKisitLimit(result.getInt("kisit_limit"));
            bean.setPercentage(result.getInt("percentege"));
            bean.setProfit(result.getInt("profit"));
            bean.setRemarks(result.getString("remarks"));
            v.addElement(bean);
        }
        return v;
        }finally{
            if(result!=null)
                result.close();
            if(st!=null)
                st.close();
        }
    }

     public static Vector getLoanpayment(int loanId)throws Exception{
        String query= "select * from loanpayment where loan_id = "+loanId;
        System.out.println(query);
        Statement st = null;
        ResultSet result = null ;
        try{
            st=con.createStatement();
            result=st.executeQuery(query);
        Vector v = new Vector();
        while(result.next()){
            loanpaymentBean bean = new loanpaymentBean();
            bean.setLoanPaymentId(result.getInt("loanpayment_id"));
            bean.setPaymentDate(result.getString("payment_date"));
            bean.setPaymentAmount(result.getInt("payment_amount"));
            bean.setLateFees(result.getInt("late_fees"));
            bean.setRemender(result.getInt("remmender"));
            bean.setTotalPay(result.getInt("total_pay"));
            
            bean.setRemarks(result.getString("remarks"));
            v.addElement(bean);
        }
        return v;
        }finally{
            if(result!=null)
                result.close();
            if(st!=null)
                st.close();
        }
    }

    
    public static int deleteCustomer(int customerId)throws Exception{
        String query= "delete from customer where customer_id = "+customerId;
        System.out.println(query);
        Statement st = null ;
        try{
        st=con.createStatement();
            int rows=st.executeUpdate(query);
            return rows;
        }
        finally{// finally state
            if(st!=null){
                st.close();
            }
        }// close finally
    }
    public static int deleteAccount(int accountId)throws Exception{
        String query= "delete from account where account_id = "+accountId;
        System.out.println(query);
        Statement st = null ;
        try{
        st=con.createStatement();
            int rows=st.executeUpdate(query);
            return rows;
        }
        finally{// finally state
            if(st!=null){
                st.close();
            }
        }// close finally
    }

    public static int deleteTransaction(int transactionId)throws Exception{
        String query= "delete from transaction where transaction_id = "+transactionId;
        System.out.println(query);
        Statement st = null ;
        try{
        st=con.createStatement();
            int rows=st.executeUpdate(query);

            return rows;
        }
        finally{// finally state

            if(st!=null){

                st.close();
            }

        }// close finally


    }
    
    
    public static int deleteLoan(int loanId)throws Exception{
        String query= "delete from loan where loan_id = "+loanId;
        System.out.println(query);
        Statement st = null ;
        try{
        st=con.createStatement();
            int rows=st.executeUpdate(query);

            return rows;
        }
        finally{// finally state

            if(st!=null){

                st.close();
            }

        }// close finally


    }
    

     public static int deleteLoanpayment(int loanpaymentId)throws Exception{
        String query= "delete from loanpayment where loanpayment_id = "+loanpaymentId;
        System.out.println(query);
        Statement st = null ;
        try{
        st=con.createStatement();
            int rows=st.executeUpdate(query);

            return rows;
        }
        finally{// finally state

            if(st!=null){

                st.close();
            }

        }// close finally


    }
    
    
    public static int updateCustomer(int customerId,String firstName,String lastName,String city,String state,String country,String address,String email,int contactNo,String dateOfCreate,String remarks)throws Exception{
    String query = "update customer set first_name ='"+firstName+"' , last_name ='"+lastName+"' , city = '"+city+"' ,state = '"+state+"' , country = '"+country+"' , address = '"+address+"' , email = '"+email+"' ,contact_no = "+contactNo+" ,date_of_create = '"+dateOfCreate+"' ,remarks = '"+remarks+"' where customer_id = "+customerId;
    System.out.println(query);
    Statement st =null;
    try{
        st=con.createStatement();
        int row =st.executeUpdate(query);
        return row;
    }finally{
        if(st!=null)
            st.close();
    }
    }

    public static int updateAccount(int customerId,int accountId,int accountNo,int pinCode,String dateOfCreate,String accountType,String remarks)throws Exception{
    String query ="update account set customer_id = "+customerId+" ,account_no = "+accountNo+" ,pin_code = "+pinCode+" , date_of_create = '"+dateOfCreate+"' ,acount_type = '"+accountType+"' ,remarks = '"+remarks+"' where account_id = "+accountId;
    System.out.println(query);
    Statement st= null;
    try{
        st=con.createStatement();
        int row =st.executeUpdate(query);
        return row ;
    }finally{
        if(st!=null)
            st.close();
    }
    }
    
    public static int updateTransaction(int accountId,int transactionId,int amount,int transactionType,String amountType,String dateOfTransaction,String remarks)throws Exception{
    String query = "update transaction set account_id = '"+accountId+"',amount = '"+amount+"' , transaction_type ='"+transactionType+"' ,amount_type = '"+amountType+"' ,date_of_transaction = '"+dateOfTransaction+"' , remarks = '"+remarks+"' where transaction_id = "+transactionId;
    System.out.println(query);
    Statement st = null ;
    try{
        st = con.createStatement();
        int row = st.executeUpdate(query);
        return row;
    }finally{
        if(st!=null)st.close();
    }
    }

    public static int updateLoan(int accountId,int loanId,int amount,int monthLimit,int kisitLimit,int percentege,int profit,String remarks)throws Exception{
        
    String query = "update loan set account_id = "+accountId+",amount = "+amount+" , month_limit ="+monthLimit+" ,kisit_limit = "+kisitLimit+" ,percentege = "+percentege+",profit = "+profit+" , remarks = '"+remarks+"' where loanpayment_id = "+loanId;
    System.out.println(query);
    Statement st = null ;
    try{
        st = con.createStatement();
        int row = st.executeUpdate(query);
        return row;
    }finally{
        if(st!=null)st.close();
    }
    }
    
    public static int updateLoanpayment(int loanId,int loanpaymentId,String  paymentDate,int paymentAmount,int lateFees,int totalPay,int remmender,String remarks)throws Exception{
    String query = "update loanpayment set loan_id = "+loanId+",payment_date = '"+paymentDate+"',payment_amount = "+paymentAmount+" ,late_fees = "+lateFees+" ,total_pay = "+totalPay+",remmender = "+remmender+" , remarks = '"+remarks+"' where loanpayment_id = "+loanpaymentId;
    System.out.println(query);
    Statement st = null ;
    try{
        st = con.createStatement();
        int row = st.executeUpdate(query);
        return row;
    }finally{
        if(st!=null)st.close();
    }
    }

    
    public static int addCutomer(String firstName,String lastName,String city,String state,String country,String address,int contactNo,String email,String date1,String remarks)throws Exception{
    String query = "insert into customer (first_name,last_name,city,country,state,address,contact_no,email,date_of_create,remarks)values('"+firstName+"','"+lastName+"' ,'"+city+"','"+country+"','"+state+"','"+address+"',"+contactNo+" ,'"+email+"','"+date1+"','"+remarks+"')"  ;  
    System.out.println(query);
    Statement st= null;
    try{
        st=con.createStatement();
        int row =st.executeUpdate(query);
        return row ;
    }finally{
        if(st!=null)
            st.close();
    }
    }
    public static int addAccount(int customerId,int accountNo,int pinCode,String dateOfCreate,String accountType,String remarks)throws Exception{
        String query = "insert into account (customer_id,account_no,pin_code,date_of_create,acount_type,remarks)values("+customerId+","+accountNo+","+pinCode+",'"+dateOfCreate+"','"+accountType+"','"+remarks+"') ";
    System.out.println(query);
    Statement st = null ;
    try{
        st = con.createStatement();
        int row = st.executeUpdate(query);
        return row;
    }finally{
        if(st!=null)st.close();
    }
    }
    
    public static int addTransaction(int tra,int accountId,int amount ,String amountType,String dateOfTransaction,String transactionType)throws Exception{
        String query1 ="select balance from account where account_no = "+accountId; 
        Statement st = null ;
        ResultSet result = null ;
             
         try{
            int am ;
            st=con.createStatement();
            result=st.executeQuery(query1);
            Vector v = new Vector();
            if(result.next()){
                
                 am=result.getInt("balance");
//            if(amount)
            int amount1 =am-amount;
             String query2 = "update  transaction set total_amount= "+amount1 +" where transaction_id = "+tra ; 
             String query3 = "update  account  set balance= "+amount1 +" where account_no = "+accountId ; 
             String query = "insert into transaction(amount_no,amount,amount_type,date_of_transaction,transaction_type,total_amount)values("+accountId+ " ,"+amount+",'"+amountType+"','"+dateOfTransaction+"','"+transactionType+"',"+amount1+" )";
       System.out.println(query);
 

             
            
            int row1 = st.executeUpdate(query);
            int row2 = st.executeUpdate(query2);
            int row3 = st.executeUpdate(query3);
            return row1 + row2 + row3;
            
         // return row;  
            }
    }finally{
        if(st!=null)st.close();
    }
        return 0;
    }
    
    public static int addTransactionD(int tra,int accountId,int amount ,String amountType,String dateOfTransaction,String transactionType)throws Exception{
        String query1 ="select balance from account where account_no = "+accountId; 
        Statement st = null ;
        ResultSet result = null ;    
         try{
            int am ;
            st=con.createStatement();
            result=st.executeQuery(query1);
            Vector v = new Vector();
            if(result.next()){
                 am=result.getInt("balance");
           
            int amount1 =am+amount;
             String query2 = "update  transaction set total_amount= "+amount1 +" where transaction_id = "+tra ; 
             String query3 = "update  account  set balance= "+amount1 +" where account_no = "+accountId ; 
             String query = "insert into transaction(amount_no,amount,amount_type,date_of_transaction,transaction_type,total_amount)values("+accountId+ " ,"+amount+",'"+amountType+"','"+dateOfTransaction+"','"+transactionType+"',"+amount1+" )";
             System.out.println(query);
             int row1 = st.executeUpdate(query);
            int row2 = st.executeUpdate(query2);
            int row3 = st.executeUpdate(query3);
            return row1 + row2 + row3;
            
            }
    }finally{        if(st!=null)st.close(); }
        return 0;
    }
    
    public static int addTransactionW(int tra,int accountId,int amount ,String amountType,String dateOfTransaction,String transactionType,int cheque)throws Exception{
        String query1 ="select balance from account where account_no = "+accountId; 
        Statement st = null ;
        ResultSet result = null ;
             
         try{
            int am ;
            st=con.createStatement();
            result=st.executeQuery(query1);
            Vector v = new Vector();
            if(result.next()){
                 am=result.getInt("balance");
             if(am >=amount){
            int amount1 =am-amount;
             String query2 = "update  transaction set total_amount= "+amount1 +" where transaction_id = "+tra ; 
             String query3 = "update  account  set balance= "+amount1 +" where account_no = "+accountId ; 
             String query = "insert into transaction(amount_no,amount,amount_type,date_of_transaction,transaction_type,total_amount,cheque)values("+accountId+ " ,"+amount+",'"+amountType+"','"+dateOfTransaction+"','"+transactionType+"',"+amount1+" ,"+cheque+" )";
       System.out.println(query);
             int row1 = st.executeUpdate(query);
            int row2 = st.executeUpdate(query2);
            int row3 = st.executeUpdate(query3);
            return row1 + row2 + row3;
             }else
                JOptionPane.showMessageDialog(null,"balance not availble ");
            }
    }finally{
        if(st!=null)st.close();
    }
        return 0;
    }
    
    public static int addTransactionTransfer(int tra,int accountId,int amount ,String amountType,String dateOfTransaction,String transactionType,int transferAccount)throws Exception{
        String query1 ="select balance from account where account_no = "+accountId; 
        String queryT ="select balance from account where account_no = "+transferAccount;         
        Statement st2= null ;
        Statement st = null ;
        ResultSet result2= null ;
        ResultSet result=null;     
         try{
            int am ,tamount;
            st=con.createStatement();
            result=st.executeQuery(query1);
          
            st2=con.createStatement();
            result2=st2.executeQuery(queryT);
            
            Vector v = new Vector();
            if(result.next() && result2.next()){
                 am=result.getInt("balance");
                 tamount =  result2.getInt("balance");
            int transferAmount = tamount+amount;
            int amount1 =am-amount;
            int tr1=tra+1;
             String query2 = "update  transaction set total_amount= "+amount1 +" where transaction_id = "+tra+" and amount_no = "+accountId ; 
             String queryT2 = "update  transaction set total_amount= "+transferAmount +" where transaction_id = "+tr1+" and amount_no = "+transferAccount ;
             String query3 = "update  account  set balance= "+transferAmount +" where account_no = "+transferAccount ; 
             String query4 = "update  account  set balance= "+amount1 +" where account_no = "+accountId ; 
             
             String query =         "insert into transaction(amount_no,amount,amount_type,date_of_transaction,transaction_type,total_amount)values("+accountId+ " ,"+amount+",'"+amountType+"','"+dateOfTransaction+"','"+transactionType+"',"+amount1+" )";
             String queryTransfer = "insert into transaction(amount_no,amount,amount_type,date_of_transaction,transaction_type,total_amount)values("+transferAccount+ " ,"+amount+",'"+amountType+"','"+dateOfTransaction+"','"+transactionType+"', "+transferAmount+")";
       
             System.out.println(query);
             System.out.println(queryT);
            
             System.out.println(queryTransfer);
       
            int row1 = st.executeUpdate(query);
            int row2 = st.executeUpdate(query2);
            int row3 = st.executeUpdate(query3);
            int row4 = st.executeUpdate(query4);
            int row5 = st.executeUpdate(queryT2);
            int row6 = st.executeUpdate(queryTransfer);
            return row1 + row2 + row3 +row4 + row5 + row6 ;
              
            }
    }finally{
        if(st!=null && st2!=null)st.close();
    }
        return 0;
    }
    
    
    public static int addLoan(int accountId,int loanId,int amount,int monthLimit,int kisitLimit,int percentege,int profit,String remarks)throws Exception{
        
    String query = "insert into loan(account_id ,amount  , month_limit ,kisit_limit ,percentege,profit , remarks)values( "+accountId+","+amount+" , "+monthLimit+" ,"+kisitLimit+" ,"+percentege+","+profit+" , '"+remarks+"' )";
    System.out.println(query);
    Statement st = null ;
    try{
        st = con.createStatement();
        int row = st.executeUpdate(query);
        return row;
    }finally{
        if(st!=null)st.close();
    }
    }
    
    
    public static int addLoanpayment(int loanId,int loanpaymentId,String  paymentDate,int paymentAmount,int lateFees,int totalPay,int remmender,String remarks)throws Exception{
        
    String query = "insert into loan(loan_id ,payment_date,payment_amount ,late_fees  ,total_pay,remmender , remarks )values(  "+loanId+",'"+paymentDate+"', "+paymentAmount+" , "+lateFees+" ,"+totalPay+","+remmender+" , '"+remarks+"' )";
    System.out.println(query);
    Statement st = null ;
    try{
        st = con.createStatement();
        int row = st.executeUpdate(query);
        return row;
    }finally{
        if(st!=null)st.close();
    }
    }
}
