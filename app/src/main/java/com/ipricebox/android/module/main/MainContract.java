package com.ipricebox.android.module.main;

import android.support.annotation.NonNull;

import com.ipricebox.android.common.mvp.BasePresenter;
import com.ipricebox.android.common.mvp.BaseView;

public interface MainContract {

	interface View extends BaseView {
		void onRespLogin();
	}

	interface Presenter extends BasePresenter {

		void reqLogin(@NonNull String phone, @NonNull String pwd);

	}
}
