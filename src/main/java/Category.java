import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alucard on 07-Oct-16.
 */
public class Category {
  private final String mName;
  private static List<Category> instances = new ArrayList<>();
  private int mId;
  private List<Task> mTasks;

  public Category(String name) {
    mName = name;
    instances.add(this);
    mId = instances.size();
    mTasks = new ArrayList<>();
  }

  public String getName() {
    return mName;
  }

  public static List<Category> all() {
    return instances;
  }

  public static void clear() {
    instances.clear();
  }

  public int getId() {
    return mId;
  }

  public void setId(int id) {
    mId = id;
  }

  public static Category find(int id) {
    return instances.get(id - 1);
  }

  public List<Task> getTasks() {
    return mTasks;
  }

  public void addTask(Task testTask) {
    mTasks.add(testTask);
  }
}
