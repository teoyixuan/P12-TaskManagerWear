package sg.edu.rp.webservices.p12_taskmanagerwear;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.RemoteInput;

public class ReplyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reply);

        CharSequence reply = null;
        Intent intent = getIntent();
        int id = intent.getIntExtra("id", -1);
        Bundle remoteInput = RemoteInput.getResultsFromIntent(intent);
        if (remoteInput != null){
            reply = remoteInput.getCharSequence("status");
        }

        if (reply != null){
            Log.d("asdsdsd", "onCreate: " + reply);
            if(reply == "Completed" ){
                // Toast.makeText(ReplyActivity.this, "is completed", Toast.LENGTH_SHORT).show();
                DBHelper db = new DBHelper(ReplyActivity.this);
                db.deleteTask(id);
                db.close();


            }else {
                Toast.makeText(ReplyActivity.this, "You have indicated: " + reply, Toast.LENGTH_SHORT).show();
            }

        }

    }
}