package com.example.secret.testapp3.presenter;

import com.example.secret.testapp3.model.GetWeatherRequest;
import com.example.secret.testapp3.bean.HeWeather;
import com.example.secret.testapp3.view.IWeatherView;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import retrofit2.Retrofit;

import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class GetWeatherPresenter {

    private IWeatherView view;

    private HeWeather weather;

    public GetWeatherPresenter(IWeatherView view){
        this.view = view;

    }

    public void get(String loc){


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://free-api.heweather.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();



        GetWeatherRequest request = retrofit.create(GetWeatherRequest.class);
        request.getRequest(loc)
                .subscribeOn(io.reactivex.schedulers.Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HeWeather>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        view.showDialog();
                    }

                    @Override
                    public void onNext(HeWeather heWeather) {
                        weather = heWeather;
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        String txt = weather.getHeWeather6().get(0).getNow().getCond_txt();
                        String tmp = weather.getHeWeather6().get(0).getNow().getTmp();
                        String code = weather.getHeWeather6().get(0).getNow().getCond_code();
                        view.showText(txt,tmp);
                        view.showPic("https://cdn.heweather.com/cond_icon/"+code+".png");
                        view.dialogDismiss();
                    }
                });

    }

}
