package com.mobileapp.tejasvinishelar.connecticutdmvstudy;

import android.app.Fragment;
import android.graphics.Color;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.List;

public class TestOneFragment extends Fragment {

    public TestOneFragment() {
    }

    TextView question,wrongans;
    RadioGroup group;
    RadioButton option1,option2,option3,selectedRadioButton;
    Button next;
    int qid = 1, correctAns= 0, wrongAns = 0;
    Q que;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View fragmentView = inflater.inflate(R.layout.test_one_fragment, container, false);
        question = (TextView)fragmentView.findViewById(R.id.textView);
        group = (RadioGroup)fragmentView. findViewById(R.id.radioGroup);
        option1 =(RadioButton)fragmentView.findViewById(R.id.radioButton1);
        option2 =(RadioButton) fragmentView.findViewById(R.id.radioButton2);
        option3 = (RadioButton)fragmentView.findViewById(R.id.radioButton3);
        next = (Button)fragmentView.findViewById(R.id.button);
        wrongans = (TextView)fragmentView.findViewById(R.id.textView2);


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Test1");

        Log.d("TAG","MYREF : "+myRef);
        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    Test test1 = dataSnapshot.getValue(Test.class);
                    final List<Q> questions = test1.getQ();
                    Log.d("TAG","QUESTIONS LIST"+questions);

                    que = new Q();
                    que= questions.get(0);
                    Log.d("TAG","QUESTION"+que.getAnswer());
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

                            int selectedRadioButtonId  = group.getCheckedRadioButtonId();
                            selectedRadioButton = (RadioButton)fragmentView.findViewById(selectedRadioButtonId);
                            if(selectedRadioButton.getText().equals(que.getAnswer())){
                                selectedRadioButton.setBackgroundColor(Color.GREEN);
                                correctAns++;
                            }else{
                                String correctOption = que.getAnswer();
                                if(correctOption==option1.getText()){
                                    option1.setBackgroundColor(Color.GREEN);
                                }else if(correctOption == option2.getText()){
                                    option2.setBackgroundColor(Color.GREEN);
                                }else{
                                    option3.setBackgroundColor(Color.GREEN);
                                }
                                wrongAns++;
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
                            if(qid == 9){
                                if(correctAns>0){correctAns--;}
                                if(correctAns>0){wrongAns--;}

                                question.setBackgroundColor(Color.GREEN);
                                question.setText(("Correct ANS : "+ correctAns));
                                wrongans.setVisibility(View.VISIBLE);
                                wrongans.setBackgroundColor(Color.RED);
                                wrongans.setPaddingRelative(20,20,20,20);
                                wrongans.setText("Wrong ANS : "+wrongAns);
                                group.setVisibility(View.INVISIBLE);
                                next.setVisibility(View.INVISIBLE);
                            }
                            }
                    });


                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Tag", "Failed to read value.", error.toException());
            }
        });
        return fragmentView;
    }
}

