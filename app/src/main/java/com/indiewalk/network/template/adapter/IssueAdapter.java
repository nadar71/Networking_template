package com.indiewalk.network.template.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import com.indiewalk.network.R;
import com.indiewalk.network.template.model.Issue;

public class IssueAdapter extends RecyclerView.Adapter<IssueAdapter.QuestionViewHolder> {

	private List<Issue> issues;
	private int rowLayout;
	private Context context;


	public IssueAdapter(List<Issue> issues, int rowLayout, Context context) {
		this.issues = issues;
		this.rowLayout = rowLayout;
		this.context = context;
	}

	@Override
	public IssueAdapter.QuestionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
		return new QuestionViewHolder(view);
	}


	@Override
	public void onBindViewHolder(QuestionViewHolder holder, final int position) {
		holder.positionNumber.setText("Issue number : " + String.valueOf(position + 1));
		holder.questionTitle.setText("Title : " + issues.get(position).getTitle());
		holder.link.setText("Link : " );
		holder.link_url.setText(issues.get(position).getLink());
		Linkify.addLinks(holder.link_url, Linkify.WEB_URLS);


	}

	@Override
	public int getItemCount() {
		return issues.size();
	}

	public static class QuestionViewHolder extends RecyclerView.ViewHolder {
		TextView positionNumber;
		TextView questionTitle;
		TextView link, link_url;

		public QuestionViewHolder(View v) {
			super(v);
			positionNumber = (TextView) v.findViewById(R.id.positionNumber);
			questionTitle  = (TextView) v.findViewById(R.id.title);
			link           = (TextView) v.findViewById(R.id.link);
			link_url       = (TextView) v.findViewById(R.id.link_url);

		}
	}
}