# VisionITBatch6
To have a collaborative efforts for API Automation FW.

Date: 29Dec2019
Steps for Branch Creation:
1. Each Test case will represent One Jira Task ID.
2. For Each Jira Task ID we would create one Branch.
3. Create the Branch from Master Branch with name as task ID name. Example, if Jira Id is 11. 
   Then Branch name should be: jira-id-11-get-products-ascending-order
4. Clone the Project
5. Switch to Your branch, which you created. Example: git checkout jira-id-11-get-products-ascending-order
6. For creating your test case, create a seperate Test Ng Class file. For example, TC_GetProductAscendingOrder
7. Create a Seperate Test Method in your class and write Rest Assured Code to validate it. Check Status code and Print Body.
8. Check if your Code is working or not. Use Reporter.log to print the response.
9. Push your code using commands:
  a. git add .
  b. git commit -m" your comments"
  c. git push
10. Once your code is checked in create Pull request for me to review.
11. I will give code review comments and finally merge your code with master.
