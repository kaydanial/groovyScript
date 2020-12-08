import com.atlassian.jira.component.ComponentAccessor

def im = ComponentAccessor.issueManager

//Remove this line if using post method
def issue = im.getIssueByCurrentKey("KH-1")

if(issue == null || issue.subTaskObjects == null) return

return issue.subTaskObjects.size()