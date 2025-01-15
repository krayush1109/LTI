import java.sql.*;
import java.util.ArrayList;
import java.util.List;
 
public class OrderDAO {
 
    // complete the implementation here
    private Connection connection;
    public OrderDAO(){
        try{
            this.connection= DatabaseConnection.getConnection();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public int createOrder(Order order) {
        String query=" INSERT INTO Orders ( customerName,orderTotal) VALUES (?,?)";
        try{
            PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, order.getCustomerName());
            ps.setDouble(2, order.getOrderTotal());
            ps.executeUpdate();
            ResultSet generatedKeys= ps.getGeneratedKeys();
 
            if(generatedKeys.next()){
                order.setOrderId(generatedKeys.getInt(1));
                return order.getOrderId();
            }else
                return -1;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return -1;
    }

    public List<Order> getAllOrders() {
        List<Order> order= new ArrayList<>();
        String query=" SELECT * FROM Orders";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                Order o= new Order();
                o.setOrderId(rs.getInt("orderId"));
                o.setCustomerName(rs.getString("customerName"));
                o.setOrderTotal(rs.getDouble("orderTotal"));
                order.add(o);
            }
            return order;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public Order getOrderById(int orderId) {
        String query= "SELECT * FROM Orders WHERE orderId=?";
        try(PreparedStatement ps= connection.prepareStatement(query)){
            ps.setInt(1, orderId);
            ResultSet rs= ps.executeQuery();
            if(rs.next()){
                Order o= new Order();
                o.setOrderId(rs.getInt("orderId"));
                o.setCustomerName(rs.getString("customerName"));
                o.setOrderTotal(rs.getDouble("orderTotal"));
                return o;
 
            }else{
                return null;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public Order updateOrder(Order order){
        String query="UPDATE Orders SET orderId=?, customerName=?, orderTotal=?  WHERE orderId=?";
        try(PreparedStatement ps= connection.prepareStatement(query)){
            ps.setInt(1, order.getOrderId());
            ps.setString(2, order.getCustomerName());
            ps.setDouble(3,order.getOrderTotal());
            ps.setInt(4, order.getOrderId());
 
            ps.executeUpdate();
            return order;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    
    public void deleteOrder(int orderId) {
        String query= "DELETE FROM Orders WHERE orderId=?";
        try(PreparedStatement ps= connection.prepareStatement(query)){
            ps.setInt(1, orderId);
            ps.executeUpdate();
           
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void close () {
        try {
            if(connection != null)
                connection.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}