package com.xxxx.service;

import com.xxxx.entity.User;
import com.xxxx.entity.vo.MessageModel;
import com.xxxx.mapper.UserMapper;
import com.xxxx.util.GetSqlSession;
import com.xxxx.util.StringUtil;
import org.apache.ibatis.session.SqlSession;

/*
* 业务逻辑
* */
public class Userservice {
    /**
     * 用户登录
     * 1.参数的非空判断
     *      如果参数为空
     *      将状态码、提示信息、回显数据设置到消息模型对象中，返回消息模型对象
     * 2.调用dao层的查询方法，通过用户名查询用户对象
     * 3.判断用户对象是否为空
     *      将状态码、提示信息、回显数据设置到消息模型对象中，返回消息模型对象
     * 4.将成功状态、提示信息、用户对象设置消息模型对象，并return
     */

    public MessageModel userLogion(String uname, String upwd) {
        MessageModel messageModel=new MessageModel();

        //1.参数的非空判断
        if(StringUtil.isEmpty(uname) || StringUtil.isEmpty(upwd)){
            //将状态码、提示信息、回显数据设置到消息模型对象中，返回消息模型对象

            messageModel.setCode(0);
            messageModel.setMsg("UseName or PassWord cannot be null");
            //回显数据
            User u=new User();
            u.setUserName(uname);
            u.setUserPwd(upwd);
            messageModel.setObject(u);
            return  messageModel;
        }

       // 2.调用dao层的查询方法，通过用户名查询用户对象
        SqlSession session= GetSqlSession.createSqlSession();
        UserMapper userMapper=session.getMapper(UserMapper.class);
        User user= userMapper.queryUserByName(uname);

        //3.判断用户对象是否为空
        if(user==null){
            //将状态码、提示信息、回显数据设置到消息模型对象中，返回消息模型对象
            messageModel.setCode(0);
            messageModel.setMsg("no this user");
            //回显数据
            User u=new User();
            u.setUserName(uname);
            u.setUserPwd(upwd);
            messageModel.setObject(u);
            return  messageModel;
        }
        //4.比较密码

        if(!upwd.equals(user.getUserPwd())){
            System.out.println(user.getUserName()+"   "+user.getUserPwd()+"   "+user.getUserId());
            messageModel.setCode(0);
            messageModel.setMsg("the password wrong");
            return  messageModel;
        }
        //5.登录成功，将用户信息设置带消息模型中

        messageModel.setObject(user);
        return  messageModel;
    }
}
