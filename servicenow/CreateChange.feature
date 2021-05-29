Feature:  Login to the Service now application and Create Change Incident

Background: Login and Enter Change in Filter Navigation
	
Given Type username as 'admin'
And Type password as 'India@123'
When Click Login Button
Then Verify Login is successful
Given Enter the Change in Filter Navigation and click Enter

Scenario Outline: Create Change

When Click Create New button
And Click Normal Change 
Given Capture the Created change number
And Enter Short Description <ShortDesc>
When Click Submit button
And Click Open button
Given Enter the Change number
Then Validate the Create change Number

Examples:
|ShortDesc|
|'Dhilip Change'|
