package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import DB.ConnectionFactory;
import models.Customer;
import models.Good;
import models.Invoice;
import models.InvoiceDetail;
import models.Supplier;


public class InvoiceDetailDAO {
//	String updateSql = "UPDATE `INVOICE-DETAILS` SET " 
//			+ "status=1"
//			+ " WHERE ID=" + invD;
	public void updateStatus(int id) throws SQLException,ClassNotFoundException{
		String sql = "UPDATE invoice_detail SET status=1 WHERE ID ="+id;
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
	public Vector<InvoiceDetail>  viewInvoiceDetailById(int invoiceId) {
		System.out.println("View Invoice");
		Vector<InvoiceDetail> invDs = null;
		
		try {
			String viewSql = "SELECT * FROM invoice_detail WHERE id_inv="+invoiceId;
			System.out.println("selectSql:" + viewSql);
			
			invDs = new Vector<InvoiceDetail>();

			ConnectionFactory connDB = new ConnectionFactory();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				ResultSet rs = stmnt.executeQuery(viewSql);
				while (rs.next()) {
					int id = rs.getInt("id");
					int idInv = rs.getInt("id_inv");
					int status = rs.getInt("status");
					int idGood = rs.getInt("id_good");
					double amount = rs.getDouble("amount");
					int qty = rs.getInt("quantity");
					Good good =new Good();
					good.setId(idGood);
					Invoice invoice = new Invoice();
					invoice.setId(idInv);
					InvoiceDetail invD = new InvoiceDetail(id,invoice,status,good, amount,qty);
					invDs.add(invD);
					System.out.println("invD:" + invD.toString());
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
		return invDs;
	}
	public void addInvoiceDetail(InvoiceDetail invD) throws SQLException, ClassNotFoundException {
		Customer customer = null;
		String sql = "INSERT INTO invoice_detail(id_inv,status,id_good,quantity,amount) VALUES("
		+invD.getInvoice().getId()+","+invD.getStatus()+","+invD.getGood().getId()+","+invD.getQuantity()+","+invD.getAmount()+")";
		System.out.println(sql);
		ConnectionFactory connDB = new ConnectionFactory();
		Connection con = connDB.getConnection();
		Statement stmnt = null;
		if (con != null) {
			stmnt = con.createStatement();
			stmnt.execute(sql);
			stmnt.close();
			con.close();
		}
	}
	public double sumAmount(int invId) throws SQLException,ClassNotFoundException {
		double total=0;
		String sql = "SELECT SUM(amount) total FROM invoice_detail WHERE id_inv = "+invId+";";
		System.out.println(sql);
		ConnectionFactory connDB = new ConnectionFactory();
		Connection con = connDB.getConnection();
		Statement stmnt = null;
		if (con != null) {
			stmnt = con.createStatement();
			ResultSet rs = stmnt.executeQuery(sql);
			if(rs.next()) {
				total=rs.getDouble("total");
			}
			stmnt.close();
			con.close();
		}
		return total;
	}
}
