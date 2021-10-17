package daos;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import DB.ConnectionFactory;
import models.Good;

import models.Supplier;
import models.SupplierGood;

public class SupplierGoodDAO {
	
	public Vector<SupplierGood> findBySupId(Supplier sup){
		Vector<SupplierGood> supGoods =null;
		try {
			String viewSql = "SELECT * FROM sup_good WHERE id_sup="+sup.getId();
			System.out.println("selectSql:" + viewSql);
			
			supGoods = new Vector<SupplierGood>();

			ConnectionFactory connDB = new ConnectionFactory();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				ResultSet rs = stmnt.executeQuery(viewSql);
				while (rs.next()) {
					int id = rs.getInt("id");
					int id_sup = rs.getInt("id_sup");
					int id_good = rs.getInt("id_good");
					double price = rs.getDouble("price");
					SupplierGood supGood = new SupplierGood(id, id_sup, id_good, price);
					supGoods.add(supGood);
					System.out.println("supGood:" + supGood.toString());
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
		return supGoods; 
	}
	public void addSupGood(SupplierGood supGood) {
		System.out.println("Add SupplierGood");
		try {
			String insertSql = "INSERT INTO sup_good (id_sup,id_good,price) VALUES ("+supGood.getId_supplier()+","+supGood.getId_good()+","+supGood.getPrice()+");";
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
	public Vector<SupplierGood>  viewSupGood() {
		System.out.println("View Sup_Good");
		Vector<SupplierGood> supGoods = null;
		
		try {
			String viewSql = "SELECT * FROM sup_good";
			System.out.println("selectSql:" + viewSql);
			
			supGoods = new Vector<SupplierGood>();

			ConnectionFactory connDB = new ConnectionFactory();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				ResultSet rs = stmnt.executeQuery(viewSql);
				while (rs.next()) {
					int id = rs.getInt("id");
					int id_sup = rs.getInt("id_sup");
					int id_good = rs.getInt("id_good");
					double price = rs.getDouble("price");
					SupplierGood supGood = new SupplierGood(id, id_sup, id_good, price);
					supGoods.add(supGood);
					System.out.println("supGood:" + supGood.toString());
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
		return supGoods;
	}
	public Vector<SupplierGood>   viewSupGoodJoin() {
		System.out.println("View Sup_Good");
		Vector<SupplierGood> supGoods = null;
		try {
			String viewSql = "SELECT * FROM sup_good INNER JOIN goods ON sup_good.id_good = goods.id INNER JOIN supplier ON sup_good.id_sup = supplier.id order by sup_good.id;";
			System.out.println("selectSql:" + viewSql);
			
			supGoods = new Vector<SupplierGood>();
			
			ConnectionFactory connDB = new ConnectionFactory();
			Connection con = connDB.getConnection();
			
			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				ResultSet rs = stmnt.executeQuery(viewSql);
				while (rs.next()) {
					int id = rs.getInt("id");
					int id_sup = rs.getInt("id_sup");
					int id_good = rs.getInt("id_good");
					double price = rs.getDouble("price");
					String goodName = rs.getString("goods.name");
					String supName = rs.getString("supplier.name");
					Good good = new Good();
					good.setId(id_good);
					good.setName(goodName);
					Supplier supplier = new Supplier();
					supplier.setId(id_sup);
					supplier.setName(supName);
					SupplierGood supGood = new SupplierGood(id, id_sup, id_good, price);
					supGood.setGood(good);
					supGood.setSupplier(supplier);
					supGoods.add(supGood);
					System.out.println("supGood:" + supGood.toString());
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
		return supGoods;
	}
	public void editSupGood(SupplierGood supGood) {
		System.out.println("Edit Sup_Good");
		try {
			
			String updateSql = "update sup_good set id_sup="+supGood.getId_supplier()+",id_good="
			+supGood.getId_good()+",price="+supGood.getPrice()+" where id ="+supGood.getId();
			
			System.out.println("updateSql:" + updateSql);
			
			ConnectionFactory connDB = new ConnectionFactory();
			Connection con = connDB.getConnection();
			
			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				stmnt.executeUpdate(updateSql);
				stmnt.close();
				con.close();
				System.out.println("Sup_good updated successfully.");
			}
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	public void deleteSupGood(int id) {
		System.out.println("Delete Sup_good");
		try {
			String deleteSql = "DELETE FROM sup_good WHERE id=" + id;
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
