package transactionexample.dao;

import transactionexample.entity.Transaction;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class CardsDAOImpl implements CardsDAO {

    private Connection connection = null;
    private PreparedStatement psAllTransactions = null;
    private PreparedStatement psInsertTransaction = null;
    private ResultSet resultSet = null;

    public CardsDAOImpl() {
        initialize();
    }

    public void initialize() {
        try {
            Properties dbProps = new Properties();
            dbProps.load(new FileInputStream("Application.properties"));
            String dbUrl = dbProps.getProperty("db.url");
            String dbUser = dbProps.getProperty("db.username");
            String dbPassword = dbProps.getProperty("db.password");
            connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            psAllTransactions = connection.prepareStatement("select * from ideas.transactions");

            psInsertTransaction = connection.prepareStatement("insert into ideas.transactions" +
                    "('cardNo','amount','txDate','status') " +
                    "values (?,?,?,?)");
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    List<Transaction> readDataBase() throws Exception {
        try {

            List<Transaction> result = new ArrayList<>();
            resultSet = psAllTransactions.executeQuery();
            while (resultSet.next()) {
                long cardno = resultSet.getLong("cardno");
                float amount = resultSet.getFloat("amount");
                int status = resultSet.getInt("status");
                Date date = resultSet.getDate("txndate");
                result.add(new Transaction(cardno, amount, date, status));
            }
            return result;
        } catch (Exception e) {
            throw e;
        } finally {
            psAllTransactions.close();
            resultSet.close();
            connection.close();
        }

    }

    boolean writeDataBase(Transaction transaction) throws Exception {
        try {

            psInsertTransaction.setLong(1, transaction.getCardNo());
            psInsertTransaction.setFloat(2, transaction.getAmount());
            psInsertTransaction.setDate(3, (Date) transaction.getTnxDate());
            psInsertTransaction.setInt(4, transaction.getStatus());
            psInsertTransaction.executeUpdate();

            return true;

        } catch (Exception e) {
            return false;
        } finally {
            psInsertTransaction.close();
            connection.close();
        }

    }

    @Override
    public List<Transaction> getAllTransactions() throws Exception {
        return readDataBase();
    }

    @Override
    public boolean insert(Transaction transaction) throws Exception {
        return writeDataBase(transaction);
    }
}
