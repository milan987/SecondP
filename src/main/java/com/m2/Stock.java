package com.m2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Milan on 22-Mar-17.
 */
@Entity
@Table(name = "stock")
public class Stock implements Serializable {
    @Id
    @Column(name = "STOCK_ID", unique = true)
    private int stock_id;

    @Column(name = "STOCK_CODE", nullable = false)
    private String stock_code;

    @Column(name = "STOCK_NAME", nullable = false)
    private String stock_name;

    public int getStock_id() {
        return stock_id;
    }

    public void setStock_id(int stock_id) {
        this.stock_id = stock_id;
    }

    public String getStock_code() {
        return stock_code;
    }

    public void setStock_code(String stock_code) {
        this.stock_code = stock_code;
    }

    public String getStock_name() {
        return stock_name;
    }

    public void setStock_name(String stock_name) {
        this.stock_name = stock_name;
    }
}
