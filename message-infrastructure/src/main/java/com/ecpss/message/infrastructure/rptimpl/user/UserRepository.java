package com.ecpss.message.infrastructure.rptimpl.user;

import com.ecpss.message.domain.user.BootUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by chenpang on 2018/2/5.
 */
@Repository
public interface UserRepository extends CrudRepository<BootUser, Long> {
    BootUser findByUserName(String userName);

    BootUser findByUserNo(String userNo);
}
