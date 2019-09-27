package services;

import database.EntityDao;
import model.Invoice;

import java.util.List;
import java.util.Optional;

public class InvoiceService {
    EntityDao entityDao = new EntityDao();

    public InvoiceService() {
    }

    public List<Invoice> getAll () {
        return entityDao.getAll(Invoice.class);
    }

    public void saveOrUpdateInvoice(Invoice invoice) {
        entityDao.saveOrUpdate(invoice);
    }

    public Optional<Invoice> getInvoice (long id) {
        return entityDao.getById(Invoice.class, id);
    }

    public void deleteInvoice(Invoice invoice) {
        entityDao.delete(invoice);
    }
}
