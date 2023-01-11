package se.lexicon.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Transaction {

    private String id;
    private Customer customer;
    private TransactionType type;
    private Double amount;
    private LocalDateTime dateTime;

    public Transaction(Customer customer, TransactionType type, Double amount) {
        this.id = UUID.randomUUID().toString();
        this.customer = customer;
        this.type = type;
        this.amount = amount;
        this.dateTime = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public TransactionType getType() {
        return type;
    }

    public Double getAmount() {
        return amount;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @Override
    public String  toString() {
        return "Transaction{" +
                "id='" + id + '\'' +
                ", customer=" + customer +
                ", type=" + type +
                ", amount=" + amount +
                ", dateTime=" + dateTime +
                '}';
    }
}
