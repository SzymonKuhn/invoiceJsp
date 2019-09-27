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

@WebServlet("/invoice-edit")
public class InvoiceEditServlet extends HttpServlet {
    InvoiceService invoiceService = new InvoiceService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long invoiceID = Long.parseLong(req.getParameter("invoiceId"));
        Optional<Invoice> invoiceOptional = invoiceService.getInvoice(invoiceID);

        if (invoiceOptional.isPresent()) {
            Invoice invoice = invoiceOptional.get();
            req.setAttribute("invoiceId", invoice.getId());
            req.setAttribute("clientName", invoice.getClientName());
            req.setAttribute("clientAddress", invoice.getClientAddress());
            req.setAttribute("clientNip", invoice.getClientNip());
            req.setAttribute("invoiceDateOfRelease", invoice.getDateOfRelease());
            req.getRequestDispatcher("/invoice-add.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long invoiceId = Long.parseLong(req.getParameter("invoiceId"));
        Optional<Invoice> optionalInvoice = invoiceService.getInvoice(invoiceId);

        if (optionalInvoice.isPresent()) {
            Invoice invoice = optionalInvoice.get();
            invoice.setClientName(req.getParameter("clientName"));
            invoice.setClientAddress(req.getParameter("clientAddress"));
            invoice.setClientNip(req.getParameter("clientNip"));
            invoiceService.saveOrUpdateInvoice(invoice);
        }
        resp.sendRedirect("/invoice-list");
    }
}
