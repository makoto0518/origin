package jp.ac.gifu_u.info.kato0518.myapplication;

//こいつらを追加しないとだめ！
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;
import android.graphics.Rect;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MyView extends View {

    //イベント発生時のx座標,y座標を保存するための動的配列
    private ArrayList array_x, array_y;
    private  ArrayList array_status;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();

        //false, trueは一個前の座標を繋げるか否か(なぞっている最中か、なぞり始める瞬間か)
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: //タッチパネルが押されたとき
            case MotionEvent.ACTION_POINTER_DOWN:
                array_x.add(new Integer(x)); //new Integer(x)でなくて単にxでおいい
                array_y.add(new Integer(y));
                array_status.add(new Boolean(false));
                invalidate();
                break;
            case MotionEvent.ACTION_MOVE:
                array_x.add(x);
                array_y.add(y);
                array_status.add(new Boolean(true));
                invalidate();
                break;
//            default:
//                break;
        }
        return true;
    }


    //コンストラクタ(ここではこの引数のものを追加)
    public MyView(Context context) {
        super(context);

        //初期化
        array_x = new ArrayList();
        array_y = new ArrayList();
        array_status = new ArrayList();

    }



    //ビューの描画を行うときに呼ばれるメソッド
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint p = new Paint();
        p.setStyle(Paint.Style.FILL);
        p.setColor(Color.BLACK);
        canvas.drawRect(new Rect(0, 0,
                canvas.getWidth(), canvas.getHeight()), p);

        p = new Paint();
        p.setStyle(Paint.Style.STROKE);
        p.setColor(Color.YELLOW);
        p.setStrokeWidth(10f); //線の太さ調整

        for (int i = 1; i < array_status.size(); i++) {
            if((Boolean) array_status.get(i)) {
                int x1 = (Integer) array_x.get(i-1);
                int x2 = (Integer) array_x.get(i);
                int y1 = (Integer) array_y.get(i-1);
                int y2 = (Integer) array_y.get(i);

                canvas.drawLine(x1, y1, x2, y2, p);
            }
        }

        //どのように描画するかを指定する Paint オブジェクトを作成
//        Paint paint = new Paint();

//        paint.setColor(Color.BLUE); //背景色を青に指定

        // (10,20)から(30,40)へ青線を描画
//        canvas.drawLine(10, 20, 80, 95,paint);
    }
}
