package dao;

import pojo.Evaluate;

import java.util.List;

public interface EvaluateDao {
    Evaluate findEvaluateById(int id);

    void addEvaluate(int id,String dinnerTime,int type,String name,String content,int rating);

    List<Evaluate> getAllEvaluate();
}
