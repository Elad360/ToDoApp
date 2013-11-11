package il.ac.shenkar.rememberthetahini;

import java.util.ArrayList;

public class TaskListManager
{
    private static TaskListManager instance = null;
    private ArrayList<TaskDetails> m_taskList;

    private TaskListManager()
    {
        m_taskList = new ArrayList<TaskDetails>();

        TaskDetails item_details;
        for (int i = 1; i <= 10; i++)
        {
            item_details = new TaskDetails();
            item_details.setName("TASK " + i + ": DO SOMETHING GOOD");
            m_taskList.add(item_details);
        }

    }

    public static synchronized TaskListManager getInstance()
    {
        if(instance == null)
        {
            instance = new TaskListManager();
        }
        return instance;
    }

    public ArrayList<TaskDetails> getTasks()
    {
        return m_taskList;
    }

    public  void addNewTask(String taskName)
    {
        TaskDetails item_details = new TaskDetails();
        item_details.setName(taskName);
        m_taskList.add(0,item_details);
    }

    public  void removeTask(TaskDetails taskToRemove)
    {
        m_taskList.remove(taskToRemove);
    }
}
