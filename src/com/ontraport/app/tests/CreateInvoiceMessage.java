package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Account_View;
import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.MessageTemplate_CreateType1;
import com.ontraport.app.pages.MessageTemplate_CreateType2;
import com.ontraport.app.pages.MessageTemplate_Edit;
import com.ontraport.app.pages.MessageTemplate_ListAll;
import com.ontraport.app.pages.MessageTemplate_TypeSelection;
import com.ontraport.app.pages.SalesReport_Settings;
import com.ontraport.app.tools.AbstractTest;

public class CreateInvoiceMessage extends AbstractTest
{
    @Test
    public void testCreateInvoiceMessage ()
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        SalesReport_Settings salesReport_Settings = contactListAll.menuPrimary.clickSalesReportSettings();
        MessageTemplate_ListAll messageTemplate_ListAll = salesReport_Settings.clickDoubleOptInInvoiceManager();
        MessageTemplate_TypeSelection messageTemplate_TypeSelection = messageTemplate_ListAll.clickNewMessageTemplate();
        MessageTemplate_CreateType2 messageTemplate_CreateType2 = messageTemplate_TypeSelection.clickCreateInvoice();
        messageTemplate_CreateType2.enterMessageName(value.get("Sales", "invoice_message"));
        messageTemplate_CreateType2.enterSendOutName(value.get("Sales", "stuff"));
        messageTemplate_CreateType2.enterReplyToEmail(value.get("Sales", "stuff"));
        messageTemplate_CreateType2.openMailFromPane();
        messageTemplate_CreateType2.selectMailFrom(1);
        messageTemplate_CreateType2.enterSubject(value.get("Sales", "stuff"));
        messageTemplate_CreateType2.enterMessageBody(value.get("Sales", "stuff"));
        messageTemplate_CreateType2.openMergeFieldPane();
        messageTemplate_CreateType2.selectMergeField("First Name");
        messageTemplate_CreateType2.enterMessagePlainTextBody(value.get("Sales", "stuff"));
        messageTemplate_ListAll = messageTemplate_CreateType2.clickSave();
        messageTemplate_ListAll.formSearch.find(value.get("Sales", "invoice_message"));
        
        //verify that it exists
        if(messageTemplate_ListAll.verifyMessage(value.get("Sales", "invoice_message"))==null)
        {
            fail("couldn't find created message");
        }

        MessageTemplate_Edit messageTemplate_Edit = messageTemplate_ListAll.clickMessage(value.get("Sales", "invoice_message"));
        if(messageTemplate_Edit.verifyBody("[First Name]" + value.get("Sales", "stuff"))==null)
        {
            fail("couldn't find message body");
        }
        if(messageTemplate_Edit.verifyReplyTo(value.get("Sales", "stuff"))==null)
        {
            fail("couldn't find reply to");
        }
        if(messageTemplate_Edit.verifySendName(value.get("Sales", "stuff"))==null)
        {
            fail("couldn't find send name");
        }
        if(messageTemplate_Edit.verifySubject(value.get("Sales", "stuff"))==null)
        {
            fail("couldn't find subject");
        }
        if(messageTemplate_Edit.verifyPlainTextEmail(value.get("Sales", "stuff"))==null)
        {
            fail("couldn't find plain text email");
        }

    }
}
