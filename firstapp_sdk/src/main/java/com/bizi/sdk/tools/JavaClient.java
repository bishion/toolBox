package com.bizi.sdk.tools;

import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.util.EntityUtils;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
 * 所有client的基类
 * @author 张少能
 */
public abstract class JavaClient {

	private static final String UTF_8 = "UTF-8";
	// private static final String JSON = "application/json";

	protected JsonMapper mapper = JsonMapper.buildNonEmptyMapper();

	/*** scheme http */
	protected String schema;
	/** 服务器ip*/
	protected String ip;
	/*** 服务器端口*/
	protected int port;
	/*** 服务器contextPath，默认为/uniproduct */
	protected String contextPath;


	protected HttpClient createHttpClient(){
		return this.createHttpClient(3000, 10000);
	}

	protected HttpClient createHttpClient(int connectionTimeout, int socketTimeout) {
		HttpClient client = new DefaultHttpClient();
		client.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
		client.getParams().setParameter(CoreProtocolPNames.HTTP_CONTENT_CHARSET, UTF_8);
		this.setTimeOut(client, connectionTimeout, socketTimeout);
		return client;
	}

	private void setTimeOut(HttpClient client, int connectionTimeout, int socketTimeout){
		client.getParams().setIntParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, connectionTimeout);
		client.getParams().setIntParameter(CoreConnectionPNames.SO_TIMEOUT, socketTimeout);
	}

	protected URI createURI(String path){
		try {
			return URIUtils.createURI(this.schema, this.ip, this.port, this.contextPath + path, null, null);
		} catch (URISyntaxException e) {
			throw NestedException.wrap(e);
		}
	}

	protected URI createURI(String path, String name, String value){
		try {
			return URIUtils.createURI(this.schema, this.ip, this.port, this.contextPath + path,
					URLEncodedUtils.format(Arrays.asList(new BasicNameValuePair(name, value)), UTF_8), null);
		} catch (URISyntaxException e) {
			throw NestedException.wrap(e);
		}
	}

	protected URI createURI(String path, Map<String, String> nameValuePairs){
		List<BasicNameValuePair> pairs = new ArrayList<BasicNameValuePair>();
		for (Map.Entry<String, String> entry : nameValuePairs.entrySet()){
			pairs.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
		}

		try {
			return URIUtils.createURI(this.schema, this.ip, this.port, this.contextPath + path, URLEncodedUtils.format(pairs, "UTF-8"), null);
		} catch (URISyntaxException e) {
			throw NestedException.wrap(e);
		}
	}

	protected String executeHttpRequest(HttpClient client, HttpUriRequest request) {
		try {
			HttpResponse response = client.execute(request);
			return EntityUtils.toString(response.getEntity(),"UTF-8");
		} catch (Exception e) {
			throw NestedException.wrap(e);
		}
	}

	protected StringEntity createStringEntity(String json) {
		try {
			return new StringEntity(json,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw NestedException.wrap(e);
		}
	}

	protected <T> T fromJson(String json, Class<T> clazz){
		try {
			return mapper.fromJson(json, clazz);
		} catch (Exception e) {
			throw new RuntimeException("from json for " + clazz + " failed, body: " + json);
		}
	}

	protected <T> List<T> fromJsonForList(String json, Class<T> clazz){
		try {
			return mapper.fromJson(json, List.class, clazz);
		} catch (Exception e) {
			throw new RuntimeException("from json list for " + clazz + " failed, body: " + json);
		}
	}
}
