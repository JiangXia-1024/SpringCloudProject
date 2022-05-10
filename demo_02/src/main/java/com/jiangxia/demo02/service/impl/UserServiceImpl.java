package com.jiangxia.demo02.service.impl;

import com.jiangxia.demo02.dao.UserDao;
import com.jiangxia.demo02.entity.User;
import com.jiangxia.demo02.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author jiangxia
 * @date 2022年05月06日 19:39
 */
//用来通知springboot 扫描当前该注解，作用：用来在工厂中创建对象
@Service
//@Service @controller  @ repository 都是有@Component演变来 用来表示不同层的组件
//这三个注解都继承了@Component注解
@Transactional //控制事务 acid 修饰范围：类、方法上都可以使用 类上表示类中的所有方法都加入事务控制，加在方法上，则表示当前修饰的方法加入事务控制
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS) //事务的传播属性
////    要用来配置当前需要执行的方法，与当前是否有transaction之间的关系
//    Propagation取值：
//    REQUIRED（默认值）：在有transaction状态下执行；如当前没有transaction，则创建新的transaction；
//    SUPPORTS：多用于查询方法 有融入 没有不开启 即如当前有transaction，则在transaction状态下执行；如果当前没有transaction，在无transaction状态下执行；
//    MANDATORY：强制事务，没有事务报错 必须在有transaction状态下执行，如果当前没有transaction，则抛出异常IllegalTransactionStateException；
//
//    REQUIRES_NEW：需要新事务 创建新的transaction并执行；如果当前已有transaction，则将当前transaction挂起；
//
//    NOT_SUPPORTED：在无transaction状态下执行；如果当前已有transaction，则将当前transaction挂起；
//
//    NEVER：在无transaction状态下执行；如果当前已有transaction，则抛出异常IllegalTransactionStateException。
//    独立事务 需要事务：外部存在事务则融入事务，没有则开启新的事务 connl
//               需要新事务：外部存在事务则外部事务挂起暂停，自己创建新的事务运行，运行结束恢复外部事务
    public List<User> findAll() {

        return userDao.findAll();
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    /**
     * @author:江夏
     * @date 2022/5/9 13:28
     * @version 1.0
     * @description: 查询一个
     */
    @Override
    public User findOne(String id) {
        return userDao.findOne(id);
    }


}
