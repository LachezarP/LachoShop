package com.example.lachoshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    double totalPrice = 0; // Var to store the total price before taxes

    int firstProduct = 0; // Var to show how many of the first products the client has chosen
    int secondProduct = 0; // Var to show how many of the second products the client has chosen
    int thirdProduct = 0; // Var to show how many of the third products the client has chosen
    int fourthProduct = 0; // Var to show how many of the fourth products the client has chosen

    final int PRICE_FIRST_PRODUCT = 75; // Var for the final price of the first product
    final int PRICE_SECOND_PRODUCT = 146; // Var for the final price of the second product
    final int PRICE_THIRD_PRODUCT = 290; // Var for the final price of the third product
    final int PRICE_FOURTH_PRODUCT = 49; // Var for the final price of the fourth product

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Method to :
     *      +Add the items
     *      +Calculate the total price of each product from the number of the products chosen
     *      +Display it on the screen
     * @param view
     */
    public void addItem(View view) {
        String strTemp ="";

        switch (view.getId()) {
            case R.id.button_card1Add:
                TextView textViewCard1Amount = findViewById(R.id.textView_card1Amount);
                TextView textViewCard1Total = findViewById(R.id.textView_card1Total);

                firstProduct++;
                strTemp = Integer.toString(firstProduct);
                textViewCard1Amount.setText(strTemp);
                strTemp = "Total : $" + firstProduct * PRICE_FIRST_PRODUCT;
                textViewCard1Total.setText(strTemp);
                break;

            case R.id.button_card2Add:
                TextView textViewCard2Amount = findViewById(R.id.textView_card2Amount);
                TextView textViewCard2Total = findViewById(R.id.textView_card2Total);

                secondProduct++;
                strTemp = Integer.toString(secondProduct);
                textViewCard2Amount.setText(strTemp);
                strTemp = "Total : $" + secondProduct * PRICE_SECOND_PRODUCT;
                textViewCard2Total.setText(strTemp);
                break;

            case R.id.button_card3Add:
                TextView textViewCard3Amount = findViewById(R.id.textView_card3Amount);
                TextView textViewCard3Total = findViewById(R.id.textView_card3Total);

                thirdProduct++;
                strTemp = Integer.toString(thirdProduct);
                textViewCard3Amount.setText(strTemp);
                strTemp = "Total : $" + thirdProduct * PRICE_THIRD_PRODUCT;
                textViewCard3Total.setText(strTemp);
                break;
            case R.id.button_card4Add:
                TextView textViewCard4Amount = findViewById(R.id.textView_card4Amount);
                TextView textViewCard4Total = findViewById(R.id.textView_card4Total);

                fourthProduct++;
                strTemp = Integer.toString(fourthProduct);
                textViewCard4Amount.setText(strTemp);
                strTemp = "Total : $" + fourthProduct * PRICE_FOURTH_PRODUCT;
                textViewCard4Total.setText(strTemp);
                break;

        }

    }

    /**
     * Method to :
     *      +Remove the items
     *      +Calculate the total price of each product from the number of the products chosen
     *      +Display it on the screen
     * @param view
     */
    public void removeItem(View view) {
        String strTemp = "";

        switch (view.getId()) {
            case R.id.button_card1Remove:
                if (firstProduct == 0) {
                    break;
                }
                else {
                    TextView textViewCard1Amount = findViewById(R.id.textView_card1Amount);
                    TextView textViewCard1Total = findViewById(R.id.textView_card1Total);

                    firstProduct--;
                    strTemp = Integer.toString(firstProduct);
                    textViewCard1Amount.setText(strTemp);
                    strTemp = "Total : $" + firstProduct * PRICE_FIRST_PRODUCT;
                    textViewCard1Total.setText(strTemp);
                    break;
                }
            case R.id.button_card2Remove:
                if (secondProduct == 0) {
                    break;
                }
                else {
                    TextView textViewCard2Amount = findViewById(R.id.textView_card2Amount);
                    TextView textViewCard2Total = findViewById(R.id.textView_card2Total);

                    secondProduct--;
                    strTemp = Integer.toString(secondProduct);
                    textViewCard2Amount.setText(strTemp);
                    strTemp = "Total : $" + secondProduct * PRICE_SECOND_PRODUCT;
                    textViewCard2Total.setText(strTemp);
                    break;
                }
            case R.id.button_card3Remove:
                if (thirdProduct == 0) {
                    break;
                }
                else {
                    TextView textViewCard3Amount = findViewById(R.id.textView_card3Amount);
                    TextView textViewCard3Total = findViewById(R.id.textView_card3Total);

                    thirdProduct--;
                    strTemp = Integer.toString(thirdProduct);
                    textViewCard3Amount.setText(strTemp);
                    strTemp = "Total : $" + thirdProduct * PRICE_THIRD_PRODUCT;
                    textViewCard3Total.setText(strTemp);
                    break;
                }
            case R.id.button_card4Remove:
                if (fourthProduct == 0) {
                    break;
                }
                else {
                    TextView textViewCard4Amount = findViewById(R.id.textView_card4Amount);
                    TextView textViewCard4Total = findViewById(R.id.textView_card4Total);

                    fourthProduct--;
                    strTemp = Integer.toString(fourthProduct);
                    textViewCard4Amount.setText(strTemp);
                    strTemp = "Total : $" + fourthProduct * PRICE_FOURTH_PRODUCT;
                    textViewCard4Total.setText(strTemp);
                    break;
                }
        }
    }

    /**
     * Method to calculate and send the final price to the CheckOut activity
     * @param view
     */
    public void checkOut(View view) {
        totalPrice = firstProduct * PRICE_FIRST_PRODUCT
                + secondProduct * PRICE_SECOND_PRODUCT
                + thirdProduct * PRICE_THIRD_PRODUCT
                + fourthProduct * PRICE_FOURTH_PRODUCT;

        Intent checkOutIntent = new Intent(MainActivity.this, CheckoutActivity.class);
        checkOutIntent.putExtra("totalPrice", totalPrice);
        startActivity(checkOutIntent);
    }
}
