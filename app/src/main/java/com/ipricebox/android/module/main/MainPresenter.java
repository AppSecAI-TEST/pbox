/**
 *
 */
package com.ipricebox.android.module.main;

import android.support.annotation.NonNull;

import com.ipricebox.android.R;
import com.ipricebox.android.common.entities.OutputDataEntity;
import com.ipricebox.android.common.lib.volley.VolleyError;
import com.ipricebox.android.common.net.ResponseListener;
import com.ipricebox.android.entities.in.LoginInEntity;
import com.ipricebox.android.entities.out.UserOutEntity;
import com.ipricebox.android.interactor.LoginInteractor;

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View mView;
    private LoginInteractor mInteractor;

    /**
     *
     */
    public MainPresenter(@NonNull MainContract.View view) {
        this.mView = view;
        mInteractor = new LoginInteractor();
    }

    @Override
    public void reqLogin(@NonNull String phone, @NonNull String password) {
        final LoginInEntity in = new LoginInEntity(phone, password);
        if (!in.checkInput()) {
            mView.onError(in.getErrors().get(0));
            return;
        }
        mView.showLoading(null);
        mInteractor.reqLogin(in, new ResponseListener<OutputDataEntity<UserOutEntity>>() {

            @Override
            public void onResponse(OutputDataEntity<UserOutEntity> response) {
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
