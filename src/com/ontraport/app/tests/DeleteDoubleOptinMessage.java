package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Account_View;
import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.MessageTemplate_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class DeleteDoubleOptinMessage extends AbstractTest
{
    @Test
    public void testDeleteDoubleOptinMessage ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        contactListAll.menuUser.open();
        Account_View account_View = contactListAll.menuUser.clickAdmin();
        MessageTemplate_ListAll messageTemplate_ListAll = account_View.clickDoubleOptInOrInvoiceManager();
        messageTemplate_ListAll.formSearch.find("SelDoubleOptInMessage");
        messageTemplate_ListAll.selectAllOnPage();
        messageTemplate_ListAll.drawerActions.clickDeleteTemplate();
        messageTemplate_ListAll.dialogBox.clickOk();
        messageTemplate_ListAll.formSearch.clear();
        messageTemplate_ListAll.formSearch.find("SelDoubleOptInMessage");
        //verify
        if(messageTemplate_ListAll.verifyNoMessage()==null)
        {
            fail("found deleted message");
        }
        
    }
}
