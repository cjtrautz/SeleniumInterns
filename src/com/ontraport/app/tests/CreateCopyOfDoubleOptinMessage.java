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

public class CreateCopyOfDoubleOptinMessage extends AbstractTest
{
    @Test
    public void testCreateCopyOfDoubleOptinMessage ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        contactListAll.menuUser.open();
        Account_View account_View = contactListAll.menuUser.clickAdmin();
        MessageTemplate_ListAll messageTemplate_ListAll = account_View.clickDoubleOptInOrInvoiceManager();
        MessageTemplate_TypeSelection messageTemplate_TypeSelection = messageTemplate_ListAll.clickNewMessageTemplate();
        messageTemplate_TypeSelection.clickDoubleOptInDropDown();
        MessageTemplate_CreateType1 messageTemplate_CreateType1 = messageTemplate_TypeSelection.selectDropDown(value.get("Messages", "sel_double_opt_in"));
        messageTemplate_ListAll = messageTemplate_CreateType1.clickSave();
        messageTemplate_ListAll.formSearch.find("Copy of " + value.get("Messages", "sel_double_opt_in"));
        
        //verify that it exists
        if(messageTemplate_ListAll.verifyMessage("Copy of " + value.get("Messages", "sel_double_opt_in"))==null)
        {
            fail("couldn't find created message");
        }

        MessageTemplate_Edit messageTemplate_Edit = messageTemplate_ListAll.clickMessage("Copy of " + value.get("Messages", "sel_double_opt_in"));
        if(messageTemplate_Edit.verifyBody("SelBody[First Name]")==null)
        {
            fail("couldn't find message body");
        }
        if(messageTemplate_Edit.verifyReplyTo("selenium@email.com")==null)
        {
            fail("couldn't find reply to");
        }
        if(messageTemplate_Edit.verifySendName("Selenium")==null)
        {
            fail("couldn't find send name");
        }
        if(messageTemplate_Edit.verifySubject("SelSubject")==null)
        {
            fail("couldn't find subject");
        }
        if(messageTemplate_Edit.verifyPlainTextEmail("SelBody")==null)
        {
            fail("couldn't find plain text email");
        }

    }
}
