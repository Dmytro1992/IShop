package httpserver.io.config;

import java.util.Map;

import httpserver.io.HttpResponse;


public interface ReadableHttpResponse extends HttpResponse {

	int getStatus();
	
	Map<String, String> getHeaders();
	
	byte[] getBody();
	
	boolean isBodyEmpty();
	
	int getBodyLength();
}
