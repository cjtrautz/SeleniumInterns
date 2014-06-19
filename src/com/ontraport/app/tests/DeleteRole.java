package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Account_View;
import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Role_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class DeleteRole extends AbstractTest
{
    @Test
    public void testDeleteRole ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        contactListAll.menuUser.open();
        Account_View account_View = contactListAll.menuUser.clickAdmin();
        Role_ListAll role_ListAll = account_View.clickTeamRolesAndPermissionManagement();
        role_ListAll.formSearch.find("SeleniumRole");
        role_ListAll.selectAllRoles();
        role_ListAll.drawerActions.clickDeleteRole();
        role_ListAll.dialogBox.clickOk();
        //role_ListAll.dialogBox.clickOk();
         
         //verify
        if(role_ListAll.verifyNoRole()==null)
        {
             fail("found delete rule");
        }
        
    }
}
