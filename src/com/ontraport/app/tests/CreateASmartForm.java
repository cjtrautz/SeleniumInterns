package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.SmartFormFe_Create;
import com.ontraport.app.pages.SmartFormFe_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class CreateASmartForm extends AbstractTest
{
    @Test
    public void testCreateASmartForm ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        SmartFormFe_ListAll smartFormFe_ListAll = contactListAll.menuPrimary.clickSmartFormFeListAll();
        SmartFormFe_Create smartFormFe_Create = smartFormFe_ListAll.clickNewSmartForm();
        
        //verify Sel Tag exists
        if(smartFormFe_Create.verifySubmitButton()==null)
        {
            fail("couldn't find submit on smartform");
        }
        
    }
}
