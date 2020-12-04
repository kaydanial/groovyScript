import com.atlassian.jira.component.ComponentAccessor
import java.text.DecimalFormat

def STATUS_INPROGRESS = "3"
def STATUS_DONE = "10001"
def STATUS_TODO = "10000"

def df = new DecimalFormat("#0.00")

def total = issue.subTaskObjects.size()
def totalDoneTask = 0

if(total == 0) return "no subtask"

for(i in issue.subTaskObjects){
    log.warn(i.status.id.class)
    log.warn(STATUS_DONE.class)
    log.warn(i.status.id == STATUS_DONE)

    if(i.status.id.equals(STATUS_DONE)){
        totalDoneTask++
    }
}

return df.format((totalDoneTask/total)*100) + " % of the subtask is done "