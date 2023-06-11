package com.company.money;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

//mock for api developed by another team
public class mockTransactionAPI {

    //generates mock transactions for customer using customer id as a seed for random generator
    public static List<Transaction> fetchTransactions(int customerId){
        //use customerId as seed to get always same transactions per customer
        Random random = new Random(customerId);
        List<Transaction> transactions = new ArrayList<>();
        //choose randomly first transaction date with couple of hard coded parameters
        LocalDate firstTransaction = LocalDate.of(1950, 1, 1).plusDays(random.nextInt(25000));
        //generate transactions upto now (using daycount and for loop for safety, while loop with check for current date was alternative idea)
        long days = ChronoUnit.DAYS.between(firstTransaction, LocalDate.now());
        int balance = 0;
        LocalDate date;
        for (int i = 0; i < days; i++){
            date = firstTransaction.plusDays(i);
            int transactionsPerDay = random.nextInt(100);
            for (int j = 0; j < transactionsPerDay; j++){
                Transaction transaction = new Transaction();
                transaction.date = date;
                int amount = random.nextInt(50000);
                //just simple logic for mock purposes. In future could develop better parameters from real data 
                if (balance > amount){
                    amount = -1 * amount;
                }
                transaction.amount = amount;
                balance += amount;
                transactions.add(transaction);
            }
        }
        return transactions;
    }
}
