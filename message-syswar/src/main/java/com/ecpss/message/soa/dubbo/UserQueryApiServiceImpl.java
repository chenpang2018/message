package com.ecpss.message.soa.dubbo;

import com.alibaba.dubbo.config.annotation.Service;
import com.ecpss.message.api.dubbo.UserQueryApiService;
import com.ecpss.message.domain.user.BootUser;
import com.ecpss.message.service.user.UserService;

import javax.annotation.Resource;

/**
 * Created by chenpang on 2019/5/20 18:04.
 */
@Service
public class UserQueryApiServiceImpl implements UserQueryApiService{
    @Resource
    private UserService userService;
    @Override
    public String queryUserNameByUserNo(String userNo) {
        BootUser bootUser = userService.getUserByUserNo(userNo);
        return bootUser == null ? "" : bootUser.getUserName();
    }
}
