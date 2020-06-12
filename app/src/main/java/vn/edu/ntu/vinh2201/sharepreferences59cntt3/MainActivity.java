package vn.edu.ntu.vinh2201.sharepreferences59cntt3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edtName, edtBirthday, edtPhone;
    RadioGroup rdpSex;
    RadioButton rdbMale, rdbFemale;
    Button btnSave, btnRead, btnClear;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addViews();
        addEvents();
    }

    private void addViews(){
        edtName = findViewById(R.id.edtName);
        edtBirthday = findViewById(R.id.edtBirthday);
        edtPhone = findViewById(R.id.edtPhone);
    }

    private void onPostResume(){

    }

    private void addEvents(){
        btnSave.setOnClickListener(this);
        btnRead.setOnClickListener(this);
        btnClear.setOnClickListener(this);
    }

    private void onClick(View v){
        int id = v.getId();
        switch (id)
        {
            case R.id.btnSave: saveSharePref(); break;
            case R.id.btnRead: readSharePref(); break;
            case R.id.btnClear: clearScreen(); break;
        }
    }

    private void saveSharePref(){
        SharedPreferences preferences = getSharedPreferences("mySharePref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        if(preferences != null){
            editor.putString("name", edtName.getText().toString());
            editor.putString("birthday", edtBirthday.getText().toString());
            editor.putString("phone", edtPhone.getText().toString());
            editor.putString("male", rdbMale.isChecked());
            editor.putString("female", rdbFemale.isChecked());
        }

    }

    private void readSharePref(){
        SharedPreferences preferences = getSharedPreferences("mySharePref", Context.MODE_PRIVATE);
        edtName.setText(preferences.getString("name", "không tên"));
        edtBirthday.setText(preferences.getString("name", "chưa sinh ra"));
        edtPhone.setText(preferences.getString("name", "chưa mua"));
        rdbMale.setChecked(preferences.getBoolean("male", true));
        rdbFemale.setChecked(preferences.getBoolean("female", true));
    }

    private void clearScreen(){
        edtName.setText("");
        edtBirthday.setText("");
        edtPhone.setText("");
    }
}
