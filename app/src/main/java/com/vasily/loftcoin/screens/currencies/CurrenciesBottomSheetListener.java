package com.vasily.loftcoin.screens.currencies;

import com.vasily.loftcoin.data.db.model.CoinEntity;

public interface CurrenciesBottomSheetListener {
    void onCurrencySelected(CoinEntity coin);
}
