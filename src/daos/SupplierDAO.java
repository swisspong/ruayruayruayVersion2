package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import DB.ConnectionFactory;

import models.Supplier;

public class SupplierDAO {
	public void addSupplier(Supplier supplier) {
		System.out.println("Add Supplier");
		try {
			String insertSql = "INSERT INTO supplier (name,address,phone,email) VALUES ('"
					+supplier.getName()+"','"+supplier.getAddress()+"','"+supplier.getPhone()+"','"+supplier.getEmail()+"');"; 
			System.out.println("insertSql:" + insertSql);

			ConnectionFactory connDB = new ConnectionFactory();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				stmnt.execute(insertSql);
				stmnt.close();
				con.close();
				System.out.println("Supplier added successfully.");
			}
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	public Vector<Supplier>  viewSuppliers() {
		System.out.println("View Suppliers");
		Vector<Supplier> suppliers = null;
		
		try {
			String viewSql = "SELECT * FROM supplier";
			System.out.println("selectSql:" + viewSql);
			
			suppliers = new Vector<Supplier>();

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
					Supplier supplier = new Supplier(id, name, address, phone, email);
					suppliers.add(supplier);
					System.out.println("supplier:" + supplier.toString());
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
		return suppliers;
	}
	public void editSupplier(Supplier supplier) {
		System.out.println("Edit Supplier");
		try {
			
			String updateSql = "update supplier set name='"+supplier.getName()+"',address='"
			+supplier.getAddress()+"',phone='"+supplier.getPhone()+"',email='"
					+supplier.getEmail()+"' where id ="+supplier.getId();
			System.out.println("updateSql:" + updateSql);
			
			ConnectionFactory connDB = new ConnectionFactory();
			Connection con = connDB.getConnection();
			
			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				stmnt.executeUpdate(updateSql);
				stmnt.close();
				con.close();
				System.out.println("Supplier updated successfully.");
			}
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	public void deleteSupplier(int id) {
		System.out.println("Delete Supplier");
		try {
			String deleteSql = "DELETE FROM supplier WHERE id=" + id;
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
