package com.llh.sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //声明控件
    private Button btn_sharedpreferences;
    private Button btn_get_sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_sharedpreferences = (Button)findViewById(R.id.btn_sharedpreferences);
        btn_get_sharedpreferences = (Button)findViewById(R.id.btn_get_sharedpreferences);
        btn_sharedpreferences.setOnClickListener(this);
        btn_get_sharedpreferences.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_sharedpreferences:
                //创建SharedPreferences对象
                SharedPreferences sp = MainActivity.this.getSharedPreferences("data",MODE_PRIVATE);
                sp.edit().putString("name","LLH").putInt("age",21).putBoolean("married",false).apply();
                break;
            case R.id.btn_get_sharedpreferences:
                SharedPreferences pref = getSharedPreferences("data",MODE_PRIVATE);
                String name = pref.getString("name", "");
                int age = pref.getInt("age", 0);
                boolean married = pref.getBoolean("married", false);
                Toast.makeText(this,"name is"+name+";age is"+age+";married is"+married,Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
