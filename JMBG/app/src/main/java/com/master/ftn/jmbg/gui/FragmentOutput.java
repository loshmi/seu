package com.master.ftn.jmbg.gui;

/**
 * Created by Loshmi on 11/27/2017.
 */

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.master.ftn.jmbg.R;

public class FragmentOutput extends Fragment
{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_output, container, false);
    }
}