package transactionexample.entity;

import java.util.Date;

public class Transaction implements Comparable<Transaction>{

    private long cardNo;
    private float amount;
    private Date tnxDate;
    private int status;

    public Transaction(long cardNo, float amount, Date tnxDate, int status) {
        this.cardNo = cardNo;
        this.amount = amount;
        this.tnxDate = tnxDate;
        this.status = status;
    }

    public long getCardNo() {
        return cardNo;
    }

    public void setCardNo(long cardNo) {
        this.cardNo = cardNo;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Date getTnxDate() {
        return tnxDate;
    }

    public void setTnxDate(Date tnxDate) {
        this.tnxDate = tnxDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("card no : %d , Amount : %f, txndate : %s, Status : %d \n", cardNo,amount,tnxDate,status);
    }

    @Override
    public int compareTo(Transaction transaction) {
        return Float.compare(this.amount, transaction.getAmount());
    }
}
