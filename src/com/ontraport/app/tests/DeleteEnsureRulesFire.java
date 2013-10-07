package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_Edit;
import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Contact_Settings;
import com.ontraport.app.pages.Rule_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class DeleteEnsureRulesFire extends AbstractTest
{
    @Test
    public void testDeleteEnsureRulesFire ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
         Rule_ListAll rule_ListAll = contactListAll.menuPrimary.clickRuleListAll();
         rule_ListAll.formSearch.find("SelRuleEnsureThatItWillFire");
         rule_ListAll.selectRule("SelRuleEnsureThatItWillFire");
         rule_ListAll.drawerActions.clickDeleteRule();
         rule_ListAll.dialogBox.clickOk();
         
         //verify
         if(rule_ListAll.verifyNoRule()==null)
         {
             fail("found delete rule");
         }
         
         contactListAll = rule_ListAll.menuPrimary.clickContactListAll();
         Contact_Edit contact_Edit = contactListAll.clickContact(1);
         contact_Edit.clickFirstName();
         contact_Edit.enterFirstName("SelFirstName");
         contact_Edit.clickFirstNameSave();
         contact_Edit.clickLastName();
         contact_Edit.enterLastName("SelLastName");
         contact_Edit.clickLastNameSave();
         contactListAll = contact_Edit.menuPrimary.clickContactListAll();
         contact_Edit = contactListAll.clickContact(1);
         
         if(contact_Edit.verifyFirstName("SelFirstName")==null)
         {
             fail("couldn't find firstName");
         }
         if(contact_Edit.verifyLastName("SelLastName")==null)
         {
             fail("couldn't find lasttName");
         }
        
    }
}
