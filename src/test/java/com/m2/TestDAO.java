package com.m2;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.m2.dao.StockDao;
import com.m2.dao.StockDaoHibernate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by Milan on 25-Mar-17.
 */
public class TestDAO {
    private EntityManagerFactory entityManagerFactory;

    @Before
    public void init() {
        entityManagerFactory = Persistence.createEntityManagerFactory( "JavaHelps" );
    }

    @After
    public void destroy() {
        entityManagerFactory.close();
    }

    @Test
    public void testDao(){
        StockDao sda = new StockDaoHibernate();
        List<Stock> lista = sda.ReadAll();
        for (Stock s : lista){
            System.out.println(s.toString());
        }
    }

    @Test
    public void testDao1(){
        
    }
}
