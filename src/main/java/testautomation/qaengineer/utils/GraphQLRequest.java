package testautomation.qaengineer.utils;

public class GraphQLRequest {
	public org.json.JSONObject json;
	
	public GraphQLRequest() {
		json = new org.json.JSONObject();
		
	}
	
	public void setQuery(String query) {
		json.put("query", query);
	}
	
	public void setVariables(String variables) {
		json.put("variables", variables);
	}
	
	public String getJsonString() {
		return json.toString();
	}

}
