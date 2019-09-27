package controller;

import model.Invoice;
import services.InvoiceService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Optional;

@WebServlet ("/invoice-release")
public class InvoiceReleaseServlet extends HttpServlet {
    InvoiceService invoiceService = new InvoiceService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long invoiceId = Long.parseLong(req.getParameter("invoiceId"));
        Optional<Invoice> invoiceOptional = invoiceService.getInvoice(invoiceId);

        if (invoiceOptional.isPresent()) {
            Invoice invoice = invoiceOptional.get();
            if (invoice.getDateOfRelease() == null) {
                invoice.setDateOfRelease(LocalDateTime.now());
            }
            invoiceService.saveOrUpdateInvoice(invoice);
        }
        resp.sendRedirect("/invoice-list");
    }

}
