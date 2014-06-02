package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Message_Edit;
import com.ontraport.app.pages.Message_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class WorkflowEnsureItemStore extends AbstractTest
{
    @Test
    public void testWorkflowEnsureItemStore()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        contactListAll.selectAllOnPage();
        contactListAll.drawerActions.clickSendEmail();
        contactListAll.drawerActions.clickEmailNameDropDown();
        Message_Edit message_Edit = contactListAll.drawerActions.selectDropDown(1);
        message_Edit.enterMessageName("SeleniumWorkflowItem");
//        message_Edit.enterSendOutName("Selenium");
//        message_Edit.enterReplyToEmail("selenium@email.com");
        message_Edit.openMailFromPane();
        message_Edit.selectMailFrom(1);
        message_Edit.enterSubject("SelSubject");
        contactListAll = message_Edit.menuPrimary.clickContactListAll();
        contactListAll.menuWorkflow.open();
        
        if(contactListAll.menuWorkflow.verifyWorkflowItem("Creating new Message")==null)
        {
            fail("couldnt find new message workflow");
        }
        message_Edit = contactListAll.menuWorkflow.clickWorkflowItem("Creating new Message");
        message_Edit.enterMessageBody("test");
        contactListAll = message_Edit.clickSave2();
        Message_ListAll message_ListAll = contactListAll.menuPrimary.clickMessageListAll();
        message_ListAll.formSearch.find("SeleniumWorkflowItem");
        message_ListAll.selectAllOnPage();
        message_ListAll.drawerActions.clickDeleteMessage();
        message_ListAll.dialogBox.clickOk();
        message_ListAll.menuWorkflow.open();
        
        if(message_ListAll.menuWorkflow.verifyNoWorkflowItem("Creating new Message")==null)
        {
            fail("found workflow message");
        }
        message_ListAll.menuWorkflow.close();
    }
}
