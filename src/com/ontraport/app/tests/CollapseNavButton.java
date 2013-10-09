package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class CollapseNavButton extends AbstractTest
{
    @Test
    public void testCollapseNavButton ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        contactListAll.menuPrimary.collapse();
        if(contactListAll.menuPrimary.verifyMenuCollapsed()==null)
        {
            fail("menu didnt collapse");
        }
        contactListAll.menuPrimary.expand();
        if(contactListAll.menuPrimary.verifyMenuExpanded()==null)
        {
            fail("menu didnt collapse");
        }
    }
}
