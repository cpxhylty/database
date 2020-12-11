package dao;

import pojo.Comment;

import java.util.Date;
import java.util.List;

public interface CommentDao {
    List<Comment> findCommentByAccount(String account);

    Comment findCommentByOrder(int orderNumber);

    void addComment(int orderNumber, int type, String name, String content, int rating, Date time);

    void updateComment(int orderNumber, String name, String content, int rating, Date time);

    void deleteComment(int orderNumber);

    List<Comment> getAllComments();

    List<Integer> findHaveComment(String account);
}
