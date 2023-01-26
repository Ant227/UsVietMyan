package com.example.usvietmyan;

import android.os.Bundle;
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

public class MmkToOther extends Fragment {
    private  static final String TAG = "MmkToOther";

    private EditText InputDong , dMmkValue , dUSvalue;
    private TextView DmmkResult,DusResult;
    private Button DConvert;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
       View view = inflater.inflate((R.layout.mmk_to_other),container,false);

        InputDong = (EditText) view.findViewById(R.id.mmk_mmk_input_value);
        DmmkResult = (TextView) view.findViewById(R.id.mmk_us_result);
        DusResult = (TextView) view.findViewById(R.id.mmk_dong_result);
        dMmkValue = (EditText) view.findViewById(R.id.mmk_mmk_value);
        dUSvalue = (EditText) view.findViewById(R.id.mmk_us_value);


        DConvert = (Button) view.findViewById(R.id.mmk_convert);




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
                    float mmkResult = (float) (dongInputFloat / mmkValueFloat);
                    String MMKresultValueString = String.format("%.2f",mmkResult);
                    DmmkResult.setText(MMKresultValueString);





                    float usResult = (float) (mmkResult * usValueFloat);

                    String formattedNumber2 = formatter.format(usResult);
                    DusResult.setText(formattedNumber2);
                }

            }
        });



       return  view;
    }
    }
