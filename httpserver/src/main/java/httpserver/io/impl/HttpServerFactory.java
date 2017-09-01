package httpserver.io.impl;

import java.util.Properties;

import httpserver.io.HandlerConfig;
import httpserver.io.HttpServer;
import httpserver.io.config.HttpServerConfig;


public class HttpServerFactory {
	protected HttpServerFactory(){
		
	}
	
	public static HttpServerFactory create() {
		return new HttpServerFactory();
	}
	
	public HttpServer createHttpServer(HandlerConfig handlerConfig, Properties overrideServerProperties) {
		HttpServerConfig httpServerConfig = new DefaultHttpServerConfig(handlerConfig, overrideServerProperties);
		return new DefaultHttpServer(httpServerConfig);
	}
}
