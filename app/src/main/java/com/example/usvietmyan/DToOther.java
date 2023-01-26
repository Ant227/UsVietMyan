package com.example.usvietmyan;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class DToOther extends Fragment {
    private  static final String TAG = "DToOther";

    private EditText InputDong , dMmkValue , dUSvalue;
    private TextView DmmkResult,DusResult;
    private Button DConvert;



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {

       View view = inflater.inflate((R.layout.d_to_other),container,false);

        InputDong = (EditText) view.findViewById(R.id.d_dong_input_value);
        DmmkResult = (TextView) view.findViewById(R.id.d_mmk_result);
        DusResult = (TextView) view.findViewById(R.id.d_us_result);
        dMmkValue = (EditText) view.findViewById(R.id.d_mmk_value);
        dUSvalue = (EditText) view.findViewById(R.id.d_us_value);


        DConvert = (Button) view.findViewById(R.id.d_convert);

        DConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputDong.onEditorAction(EditorInfo.IME_ACTION_DONE);
                String dongInput = InputDong.getText().toString();



                if(TextUtils.isEmpty(dongInput))
                {
                    Toast.makeText(getActivity(), "Please Enter Value First", Toast.LENGTH_SHORT).show();
                }
                else
                {

                    NumberFormat formatter = new DecimalFormat("#,###");


                    String mmkValue = dMmkValue.getText().toString();
                    float mmkValueFloat = Float.parseFloat(mmkValue);



                    String usValue = dUSvalue.getText().toString();
                    float usValueFloat = Float.parseFloat(usValue);

                    float usRating = 1/usValueFloat;




                    float dongInputFloat = Float.parseFloat(dongInput);
                    float mmkResult = (float) (dongInputFloat * (usRating * mmkValueFloat));
                    String formattedNumber1 = formatter.format(mmkResult);
                    DmmkResult.setText(formattedNumber1);





                    float usResult = (float) (dongInputFloat * usRating);
                    String UsresultValueString = String.format("%.2f",usResult);
                    DusResult.setText(UsresultValueString);
                }

            }
        });




        return  view;
    }
    }
