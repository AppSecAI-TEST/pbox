package com.ipricebox.android.module.me;

import com.ipricebox.android.common.mvp.BasePresenter;
import com.ipricebox.android.common.mvp.BaseView;
import com.ipricebox.android.entities.out.UserWidgetsOutEntity;

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
