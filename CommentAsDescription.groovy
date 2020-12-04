import com.atlassian.jira.component.ComponentAccessor
import java.text.DecimalFormat


def im = ComponentAccessor.issueManager
def issue = im.getIssueByCurrentKey("KH-1")


def STATUS_INPROGRESS = "3"
def STATUS_DONE = "10001"
def STATUS_TODO = "10000"

def df = new DecimalFormat("#0.00")

def total = issue.subTaskObjects.size()
def totalDoneTask = 0

for(i in issue.subTaskObjects){
    if(i.status.id.equals(STATUS_DONE)){
        totalDoneTask++
    }
}



return df.format((totalDoneTask/total)*100) + " % of the subtask is done "