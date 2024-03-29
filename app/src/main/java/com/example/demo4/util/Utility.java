package com.example.demo4.util;

import android.text.TextUtils;

import com.example.demo4.db.City;
import com.example.demo4.db.County;
import com.example.demo4.db.Province;
import com.example.demo4.gson.Weather;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Utility {
    /**
     * 解析和处理服务器返回的省级数据
     */
    public static boolean handleProvinceResponse(String response) {
        // 如果返回的数据不为空
        if (!TextUtils.isEmpty(response)) {
            try {
                // 将返回数据转换成Json数组
                JSONArray allProvinces = new JSONArray(response);
                // 遍历数组
                for (int i = 0; i < allProvinces.length(); i++) {
                    // 将Json数据转换并存入数据库
                    JSONObject provinceObject = allProvinces.getJSONObject(i);
                    Province province = new Province();
                    province.setProvinceName(provinceObject.getString("name"));
                    province.setProvinceCode(provinceObject.getInt("id"));
                    province.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 解析和处理服务器返回的市级数据
     */
    public static boolean handleCityResponse(String response, int provinceId) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray allCities = new JSONArray(response);
                for (int i = 0; i < allCities.length(); i++) {
                    JSONObject cityObject = allCities.getJSONObject(i);
                    City city = new City();
                    city.setCityName(cityObject.getString("name"));
                    city.setCityCode(cityObject.getInt("id"));
                    city.setProvinceId(provinceId);
                    city.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    /**
     * 解析和处理服务器返回的县级数据
     */
    public static boolean hanleCountyResponse(String response, int cityId) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray allCounties = new JSONArray(response);
                for (int i = 0; i < allCounties.length(); i++){
                    JSONObject countyObject = allCounties.getJSONObject(i);
                    County county = new County();
                    county.setCountyName(countyObject.getString("name"));
                    county.setWeatherId(countyObject.getString("weather_id"));
                    county.setCityId(cityId);
                    county.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    /**
     * 将返回的Json数据解析成Weather实体类
     */
    public static Weather handleWeatherResponse(String response) {
        try {
            // 通过网络请求获取Json对象
            JSONObject jsonObject = new JSONObject(response);
            // 从Json对象获取Json数组
            JSONArray jsonArray = jsonObject.getJSONArray("HeWeather");
            // 将数组第一项以字符串形式保存
            String weatherContent = jsonArray.getJSONObject(0).toString();
            // Gson解析字符串成Weather对象
            return new Gson().fromJson(weatherContent, Weather.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
