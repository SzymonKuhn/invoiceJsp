package controller;

import model.Invoice;
import model.Product;
import model.TaxType;
import services.InvoiceService;
import services.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@WebServlet("/product-add")
public class ProductAddServlet extends HttpServlet {
    InvoiceService invoiceService = new InvoiceService();
    ProductService productService = new ProductService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long invoiceId = Long.parseLong(req.getParameter("invoiceId"));
        req.setAttribute("invoiceId", invoiceId);
        req.getRequestDispatcher("/product-add.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long invoiceId = Long.parseLong(req.getParameter("invoiceId"));
        Optional<Invoice> invoiceOptional = invoiceService.getInvoice(invoiceId);

        if (invoiceOptional.isPresent()) {
            Invoice invoice = invoiceOptional.get();
            if (invoice.getDateOfRelease() == null) {
                Product product = new Product();
                product.setInvoice(invoice);
                product.setName(req.getParameter("productName"));
                product.setPrice(Double.parseDouble(req.getParameter("productPrice")));
                product.setTaxType(TaxType.valueOf(req.getParameter("taxType")));
                product.setStock(Integer.parseInt(req.getParameter("productStock")));

                productService.addProduct(product);
            }
        }
        resp.sendRedirect("/invoice-list");
    }
}
