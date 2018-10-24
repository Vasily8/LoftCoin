package com.vasily.loftcoin.data.db;

import com.vasily.loftcoin.data.db.model.CoinEntity;
import com.vasily.loftcoin.data.db.model.Transaction;
import com.vasily.loftcoin.data.db.model.TransactionModel;
import com.vasily.loftcoin.data.db.model.Wallet;
import com.vasily.loftcoin.data.db.model.WalletModel;

import java.util.List;

import io.reactivex.Flowable;

public interface Database {

    void saveCoins(List<CoinEntity> coins);

    void saveWallet(Wallet wallet);

    void saveTransaction(List<Transaction> transactions);

    Flowable<List<CoinEntity>> getCoins();

    Flowable<List<WalletModel>> getWallets();

    Flowable<List<TransactionModel>> getTransactions(String walletId);

    CoinEntity getCoin(String symbol);
}
