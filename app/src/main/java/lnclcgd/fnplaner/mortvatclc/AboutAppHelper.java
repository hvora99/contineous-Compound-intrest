package lnclcgd.fnplaner.mortvatclc;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;


final class AboutAppHelper {

    static void rateApp(Context context) {
        String packageName = context.getPackageName();

        try {
            Intent goToMarket = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("market://details?id=" + packageName));
            goToMarket.addFlags(
                    Intent.FLAG_ACTIVITY_NO_HISTORY |
                            Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                            Intent.FLAG_ACTIVITY_MULTIPLE_TASK
            );
            context.startActivity(goToMarket);
        } catch (ActivityNotFoundException e) {
            context.startActivity(
                    new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://play.google.com/store/apps/details?id=" + packageName))
            );
        }
    }



    static void Pricacypolicy_my(Context context)
    {

        try {

            context.startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://edieloangud.blogspot.com/")));
        } catch (ActivityNotFoundException e) {
            context.startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://edieloangud.blogspot.com/")));


        }
    }

    static void share_myapp(Context context)
    {
        String packageName = context.getPackageName();

        Intent intent=new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT,"My application name");
        intent.putExtra(Intent.EXTRA_TEXT,"Get This app \n\n" + "http://play.google.com/store/apps/details?id=" + packageName );
        context.startActivity(Intent.createChooser(intent,"choose one"));

    }


}
