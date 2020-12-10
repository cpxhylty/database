package dao;

import pojo.Comment;

import java.util.List;

public interface CommentDao {
    Comment findCommentById(int id);

    void addComment(int id, String dinnerTime, int type, String name, String content, int rating);

    List<Comment> getAllComments();
}
