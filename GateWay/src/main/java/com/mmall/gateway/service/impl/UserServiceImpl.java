package com.mmall.gateway.service.impl;

import com.mmall.gateway.utils.Assert;
import com.mmall.gateway.common.ServerResponse;
import com.mmall.gateway.exception.MmallException;
import com.mmall.gateway.exception.MmallExceptionEnum;
import com.mmall.gateway.mapper.MmallUserMapper;
import com.mmall.gateway.pojo.MmallUser;
import com.mmall.gateway.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description
 * Create by dong.zhou
 * Date 2022/9/12 02:21
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private MmallUserMapper mapper;

    @Override
    public MmallUser findById(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public ServerResponse<MmallUser> login(String userName, String passWord)  {

        //todo 是否存在一个解析jwt过程

        //参数校验
        Assert.isFalse(StringUtils.isEmpty(userName) || StringUtils.isEmpty(passWord), MmallExceptionEnum.USERNAME_PASSWORD_INPUT_NOT_NULL);

        Assert.isFalse(mapper.selectCount(MmallUser.builder().username(userName).build()) == 0, MmallExceptionEnum.USERNAME_PASSWORD_INPUT_ERROR);

        Assert.isFalse(mapper.selectCount(MmallUser.builder().username(userName).password(passWord).build()) == 0, MmallExceptionEnum.USERNAME_PASSWORD_INPUT_ERROR);

//        MmallUser mmallUser = mapper.select(MmallUser.builder().username(userName).build());

        //名字不可以重复
        MmallUser mmallUser = mapper.selectOne(MmallUser.builder().username(userName).build());

        mmallUser.setPassword(null);

        return ServerResponse.createBySuccess(mmallUser);

    }
}
