package testautomation.qaengineer;

import static org.testng.Assert.assertEquals;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import testautomation.qaengineer.utils.GraphQLRequest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GraphQlTest {
	@Test
	public void CekTodosCompleted() {
		String query = "{\"query\":\"{\\n  users {\\n    name\\n    todos {\\n      title\\n    }\\n  }\\n}\\n\",\"variables\":null}";
		
		given().log().all()
			.contentType("application/json")
			.header("Authorization","Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6Ik9FWTJSVGM1UlVOR05qSXhSRUV5TURJNFFUWXdNekZETWtReU1EQXdSVUV4UVVRM05EazFNQSJ9.eyJodHRwczovL2hhc3VyYS5pby9qd3QvY2xhaW1zIjp7IngtaGFzdXJhLWRlZmF1bHQtcm9sZSI6InVzZXIiLCJ4LWhhc3VyYS1hbGxvd2VkLXJvbGVzIjpbInVzZXIiXSwieC1oYXN1cmEtdXNlci1pZCI6ImF1dGgwfDY0NTUzZmJjMWM1ODE0MTFkODUwZWY0ZiJ9LCJuaWNrbmFtZSI6ImJvZ2ltYWhlbmRyYTI3IiwibmFtZSI6ImJvZ2ltYWhlbmRyYTI3QGdtYWlsLmNvbSIsInBpY3R1cmUiOiJodHRwczovL3MuZ3JhdmF0YXIuY29tL2F2YXRhci9jOWIwYmVjNjk3Yzc1MmIwMDhkMTZkZWEyNzkzZTM2MT9zPTQ4MCZyPXBnJmQ9aHR0cHMlM0ElMkYlMkZjZG4uYXV0aDAuY29tJTJGYXZhdGFycyUyRmJvLnBuZyIsInVwZGF0ZWRfYXQiOiIyMDIzLTA1LTA1VDE3OjQxOjE3LjI2OFoiLCJpc3MiOiJodHRwczovL2dyYXBocWwtdHV0b3JpYWxzLmF1dGgwLmNvbS8iLCJhdWQiOiJQMzhxbkZvMWxGQVFKcnprdW4tLXdFenFsalZOR2NXVyIsImlhdCI6MTY4MzQ0ODE1MCwiZXhwIjoxNjgzNDg0MTUwLCJzdWIiOiJhdXRoMHw2NDU1M2ZiYzFjNTgxNDExZDg1MGVmNGYiLCJhdF9oYXNoIjoiQUNuRXRXcjhXR0Q4enA4Vlo3WFJZdyIsInNpZCI6IjRzWWtPRERZRm9CTmFPT1lwdWVhckFkYjFjQmtlckZEIiwibm9uY2UiOiI1dFh5MDBhVXpBZ3BqRWRzOFpwZGpCVVFoczVJTGRTWCJ9.hBOuUQiubDBLMxdi3J1_Mi962bU4pAXWRD8jDGcXS8Q91Gwv6-sxJCDlKGuqcTJmurZCZt54XGy3Jucih-oudYGNHgKlRC56xGMecz2N59IwvY1Q8-lYAviW-HUhdTSeBrQ50gTP3QFRwpz32IGZK9yj6TYOitlQIv3E2BP24HYdcENnhm3fLWoBtzxdblrD6usTbI1eM6xIBPBWeWFV-m7QqTL2xOEpJ2xZM6-EHRmUd-e4ogssoQ9J0iuEMR-iHszFnasv9S_xqDbY8xKWourMSxtFsAEBeYfHkBkSQw9zFLdWai06t9pPO4htqIp0yft0da7sCGe75eK1MsSRfg")
				
			.body(query)
				.when().log().all()
					.post("https://hasura.io/learn/graphql")
						.then().log().all()
							.assertThat()
								.statusCode(200)
									.body("data.users[1].todos[1].title", equalTo("Test"));
	}
	
	@Test
	public void getUsersName() {
		String query = "{\"query\":\"{\\n  users(limit:5) {\\n    name\\n  }\\n}\\n\",\"variables\":null}";
		
		given().log().all()
			.contentType("application/json")
			.header("Authorization","Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6Ik9FWTJSVGM1UlVOR05qSXhSRUV5TURJNFFUWXdNekZETWtReU1EQXdSVUV4UVVRM05EazFNQSJ9.eyJodHRwczovL2hhc3VyYS5pby9qd3QvY2xhaW1zIjp7IngtaGFzdXJhLWRlZmF1bHQtcm9sZSI6InVzZXIiLCJ4LWhhc3VyYS1hbGxvd2VkLXJvbGVzIjpbInVzZXIiXSwieC1oYXN1cmEtdXNlci1pZCI6ImF1dGgwfDY0NTUzZmJjMWM1ODE0MTFkODUwZWY0ZiJ9LCJuaWNrbmFtZSI6ImJvZ2ltYWhlbmRyYTI3IiwibmFtZSI6ImJvZ2ltYWhlbmRyYTI3QGdtYWlsLmNvbSIsInBpY3R1cmUiOiJodHRwczovL3MuZ3JhdmF0YXIuY29tL2F2YXRhci9jOWIwYmVjNjk3Yzc1MmIwMDhkMTZkZWEyNzkzZTM2MT9zPTQ4MCZyPXBnJmQ9aHR0cHMlM0ElMkYlMkZjZG4uYXV0aDAuY29tJTJGYXZhdGFycyUyRmJvLnBuZyIsInVwZGF0ZWRfYXQiOiIyMDIzLTA1LTA1VDE3OjQxOjE3LjI2OFoiLCJpc3MiOiJodHRwczovL2dyYXBocWwtdHV0b3JpYWxzLmF1dGgwLmNvbS8iLCJhdWQiOiJQMzhxbkZvMWxGQVFKcnprdW4tLXdFenFsalZOR2NXVyIsImlhdCI6MTY4MzQ0ODE1MCwiZXhwIjoxNjgzNDg0MTUwLCJzdWIiOiJhdXRoMHw2NDU1M2ZiYzFjNTgxNDExZDg1MGVmNGYiLCJhdF9oYXNoIjoiQUNuRXRXcjhXR0Q4enA4Vlo3WFJZdyIsInNpZCI6IjRzWWtPRERZRm9CTmFPT1lwdWVhckFkYjFjQmtlckZEIiwibm9uY2UiOiI1dFh5MDBhVXpBZ3BqRWRzOFpwZGpCVVFoczVJTGRTWCJ9.hBOuUQiubDBLMxdi3J1_Mi962bU4pAXWRD8jDGcXS8Q91Gwv6-sxJCDlKGuqcTJmurZCZt54XGy3Jucih-oudYGNHgKlRC56xGMecz2N59IwvY1Q8-lYAviW-HUhdTSeBrQ50gTP3QFRwpz32IGZK9yj6TYOitlQIv3E2BP24HYdcENnhm3fLWoBtzxdblrD6usTbI1eM6xIBPBWeWFV-m7QqTL2xOEpJ2xZM6-EHRmUd-e4ogssoQ9J0iuEMR-iHszFnasv9S_xqDbY8xKWourMSxtFsAEBeYfHkBkSQw9zFLdWai06t9pPO4htqIp0yft0da7sCGe75eK1MsSRfg")
				
			.body(query)
				.when().log().all()
					.post("https://hasura.io/learn/graphql")
						.then().log().all()
							.assertThat()
								.statusCode(200)
									.body("data.users[1].name", equalTo("dassad"));
	}
	
}
