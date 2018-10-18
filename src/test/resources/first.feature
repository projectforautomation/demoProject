Feature: to test login 

@UI
Scenario Outline: with valid credentials
When we enter <username> and <password>
And click on login
Examples:
| username | password |
| bomaster | 12345678 |

