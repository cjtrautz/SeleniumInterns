package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Account_View;
import com.ontraport.app.pages.Contact_Create;
import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Tag_ListAll;
import com.ontraport.app.tools.AbstractSuite;
//import com.ontraport.app.pages.Sequence_ListAll;
//import com.ontraport.app.pages.Rule_ListAll;
//import com.ontraport.app.pages.Sequence_ListAll;
//import com.ontraport.app.pages.SmartFormFe_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class AddTagToGroupSubset extends AbstractTest
{
    @Test
    public void testAddTagToGroupSubset () throws InterruptedException
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        Contact_Create contact_Create = contactListAll.clickNewContact();
        //create a unique contact that will match group, but not search
        contact_Create.enterFirstName("unique");
        contact_Create.enterLastName("contact");
        contact_Create.enterEmail("unique@selenium.com");
        contactListAll = contact_Create.clickSave();
        //need contacts that match group criteria and enough to trigger pagination
        for (int i = 1; i < 7; i++)
        {
            contact_Create = contactListAll.clickNewContact();
            contact_Create.enterFirstName("test"+i);
            contact_Create.enterLastName("test");
            contact_Create.enterEmail("test"+i+"@selenium.com");
            contactListAll = contact_Create.clickSave();
        }
        contactListAll.drawerManageGroups.open();
        contactListAll.drawerManageGroups.enterGroupName("Group Actions Test");
        contactListAll.drawerManageGroups.openFieldPane(0);
        contactListAll.drawerManageGroups.clickField("Email", 0);
        contactListAll.drawerManageGroups.openConditionPane(0);
        contactListAll.drawerManageGroups.clickCondition("Contains", 0);
        contactListAll.drawerManageGroups.enterValue("@selenium.com", 0, 0);
        contactListAll.drawerManageGroups.clickSave();
        
        if(contactListAll.verifyTotalContactNumber("7") == null)
        {
            fail("incorrect number of contacts in group");
        }
        
        contactListAll.paginator.openRecordsPerPagePane();
        contactListAll.paginator.clickRecordsPerPage(5);
        contactListAll.formSearch.find("test");
        
        if(contactListAll.verifyTotalContactNumber("6") == null)
        {
            fail("incorrect number of contacts in search");
        }

        contactListAll.selectAllOnPage();
        contactListAll.selectAllInGroup();
        contactListAll.drawerActions.clickAddRemoveTags();
        contactListAll.drawerActions.clickTagDropDown();
        contactListAll.drawerActions.clickCreateNew();
        contactListAll.drawerActions.enterName("Group Actions Test");
        contactListAll.drawerActions.clickSave();
        contactListAll.drawerActions.clickSubmit();
        contactListAll.drawerManageGroups.open();
        contactListAll.drawerManageGroups.clickNew();
        contactListAll.drawerManageGroups.enterGroupName("Search Test");
        contactListAll.drawerManageGroups.openFieldPane(0);
        contactListAll.drawerManageGroups.clickField("Contact Tags", 0);
        contactListAll.drawerManageGroups.openConditionPane(0);
        contactListAll.drawerManageGroups.clickCondition("Contains", 0);
        contactListAll.drawerManageGroups.openValuePane(0);
        contactListAll.drawerManageGroups.clickValue("Group Actions Test", 0);
        contactListAll.drawerManageGroups.clickSave();
        
        if(contactListAll.verifyTotalContactNumber("6") == null)
        {
            fail("incorrect number of contacts in final group");
        }
        
        contactListAll.formSearch.find("unique@selenium.com");
        if(contactListAll.verifyNoContact() == null)
        {
            fail("Contact was tagged incorrectly");
        }
        
        contactListAll.drilldownGroup.open();
        contactListAll.drilldownGroup.clickGroup("Group Actions Test");
        contactListAll.formSearch.clear();
        contactListAll.selectAllOnPage();
        contactListAll.selectAllInGroup();
        contactListAll.drawerActions.clickDeleteContacts();
        contactListAll.dialogBox.clickOk();
        
        //verify its gone
        if(contactListAll.verifyNoContact()==null)
        {
            fail("contacts not deleted");
        }
        
        contactListAll.drawerManageGroups.open();
        contactListAll.drawerManageGroups.clickDeleteGroup();

        if (contactListAll.drilldownGroup.confirmGroupDoesntExists("Group Actions Test") == false)
        {
            fail("didnt delete group in list");
        }
             
        contactListAll.drilldownGroup.open();
        contactListAll.drilldownGroup.clickGroup("Search Test");
        contactListAll.drawerManageGroups.open();
        contactListAll.drawerManageGroups.clickDeleteGroup();

        if (contactListAll.drilldownGroup.confirmGroupDoesntExists("Search Test") == false)
        {
            fail("didnt delete group in list");
        }
        
        contactListAll.menuUser.open();
        Account_View account_View = contactListAll.menuUser.clickAdmin();
        Tag_ListAll tag_ListAll = account_View.clickManageTags();
        tag_ListAll.formSearch.find("Group Actions Test");
        tag_ListAll.selectAllOnPage();
        tag_ListAll.drawerActions.clickDeleteTag();
        tag_ListAll.dialogBox.clickOk();
        tag_ListAll.menuUser.open();
        account_View = tag_ListAll.menuUser.clickAdmin();
        tag_ListAll = account_View.clickManageTags();
        tag_ListAll.formSearch.find("Group Actions Test");
        
        //verify
        if(tag_ListAll.verifyNoTag()==null)
        {
            fail("deleted tag found");
        }
    }
}
