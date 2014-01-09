package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_Edit;
import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Order_Form;
import com.ontraport.app.pages.Purchase_ListAll;
import com.ontraport.app.pages.SalesReport_ListAll;
import com.ontraport.app.pages.SmartFormFe_Edit;
import com.ontraport.app.pages.SmartFormFe_ListAll;
import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;
import com.ontraport.app.tools.AbstractSuite;
//import com.ontraport.app.pages.Sequence_ListAll;
//import com.ontraport.app.pages.Rule_ListAll;
//import com.ontraport.app.pages.Sequence_ListAll;
//import com.ontraport.app.pages.SmartFormFe_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class SubmitOrderForm extends AbstractTest
{
    @Test
    public void testSubmitOrderForm () throws InterruptedException
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        SmartFormFe_ListAll smartFormFe_ListAll = contactListAll.menuPrimary.clickSmartFormFeListAll();
        SmartFormFe_Edit smartFormFe_Edit = smartFormFe_ListAll.clickSmartform(value.get("SmartForms", "orderForm"));
        smartFormFe_Edit.clickSettings();
        smartFormFe_Edit.clickTagDropDown();
        smartFormFe_Edit.selectDropDown(value.get("Contacts", "tag"));
        smartFormFe_Edit.clickSequenceDropDown();
        smartFormFe_Edit.selectDropDown(value.get("Sequences", "step_rule_sequence"));
        smartFormFe_Edit.clickAddRule();
        smartFormFe_Edit.enterRuleName(value.get("SmartForms", "rule_name"));
        smartFormFe_Edit.clickIfDropDown();
        smartFormFe_Edit.selectDropDown("If Contact is subscribed to Tag");
        smartFormFe_Edit.clickIfDropDown();
        smartFormFe_Edit.selectDropDown(value.get("Contacts", "tag"));
        smartFormFe_Edit.clickThenDropDown();
        smartFormFe_Edit.enterThenInputForDropDown("Change", 1);
        smartFormFe_Edit.selectDropDown("Change the value of a field");
        smartFormFe_Edit.clickThenDropDown();
        smartFormFe_Edit.selectDropDown("First Name");
        smartFormFe_Edit.enterThenInput(value.get("SmartForms", "change"), 2);
        smartFormFe_Edit.clickRuleSave();
        smartFormFe_Edit.clickSave();  
        smartFormFe_ListAll = contactListAll.menuPrimary.clickSmartFormFeListAll();
        smartFormFe_ListAll.formSearch.find(value.get("SmartForms", "orderForm"));

        //verify Sel Tag exists
        if(smartFormFe_ListAll.verifySmartForm(value.get("SmartForms", "orderForm"))==null)
        {
            fail("couldn't find smartform");
        }
        smartFormFe_Edit = smartFormFe_ListAll.clickSmartform(value.get("SmartForms", "orderForm"));
        smartFormFe_Edit.clickSettings();
        if(smartFormFe_Edit.verifyTag(value.get("Contacts", "tag"))==null)
        {
            fail("couldn't find tag");
        }
        if(smartFormFe_Edit.verifySequence(value.get("Sequences", "step_rule_sequence"))==null)
        {
            fail("couldn't find sequence");
        }
        if(smartFormFe_Edit.verifyRule(value.get("SmartForms", "rule_name"))==null)
        {
            fail("couldn't find rule");
        }
        smartFormFe_Edit.clickRule(value.get("SmartForms", "rule_name"));
        if(smartFormFe_Edit.verifyIfDropDown(value.get("Contacts", "tag"))==null)
        {
            fail("couldn't find if");
        }
        if(smartFormFe_Edit.verifyThenInput("First Name", 1)==null)
        {
            fail("couldn't find then");
        }
        if(smartFormFe_Edit.verifyThenInput(value.get("SmartForms", "change"), 2)==null)
        {
            fail("couldn't find then 2");
        }
        driver.navigate().refresh();
        AbstractPart.waitForAjax(driver, 20);
        driver.get(value.get("LandingPages", "Easy_Landing_Page_Form") + AbstractSuite.UNIQUE + ".respond.ontraport.net");
        
        Order_Form order_Form = (Order_Form) new Order_Form().init();
        order_Form.enterFirstName(value.get("SmartForms", "order_first_name"));
        order_Form.enterEmail(value.get("SmartForms", "order_email"));
        order_Form.enterBillingAddress(value.get("SmartForms", "order_billing_address"));
        order_Form.enterBillingCity(value.get("SmartForms", "order_billing_city"));
        order_Form.enterBillingZip(value.get("SmartForms", "order_billing_zip"));
        order_Form.clickState();
        order_Form.enterState("C");
        order_Form.clickCountry();
        order_Form.enterCountry("U");
        order_Form.enterCardNumber(value.get("SmartForms", "order_billing_card"));
        order_Form.enterCVCNumber(value.get("SmartForms", "order_billing_cvc"));
        order_Form.clickMonth();
        order_Form.enterMonth("1");
        order_Form.clickYear();
        order_Form.enterYear("2");
        order_Form.enterYear("2");
        order_Form.clickSubmit();
        if(order_Form.verifyPage()==null)
        {
            fail("did not submit");
        }
        driver.get(AbstractPage.getUrl() + "?track_requests=1/#!/contact/listAll");
        driver.navigate().refresh();
        AbstractPart.waitForAjax(driver, 20);
        contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        contactListAll.formSearch.find(value.get("SmartForms", "change"));
        if(contactListAll.verifyContact(value.get("SmartForms", "change"))==null)
        {
            fail("Contact not added to records");
        }
        Contact_Edit contact_Edit = contactListAll.clickContact(value.get("SmartForms", "change"));
        if(contact_Edit.verifyFirstName(value.get("SmartForms", "change"))==null)
        {
            fail("couldnt find first name");
        }
        if(contact_Edit.verifySequence(value.get("Sequences", "step_rule_sequence"))==null)
        {
            fail("couldnt find sequence");
        }
        if(contact_Edit.verifyTag(value.get("Contacts", "tag"))==null)
        {
            fail("couldnt find tag");
        }
        Purchase_ListAll purchase_ListAll = contact_Edit.menuPrimary.clickPurchaseListAll();
        if(purchase_ListAll.verifyPurchase(value.get("SmartForms", "product") + AbstractSuite.UNIQUE)==null)
        {
            fail("couldnt find tag");
        }
        contactListAll = purchase_ListAll.menuPrimary.clickContactListAll();
        contactListAll.formSearch.clear();
        contactListAll.formSearch.find(value.get("SmartForms", "change"));
        contactListAll.selectAllOnPage();
        contactListAll.drawerActions.clickDeleteContacts();
        contactListAll.dialogBox.clickOk();
        
        //verify its gone
        if(contactListAll.verifyNoContact()==null)
        {
            fail("found deleted contatct");
        }

        
    }
}
