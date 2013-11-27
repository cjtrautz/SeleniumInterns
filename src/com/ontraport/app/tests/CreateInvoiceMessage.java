package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Account_View;
import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.MessageTemplate_CreateType1;
import com.ontraport.app.pages.MessageTemplate_Edit;
import com.ontraport.app.pages.MessageTemplate_ListAll;
import com.ontraport.app.pages.MessageTemplate_TypeSelection;
import com.ontraport.app.tools.AbstractTest;

public class CreateInvoiceMessage extends AbstractTest
{
    @Test
    public void testCreateInvoiceMessage ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();


    }
}
