package service.impl;

import dao.CommentDao;
import dao.impl.CommentDaoImpl;
import pojo.Comment;
import service.CommentService;

import java.util.List;

public class CommentServiceImpl implements CommentService {
    CommentDao commentDao = new CommentDaoImpl();

    @Override
    public List<Comment> getAllComments() {
        return commentDao.getAllComments();
    }
}
