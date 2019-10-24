package com.example.demo4.gson;

import com.google.gson.annotations.SerializedName;

/**
 * 准备接收和处理Json数据的now字段
 * 使用@SerializedName注解来映射Json字段与Java字段的关系
 */
public class Now {

    @SerializedName("tmp")
    public String temperature;

    @SerializedName("cond")
    public More more;

    public class More {
        @SerializedName("txt")
        public String info;
    }
}
