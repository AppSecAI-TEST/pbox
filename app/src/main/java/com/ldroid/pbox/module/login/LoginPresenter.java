/**
 * 
 */
package com.ldroid.pbox.module.login;

import android.support.annotation.NonNull;

import com.ldroid.pbox.R;
import com.ldroid.pbox.common.entities.OutputDataEntity;
import com.ldroid.pbox.common.lib.volley.VolleyError;
import com.ldroid.pbox.common.net.ResponseListener;
import com.ldroid.pbox.entities.in.LoginInEntity;
import com.ldroid.pbox.entities.out.LoginOutEntity;
import com.ldroid.pbox.interactor.LoginInteractor;

public class LoginPresenter implements LoginContract.Presenter {

	private LoginContract.View mView;
	private LoginInteractor mInteractor;

	/**
	 * 
	 */
	public LoginPresenter(@NonNull LoginContract.View view) {
		this.mView = view;
		mInteractor = new LoginInteractor();
	}

	@Override
	public void reqLogin(@NonNull String utel, @NonNull String upwd) {
		final LoginInEntity in = new LoginInEntity(utel, upwd);
		if (!in.checkInput()) {
			mView.onError(in.getErrors().get(0));
			return;
		}
		mView.showLoading(null);
		mInteractor.reqLogin(in, new ResponseListener<OutputDataEntity<LoginOutEntity>>() {

			@Override
			public void onResponse(OutputDataEntity<LoginOutEntity> response) {
				mView.dismissLoading();
				if (response == null) {
					mView.onError(mView.getContext().getString(R.string.common_net_error));
				} else {
					if (Code.SUCCESS.equals(response.code)) {
						mView.onRespLogin();
					} else {
						mView.onError(response.getErrorMsg());
					}
				}
			}

			@Override
			public void onErrorResponse(VolleyError error) {
				mView.dismissLoading();
				mView.onError(error.toString());
			}
		});

	}

}
