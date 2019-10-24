package com.example.demo4.gson;
/**
 * 准备接收和处理Json数据的aqi字段
 * 使用@SerializedName注解来映射Json字段与Java字段的关系
 */
public class AQI {

    public AQICity city;

    public class AQICity {

        public String aqi;

        public String pm25;
    }
}
