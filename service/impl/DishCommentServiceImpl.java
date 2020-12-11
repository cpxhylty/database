package service.impl;

import dao.DishCommentDao;
import dao.impl.DishCommentDaoImpl;
import pojo.DishComment;
import service.DishCommentService;

import java.util.Date;
import java.util.List;

public class DishCommentServiceImpl implements DishCommentService {
    DishCommentDao dishCommentDao = new DishCommentDaoImpl();

    @Override
    public List<DishComment> getAllDishComments() {
        return dishCommentDao.getAllDishComments();
    }

    @Override
    public List<DishComment> findDishCommentByAccount(String account) {
        return dishCommentDao.findDishCommentByAccount(account);
    }

    @Override
    public void addComment(Date time, String account, String dish, String content) {
        dishCommentDao.addComment(time, account, dish, content);
    }

    @Override
    public void deleteComment(Date time, String account, String dish) {
        dishCommentDao.deleteComment(time, account, dish);
    }
}
