import com.atlassian.jira.component.ComponentAccessor

def im = ComponentAccessor.issueManager
def issue = im.getIssueByCurrentKey("KH-1")

return issue.subTaskObjects.size()