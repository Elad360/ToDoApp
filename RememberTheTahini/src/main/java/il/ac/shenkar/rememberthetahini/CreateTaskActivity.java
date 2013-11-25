package il.ac.shenkar.rememberthetahini;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class CreateTaskActivity extends Activity
{

    private TaskListModel taskListModel;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_task);
        taskListModel = TaskListModel.getInstance(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void createNewTask(View view)
    {
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String taskName = editText.getText().toString();
        if (taskName != null)
        {
            Intent intent = new Intent(this, ListViewTasksActivity.class);
            taskListModel.addNewTask(taskName);
            startActivity(intent);
        }
    }


}
