package transactionexample.dao;

import transactionexample.entity.Transaction;

import java.util.List;

public interface CardsDAO {

    List<Transaction> getAllTransactions() throws Exception;
    boolean insert(Transaction transaction) throws Exception;
}
