package com.example.demo4.gson;

import com.google.gson.annotations.SerializedName;

/**
 * 准备接收和处理Json数据的basic字段
 * 使用@SerializedName注解来映射Json字段与Java字段的关系
 */
public class Basic {

    @SerializedName("city")
    public String cityName;

    @SerializedName("id")
    public String weatherId;

    public Update update;

    public class Update {
        @SerializedName("loc")
        public String updateTime;
    }
}
