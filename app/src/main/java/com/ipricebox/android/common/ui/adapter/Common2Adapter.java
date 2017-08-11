package com.ipricebox.android.common.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.LinkedList;

public abstract class Common2Adapter<T> extends BaseAdapter {

	protected Context mContext;
	protected LinkedList<T> mListData;
	protected LayoutInflater mInflater;
	private int layoutId;

	public Common2Adapter(Context context, int layoutId) {
		this.mContext = context;
		mInflater = LayoutInflater.from(context);
		this.layoutId = layoutId;
	}

	public void setListData(LinkedList<T> data) {
		mListData = data;
		notifyDataSetChanged();
	}

	@Override
	public int getCount() {
		return this.mListData != null ? this.mListData.size() : 0;
	}

	@Override
	public T getItem(int position) {
		return (this.mListData != null && !this.mListData.isEmpty()) ? this.mListData.get(position)
				: null;	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		ViewHolder holder = ViewHolder.get(mContext, convertView, parent, layoutId, position);
		convert(holder, getItem(position));
		return holder.getConvertView();
	}

	public abstract void convert(ViewHolder holder, T t);

}
