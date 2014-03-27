package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_Create;
import com.ontraport.app.pages.Contact_Edit;
import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Message_CreateEmail;
import com.ontraport.app.pages.Message_ListAll;
import com.ontraport.app.pages.Message_TypeSelection;
import com.ontraport.app.pages.WordPress_CreateType2;
import com.ontraport.app.pages.WordPress_TypeSelection;
import com.ontraport.app.tools.AbstractSuite;
//import com.ontraport.app.pages.Sequence_ListAll;
//import com.ontraport.app.pages.Rule_ListAll;
//import com.ontraport.app.pages.Sequence_ListAll;
//import com.ontraport.app.pages.SmartFormFe_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class SendDoubleOptIn extends AbstractTest
{
    @Test
    public void testSendDoubleOptIn () throws InterruptedException
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Contact_Create contact_Create = contactListAll.clickNewContact();
        contact_Create.enterFirstName(value.get("Contacts", "double_optin_first_name"));
        contact_Create.enterLastName(value.get("Contacts", "double_optin_last_name"));
        contact_Create.enterEmail(value.get("Contacts", "double_optin_email"));
        contactListAll = contact_Create.clickSave();
        contactListAll.formSearch.find(value.get("Contacts", "double_optin_email"));
        
       //verify that the contact Exists
        if(contactListAll.verifyContact(value.get("Contacts", "double_optin_email"))==null)
        {
            fail("couldnt find created contact");
        }
        Contact_Edit contact_Edit = contactListAll.clickContact(value.get("Contacts", "double_optin_email"));
        if(contact_Edit.verifyFieldValue(value.get("Contacts", "double_optin_email"))==null)
        {
            fail("couldnt find contact email");
        }
        if(contact_Edit.verifyFieldValue(value.get("Contacts", "double_optin_first_name"))==null)
        {
            fail("couldnt find contact first name");
        }
        if(contact_Edit.verifyFieldValue(value.get("Contacts", "double_optin_last_name"))==null)
        {
            fail("couldnt find contact last name");
        }
        contactListAll = contact_Edit.menuPrimary.clickContactListAll();
        contactListAll.formSearch.clear();
        contactListAll.formSearch.find(value.get("Contacts", "double_optin_email"));
        contactListAll.selectContact(1);
        contactListAll.drawerActions.clickSendDoubleOptIn();
        contactListAll.drawerActions.clickEmailNameDropDown();
        contactListAll.drawerActions.selectDrillDown("Please confirm your subscription.");
        contactListAll.drawerActions.clickEmailFromDropDown();
        contactListAll.drawerActions.selectDropDown(1);
        contactListAll.drawerActions.clickSendFromDropDown();
        contactListAll.drawerActions.selectDropDown(1);
        contactListAll.drawerActions.clickSend();



        


        
    }
}
