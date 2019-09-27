package controller;

import services.InvoiceService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet ("/invoice-list")
public class InvoiceListServlet extends HttpServlet {

    InvoiceService invoiceService = new InvoiceService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("invoiceList", invoiceService.getAll());
        req.getRequestDispatcher("invoice-list.jsp").forward(req, resp);
    }


}
