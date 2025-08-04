#Author: Rem Ermita
@TestAutoGetApi
Feature: GET all Users
  As an admin
  I want to get all users
  So that I can check all the active users

  Background: Get all users

  Scenario: GET users returns 200 status
    
    Given User sends a GET request to "endpoint"
    And Response status code should be 200
    Then Response should return all users