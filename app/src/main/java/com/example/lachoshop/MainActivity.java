package com.example.lachoshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    double totalPrice = 0;

    int firstProduct = 0;
    int secondProduct = 0;
    int thirdProduct = 0;
    int fourthProduct = 0;

    final int PRICE_FIRST_PRODUCT = 75;
    final int PRICE_SECOND_PRODUCT = 146;
    final int PRICE_THIRD_PRODUCT = 290;
    final int PRICE_FOURTH_PRODUCT = 49;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addItem(View view) {
        String strTemp ="";

        switch (view.getId()) {
            case R.id.button_card1Add:
                TextView textViewCard1Amount = (TextView)findViewById(R.id.textView_card1Amount);
                TextView textViewCard1Total = (TextView)findViewById(R.id.textView_card1Total);

                firstProduct++;
                strTemp = Integer.toString(firstProduct);
                textViewCard1Amount.setText(strTemp);
                strTemp = "Total : $" + firstProduct * PRICE_FIRST_PRODUCT;
                textViewCard1Total.setText(strTemp);
                break;

            case R.id.button_card2Add:
                TextView textViewCard2Amount = (TextView)findViewById(R.id.textView_card2Amount);
                TextView textViewCard2Total = (TextView)findViewById(R.id.textView_card2Total);
                secondProduct++;
                strTemp = Integer.toString(secondProduct);
                textViewCard2Amount.setText(strTemp);
                strTemp = "Total : $" + secondProduct * PRICE_SECOND_PRODUCT;
                textViewCard2Total.setText(strTemp);
                break;

            case R.id.button_card3Add:
                TextView textViewCard3Amount = (TextView)findViewById(R.id.textView_card3Amount);
                TextView textViewCard3Total = (TextView)findViewById(R.id.textView_card3Total);
                thirdProduct++;
                strTemp = Integer.toString(thirdProduct);
                textViewCard3Amount.setText(strTemp);
                strTemp = "Total : $" + thirdProduct * PRICE_THIRD_PRODUCT;
                textViewCard3Total.setText(strTemp);
                break;
            case R.id.button_card4Add:
                TextView textViewCard4Amount = (TextView)findViewById(R.id.textView_card4Amount);
                TextView textViewCard4Total = (TextView)findViewById(R.id.textView_card4Total);
                fourthProduct++;
                strTemp = Integer.toString(fourthProduct);
                textViewCard4Amount.setText(strTemp);
                strTemp = "Total : $" + fourthProduct * PRICE_FOURTH_PRODUCT;
                textViewCard4Total.setText(strTemp);
                break;

        }
        //Log.d("test", Double.toString(totalPrice));
    }

}
