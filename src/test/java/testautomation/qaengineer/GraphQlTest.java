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
			.header("Authorization","Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6Ik9FWTJSVGM1UlVOR05qSXhSRUV5TURJNFFUWXdNekZETWtReU1EQXdSVUV4UVVRM05EazFNQSJ9.eyJodHRwczovL2hhc3VyYS5pby9qd3QvY2xhaW1zIjp7IngtaGFzdXJhLWRlZmF1bHQtcm9sZSI6InVzZXIiLCJ4LWhhc3VyYS1hbGxvd2VkLXJvbGVzIjpbInVzZXIiXSwieC1oYXN1cmEtdXNlci1pZCI6ImF1dGgwfDY0NTUzZmJjMWM1ODE0MTFkODUwZWY0ZiJ9LCJuaWNrbmFtZSI6ImJvZ2ltYWhlbmRyYTI3IiwibmFtZSI6ImJvZ2ltYWhlbmRyYTI3QGdtYWlsLmNvbSIsInBpY3R1cmUiOiJodHRwczovL3MuZ3JhdmF0YXIuY29tL2F2YXRhci9jOWIwYmVjNjk3Yzc1MmIwMDhkMTZkZWEyNzkzZTM2MT9zPTQ4MCZyPXBnJmQ9aHR0cHMlM0ElMkYlMkZjZG4uYXV0aDAuY29tJTJGYXZhdGFycyUyRmJvLnBuZyIsInVwZGF0ZWRfYXQiOiIyMDIzLTA1LTE1VDE2OjM2OjQzLjUxN1oiLCJpc3MiOiJodHRwczovL2dyYXBocWwtdHV0b3JpYWxzLmF1dGgwLmNvbS8iLCJhdWQiOiJQMzhxbkZvMWxGQVFKcnprdW4tLXdFenFsalZOR2NXVyIsImlhdCI6MTY4NDMzMDU1OCwiZXhwIjoxNjg0MzY2NTU4LCJzdWIiOiJhdXRoMHw2NDU1M2ZiYzFjNTgxNDExZDg1MGVmNGYiLCJhdF9oYXNoIjoieWNsd2gzUmZtNFRRWU45b2JBZkh2dyIsInNpZCI6IlVkbVpfazBHWDhOcnA0U3gzWHNNZEtWTXVsV21nd2FrIiwibm9uY2UiOiJuZGVoZUxVZG45SzRWWm5BYjlIS3ZKRmZmNkxFUnZlTyJ9.CVaYGmnDlyeFwDFTqdRQ9vwHXW1SQUWjK3B342WvZ22FjgA_cn3fgT0ax-QOr97mu4C5e9MHJ1ccSarr26qzBym-p78jBqPnFggEA9namOg9seQekSle_aDTgqJ9SJPxu1q2va_RS8eqja7qf_uiHzPNYdsE9-r5nS9_NivX62kKgVfxLowPY6dkK5xawMaLgZbMnuZ7movrAFJAOtqzMMPT6G7xsyyxxP4xG2CgWDt7vgORxDEJ_Sfh8cIjEBG11rZVoAlj-x0JtLBbZikuH2ZDdOGWAMOSKnBmLgVr1c5cWu0fefkChpAh68XmufXevedaWJzEW1jlzZcAgUfkPw")
				
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
			.header("Authorization","Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6Ik9FWTJSVGM1UlVOR05qSXhSRUV5TURJNFFUWXdNekZETWtReU1EQXdSVUV4UVVRM05EazFNQSJ9.eyJodHRwczovL2hhc3VyYS5pby9qd3QvY2xhaW1zIjp7IngtaGFzdXJhLWRlZmF1bHQtcm9sZSI6InVzZXIiLCJ4LWhhc3VyYS1hbGxvd2VkLXJvbGVzIjpbInVzZXIiXSwieC1oYXN1cmEtdXNlci1pZCI6ImF1dGgwfDY0NTUzZmJjMWM1ODE0MTFkODUwZWY0ZiJ9LCJuaWNrbmFtZSI6ImJvZ2ltYWhlbmRyYTI3IiwibmFtZSI6ImJvZ2ltYWhlbmRyYTI3QGdtYWlsLmNvbSIsInBpY3R1cmUiOiJodHRwczovL3MuZ3JhdmF0YXIuY29tL2F2YXRhci9jOWIwYmVjNjk3Yzc1MmIwMDhkMTZkZWEyNzkzZTM2MT9zPTQ4MCZyPXBnJmQ9aHR0cHMlM0ElMkYlMkZjZG4uYXV0aDAuY29tJTJGYXZhdGFycyUyRmJvLnBuZyIsInVwZGF0ZWRfYXQiOiIyMDIzLTA1LTE1VDE2OjM2OjQzLjUxN1oiLCJpc3MiOiJodHRwczovL2dyYXBocWwtdHV0b3JpYWxzLmF1dGgwLmNvbS8iLCJhdWQiOiJQMzhxbkZvMWxGQVFKcnprdW4tLXdFenFsalZOR2NXVyIsImlhdCI6MTY4NDMzMDU1OCwiZXhwIjoxNjg0MzY2NTU4LCJzdWIiOiJhdXRoMHw2NDU1M2ZiYzFjNTgxNDExZDg1MGVmNGYiLCJhdF9oYXNoIjoieWNsd2gzUmZtNFRRWU45b2JBZkh2dyIsInNpZCI6IlVkbVpfazBHWDhOcnA0U3gzWHNNZEtWTXVsV21nd2FrIiwibm9uY2UiOiJuZGVoZUxVZG45SzRWWm5BYjlIS3ZKRmZmNkxFUnZlTyJ9.CVaYGmnDlyeFwDFTqdRQ9vwHXW1SQUWjK3B342WvZ22FjgA_cn3fgT0ax-QOr97mu4C5e9MHJ1ccSarr26qzBym-p78jBqPnFggEA9namOg9seQekSle_aDTgqJ9SJPxu1q2va_RS8eqja7qf_uiHzPNYdsE9-r5nS9_NivX62kKgVfxLowPY6dkK5xawMaLgZbMnuZ7movrAFJAOtqzMMPT6G7xsyyxxP4xG2CgWDt7vgORxDEJ_Sfh8cIjEBG11rZVoAlj-x0JtLBbZikuH2ZDdOGWAMOSKnBmLgVr1c5cWu0fefkChpAh68XmufXevedaWJzEW1jlzZcAgUfkPw")
				
			.body(query)
				.when().log().all()
					.post("https://hasura.io/learn/graphql")
						.then().log().all()
							.assertThat()
								.statusCode(200)
									.body("data.users[1].name", equalTo("dassad"));
	}
	
}
