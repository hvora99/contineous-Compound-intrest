package lnclcgd.fnplaner.mortvatclc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Objects;

import lnclcgd.fnplaner.mortvatclc.AdHelper.TopOnAdsHelper;

public class MortgageLoan extends AppCompatActivity {

    private static final String LOAN_AMOUNT = "LOAN_AMOUNT";
    private static final String CUSTOM_INTEREST_RATE = "CUSTOM_INTEREST_RATE";

    private double currentLoanAmount ;

    private double currentCustomRate; 
    private TextView customRateTextView; 

    private EditText tenYearEditText;  
    private EditText fifteenYearEditText;  
    private EditText thirtyYearEditText;   


    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate (savedInstanceState);
        Objects.requireNonNull (getSupportActionBar ( )).hide ();
        setContentView ( R.layout.activity_mortgage_loan);

        TopOnAdsHelper.LOADBANNERAD(MortgageLoan.this,findViewById(R.id.banner_container));
        TopOnAdsHelper.LoadNativeAd(MortgageLoan.this,findViewById(R.id.native_ad_container));

        ImageView q3 = (ImageView) findViewById(R.id.q2);
        q3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               openportal1 ();

            }
        });

        if ( savedInstanceState == null )  
        {
            currentLoanAmount = 0.0;  
            currentCustomRate = 5.00;  
        } // end if
        else  
        {
            currentLoanAmount = savedInstanceState.getDouble(LOAN_AMOUNT);

             currentCustomRate =
                    savedInstanceState.getDouble(CUSTOM_INTEREST_RATE);
        } // end else

         customRateTextView = (TextView) findViewById(R.id.customRateTextView);

        EditText loanEditText = (EditText) findViewById (R.id.loanEditText);
         loanEditText.addTextChangedListener(loanEditTextWatcher);

         SeekBar customSeekBar = (SeekBar) findViewById(R.id.customSeekBar);
        customSeekBar.setOnSeekBarChangeListener(customSeekBarListener);

         tenYearEditText = (EditText) findViewById(R.id.tenYearEditText);
        fifteenYearEditText = (EditText) findViewById(R.id.fifteenYearEditText);
        thirtyYearEditText = (EditText) findViewById(R.id.thirtyYearEditText);
    }

     private double formula(double loan, double rate, int term)
    {
        double c = rate/100/12.;
        double n = term *12 ;
        return loan * (c * Math.pow(1 + c, n )) / ( Math.pow(1 + c,n)-1);
    }

     @SuppressLint({"DefaultLocale", "SetTextI18n"})
     private void updateMonthlyPayment()
    {
         double tenYearMonthly =
                formula(currentLoanAmount,currentCustomRate, 10 );
        double fifteenYearMonthly =
                formula(currentLoanAmount,currentCustomRate, 20 );
        double thirtyYearMonthly =
                formula(currentLoanAmount,currentCustomRate, 30 );

        // 10, 15 and 30 yr monthly payment EditTexts
        tenYearEditText.setText("₹" + String.format("% .0f", tenYearMonthly));
        fifteenYearEditText.setText("₹" + String.format("%.0f", fifteenYearMonthly));
        thirtyYearEditText.setText("₹" + String.format("%.0f", thirtyYearMonthly));
    }

    // updates the custom rate and monthly payment EditTexts
    @SuppressLint({"DefaultLocale", "SetTextI18n"})
    private void updateCustomRate()
    {
        // set customRateTextView's text to match the position of the SeekBar
        customRateTextView.setText(String.format("%.02f", currentCustomRate) + "%");
        updateMonthlyPayment(); // update the 10, 15 and 30 yr EditTexts

    }

    // save values of loanEditText and customSeekBar
    @Override
    protected void onSaveInstanceState( @NonNull Bundle outState)
    {
        super.onSaveInstanceState(outState);

        outState.putDouble(LOAN_AMOUNT, currentLoanAmount);
        outState.putDouble(CUSTOM_INTEREST_RATE, currentCustomRate);
    }

     private final SeekBar.OnSeekBarChangeListener customSeekBarListener =
            new SeekBar.OnSeekBarChangeListener ()
            {
                // update currentCustomRate, then call updateCustomRate
                public void onProgressChanged(SeekBar seekBar, int progress,
                                              boolean fromUser)
                {
                    // get currentCustomRate from the position of the SeekBar's thumb
                    currentCustomRate = seekBar.getProgress() / 100.0;
                    // update EditTexts for custom rate and monthly
                    updateCustomRate();
                }

                public void onStartTrackingTouch(SeekBar seekBar)
                {}

                public void onStopTrackingTouch( SeekBar seekBar)
                {}
            };

    // event-handling object that responds to loanEditText's events
    private final TextWatcher loanEditTextWatcher = new TextWatcher ()
    {
        // called when the user enters a number

        public void onTextChanged(CharSequence s, int start, int before, int count)
        {
            // convert loanEditText's text to a double
            try
            {
                currentLoanAmount = Double.parseDouble(s.toString());
            }
            catch (NumberFormatException e)
            {
                currentLoanAmount = 0.0; // default if an exception occurs
            }

            // update the Monthly Payment
            updateMonthlyPayment(); // update the 10, 15 and 30 yr EditTexts
        }

        public void afterTextChanged( Editable s)
        {}

        public void beforeTextChanged(CharSequence s, int start, int count,
                                      int after)
        {}
    };

    public void openportal1() {
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        builder.setToolbarColor( ContextCompat.getColor(this, R.color.colorPrimary));
        CustomTabsIntent build = builder.build();
        build.intent.setPackage("com.android.chrome");
        build.launchUrl(this, Uri.parse("https://41.go.qureka.com/"));
    }
    
}