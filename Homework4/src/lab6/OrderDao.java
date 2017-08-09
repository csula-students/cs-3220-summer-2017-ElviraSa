package lab6;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class OrderDao implements DAO<NOrder> {
	public void add(NOrder entry) {
        Database db = new Database();
        try (Connection c = db.connection()) {
            PreparedStatement pstmt = c.prepareStatement("INSERT INTO orders (item_id,item_img,castomer_name,created,statuse) VALUES ( ?,?,?,?,?)");
            pstmt.setInt(1, entry.getItem_id());
            pstmt.setString(2, entry.getItem_img());
            pstmt.setString(3, entry.getCastomer_name());
            pstmt.setDate(4,entry.getCreated());
            pstmt.setString(5, entry.getStatuse()); 
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	@Override
	public List<NOrder> list() {
		 List<NOrder> list = new ArrayList<>();
	        Database db = new Database();
	        try (Connection c = db.connection()) {
	            Statement stmt = c.createStatement();
	            ResultSet rs = stmt.executeQuery("SELECT * FROM orders");
	            while (rs.next()) {
	                list.add(new NOrder(
	                    rs.getInt("order_id"),
	                    rs.getInt("item_id"),
	                    rs.getString("item_img"),
	                    rs.getString("castomer_name"),
	                    rs.getDate ("created"),
	                    rs.getString("statuse")
	                ));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return list;
	        }
	        return list;
	    }
	

	@Override
	public Optional<NOrder> get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(NOrder entry) {
		   Database db = new Database();
	        try (Connection c = db.connection()) {
	            PreparedStatement pstmt = c.prepareStatement("Update orders set statuse=? where order_id=?");
	            pstmt.setString(1, entry.getStatuse()); 
	            pstmt.setInt(2, entry.getOrder_id());
	            pstmt.execute();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
		
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}


}
