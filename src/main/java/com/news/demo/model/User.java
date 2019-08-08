package com.news.demo.model;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;


/**
 * <p>
 * 用户表
 * </p>
 *
 * @author GEBILAOHU
 * @since 2019-06-09
 */

@TableName("t_user")
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    /**
     * 创建日期
     */
    @TableField("creat_time")
    private Date creatTime;
    /**
     * 出生日期
     */
    private Date birthday;
    /**
     * 性别
     */
    private Integer gender;
    /**
     * 登录名
     */
    @TableField("user_name")
    private String userName;


    /**
     * 密码
     */
    @TableField("user_pwd")
    private String userPwd;
    /**
     * 用户编号
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    /**
     * 用户设备标识
     */
    @TableId(value = "user_deviceId")
    private String deviceId;

    /**
     * 用户设备标识
     */
    @TableId(value = "user_avatarUrl")
    private String avatarUrl;

    public User(){};

    public User(Date birthday, Integer gender, String userName, String userPwd, String deviceId,Date date,String avatarUrl ) {
        this.birthday = birthday;
        this.gender = gender;
        this.userName = userName;
        this.userPwd = userPwd;
        this.deviceId = deviceId;
        this.creatTime = date;
        this.avatarUrl = avatarUrl;
    }

    @Override
    protected Serializable pkVal() {
        return this.userId;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}
