package il.ac.shenkar.rememberthetahini;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class ListViewTasksActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);

        ArrayList<TaskDetails> image_details = GetSearchResults();

        final ListView lv1 = (ListView) findViewById(R.id.listV_main);
        lv1.setAdapter(new ItemListBaseAdapter(this, image_details));

        lv1.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = lv1.getItemAtPosition(position);
                TaskDetails obj_taskDetails = (TaskDetails)o;
                Toast.makeText(ListViewTasksActivity.this, "You have chosen : " + " " + obj_taskDetails.getName(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void addTask(View view)
    {
        Intent intent = new Intent(this, CreateTaskActivity.class);
        startActivity(intent);
    }

    private ArrayList<TaskDetails> GetSearchResults(){
        ArrayList<TaskDetails> results = new ArrayList<TaskDetails>();

        TaskDetails item_details;
        for (int i = 1; i < 20; i++)
        {
            item_details = new TaskDetails();
            item_details.setName("Task" + i);
            results.add(item_details);
        }

        return results;
    }
}