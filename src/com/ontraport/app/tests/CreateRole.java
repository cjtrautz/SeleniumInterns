package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Account_View;
import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Role_Create;
import com.ontraport.app.pages.Role_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class CreateRole extends AbstractTest
{
    @Test
    public void testCreateRole ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        contactListAll.menuUser.open();
        Account_View account_View = contactListAll.menuUser.clickAdmin();
        Role_ListAll role_ListAll = account_View.clickTeamRolesAndPermissionManagement();
        Role_Create role_Create = role_ListAll.clickNewRole();
        role_Create.enterRoleName("SeleniumRole");
        role_Create.clickRoleManagerDropDown();
        role_Create.selectDropDown(2);
        role_ListAll = role_Create.clickSave();
        role_ListAll.formSearch.find("SeleniumRole");
        
        if(role_ListAll.verifyRole("SeleniumRole")==null)
        {
            fail("no Role");
        }
        
    }
}
