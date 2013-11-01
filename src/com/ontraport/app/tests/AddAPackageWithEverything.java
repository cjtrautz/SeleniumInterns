package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Account_View;
import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Package_Create;
import com.ontraport.app.pages.Package_Edit;
import com.ontraport.app.pages.Package_ListAll;
import com.ontraport.app.tools.AbstractSuite;
//import com.ontraport.app.pages.Sequence_ListAll;
//import com.ontraport.app.pages.Rule_ListAll;
//import com.ontraport.app.pages.Sequence_ListAll;
//import com.ontraport.app.pages.SmartFormFe_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class AddAPackageWithEverything extends AbstractTest
{
    @Test
    public void test () throws InterruptedException
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        Account_View account_View = contactListAll.menuUser.clickAdmin();
        Package_ListAll package_ListAll = account_View.clickPackageManager();
        Package_Create package_Create = package_ListAll.clickNewPackage();
        package_Create.enterName(value.get("Packages", "package_all"));
        package_Create.enterPrice(value.get("Packages", "price"));
        package_Create.clickAddItem();
        package_Create.dialogBox.clickTagDropDown();
        package_Create.dialogBox.selectDrillDown(value.get("Contacts", "tag"));
        package_Create.dialogBox.clickAddTag();
        package_Create.dialogBox.clickMessageDropDown();
        package_Create.dialogBox.selectDrillDown(value.get("Messages", "email_message"));
        package_Create.dialogBox.clickAddMessage();
//        package_Create.dialogBox.clickSequenceDropDown();
//        package_Create.dialogBox.selectDrillDown(value.get("Sequences", "step_rule_sequence"));
//        package_Create.dialogBox.clickAddSequence();
//        package_Create.dialogBox.clickLandingPageDropDown();
//        package_Create.dialogBox.selectDrillDown(value.get("LandingPages", "Easy_Landing_Page_Form"));
//        package_Create.dialogBox.clickAddLandingPage();
//        package_Create.dialogBox.clickFormsDropDown();
//        package_Create.dialogBox.selectDrillDown(value.get("SmartForms", "orderForm"));
//        package_Create.dialogBox.clickAddForms();
//        package_Create.dialogBox.clickRulesDropDown();
//        package_Create.dialogBox.selectDrillDown(value.get("Rules", "Ping_Url_Name"));
//        package_Create.dialogBox.clickAddRules();
//        package_Create.dialogBox.clickSectionDropDown();
//        package_Create.dialogBox.selectDrillDown(value.get("Fields", "New_Section"));
//        package_Create.dialogBox.clickAddSections();
//        package_Create.dialogBox.clickStaffDropDown();
//        package_Create.dialogBox.selectDrillDown(value.get("Fields", "New_Section"));
//        package_Create.dialogBox.clickAddStaff();
//        package_Create.dialogBox.clickDone();
//        package_ListAll = package_Create.clickSave();
//        package_ListAll.formSearch.find(value.get("Packages", "package_all"));
//        
//        if(package_ListAll.verifyPackage(value.get("Packages", "package_all"))==null)
//        {
//            fail("couldnt find package");
//        }
//        Package_Edit package_Edit = package_ListAll.clickPackage(value.get("Packages", "package_all"));
//        
//        if(package_Edit.verifyPrice(value.get("Packages", "price"))==null)
//        {
//            fail("couldnt find package price");
//        }
//        if(package_Edit.verifyField("Tag", value.get("Contacts", "tag"))==null)
//        {
//            fail("couldnt find package tag");
//        }
//        if(package_Edit.verifyField("Message", value.get("Messages", "email_message"))==null)
//        {
//            fail("couldnt find package tag");
//        }
//        if(package_Edit.verifyField("Sequence", value.get("Sequences", "step_rule_sequence"))==null)
//        {
//            fail("couldnt find package tag");
//        }
//        if(package_Edit.verifyField("Landing Page", value.get("LandingPages", "Easy_Landing_Page_Form"))==null)
//        {
//            fail("couldnt find package tag");
//        }
//        if(package_Edit.verifyField("Form", value.get("SmartForms", "orderForm"))==null)
//        {
//            fail("couldnt find package tag");
//        }
//        if(package_Edit.verifyField("Rule", value.get("Rules", "Ping_Url_Name"))==null)
//        {
//            fail("couldnt find package tag");
//        }
//        if(package_Edit.verifyField("Section", value.get("Fields", "New_Section"))==null)
//        {
//            fail("couldnt find package tag");
//        }
//        if(package_Edit.verifyField("Staff", value.get("Fields", "New_Section"))==null)
//        {
//            fail("couldnt find package tag");
//        }
        
    }
}
