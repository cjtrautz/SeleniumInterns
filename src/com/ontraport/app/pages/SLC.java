package com.ontraport.app.pages;

import org.openqa.selenium.support.ui.Clock;
import org.openqa.selenium.support.ui.SlowLoadableComponent;

public class SLC extends SlowLoadableComponent<SLC>
{

    public SLC ( Clock clock,
                 int timeOutInSeconds )
    {
        super(clock,
            timeOutInSeconds);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void isLoaded () throws Error
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    protected void load ()
    {
        // TODO Auto-generated method stub
        
    }
}
