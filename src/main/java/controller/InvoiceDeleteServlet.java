package controller;

import model.Invoice;
import services.InvoiceService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/invoice-delete")
public class InvoiceDeleteServlet extends HttpServlet {
    InvoiceService invoiceService = new InvoiceService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long invoiceId = Long.parseLong(req.getParameter("invoiceId"));
        Optional<Invoice> invoiceOptional = invoiceService.getInvoice(invoiceId);

        if (invoiceOptional.isPresent()){
            invoiceService.deleteInvoice(invoiceOptional.get());
        }
        resp.sendRedirect("/invoice-list");
    }
}
