package br.com.bollyfilmes.view.fragments.listafilmes;

import android.widget.AdapterView;

import java.util.List;

import br.com.bollyfilmes.model.ItemFilme;

/**
 * Created by wesleygoes on 17/05/17.
 */

public interface IOnClickFilmesFragment {
    public void onClickRecycleView(ItemFilme itemFilme, int position);
}
