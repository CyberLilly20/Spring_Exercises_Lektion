package se.lexicon.dao;

import se.lexicon.exception.DataNotFoundException;
import se.lexicon.model.Customer;

import java.util.List;

public interface CustomerDao extends BaseDao<Customer, Long> {

    List<Customer> finBuName(String firstName) ;
}
