package se.lexicon.dao.impl;

import org.springframework.stereotype.Component;
import se.lexicon.dao.CustomerDao;
import se.lexicon.dao.sequencer.AccountIdGenerator;
import se.lexicon.model.Customer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Component
public class CustomerDaoImpl implements CustomerDao {
    private List<Customer> storage= new ArrayList<>();
    @Override
    public Customer create(Customer customer) {
        if(customer==null)throw new IllegalArgumentException("Customer was null");
        Long accountId= AccountIdGenerator.generateAccountNumber();
        customer.setId(accountId);
        storage.add(customer);
        return customer;
    }

    @Override
    public Optional<Customer> findById(Long id) {
        if (id == null) throw new IllegalArgumentException("Customer was null");
        return storage.stream()//stream source
                .filter(customer -> customer.getId().equals(id))//used intermediate to create a small stream
                .findFirst();// terminal operation used to make a result

    }

    @Override
    public Collection<Customer> findAll() {
        return new ArrayList<>(storage);
    }

    @Override
    public void remove(Long aLong) {

    }
}
