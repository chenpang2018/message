package com.ecpss.message.domain.user;

import com.ecpss.message.domain.user.base.BaseEntity;

import javax.persistence.*;

/**
 * Created by chenpang on 2018/2/5.
 */
@Entity
@Table(name = "boot_user")
@SequenceGenerator(name = "msg_default_seq", sequenceName = "SEQ_MSG_BOOTUSER", allocationSize = 1)
public class BootUser extends BaseEntity{

    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_no")
    private String userNo;

    public BootUser() {
    }

    public BootUser(String userName, String userNo) {
        this.userName = userName;
        this.userNo = userNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }
}
