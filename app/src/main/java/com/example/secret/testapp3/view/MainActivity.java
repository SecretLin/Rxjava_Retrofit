package com.example.secret.testapp3.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.example.secret.testapp3.MyEvent;
import com.example.secret.testapp3.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;


public class MainActivity extends AppCompatActivity {

//    Button btn;
//    TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EventBus.getDefault().register(this);

//        btn = findViewById(R.id.btn);
//        tv = findViewById(R.id.tv);



    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void handleMsg(MyEvent event){

//        tv.setText(event.getMsg());


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
