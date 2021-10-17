package models;

public class InvoiceDetail {
	private int id;
	private Invoice invoice;
	private int status;
	private Good good;
	private double amount;
	private int quantity;
	
	
	
	public InvoiceDetail(int id, Invoice invoice, int status, Good good, double amount, int quantity) {
		this.id = id;
		this.invoice = invoice;
		this.status = status;
		this.good = good;
		this.amount = amount;
		this.quantity = quantity;
	}
	public InvoiceDetail(Invoice invoice, int status, Good good, double amount, int quantity) {
		
		this.invoice = invoice;
		this.status = status;
		this.good = good;
		this.amount = amount;
		this.quantity = quantity;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Invoice getInvoice() {
		return invoice;
	}
	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Good getGood() {
		return good;
	}
	public void setGood(Good good) {
		this.good = good;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
}
