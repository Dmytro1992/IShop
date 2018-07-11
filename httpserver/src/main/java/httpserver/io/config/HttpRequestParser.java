package httpserver.io.config;

import java.io.IOException;
import java.io.InputStream;

import httpserver.io.HttpRequest;
import httpserver.io.exception.HttpServerException;


public interface HttpRequestParser {

	HttpRequest parseHttpRequest(InputStream inputStream, String remoteAddress) throws IOException, HttpServerException;
}
