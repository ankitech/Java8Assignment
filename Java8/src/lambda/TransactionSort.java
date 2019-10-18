package lambda;

import transactionexample.entity.Transaction;

import java.util.*;

public class TransactionSort {

    public static void main(String[] args) {

        TreeMap<Long, Transaction> allTransaction = new TreeMap<>((t1, t2)-> -t1.compareTo(t2));

        allTransaction.put(101L, new Transaction(101L, 1000f,new Date(10,01,02),1));
        allTransaction.put(104L, new Transaction(104L, 3000f,new Date(10,01,02),1));
        allTransaction.put(103L, new Transaction(103L, 5000f,new Date(10,01,02),1));
        allTransaction.put(109L, new Transaction(109L, 2000f,new Date(10,01,02),1));
        allTransaction.put(108L, new Transaction(108L, 6000f,new Date(10,01,02),1));

        System.out.println(allTransaction);


        List<Transaction> transactionList = new ArrayList<>();

        transactionList.add(new Transaction(101L, 1000f,new Date(10,01,02),1));
        transactionList.add(new Transaction(104L, 3000f,new Date(10,01,02),1));
        transactionList.add(new Transaction(103L, 5000f,new Date(10,01,02),1));
        transactionList.add(new Transaction(109L, 2000f,new Date(10,01,02),1));
        transactionList.add(new Transaction(108L, 6000f,new Date(10,01,02),1));

    }
}
