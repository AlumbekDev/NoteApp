package com.example.noteapp.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.noteapp.R;
import com.example.noteapp.model.TaskModel;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FormFragment extends Fragment {
    TextView title, desc;
    TextView save;
    TaskModel model;

    TextView txtData, txtTime;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_form, container, false);
        initView(view);
        initClickListener();
        getData();

        return view;

    }

    private void getData() {
        Calendar wer = Calendar.getInstance();
        SimpleDateFormat et = new SimpleDateFormat("d MMMM");
        SimpleDateFormat tet = new SimpleDateFormat(" HH:mm");
        String strEt = et.format(wer.getTime());
        String strTet = tet.format(wer.getTime());
        txtData.setText(strEt);
        txtTime.setText(strTet);

    }

    private void initView(View view) {
        title = view.findViewById(R.id.title_et);
        txtData = view.findViewById(R.id.right);
        save = view.findViewById(R.id.readi_text);
        txtTime = view.findViewById(R.id.easeOut);
    }

    private void initClickListener() {
        save.setOnClickListener(v -> {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMMM HH:mm");
            String date = simpleDateFormat.format(new Date());
            String tit = title.getText().toString();
            model = new TaskModel(tit, date);
            Bundle bundle = new Bundle();
            bundle.putSerializable("model", model);
            getParentFragmentManager().setFragmentResult("rv_model", bundle);
            close();
        });
    }

    private void close() {
        NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_content_main);
        navController.navigateUp();
    }


}