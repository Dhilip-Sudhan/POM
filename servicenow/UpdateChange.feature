Feature:  Login and Enter Change in Filter Navigation

Background: Login and Enter Change in Filter Navigation
	
Given Type username as 'admin'
And Type password as 'India@123'
When Click Login Button
Then Verify Login is successful
Given Enter the Change in Filter Navigation and click Enter

Scenario Outline: Update Change

And Click Open button
Given Enter the Short Description text in Search field <ShortDesc>
When Click First Match
And Enter Short Description <ShortDescValidation>
And Click Schedule
Given Select Date from Planned Start Date
And Select Date from Planned To Date
Given Check the check box CAB Required
And Enter CAB date and select the Date
When Click Update button
Then Validate the Updated Changes Reflected after CAB <ShortDescValidation>

Examples:
|ShortDesc|ShortDescValidation|
|'Dhilip Change'|'Dhilip Change Auto'|
