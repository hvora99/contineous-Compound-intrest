package lnclcgd.fnplaner.mortvatclc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import lnclcgd.fnplaner.mortvatclc.AdHelper.TopOnAdsHelper;
import lnclcgd.fnplaner.mortvatclc.Controller.Stack;
import lnclcgd.fnplaner.mortvatclc.Model.DatabaseHelper;

public class EditDataActivity extends AppCompatActivity {

    private static final String TAG = "EditDataActivity";

    private EditText editable_item;
    DatabaseHelper mDatabaseHelper;
    private String selectedName;
    private int selectedID;
    Intent receivedIntent;

    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate (savedInstanceState);
        setContentView ( R.layout.activity_edit_data);

        TopOnAdsHelper.LOADBANNERAD(EditDataActivity.this,findViewById(R.id.banner_container));
        TopOnAdsHelper.LoadNativeAd(EditDataActivity.this,findViewById(R.id.native_ad_container));


        Button btnDelete = (Button) findViewById (R.id.btnDelete);
        editable_item = (EditText) findViewById(R.id.editable_item);
        mDatabaseHelper = new DatabaseHelper(this);
        receivedIntent = getIntent();
        selectedID = receivedIntent.getIntExtra("id",-1); //NOTE: -1 is just the default value

        //now get the name we passed as an extra
        selectedName = receivedIntent.getStringExtra("name");

        //set the text to show the current selected name
        editable_item.setText(selectedName);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDatabaseHelper.deleteName(selectedID,selectedName);
                editable_item.setText("");
                toastMessage("removed from database");
            }
        });
    }

    @Override
    public void onBackPressed() {
        Stack newStack = new Stack();

        int[] stackArr = receivedIntent.getIntArrayExtra("intArr");
        newStack.setStackArr(stackArr);
        int top = receivedIntent.getIntExtra("top",9999);
        newStack.setTop(top);
        newStack.pop();
        int formulaType;
        formulaType = 0;

        Intent intent = new Intent(this, ListDataActivity.class);
        intent.putExtra("type", formulaType);
        intent.putExtra("intArr",stackArr);
        intent.putExtra("top",newStack.getTop());
        startActivity(intent);
        finish();
    }

    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }
}