package RestAPI;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;


public class GetMethod {
	
//	@Test(dataProvider="idProvider")
//	public static void test(String id) {
//		given().
//			pathParam("id", id).
//		when().
//			get("https://finanzen.check24.de/accounts/r/frs/productInfo/kreditkarte/{id}").
//		then().
//			assertThat().
//			statusCode(200);
//
//	}
	
	
	//Test with valid ID Given and expected is 200 response code
	@Test
	public static void testForValidId() {
		given().
			pathParam("id", "200007").
		when().
			get("https://finanzen.check24.de/accounts/r/frs/productInfo/kreditkarte/{id}").
		then().
			assertThat().
			statusCode(200);
		
		
	}
	//Test with Invalid ID Given and expected is 404 response code
	@Test
	public static void testForInvalidId() {
		given().
			pathParam("id", "abcd").
		when().
			get("https://finanzen.check24.de/accounts/r/frs/productInfo/kreditkarte/{id}").
		then().
			assertThat().
			statusCode(404);
		}
	//Test with valid ID Given but ID is not present in the DB and expected is 204 response code
	@Test
	public static void testForIdNotPresent() {
		given().
			pathParam("id", "5456").
		when().
			get("https://finanzen.check24.de/accounts/r/frs/productInfo/kreditkarte/{id}").
		then().
			assertThat().
			statusCode(204);
		}
	
	
//	@DataProvider(name="idProvider")
//    public String[][] getCountryData(){     
//        String id[][] = {{"200007"}, {"abcd"}, {"5456"}};
//        return (id);
//    }
}
