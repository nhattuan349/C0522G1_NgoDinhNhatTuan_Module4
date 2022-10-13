package com.converter.service;

import org.springframework.stereotype.Service;

@Service
public class CurrencyConverterService implements ICurrencyConverterService {

    @Override
    public double converter(double usd) {
        return usd*22000;
    }
}
