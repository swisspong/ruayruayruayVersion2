package models;

public class Invoice {
	private int id;
	private Supplier supplier;
	private String date;
	private double total;
	
	public Invoice() {
		
	}
	
	public Invoice(int id, Supplier supplier, String date, double total) {
		
		this.id = id;
		this.supplier = supplier;
		this.date = date;
		this.total = total;
	}
	public Invoice(Supplier supplier, double total) {
		
		this.supplier = supplier;
		this.total = total;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	
}
