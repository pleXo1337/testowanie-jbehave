Scenario: User is clicking on Javascript alerts
Given user is on a Javascript Alert test site
When I click on an Alert Box
Then I assert whether the box appeared and click on OK button
When I click on a Confirm Box and dismiss it
When I click on a Prompt Box, write Asia in it and accept it
Then I assert whether I'm getting "You pressed Cancel!" and "You have entered 'Asia' !" messages.