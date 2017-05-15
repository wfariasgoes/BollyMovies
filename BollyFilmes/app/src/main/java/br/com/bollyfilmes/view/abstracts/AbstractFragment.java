package br.com.bollyfilmes.view.abstracts;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by wesleygoes on 09/03/17.
 */

public class AbstractFragment extends Fragment {

    public static final String KEY_TITLE_BUNDLE = "key_TITLE_bundle";

    protected void hideKeyboard(View view){
        if(view!=null){
            InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }

    }

    protected void keyBoardAdjustInputPan(boolean isToAdjust){
        if(isToAdjust){
            getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        }else{
            getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        }

    }
}
