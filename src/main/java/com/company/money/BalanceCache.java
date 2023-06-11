package com.company.money;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

import java.util.Collections;

import java.time.LocalDate; 

//simple cache for monthly and current total balance. When real transactionAPI is used, update to real cache redis etc..
public class BalanceCache {
    
    public static HashMap<Integer, Balance> customerBalances = new HashMap<>();

    public static void updateCache(int customerId, List<Transaction> transactions){
        Balance balance = customerBalances.get(customerId);
        if (balance == null){
            balance = new Balance();
            balance.cumulativeAmountToDate = cumulativeAmountFromDate(null, transactions);
            balance.monthlyBalancesToDate = monthlyBalancesFromDate(null, transactions);
        }else {
            balance.cumulativeAmountToDate += cumulativeAmountFromDate(balance.date, transactions);
            balance.monthlyBalancesToDate.addAll(monthlyBalancesFromDate(balance.date, transactions));
        }
        customerBalances.put(customerId, balance);
    }

    //balances in format month/year balance
    public static Balance readMonthlyBalances(int customerId){
        return customerBalances.get(customerId);
    }

    public static int cumulativeAmountFromDate(LocalDate date, List<Transaction> transactions){
        if (date != null){
            transactions = transactions.stream().filter(t -> t.date.isAfter(date)).toList();
        }

        return transactions.stream().mapToInt(t -> t.amount).sum();
    }

    public static List<String> monthlyBalancesFromDate(LocalDate date, List<Transaction> transactions){
        List<String> monthlyBalances = new ArrayList<>();
        if (date != null){
            transactions = transactions.stream().filter(t -> t.date.isAfter(date)).toList();
        }
        int previousYear = transactions.get(0).date.getYear();
        int previousMonth = transactions.get(0).date.getMonthValue();
        int monthAmount = 0;
        for (Transaction transaction : transactions) {
            if (transaction.date.getYear() != previousYear || transaction.date.getMonthValue() != previousMonth){
                monthlyBalances.add(previousMonth + "/" + previousYear + "     " + (monthAmount / 100) + "," + (Math.abs(monthAmount) % 100));
                monthAmount = transaction.amount;
                previousYear = transaction.date.getYear();
                previousMonth = transaction.date.getMonthValue();
            } else {
                monthAmount += transaction.amount;
            }
        }
        Collections.reverse(monthlyBalances);
        return monthlyBalances;
    }
}
