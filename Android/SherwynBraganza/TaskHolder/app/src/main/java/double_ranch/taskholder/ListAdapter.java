package double_ranch.taskholder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 7408588 on 6/18/2017.
 */

public class ListAdapter extends BaseAdapter {

    private Context mContext;

    public ListAdapter(Context mContext, List<TaskLayout> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    private List<TaskLayout> mList;


    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = View.inflate(mContext,R.layout.list_layout,null);
        TextView tvName = (TextView)v.findViewById(R.id.name);
        tvName.setText(mList.get(position).getName());

        v.setTag(mList.get(position).getId());

        return v;
    }
}
