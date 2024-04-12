Feature: Test End To End API Functionality for employee endpoints

  Scenario: Create new Employee using HTTP POST Request
    Given get RequestSpecification object
    And user set request header
    And user attach request body for "POST" Request
    When user select HTTP "POST" Request
    Then user capture the employee id
    And user validate status code as 201
    And user validate status line as "201"
    And user validate response time should be below 5000 ms
    And user validate "firstname" , "address" and "emailId" keys
    And user validate firstname, lastname, address values
    And user generate the response logs

  Scenario: Retriev new Employee using HTTP GET Request
    Given get RequestSpecification object
    When user select HTTP "GET" Request
    And user validate status code as 200
    And user validate status line as "200"
    And user validate response time should be below 5000 ms
    And user validate "firstname" , "address" and "emailId" keys
    And user validate firstname, lastname, address values
    And user generate the response logs

  Scenario: update Employee using HTTP PUT Request
    Given get RequestSpecification object
    And user set request header
    And user attach request body for "PUT" Request
    When user select HTTP "PUT" Request
    Then user capture the employee id
    And user validate status code as 200
    And user validate status line as "200"
    And user validate response time should be below 5000 ms
    And user validate "firstname" , "address" and "emailId" keys
    And user validate firstname, lastname, address values
    And user generate the response logs

  Scenario: Retriev new Employee using HTTP GET Request
    Given get RequestSpecification object
    When user select HTTP "GET" Request
    And user validate status code as 200
    And user validate status line as "200"
    And user validate response time should be below 5000 ms
    And user validate "firstname" , "address" and "emailId" keys
    And user validate firstname, lastname, address values
    And user generate the response logs

  Scenario: Retriev new Employee using HTTP DELETE Request
    Given get RequestSpecification object
    When user select HTTP "DELETE" Request
    And user validate status code as 204
    And user validate status line as "204"
    And user validate response time should be below 5000 ms
    And user generate the response logs
    
     Scenario: Retriev new Employee using HTTP GET Request
    Given get RequestSpecification object
    When user select HTTP "GET" Request
    And user validate status code as 500
    And user validate status line as "500"
    And user validate response time should be below 5000 ms
    And user generate the response logs
