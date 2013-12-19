package com.ontraport.app.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Task_ListAll;
import com.ontraport.app.tools.AbstractSuite;
//import com.ontraport.app.pages.Sequence_ListAll;
//import com.ontraport.app.pages.Rule_ListAll;
//import com.ontraport.app.pages.Sequence_ListAll;
//import com.ontraport.app.pages.SmartFormFe_ListAll;
import com.ontraport.app.tools.AbstractTest;

public class TaskActions extends AbstractTest
{
    @Test
    public void testTaskActions () throws InterruptedException
    {
        Contact_ListAll contactListAll = (Contact_ListAll) new Contact_ListAll().init();
        Task_ListAll task_ListAll = contactListAll.menuPrimary.clickTaskListAll();
        task_ListAll.formSearch.find(value.get("Messages", "task_subject_new"));
        task_ListAll.selectAll();
        task_ListAll.drawerActions.clickSendEmail();
        if(task_ListAll.verifySendEmailPane()==null)
        {
            fail("no send email");
        }
        task_ListAll.drawerActions.clickCancelSendEmail();
        task_ListAll.drawerActions.open();
        task_ListAll.drawerActions.clickReAssign();
        task_ListAll.drawerActions.clickUserDropDown();
        task_ListAll.drawerActions.selectDrillDown(value.get("Admin", "user"));
        task_ListAll.drawerActions.clickSaveReAssign();
        task_ListAll.formSearch.clear();
        task_ListAll.formSearch.find(value.get("Messages", "task_subject_new"));
        if(task_ListAll.verifyAssignee(value.get("Admin", "user"))==null)
        {
            fail("did not reassign");
        }
        task_ListAll.selectAll();
        task_ListAll.drawerActions.clickReschedule();
        task_ListAll.drawerActions.clickDateSelectorInput();
        if(task_ListAll.verifyDateSelector()==null)
        {
            fail("couldnt find date selector");
        }
        task_ListAll.selectAll();
        task_ListAll.selectAll();
        task_ListAll.drawerActions.clickCancelTask();
        task_ListAll.dialogBox.clickOk();
        task_ListAll.formSearch.clear();
        task_ListAll.formSearch.find(value.get("Messages", "task_subject_new"));
        if(task_ListAll.verifyNoTasks()==null)
        {
            fail("found canceled task");
        }
        
        
    }
}
