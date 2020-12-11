package dao;

import pojo.Comment;

import java.util.List;

public interface CommentDao {
    List<Comment> findCommentByAccount(String account);

    void addComment(int id, String dinnerTime, int type, String name, String content, int rating);

    List<Comment> getAllComments();

    List<Integer> findHaveComment(String account);
}
