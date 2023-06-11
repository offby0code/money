package com.company.money;

public class AppLogic {
    
    public static String fetchCustomerBalances(int customerId){
        BalanceCache.updateCache(customerId, mockTransactionAPI.fetchTransactions(customerId));
        Balance balance = BalanceCache.readMonthlyBalances(customerId);
        return "Your Balance is " + balance.cumulativeAmountToDate + "\n" +
        "Your monthly balance history is " + String.join("\n", balance.monthlyBalancesToDate);
    }
}
