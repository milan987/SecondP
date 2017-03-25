package com.m2;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.m2.dao.StockDao;
import com.m2.dao.StockDaoHibernate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.sql.SQLException;
import java.util.List;

import org.h2.tools.RunScript;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;

/**
 * Created by Milan on 25-Mar-17.
 */
public class TestDAO {
    private EntityManagerFactory entityManagerFactory;

    @Before
    public void init() {
        entityManagerFactory = Persistence.createEntityManagerFactory( "Testing" );
        @Override
        public void execute(Connection connection) throws SQLException {
            try {
                File script = new File(getClass().getResource("/data.sql").getFile());
                RunScript.execute(connection, new FileReader(script));
            } catch (FileNotFoundException e) {
                throw new RuntimeException("could not initialize with script");
            }
        }
    });
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
    @Transactional
    @Rollback
    public void testDao1(){
        StockDao sda = new StockDaoHibernate();
        sda.create(6,"Pera1","199");
        sda.create(7,"Jelka1","166");
        List<Stock> lista = sda.ReadAll();
        for (Stock s : lista){
            System.out.println(s.toString());
        }
    }
}
