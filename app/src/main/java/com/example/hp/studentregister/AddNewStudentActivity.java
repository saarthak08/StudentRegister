package com.example.hp.studentregister;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hp.studentregister.databinding.ActivityAddNewStudentBinding;

public class AddNewStudentActivity extends AppCompatActivity {

    private Button submitButton;
    private EditText nameEditText;
    private EditText emailEditText;
    private EditText countryEditText;
    private ActivityAddNewStudentBinding activityAddNewStudentBinding;
    private AddNewStudentClickHandlers addNewStudentClickHandlers;
    private Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityAddNewStudentBinding= DataBindingUtil.setContentView(AddNewStudentActivity.this,R.layout.activity_add_new_student);
        addNewStudentClickHandlers=new AddNewStudentClickHandlers(AddNewStudentActivity.this);
        activityAddNewStudentBinding.setClickHandlers(addNewStudentClickHandlers);
        student= new Student();
        activityAddNewStudentBinding.setStudent(student);
        nameEditText=findViewById(R.id.et_name);
        emailEditText=findViewById(R.id.et_email);
        countryEditText=findViewById(R.id.et_country);
        submitButton=findViewById(R.id.btnSubmit);



    }
    public class AddNewStudentClickHandlers{
        Context context;
        public AddNewStudentClickHandlers(Context context) {
            this.context=context;
        }
        public void onSubmitButtonClicked(View view)
        {
            if(student.getName()==null){

                Toast.makeText(getApplicationContext(),"Name field cannot be empty",Toast.LENGTH_LONG).show();
            }else{
                Intent intent=new Intent();
                intent.putExtra("NAME",student.getName());
                intent.putExtra("EMAIL",student.getEmail());
                intent.putExtra("COUNTRY",student.getCountry());
                setResult(RESULT_OK,intent);
                finish();
            }
        }
    }
}
