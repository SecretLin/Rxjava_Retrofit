package com.example.secret.testapp3.model;

import com.example.secret.testapp3.bean.HeWeather;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetWeatherRequest {

    @GET("s6/weather/now?&key=de5b590c06384b5195cebc329fef83e2")
    Observable<HeWeather> getRequest(@Query("location")String loc);

}
