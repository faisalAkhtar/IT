/**
   @author Faisal Akhtar
 */
package java01;

import java.util.ArrayList;
class Bank {

    private ArrayList<BankAccount> accounts;

    public Bank()
    {
        accounts = new ArrayList<BankAccount>();
    }
    
    void addAccount(BankAccount a)
    {
        accounts.add(a);
    }
    
    float getTotalBalance()
    {
        float total = 0;
        for (BankAccount a : accounts)
            total = total + a.getBalance();
        return total;
    }
    
    int getMaximum()
    {
        if (accounts.isEmpty()) return -1;
        BankAccount getMax = accounts.get(0);
        for (BankAccount a : accounts)
        {
            if (a.getBalance() > getMax.getBalance())
            {
                getMax = a;
            }
        }
        return getMax.getAccountNo();
    }
    
    int getMinimum()
    {
        if (accounts.isEmpty()) return -1;
        BankAccount getMin = accounts.get(0);
        for (BankAccount a : accounts)
        {
            if (a.getBalance() < getMin.getBalance())
            {
                getMin = a;
            }
        }
        return getMin.getAccountNo();
    }
    
    BankAccount findAccount(int accountNumber)
    {
        if (accounts.isEmpty()) return null;
        for (BankAccount a : accounts)
        {
            if (a.getAccountNo()==accountNumber)
                return a;
        }
        return null;
    }
    
    int noOfAccountsWithAtleast(double thresholdBalance)
    {
        if (accounts.isEmpty()) return 0;
        int count = 0;
        for (BankAccount a : accounts)
        {
            if (a.getBalance()>=thresholdBalance)
                count++;
        }
        return count;
    }
}

class BankAccount {
    
    private int accountNumber;
    private float balance;
    
    public BankAccount(int anAccountNumber)
    {
        accountNumber = anAccountNumber;
        balance = 0;
    }
    
    public BankAccount(int anAccountNumber, float initialBalance)
    {
        accountNumber = anAccountNumber;
        balance = initialBalance;
    }
    
    float deposit(float x)
    {
        balance = balance + x;
        return balance;
    }
    
    float withdraw(float x)
    {
        balance = balance - x;
        return balance;
    }
    
    int getAccountNo()
    {
        return accountNumber;
    }
    
    float getBalance()
    {
        return balance;
    }
}

public class Java01 {

    public static void main(String[] args) {
        Bank ironBank = new Bank();
        ironBank.addAccount(new BankAccount(10001, 20000));
        ironBank.addAccount(new BankAccount(10002, 15000));
        ironBank.addAccount(new BankAccount(10003, 25000));
        
        System.out.println("Total balance in Iron-Bank : " + ironBank.getTotalBalance());
        System.out.println("Expected : 60000.0");

        System.out.println("Account with maximum balance : " + ironBank.getMaximum());
        System.out.println("Expected : 1003");
        System.out.println("Account with minimum balance : " + ironBank.getMinimum());
        System.out.println("Expected : 1002");

        double threshold = 20000;
        System.out.println("No of accounts with atleast " + threshold + " balance : " + ironBank.noOfAccountsWithAtleast(threshold));
        System.out.println("Expected : 2");
    }
    
}
