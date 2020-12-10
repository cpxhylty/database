package service.impl;

import dao.DishCommentDao;
import dao.impl.DishCommentDaoImpl;
import pojo.DishComment;
import service.DishCommentService;

import java.util.List;

public class DishCommentServiceImpl implements DishCommentService {
    DishCommentDao dishCommentDao = new DishCommentDaoImpl();

    @Override
    public List<DishComment> getAllDishComments() {
        List<DishComment> dishComments = dishCommentDao.getAllDishComments();
        return dishComments;
    }
}
