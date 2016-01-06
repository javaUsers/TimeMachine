package com.xiaomo.timeMachine.core.model;

import com.xiaomo.timeMachine.core.constant.OauthType;
import com.xiaomo.timeMachine.core.model.base.GenerateIdEntity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.util.Date;

/**
 * 把今天最好的表现当作明天最新的起点．．～
 * いま 最高の表現 として 明日最新の始発．．～
 * Today the best performance  as tomorrow newest starter!
 * Created by IntelliJ IDEA.
 *
 * @author: xiaomo
 * @github: https://github.com/qq83387856
 * @email: hupengbest@163.com
 * @QQ_NO: 83387856
 * @Date: 12:41 2016/1/5
 * @Description: todo
 * @Copyright(©) 2015 by xiaomo.
 */
@Entity
@Table(name = "qq_login")
public class QQUser extends GenerateIdEntity {

    private String openId;                      // open_id

    private Date createTime;               // create_time

    private String nickName;                   // Nickname

    private String headPhoto;               // 头像url

    private String address; //省+市

    private int tel;

    private String e_mail;

    private String year;

    private String gender;

    @Enumerated(EnumType.STRING)
    private OauthType type;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }


    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getHeadPhoto() {
        return headPhoto;
    }

    public void setHeadPhoto(String headPhoto) {
        this.headPhoto = headPhoto;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public OauthType getType() {
        return type;
    }

    public void setType(OauthType type) {
        this.type = type;
    }
}
