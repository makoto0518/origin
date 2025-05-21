package jp.ac.gifu_u.info.kato0518.myapplication;

import android.content.Context;
import android.hardware.Camera;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Toast;

public class CameraView extends SurfaceView implements SurfaceHolder.Callback {
    private Camera cam;
    private SurfaceHolder holder;

    public CameraView(Context context) {
        super(context);
        holder = getHolder();
        holder.addCallback(this);
        holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        try {
            cam = Camera.open();
            cam.setPreviewDisplay(holder);
            cam.startPreview();
        } catch (Exception e) {
            Log.e("CameraView", "カメラ起動に失敗: " + e.getMessage());
            Toast.makeText(getContext(), "カメラの初期化に失敗しました", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        // 何もしない
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        if (cam != null) {
            cam.stopPreview();
            cam.release();
            cam = null;
        }
    }
}
