package br.com.bollyfilmes.view.fragments.splash;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import br.com.bollyfilmes.R;
import br.com.bollyfilmes.presenter.busines.splash.SplashPresenterImpl;
import br.com.bollyfilmes.presenter.listener.presenter.OnSplashPresenter;
import br.com.bollyfilmes.utils.enums.ControlFrags;
import br.com.bollyfilmes.utils.logs.WrapperLog;
import br.com.bollyfilmes.view.abstracts.AbstractFragment;
import br.com.bollyfilmes.view.listner.OnMainActivityView;
import br.com.bollyfilmes.view.listner.OnSplashView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class SSplashFragment extends AbstractFragment implements OnSplashView {
    private ImageView imageLogo;
    Unbinder unbinder;
    private OnSplashPresenter presenter;
    private OnMainActivityView onMainActivityView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ssplash_fragment, container, false);
        onMainActivityView = (OnMainActivityView) getActivity();
        imageLogo          = (ImageView) view.findViewById(R.id.image_logo);
        AlphaAnimation alpha = new AlphaAnimation(0.0f, 1.0f);
        alpha.setDuration(2000);
        alpha.setStartOffset(300);

        ScaleAnimation scale = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scale.setDuration(2000);

        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(alpha);
        animationSet.addAnimation(scale);
        animationSet.setFillAfter(true);

        animationSet.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                WrapperLog.info("ON "+ animation);
            }

            @Override
            public void onAnimationEnd(Animation animation)
            {
                callSplash();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                WrapperLog.info("REPEAT "+ animation);
            }
        });

        imageLogo.startAnimation(animationSet);


        unbinder = ButterKnife.bind(this, view);
        return view;

    }

    @Override
    public void showMessage(String message) {
        onMainActivityView.transferFragment(ControlFrags.DASH, R.id.content, false);
    }

    @Override
    public void callSplash() {
        presenter = new SplashPresenterImpl(this);
        presenter.callSplash();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
