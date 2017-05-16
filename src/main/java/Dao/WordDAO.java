package Dao;

import db.DBAccess;
import javabeans.WordsEntity;
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


    public WordsEntity selectSinglePeople(String word) {
        session = dbAccess.getSession();
        transaction = session.beginTransaction();
        String hql = "from WordsEntity s where word = ?";
        Query query = session.createQuery(hql).setParameter(0, word);
        WordsEntity wordsEntity = (WordsEntity) query.getSingleResult();
        transaction.commit();
        return wordsEntity;
    }

    @Test
    public void test (){
        System.out.println(new WordDAO().selectSinglePeople("take").getWord().toString());
    }

}
