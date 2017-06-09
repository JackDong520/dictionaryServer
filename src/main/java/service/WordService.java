package service;


import javabeans.DictEntity;

/**
 * Created by 72408 on 2017/1/20.
 */
public interface WordService {
    DictEntity selectSingleWordResult(String word);
}
