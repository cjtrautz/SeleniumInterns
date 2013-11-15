package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Account_View;
import com.ontraport.app.pages.Contact_Edit;
import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Tag_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class CreateTagToAddToContact extends AbstractTest
{
    @Test
    public void testCreateTagToAddToContact ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        contactListAll.selectContact(1);
        contactListAll.drawerActions.clickAddRemoveTags();
        contactListAll.drawerActions.clickTagDropDown();
        contactListAll.drawerActions.clickCreateNew();
        contactListAll.drawerActions.enterName(value.get("Contacts", "contact_tag"));
        contactListAll.drawerActions.clickSave();
//        contactListAll.drawerActions.clickTagDropDown();
//        contactListAll.drawerActions.selectDrillDown(value.get("Contacts", "contact_tag"));
        contactListAll.drawerActions.clickSubmit();
        Contact_Edit contact_Edit = contactListAll.clickContact(1);
        driver.navigate().refresh();
        //verify Sel Tag exists
        if(contact_Edit.verifyTag(value.get("Contacts", "contact_tag"))==null)
        {
            fail("couldn't find tag");
        }
        contact_Edit.deleteTag(value.get("Contacts", "contact_tag"));
        if(contact_Edit.verifyNoTag(value.get("Contacts", "contact_tag"))==null)
        {
            fail("found added tag");
        }
        contact_Edit.menuUser.open();
        Account_View account_View = contact_Edit.menuUser.clickAdmin();
        Tag_ListAll tag_ListAll = account_View.clickManageTags();
        tag_ListAll.formSearch.find(value.get("Contacts", "contact_tag"));
        tag_ListAll.selectAllOnPage();
        tag_ListAll.drawerActions.clickDeleteTag();
        tag_ListAll.dialogBox.clickOk();
        tag_ListAll.menuUser.open();
        account_View = tag_ListAll.menuUser.clickAdmin();
        tag_ListAll = account_View.clickManageTags();
        tag_ListAll.formSearch.find(value.get("Contacts", "contact_tag"));
        
        //verify
        if(tag_ListAll.verifyNoTag()==null)
        {
            fail("deleted tag found");
        }
        
    }
}
