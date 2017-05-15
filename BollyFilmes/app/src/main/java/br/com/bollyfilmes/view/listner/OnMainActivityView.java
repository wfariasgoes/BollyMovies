package br.com.bollyfilmes.view.listner;

import android.os.Bundle;

import br.com.bollyfilmes.utils.enums.ControlFrags;

/**
 * Created by wesleygoes on 09/03/17.
 */

public interface OnMainActivityView {
    void registrerFragment(ControlFrags frags, int layoutId, boolean addBackStack);
    void transferFragment(ControlFrags frags, int layoutId, boolean addBackStack);
    void transferFragment(ControlFrags frags, int layoutId, boolean addBackStack, Bundle bundle);
    void removeFragmentOnActivity(ControlFrags frags, int layoutId);
    void onBackPressed();
}
