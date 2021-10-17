package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import DB.ConnectionFactory;

import models.Invoice;
import models.Supplier;


public class InvoiceDAO {
	public Vector<Invoice>  viewInvoices() {
		System.out.println("View Invoice");
		Vector<Invoice> invoices = null;
		
		try {
			String viewSql = "SELECT * FROM invoice";
			System.out.println("selectSql:" + viewSql);
			
			invoices = new Vector<Invoice>();

			ConnectionFactory connDB = new ConnectionFactory();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				ResultSet rs = stmnt.executeQuery(viewSql);
				while (rs.next()) {
					int id = rs.getInt("id");
					int idSup = rs.getInt("id_sup");
					String date = rs.getString("date");
					double total = rs.getDouble("total");
					Supplier sup = new Supplier();
					sup.setId(idSup);
					Invoice invoice = new Invoice(id,sup, date, total);
					invoices.add(invoice);
					System.out.println("invoice:" + invoice.toString());
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
		return invoices;
	}
	public int addInvoieAndGetKey(Invoice invoice) throws SQLException, ClassNotFoundException {
		System.out.println("Add Order");
		int candidateId = 0;

		String insertSql = "INSERT INTO invoice (date,total,id_sup) VALUES (NOW(),?,?);";
		System.out.println("insertSql:" + insertSql);

		ConnectionFactory connDB = new ConnectionFactory();
		try (Connection con = connDB.getConnection();
				PreparedStatement pstmt = con.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS);) {
			ResultSet rs=null;
			pstmt.setDouble(1, invoice.getTotal());
			pstmt.setInt(2, invoice.getSupplier().getId());
			int rowAffected = pstmt.executeUpdate();
			if (rowAffected == 1) {
				rs = pstmt.getGeneratedKeys();
				if (rs.next()) {					
					candidateId = rs.getInt(1);
				}
			}
			pstmt.close();
			con.close();
		}
		return candidateId;
	}
	public void updateTotal(Invoice invoice) throws SQLException,ClassNotFoundException{
		String sql = "UPDATE invoice SET TOTAL="+invoice.getTotal()+" WHERE ID ="+invoice.getId();
		System.out.println(sql);
		ConnectionFactory connDB = new ConnectionFactory();
		Connection con = connDB.getConnection();
		Statement stmnt =null;
		if(con !=null) {
			stmnt=con.createStatement();
			stmnt.execute(sql);
			stmnt.close();
			con.close();
		}
	}
}
