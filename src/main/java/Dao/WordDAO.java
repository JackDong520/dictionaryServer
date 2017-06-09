package Dao;

import db.DBAccess;
import javabeans.DictEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Test;

/**
 * Created by 72408 on 2017/1/20.
 */
public class WordDAO {

    private static Session session;
    private Transaction transaction;
    private static DBAccess dbAccess;

    static {
        dbAccess = new DBAccess();
    }
    public DictEntity selectSingleWord(String word) {
        session = dbAccess.getSession();
        transaction = session.beginTransaction();
        String hql = "from DictEntity s where word = ?";
        Query query = session.createQuery(hql).setParameter(0, word);
        DictEntity dictEntity = (DictEntity) query.getSingleResult();
        transaction.commit();
        return dictEntity;
    }

    @Test
    public void test (){
        System.out.println(new WordDAO().selectSingleWord("take").getWord().toString());
    }

}
