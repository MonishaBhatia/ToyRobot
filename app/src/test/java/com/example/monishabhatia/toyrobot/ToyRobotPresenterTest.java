package com.example.monishabhatia.toyrobot;

import android.util.Log;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by monishabhatia on 24/02/18.
 */

@RunWith(MockitoJUnitRunner.class)
public class ToyRobotPresenterTest {

    @Mock
    private ToyRobotPresenter presenter;
    @Mock
    private ToyRobotView view;

    private int xCord;
    private int yCord;
    private String face;

    @Before
    public void setUp() throws Exception {

        presenter = new ToyRobotPresenter(view);
    }

    @Test
    public void testCaseOne() throws Exception {


        presenter.turnLeft(0, 0, "North");
    }

    @Test
    public void testCaseTwo() throws Exception {

        presenter.movetoy(0, 0, "North");
    }

}
