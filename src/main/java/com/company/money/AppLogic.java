package com.company.money;

public class AppLogic {
    
    public static String fetchCustomerBalances(int customerId){
        BalanceCache.updateCache(customerId, mockTransactionAPI.fetchTransactions(customerId));
        return "Your Balance is " + BalanceCache.balance + "\n" +
        "Your monthly balance history is " + String.join("\n", BalanceCache.readMonthlyBalances(customerId));
    }
}
