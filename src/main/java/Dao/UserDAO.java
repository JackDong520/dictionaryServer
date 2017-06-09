package Dao;

import db.DBAccess;

import javabeans.UserEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Test;

/**
 * Created by 72408 on 2017/1/20.
 */
public class UserDAO {

    private static Session session;
    private Transaction transaction;
    private static DBAccess dbAccess;
    private static UserEntity userEntity;

    static {
        dbAccess = new DBAccess();
        userEntity = new UserEntity();
    }

    public UserEntity selectSingleUser(String user) {
        session = dbAccess.getSession();
        transaction = session.beginTransaction();
        String hql = "from UserEntity s where user = ?";
        Query query = session.createQuery(hql).setParameter(0, user);
        if (query.getResultList().size()==0)
            return null;
        UserEntity userEntity = (UserEntity) query.getSingleResult();
        transaction.commit();
        return userEntity;
    }

    public boolean saveSingleUser(UserEntity user) {
        session = dbAccess.getSession();
        transaction = session.beginTransaction();
        userEntity.setId(user.getId());
        userEntity.setUser(user.getUser());
        userEntity.setPwd(user.getPwd());
        session.save(userEntity);
        transaction.commit();
        return true;
    }


    @Test
    public void test() {
        System.out.println(new UserDAO().saveSingleUser(new UserEntity(0,"jackdong","13584600")));
        //System.out.println(new UserDAO().selectSingleUser("jack").getPwd());
        //if (new UserDAO().selectSingleUser("jack") == null) System.out.println("没有账户");
        //if (new UserDAO().selectSingleUser("jack") != null) System.out.println("有账户");

    }

}
