package il.ac.shenkar.rememberthetahini;

import java.util.ArrayList;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

public class ItemListBaseAdapter extends BaseAdapter {
    private static ArrayList<TaskDetails> taskDetailsArrayList;

    private LayoutInflater l_Inflater;

    public ItemListBaseAdapter(Context context, ArrayList<TaskDetails> results) {
        taskDetailsArrayList = results;
        l_Inflater = LayoutInflater.from(context);
    }

    public int getCount() {
        return taskDetailsArrayList.size();
    }

    public Object getItem(int position) {
        return taskDetailsArrayList.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null)
        {
            convertView = l_Inflater.inflate(R.layout.item_details_view, null);
            holder = new ViewHolder();
            holder.txt_task_name = (TextView) convertView.findViewById(R.id.task_name);
            holder.button_task_done = (Button) convertView.findViewById(R.id.b_done);

            convertView.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.txt_task_name.setText(taskDetailsArrayList.get(position).getName());
        return convertView;
    }

    static class ViewHolder
    {
        TextView txt_task_name;
        Button button_task_done;
    }
}

