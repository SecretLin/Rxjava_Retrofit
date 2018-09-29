package com.example.secret.testapp3.view;

import android.app.ProgressDialog;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;


import com.bumptech.glide.Glide;
import com.example.secret.testapp3.MyEvent;
import com.example.secret.testapp3.R;
import com.example.secret.testapp3.databinding.ActivityWetherRepAcyBinding;
import com.example.secret.testapp3.presenter.GetWeatherPresenter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import retrofit2.http.Url;


public class WeatherRepAcy extends AppCompatActivity implements IWeatherView{


    //加载框
    private ProgressDialog dialog;

    GetWeatherPresenter presenter;

    ActivityWetherRepAcyBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wether_rep_acy);

        EventBus.getDefault().register(this);

        initView();
    }

    private void initView(){
        //加载binding
        binding = DataBindingUtil.setContentView(this,R.layout.activity_wether_rep_acy);

        binding.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String loc = binding.etName.getText().toString().trim();
                presenter.get(loc);

                EventBus.getDefault().post(new MyEvent("加载中..."));

            }
        });

        presenter = new GetWeatherPresenter(this);

        dialog = new ProgressDialog(this);
    }

    @Override
    public void showText(String txt,String tmp) {
        //显示天气情况
        binding.tvCond.setText(txt);
        //显示温度
        binding.tvTmp.setText(tmp+"°");
    }

    @Override
    public void showDialog() {
        dialog.show();
    }

    @Override
    public void dialogDismiss() {
        dialog.dismiss();
    }

    @Override
    public void showPic(String url) {
        //显示天气情况的图标
        Glide.with(this).load(url).into(binding.icon);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void handleMsg(MyEvent event){

        Toast.makeText(this,event.getMsg(),Toast.LENGTH_SHORT).show();

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
