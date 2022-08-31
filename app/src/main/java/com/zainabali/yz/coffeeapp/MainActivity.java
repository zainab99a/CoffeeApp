package com.zainabali.yz.coffeeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
Button button1,button2,button3;
TextView text1,text2;
CheckBox addingCream,addingChocolate;
int i=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     button1=findViewById(R.id.increment);
     button2=findViewById(R.id.decrement);
     button3=findViewById(R.id.order);
        text1= findViewById(R.id.quantity);
        text2=findViewById(R.id.price);
        addingCream=findViewById(R.id.box);
        addingChocolate=findViewById(R.id.box2);
      }//onCreate()

    public void Increment(View view) {
        i+=1;
        displayQuantity(i);
    }

    public void Decrement(View view) {
        if(i>1){
        i-=1;}
        else {
            Toast.makeText(this, "You can not have less than 1 coffee", Toast.LENGTH_SHORT).show();
        }
        displayQuantity(i);

    }
//in order() we add check method
    public void Order(View view) {
       boolean hasChecked=addingCream.isChecked();
       boolean isChecked=addingChocolate.isChecked();
        int calculatePrice= price(hasChecked,isChecked);
       // Log.v("MainActivity","has whipping cream  " +hasChecked);//to check  if the code is correct
      //  String priceMassage="Total Price : "+" "+ price(i)+"$"+"\n Has whipping cream? " +hasChecked+"\n Thanks";
        //we add whipping cream to display massage on phone
        String message = createOrderSummary(calculatePrice, hasChecked, isChecked);
        displayMassage(message);


    }

    private void displayMassage(String message){
        text2.setText(message);

    }

    @SuppressLint("SetTextI18n")
    private void displayQuantity(int num){
        text1.setText(""+num);
    }
    private int price(boolean addCream,boolean addChocolate){
       int basePrice=2;
       if (addCream){basePrice+=1;}
       if (addChocolate){basePrice+=2;}
       return i*basePrice;
    }

    private String createOrderSummary(int price, boolean addWhippedCream, boolean addChocolate) {
        String priceMessage= "\nAdd whipped cream? " + addWhippedCream;
        priceMessage += "\nAdd chocolate? " + addChocolate;
        priceMessage += "\nTotal: $" + price;
        priceMessage += "\nThank you!";
        return priceMessage;
    }


}//main()