package lab6;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

public class FoodItemDao implements DAO<Food> {
    public List<Food> list() {
        List<Food> list = new ArrayList<>();
        Database db = new Database();
        try (Connection c = db.connection()) {
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM food_items");
            while (rs.next()) {
                list.add(new Food(
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

    public Optional<Food> get(int id) {
        return Optional.empty();
    }

    public void add(Food entry) {
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

    public void update(Food entry) {

    }

    public void delete(int id) {
    }
}