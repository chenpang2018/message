package com.ecpss.message.domain.user;

import javax.persistence.*;

/**
 * Created by chenpang on 2018/2/5.
 */
@Entity(name = "boot_user")
public class BootUser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "boot_user_seq")
    @SequenceGenerator(name = "boot_user_seq", sequenceName = "SEQ_BOOT_USER", allocationSize = 1)
    private Long id;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
