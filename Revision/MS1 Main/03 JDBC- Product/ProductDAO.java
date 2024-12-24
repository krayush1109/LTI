import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private Connection connection;
    
    // public ProductDAO(){}
    public ProductDAO() {
        try {
            this.connection = DatabaseConnection.getConnection();            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int createProduct(Product product) {
        String sql = "INSERT INTO Product (productId, productName, quantity) VALUES(?,?,?)";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, product.getProductId());
            pstmt.setString(2, product.getProductName());
            pstmt.setInt(3, product.getQuantity());
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                ResultSet generatedKeys = pstmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Creating product failed, no ID obtained.");
                }
                
            } else {
                throw new SQLException("Creating product failed.");
            }
            
        } catch(Exception e) {
            e.printStackTrace();
            return -1;
        }     
    }
    
    public List<Product> getAllProducts() {
        String sql = "SELECT * FROM Product";
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getInt("productId"));
                product.setProductName(rs.getString("productName"));
                product.setQuantity(rs.getInt("quantity"));
                products.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
        
    }

    public Product getProductById(int productId) {
        String sql = "SELECT * FROM Product WHERE productId=?";
        Product product = null;
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, productId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                product = new Product();
                product.setProductId(rs.getInt("productId"));
                product.setProductName(rs.getString("productName"));
                product.setQuantity(rs.getInt("quantity"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return product;
    }

    public Product updateProduct(Product product) {
        String sql = "UPDATE Product SET productName=?, quantity=? WHERE productId=?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, product.getProductName());
            pstmt.setInt(2, product.getQuantity());
            pstmt.setInt(3, product.getProductId());
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                return product;
            } else {
                throw new SQLException("Updating product failed.");
            }
            
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }     
    }

    public void deleteProduct(int productId) {
        String sql = "DELETE FROM Product WHERE productId=?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, productId);
            pstmt.executeUpdate();
            
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

        public void close(){
            try {
                if(connection != null){
                    connection.close();
                }            
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    
} 