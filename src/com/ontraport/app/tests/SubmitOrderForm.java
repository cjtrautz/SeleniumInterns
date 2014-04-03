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
        driver.get(value.get("LandingPages", "Easy_Landing_Page_Form") + AbstractSuite.UNIQUE + ".respond.ontraport.net");
        
        Order_Form order_Form = (Order_Form) new Order_Form().init();
        if(order_Form.verifyTotal("$9.45")==null)
        {
            fail("no tax on hosted");
        }
        if(order_Form.verifyShipping("SelShipping - $3.45")==null)
        {
            fail("no shiiping on hosted");
        }
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
