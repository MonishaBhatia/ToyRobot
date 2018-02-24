package com.example.monishabhatia.toyrobot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ToyRobotActivity extends AppCompatActivity {

    @BindView(R.id.edt_x_cords)
    EditText edtXCords;
    @BindView(R.id.edt_y_cords)
    EditText edtYCords;
    @BindView(R.id.edt_face)
    EditText edtFace;
    @BindView(R.id.btn_place)
    Button btnPlace;
    @BindView(R.id.btn_move)
    Button btnMove;
    @BindView(R.id.btn_left)
    Button btnLeft;
    @BindView(R.id.btn_right)
    Button btnRight;
    @BindView(R.id.btn_report)
    Button btnReport;
    @BindView(R.id.tv_report)
    TextView tvReport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toy_robot);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_place)
    public void onClickPlace(){

    }

    @OnClick(R.id.btn_move)
    public void onClickMove(){

    }

    @OnClick(R.id.btn_left)
    public void onClickLeft(){

    }

    @OnClick(R.id.btn_right)
    public void onClickRight(){

    }

    @OnClick(R.id.btn_report)
    public void onClickReport(){

    }

}
