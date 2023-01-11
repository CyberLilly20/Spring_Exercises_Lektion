package se.lexicon.service;

import se.lexicon.exception.DataNotFoundException;
import se.lexicon.exception.InsufficientFoundsException;
import se.lexicon.model.Transaction;
import se.lexicon.model.TransactionType;

public interface TransactionService {


    Transaction moneyTransfer(Long customerId, double amount, TransactionType type)throws DataNotFoundException, InsufficientFoundsException;

}
