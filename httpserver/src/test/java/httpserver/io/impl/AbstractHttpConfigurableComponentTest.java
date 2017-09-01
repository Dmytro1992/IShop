package httpserver.io.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import httpserver.io.config.HttpServerConfig;
import httpserver.io.impl.AbstractHttpConfigurableComponent;

public class AbstractHttpConfigurableComponentTest {
	private HttpServerConfig httpServerConfig;
	AbstractHttpConfigurableComponent rv = new AbstractHttpConfigurableComponent(httpServerConfig);
	@Test
	public void  AbstractHttpConfigurableComponent(){ 
		assertEquals(rv.httpServerConfig,httpServerConfig); 
	}
}
