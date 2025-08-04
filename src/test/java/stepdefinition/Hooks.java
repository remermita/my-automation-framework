package stepdefinition;

import com.trustarc.automation.base.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends BaseTest {

    @Before
    public void setUp() {
        // Launch the browser before each scenario
        driver = initializeDriver(); // from BaseTest
        System.out.println("Launching browser...");
    }

    @After
    public void tearDown() {
        // Quit the browser after each scenario
        if (driver != null) {
            driver.quit();
            System.out.println("Browser closed.");
        }
    }
}
