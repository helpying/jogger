package org.jogger;

import java.lang.reflect.Method;

import org.jogger.util.Preconditions;

/**
 * Holds the information of a route.
 * 
 * @author German Escobar
 */
public class Route {
	
	public enum HttpMethod {
		GET,
		POST
	}
	
	private final HttpMethod httpMethod;
	
	private final String path;
	
	private final Object controller;
	
	private final Method action;
	
	public Route(HttpMethod httpMethod, String path, Object controller, Method action) {
		Preconditions.notNull(httpMethod, "no httpMethod provided");
		Preconditions.notNull(path, "no path provided");
		Preconditions.notNull(controller, "no controller provided");
		Preconditions.notNull(action, "no action provided");
		
		this.httpMethod = httpMethod;
		this.path = addSlashPrefixTo(path);
		this.controller = controller;
		this.action = action;
	}
	
	private String addSlashPrefixTo(String path) {
		if (!path.startsWith("/")) {
			path = "/" + path;
		}
		
		return path;
	}

	public HttpMethod getHttpMethod() {
		return httpMethod;
	}

	public String getPath() {
		return path;
	}

	public Object getController() {
		return controller;
	}

	public Method getAction() {
		return action;
	}
	
}
