package hellocucumber;

import io.cucumber.java.en.*;

import static org.junit.Assert.assertEquals;


public class StepDefinitions {
	
	private String actualValue="passed";

    @Given("an example scenario")
    public void anExampleScenario() {
    	System.out.println("Inside - an example scenario");
    }

    @When("all step definitions are implemented")
    public void allStepDefinitionsAreImplemented() {
    	System.out.println("Inside - all step definitions are implemented");
    }

    @Then("the scenario passes")
    public void theScenarioPasses() {
    	System.out.println("Inside - the scenario passes");
    }
    
    @Then("result is displayed")
    public void result_is_displayed() {
    	System.out.println("Inside - result is displayed");
    }
    
    @Then("result is {string}")
    public void result_is(String expectedValue) {
    	System.out.println("Inside - result is passed");
    	assertEquals(expectedValue,actualValue);
    	
    	// Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }

}
