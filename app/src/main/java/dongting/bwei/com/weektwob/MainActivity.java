package dongting.bwei.com.weektwob;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity{

    private RecyclerView recyclerView;
    private List<Bean> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        //设置布局管理器
        LinearLayoutManager linearLayoutManager =  new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        list = new ArrayList<>();

        initData();

        final MyAdapter adapter =new MyAdapter(this,list);
        recyclerView.setAdapter(adapter);

        recyclerView.addItemDecoration(
                new HorizontalDividerItemDecoration.Builder(this)
                        .color(Color.RED)
//                        .sizeResId(R.dimen.divider)
//                        .marginResId(R.dimen.leftmargin, R.dimen.rightmargin)
                        .build());

        // 为 item add remove 时增加动画
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        adapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClickListener(int position, View view) {
                list.remove(position);
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "条目删除成功", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void jump() {

                startActivity(new Intent(MainActivity.this,SecondActivity.class));
            }
        });
    }

    private void initData() {
        for (int i=0;i<5;i++){
            list.add(new Bean("旅行","所谓旅行就是从一个自己呆腻了的地方到一个别人呆腻了的地方"));
            list.add(new Bean("学习","所谓学习就是把别人的思想变成自己的思想的一个过程"));
            list.add(new Bean("生活","所谓生活就是努力实现梦想"));
            list.add(new Bean("梦想","所谓梦想要么是幻想，要么是奇迹"));
        }
    }
}
