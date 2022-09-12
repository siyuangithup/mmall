package com.mmall.gateway.service;

import com.mmall.gateway.common.ServerResponse;
import com.mmall.gateway.exception.MmallException;
import com.mmall.gateway.pojo.MmallUser;

/**
 * Description
 * Create by dong.zhou
 * Date 2022/9/12 02:20
 */
public interface IUserService {

    /**
     * 测试
     * @param id
     * @return
     */
    MmallUser findById(Integer id);


    /**
     * 登陆
     * @param userName 用户名
     * @param passWord 密码
     */
    ServerResponse<MmallUser> login(String userName, String passWord) throws MmallException;
}
