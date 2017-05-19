package br.com.bollyfilmes.view.fragments.dashboard;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import br.com.bollyfilmes.R;
import br.com.bollyfilmes.utils.enums.ControlFrags;
import br.com.bollyfilmes.view.abstracts.AbstractFragment;
import br.com.bollyfilmes.view.listner.OnMainActivityView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class DashBoadFragment extends AbstractFragment   {


    @BindView(R.id.textTitle)
    TextView textTitle;
    @BindView(R.id.textName)
    TextView textName;
    @BindView(R.id.btnQuestions)
    AppCompatButton btnQuestions;
    @BindView(R.id.tbnTechnicalsAssistance)
    AppCompatButton tbnTechnicalsAssistance;
    Unbinder unbinder;
    private OnMainActivityView onMainActivityView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dash_boad, container, false);
        onMainActivityView = (OnMainActivityView) getActivity();
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.btnQuestions, R.id.tbnTechnicalsAssistance})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnQuestions:
                onMainActivityView.transferFragment(ControlFrags.FILMES, R.id.content, true);
                break;
            case R.id.tbnTechnicalsAssistance:
                onMainActivityView.transferFragment(ControlFrags.QUESTIONS, R.id.content, true);
                break;
        }
    }
}
