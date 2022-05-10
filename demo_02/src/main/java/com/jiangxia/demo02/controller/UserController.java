package com.jiangxia.demo02.controller;

import com.jiangxia.demo02.entity.User;
import com.jiangxia.demo02.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author jiangxia
 * @date 2022年05月07日 10:06
 */
@RestController
@RequestMapping("user")
public class UserController {
//    定义日志对象
    private Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    /**
     * @author:江夏
     * @date 2022/5/7 10:14
     * @version 1.0
     * @description: 查询所有
     */
    @RequestMapping("user")
//    HttpServletRequest request, Model model
    public List<User> findAll(){
        List<User> users = userService.findAll();
        return users;
        //保存到作用域
//        model.addAttribute("users",users);
//        return "showAll";//跳转到jsp中
    }

    @RequestMapping("save")
    public void save(){
        User user = new User("2323@qq.com","gfgfgfg","卡莎");
        userService.save(user);
    }

//    测试使用数据库的自动生成
    @RequestMapping("save1")
    public void save1(){
        User user = new User("2322223@qq.com","gfgfgf22g","薇恩");
        System.out.println("调用dao方法之前"+user.getId());
        userService.save(user);
        System.out.println("调用dao方法之后"+user.getId());
    }

    @RequestMapping("selectOne/{id}")
    public User findOne(@PathVariable String id){
        logger.debug("日志调用");
        logger.debug("日志调用的占位符演示：{},{}",id,"占位符");
        return userService.findOne(id);
    }
}
