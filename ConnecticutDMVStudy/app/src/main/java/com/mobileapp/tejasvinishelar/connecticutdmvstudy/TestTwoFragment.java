package com.mobileapp.tejasvinishelar.connecticutdmvstudy;


import android.app.Fragment;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class TestTwoFragment extends Fragment {

    TextView question;
    RadioGroup group;
    RadioButton option1,option2,option3,selectedRadioButton;
    Button next;
    int qid = 1;
    Q que;

    public TestTwoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View fragmentView = inflater.inflate(R.layout.fragment_test_two, container, false);
        String dmvJson = loadJSONFromAsset(fragmentView.getContext());
        Log.d("TAG JSOn", "JSON :" + dmvJson);
        try {
            JSONObject obj = new JSONObject(dmvJson);
            Log.d("TAG Object", "Obj :" + obj);
            /*JSONArray jsonArray  = obj.getJSONArray("Test2");
            Log.d("TAG Object", "jsonArray :" + obj);*/
            JSONObject jsonObject = obj.getJSONObject("Test2");
            Log.d("TAG Object", "jsonObject :" + jsonObject);


            /*Test test2 = ( (Test) jsonObject);
            final List<Q> questions = test2.getQ();
            Log.d("TAG", "QUESTIONS LIST" + questions);

            que = new Q();
            que = questions.get(qid);
            Log.d("TAG", "QUESTION" + que.getAnswer());
            question.setText(que.getQuestion());
            List<String> options = que.getOptions();
            option1.setText(options.get(0));
            option2.setText(options.get(1));
            option3.setText(options.get(2));
            option1.setBackgroundColor(Color.WHITE);
            option2.setBackgroundColor(Color.WHITE);
            option3.setBackgroundColor(Color.WHITE);

            group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {

                    int selectedRadioButtonId = group.getCheckedRadioButtonId();
                    selectedRadioButton = (RadioButton) fragmentView.findViewById(selectedRadioButtonId);
                    if (selectedRadioButton.getText().equals(que.getAnswer())) {
                        selectedRadioButton.setBackgroundColor(Color.GREEN);
                    } else {
                        String correctOption = que.getAnswer();
                        if (correctOption == option1.getText()) {
                            option1.setBackgroundColor(Color.GREEN);
                        } else if (correctOption == option2.getText()) {
                            option2.setBackgroundColor(Color.GREEN);
                        } else {
                            option3.setBackgroundColor(Color.GREEN);
                        }
                        selectedRadioButton.setBackgroundColor(Color.RED);

                    }
                }
            });

            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    option1.setChecked(false);
                    option2.setChecked(false);
                    option3.setChecked(false);
                    qid++;
                    que = questions.get(qid);
                    que = questions.get(qid);
                    question.setText(que.getQuestion());
                    List<String> options = que.getOptions();
                    option1.setText(options.get(0));
                    option2.setText(options.get(1));
                    option3.setText(options.get(2));
                    option1.setBackgroundColor(Color.WHITE);
                    option2.setBackgroundColor(Color.WHITE);
                    option3.setBackgroundColor(Color.WHITE);

                }
            });
*/
        }catch(Exception e){

        }



        return fragmentView;
    }

    public String loadJSONFromAsset(Context context) {
        String json = null;
        try {
            InputStream is = context.getAssets().open("ctdmvtest.json");

            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);

            is.close();

            json = new String(buffer, "UTF-8");


        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;

    }
}
