package homeWork38.repositories;

import homeWork38.models.Product;

public class ProductsRepository {
    private static final int MAX_PRODUCTS_COUNT = 100;
    private Product[] products;
    private int productsCount;

    public ProductsRepository() {
        this.products = new Product[MAX_PRODUCTS_COUNT];
    }

    public void save(Product product) {
        this.products[productsCount] = product;
        this.productsCount++;
    }

    public Product[] findAll() {
        Product[] copy = new Product[productsCount];
        System.arraycopy(products, 0, copy, 0, productsCount);
        return copy;
    }

    public Product findByTitle(String title) {
        for (int i = 0; i < productsCount; i++) {
            if (products[i].getTitle().equals(title)) {
                return products[i];
            }
        }
        return null;
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }

    public int getProductsCount() {
        return productsCount;
    }

    public void setProductsCount(int productsCount) {
        this.productsCount = productsCount;
    }
}