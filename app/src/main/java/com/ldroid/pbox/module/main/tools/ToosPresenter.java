/**
 *
 */
package com.ldroid.pbox.module.main.tools;

import android.support.annotation.NonNull;

import com.ldroid.pbox.R;
import com.ldroid.pbox.common.entities.OutputDataEntity;
import com.ldroid.pbox.common.lib.volley.VolleyError;
import com.ldroid.pbox.common.net.ResponseListener;
import com.ldroid.pbox.entities.in.ToolsCBLRInEntity;
import com.ldroid.pbox.entities.in.ToolsCountrysInEntity;
import com.ldroid.pbox.entities.in.ToolsEMSInEntity;
import com.ldroid.pbox.entities.in.ToolsEYBInEntity;
import com.ldroid.pbox.entities.in.ToolsGHDBInEntity;
import com.ldroid.pbox.entities.in.ToolsGHXBInEntity;
import com.ldroid.pbox.entities.in.ToolsHGZXInEntity;
import com.ldroid.pbox.entities.in.ToolsHWCInEntity;
import com.ldroid.pbox.entities.in.ToolsPZHSInEntity;
import com.ldroid.pbox.entities.in.ToolsTYInEntity;
import com.ldroid.pbox.entities.in.ToolsWLZZInEntity;
import com.ldroid.pbox.entities.in.ToolsYFGSInEntity;
import com.ldroid.pbox.entities.out.ToolsCBLROutEntity;
import com.ldroid.pbox.entities.out.ToolsCountrysOutEntity;
import com.ldroid.pbox.entities.out.ToolsEMSOutEntity;
import com.ldroid.pbox.entities.out.ToolsEYBOutEntity;
import com.ldroid.pbox.entities.out.ToolsGHDBOutEntity;
import com.ldroid.pbox.entities.out.ToolsGHXBOutEntity;
import com.ldroid.pbox.entities.out.ToolsHGZXOutEntity;
import com.ldroid.pbox.entities.out.ToolsHWCOutEntity;
import com.ldroid.pbox.entities.out.ToolsPZHSOutEntity;
import com.ldroid.pbox.entities.out.ToolsTYOutEntity;
import com.ldroid.pbox.entities.out.ToolsWLZZOutEntity;
import com.ldroid.pbox.entities.out.ToolsYFGSOutEntity;
import com.ldroid.pbox.interactor.ToolsInteractor;

public class ToosPresenter implements ToolsContract.Presenter {

    private ToolsContract.View mView;
    private ToolsInteractor mInteractor;

    /**
     *
     */
    public ToosPresenter(@NonNull ToolsContract.View view) {
        this.mView = view;
        mInteractor = new ToolsInteractor();
    }

