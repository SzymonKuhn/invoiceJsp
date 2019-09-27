package controller;

import model.Invoice;
import services.InvoiceService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet ("/invoice-add")
public class InvoiceAddServlet extends HttpServlet {
    private final InvoiceService invoiceService = new InvoiceService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("invoice-add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String clientName = req.getParameter("clientName");
        String clientAddress = req.getParameter("clientAddress");
        String clientNip = req.getParameter("clientNip");

        Invoice invoice = new Invoice(clientName, clientNip, clientAddress);
        System.out.println(invoice);

        invoiceService.saveOrUpdateInvoice(invoice);
        resp.sendRedirect("/invoice-list");


    }
}
