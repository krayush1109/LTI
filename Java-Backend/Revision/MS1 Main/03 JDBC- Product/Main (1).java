// import java.util.HashSet;
// import java.util.Set;

public class Main {
    public static void main(String[] args) {   
        ProductDAO productDAO = new ProductDAO();
        Product product = new Product();
        product.setProductId(1);
        product.setProductName("Product first");
        product.setQuantity(150);

        int productId = productDAO.createProduct(product);
        System.out.println("Product created with ID: " + productId);   

    }
}
