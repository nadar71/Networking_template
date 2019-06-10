package com.indiewalk.network.template.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



/**
 * -------------------------------------------------------------------------------------------------
 * Retrofit client ; using Gson as converter
 * -------------------------------------------------------------------------------------------------
 */
public class RestClient {


	private static Retrofit retrofit = null;


	public static Retrofit getClient() {
		if (retrofit == null) {
			retrofit = new Retrofit.Builder()
					.baseUrl(IssuesAPIService.BASE_URL)
					.addConverterFactory(GsonConverterFactory.create())
					.build();
		}
		return retrofit;
	}
}
