package com.m2.dao;

import com.m2.Stock;

import java.util.List;

/**
 * Created by Milan on 25-Mar-17.
 */
public interface StockDao {
    public List<Stock> ReadAll();

    public void create(int id, String name, String code);

    public void delete(int id);

    public void upate(int id, String name, String code);
}
