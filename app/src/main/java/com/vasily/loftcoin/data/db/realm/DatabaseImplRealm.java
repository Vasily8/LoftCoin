package com.vasily.loftcoin.data.db.realm;

import com.vasily.loftcoin.data.db.Database;
import com.vasily.loftcoin.data.db.model.CoinEntity;
import com.vasily.loftcoin.data.db.model.Transaction;
import com.vasily.loftcoin.data.db.model.Wallet;

import java.util.List;

import io.reactivex.Flowable;
import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;

public class DatabaseImplRealm implements Database {

    private Realm realm;

    @Override
    public void open() {
        realm = Realm.getDefaultInstance();
    }

    @Override
    public void close() {
        realm.close();
    }

    @Override
    public void saveCoins(List<CoinEntity> coins) {
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(coins);
        realm.commitTransaction();
    }

    @Override
    public void saveWallet(Wallet wallet) {
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(wallet);
        realm.commitTransaction();
    }

    @Override
    public void saveTransaction(List<Transaction> transactions) {
        realm.beginTransaction();
        realm.copyToRealm(transactions);
        realm.commitTransaction();
    }

    @Override
    public Flowable<List<CoinEntity>> getCoins() {

        Flowable<RealmResults<CoinEntity>> flowable = realm.where(CoinEntity.class) //request CoinEntity
                .findAll()
                .asFlowable()
                .filter(RealmResults::isLoaded);


        return (Flowable) flowable;
    }

    @Override
    public Flowable<List<Wallet>> getWallets() {
        Flowable<RealmResults<Wallet>> flowable = realm.where(Wallet.class) //request Wallet
                .findAll()
                .asFlowable()
                .filter(RealmResults::isLoaded);


        return (Flowable) flowable;
    }

    @Override
    public Flowable<List<Transaction>> getTransactions(String walletId) {
        Flowable<RealmResults<Transaction>> flowable = realm.where(Transaction.class) //request Transaction
                .equalTo("walletId", walletId)
                .findAll()
                .sort("date", Sort.DESCENDING) //sort by date and descending
                .asFlowable()
                .filter(RealmResults::isLoaded);


        return (Flowable) flowable;
    }

    @Override
    public CoinEntity getCoin(String symbol) {
        return realm.where(CoinEntity.class).equalTo("symbol", symbol).findFirst();
    }
}
