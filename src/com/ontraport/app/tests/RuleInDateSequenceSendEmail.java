package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Message_CreateEmail;
import com.ontraport.app.pages.Message_ListAll;
import com.ontraport.app.pages.Message_TypeSelection;
import com.ontraport.app.pages.Sequence_CreateDate;
import com.ontraport.app.pages.Sequence_ListAll;
import com.ontraport.app.pages.Sequence_TypeSelection;
import com.ontraport.app.tools.AbstractSuite;
import com.ontraport.app.tools.AbstractTest;

public class RuleInDateSequenceSendEmail extends AbstractTest
{
    @Test
    public void testRuleInDateSequenceSendEmail () throws InterruptedException
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        
        Message_ListAll message_ListAll = contactListAll.menuPrimary.clickMessageListAll();
        
        Message_TypeSelection message_TypeSelection = message_ListAll.clickNewMessage();
        
        Message_CreateEmail message_CreateEmail = message_TypeSelection.clickEmailCreate();
        message_CreateEmail.enterMessageName(value.get("Messages", "email_message_from_rule_sequence_date"));
        message_CreateEmail.openMailFromPane();
        message_CreateEmail.selectMailFrom(1);
        message_CreateEmail.enterSubject(value.get("Messages", "email_message_from_rule_sequence_date"));
        message_CreateEmail.enterMessageBody(value.get("Messages", "email_body"));
        message_CreateEmail.openMergeFieldPane();
        message_CreateEmail.selectMergeField("First Name");
        
        message_ListAll = message_CreateEmail.clickSave();
        
        Sequence_ListAll sequence_ListAll = contactListAll.menuPrimary.clickSequenceListAll();
        
        Sequence_TypeSelection sequence_TypeSelection = sequence_ListAll.clickNewSequence();
        
        Sequence_CreateDate sequence_CreateDate = sequence_TypeSelection.clickDateSequenceCreate();
        sequence_CreateDate.enterSequenceName(value.get("Sequences", "email_from_rule_sequence_date"));
        sequence_CreateDate.clickAddRuleStep();
        sequence_CreateDate.clickTimeToSendDropDown();
        sequence_CreateDate.enterNextTime();
        sequence_CreateDate.enterRuleName("Date Sequence Rule Test");
        sequence_CreateDate.openThenPane(1);
        sequence_CreateDate.selectThenOption("Send an Email");
        
        sequence_ListAll = sequence_CreateDate.clickSave();
        sequence_ListAll.formSearch.find(value.get("Sequences", "email_from_rule_sequence_date"));
    }
}