package br.com.bollyfilmes.view.fragments.listafilmes;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.List;

import br.com.bollyfilmes.R;
import br.com.bollyfilmes.model.ItemFilme;
import br.com.bollyfilmes.utils.logs.WrapperLog;
import br.com.bollyfilmes.view.abstracts.AbstractFragment;
import br.com.bollyfilmes.view.activitys.FilmeDetalheActivity;
import br.com.bollyfilmes.view.adapter.ListAdapter;

public class FilmesFragment extends AbstractFragment implements IOnClickFilmesFragment {
//    private ImageView         imgUpDown;
    private RecyclerView      recyclerView;
    private ListAdapter       adapter;
    private List<ItemFilme>   list;
    private IOnClickFilmesFragment itemClick;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.filme_fragment, container, false);
        binds(view);
        return view;
    }

    private void binds(View view) {

        list = new ArrayList<ItemFilme>();

        list.add(new ItemFilme("Homem Aranha", "Filme de heroi picado por uma aranha", "10/04/2016", 4));
        list.add(new ItemFilme("Homem Cobra", "Filme de heroi picado por uma cobra", "06/01/2016", 2));
        list.add(new ItemFilme("Homem Javali", "Filme de heroi mordido por uma javali", "30/06/2016", 3));
        list.add(new ItemFilme("Homem Passaro", "Filme de heroi picado por uma passaro", "23/05/2016", 5));
        list.add(new ItemFilme("Homem Cachorro", "Filme de heroi mordido por uma cachorro", "14/02/2016", 3.5f));
        list.add(new ItemFilme("Homem Gato", "Filme de heroi mordido por uma gato", "10/04/2016", 2.5f));

        adapter = new ListAdapter(list,this);

        recyclerView = (RecyclerView) view.findViewById(R.id.rclListaFilmes);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }


    @Override
    public void onClickRecycleView(ItemFilme itemFilme, int position) {
//         itemFilme = list.get(position);

        WrapperLog.info("POSITION "+itemFilme.getTitulo());

        Intent intent = new Intent(getActivity(), FilmeDetalheActivity.class);
        intent.putExtra("KEY_FILME",itemFilme);
        startActivity(intent);

    }
}
