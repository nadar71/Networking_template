package com.indiewalk.network.template.rest;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import com.indiewalk.network.template.model.IssueList;

/**
 * -------------------------------------------------------------------------------------------------
 * Request to stackexchange, check out details at : https://api.stackexchange.com/docs/
 * -------------------------------------------------------------------------------------------------
 */
public interface IssuesAPIService {

	public static final String BASE_URL = "https://api.stackexchange.com";

	// @GET("/2.2/questions?order=desc&sort=creation&site=stackoverflow")	//End Url
	@GET("/2.2/questions/no-answers?order=desc&sort=creation&site=stackoverflow")	//End Url
	Call<IssueList> fetchIssues(@Query("tagged") String tags);


}