    public void reqToolsTY(String userid, String productname, String countryname, String profitmargin, String price, String amount, String grossfreight1, String grossfreight2, String incidentals, String exchangerate1, String exchangerate2) {
        final ToolsTYInEntity in = new ToolsTYInEntity(userid, productname, countryname,
                profitmargin, price, amount, grossfreight1, grossfreight2, incidentals, exchangerate1, exchangerate2);
        if (!in.checkInput()) {
            mView.onError(in.getErrors().get(0));
            return;
        }
        mView.showLoading(null);
        mInteractor.reqToolsTY(in, new ResponseListener<OutputDataEntity<ToolsTYOutEntity>>() {

            @Override
            public void onResponse(OutputDataEntity<ToolsTYOutEntity> response) {
                mView.dismissLoading();
                if (response == null) {
                    mView.onError(mView.getContext().getString(R.string.common_net_error));
                } else {
                    if (Code.SUCCESS.equals(response.code)) {
                        mView.onRespToolsTY(response.data);
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


    public void reqToolsEYB(String userid, String productname, String countryname, String profitmargin, String cost, String weight, String discount, String incidentals, String exchangerate1, String exchangerate2) {
        final ToolsEYBInEntity in = new ToolsEYBInEntity(userid, productname, countryname, profitmargin, cost, weight, discount, incidentals, exchangerate1, exchangerate2);
        if (!in.checkInput()) {
            mView.onError(in.getErrors().get(0));
            return;
        }
        mView.showLoading(null);
        mInteractor.reqToolsEYB(in, new ResponseListener<OutputDataEntity<ToolsEYBOutEntity>>() {

            @Override
            public void onResponse(OutputDataEntity<ToolsEYBOutEntity> response) {
                mView.dismissLoading();
                if (response == null) {
                    mView.onError(mView.getContext().getString(R.string.common_net_error));
                } else {
                    if (Code.SUCCESS.equals(response.code)) {
                        mView.onRespToolsEYB(response.data);
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

    public void reqToolsGHXB(String userid, String productname, String countryname, String profitmargin, String cost, String weight, String discount, String incidentals, String exchangerate1, String exchangerate2) {
        final ToolsGHXBInEntity in = new ToolsGHXBInEntity(userid, productname, countryname, profitmargin, cost, weight, discount, incidentals, exchangerate1, exchangerate2);
        if (!in.checkInput()) {
            mView.onError(in.getErrors().get(0));
            return;
        }
        mView.showLoading(null);
        mInteractor.reqToolsGHXB(in, new ResponseListener<OutputDataEntity<ToolsGHXBOutEntity>>() {

            @Override
            public void onResponse(OutputDataEntity<ToolsGHXBOutEntity> response) {
                mView.dismissLoading();
                if (response == null) {
                    mView.onError(mView.getContext().getString(R.string.common_net_error));
                } else {
                    if (Code.SUCCESS.equals(response.code)) {
                        mView.onRespToolsGHXB(response.data);
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


    public void reqToolsGHDB(String userid, String productname, String countryname, String profitmargin, String cost, String weight, String discount, String incidentals, String exchangerate1, String exchangerate2) {
        final ToolsGHDBInEntity in = new ToolsGHDBInEntity(userid, productname, countryname, profitmargin, cost, weight, discount, incidentals, exchangerate1, exchangerate2);
        if (!in.checkInput()) {
            mView.onError(in.getErrors().get(0));
            return;
        }
        mView.showLoading(null);
        mInteractor.reqToolsGHDB(in, new ResponseListener<OutputDataEntity<ToolsGHDBOutEntity>>() {

            @Override
            public void onResponse(OutputDataEntity<ToolsGHDBOutEntity> response) {
                mView.dismissLoading();
                if (response == null) {
                    mView.onError(mView.getContext().getString(R.string.common_net_error));
                } else {
                    if (Code.SUCCESS.equals(response.code)) {
                        mView.onRespToolsGHDB(response.data);
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


    public void reqToolsEMS(String userid, String productname, String countryname, String
            profitmargin, String cost, String weight, String discount, String incidentals, String exchangerate1, String exchangerate2) {
        final ToolsEMSInEntity in = new ToolsEMSInEntity(userid, productname, countryname, profitmargin, cost, weight, discount, incidentals, exchangerate1, exchangerate2);
        if (!in.checkInput()) {
            mView.onError(in.getErrors().get(0));
            return;
        }
        mView.showLoading(null);
        mInteractor.reqToolsEMS(in, new ResponseListener<OutputDataEntity<ToolsEMSOutEntity>>() {

            @Override
            public void onResponse(OutputDataEntity<ToolsEMSOutEntity> response) {
                mView.dismissLoading();
                if (response == null) {
                    mView.onError(mView.getContext().getString(R.string.common_net_error));
                } else {
                    if (Code.SUCCESS.equals(response.code)) {
                        mView.onRespToolsEMS(response.data);
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


    public void reqToolsHWC(String userid, String productname, String countryname, String profitmargin, String price, String amount, String weight, String turnaroundtime, String exchangerate2, String grossfreight1, String firstfreight, String secondfreight, String incidentals, String exchangerate1, String financingcosrate) {
        final ToolsHWCInEntity in = new ToolsHWCInEntity(userid, productname, countryname, profitmargin, price, amount, weight, turnaroundtime, exchangerate2, grossfreight1, firstfreight, secondfreight, incidentals, exchangerate1, financingcosrate);
        if (!in.checkInput()) {
            mView.onError(in.getErrors().get(0));
            return;
        }
        mView.showLoading(null);
        mInteractor.reqToolsHWC(in, new ResponseListener<OutputDataEntity<ToolsHWCOutEntity>>() {

            @Override
            public void onResponse(OutputDataEntity<ToolsHWCOutEntity> response) {
                mView.dismissLoading();
                if (response == null) {
                    mView.onError(mView.getContext().getString(R.string.common_net_error));
                } else {
                    if (Code.SUCCESS.equals(response.code)) {
                        mView.onRespToolsHWC(response.data);
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


    public void reqToolsCountrys(String userid, String type) {
        final ToolsCountrysInEntity in = new ToolsCountrysInEntity(userid, type);
        if (!in.checkInput()) {
            mView.onError(in.getErrors().get(0));
            return;
        }
        mView.showLoading(null);
        mInteractor.reqToolsCountrys(in, new ResponseListener<OutputDataEntity<ToolsCountrysOutEntity>>() {

            @Override
            public void onResponse(OutputDataEntity<ToolsCountrysOutEntity> response) {
                mView.dismissLoading();
                if (response == null) {
                    mView.onError(mView.getContext().getString(R.string.common_net_error));
                } else {
                    if (Code.SUCCESS.equals(response.code)) {
                        mView.onRespToolsCountry(response.data);
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

    public void reqToolsCBLR(String userid, String productname, String countryname, String sellingprice, String cost, String grossfreight2, String incidentals, String exchangerate1, String exchangerate2) {
        final ToolsCBLRInEntity in = new ToolsCBLRInEntity(userid, productname, countryname, sellingprice, cost, grossfreight2, incidentals, exchangerate1, exchangerate2);
        if (!in.checkInput()) {
            mView.onError(in.getErrors().get(0));
            return;
        }
        mView.showLoading(null);
        mInteractor.reqToolsCBLR(in, new ResponseListener<OutputDataEntity<ToolsCBLROutEntity>>() {

            @Override
            public void onResponse(OutputDataEntity<ToolsCBLROutEntity> response) {
                mView.dismissLoading();
                if (response == null) {
                    mView.onError(mView.getContext().getString(R.string.common_net_error));
                } else {
                    if (Code.SUCCESS.equals(response.code)) {
                        mView.onRespToolsCBLR(response.data);
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

    public void reqToolsPZHS(String userid, String length, String width, String height, String countingbase) {
        final ToolsPZHSInEntity in = new ToolsPZHSInEntity(userid, length, width, height, countingbase);
        if (!in.checkInput()) {
            mView.onError(in.getErrors().get(0));
            return;
        }
        mView.showLoading(null);
        mInteractor.reqToolsPZHS(in, new ResponseListener<OutputDataEntity<ToolsPZHSOutEntity>>() {

            @Override
            public void onResponse(OutputDataEntity<ToolsPZHSOutEntity> response) {
                mView.dismissLoading();
                if (response == null) {
                    mView.onError(mView.getContext().getString(R.string.common_net_error));
                } else {
                    if (Code.SUCCESS.equals(response.code)) {
                        mView.onRespToolsPZHS(response.data);
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


    public void reqToolsHGZX(String userid, String length, String width, String height, String countingbase) {
        final ToolsHGZXInEntity in = new ToolsHGZXInEntity(userid, length, width, height, countingbase);
        if (!in.checkInput()) {
            mView.onError(in.getErrors().get(0));
            return;
        }
        mView.showLoading(null);
        mInteractor.reqToolsHGZX(in, new ResponseListener<OutputDataEntity<ToolsHGZXOutEntity>>() {

            @Override
            public void onResponse(OutputDataEntity<ToolsHGZXOutEntity> response) {
                mView.dismissLoading();
                if (response == null) {
                    mView.onError(mView.getContext().getString(R.string.common_net_error));
                } else {
                    if (Code.SUCCESS.equals(response.code)) {
                        mView.onRespToolsHGZX(response.data);
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

    public void reqToolsYFGS(String userid, String channeltype, String countryname, String weight, String discount) {
        final ToolsYFGSInEntity in = new ToolsYFGSInEntity(userid, channeltype, countryname, weight, discount);
        if (!in.checkInput()) {
            mView.onError(in.getErrors().get(0));
            return;
        }
        mView.showLoading(null);
        mInteractor.reqToolsYFGS(in, new ResponseListener<OutputDataEntity<ToolsYFGSOutEntity>>() {

            @Override
            public void onResponse(OutputDataEntity<ToolsYFGSOutEntity> response) {
                mView.dismissLoading();
                if (response == null) {
                    mView.onError(mView.getContext().getString(R.string.common_net_error));
                } else {
                    if (Code.SUCCESS.equals(response.code)) {
                        mView.onRespToolsYFGS(response.data);
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


    public void reqToolsWLZZ(String userid, String num) {
        final ToolsWLZZInEntity in = new ToolsWLZZInEntity(userid, num);
        if (!in.checkInput()) {
            mView.onError(in.getErrors().get(0));
            return;
        }
        mView.showLoading(null);
        mInteractor.reqToolsWLZZ(in, new ResponseListener<OutputDataEntity<ToolsWLZZOutEntity>>() {

            @Override
            public void onResponse(OutputDataEntity<ToolsWLZZOutEntity> response) {
                mView.dismissLoading();
                if (response == null) {
                    mView.onError(mView.getContext().getString(R.string.common_net_error));
                } else {
                    if (Code.SUCCESS.equals(response.code)) {
                        mView.onRespToolsWLZZ(response.data);
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
