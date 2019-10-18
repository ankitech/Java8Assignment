package transactionexample;

import transactionexample.dao.CardsDAO;
import transactionexample.dao.CardsDAOImpl;
import transactionexample.entity.Transaction;
import java.util.List;
import java.util.function.Predicate;

public class Client {

    public static void main(String[] args) throws Exception {

        CardsDAO cards = new CardsDAOImpl();

        System.out.println("List of all transactions");
        List<Transaction> allTransactions = cards.getAllTransactions();
        System.out.println(allTransactions);

        System.out.println("List of all transactions above 5000");
        Predicate<Transaction> amtGt5000 = tx -> tx.getAmount() > 5000;
        filter(allTransactions,amtGt5000);

        System.out.println("List of all transactions below 2000");
        Predicate<Transaction> amtLt2000 = tx -> tx.getAmount() < 2000;
        filter(allTransactions,amtLt2000);

        System.out.println("List of all transactions that failed");
        Predicate<Transaction> hasTxnFailed = tx -> tx.getStatus() == 0;
        filter(allTransactions,hasTxnFailed);

    }

    private static void filter(List<Transaction> list, Predicate<Transaction> condition){


        for (Transaction transaction :
                list) {
            if (condition.test(transaction)){
                System.out.print(transaction);
            }
        }
    }

}
