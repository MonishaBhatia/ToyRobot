package com.example.monishabhatia.toyrobot;

import java.util.Arrays;

/**
 * Created by monishabhatia on 24/02/18.
 */

public class ToyRobotPresenter {

    private ToyRobotView view;
    private static final int MAXCORD = 5;
    private static final String MAXCORDERROR = "Enter Co-ordinates between 0 To 5";

    private String direction[] = {"north", "south", "east", "west"};
    private static final int NORTH = 0;
    private static final int SOUTH = 1;
    private static final int EAST = 2;
    private static final int WEST = 3;

    public ToyRobotPresenter(ToyRobotView view) {
        this.view = view;
    }

    public boolean validateXY(int cord) {

        if (cord >= 0 && cord <= 5) {
            return true;
        } else {
            return false;
        }
    }

    public boolean validateDir(String dir) {
        if (dir != null && dir.isEmpty() && !Arrays.asList(direction).contains(dir.toLowerCase())) {
            return false;
        } else {
            return true;
        }
    }

    public void movetoy(int xCord, int yCord, String face) {

        if (face.equals(direction[NORTH]) || face.equals(direction[SOUTH])) {
            if (validateXY(yCord + 1)) {
                yCord += 1;
            } else {
                view.showErrorMessage(R.string.fall_error);
                return;
            }
        } else {
            if (validateXY(xCord + 1)) {
                xCord += 1;
            } else {
                view.showErrorMessage(R.string.fall_error);
                return;
            }
        }
        view.setNewCords(xCord, yCord);
    }

    public void turnLeft(int xCord, int yCord, String face) {

        if (direction[NORTH].equals(face)) {
            face = direction[WEST];
        } else if (direction[SOUTH].equals(face)) {
            face = direction[EAST];
        } else if (direction[EAST].equals(face)) {
            face = direction[NORTH];
        } else {
            face = direction[SOUTH];
        }
        view.setNewface(face);
    }

    public void turnRight(String face) {

        if (direction[NORTH].equals(face)) {
            face = direction[EAST];
        } else if (direction[SOUTH].equals(face)) {
            face = direction[WEST];
        } else if (direction[EAST].equals(face)) {
            face = direction[SOUTH];
        } else {
            face = direction[NORTH];
        }
        view.setNewface(face);
    }
}
