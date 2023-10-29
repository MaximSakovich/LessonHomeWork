package homeWork38.services;

import homeWork38.models.Product;
import homeWork38.repositories.ProductsRepository;

public class ProductsService {
    private ProductsRepository productsRepository;
    private OrderService orderService;

   public ProductsService(ProductsRepository productsRepository, OrderService orderService) {
        this.productsRepository = productsRepository;
       this.orderService = orderService;
   }

    public void addProduct(String title, double price, String description, int residual) {
        Product product = new Product(title, price, description, residual);
        productsRepository.save(product);
    }

    public int getProductStock(String productTitle, int count) {
        Product product = productsRepository.findByTitle(productTitle);
        if (product != null) {
            int reserved = orderService.getTotalReservedProduct(productTitle);
            int remainingStock = product.getResidual() - reserved - count;
            if (remainingStock >= 0) {
                return remainingStock;
            } else {
                System.err.println();
                return -1;
            }
        }
        System.err.println();
        return -2;
    }
    public Product[] getAllProducts() {
        return productsRepository.findAll();
    }
}