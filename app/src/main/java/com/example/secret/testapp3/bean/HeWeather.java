package com.example.secret.testapp3.bean;

import java.util.List;

public class HeWeather {

   private List<HeWeather> HeWeather6;
   private now now;

   public List<HeWeather> getHeWeather6() {
      return HeWeather6;
   }

   public void setHeWeather6(List<HeWeather> heWeather6) {
      HeWeather6 = heWeather6;
   }

   public com.example.secret.testapp3.bean.now getNow() {
      return now;
   }

   public void setNow(com.example.secret.testapp3.bean.now now) {
      this.now = now;
   }


   //根据返回的json数据u构造了HeWeather和now的bean
   /*
   {
   "HeWeather6":[{
      "basic":
         {"cid":"CN101280101","location":"广州","parent_city":"广州","admin_area":"广东","cnty":"中国","lat":"23.12517738","lon":"113.28063965","tz":"+8.00"},
      "update":
         {"loc":"2018-09-29 13:46","utc":"2018-09-29 05:46"},
      "status":"ok",
      "now":
         {"cloud":"50","cond_code":"100","cond_txt":"晴","fl":"29","hum":"48","pcpn":"0.0","pres":"1009","tmp":"28","vis":"10","wind_deg":"353","wind_dir":"北风","wind_sc":"2","wind_spd":"8"}
       }]
    }
    */
}
