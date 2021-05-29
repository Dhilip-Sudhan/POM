Feature:  Login and Enter Change in Filter Navigation

Background: Login and Enter Change in Filter Navigation
	
Given Type username as 'admin'
And Type password as 'India@123'
When Click Login Button
Then Verify Login is successful
Given Enter the Change in Filter Navigation and click Enter

Scenario Outline: Delete change

And Click Open button
Given Enter the Short Description text in Search field <ShortDesc>
When Click First Match
And Click Delete Button
When Click Confirm Delete button
Then Validate No Records Found

Examples:
|ShortDesc|
|'Dhilip Change Auto Updated'|
