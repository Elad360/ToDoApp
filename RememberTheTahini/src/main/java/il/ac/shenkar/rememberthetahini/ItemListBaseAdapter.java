package il.ac.shenkar.rememberthetahini;

import java.util.ArrayList;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

public class ItemListBaseAdapter extends BaseAdapter
{
    private LayoutInflater l_Inflater;
    private Context m_context;
    private TaskListModel m_taskListModel;

    public ItemListBaseAdapter(Context context)
    {
        m_context = context;
        m_taskListModel = TaskListModel.getInstance(context);
        l_Inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return m_taskListModel.getCount();
    }

    @Override
    public Object getItem(int position)
    {
        return m_taskListModel.getTask(position);
    }

    @Override
    public long getItemId(int position)
    {
        return m_taskListModel.getTask(position).getId();
    }

    @Override
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

        holder.txt_task_name.setText(m_taskListModel.getTask(position).getName());
        return convertView;
    }

    static class ViewHolder
    {
        TextView txt_task_name;
        Button button_task_done;
    }
}

