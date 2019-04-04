package com.codedelegance.thedicer;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    private TextView rollsResult, totalResults, dieQTYValue;
    private SeekBar dieQty;
    private RadioGroup dieType;
    private Button roll;
    private int dieTypeValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rollsResult = findViewById(R.id.rollsResultsText);
        totalResults = findViewById(R.id.totalResultsText);
        dieQTYValue = findViewById(R.id.dieQTYValue);
        dieQty = findViewById(R.id.dieQtySeekBar);
        dieType = findViewById(R.id.dieTypeRadioGroup);
        roll = findViewById(R.id.rollButton);

        dieQTYValue.setText(dieQty.getProgress() + "/" + dieQty.getMax());
        dieType.check(R.id.d4);
        dieTypeValue = 4;

        dieQty.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            final int MIN = 1;
            int progress = 1;

            @Override
            public void onProgressChanged(SeekBar dieQty, int progressValue, boolean fromUser) {
                progress = progressValue;
                if (progress < MIN) {
                    dieQty.setProgress(MIN);
                }
                dieQTYValue.setText(progress + "/" + dieQty.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar dieQty) {
                // Do something here, if you want to do anything at the start of touching the seekbar
            }

            @Override
            public void onStopTrackingTouch(SeekBar dieQty) {
                dieQTYValue.setText(progress + "/" + dieQty.getMax());
            }
        });

        dieType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup dieQty, int checkedId) {
                if (checkedId == R.id.d2) {
                    dieTypeValue = 2;
                } else if (checkedId == R.id.d4) {
                    dieTypeValue = 4;
                } else if (checkedId == R.id.d6) {
                    dieTypeValue = 6;
                } else if (checkedId == R.id.d8) {
                    dieTypeValue = 8;
                } else if (checkedId == R.id.d10) {
                    dieTypeValue = 10;
                } else if (checkedId == R.id.d12) {
                    dieTypeValue = 12;
                } else if (checkedId == R.id.d20) {
                    Toast.makeText(getApplicationContext(), "D20", Toast.LENGTH_LONG).show();
                    dieTypeValue = 20;
                } else {
                    dieTypeValue = 100;
                }
            }
        });

        roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int dieQtyValue = dieQty.getProgress();
                int[] dieRolls;
                int totalRoll = 0;

                dieRolls = ProcessRoll.performRolls(dieQtyValue, dieTypeValue);

                for (int roll : dieRolls) {
                    totalResults.setText(Integer.toString(totalRoll += roll));
                }

                String rollText = "";
                for (int i = 0; i < dieRolls.length; i++) {
                    if (i == dieRolls.length - 1) {
                        rollText = rollText + dieRolls[i];
                    } else {
                        rollText = rollText + dieRolls[i] + ", ";
                    }
                }
                rollsResult.setText(rollText);
            }
        });
    }
}
