package lnclcgd.fnplaner.mortvatclc;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Objects;

import lnclcgd.fnplaner.mortvatclc.AdHelper.TopOnAdsHelper;
import lnclcgd.fnplaner.mortvatclc.Controller.Stack;
import lnclcgd.fnplaner.mortvatclc.Math.FinanceMath;
import lnclcgd.fnplaner.mortvatclc.Model.DatabaseHelper;

public class AnnualCompoundInterest extends AppCompatActivity {

    TextView mYearGrow, mInterestRate, mCurrentPrinciple, mNumberOfTimesCompounded, mTotal;
    EditText mYearGrowInput, mInterestRateInput, mCurrentPrincipleInput, mNumberOfTimesCompoundedInput;
    Button mCalculate;
    FinanceMath finance;
    String strInput;
    int numberOfTimesCompoundedCompute;
    int yearsToGrow;
    private DecimalFormat df2;
    private NumberFormat nf1;
    private Currency c1;
    double interestRate;
    double currentPrinciple;
    double total;
    boolean checkValidation;
    Intent intent;
    Button mSave;
    DatabaseHelper mDatabaseHelper;

    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate (savedInstanceState);
        Objects.requireNonNull (getSupportActionBar ( )).hide ();
        setContentView ( R.layout.activity_annual_compound_interest);

        TopOnAdsHelper.LOADBANNERAD(AnnualCompoundInterest.this,findViewById(R.id.banner_container));
        TopOnAdsHelper.LoadNativeAd(AnnualCompoundInterest.this,findViewById(R.id.native_ad_container));

        ImageView q3 = (ImageView) findViewById(R.id.q1);
        q3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openportal1 ();

            }
        });



        mYearGrow = (TextView) findViewById(R.id.yearGrow);
        mInterestRate = (TextView) findViewById(R.id.interestRate);
        mCurrentPrinciple = (TextView) findViewById(R.id.currentPrinciple);
        mNumberOfTimesCompounded = (TextView) findViewById(R.id.numberOfTimesCompounded);
        mYearGrowInput = (EditText) findViewById(R.id.yearGrowInput);
        mInterestRateInput = (EditText) findViewById(R.id.interestRateInput);
        mCurrentPrincipleInput = (EditText) findViewById(R.id.currentPrincipleInput);
        mNumberOfTimesCompoundedInput = (EditText) findViewById(R.id.numberOfTimesCompoundedInput);
        mTotal = (TextView) findViewById(R.id.total);
        df2 = new DecimalFormat(".##");
        mCalculate = (Button) findViewById(R.id.calculate);
        mSave = (Button) findViewById(R.id.save);
        finance = new FinanceMath();
        nf1 = NumberFormat.getInstance();
        nf1.setMaximumFractionDigits(2);
        nf1.setMinimumFractionDigits(2);
        c1 = Currency.getInstance("USD");
        nf1.setCurrency(c1);

        checkValidation = false;
        intent = getIntent();
        mDatabaseHelper = new DatabaseHelper(this);

        mTotal.setText("Total: ₹0.00");
        Context context = getApplicationContext();
        final Context context1 = this;
        CharSequence text = "Hello toast!";
        int duration = Toast.LENGTH_SHORT;

        if(mYearGrowInput.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }

        mNumberOfTimesCompoundedInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if ((actionId == EditorInfo.IME_ACTION_DONE) || (actionId == EditorInfo.IME_ACTION_SEARCH)) {
                    checkValidation = false;
                    strInput = mNumberOfTimesCompoundedInput.getText().toString();
                    if(isEmpty(strInput)){
                        mNumberOfTimesCompoundedInput.setError("Input must not be empty.");
                        checkValidation = true;
                    } else {
                        numberOfTimesCompoundedCompute = Integer.parseInt(strInput);
                    }
                }
                return false;
            }
        });

        if(intent.getIntExtra("classLoaded",9999) == 1){
            unpackSavedData();
        }

        mCalculate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                checkValidation = false;
                strInput = mYearGrowInput.getText().toString();
                if(isEmpty(strInput)) {
                    mYearGrowInput.setError("Input must not be empty.");
                    checkValidation = true;
                } else {
                    yearsToGrow = Integer.parseInt(strInput);
                }
                strInput = mInterestRateInput.getText().toString();
                if(isEmpty(strInput)) {
                    mInterestRateInput.setError("Input must not be empty.");
                    checkValidation = true;
                } else {
                    interestRate = Double.parseDouble(strInput);
                    interestRate = interestRate * .01;
                }
                strInput = mCurrentPrincipleInput.getText().toString();
                if(isEmpty(strInput)){
                    mCurrentPrincipleInput.setError("Input must not be empty.");
                    checkValidation = true;
                } else {
                    currentPrinciple = Double.parseDouble(strInput);
                }
                strInput = mNumberOfTimesCompoundedInput.getText().toString();
                if(isEmpty(mNumberOfTimesCompoundedInput.getText().toString())){
                    mNumberOfTimesCompoundedInput.setError("Input must not be empty.");
                    checkValidation = true;
                } else {
                    numberOfTimesCompoundedCompute = Integer.parseInt(strInput);
                }

                //strInput = mNumberOfTimesCompoundedInput.getText().toString();
                if(checkValidation != true) {
                    total = finance.annualCompoundInterest(currentPrinciple, interestRate, yearsToGrow, numberOfTimesCompoundedCompute);
                    Log.d("Test", "Total amount: " + df2.format(total));
                    String totalDisplay = "Total: " + "₹" + nf1.format(total);
                    mTotal.setText(totalDisplay);
                }

            }});
