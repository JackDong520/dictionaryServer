package service;


import Dao.WordDAO;
import javabeans.DictEntity;
import org.junit.Test;

/**
 * Created by 72408 on 2017/1/20.
 */
public class WordServiceImpl implements WordService {
    private static WordDAO wordDAO;

    static {
        wordDAO = new WordDAO();
    }

    @Override
    public DictEntity selectSingleWordResult(String word) {
        return  wordDAO.selectSingleWord(word);
    }

    @Test
    public void test(){

        System.out.println( new WordServiceImpl().selectSingleWordResult("take").getWord().toString());
    }
}
