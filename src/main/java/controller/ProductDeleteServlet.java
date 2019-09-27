package controller;

import model.Invoice;
import model.Product;
import services.InvoiceService;
import services.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/product-delete")
public class ProductDeleteServlet extends HttpServlet {
    ProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long productId = Long.parseLong(req.getParameter("productId"));
        Optional<Product> productOptional = productService.getProduct(productId);

        if (productOptional.isPresent()){
            productService.deleteProduct(productOptional.get());
        }
        resp.sendRedirect("/invoice-list");
    }
}