// add button listener
        mSave.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                // get prompts.xml view
                LayoutInflater li = LayoutInflater.from(context1);
                View promptsView = li.inflate(R.layout.custom, null);

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context1);

                // set prompts.xml to alertdialog builder
                alertDialogBuilder.setView(promptsView);

                final EditText userInput = (EditText) promptsView
                        .findViewById(R.id.editTextDialogUserInput);

                // set dialog message
                alertDialogBuilder
                        .setCancelable(true)
                        .setPositiveButton("OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,int id) {

                                        Stack newStack = new Stack();
                                        //Copy stack from previous activity to the next.
                                        int[] stackArr = intent.getIntArrayExtra("intArr");
                                        newStack.setStackArr(stackArr);
                                        int top = intent.getIntExtra("top",9999);
                                        newStack.setTop(top);
                                        newStack.push(4);

                                        newStack.printAll();

                                        String fileName = userInput.getText().toString();

                                        if (userInput.length() != 0) {
                                            AddData(fileName, yearsToGrow, interestRate, currentPrinciple, numberOfTimesCompoundedCompute);
                                            userInput.setText("");

                                            //View list of data
                                            Intent intent = new Intent(AnnualCompoundInterest.this, ListDataActivity.class);
                                            intent.putExtra("type", 4);
                                            intent.putExtra("top", newStack.getTop());
                                            intent.putExtra("intArr", newStack.getStackArr());
                                            startActivity(intent);
                                            finish();
                                        } else {
                                            toastMessage("You must put something in the text field!");
                                        }

                                        //mResult.setText(test);
                                    }
                                })
                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,int id) {
                                        dialog.cancel();
                                    }
                                });

                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();

            }
        });

    }

    public void openportal1() {
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        builder.setToolbarColor( ContextCompat.getColor(this, R.color.colorPrimary));
        CustomTabsIntent build = builder.build();
        build.intent.setPackage("com.android.chrome");
        build.launchUrl(this, Uri.parse("https://41.go.qureka.com/"));
    }

    @Override
    public void onBackPressed(){
        Stack newStack = new Stack();

        int formulaType = intent.getIntExtra("type", 9999);
        int[] stackArr = intent.getIntArrayExtra("intArr");
        newStack.setStackArr(stackArr);
        int top = intent.getIntExtra("top",9999);
        newStack.setTop(top);
        newStack.pop();

        Intent nextIntent = new Intent(AnnualCompoundInterest.this, Emicalc.class);
        nextIntent.putExtra("type", formulaType);
        nextIntent.putExtra("intArr",stackArr);
        nextIntent.putExtra("top",newStack.getTop());
        startActivity(nextIntent);
        finish();
    }

    /*Years to grow, interest rate, current principle, number of times compounded annually*/
    public void AddData(String fileName,int yearsToGrow, double interestRate,
                        double currentPrinciple, int numberOfTimesCompoundedCompute) {

        boolean insertData = mDatabaseHelper.addData(fileName, yearsToGrow, interestRate,
                currentPrinciple, numberOfTimesCompoundedCompute,"AnnualCompoundInterest");

        if (insertData) {
            toastMessage("Data Successfully Inserted!");
        } else {
            toastMessage("Something went wrong");
        }
    }

    public void unpackSavedData()
    {
        int listPosition = intent.getIntExtra("listPosition", 9999);
        String interestTable = intent.getStringExtra("interest_table");

        int yearsToGrow = intent.getIntExtra("years_to_grow",9999);
        mYearGrowInput.setText(String.valueOf(yearsToGrow), TextView.BufferType.EDITABLE);
        double interestRate = intent.getDoubleExtra("interest_rate",9999);
        mInterestRateInput.setText(String.valueOf(interestRate*100),TextView.BufferType.EDITABLE);
        double currentPrinciple = intent.getDoubleExtra("current_principle",9999);
        mCurrentPrincipleInput.setText(String.valueOf(currentPrinciple),TextView.BufferType.EDITABLE);
        int numOfTimeCompAnnually = intent.getIntExtra("NumOfTimeCompAnnually",9999);
        mNumberOfTimesCompoundedInput.setText(String.valueOf(numOfTimeCompAnnually),TextView.BufferType.EDITABLE);

        total = finance.annualCompoundInterest(currentPrinciple, interestRate, yearsToGrow, numOfTimeCompAnnually);
        String totalDisplay = "Total: " + "₹" + nf1.format(total);
        mTotal.setText(totalDisplay);
    }

    /**
     * customizable toast
     * @param message
     */
    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }

    public boolean isEmpty(String strInput){

        if(strInput.isEmpty() || (0 == strInput.compareTo(" "))) {
            return true;
        } else {
            return false;
        }

    }
}