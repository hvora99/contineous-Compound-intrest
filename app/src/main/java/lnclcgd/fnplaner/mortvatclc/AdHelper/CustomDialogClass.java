package lnclcgd.fnplaner.mortvatclc.AdHelper;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Window;

import lnclcgd.fnplaner.mortvatclc.R;


public class CustomDialogClass extends Dialog {

    public CustomDialogClass(Activity a) {
        super(a);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView( R.layout.custom_dialog);
        setCancelable(false);
    }
}
