package service;

import pojo.Comment;

import java.util.Date;
import java.util.List;

public interface CommentService {
    Comment findCommentByOrder(int orderNumber);

    void addComment(int orderNumber, int type, String name, String content, int rating, Date time);

    void updateComment(int orderNumber, String name, String content, int rating, Date time);

    void deleteComment(int orderNumber);

    List<Comment> getAllComments();
}
