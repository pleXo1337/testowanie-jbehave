Scenario: User inputs data on a site
Given user is on a Simple Form test site
When I type TEST into form box and click the button
When I type 10 and 27 numbers and sum them up
Then I assert whether Im getting TEST message and a sum of 37