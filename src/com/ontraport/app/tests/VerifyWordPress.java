package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.WordPress_Edit;
import com.ontraport.app.tools.AbstractSuite;
//import com.ontraport.app.pages.Sequence_ListAll;
//import com.ontraport.app.pages.Rule_ListAll;
//import com.ontraport.app.pages.Sequence_ListAll;
//import com.ontraport.app.pages.SmartFormFe_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class VerifyWordPress extends AbstractTest
{
    @Test
    public void testVerifyWordPress () throws InterruptedException
    {
        WordPress_Edit wordPress_Edit = (WordPress_Edit) new WordPress_Edit().init();
        String password = AbstractTest.getWPpass();
        if(wordPress_Edit.verifyHosted(value.get("WordPress", "wordpress_domain") + AbstractSuite.UNIQUE, password)==null)
        {
            fail("couldnt find wp membership level");
        }
    }
}
//seleniumwordpress227223236367069