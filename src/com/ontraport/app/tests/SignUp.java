package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Login;
import com.ontraport.app.pages.OPPackage_View;
import com.ontraport.app.pages.Ontraport_SignUp;
import com.ontraport.app.tools.AbstractSuite;
//import com.ontraport.app.pages.Sequence_ListAll;
//import com.ontraport.app.pages.Rule_ListAll;
//import com.ontraport.app.pages.Sequence_ListAll;
//import com.ontraport.app.pages.SmartFormFe_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class SignUp extends AbstractTest
{
    @Test
    public void testSignUp () throws InterruptedException
    {
        driver.get("https://signup.ontraport.com/ontraport-beta-signup.php");
        Ontraport_SignUp ontraport_SignUp = (Ontraport_SignUp) new Ontraport_SignUp().init();
        ontraport_SignUp.enterFirstName(value.get("SignUp", "first_name"));
        ontraport_SignUp.enterLastName(value.get("SignUp", "last_name"));
        ontraport_SignUp.enterBusinessName(value.get("SignUp", "business"));
        ontraport_SignUp.enterPhoneNumber(value.get("SignUp", "phone_number"));
        ontraport_SignUp.enterAddress(value.get("SignUp", "address"));
        ontraport_SignUp.enterCity(value.get("SignUp", "city"));
        ontraport_SignUp.enterState("c");
        ontraport_SignUp.enterZip(value.get("SignUp", "zip"));
        ontraport_SignUp.enterCountry("u");
        ontraport_SignUp.enterEmailAddress(value.get("SignUp", "email"));
        ontraport_SignUp.enterEmailAddressAgain(value.get("SignUp", "email"));
        ontraport_SignUp.enterPassword(value.get("SignUp", "pass"));
        ontraport_SignUp.enterPasswordAgain(value.get("SignUp", "pass"));
        ontraport_SignUp.checkAgreeToTerms();
        ontraport_SignUp.clickCreateMyAccount();
        ontraport_SignUp.dialogBox.enterSubDomain(value.get("SignUp", "first_name") + AbstractSuite.UNIQUE);
        ontraport_SignUp.dialogBox.enterReplyToName(value.get("SignUp", "email"));
        ontraport_SignUp.dialogBox.enterBusinessName(value.get("SignUp", "business"));
        ontraport_SignUp.dialogBox.enterBusinessAddress(value.get("SignUp", "address"));
        ontraport_SignUp.dialogBox.enterBusinessCity(value.get("SignUp", "city"));
        ontraport_SignUp.dialogBox.enterBusinessZip(value.get("SignUp", "zip"));
        Contact_ListAll contact_ListAll = ontraport_SignUp.dialogBox.clickSubmit();
        contact_ListAll.menuUser.open();
        OPPackage_View oPPackage_View = contact_ListAll.menuUser.clickAccount();
        oPPackage_View.clickCancelAccount();
        oPPackage_View.dialogBox.checkIKnowDeleted();
        oPPackage_View.dialogBox.checkIKnowNoRecovery();
        oPPackage_View.dialogBox.checkIKnowStopWorking();
        Login login = oPPackage_View.dialogBox.clickCancelAccount();
        
        if(login.verifyPage()==null)
        {
            fail("couldnt cancel account");
        }
    }
}