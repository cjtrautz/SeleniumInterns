package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Message_ListAll;
import com.ontraport.app.tools.AbstractSuite;
//import com.ontraport.app.pages.Sequence_ListAll;
//import com.ontraport.app.pages.Rule_ListAll;
//import com.ontraport.app.pages.Sequence_ListAll;
//import com.ontraport.app.pages.SmartFormFe_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class DeleteBroadCastEmail extends AbstractTest
{
    @Test
    public void testDeleteBroadCastEmail () throws InterruptedException
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        Message_ListAll message_ListAll = contactListAll.menuPrimary.clickMessageListAll();
        message_ListAll.formSearch.find(value.get("Messages", "email_message_send2"));
        message_ListAll.selectAllOnPage();
        message_ListAll.drawerActions.clickDeleteMessage();
        message_ListAll.dialogBox.clickOk();
        
        //verify
        if(message_ListAll.verifyNoMessage()==null)
        {
            fail("found deleted message");
        }
        contactListAll = message_ListAll.menuPrimary.clickContactListAll();
        contactListAll.formSearch.clear();
        contactListAll.formSearch.find(value.get("Contacts", "my_email_adress3"));
        contactListAll.selectAllOnPage();
        contactListAll.drawerActions.clickDeleteContacts();
        contactListAll.dialogBox.clickOk();
        
        //verify its gone
        if(contactListAll.verifyNoContact()==null)
        {
            fail("found deleted contatct");
        }

        contactListAll.formSearch.clear();
        
        contactListAll = message_ListAll.menuPrimary.clickContactListAll();
        contactListAll.formSearch.clear();
        contactListAll.formSearch.find(value.get("Contacts", "my_email_adress2"));
        contactListAll.selectAllOnPage();
        contactListAll.drawerActions.clickDeleteContacts();
        contactListAll.dialogBox.clickOk();
        
        //verify its gone
        if(contactListAll.verifyNoContact()==null)
        {
            fail("found deleted contatct");
        }

        contactListAll.formSearch.clear();
    }
}
