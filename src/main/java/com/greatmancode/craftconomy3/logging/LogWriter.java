package com.greatmancode.craftconomy3.logging;

import com.greatmancode.craftconomy3.Cause;
import com.greatmancode.craftconomy3.LogInfo;
import com.greatmancode.craftconomy3.account.Account;
import com.greatmancode.craftconomy3.currency.Currency;

public interface LogWriter {

    void writeLog(LogInfo info, Cause cause, String causeReason, Account account, double amount, double balance, Currency currency, String worldName);
}
