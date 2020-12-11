package service.impl;

import dao.CommentDao;
import dao.impl.CommentDaoImpl;
import pojo.Comment;
import service.CommentService;

import java.util.Date;
import java.util.List;

public class CommentServiceImpl implements CommentService {
    CommentDao commentDao = new CommentDaoImpl();

    @Override
    public Comment findCommentByOrder(int orderNumber) {
        return commentDao.findCommentByOrder(orderNumber);
    }

    @Override
    public void addComment(int orderNumber, int type, String name, String content, int rating, Date time) {
        commentDao.addComment(orderNumber, type, name, content, rating, time);
    }

    @Override
    public void updateComment(int orderNumber, String name, String content, int rating, Date time) {
        commentDao.updateComment(orderNumber, name, content, rating, time);
    }

    @Override
    public void deleteComment(int orderNumber) {
        commentDao.deleteComment(orderNumber);
    }

    @Override
    public List<Comment> getAllComments() {
        return commentDao.getAllComments();
    }
}
