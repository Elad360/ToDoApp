package il.ac.shenkar.rememberthetahini;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

public class ListViewTasksActivity extends Activity
{
    Context context;
    ItemListBaseAdapter itemListAdapter;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);

        context = this;
        TaskListModel taskListModel = TaskListModel.getInstance(this);

        for (int i = 1; i <= 10; i++)
        {
            taskListModel.addNewTask("TASK " + i + ": DO SOMETHING GOOD");
        }

        final ListView taskList = (ListView) findViewById(R.id.listV_main);
        ItemListBaseAdapter itemListBaseAdapter = new ItemListBaseAdapter(this);
        taskList.setAdapter(itemListBaseAdapter);
    }


//    @Override
//    public void onResume()
//    {
//        super.onResume();
//        itemListAdapter.notifyDataSetChanged();
//    }

    public void addTask(View view)
    {
        Intent intent = new Intent(this, CreateTaskActivity.class);
        startActivity(intent);
    }

    public void removeTask(View view)
    {
        final ListView lv = (ListView) findViewById(R.id.listV_main);
        int position = lv.getPositionForView((View) view.getParent());
        TaskDetails taskToRemove = (TaskDetails) lv.getItemAtPosition(position);
        Toast.makeText(ListViewTasksActivity.this, "You have completed : " + " " + taskToRemove.getName(), Toast.LENGTH_LONG).show();
        TaskListModel.getInstance(context).removeTask(taskToRemove);
        //itemListAdapter.notifyDataSetChanged();
        lv.invalidateViews();
    }
}