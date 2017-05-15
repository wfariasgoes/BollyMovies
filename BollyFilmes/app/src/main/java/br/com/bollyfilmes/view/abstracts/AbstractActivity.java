package br.com.bollyfilmes.view.abstracts;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import br.com.bollyfilmes.utils.enums.ControlFrags;
import br.com.bollyfilmes.utils.logs.WrapperLog;

/**
 * Created by wesleygoes on 09/03/17.
 */

public class AbstractActivity extends AppCompatActivity {

    protected FragmentManager fragmentManager;
    private AbstractFragment abstractFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentManager = getSupportFragmentManager();
    }

    /**
     * method to add fragment in backstack
     */
    public void addFragment(ControlFrags control, int layoutId,
                            boolean addBackStack) {

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        try {
            abstractFragment = control.getClassFrag().newInstance();

            fragmentTransaction.add(layoutId, abstractFragment, control.getName());
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            WrapperLog.error(e.getMessage());
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            WrapperLog.error(e.getMessage());
        }

        if (addBackStack) {
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();

    }


    /**
     * method to send bundle to another fragment
     */

    public void replaceFragment(ControlFrags control, int layoutId,
                                boolean addBackStack, Bundle bundle) {

        FragmentTransaction fragmentTransaction = fragmentManager
                .beginTransaction();
        try {
            abstractFragment = control.getClassFrag().newInstance();
            abstractFragment.setArguments(bundle);
            fragmentTransaction.replace(layoutId, abstractFragment, control.getName());
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            WrapperLog.error(e.getMessage());
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            WrapperLog.error(e.getMessage());
        }

        if (addBackStack) {
            fragmentTransaction.addToBackStack(control.getName());
        }
        if (!isFinishing()) {
            fragmentTransaction.commit();
        }


    }


    /**
     * method to replace fragment in backstack
     */

    public void replaceFragment(ControlFrags control, int layoutId, boolean addBackStack) {

        WrapperLog.info("replaceFragment");
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        try {
            abstractFragment = control.getClassFrag().newInstance();

            fragmentTransaction.replace(layoutId, abstractFragment, control.getName());
        } catch (InstantiationException e) {
            WrapperLog.error(e.getMessage());
        } catch (IllegalAccessException e) {
            WrapperLog.error(e.getMessage());
        }

        if (addBackStack) {
            WrapperLog.info("addBackStack");
            fragmentTransaction.addToBackStack(control.getName());
        }
        if (!isFinishing()) {
            fragmentTransaction.commit();
        }

    }


    /**
     * method to remove fragment in backstack
     */

    public void removeFragment(ControlFrags control, int layoutId) {

        FragmentTransaction fragmentTransaction = fragmentManager
                .beginTransaction();
        try {
            abstractFragment = control.getClassFrag().newInstance();
            fragmentTransaction.remove(abstractFragment);
            fragmentTransaction.commit();
        } catch (InstantiationException e) {
            WrapperLog.debug("Menu Teste: removeFragment -> "+e.getMessage());
            WrapperLog.error(e.getMessage());
        } catch (IllegalAccessException e) {
            WrapperLog.debug("Menu Teste: removeFragment -> "+e.getMessage());
            WrapperLog.error(e.getMessage());
        }


    }

    /**
     * implemented backstack of application
     */
    @Override
    public void onBackPressed() {

        super.onBackPressed();
//        if (getFragmentManager().getBackStackEntryCount() > 0) {
//            getFragmentManager().popBackStack();
//        } else {
//
//            if (doubleBackToExitPressedOnce) {
//                super.onBackPressed();
//                return;
//            }
//            this.doubleBackToExitPressedOnce = true;
//            Toast.makeText(this, getResources().getString(R.string.txt_to_onback), Toast.LENGTH_SHORT).show();
//            new Handler().postDelayed(new Runnable() {
//
//                @Override
//                public void run() {
//                    doubleBackToExitPressedOnce = false;
//                }
//            }, 2000);
//        }
    }

    @Override
    protected void onPause() {
        super.onPause();
    }



}
