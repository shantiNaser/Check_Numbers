package com.example.numbers;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

class myStack{
    private int top=0;
    private int array[];


    public myStack(int t){ // Constructer
        t=10;
        array=new int[t];
        top=0;
    }


    public boolean isFull(){
        return top==array.length;
    }


    public boolean isEmpty(){
        return top==0;
    }


    public void push(int value){
        if(!isFull())
            array[top++]=value;
    }


    public int pop(){
        if(!isEmpty())
            return array[--top];
        return -9999;
    }

    @Override
    protected void finalize () // destracter
    {
        System.out.println("the finilize is called...");
    }




}

// end class myStack


class myQueue {

    private int array[];
    private int front=0;
    private int rear=0;


    public myQueue(int size){
        array=new int[size];
        rear=front=0;
    }


    public myQueue(){
        this(10);
    }


    public boolean isempty(){
        return rear==0;
    }


    public boolean isFull(){
        return front==rear;
    }


    public void add(int value){
        if(rear!=9){
    array[rear] = value;
    rear++;
}



    }


    public int Delete(){
        if(!isFull()){
            int savePoint=front;
            front++;
            return array[savePoint];
        }
        return -9999;

    }


    @Override
    protected void finalize () // destracter
    {
        System.out.println("the finilize is called...");
    }

}
// end class myQueue


public class MainActivity extends AppCompatActivity {

    private Button Bt;
    private EditText In;
    private TextView outV;
    //myStack st = new myStack(10);
    //myQueue Q = new myQueue(10);


    public boolean isPrime(int n) {


        if (n % 2 == 0) return false;

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }


/*

working without addTextChangeListener

    public boolean isPalindrome(int n) {

        while (n != 0) {
            st.push(n % 10);
            Q.add(n % 10);
            n /= 10;

        }

        while (!st.isEmpty() && !Q.isempty()) {
            if (st.pop() != Q.Delete()) {
                return false;
            }
        }
        return true;

    }
*/
    public boolean isPalindrome22(int n) {
        int rev=0;
        int numberinreverse=0;
        int savePoint;
        savePoint=n;
        while(n>0){
            rev=n%10;
            numberinreverse=(numberinreverse*10)+rev;
            n=n/10;
        }
        if(savePoint==numberinreverse)
            return true;
        else
          return false;
    }




    public int rev(int n) {

        int reversed = 0;
        while (n != 0) {
            int digit = n % 10;
            reversed = reversed * 10 + digit;
            n /= 10;
        }
        return reversed;
    }

    // the number is considerd to be emirp if the number is prime and the inverse of number also is prime
    public boolean isEmirp(int n) {

        if (isPrime(n)) {
            int InverseNum = rev(n);

            if (isPrime(InverseNum)) {
                return true;
            }
        }
        // return false if the number is not  prime
        return false;


    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar bar = getSupportActionBar();
        bar.setDisplayHomeAsUpEnabled(true);
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#5c485b")));


        // beautiful Color --> "#99b19c"
        Bt = findViewById(R.id.Bt);
        In = findViewById(R.id.In);
        outV = findViewById(R.id.outV);







        In.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {



                String s = In.getText().toString();

                if (s.isEmpty()) {
                   // Toast.makeText(this, "No Input for checking", Toast.LENGTH_SHORT).show();
                    outV.setText("No input ");
                } else {
                    int number = Integer.parseInt(s);
                    outV.setText("the Number ( " + number + " ) is :-");


                    if (isPalindrome22(number)) {
                        outV.append("\n---> Palindrome Number");
                    } else {
                        outV.append("\n---> Not Palindrome Number");

                    }

                    // To here Check if its Palindrome or not


                    if (isPrime(number)) {

                        outV.append("\n---> Prime Number");
                    } else {

                        outV.append("\n---> Not Prime Number");
                    }

                    if (isEmirp(number)) {
                        System.out.println("Hello World");
                        outV.append("\n---> twisted( Emirp ) Number");
                    } else {
                        outV.append("\n---> Not twisted( Emirp ) Number\"");
                    }


                }


            }


        });


Bt.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        openDialog();
    }
});


    }

    public void openDialog()
    {

        MyDia D1 = new MyDia();
        D1.show(getSupportFragmentManager(),"Example");

    }


}
