import com.atlassian.jira.event.type.EventDispatchOption
import com.atlassian.jira.component.ComponentAccessor

def commentManager = ComponentAccessor.commentManager
def issueManager = ComponentAccessor.issueManager

if(event == null || event.getIssue() == null) return
def issue = event.getIssue()
def issueId = issue.id

def mutableIssue = issueManager.getIssueObject(issueId)
def comment = commentManager.getLastComment(issue)

if(mutableIssue == null || comment == null) return
mutableIssue.setDescription(comment.getBody())

issueManager.updateIssue(event.user, mutableIssue, EventDispatchOption.ISSUE_UPDATED, false)
