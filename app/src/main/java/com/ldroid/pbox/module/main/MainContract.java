package com.ldroid.pbox.module.main;

import android.support.annotation.NonNull;

import com.ldroid.pbox.common.mvp.BasePresenter;
import com.ldroid.pbox.common.mvp.BaseView;

public interface MainContract {

	interface View extends BaseView {
		void onRespLogin();
	}

	interface Presenter extends BasePresenter {

		void reqLogin(@NonNull String phone, @NonNull String pwd);

	}
}
