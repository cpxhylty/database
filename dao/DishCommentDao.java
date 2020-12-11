package dao;

import pojo.DishComment;

import java.util.Date;
import java.util.List;

public interface DishCommentDao {
    List<DishComment> getAllDishComments();

    List<DishComment> findDishCommentByAccount(String account);

    void addComment(Date time, String account, String dish, String content);

    void deleteComment(Date time, String account, String dish);
}
