package com.app.product;

public class OrderFacade {
    private ProductDAO productDAO;
    private Payment payment;
    private Invoice invoice;
    private Notification notification;

    public OrderFacade() {
        this.productDAO = new ProductDAO();
        this.payment = new Payment();
        this.invoice = new Invoice();
        this.notification = new Notification();
    }

    public void createOrder() {
        Product product = productDAO.getProduct(121);
        payment.makePayment();
        invoice.generateInvoice();
        notification.sendNotification();
    }
}
