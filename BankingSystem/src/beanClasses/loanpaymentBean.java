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
public class loanpaymentBean {
    
    	private int loanPaymentId;
	private int loanId;
	private String paymentDate; 
	private int paymentAmount;
	private int lateFees;
	private int totalPay ;
	private int remender;
	private String remarks;
	public int getLoanPaymentId() {
		return loanPaymentId;
	}
	public void setLoanPaymentId(int loanPaymentId) {
		this.loanPaymentId = loanPaymentId;
	}
	public int getLoanId() {
		return loanId;
	}
	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}
	public String getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}
	public int getPaymentAmount() {
		return paymentAmount;
	}
	public void setPaymentAmount(int paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	public int getLateFees() {
		return lateFees;
	}
	public void setLateFees(int lateFees) {
		this.lateFees = lateFees;
	}
	public int getTotalPay() {
		return totalPay;
	}
	public void setTotalPay(int totalPay) {
		this.totalPay = totalPay;
	}
	public int getRemender() {
		return remender;
	}
	public void setRemender(int remender) {
		this.remender = remender;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	@Override
	public String toString() {
		return ""+loanPaymentId;
	}
}
