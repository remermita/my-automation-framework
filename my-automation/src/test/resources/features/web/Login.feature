#Author: Rem Ermita
  @TestAutoWeb @WIP
  Feature: Login functionality
  As a registered user
  I want to log in
  So that I can access my account

  Background: User logs on Test page

  Scenario: User successfully logs in on Test page

  Given User is on Login Page
  When User inputs "student" and "Password123"
  And User clicks submit button
  Then User logs in successfully
  And User closes the browser