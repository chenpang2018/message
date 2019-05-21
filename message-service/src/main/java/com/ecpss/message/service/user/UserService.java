package com.ecpss.message.service.user;

import com.ecpss.message.domain.user.BootUser;

/**
 * Created by chenpang on 2018/2/6.
 */
public interface UserService {

    public void saveUser(String userName, String userNo);

    public BootUser getUserByUserNo(String userNo);
}
