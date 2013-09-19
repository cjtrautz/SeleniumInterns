package com.ontraport.app.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.ontraport.app.tools.AbstractSuite;

@RunWith(Suite.class)
@SuiteClasses(
{
    com.ontraport.app.tests.CreateRule_CreditCardDeclined.class,
    com.ontraport.app.tests.DeleteRule_CreditCardDeclined.class,
    com.ontraport.app.tests.CreateRule_CreditCardCharged.class,
    com.ontraport.app.tests.DeleteRule_CreditCardCharged.class,
    com.ontraport.app.tests.CreateRule_ContactIsAddedToFulfillmentList.class,
    com.ontraport.app.tests.DeleteRule_ContactIsAddedToFulfillmentList.class,
    com.ontraport.app.tests.CreateContact.class,
    com.ontraport.app.tests.DeleteContact.class,
    com.ontraport.app.tests.CreateRule_ClicksTrackedLink.class,
    com.ontraport.app.tests.DeleteRule_ClicksTrackedLink.class,
    com.ontraport.app.tests.CreateRule_ClicksEMailLink.class,
    com.ontraport.app.tests.DeleteRule_ClicksEMailLink.class,
    com.ontraport.app.tests.CreateRule_AFieldMeetsGivenCriteria.class,
    com.ontraport.app.tests.DeleteRule_AFieldMeetsGivenCriteria.class,
    com.ontraport.app.tests.CreateRule_ACertainFieldIsUpdated.class,
    com.ontraport.app.tests.DeleteRule_ACertainFieldIsUpdated.class,
    com.ontraport.app.tests.CreateProduct.class,
    com.ontraport.app.tests.DeleteProduct.class,
    com.ontraport.app.tests.AddGroup.class,
    com.ontraport.app.tests.DeleteGroup.class,
    com.ontraport.app.tests.CreateNote.class,
    com.ontraport.app.tests.DeleteNote.class,
    com.ontraport.app.tests.CreateFulfillment.class,
    com.ontraport.app.tests.DeleteFulfillment.class,
    com.ontraport.app.tests.CreateMessage.class,
    com.ontraport.app.tests.CreateEmailSequence.class,
    com.ontraport.app.tests.DeleteMessage.class,
    com.ontraport.app.tests.DeleteEmailSequence.class,
    com.ontraport.app.tests.CreateFacebook.class,
    com.ontraport.app.tests.DeleteFacebook.class,
    com.ontraport.app.tests.CreateExportContacts.class,
    com.ontraport.app.tests.CreateATag.class,
    com.ontraport.app.tests.DeleteTag.class,
    com.ontraport.app.tests.CreateAPIKeys.class,
    com.ontraport.app.tests.DeleteAPIKeys.class,
    com.ontraport.app.tests.CreateAffiliateTrackingPixel.class,
    com.ontraport.app.tests.Create1SCSync.class,
    com.ontraport.app.tests.AffiliateLink.class,
    com.ontraport.app.tests.AddRoundRobin.class,
    com.ontraport.app.tests.DeleteRoundRobin.class,
    com.ontraport.app.tests.AddWeightedRandom.class,
    com.ontraport.app.tests.DeleteWeightedRandom.class,
    com.ontraport.app.tests.AddColumn.class,
    com.ontraport.app.tests.AddDeleteUserPermissions.class,
    
    com.ontraport.app.tests.AddNewSection.class,
    com.ontraport.app.tests.DeleteSection.class,
    com.ontraport.app.tests.DeleteColumn.class,
    
})
public class Active extends AbstractSuite
{
}
