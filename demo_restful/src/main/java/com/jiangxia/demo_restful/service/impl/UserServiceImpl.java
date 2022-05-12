package com.jiangxia.demo_restful.service.impl;

import com.jiangxia.demo_restful.dao.UserDao;
import com.jiangxia.demo_restful.entity.User;
import com.jiangxia.demo_restful.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (User)表服务实现类
 *
 * @author jiangxia
 * @since 2022-05-11 10:53:49
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public User queryById(Integer id) {
        return this.userDao.queryById(id);
    }

    @Override
    public List<User> querybylimit(Integer start, Integer end) {
        return null;
    }

    /**
     * 分页查询
     *
     * @param user 筛选条件
     * @param pageable      分页对象
     * @return 查询结果
     */
//    @Override
//    public Page<User> queryByPage(User user, Pageable pageable) {
//        long total = this.userDao.count(user);
//        return new Page<User>(this.userDao.queryAllByLimit(user, pageable), pageable, total);
//    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User insert(User user) {
        this.userDao.insert(user);
        return user;
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User update(User user) {
        this.userDao.update(user);
        return this.queryById(user.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.userDao.deleteById(id) > 0;
    }
}
