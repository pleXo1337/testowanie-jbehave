Scenario: User is downloading a file
Given user is on a download test site
When I click on download button
Then I assert wheter the download was succesful
Then I click a button to finish