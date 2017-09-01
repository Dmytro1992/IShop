package httpserver.io.handler;

import java.io.IOException;

import httpserver.io.HttpHandler;
import httpserver.io.HttpRequest;
import httpserver.io.HttpResponse;
import httpserver.io.HttpServerContext;


public class HelloWorldHttpHandler implements HttpHandler {

	@Override
	public void handle(HttpServerContext context, HttpRequest request, HttpResponse response) throws IOException {
		response.setBody("Hello world");
	}
}
