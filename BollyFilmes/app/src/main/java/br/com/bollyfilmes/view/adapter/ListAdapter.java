package br.com.bollyfilmes.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

import br.com.bollyfilmes.R;
import br.com.bollyfilmes.model.ItemFilme;
import br.com.bollyfilmes.utils.logs.WrapperLog;
import br.com.bollyfilmes.view.fragments.listafilmes.IOnClickFilmesFragment;

/**
 * Created by wesleygoes on 10/03/17.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private List<ItemFilme> list;
    private static final int VIEW_TYPE_DESTAQUE = 0;

    private static final int VIEW_TYPE_ITEM = 1;

    private ViewGroup parent;
    private int position;
    private View views;
    private IOnClickFilmesFragment itemClick;


    public ListAdapter(List<ItemFilme> list, IOnClickFilmesFragment itemClick) {
        this.list = list;
        this.itemClick = itemClick;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        this.position = position;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int position) {
        int typeView  = getItemViewType(position);
        ItemFilme itemFilme = list.get(this.position);
        WrapperLog.info("POSIT " + position);
        switch (typeView) {
            case VIEW_TYPE_DESTAQUE:
                views = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_filme_destaque, parent, false);

                TextView desc = (TextView) views.findViewById(R.id.tvDescricao);
                desc.setText(itemFilme.getDescricao());

                RatingBar avaliacao = (RatingBar) views.findViewById(R.id.ratingPreference);
                avaliacao.setRating(itemFilme.getAvaliacao());

                break;

            case VIEW_TYPE_ITEM:
                views = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_filme, parent, false);
                ViewHolder holder;
                if (views.getTag() == null) {
                    holder = new ViewHolder(views, itemFilme);
                    views.setTag(views);
                } else {
                    holder = (ViewHolder) views.getTag();
                }
                holder.tvTitulo.setText(itemFilme.getTitulo());
                holder.tvDescricao.setText(itemFilme.getDescricao());
                holder.tvData.setText(itemFilme.getDataLancamento());
                holder.ratingPreference.setRating(itemFilme.getAvaliacao());
                break;

        }

        return new ViewHolder(views,itemFilme);
    }


    @Override
    public int getItemViewType(int position) {
        return (position == 0 ? VIEW_TYPE_DESTAQUE : VIEW_TYPE_ITEM);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgItemPoster;
        private TextView tvTitulo, tvDescricao, tvData;
        private RatingBar ratingPreference;
        private ItemFilme itemFilme;

        ViewHolder(View itemView,final ItemFilme itemFilme) {
            super(itemView);
            this.itemFilme =  itemFilme;
            imgItemPoster = (ImageView) itemView.findViewById(R.id.imgItemPoster);
            tvTitulo = (TextView) itemView.findViewById(R.id.tvTitulo);
            tvDescricao = (TextView) itemView.findViewById(R.id.tvDescricao);
            tvData = (TextView) itemView.findViewById(R.id.tvData);
            ratingPreference = (RatingBar) itemView.findViewById(R.id.ratingPreference);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClick.onClickRecycleView(itemFilme,position);
                }
            });

        }

    }
}
