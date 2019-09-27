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
import java.util.List;
import java.util.Optional;

@WebServlet("/product-list")
public class ProductListServlet extends HttpServlet {
    ProductService productService = new ProductService();
    InvoiceService invoiceService = new InvoiceService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> productList = null;
        if (req.getParameter("invoiceId") != null) {
            long invoiceId = Long.parseLong(req.getParameter("invoiceId"));
            Optional<Invoice> invoiceOptional = invoiceService.getInvoice(invoiceId);
            if (invoiceOptional.isPresent()) {
                Invoice invoice = invoiceOptional.get();
                productList = invoice.getProduct();
                req.setAttribute("invoice", invoice);

            }

        } else {
            productList = productService.getAll();
        }
        req.setAttribute("productList", productList);
        req.getRequestDispatcher("/product-list.jsp").forward(req, resp);
    }
}
