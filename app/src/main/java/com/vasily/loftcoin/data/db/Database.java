package com.vasily.loftcoin.data.db;

import com.vasily.loftcoin.data.db.model.CoinEntity;
import com.vasily.loftcoin.data.db.model.Transaction;
import com.vasily.loftcoin.data.db.model.Wallet;

import java.util.List;

import io.reactivex.Flowable;

public interface Database {

    void saveCoins(List<CoinEntity> coins);

    void saveWallet(Wallet wallet);

    void saveTransaction(List<Transaction> transactions);

    Flowable<List<CoinEntity>> getCoins();

    Flowable<List<Wallet>> getWallets();

    Flowable<List<Transaction>> getTransactions(String walletId);

    CoinEntity getCoin(String symbol);


    void open();

    void close();

}
