package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Product;


public class ProductDAO {
    private Connection connection;

    public ProductDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Product> getAllProducts() throws SQLException {
        List<Product> products = new ArrayList<>();
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM 商品");
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("商品ID"));
                product.setName(rs.getString("商品名"));
                product.setPrice(rs.getInt("単価"));
                product.setDescription(rs.getString("商品説明"));
                products.add(product);
            }
        }
        return products;
    }
}