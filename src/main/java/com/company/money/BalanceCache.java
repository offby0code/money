package com.company.money;

import java.util.ArrayList;
import java.util.List;

import com.company.money.Transaction;

import java.time.LocalDate; 

//simple cache for monthly and current total balance. When real transactionAPI is used, update to real cache redis etc..
public class BalanceCache {
    
    public static List<String> monthlyBalances = new ArrayList<>();
    public static LocalDate balanceDate;
    public static int balance;

    public static void updateCache(int customerId, List<Transaction> transactions){

    }

    //balances  in format month/year balance
    public static List<String> readMonthlyBalances(int customerId){
        return monthlyBalances;
    }

    public static int readBalance(){
        return balance;
    }
}
