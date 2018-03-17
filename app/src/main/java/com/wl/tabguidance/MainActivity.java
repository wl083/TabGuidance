package com.wl.tabguidance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.wl.tabguidance.activity.ActivityFive;
import com.wl.tabguidance.activity.ActivityFour;
import com.wl.tabguidance.activity.ActivityOne;
import com.wl.tabguidance.activity.ActivitySeven;
import com.wl.tabguidance.activity.ActivitySix;
import com.wl.tabguidance.activity.ActivityThree;
import com.wl.tabguidance.activity.ActivityTwo;
import com.wl.tabguidance.activity.home.HomePageActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnOne,btnTwo,btnThree,btnFour,btnFive,btnSix,btnSeven;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        initView();


    }



    private void initView() {
        btnOne = (Button) findViewById(R.id.btn_one);
        btnOne.setOnClickListener(this);

        btnTwo = (Button) findViewById(R.id.btn_two);
        btnTwo.setOnClickListener(this);

        btnThree = (Button) findViewById(R.id.btn_three);
        btnThree.setOnClickListener(this);

        btnFour = (Button) findViewById(R.id.btn_four);
        btnFour.setOnClickListener(this);

        btnFive = (Button) findViewById(R.id.btn_five);
        btnFive.setOnClickListener(this);
        btnSix = (Button) findViewById(R.id.btn_six);
        btnSix.setOnClickListener(this);

        btnSeven = (Button) findViewById(R.id.btn_seven);
        btnSeven.setOnClickListener(this);


        findViewById(R.id.btn_home_page).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        // * TODO turn to some page
        switch (view.getId()){
            case R.id.btn_one:
//                UIHelper.showToash("enter activity_one");
                startActivity(new Intent(this,ActivityOne.class));
                break;
            case R.id.btn_two:
                startActivity(new Intent(this,ActivityTwo.class));
                break;
            case R.id.btn_three:
                startActivity(new Intent(this,ActivityThree.class));
                break;
            case R.id.btn_four:
                startActivity(new Intent(this,ActivityFour.class));
                break;

            case R.id.btn_five:
                startActivity(new Intent(this,ActivityFive.class));
                break;

            case R.id.btn_six:
                startActivity(new Intent(this,ActivitySix.class));
                break;

            case R.id.btn_seven:
                startActivity(new Intent(this,ActivitySeven.class));
                break;
            case R.id.btn_home_page:
                startActivity(new Intent(this,HomePageActivity.class));
                break;
        }
    }
}
