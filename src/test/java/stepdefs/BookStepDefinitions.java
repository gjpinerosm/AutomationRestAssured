package stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class BookStepDefinitions {

	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;

	private String ENDPOINT_GET_BOOK_BY_ISBN = "https://www.googleapis.com/books/v1/volumes";

	/**
	 *
	 * @param id: Parametro que contiene el isbn que se concatenara en el request solicitado para la consulta
	 * @url:  https://www.googleapis.com/books/v1/volumes?q=isbn:9781451648546
	 */


	@Given("el libro tiene el id (.*)")
	public void a_book_exists_with_isbn(String id){
		request = given().param("q", "id:" + id);
	}

	@When("un usuario obtiene los datos del libro por el ISBN")
	public void a_user_retrieves_the_book_by_isbn(){
		response = request.when().get(ENDPOINT_GET_BOOK_BY_ISBN);
		System.out.println("response: " + response.prettyPrint());
	}

	@Then("el codigo de estado es (\\d+)")
	public void verify_status_code(int statusCode){
		json = response.then().statusCode(statusCode);
	}

	@And("la respuesta tiene los siguientes datos")
	public void response_equals(Map<String,String> responseFields){
		for (Map.Entry<String, String> field : responseFields.entrySet()) {
			if(StringUtils.isNumeric(field.getValue())){
				json.body(field.getKey(), equalTo(Integer.parseInt(field.getValue())));
			}
			else{
				json.body(field.getKey(), equalTo(field.getValue()));
			}
		}
	}

	@And("la respuesta incluye los datos siguientes en cualquier orden")
	public void response_contains_in_any_order(Map<String,String> responseFields){
		for (Map.Entry<String, String> field : responseFields.entrySet()) {
			if(StringUtils.isNumeric(field.getValue())){
				json.body(field.getKey(), containsInAnyOrder(Integer.parseInt(field.getValue())));
			}
			else{
			    String variableAuxiliar[] = field.getValue().split(",");
			    String variableAuxiliar0 = variableAuxiliar[0];
                String variableAuxiliar1 = variableAuxiliar[1];
				json.body(field.getKey(),hasItems(variableAuxiliar0,variableAuxiliar1));
			}
		}
	}
}


