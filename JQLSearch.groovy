import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.web.bean.PagerFilter;

def jqlQueryParser = ComponentAccessor.getComponentOfType(com.atlassian.jira.jql.parser.JqlQueryParser)
def loginUser = ComponentAccessor.getJiraAuthenticationContext().getLoggedInUser();
def searchService = ComponentAccessor.getComponentOfType(com.atlassian.jira.bc.issue.search.SearchService);

//Replace <QUERY> with your desired query base on your usecase
def query = jqlQueryParser.parseQuery("description is EMPTY")

def searchResults = searchService.search(loginUser, query, PagerFilter.getUnlimitedFilter());

//Initiate empty string to be return to the scripted field. By default will return an empty string if search result is empty
String jiraIssues = ""
String delim = ""

if(searchResults == null) return jiraIssues

//loop through the search result and concantenate the issue key into our result
searchResults.getResults().each {
    issue ->
        {
            jiraIssues += delim + issue.getKey()
            delim = " , "
        }
}



return jiraIssues
