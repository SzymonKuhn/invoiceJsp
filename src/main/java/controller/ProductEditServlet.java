package controller;

import model.Product;
import model.TaxType;
import services.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/product-edit")
public class ProductEditServlet extends HttpServlet {
    ProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long productId = Long.parseLong(req.getParameter("productId"));
        Optional<Product> productOptional = productService.getProduct(productId);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            req.setAttribute("productId", product.getId());
            req.setAttribute("productName", product.getName());
            req.setAttribute("productPrice", product.getPrice());
            req.setAttribute("productTaxType", product.getTaxType());
            req.setAttribute("productStock", product.getStock());
            req.setAttribute("invoiceId", product.getInvoice().getId());
            req.setAttribute("invoiceReleaseDate", product.getInvoice().getDateOfRelease()); //chyba potrzeba
            // przekazania dateOfRelease ponieważ wyświetlamy listę wszystkich produktów i w zależności
            // od tego pola udostępniamy edycję produktu
        }
        req.getRequestDispatcher("product-add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long productId = Long.parseLong(req.getParameter("productId"));
        Optional<Product> productOptional = productService.getProduct(productId);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            product.setName(req.getParameter("productName"));
            product.setPrice(Double.parseDouble(req.getParameter("productPrice")));
            product.setTaxType(TaxType.valueOf(req.getParameter("taxType")));
            product.setStock(Integer.parseInt(req.getParameter("productStock")));
            productService.addProduct(product);
        }
        resp.sendRedirect("/invoice-list");
    }
}
