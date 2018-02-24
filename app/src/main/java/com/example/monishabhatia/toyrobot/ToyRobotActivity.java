package com.example.monishabhatia.toyrobot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ToyRobotActivity extends AppCompatActivity implements ToyRobotView {

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

    private ToyRobotPresenter toyRobotPresenter;
    private int xCord;
    private int yCord;
    private String face;
    private static final String EMPTY = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toy_robot);
        ButterKnife.bind(this);

        toyRobotPresenter = new ToyRobotPresenter(this);
    }

    @OnClick(R.id.btn_place)
    public void onClickPlace(){
        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        tvReport.setText(EMPTY);

        if(edtXCords.getText().toString().isEmpty()){
            edtXCords.setText("0");
        }

        if(edtYCords.getText().toString().isEmpty()){
            edtYCords.setText("0");
        }

        if(validateFields()){
            xCord = Integer.parseInt(edtXCords.getText().toString());
            yCord = Integer.parseInt(edtYCords.getText().toString());
            face = edtFace.getText().toString();
        }
    }

    @OnClick(R.id.btn_move)
    public void onClickMove(){
        toyRobotPresenter.movetoy(xCord, yCord, face);
        tvReport.setText(EMPTY);
    }

    @OnClick(R.id.btn_left)
    public void onClickLeft(){
        toyRobotPresenter.turnLeft(xCord, yCord, face);
        tvReport.setText(EMPTY);
    }

    @OnClick(R.id.btn_right)
    public void onClickRight(){
        toyRobotPresenter.turnRight(face);
    }

    @OnClick(R.id.btn_report)
    public void onClickReport(){
        tvReport.setText(xCord  + "," + yCord + "," + face);
    }

    @Override
    public void showErrorMessage(int msg) {
        Toast.makeText(this, getString(msg), Toast.LENGTH_LONG).show();
    }

    @Override
    public void setNewCords(int xCord, int yCord) {
        this.xCord = xCord;
        this.yCord = yCord;
        showNewCords();
    }

    private void showNewCords(){
        Toast.makeText(this, xCord  + "," + yCord + "," + face , Toast.LENGTH_LONG).show();
    }

    @Override
    public void setNewface(String face) {
        this.face = face;
        showNewCords();
    }

    private boolean validateFields(){

        if(!toyRobotPresenter.validateXY(Integer.parseInt(edtXCords.getText().toString()))){
            showErrorMessage(R.string.cord_error);
            return false;
        }
        if(!toyRobotPresenter.validateXY(Integer.parseInt(edtYCords.getText().toString()))){
            showErrorMessage(R.string.cord_error);
            return false;
        }

        if(!toyRobotPresenter.vlaidateDir(edtFace.getText().toString())){
            showErrorMessage(R.string.dir_error);
            return false;
        }
        return true;
    }
}
