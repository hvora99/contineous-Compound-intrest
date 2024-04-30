package lnclcgd.fnplaner.mortvatclc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Objects;

import lnclcgd.fnplaner.mortvatclc.AdHelper.TopOnAdsHelper;

public class details extends AppCompatActivity {

    public static String Desc = "desc";
    public static String Title = "title";
    private int position;

    public ImageView ivBack;
    public  LinearLayout toolBar;
    public  TextView tvDetails;
    public  ImageView tvNext;
    public  TextView tvTitle;

    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate (savedInstanceState);
        Objects.requireNonNull ( getSupportActionBar ( ) ).hide ();
        setContentView ( R.layout.activity_details);

        TopOnAdsHelper.LOADBANNERAD(details.this,findViewById(R.id.banner_container));


        ivBack = findViewById(R.id.ivBack);
        toolBar = findViewById(R.id.toolBar);
        tvDetails = findViewById(R.id.tvDetails);
        tvNext = findViewById(R.id.tvNext);
        tvTitle = findViewById(R.id.tvTitle);

        Intent intent = getIntent();
        this.position = getIntent().getIntExtra("pos", 0);
        if (intent != null) {
            ((TextView) findViewById(R.id.tvTitle)).setText(intent.getStringExtra(Title));
            ((TextView) findViewById(R.id.tvDetails)).setText(intent.getStringExtra(Desc));
        }

    }
}