package com.example.secret.testapp3.view;


import retrofit2.http.Url;

public interface IWeatherView {

    void showText(String txt,String tmp);

    void showDialog();

    void dialogDismiss();

    void showPic(String url);


}
