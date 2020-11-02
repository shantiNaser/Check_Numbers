package com.example.numbers;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatDialogFragment;

public class MyDia extends AppCompatDialogFragment {

    @Override
public Dialog onCreateDialog(Bundle savedInstanceState)
{
    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
    builder.setTitle("Defination(what i Do) ---> ")
            .setMessage("Primes number --> numbers greater than 1, that have only two factors ( 1 and the number itself.\n\n" +
                    "Palindrome number ---> that remains the same when its digits are reversed (such as 16461).\n\n " +
                    "Twisted number ---> A number it is a prime number and reverse of the number is also a prime number.")

            .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
      return builder.create();
}
}
