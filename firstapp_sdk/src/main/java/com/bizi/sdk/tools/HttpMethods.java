package com.bizi.sdk.tools;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;

import java.net.URI;
import java.net.URISyntaxException;

public class HttpMethods {
	
	public static HttpGet get(URI uri){
		HttpGet get = new HttpGet(uri);
		setAccept(get);
		return get;
	}
	
	public static HttpGet get(URI uri, long userId){
		HttpGet get = get(uri);
		setUserIdCookie(get, userId);
		return get;
	}
	
	public static HttpPost post(String uri){
		URI u = null;
		try {
			u = new URI(uri);
		} catch (URISyntaxException e) {
			throw NestedException.wrap(e);
		}
		HttpPost post = post(u);
		return post;
	}
	
	public static HttpPost post(URI uri){
		HttpPost post = new HttpPost(uri);
		setAccept(post);
		setContentType(post);
		return post;
	}
	
	public static HttpPost post(String uri, long userId){
		HttpPost post = post(uri);
		setUserIdCookie(post, userId);
		return post;
	}
	
	public static HttpPost post(URI uri, long userId){
		HttpPost post = post(uri);
		setUserIdCookie(post, userId);
		return post;
	}
	
	private static void setAccept(HttpRequestBase request){
		request.setHeader("Accept", "application/json");
	}
	
	private static void setContentType(HttpRequestBase request){
		request.setHeader("Content-Type", "application/json; charset=UTF-8");
	}
	
	private static void setUserIdCookie(HttpRequestBase request, long userId){
		request.setHeader("Cookie", "userId=" + userId);
	}

}
