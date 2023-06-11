package com.company.money;

import java.util.ArrayList;
import java.util.List;

public class AppLogic {
    
    public static List<String> fetchCustomerBalances(int customerId){
        BalanceCache.updateCache(customerId, mockTransactionAPI.fetchTransactions(customerId));
        Balance balance = BalanceCache.readMonthlyBalances(customerId);
        List<String> balances = new ArrayList<>();
        balances.add("Your cumulative balance is " + balance.cumulativeAmountToDate());
        balances.add("Your monthly balances are ");
        balances.addAll(balance.monthlyBalancesToDate);
        return balances;
    }
}
