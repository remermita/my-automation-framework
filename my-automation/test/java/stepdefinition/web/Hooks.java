package stepdefinition.web;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import utils.DriverManager;

public class Hooks {

    @Before
    public void setup() {
        WebDriver driver = DriverManager.getDriver();
    }

    @After
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
