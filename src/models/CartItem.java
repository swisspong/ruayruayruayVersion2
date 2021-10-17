package models;


public class CartItem extends Good{
	private int quantity;
	private double subTotal;
	public CartItem() {
		
	}
	public CartItem(int id,String name ,String description,double price,int stock) {
		super(id, name, description, price, stock);
	}

	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	
	
	
}
