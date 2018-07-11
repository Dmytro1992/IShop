package httpserver.io.config;

import java.net.Socket;
import java.util.concurrent.ThreadFactory;

import httpserver.io.HttpServerContext;
import httpserver.io.ServerInfo;


public interface HttpServerConfig extends AutoCloseable{

	ServerInfo getServerInfo();
	
	String getStatusMessage(int statusCode);
	
	HttpRequestParser getHttpRequestParser();
	
	HttpResponseBuilder getHttpResponseBuilder();
	
	HttpResponseWriter getHttpResponseWriter();
	
	HttpServerContext getHttpServerContext();
	
	HttpRequestDispatcher getHttpRequestDispatcher();
	
	ThreadFactory getWorkerThreadFactory();
	
	HttpClientSocketHandler buildNewHttpClientSocketHandler(Socket clientSocket);
}
