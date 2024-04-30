package lnclcgd.fnplaner.mortvatclc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import java.util.Objects;

import lnclcgd.fnplaner.mortvatclc.AdHelper.TopOnAdsHelper;

public class LoanEpfActivity extends AppCompatActivity {

    public int f46i = 0;

    public  LinearLayout icBikeLoan;
    public  LinearLayout icBusinessLoan;
    public  LinearLayout icCarLoan;
    public  LinearLayout icCreditcard;
    public  LinearLayout icEducationLoan;
    public  LinearLayout icEpfLoan;
    public  LinearLayout icEpfLoan2;
    public  LinearLayout icGoldLoan;
    public  LinearLayout icHomeLoan;
    public  LinearLayout icPersonalLoan;


    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate (savedInstanceState);
        Objects.requireNonNull (getSupportActionBar ( )).hide ();
        setContentView ( R.layout.activity_loan_epf);

        TopOnAdsHelper.LOADBANNERAD(LoanEpfActivity.this,findViewById(R.id.banner_container));


        icPersonalLoan = findViewById(R.id.ic_personal_loan);
        icPersonalLoan.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Intent intent = new Intent(LoanEpfActivity.this, details.class);
                intent.putExtra(details.Title, "1.EPF Service");
                intent.putExtra(details.Desc, getString(R.string.e1));
                intent.putExtra("pos", LoanEpfActivity.this.f46i);
                startActivity(intent);

            }
        });

        icHomeLoan = findViewById(R.id.ic_home_loan);
        icHomeLoan.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Intent intent2 = new Intent(LoanEpfActivity.this, details.class);
                intent2.putExtra(details.Title, "2. KYC Updating");
                intent2.putExtra(details.Desc, getString(R.string.e2));
                intent2.putExtra("pos", LoanEpfActivity.this.f46i);
                startActivity(intent2);

            }
        });
        icEducationLoan=findViewById(R.id.ic_education_loan);
        icEducationLoan.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Intent intent3 = new Intent(LoanEpfActivity.this, details.class);
                intent3.putExtra(details.Title, "3. UMANG");
                intent3.putExtra(details.Desc, getString(R.string.e3));
                intent3.putExtra("pos", LoanEpfActivity.this.f46i);
                startActivity(intent3);
            }
        });

        icCreditcard = findViewById(R.id.ic_Creditcard);
        icCreditcard.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Intent intent4 = new Intent(LoanEpfActivity.this, details.class);
                intent4.putExtra(details.Title, "4. ECR / Returns and Payments");
                intent4.putExtra("pos", LoanEpfActivity.this.f46i);
                intent4.putExtra(details.Desc, getString(R.string.e4));
                startActivity(intent4);
            }
        });

        icBusinessLoan=findViewById(R.id.ic_business_loan);
        icBusinessLoan.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Intent intent5 = new Intent(LoanEpfActivity.this, details.class);
                intent5.putExtra(details.Title, "5. Online Claims account transfer");
                intent5.putExtra("pos", LoanEpfActivity.this.f46i);
                intent5.putExtra(details.Desc, getString(R.string.e5));
                startActivity(intent5);
            }
        });
        icGoldLoan= findViewById(R.id.ic_Gold_Loan);
        icGoldLoan.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Intent intent6 = new Intent(LoanEpfActivity.this, details.class);
                intent6.putExtra(details.Title, "6. E-Passport");
                intent6.putExtra("pos", LoanEpfActivity.this.f46i);
                intent6.putExtra(details.Desc, getString(R.string.e6));
                startActivity(intent6);
            }
        });

        icCarLoan=findViewById(R.id.ic_car_loan);
        icCarLoan.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Intent intent7 = new Intent(LoanEpfActivity.this, details.class);
                intent7.putExtra(details.Title, "7. Sharam suvidha commen ECP");
                intent7.putExtra("pos", LoanEpfActivity.this.f46i);
                intent7.putExtra(details.Desc, getString(R.string.e7));
                startActivity(intent7);
            }
        });
        icBikeLoan=findViewById(R.id.ic_bike_loan);
        icBikeLoan.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Intent intent8 = new Intent(LoanEpfActivity.this, details.class);
                intent8.putExtra(details.Title, "8. Personal Portal");
                intent8.putExtra("pos", LoanEpfActivity.this.f46i);
                intent8.putExtra(details.Desc, getString(R.string.e8));
                startActivity(intent8);
            }
        });
        icEpfLoan=findViewById(R.id.ic_epf_loan);
        icEpfLoan.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Intent intent9 = new Intent(LoanEpfActivity.this, details.class);
                intent9.putExtra(details.Title, "9. international workers portal");
                intent9.putExtra("pos", LoanEpfActivity.this.f46i);
                intent9.putExtra(details.Desc, getString(R.string.e9));
                startActivity(intent9);
            }
        });

        icEpfLoan2 = findViewById(R.id.ic_epf_loan2);
        icEpfLoan2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Intent intent10 = new Intent(LoanEpfActivity.this, details.class);
                intent10.putExtra(details.Title, "10. EKYC Portal");
                intent10.putExtra("pos", LoanEpfActivity.this.f46i);
                intent10.putExtra(details.Desc, getString(R.string.e10));
                startActivity(intent10);
            }
        });
    }
}