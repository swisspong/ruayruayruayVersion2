package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import DB.ConnectionFactory;
import models.Customer;
import models.Good;

public class CustomerDAO {
	public void addCustomer(Customer customer) {
		System.out.println("Add Customer");
		try {
			String insertSql = "INSERT INTO customer (name,address,phone,email,username,password) VALUES ('"
					+customer.getName()+"','"+customer.getAddress()+"','"+customer.getPhone()+"','"+customer.getEmail()+"','"
					+customer.getUsername()+"','"+customer.getPassword()+"');"; 
			System.out.println("insertSql:" + insertSql);

			ConnectionFactory connDB = new ConnectionFactory();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				stmnt.execute(insertSql);
				stmnt.close();
				con.close();
				System.out.println("Customer added successfully.");
			}
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	public Vector<Customer>  viewCustomers() {
		System.out.println("View Customer");
		Vector<Customer> customers = null;
		
		try {
			String viewSql = "SELECT * FROM customer";
			System.out.println("selectSql:" + viewSql);
			
			customers = new Vector<Customer>();

			ConnectionFactory connDB = new ConnectionFactory();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				ResultSet rs = stmnt.executeQuery(viewSql);
				while (rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String address = rs.getString("address");
					String phone = rs.getString("phone");
					String email = rs.getString("email");
					String username = rs.getString("username");
					String password = rs.getString("password");
					
					Customer customer = new Customer(id, name, address, phone, email, username, password);
					customers.add(customer);
					System.out.println("customer:" + customer.toString());
				}
				stmnt.close();
				con.close();
				System.out.println("Searched successfully.");
			}
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return customers;
	}
	public void editCustomer(Customer customer) {
		System.out.println("Edit Customer");
		try {
			
			String updateSql = "update customer set name='"+customer.getName()+"',address='"
			+customer.getAddress()+"',phone='"+customer.getPhone()+"',email='"
					+customer.getEmail()+"',username='"+customer.getUsername()+
					"',password='"+customer.getPassword()+"' where id ="+customer.getId();
			System.out.println("updateSql:" + updateSql);
			
			ConnectionFactory connDB = new ConnectionFactory();
			Connection con = connDB.getConnection();
			
			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				stmnt.executeUpdate(updateSql);
				stmnt.close();
				con.close();
				System.out.println("Customer updated successfully.");
			}
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	public void deleteCustomer(int id) {
		System.out.println("Delete Customer");
		try {
			String deleteSql = "DELETE FROM customer WHERE id=" + id;
			System.out.println("deleteSql:" + deleteSql);

			ConnectionFactory connDB = new ConnectionFactory();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				stmnt.executeUpdate(deleteSql);
				stmnt.close();
				con.close();
				System.out.println("Deleted successfully.");
			}
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}
