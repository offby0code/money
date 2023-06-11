package com.company.money;

import java.time.LocalDate;
import java.util.List;

public class Balance {
    //cumulative balance calculated to date property, including all transaction made in that date
    public int cumulativeAmountToDate;
    //date until balances are calculated and cached
    public LocalDate date;
    //monthly balances for UI in form 01/2021 12,00
    public List<String> monthlyBalancesToDate;
}
