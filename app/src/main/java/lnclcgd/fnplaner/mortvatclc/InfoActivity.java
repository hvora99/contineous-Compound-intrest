package lnclcgd.fnplaner.mortvatclc;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import lnclcgd.fnplaner.mortvatclc.AdHelper.TopOnAdsHelper;

public class InfoActivity extends AppCompatActivity {

    public boolean isEng = false;
    public boolean isHindi = false;

    TabLayout tabLayout;
    TextView txtDesc;
    TextView txtTitle;
    String txten = "";
    String txthn = "";
    String txttitle = "";
    public LinearLayout top;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_info);

        TopOnAdsHelper.LOADBANNERAD(InfoActivity.this,findViewById(R.id.banner_container));

        top = findViewById(R.id.top);

        this.tabLayout = (TabLayout) findViewById(R.id.tabs);
        this.txtDesc = (TextView) findViewById(R.id.txt_desc);
        this.txtTitle = (TextView) findViewById(R.id.txt_title);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.txthn = extras.getString("txthn", "");
            this.txten = extras.getString("txten", "");
            this.txttitle = extras.getString("title", "");
        }

        this.txtTitle.setText(this.txttitle);
        this.txtDesc.setText(this.txthn);
        TabLayout tabLayout2 = this.tabLayout;
        tabLayout2.addTab(tabLayout2.newTab().setText((CharSequence) "Hindi"));
        TabLayout tabLayout3 = this.tabLayout;
        tabLayout3.addTab(tabLayout3.newTab().setText((CharSequence) "English"));
        this.tabLayout.setTabGravity(0);
        this.tabLayout.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new TabLayout.OnTabSelectedListener() {
            public void onTabReselected(TabLayout.Tab tab) {
            }

            public void onTabUnselected(TabLayout.Tab tab) {
            }

            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                if (position == 0) {
                    boolean unused = InfoActivity.this.isHindi = true;
                    InfoActivity.this.txtDesc.setText(InfoActivity.this.txthn);
                } else if (position == 1) {
                    boolean unused2 = InfoActivity.this.isEng = true;
                    InfoActivity.this.txtDesc.setText(InfoActivity.this.txten);
                }
            }
        });

         ImageView ivBack = findViewById(R.id.iv_back);
         ivBack.setOnClickListener (new View.OnClickListener ( ) {
             @Override
             public void onClick ( View view ) {
                 InfoActivity.this.onBackPressed();

             }
         });

    }
}