package com.mphasis.filters;

import javax.servlet.http.HttpServletRequest;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class ErrorFilter extends ZuulFilter{

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		
		
		System.out.println("------------------Your are in the Route filter-----------------------");
		
		return null;
	}

	@Override
	public String filterType() {
		
		return "error";
	}

	@Override
	public int filterOrder() {
		
		return 0;
	}

}
