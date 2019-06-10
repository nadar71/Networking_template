package com.indiewalk.network.template.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import com.indiewalk.network.R;
import com.indiewalk.network.template.adapter.IssueAdapter;
import com.indiewalk.network.template.model.Issue;
import com.indiewalk.network.template.model.IssueList;
import com.indiewalk.network.template.rest.IssuesAPIService;
import com.indiewalk.network.template.rest.RestClient;

public class MainActivity extends AppCompatActivity {

	private static final String TAG = MainActivity.class.getSimpleName();

	IssuesAPIService apiService;

	RecyclerView recyclerView;
	IssueAdapter adapter;
	List<Issue> issues = new ArrayList<>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		apiService = RestClient.getClient().create(IssuesAPIService.class);

		recyclerView = (RecyclerView) findViewById(R.id.questionListRecyclerView);
		recyclerView.setLayoutManager(new LinearLayoutManager(this));

		adapter = new IssueAdapter(issues, R.layout.question_item, getApplicationContext());
		recyclerView.setAdapter(adapter);

		fetchIssuesList();
	}

	private void fetchIssuesList() {
		Call<IssueList> call = apiService.fetchIssues("android");
		call.enqueue(new Callback<IssueList>() {
			@Override
			public void onResponse(Call<IssueList> call, Response<IssueList> response) {
				Log.d(TAG, "Total number of issues no answered fetched : " + response.body().getIssuesList().size());

				issues.addAll(response.body().getIssuesList());
				adapter.notifyDataSetChanged();
			}

			@Override
			public void onFailure(Call<IssueList> call, Throwable t) {
				Log.e(TAG, "Error : " + t.getLocalizedMessage());
			}
		});
	}
}




