package com.example.android.discoveringcolombia;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class SummaryTest extends AppCompatActivity {
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent launchSummary = getIntent();
        String userName = launchSummary.getStringExtra("Name");
        int score = launchSummary.getIntExtra("Score", 0);
        int totalQ = launchSummary.getIntExtra("Total Question", 0);
        setContentView(R.layout.activity_summary);
        displayMessage(userName, score, totalQ);
    }

    /** This method is called from onCreate
     * @param userName input from MainActivity
     * @param score from ColombiaTest
     * @param totalQ is the total number of question from ColombiaTest
 */

    public void displayMessage(String userName, int score, int totalQ) {
        TextView printMessage = findViewById(R.id.message);
        message = getString(R.string.congratz) + getString(R.string.score_text) + score + getString(R.string.quant)  + totalQ  + getString(R.string.correct);
        printMessage.setText(message);


    }


    /* This method is called when the Send Email button is clicked
     */
    public void sendEmail(View view) {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:")); // only email apps should handle this
            intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.app_name) );
            intent.putExtra(Intent.EXTRA_TEXT, message);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}




