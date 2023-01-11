package se.lexicon.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.lexicon.dao.AccountDao;
import se.lexicon.dao.CustomerDao;
import se.lexicon.exception.DataNotFoundException;
import se.lexicon.model.Account;
import se.lexicon.model.Customer;
import se.lexicon.service.CustomerService;
@Component

public class CustomerServiceImpl implements CustomerService {

    AccountDao accountDao;
    CustomerDao customerDao;

    @Autowired
    public CustomerServiceImpl(AccountDao accountDao, CustomerDao customerDao) {
        this.accountDao = accountDao;
        this.customerDao = customerDao;
    }
   /*@Autowired
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
   @Autowired
    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }*/

    @Override
    public Customer registerCustomer(Customer customerData) {
        //step1: validate the method parameters
        //step2: create a new account for customer
        //step3: add created account to customer
        //step4: create customer
        //step5: return the created customer
        if (customerData == null) throw new IllegalArgumentException("Customer data was null");
        if (customerData.getAccount() == null) throw new IllegalArgumentException("Account data was null");
        Account accountData = customerData.getAccount();
        Account createdAccount = accountDao.create(accountData);
        customerData.setAccount(createdAccount);

        Customer createdCustomer = customerDao.create(customerData);
        return createdCustomer;
    }

    @Override
    public Customer findById(Long id) throws DataNotFoundException {
        if(id == null)throw new IllegalArgumentException("id was null");
        return customerDao.findById(id)
                .orElseThrow(()->new DataNotFoundException("data not found"));

    }
}
