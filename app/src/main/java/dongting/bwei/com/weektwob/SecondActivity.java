package dongting.bwei.com.weektwob;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 作者:${董婷}
 * 日期:2017/6/17
 * 描述:
 */

public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);


        Toast toast = Toast.makeText(this, "跳转成功", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL| Gravity.CENTER_HORIZONTAL , 0, 0);  //设置显示位置
        TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
        v.setTextColor(Color.BLACK);
        v.setTextSize(15);
        toast.show();
    }


}
