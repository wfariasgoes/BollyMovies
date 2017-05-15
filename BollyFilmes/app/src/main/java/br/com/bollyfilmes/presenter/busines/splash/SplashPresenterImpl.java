package br.com.bollyfilmes.presenter.busines.splash;

import br.com.bollyfilmes.presenter.interactor.SplashInteractor;
import br.com.bollyfilmes.presenter.listener.callback.OnSplashCallBack;
import br.com.bollyfilmes.presenter.listener.interactor.OnSplashInteractor;
import br.com.bollyfilmes.presenter.listener.presenter.OnSplashPresenter;
import br.com.bollyfilmes.view.abstracts.AbstractFragment;
import br.com.bollyfilmes.view.listner.OnSplashView;

/**
 * Created by wesleygoes on 09/03/17.
 */

public class SplashPresenterImpl extends AbstractFragment implements OnSplashPresenter,OnSplashCallBack{

    private OnSplashView onSplashView;
    private OnSplashInteractor interactor;

    public SplashPresenterImpl(OnSplashView onSplashView){
        this.onSplashView = onSplashView;
        this.interactor = new SplashInteractor();
    }


    @Override
    public boolean callSplash() {
        interactor.callSplahs(this);
        return true;
    }

    @Override
    public boolean showMsg(String msg) {
        if(msg != null){
            onSplashView.showMessage(msg);
            return true;
        }
        return false;
    }
}
