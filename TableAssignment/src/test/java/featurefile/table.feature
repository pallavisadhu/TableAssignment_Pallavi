Feature: Bears Table

Background: 
When the user navigate to the url "http://seleniumtableassignment.s3-website-us-west-2.amazonaws.com/"			

Scenario: Verify only details of black bears are displayed on the Bear Table
And the user verifies the details in the bears table
Then the number of rows returned should be 3
And close the browser

Scenario: Verify only details of cats with weight less than 15lbs is added to the table on the CAT TABLE below
And the user verifies the details in the cat table
Then it should return "false"
And close the browser


Scenario: Verify only two rows are displayed on the STAR WARS Table below
And the user verifies the number of rows in the STAR WARS table
Then the number of rows should be 2
And close the browser


Scenario: Verify that the values in the Description column has less than 350 characters
And the user counts number of characters in the description column
Then the user should return "true"
And close the browser
