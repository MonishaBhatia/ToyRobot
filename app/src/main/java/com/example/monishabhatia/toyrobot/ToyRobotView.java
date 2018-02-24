package com.example.monishabhatia.toyrobot;

/**
 * Created by monishabhatia on 24/02/18.
 */

public interface ToyRobotView {

    int getXCords();

    int getyCords();

    String getDirection();

    void showErrorMessage(int msg);

    void setNewCords(int xCord, int yCord);

    void setNewface(String face);
}
