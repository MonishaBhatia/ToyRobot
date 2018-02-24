package com.example.monishabhatia.toyrobot;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Created by monishabhatia on 24/02/18.
 */

@RunWith(MockitoJUnitRunner.class)
public class ToyRobotPresenterTest {

    @Mock
    private ToyRobotPresenter presenter;
    @Mock
    private ToyRobotView view;

    @Before
    public void setUp() throws Exception {

        presenter = new ToyRobotPresenter(view);
    }
}
