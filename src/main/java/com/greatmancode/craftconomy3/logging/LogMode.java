package com.greatmancode.craftconomy3.logging;

import com.google.common.collect.ImmutableMap;
import com.greatmancode.craftconomy3.Cause;
import com.greatmancode.craftconomy3.Common;
import com.greatmancode.craftconomy3.LogInfo;
import com.greatmancode.craftconomy3.account.Account;
import com.greatmancode.craftconomy3.currency.Currency;
import com.greatmancode.craftconomy3.utils.Utils;
import org.json.simple.JSONObject;

import java.util.Objects;

public enum LogMode implements LogWriter {
    NONE,
    LOGGER {
        @Override
        public void writeLog(LogInfo info, Cause cause, String causeReason, Account account, double amount, double balance, Currency currency, String worldName) {
            ImmutableMap<?, ?> log = ImmutableMap.builder()
                    .put("info", info.name())
                    .put("cause", cause.name())
                    .put("reason", Utils.requireNonNullElse(causeReason, ""))
                    .put("account", account.getAccountName())
                    .put("amount", amount)
                    .put("balance", balance)
                    .put("currency", currency.getName())
                    .put("worldName", worldName)
                    .build();
            Common.getInstance().getLogger().info("[craftconomy3],"+JSONObject.toJSONString(log));
        }
    },
    SQL {
        @Override
        public void writeLog(LogInfo info, Cause cause, String causeReason, Account account, double amount, double balance, Currency currency, String worldName) {
            Common.getInstance().getStorageHandler().getStorageEngine().saveLog(info, cause, causeReason, account, amount, currency, worldName);
        }
    };

    @Override
    public void writeLog(LogInfo info, Cause cause, String causeReason, Account account, double amount, double balance, Currency currency, String worldName) {
        // None
    }
}
