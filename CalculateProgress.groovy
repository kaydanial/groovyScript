import com.atlassian.jira.component.ComponentAccessor
import java.text.DecimalFormat

// Declare constant for possible status to keep track
def STATUS_INPROGRESS = "3"
def STATUS_DONE = "10001"
def STATUS_TODO = "10000"

def ISSUE_NOT_EXIST_TEXT = "Issue does not exist"
def NO_SUBTASK_TEXT = "no subtask"
def SUBTASK_COMPLETED_TEXT = " %s percent of the subtask is done"

def df = new DecimalFormat("#0.00")

if(issue == null) return ISSUE_NOT_EXIST_TEXT

if(issue.subTaskObjects == null || issue.subTaskObjects.size() == 0) return NO_SUBTASK_TEXT

def total = issue.subTaskObjects.size()
def totalDoneTask = 0

for(i in issue.subTaskObjects){

    if(i.status.id.equals(STATUS_DONE)){
        totalDoneTask++
    }
}


return String.format(SUBTASK_COMPLETED_TEXT, (totalDoneTask/total)*100)
