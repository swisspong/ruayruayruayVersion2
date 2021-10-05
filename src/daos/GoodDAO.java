package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import DB.ConnectionFactory;

import models.Good;



public class GoodDAO {
	public void addGood(Good good) {
		System.out.println("Add Good");
		try {
			String insertSql = "INSERT INTO goods (name,price,description,stock) VALUES ('"+good.getName()+"',"+good.getPrice()+",'"+good.getDescription()+"',"+good.getStock()+");"; 
			System.out.println("insertSql:" + insertSql);

			ConnectionFactory connDB = new ConnectionFactory();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				stmnt.execute(insertSql);
				stmnt.close();
				con.close();
				System.out.println("Good added successfully.");
			}
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	public Vector<Good>  viewGoods() {
		System.out.println("View Good");
		Vector<Good> goods = null;
		
		try {
			String viewSql = "SELECT * FROM goods";
			System.out.println("selectSql:" + viewSql);
			
			goods = new Vector<Good>();

			ConnectionFactory connDB = new ConnectionFactory();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				ResultSet rs = stmnt.executeQuery(viewSql);
				while (rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					double price = rs.getDouble("price");
					String desc = rs.getString("description");
					int stock = rs.getInt("stock");
					Good good = new Good(id, name, desc, price, stock);
					goods.add(good);
					System.out.println("good:" + good.toString());
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
		return goods;
	}
	
	public void editGood(Good good) {
		System.out.println("Edit Good");
		try {
			
			String updateSql = "update goods set name='"+good.getName()+"',price="
			+good.getPrice()+",stock="+good.getStock()+",description='"
					+good.getDescription()+"' where id ="+good.getId();
			System.out.println("updateSql:" + updateSql);
			
			ConnectionFactory connDB = new ConnectionFactory();
			Connection con = connDB.getConnection();
			
			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				stmnt.executeUpdate(updateSql);
				stmnt.close();
				con.close();
				System.out.println("Good updated successfully.");
			}
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	public void deleteGood(int id) {
		System.out.println("Delete Good");
		try {
			String deleteSql = "DELETE FROM goods WHERE id=" + id;
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
