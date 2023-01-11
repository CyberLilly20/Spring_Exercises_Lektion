package se.lexicon.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import se.lexicon.config.AppConfig;
import se.lexicon.exception.DataNotFoundException;
import se.lexicon.model.Account;

import java.util.Optional;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppConfig.class)
public class AccountDaoTest {
    @Autowired
    AccountDao testObject;

    Account createdAccount;

    @BeforeEach
    public void setup() {
        Account accountData = new Account(100);
        createdAccount = testObject.create(accountData);

    }

    @Test
    public void findAll() {
        int expectedResult = 1;
        int actualResult = testObject.findAll().size();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void findBuId() {
        Account expectedAccount = new Account(createdAccount.getId(), 100.00);
        Optional<Account> optionalAccount = testObject.findById(createdAccount.getId());
        Account actualAccount = optionalAccount.orElse(null);
        assertEquals(expectedAccount, actualAccount);
    }

    @Test
    public void remove() {
        assertDoesNotThrow(() -> testObject.remove(createdAccount.getId()));
    }

    @Test
    public void remove_throws_exception() {
        assertThrows(DataNotFoundException.class, () -> testObject.remove(1L));
    }
    //todo: add more unit tests
}
