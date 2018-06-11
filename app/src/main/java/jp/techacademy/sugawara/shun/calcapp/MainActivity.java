package jp.techacademy.sugawara.shun.calcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.support.design.widget.Snackbar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    double num1 = 0;
    double num2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button plusButton = (Button) findViewById(R.id.plusButton);
        Button minusButton = (Button) findViewById(R.id.minusButton);
        Button kakeButton = (Button) findViewById(R.id.kakeButton);
        Button wariButton = (Button) findViewById(R.id.wariButton);

        plusButton.setOnClickListener(this);
        minusButton.setOnClickListener(this);
        kakeButton.setOnClickListener(this);
        wariButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        double answer = 0;


        EditText editText1 = (EditText) findViewById(R.id.editText1);
        EditText editText2 = (EditText) findViewById(R.id.editText2);

        if(editText1.getText().toString().matches("") || editText2.getText().toString().matches("")){
//            Log.d("TestTest","数値を入力してください");
            Snackbar.make(v,"数値を入力して下さい",Snackbar.LENGTH_LONG).show();
            return;
        }

        num1 = Double.parseDouble(editText1.getText().toString());
        num2 = Double.parseDouble(editText2.getText().toString());


        switch (v.getId()){
            case R.id.plusButton :
                answer = num1 + num2;break;
            case R.id.minusButton :
                answer = num1 - num2;break;
            case R.id.kakeButton :
                //12*3.3 が39.6にならない
                answer = num1 * num2;break;
            case R.id.wariButton :
                answer = num1 / num2;break;
        }

        Log.d("TestTest",String.valueOf(answer));

        Intent intent = new Intent(this,SecondActivity.class);
        intent.putExtra("VALUE1",answer);
        startActivity(intent);

    }

}
