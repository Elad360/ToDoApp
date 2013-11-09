package il.ac.shenkar.rememberthetahini;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class ListViewTasksActivity extends Activity
{

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);

        final ListView lv1 = (ListView) findViewById(R.id.listV_main);
        lv1.setAdapter(new ItemListBaseAdapter(this, TaskListManager.getInstance().getTasks()));
    }

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
        TaskListManager.getInstance().removeTask(taskToRemove);
        lv.invalidateViews();
    }
}