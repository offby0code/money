package com.company.money;

import java.util.ArrayList;
import java.util.List;

public class AppLogic {
    
    public static List<String> fetchCustomerBalances(int customerId){
        //BalanceCache.updateCache(customerId, mockTransactionAPI.fetchTransactions(customerId));
        //Balance balance = BalanceCache.readMonthlyBalances(customerId);
        Balance balance = new Balance();
        balance.monthlyBalancesToDate = new ArrayList<>();
        balance.monthlyBalancesToDate.add("01/2021 12,23");
        balance.monthlyBalancesToDate.add("02/2021 122,23");
        List<String> balances = new ArrayList<>();
        balances.add("Your cumulative balance is " + balance.cumulativeAmountToDate());
        balances.add("Your monthly balances are ");
        balances.addAll(balance.monthlyBalancesToDate);
        return balances;
    }
}
