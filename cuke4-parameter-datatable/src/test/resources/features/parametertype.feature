Feature: Parameter Conversion for Cucumber-JVM 4

  Scenario: Delimiter Annotation scenario
    Given the user names are jane,john,colin,alice
    Given the users are jane,john,colin,alice

  Scenario: Format Annotation scenario
    Given the date is 2017-11-05T09:54:13

  Scenario: Transformer Annotation scenario
    Given the name is 'John Mich Arthur Doe'
    Given the amount is $91.63

  Scenario: Parameter scenario single arg constructor
    Given the user name is John Doe

  Scenario: Parameter scenario NO single arg constructor
    Given the professor is John Doe

  Scenario: Parameter scenario enum
    Given the professor level is ASSOCIATE

  Scenario: Parameter scenario BigInteger
    Given the biginteger value is 7777777777

  Scenario: Parameter scenario BigDecimal
    Given the bigdecimal value is 77777.77777
