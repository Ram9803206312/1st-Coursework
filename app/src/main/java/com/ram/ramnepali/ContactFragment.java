package com.ram.ramnepali;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class ContactFragment extends Fragment {

//initial Variable
private  View view;
private EditText tvToEmail;
private EditText tvSubject;
private EditText tvMessage;
private EditText Phone_num;
Button btnSent ;
ImageView toPhone;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =inflater.inflate(R.layout.fragment_contact, container, false);
        return view;


    }
    @Override
    public void onViewCreated (@NonNull View view,@NonNull Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
      //  Assign Variable
        tvToEmail = view.findViewById(R.id.tvToEmail);
        tvSubject = view.findViewById(R.id.tvSubject);
        tvMessage = view.findViewById(R.id.tvMessage);
        Phone_num = view.findViewById(R.id.Phone_num);
        btnSent = view.findViewById(R.id.btnSent);
        btnSent.setOnClickListener(new View.OnClickListener() {
            //create method  onclick  for send email button
             @Override
             public void onClick(View view) {
                 String to = tvToEmail.getText().toString().trim();
                 String Subject = tvSubject.getText().toString().trim();
                 String Message  = tvMessage.getText().toString().trim();
                 Intent intent = new Intent(Intent.ACTION_SEND);
                 intent.putExtra(Intent.EXTRA_EMAIL,new String[] {to});
                 intent.putExtra(Intent.EXTRA_SUBJECT,Subject);
                 intent.putExtra(Intent.EXTRA_TEXT,Message);
                 intent.setType("message/rfc822");
                 startActivity(Intent.createChooser(intent,"Choose an email client"));
             }
         });
        // create  method  onclick  for  toPhone
        toPhone = view.findViewById(R.id.toPhone);
        toPhone.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String call = Phone_num.getText().toString().trim();
               Intent intent = new Intent(Intent.ACTION_DIAL);
               intent.setData(Uri.parse("tel:"+call));
               startActivity(intent);
           }
        });
    }
}
