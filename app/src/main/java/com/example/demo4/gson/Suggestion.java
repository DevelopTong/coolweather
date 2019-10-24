package com.example.demo4.gson;

import com.google.gson.annotations.SerializedName;

/**
 * 准备接收和处理Json数据的suggestion字段
 * 使用@SerializedName注解来映射Json字段与Java字段的关系
 */
public class Suggestion {

    @SerializedName("comf")
    public Comfort comfort;

    @SerializedName("cw")
    public CarWash carWash;

    public Sport sport;

    public class Comfort{
        @SerializedName("txt")
        public String info;
    }

    public class CarWash{
        @SerializedName("txt")
        public String info;
    }

    public class Sport{
        @SerializedName("txt")
        public String info;
    }
}
