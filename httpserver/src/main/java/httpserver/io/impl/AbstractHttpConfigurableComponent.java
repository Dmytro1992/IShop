package httpserver.io.impl;

import httpserver.io.config.HttpServerConfig;


class AbstractHttpConfigurableComponent {
	final HttpServerConfig httpServerConfig;

	AbstractHttpConfigurableComponent(HttpServerConfig httpServerConfig) {
		super();
		this.httpServerConfig = httpServerConfig;
	}
}
