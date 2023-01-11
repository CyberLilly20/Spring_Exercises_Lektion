package se.lexicon.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.lexicon.dao.AccountDao;
import se.lexicon.dao.CustomerDao;
import se.lexicon.dao.TransactionDao;
import se.lexicon.exception.DataNotFoundException;
import se.lexicon.exception.InsufficientFoundsException;
import se.lexicon.model.Account;
import se.lexicon.model.Customer;
import se.lexicon.model.Transaction;
import se.lexicon.model.TransactionType;
import se.lexicon.service.TransactionService;

import java.util.Optional;


@Component
public class TransactionServiceImpl implements TransactionService {

    CustomerDao customerDao;
    AccountDao accountDao;
    TransactionDao transactionDao;
    @Autowired

    public TransactionServiceImpl(CustomerDao customerDao, AccountDao accountDao, TransactionDao transactionDao) {
        this.customerDao = customerDao;
        this.accountDao = accountDao;
        this.transactionDao = transactionDao;
    }



    @Override
    public Transaction moneyTransfer(Long customerId, double amount, TransactionType type) throws DataNotFoundException, InsufficientFoundsException {
       if (customerId == null)throw new IllegalArgumentException("customer id was null");
      /*Optional<Customer> optionalCustomer= customerDao.findById(customerId);
      if (!optionalCustomer.isPresent())throw new DataNotFoundException("customer id was not valid");*/

      Customer customer= customerDao.findById(customerId)
              .orElseThrow(()-> new DataNotFoundException("customer id was not valid"));
        Account account = customer.getAccount();
        if(type.equals(TransactionType.DEPOSIT))account.deposit(amount);
        else account.withdraw(amount);

         accountDao.updateBalance(account);
         Transaction transactionData = new Transaction(customer,type,amount);
         Transaction createdTransaction = transactionDao.create(transactionData);

        return createdTransaction;
    }
}
