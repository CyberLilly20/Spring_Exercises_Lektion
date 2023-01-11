package se.lexicon.dao.impl;

import org.springframework.stereotype.Component;
import se.lexicon.dao.TransactionDao;
import se.lexicon.exception.DataNotFoundException;
import se.lexicon.model.Transaction;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
@Component
public class TransactionDaoImpl implements TransactionDao {

    List<Transaction> storage = new ArrayList<>();
    @Override
    public Transaction create(Transaction transaction) {
        if(transaction == null) throw new IllegalArgumentException("transaction date was null");
        // todo: add more validations...
        storage.add(transaction);
        return transaction;
    }

    @Override
    public Optional<Transaction> findById(String id) {
        if(id == null)throw new IllegalArgumentException("id was null");
       return storage.stream()
               .filter(transaction -> transaction.getId().equals(id))
               .findFirst();

    }

    @Override
    public Collection<Transaction> findAll() {
        return new ArrayList<>(storage);
    }

    @Override
    public void remove(String id) throws DataNotFoundException {
        findById(id).ifPresent(transaction -> storage.remove(transaction));
        throw new DataNotFoundException("Data not found exception");

    }
}
