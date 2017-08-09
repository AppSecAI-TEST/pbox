package com.ldroid.pbox.module.me;

import android.support.annotation.NonNull;

import com.ldroid.pbox.common.mvp.BasePresenter;
import com.ldroid.pbox.common.mvp.BaseView;
import com.ldroid.pbox.entities.out.UserWidgetsOutEntity;

public interface UserContract {

	interface View extends BaseView {
		void onRespUserWidgets(UserWidgetsOutEntity data);

		void onRespNickName();

		void onRespPhone();

		void onRespSmsCode(String phone);
	}

	interface Presenter extends BasePresenter {


	}
}
