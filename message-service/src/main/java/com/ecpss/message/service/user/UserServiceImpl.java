package com.ecpss.message.service.user;

import com.ecpss.message.domain.user.BootUser;
import com.ecpss.message.infrastructure.rptimpl.user.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by chenpang on 2018/2/6.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Resource
    private UserRepository userRepository;

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    public void saveUser(String userName, String userNo) {
        logger.info("保存用户信息，userName:" + userName + ",userNo:" + userNo);

        BootUser user = new BootUser(userName, userNo);
        userRepository.save(user);

        if ("chenpang".equals(userName)) {
            throw new RuntimeException("异常回滚");
        }
    }

    public BootUser getUserByUserNo(String userNo) {
        BootUser bootUser = userRepository.findByUserNo(userNo);
        return bootUser;
    }
}
