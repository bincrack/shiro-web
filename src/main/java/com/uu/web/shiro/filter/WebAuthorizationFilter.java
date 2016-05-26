package com.uu.web.shiro.filter;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;

public class WebAuthorizationFilter extends PermissionsAuthorizationFilter
{
	@Override
	public boolean isAccessAllowed(ServletRequest r, ServletResponse response, Object mappedValue) throws IOException
	{
		HttpServletRequest request = (HttpServletRequest) r;
		String path = request.getContextPath();
		String uri = request.getRequestURI();
		String permission = uri.substring(path.length());

		return getSubject(request, response).isPermitted(permission);
	}

}
