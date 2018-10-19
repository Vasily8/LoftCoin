package com.vasily.loftcoin.screens.currencies;

import com.vasily.loftcoin.data.db.model.CoinEntity;

public interface CurrenciesAdapterListener {
    void onCurrencyClick(CoinEntity coin);
}
