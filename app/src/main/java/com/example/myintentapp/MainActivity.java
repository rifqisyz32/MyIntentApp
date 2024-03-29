package com.example.myintentapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnMoveActivity;
    private Button btnMoveWithDataActivity;
    private Button btnMoveWithObject;
    private Button btnDialPhone;
    private Button btnMoveForResult;
    private TextView tvResult;
    private int REQUEST_CODE = 100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnMoveActivity = (Button)findViewById(R.id.btn_move_activity);
        btnMoveActivity.setOnClickListener(this);

        btnMoveWithDataActivity = (Button)findViewById(R.id.btn_move_activity_data);
        btnMoveWithDataActivity.setOnClickListener(this);

        btnMoveWithObject = (Button)findViewById(R.id.btn_move_activity_object);
        btnMoveWithObject.setOnClickListener(this);

        btnDialPhone = (Button)findViewById(R.id.btn_dial_number);
        btnDialPhone.setOnClickListener(this);

        btnMoveForResult = (Button)findViewById(R.id.btn_move_for_result);
        btnMoveForResult.setOnClickListener(this);
        tvResult = (TextView)findViewById(R.id.tv_result);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){

            case R.id.btn_move_activity:
                Intent moveIntent = new Intent(MainActivity.this, MoveActivity.class);
                startActivity (moveIntent);
                break;

            case R.id.btn_move_activity_data:
                Intent moveWithDataIntent = new Intent(MainActivity.this, MoveWithDataActivity.class);
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "Rifqi Syamsu Zulkarnain");
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NPM, 1817051032);
                startActivity(moveWithDataIntent);
                break;

            case R.id.btn_move_activity_object:
                Person mPerson = new Person();
                mPerson.setName("Rifqi Syamsu Zulkarnain");
                mPerson.setNpm(1817051032);
                mPerson.setEmail("rifqi.syamsu1032@students.unila.ac.id");
                mPerson.setCity("Lampung");
                Intent moveWithObjectIntent = new Intent(MainActivity.this, MoveWithObjectActivity.class);
                moveWithObjectIntent.putExtra(MoveWithObjectActivity.EXTRA_PERSON, mPerson);
                startActivity(moveWithObjectIntent);
                break;

            case R.id.btn_dial_number:
                String phoneNumber = "0895606095604";
                Intent dialPhoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phoneNumber));
                startActivity(dialPhoneIntent);
                break;

            case R.id.btn_move_for_result:
                Intent moveForResultIntent = new Intent(MainActivity.this, MoveForResultActivity.class);
                startActivityForResult(moveForResultIntent, REQUEST_CODE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE){
            if (resultCode == MoveForResultActivity.RESULT_CODE){
                int selectedValue = data.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE, 0);
                tvResult.setText("Hasil : "+selectedValue);
            }
        }
    }
}