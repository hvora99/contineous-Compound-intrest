package lnclcgd.fnplaner.mortvatclc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Objects;

import lnclcgd.fnplaner.mortvatclc.AdHelper.TopOnAdsHelper;

public class LoanDescription extends AppCompatActivity {

    String description,title;
    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate (savedInstanceState);
        Objects.requireNonNull ( getSupportActionBar ( ) ).hide ();
        setContentView ( R.layout.activity_loan_description);

        TopOnAdsHelper.LOADBANNERAD(LoanDescription.this,findViewById(R.id.banner_container));


        TextView tvTitleLabel = (TextView)findViewById(R.id.loanname);
        TextView tvDescLabel = (TextView)findViewById(R.id.loandetail);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {

            title = extras.getString("province");
            tvTitleLabel.setText(title);

            description = extras.getString("provincedesclabel");
            tvDescLabel.setText(description);

        }

    }
}