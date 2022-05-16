package com.jiangxia.dao;

import com.jiangxia.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jiangxia
 * @date 2022年05月06日 16:16
 * desc：dao层
 */
@Repository
public interface UserDao {

    /**
     * @author:江夏
     * @date 2022/5/6 16:17
     * @version 1.0
     * @description: 查询所有
     */
    List<User> findAll();

    void save(User user);

    User findOne(String id);
}
