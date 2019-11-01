Feature: Parameter Conversion for Cucumber-JVM 4

  Scenario: No.1 Delimiter Annotation scenario
    Given the user names are jane,john,colin,alice
    Given the users are jane,john,colin,alice

  Scenario: No.2 Format Annotation scenario
    Given the date is 2017-11-05T09:54:13

  Scenario: No.3 Transformer Annotation scenario
    Given the name is 'John Mich Arthur Doe'
    Given the amount is $91.63

  Scenario: No.4 Parameter scenario single arg constructor
    Given the user name is John Doe

  Scenario: No.5 Parameter scenario NO single arg constructor
    Given the professor is John Doe

  Scenario: No.6 Parameter scenario enum
    Given the professor level is ASSOCIATE

  Scenario: No.7 Parameter scenario BigInteger
    Given the biginteger value is 7777777777

  Scenario: No.8 Parameter scenario BigDecimal
    Given the bigdecimal value is 77777.77777
    
  Scenario: No.9 Group transformer
    Given the total payment is in £ main currency 75 fractional currency 57
