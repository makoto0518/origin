package jp.ac.gifu_u.info.kato0518.myapplication;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.List;

import android.Manifest;
import android.content.pm.PackageManager;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.os.Build;




public class MainActivity extends AppCompatActivity {

    private SensorManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // ★リクエスト前に呼ぶ！
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // カメラのパーミッションがなければ要求
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CAMERA}, 0);
            return;
        }
//        setContentView(new MyView(this));
        setContentView(R.layout.activity_main);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_main);
//        Button b = (Button) findViewById(R.id.button);
//        b.setOnClickListener(this);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
//        manager = (SensorManager) getSystemService(SENSOR_SERVICE);
//        preview = findViewById(R.id.preview)

        // 仮想端末なら activity_main.xml を使う（カメラなし）
        if (Build.FINGERPRINT.contains("generic")) {
            Toast.makeText(this, "仮想端末ではカメラは使えません", Toast.LENGTH_LONG).show();
            setContentView(R.layout.activity_main);
        } else {
            // 実機なら CameraView を表示
            CameraView camview = new CameraView(this);
            setContentView(camview);
        }
    }


//    private void setCaputure() {
//        ProcessCameraProvider.getInstance(this).addListener(new Runnable() {
//            @Override
//            public void run {
//                try {
//                    Preview p = new Preview.Builder().build();
//                    p.setSurfaceProvider(preview.getSurfaceProvider());
//                    ProcessCameraProvider provider = ProcessCameraProvider.getInstance(getApplication());
//                    provider.unbindAll();
//                    privider.bindToLifecycle(MainActivity.this, CameraSelector.DEFAULT_BACK_CAMERA);
//                } catch (Exception e) {
//
//                }
//            }, ContextCompat.getMainExecutor(this);
//        }
//    }


//    @Override
////    protected void onResume() {
////        super.onResume();
////        List<Sensor> sensors = manager.getSensorList(Sensor.TYPE_LIGHT);
////        if (sensors.size() != 0) {
////            Sensor sensor = sensors.get(0);
////            manager.registerListener(
////                    (SensorEventListener) this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
////        }
////    }

//    @Override
//    protected void onPause() {
//        super.onPause();
//        manager.unregisterListener(this);
//    }



//    @Override
//    public void onAccuracyChanged(Sensor argO, int arg1) {
//    }

//    @Override
//    public void onSensorChanged(SensorEvent argO) {
//        if (argO.sensor.getType() == Sensor.TYPE_LIGHT) {
//            float intensity = argO.values[0];
//            String str = Float.toString(intensity) + "ルクス";
//            TextView textview = (TextView) findViewById(R.id.status_text);
//            textview.setText(str);
//        }
//    }

//    @Override
//    public void onClick(View v) {
//        Toast.makeText(this, "Finished", Toast.LENGTH_SHORT).show();
////        showToast("アプリを終了しました");
//        finish();
//    }
}