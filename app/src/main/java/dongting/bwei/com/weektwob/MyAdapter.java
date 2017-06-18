package dongting.bwei.com.weektwob;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * 作者:${董婷}
 * 日期:2017/6/18
 * 描述:
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    List<Bean> list ;
    Context context;
   LayoutInflater inflater ;

    public   MyAdapter(Context context,List<Bean> list){
        this.context=context;
        this.list =list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.item,parent,false);

        MyViewHolder viewHolder = new MyViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.tv_title.setText(list.get(position).getTitle());
        holder.tv_content.setText(list.get(position).getContent());

        //点击条目跳转
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.jump();
            }
        });

        //点击删除条目
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClickListener(position,v);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {


        private final TextView tv_title;
        private final TextView tv_content;
        private final ImageView iv;
        private final Button delete;


        public MyViewHolder(View itemView) {
            super(itemView);

            iv = (ImageView) itemView.findViewById(R.id.iv);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            tv_content = (TextView) itemView.findViewById(R.id.tv_content);
            delete = (Button) itemView.findViewById(R.id.delete);
        }
    }

    interface OnItemClickListener {

        void onItemClickListener(int position,View view);
        void jump();
    }

    public OnItemClickListener listener ;

    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }

}
