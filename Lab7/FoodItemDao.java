package edu.csula.jaxrs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

public class FoodItemDao implements DAO<FoodItem> {
    public List<FoodItem> list() {
        List<FoodItem> list = new ArrayList<>();
        Database db = new Database();
        try (Connection c = db.connection()) {
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM food_items");
            while (rs.next()) {
                list.add(new FoodItem(
                    rs.getInt("id"),
                    rs.getString("item"),
                    rs.getString("description"),
                    rs.getString ("image"),
                    rs.getDouble("price"),
                    rs.getInt("quantity")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return list;
        }
        return list;
    }

    public Optional<FoodItem> get(int id) {
    	 Optional<FoodItem> cart  = Optional.empty();
		 Database db = new Database();
	        try (Connection c = db.connection()) {
	            PreparedStatement pstmt = c.prepareStatement("SELECT * FROM food_items WHERE food_items.id = ? ");
	            pstmt.setInt(1, id);
	            ResultSet rs = pstmt.executeQuery();
	            
	            if (rs.next()) {
	            	FoodItem editItem = new FoodItem(rs.getInt("id"), rs.getString("item"), rs.getString("description"),
							rs.getString("image"), rs.getDouble("price"),rs.getInt("quantity"));
	                cart = Optional.of(editItem);
	            }
	        }catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return cart;
	}
        
    

    public void add(FoodItem entry) {
        Database db = new Database();
        try (Connection c = db.connection()) {
            PreparedStatement pstmt = c.prepareStatement("INSERT INTO food_items ( item, description,image,price,quantity) VALUES ( ?,?,?,?,?)");
            pstmt.setString(1, entry.getName());
            pstmt.setString(2, entry.getDescription());
            pstmt.setString(3, entry.getImage());
            pstmt.setDouble(4, entry.getPrice());
            pstmt.setInt(5, entry.getQuantity());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(FoodItem entry) {

		Database db = new Database();
        try (Connection c = db.connection()) {
            PreparedStatement pstmt = c.prepareStatement("UPDATE food_items SET item = ?, description = ?, image = ?, price = ?, quantity=? WHERE id = ?");
            pstmt.setString(1, entry.getName());
			pstmt.setString(2, entry.getDescription());
			pstmt.setString(3, entry.getImage());
			pstmt.setDouble(4, entry.getPrice());
			pstmt.setInt(5, entry.getQuantity());
			pstmt.setInt(6, entry.getId());
          
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void delete(int id) {
    	Database db = new Database();
        try (Connection c = db.connection()) {
            PreparedStatement pstmt = c.prepareStatement("DELETE FROM food_items WHERE food_items.id = ? ");
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
		
	}
    }
