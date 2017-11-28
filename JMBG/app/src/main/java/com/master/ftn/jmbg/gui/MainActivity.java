package com.master.ftn.jmbg.gui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.master.ftn.jmbg.R;
import com.master.ftn.jmbg.data.ValidityCodes;
import com.master.ftn.jmbg.parser.Parser;
import com.master.ftn.jmbg.parser.Validator;

public class MainActivity extends AppCompatActivity
{
    private EditText edtTxtJMBG;
    private Button btnPrikazi;
    private TextView txtVwError;
    private TextView txtVwRezDob;
    private TextView txtVwRezMesto;
    private TextView txtVwRezPol;
    private TextView txtVwRezBroj;

    private String jmbg;

    private boolean isCorrect;

    private String result;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtTxtJMBG = (EditText) findViewById(R.id.jmbg);
        txtVwError = (TextView) findViewById(R.id.error);
        txtVwRezDob = (TextView) findViewById(R.id.rezDob);
        txtVwRezMesto = (TextView) findViewById(R.id.rezMesto);
        txtVwRezPol = (TextView) findViewById(R.id.rezPol);
        txtVwRezBroj = (TextView) findViewById(R.id.rezBroj);

        btnPrikazi = (Button) findViewById(R.id.prikazi);
        btnPrikazi.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                isCorrect = true;
                result = "Uspesno parsiranje!";

                jmbg = edtTxtJMBG.getText().toString();

                // Provera duzine
                checkLength();

                // Provera parnosti
                checkParity();

                // Provera datuma
                checkDate();

                // Provera mesta rodjenja
                checkLocation();

                txtVwError.setTextSize(getResources().getDimension(R.dimen.textsize));

                int color;

                if (isCorrect)
                {
                    color = Color.GREEN;
                }
                else
                {
                    color = Color.RED;
                }

                txtVwError.setTextColor(color);
                txtVwError.setText(result);

                if (isCorrect)
                {
                    txtVwRezDob.setTextSize(getResources().getDimension(R.dimen.textsize));
                    txtVwRezDob.setText(getResources().getString(R.string.dob) + ": " + Parser.getDOB(jmbg));
                    txtVwRezMesto.setTextSize(getResources().getDimension(R.dimen.textsize));
                    txtVwRezMesto.setText(getResources().getString(R.string.mesto) + ": " + Parser.getLocation(jmbg));
                    txtVwRezPol.setTextSize(getResources().getDimension(R.dimen.textsize));
                    txtVwRezPol.setText(getResources().getString(R.string.pol) + ": " + Parser.getSex(jmbg));
                    txtVwRezBroj.setTextSize(getResources().getDimension(R.dimen.textsize));
                    txtVwRezBroj.setText (getResources().getString(R.string.broj) + ": " + Parser.getNumber(jmbg));
                }

                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(edtTxtJMBG.getWindowToken(), 0);
            }
        });
    }

    private void checkLength ()
    {
        int rez = Validator.checkLength(jmbg);
        if (rez == ValidityCodes.SHORTER)
        {
            isCorrect = false;
            result = "JMBG nema dovoljno cifara!!!";
        }
        else if (rez == ValidityCodes.LONGER)
        {
            isCorrect = false;
            result = "JMBG ima previse cifara!!!";
        }
    }

    private void checkParity ()
    {
        boolean rez = Validator.checkParity(jmbg);

        if (!rez)
        {
            isCorrect = false;
            result = "Parnost nije dobra!!!";
        }
    }

    private void checkDate ()
    {
        boolean rez = Validator.checkDate(jmbg);

        if (!rez)
        {
            isCorrect = false;
            result = "Datum nije ispravan!!!";
        }
    }

    private void checkLocation ()
    {
        boolean rez = Validator.checkLocation(jmbg);

        if (!rez)
        {
            isCorrect = false;
            result = "8. i 9. cifra nisu ispravno unete!!!";
        }
    }
}
