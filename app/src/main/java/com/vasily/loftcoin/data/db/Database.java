package com.vasily.loftcoin.data.db;

import com.vasily.loftcoin.data.db.model.CoinEntity;
import com.vasily.loftcoin.data.db.model.Wallet;
import com.vasily.loftcoin.data.db.model.WalletModel;

import java.util.List;

import io.reactivex.Flowable;

public interface Database {

    void saveCoins(List<CoinEntity> coins);

    void saveWallet(Wallet wallet);

    Flowable<List<CoinEntity>> getCoins();

    Flowable<List<WalletModel>> getWallets();

    CoinEntity getCoin(String symbol);
}
