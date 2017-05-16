package service;


import javabeans.WordsEntity;

/**
 * Created by 72408 on 2017/1/20.
 */
public interface WordService {
    WordsEntity selectSingleWordResult(String word);
}
