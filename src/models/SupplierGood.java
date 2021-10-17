package models;

public class SupplierGood {
	private int id;
	private int id_supplier;
	private int id_good;
	private double price;
	private Good good;
	private Supplier supplier;
	
	public SupplierGood(int id, int id_supplier, int id_good, double price) {
		super();
		this.id = id;
		this.id_supplier = id_supplier;
		this.id_good = id_good;
		this.price = price;
	}
	public SupplierGood(int id_supplier, int id_good, double price) {
		super();
		this.id_supplier = id_supplier;
		this.id_good = id_good;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_supplier() {
		return id_supplier;
	}
	public void setId_supplier(int id_supplier) {
		this.id_supplier = id_supplier;
	}
	public int getId_good() {
		return id_good;
	}
	public void setId_good(int id_good) {
		this.id_good = id_good;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public Good getGood() {
		return good;
	}
	public void setGood(Good good) {
		this.good = good;
	}
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	@Override
	public String toString() {
		return "SupplierGood [id=" + id + ", id_supplier=" + id_supplier + ", id_good=" + id_good + ", price=" + price
				+ ", good=" + good + ", supplier=" + supplier + "]";
	}
	
	
	
}
