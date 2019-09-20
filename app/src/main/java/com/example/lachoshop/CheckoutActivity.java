package com.example.lachoshop;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;

public class CheckoutActivity extends AppCompatActivity {
    final double GST_VAR = 0.05; // Var of the current GST
    final double QST_VAR = 0.09975; // Var of the current QST

    double quebecTax = 0; // Var that stores the qst of the total price
    double governmentTax = 0; // Var that store the gst of the total price
    double finalPrice = 0; // Var that stores the final price

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        // Takes the total price, calculates the taxes and adds everything to the screen
        Bundle extra = getIntent().getExtras();
        if(extra != null){
            double totalPrice = extra.getDouble("totalPrice");

            TextView textViewBeforeTaxes = findViewById(R.id.textView_beforeTaxes);
            TextView textViewGst = findViewById(R.id.textView_gst);
            TextView textViewQst = findViewById(R.id.textView_qst);
            TextView textViewTotalWithTax = findViewById(R.id.textView_totalWithTax);

            governmentTax = totalPrice * GST_VAR;
            quebecTax = totalPrice * QST_VAR;
            finalPrice = totalPrice + governmentTax + quebecTax;

            textViewBeforeTaxes.setText("$" + roundTwoDecimals(totalPrice));
            textViewGst.setText("$" + roundTwoDecimals(governmentTax));
            textViewQst.setText("$" + roundTwoDecimals(quebecTax));
            textViewTotalWithTax.setText("$" + roundTwoDecimals(finalPrice));
        }
    }

    /**
     * Method to round a double to two decimals.
     * @param d
     * @return double with 2 decimals
     */
    double roundTwoDecimals(double d)
    {
        DecimalFormat twoDForm = new DecimalFormat("#.##");
        return Double.valueOf(twoDForm.format(d));
    }
}
