package se.lexicon.dao;

import se.lexicon.exception.DataNotFoundException;
import se.lexicon.model.Account;

public interface AccountDao  extends BaseDao<Account, Long>{

    void updateBalance(Account account) throws DataNotFoundException;
}
