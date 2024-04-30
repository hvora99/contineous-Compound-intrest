package lnclcgd.fnplaner.mortvatclc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;

import lnclcgd.fnplaner.mortvatclc.AdHelper.TopOnAdsHelper;

public class CashCounterActivity extends AppCompatActivity {

    int note10 = 0;
    int note100 = 0;
    int note20 = 0;
    int note200 = 0;
    int note2000 = 0;
    int note50 = 0;
    int note500 = 0;

    public ImageView edt10;
    public  ImageView edt100;
    public  ImageView edt20;
    public  ImageView edt200;
    public  ImageView edt2000;
    public  ImageView edt50;
    public  ImageView edt500;
    public TextView edtTotal;
    public  TextView edtTotal10;
    public  TextView edtTotal100;
    public  TextView edtTotal20;
    public  TextView edtTotal200;
    public  TextView edtTotal2000;
    public  TextView edtTotal50;
    public  TextView edtTotal500;
    public  ImageView ivBack;
    public  ImageView ivMinus10;
    public  ImageView ivMinus100;
    public  ImageView ivMinus20;
    public  ImageView ivMinus200;
    public  ImageView ivMinus2000;
    public  ImageView ivMinus50;
    public  ImageView ivMinus500;
    public  ImageView ivPlus10;
    public  ImageView ivPlus100;
    public  ImageView ivPlus20;
    public  ImageView ivPlus200;
    public  ImageView ivPlus2000;
    public  ImageView ivPlus50;
    public  ImageView ivPlus500;

    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate (savedInstanceState);
        Objects.requireNonNull (getSupportActionBar ( )).hide ();
        setContentView ( R.layout.activity_cash_counter);

        TopOnAdsHelper.LOADBANNERAD(CashCounterActivity.this,findViewById(R.id.banner_container));


        edt10 = findViewById(R.id.edt_10);
        edt100 = findViewById(R.id.edt_100);
        edt20 = findViewById(R.id.edt_20);
        edt200 = findViewById(R.id.edt_200);
        edt2000 = findViewById(R.id.edt_2000);
        edt50 = findViewById(R.id.edt_50);
        edt500 = findViewById(R.id.edt_500);
        edtTotal = findViewById(R.id.edt_total);
        edtTotal10 = findViewById(R.id.edt_total_10);
        edtTotal100 = findViewById(R.id.edt_total_100);
        edtTotal20 = findViewById(R.id.edt_total_20);
        edtTotal200 = findViewById(R.id.edt_total_200);
        edtTotal2000 = findViewById(R.id.edt_total_2000);
        edtTotal50 = findViewById(R.id.edt_total_50);
        edtTotal500 = findViewById(R.id.edt_total_500);
        ivBack = findViewById(R.id.ivBack);
        ivMinus10 = findViewById(R.id.iv_minus_10);
        ivMinus100 = findViewById(R.id.iv_minus_100);
        ivMinus20 = findViewById(R.id.iv_minus_20);
        ivMinus200 = findViewById(R.id.iv_minus_200);
        ivMinus2000 = findViewById(R.id.iv_minus_2000);
        ivMinus50 = findViewById(R.id.iv_minus_50);
        ivMinus500 = findViewById(R.id.iv_minus_500);
        ivPlus10 = findViewById(R.id.iv_plus_10);
        ivPlus100 = findViewById(R.id.iv_plus_100);
        ivPlus20 = findViewById(R.id.iv_plus_20);
        ivPlus200 = findViewById(R.id.iv_plus_200);
        ivPlus2000 = findViewById(R.id.iv_plus_2000);
        ivPlus50 = findViewById(R.id.iv_plus_50);
        ivPlus500 = findViewById(R.id.iv_plus_500);

        ivPlus2000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                note2000 += 2000;
                setData();
            }
        });
        ivPlus500.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                note500 += 500;
                setData();
            }
        });
        ivPlus200.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                note200 += ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION;
                setData();
            }
        });
        ivPlus100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                note100 += 100;
                setData();
            }
        });
        ivPlus50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                note50 += 50;
                setData();
            }
        });
        ivPlus20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                note20 += 20;
                setData();
            }
        });
        ivPlus10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                note10 += 10;
                setData();
            }
        });
        ivMinus2000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = note2000;
                if (i != 0) {
                    note2000 = i - 2000;
                    setData();
                }
            }
        });
        ivMinus500.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = note500;
                if (i != 0) {
                    note500 = i - 500;
                    setData();
                }
            }
        });
        ivMinus200.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = note200;
                if (i != 0) {
                    note200 = i - 200;
                    setData();
                }
            }
        });
        ivMinus100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = note100;
                if (i != 0) {
                    note100 = i - 100;
                    setData();
                }
            }
        });
        ivMinus50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = note50;
                if (i != 0) {
                    note50 = i - 50;
                    setData();
                }
            }
        });
        ivMinus20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = note20;
                if (i != 0) {
                    note20 = i - 20;
                    setData();
                }
            }
        });
        ivMinus10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = note10;
                if (i != 0) {
                    note10 = i - 10;
                    setData();
                }
            }
        });
     }



    private void setData() {
        edtTotal2000.setText(String.valueOf(this.note2000));
        edtTotal500.setText(String.valueOf(this.note500));
        edtTotal200.setText(String.valueOf(this.note200));
        edtTotal100.setText(String.valueOf(this.note100));
        edtTotal50.setText(String.valueOf(this.note50));
        edtTotal20.setText(String.valueOf(this.note20));
        edtTotal10.setText(String.valueOf(this.note10));
        edtTotal.setText(String.valueOf(this.note2000 + this.note500 + this.note200 + this.note100 + this.note50 + this.note20 + this.note10));
    }

}