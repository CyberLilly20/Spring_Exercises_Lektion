package se.lexicon.model;

import se.lexicon.exception.InsufficientFoundsException;

import java.util.Objects;

public class Account {

    private Long id;
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public Account(Long id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public void withdraw(double amount) throws InsufficientFoundsException{
        if(amount<= 0) throw new IllegalArgumentException("Amount is nor valid!");
        if(amount> balance) throw new InsufficientFoundsException("Balance is Insufficient ", amount);
        this.balance-= amount;

    }
    public void deposit(double amount){
        if (amount<= 0) throw new IllegalArgumentException("Amount is not valid!");
        this.balance+= amount;


    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return Double.compare(account.getBalance(), getBalance()) == 0 && Objects.equals(getId(), account.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getBalance());
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                '}';
    }
}
