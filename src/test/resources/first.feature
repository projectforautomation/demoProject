Feature: to test login 

@UI
Scenario Outline: with valid credentials
When we enter <username> and <password>
And click on login
Examples:
| username | password |
| bomaster | 12345678 |
| testret  | 12345678 |


@Api
Scenario Outline: To validate login with database
When login is performed through api with <username> and <password>

Examples:
| username | password |
| bomaster | 12345678 |
| testret  | 12345678 |

