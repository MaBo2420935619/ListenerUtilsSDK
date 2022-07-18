package com.mabo.entity;

import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.io.Serializable;

/**
 * (History)实体类
 *
 * @author makejava
 * @since 2022-07-18 11:19:29
 */
@Mapper
public class History implements Serializable {
    private static final long serialVersionUID = 792733272788620877L;
    /**
     * 请求的ip地址
     */
    private String ip;
    /**
     * 下载的sdk名称
     */
    private String sdkname;
    /**
     * 下载时间
     */
    private Date time;
    /**
     * 下载的请求次数
     */
    private Integer number;


    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getSdkname() {
        return sdkname;
    }

    public void setSdkname(String sdkname) {
        this.sdkname = sdkname;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

}

