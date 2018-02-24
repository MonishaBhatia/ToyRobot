package com.example.monishabhatia.toyrobot;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
    public void onClickPlace() {
        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        tvReport.setText(EMPTY);

        if (validateFields()) {
            xCord = getXCords();
            yCord = getyCords();
            face = getDirection();
        }
    }

    @OnClick(R.id.btn_move)
    public void onClickMove() {
        toyRobotPresenter.movetoy(xCord, yCord, face);
        tvReport.setText(EMPTY);
    }

    @OnClick(R.id.btn_left)
    public void onClickLeft() {
        toyRobotPresenter.turnLeft(face);
        tvReport.setText(EMPTY);
    }

    @OnClick(R.id.btn_right)
    public void onClickRight() {
        toyRobotPresenter.turnRight(face);
        tvReport.setText(EMPTY);
    }

    @OnClick(R.id.btn_report)
    public void onClickReport() {
        tvReport.setText(xCord + "," + yCord + "," + face);
    }

    @Override
    public int getXCords() {
        if (edtXCords.getText().toString().isEmpty()) {
            edtXCords.setText("0");
            return 0;
        } else {
            return Integer.parseInt(edtXCords.getText().toString());
        }
    }

    @Override
    public int getyCords() {
        if (edtYCords.getText().toString().isEmpty()) {
            edtYCords.setText("0");
            return 0;
        } else {
            return Integer.parseInt(edtYCords.getText().toString());
        }
    }

    @Override
    public String getDirection() {
        return edtFace.getText().toString();
    }

    @Override
    public void showErrorMessage(int msg) {
        Toast.makeText(this, getString(msg), Toast.LENGTH_LONG).show();
    }

    @Override
    public void setNewCords(int xCord, int yCord) {
        this.xCord = xCord;
        this.yCord = yCord;
    }

    @Override
    public void setNewface(String face) {
        this.face = face;
    }

    private boolean validateFields() {

        if (!toyRobotPresenter.validateXY(getXCords())) {
            showErrorMessage(R.string.cord_error);
            return false;
        }
        if (!toyRobotPresenter.validateXY(getyCords())) {
            showErrorMessage(R.string.cord_error);
            return false;
        }

        if (!toyRobotPresenter.validateDir(edtFace.getText().toString())) {
            showErrorMessage(R.string.dir_error);
            return false;
        }
        return true;
    }
}
