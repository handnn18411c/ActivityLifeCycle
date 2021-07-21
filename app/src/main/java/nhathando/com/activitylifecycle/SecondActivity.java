package nhathando.com.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView tvMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tvMessage = findViewById(R.id.tvMessage);
        receiveData();
    }

    private void receiveData() {
        Bundle bundle = getIntent().getBundleExtra("EXTRA");
        String message = bundle.getString("MESSAGE");
        tvMessage.setText(message);
    }
}