#Author: Rem Ermita
@TestAutoPostApi
Feature: Create User
  As a new client
  I want to sign up
  So that I can access my account

  Background: Create user

  Scenario: POST user successfully

    Given User successfully POST a new user
    Then User verifies customer Id