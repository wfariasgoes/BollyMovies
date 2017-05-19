package br.com.bollyfilmes.view.fragments.questions;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import br.com.bollyfilmes.R;
import br.com.bollyfilmes.view.abstracts.AbstractFragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionsFragment extends AbstractFragment {


    @BindView(R.id.text_km)
    AppCompatTextView textKm;
    @BindView(R.id.img_arrow_donw)
    AppCompatImageView imgArrowDonw;
    @BindView(R.id.img_arrow_up)
    AppCompatImageView imgArrowUp;
    @BindView(R.id.text_produto)
    AppCompatTextView textProduto;
    @BindView(R.id.text_status)
    AppCompatTextView textStatus;
    @BindView(R.id.item_detail)
    LinearLayout itemDetail;
    Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_questions, container, false);
        unbinder = ButterKnife.bind(this, view);
        textKm.setText("Carga de bateria");
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.img_arrow_donw, R.id.img_arrow_up, R.id.item_detail})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_arrow_donw:
                break;
            case R.id.img_arrow_up:
                break;
            case R.id.item_detail:
                break;
        }
    }
}
