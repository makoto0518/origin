package jp.ac.gifu_u.info.kato0518.myapplication;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyView(this));
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_main);
//        Button b = (Button) findViewById(R.id.button);
//        b.setOnClickListener(this);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
    }

//    @Override
//    public void onClick(View v) {
//        Toast.makeText(this, "Finished", Toast.LENGTH_SHORT).show();
////        showToast("アプリを終了しました");
//        finish();
//    }
}