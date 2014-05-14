package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Account_View;
import com.ontraport.app.pages.Contact_Create;
import com.ontraport.app.pages.Contact_Edit;
import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Tag_ListAll;
import com.ontraport.app.tools.AbstractSuite;
import com.ontraport.app.tools.AbstractTest;

public class CreateGroupContainsTag extends AbstractTest
{
    @Test
    public void testCreateGroupContainsTag ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        contactListAll = contactListAll.menuPrimary.clickContactListAll();
        Contact_Create contact_Create = contactListAll.clickNewContact();
        contact_Create.enterFirstName("Tag");
        contact_Create.enterLastName("Guy");
        contact_Create.enterEmail("tag@email.com");
        contactListAll = contact_Create.clickSave();
        contact_Create = contactListAll.clickNewContact();
        contact_Create.enterFirstName("ManyTag");
        contact_Create.enterLastName("Guy");
        contact_Create.enterEmail("manytag@email.com");
        contactListAll = contact_Create.clickSave();
        contact_Create = contactListAll.clickNewContact();
        contact_Create.enterFirstName("NoTag");
        contact_Create.enterLastName("Guy");
        contact_Create.enterEmail("notag@email.com");
        contactListAll = contact_Create.clickSave();
        contactListAll.selectContact(2);
        contactListAll.drawerActions.clickAddRemoveTags();
        contactListAll.drawerActions.clickTagDropDown();
        contactListAll.drawerActions.clickCreateNew();
        contactListAll.drawerActions.enterName("GroupTag1");
        contactListAll.drawerActions.clickSave();
        contactListAll.drawerActions.clickTagDropDown();
        contactListAll.drawerActions.clickCreateNew();
        contactListAll.drawerActions.enterName("GroupTag2");
        contactListAll.drawerActions.clickSave();
        contactListAll.drawerActions.clickSubmit();
        contactListAll.selectContact(2);
        contactListAll.selectContact(1);
        contactListAll.drawerActions.clickAddRemoveTags();
        contactListAll.drawerActions.clickTagDropDown();
        contactListAll.drawerActions.selectDrillDown("GroupTag1");
        contactListAll.drawerActions.clickSubmit();
        contactListAll.selectContact(1);
        contactListAll.drawerManageGroups.open();
        contactListAll.drawerManageGroups.enterGroupName("My tag contains group");
        contactListAll.drawerManageGroups.openGroupPermissionsPane();
        contactListAll.drawerManageGroups.clickPermissions("Everyone can view and edit");
        contactListAll.drawerManageGroups.openFieldPane(0);
        contactListAll.drawerManageGroups.clickField("Contact Tags", 0);
        contactListAll.drawerManageGroups.openConditionPane(0);
        contactListAll.drawerManageGroups.clickCondition("Contains", 0);
        contactListAll.drawerManageGroups.openValuePane(0);
        contactListAll.drawerManageGroups.clickValue("GroupTag1", 0);
        contactListAll.drawerManageGroups.clickSave();

        if(contactListAll.verifyNumberOfContacts(2)==null)
        {
            fail("too many contacts");
        }
        if(contactListAll.verifyContact("manytag@email.com")==null)
        {
            fail("no contact 1");
        }
        if(contactListAll.verifyContact("tag@email.com")==null)
        {
            fail("no contact 2");
        }
        contactListAll.drilldownGroup.open();
        contactListAll.drilldownGroup.clickGroup("My tag contains group");
        contactListAll.drawerManageGroups.open();
        contactListAll.drawerManageGroups.clickDeleteGroup();

        if (contactListAll.drilldownGroup.confirmGroupDoesntExists("My First Group"+AbstractSuite.UNIQUE) == false)
        {
            fail("didnt delete group in list");
        }
        contactListAll.selectAllOnPage();
        contactListAll.drawerActions.clickDeleteContacts();
        contactListAll.dialogBox.clickOk();
        
        //verify its gone
        if(contactListAll.verifyNoContact()==null)
        {
            fail("found deleted contatct");
        }
        contactListAll.menuUser.open();
        Account_View account_View = contactListAll.menuUser.clickAdmin();
        Tag_ListAll tag_ListAll = account_View.clickManageTags();
        tag_ListAll.formSearch.find("GroupTag");
        tag_ListAll.selectAllOnPage();
        tag_ListAll.drawerActions.clickDeleteTag();
        tag_ListAll.dialogBox.clickOk();
        tag_ListAll.menuUser.open();
        account_View = tag_ListAll.menuUser.clickAdmin();
        tag_ListAll = account_View.clickManageTags();
        tag_ListAll.formSearch.find("GroupTag");
        
        //verify
        if(tag_ListAll.verifyNoTag()==null)
        {
            fail("deleted tag found");
        }


    }
}
