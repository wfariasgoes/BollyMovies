package br.com.bollyfilmes.view.activitys;

import android.os.Bundle;

import br.com.bollyfilmes.R;
import br.com.bollyfilmes.utils.enums.ControlFrags;
import br.com.bollyfilmes.view.abstracts.AbstractActivity;
import br.com.bollyfilmes.view.listner.OnMainActivityView;

public class MainActivity extends AbstractActivity implements OnMainActivityView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addFragment(ControlFrags.SPLASH,R.id.content,false);
    }

    @Override
    public void registrerFragment(ControlFrags frags, int layoutId, boolean addBackStack) {

    }

    @Override
    public void transferFragment(ControlFrags frags, int layoutId, boolean addBackStack) {
        replaceFragment(frags, layoutId, addBackStack);
    }

    @Override
    public void transferFragment(ControlFrags frags, int layoutId, boolean addBackStack, Bundle bundle) {
        replaceFragment(frags, layoutId, addBackStack);
    }

    @Override
    public void removeFragmentOnActivity(ControlFrags frags, int layoutId) {

    }
}
