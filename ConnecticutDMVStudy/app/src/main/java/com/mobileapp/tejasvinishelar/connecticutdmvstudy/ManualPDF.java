package com.mobileapp.tejasvinishelar.connecticutdmvstudy;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.barteksc.pdfviewer.PDFView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ManualPDF extends Fragment {


    public ManualPDF() {
        // Required empty public constructor
    }

    PDFView manualpdf;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragment = inflater.inflate(R.layout.fragment_manual_pd, container, false);
        manualpdf = fragment.findViewById(R.id.pdfviewer);
        manualpdf.fromAsset("dmvconnecticutmanual.pdf").load();


        return fragment;
    }

}
