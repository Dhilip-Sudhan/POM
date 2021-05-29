Feature:  Login and Enter Change in Filter Navigation

Background: Login and Enter Change in Filter Navigation
	
Given Type username as 'admin'
And Type password as 'India@123'
When Click Login Button
Then Verify Login is successful
Given Enter the Change in Filter Navigation and click Enter

Scenario Outline: Assess Change

And Click Open button
Given Enter the Short Description text in Search field <ShortDesc>
When Click First Match
Given Select the State <StateVal>
And Select Assign To <AssignedTo>
Given Select Assignment Group <AssignmentGroup>
When Click Update button
Then Validate the Updated Changes Reflected

Examples:
|ShortDesc|StateVal|AssignedTo|AssignmentGroup|
|'Dhilip Change'|'Assess'|'ITIL User'|'Software'|
