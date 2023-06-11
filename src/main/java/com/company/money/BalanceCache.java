package com.company.money;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

import com.company.money.Transaction;

import java.time.LocalDate; 

//simple cache for monthly and current total balance. When real transactionAPI is used, update to real cache redis etc..
public class BalanceCache {
    
    public static HashMap<Integer, Balance> customerBalances = new HashMap<>();
    public static LocalDate balanceDate;
    public static int balance;

    public static void updateCache(int customerId, List<Transaction> transactions){
        Balance balance = customerBalances.get(customerId);
        if (balance == null){
            balance = new Balance();
        }


        customerBalances.put(customerId, balance);
    }

    //balances  in format month/year balance
    public static Balance readMonthlyBalances(int customerId){
        return customerBalances.get(customerId);
    }
}
