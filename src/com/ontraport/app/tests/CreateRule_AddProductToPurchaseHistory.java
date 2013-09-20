package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Rule_Create;
import com.ontraport.app.pages.Rule_Edit;
import com.ontraport.app.pages.Rule_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class CreateRule_AddProductToPurchaseHistory extends AbstractTest
{
    @Test
    public void test ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Rule_ListAll rule_ListAll = contactListAll.menuPrimary.clickRuleListAll();
        Rule_Create rule_Create = rule_ListAll.clickNewRule();
        rule_Create.enterRuleName("SelRuleAddProductToPurchaseHistory");
        rule_Create.openWhenTriggerPane(1);
        rule_Create.selectWhenDrillDownPaneOption("Contact is created");
        rule_Create.openThenActionPane(1);
        rule_Create.selectThenDrillDownPaneOption("Add Product to Purchase History");
        rule_Create.openThenActionPane(1);
        rule_Create.selectThenDrillDownPaneOption("SelProduct");
        rule_ListAll = rule_Create.clickSave();
        rule_ListAll.formSearch.find("SelRuleAddProductToPurchaseHistory");
        
        //verify rule exists
        if(rule_ListAll.verifyRule("SelRuleAddProductToPurchaseHistory")==null)
        {
            fail("couldnt find created rule");
        }
        Rule_Edit rule_Edit = rule_ListAll.clickRule("SelRuleAddProductToPurchaseHistory");
        if(rule_Edit.verifyText("Contact is created")==null)
        {
            fail("didnt select when contact is created");
        }
        if(rule_Edit.verifyThenDropDownInputText(1, "SelProduct")==null)
        {
            fail("didnt select product");
        }
        if(rule_Edit.verifyText(" to purchase history")==null)
        {
            fail("didn't select add product to purchase history");
        }
        
    }
}
