$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/AccountActivityNavigation.feature");
formatter.feature({
  "name": "Navigating to specific accounts in Accounts Activity",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "\"\u003cAccountName\u003e\" account redirect",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@login"
    }
  ]
});
formatter.step({
  "name": "the user is logged in",
  "keyword": "Given "
});
formatter.step({
  "name": "the Account Summary page should be displayed",
  "keyword": "Then "
});
formatter.step({
  "name": "the user clicks on \"\u003cAccountName\u003e\" link on the Account Summary page",
  "keyword": "When "
});
formatter.step({
  "name": "the Account Activity page should be displayed",
  "keyword": "Then "
});
formatter.step({
  "name": "Account drop down should have \"\u003cAccountName\u003e\" selected",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "AccountName"
      ]
    },
    {
      "cells": [
        "Savings"
      ]
    },
    {
      "cells": [
        "Brokerage"
      ]
    },
    {
      "cells": [
        "Checking"
      ]
    },
    {
      "cells": [
        "Credit Card"
      ]
    },
    {
      "cells": [
        "Loan"
      ]
    }
  ]
});
formatter.scenario({
  "name": "\"Savings\" account redirect",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@login"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "the user is logged in",
  "keyword": "Given "
});
formatter.match({
  "location": "com.zerobank.step_definitions.AccountsActivityDefs.the_user_is_logged_in()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the Account Summary page should be displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "com.zerobank.step_definitions.AccountsActivityDefs.the_Account_Summary_page_should_be_displayed()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user clicks on \"Savings\" link on the Account Summary page",
  "keyword": "When "
});
formatter.match({
  "location": "com.zerobank.step_definitions.AccountsActivityDefs.the_user_clicks_on_link_on_the_Account_Summary_page(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the Account Activity page should be displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "com.zerobank.step_definitions.AccountsActivityDefs.the_Account_Activity_page_should_be_displayed()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Account drop down should have \"Savings\" selected",
  "keyword": "And "
});
formatter.match({
  "location": "com.zerobank.step_definitions.AccountsActivityDefs.the_user_enters_the_sales_manager_information(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "\"Brokerage\" account redirect",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@login"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "the user is logged in",
  "keyword": "Given "
});
formatter.match({
  "location": "com.zerobank.step_definitions.AccountsActivityDefs.the_user_is_logged_in()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the Account Summary page should be displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "com.zerobank.step_definitions.AccountsActivityDefs.the_Account_Summary_page_should_be_displayed()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user clicks on \"Brokerage\" link on the Account Summary page",
  "keyword": "When "
});
formatter.match({
  "location": "com.zerobank.step_definitions.AccountsActivityDefs.the_user_clicks_on_link_on_the_Account_Summary_page(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the Account Activity page should be displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "com.zerobank.step_definitions.AccountsActivityDefs.the_Account_Activity_page_should_be_displayed()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Account drop down should have \"Brokerage\" selected",
  "keyword": "And "
});
formatter.match({
  "location": "com.zerobank.step_definitions.AccountsActivityDefs.the_user_enters_the_sales_manager_information(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "\"Checking\" account redirect",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@login"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "the user is logged in",
  "keyword": "Given "
});
formatter.match({
  "location": "com.zerobank.step_definitions.AccountsActivityDefs.the_user_is_logged_in()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the Account Summary page should be displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "com.zerobank.step_definitions.AccountsActivityDefs.the_Account_Summary_page_should_be_displayed()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user clicks on \"Checking\" link on the Account Summary page",
  "keyword": "When "
});
formatter.match({
  "location": "com.zerobank.step_definitions.AccountsActivityDefs.the_user_clicks_on_link_on_the_Account_Summary_page(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the Account Activity page should be displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "com.zerobank.step_definitions.AccountsActivityDefs.the_Account_Activity_page_should_be_displayed()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Account drop down should have \"Checking\" selected",
  "keyword": "And "
});
formatter.match({
  "location": "com.zerobank.step_definitions.AccountsActivityDefs.the_user_enters_the_sales_manager_information(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "\"Credit Card\" account redirect",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@login"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "the user is logged in",
  "keyword": "Given "
});
formatter.match({
  "location": "com.zerobank.step_definitions.AccountsActivityDefs.the_user_is_logged_in()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the Account Summary page should be displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "com.zerobank.step_definitions.AccountsActivityDefs.the_Account_Summary_page_should_be_displayed()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user clicks on \"Credit Card\" link on the Account Summary page",
  "keyword": "When "
});
formatter.match({
  "location": "com.zerobank.step_definitions.AccountsActivityDefs.the_user_clicks_on_link_on_the_Account_Summary_page(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the Account Activity page should be displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "com.zerobank.step_definitions.AccountsActivityDefs.the_Account_Activity_page_should_be_displayed()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Account drop down should have \"Credit Card\" selected",
  "keyword": "And "
});
formatter.match({
  "location": "com.zerobank.step_definitions.AccountsActivityDefs.the_user_enters_the_sales_manager_information(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "\"Loan\" account redirect",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@login"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "the user is logged in",
  "keyword": "Given "
});
formatter.match({
  "location": "com.zerobank.step_definitions.AccountsActivityDefs.the_user_is_logged_in()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the Account Summary page should be displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "com.zerobank.step_definitions.AccountsActivityDefs.the_Account_Summary_page_should_be_displayed()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user clicks on \"Loan\" link on the Account Summary page",
  "keyword": "When "
});
formatter.match({
  "location": "com.zerobank.step_definitions.AccountsActivityDefs.the_user_clicks_on_link_on_the_Account_Summary_page(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the Account Activity page should be displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "com.zerobank.step_definitions.AccountsActivityDefs.the_Account_Activity_page_should_be_displayed()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Account drop down should have \"Loan\" selected",
  "keyword": "And "
});
formatter.match({
  "location": "com.zerobank.step_definitions.AccountsActivityDefs.the_user_enters_the_sales_manager_information(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});