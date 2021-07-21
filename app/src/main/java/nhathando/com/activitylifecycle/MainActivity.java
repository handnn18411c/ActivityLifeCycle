package nhathando.com.activitylifecycle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private int count;

//    Lợi cập nhật tính năng Gallery
    EditText editText;
    TextView tvCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        count = 0;
        if(savedInstanceState != null) {
            count = savedInstanceState.getInt("COUNT");
        }
        addView();
    }

    private void addView() {
        editText = findViewById(R.id.edtMessage);
        tvCount = findViewById(R.id.tvCount);
        tvCount.setText(count + "");
    }

    public void sendDataToSecondActivity(View view) {
//        Count
        count += 1;
        tvCount.setText(count + "");

//        Truyền dữ liệu
        Bundle bundle = new Bundle();
        bundle.putString("MESSAGE", editText.getText().toString());
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra("EXTRA", bundle);
        startActivity(intent, bundle);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("COUNT", count);
    }
}