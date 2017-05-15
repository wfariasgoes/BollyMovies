package br.com.bollyfilmes.presenter.interactor;

import android.os.Handler;

import br.com.bollyfilmes.presenter.listener.callback.OnSplashCallBack;
import br.com.bollyfilmes.presenter.listener.interactor.OnSplashInteractor;

/**
 * Created by wesleygoes on 09/03/17.
 */

public class SplashInteractor implements OnSplashInteractor{
    /**
     * method that implements business logic
     * */

    @Override
    public void callSplahs(final OnSplashCallBack listener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                String msg = "sucess!!!";
                listener.showMsg(msg);
            }
        }, 2000/* 1sec delay */);

    }




}
