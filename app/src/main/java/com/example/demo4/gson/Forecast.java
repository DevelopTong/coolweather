package com.example.demo4.gson;

import com.google.gson.annotations.SerializedName;

/**
 * 准备接收和处理Json数据的forecast字段
 * 使用@SerializedName注解来映射Json字段与Java字段的关系
 */
public class Forecast {

    public String date;

    @SerializedName("tmp")
    public Temperature temperature;

    @SerializedName("cond")
    public More more;

    public class Temperature {

        public String max;

        public String min;
    }

    public class More {

        @SerializedName("txt_d")
        public String info;
    }
}
