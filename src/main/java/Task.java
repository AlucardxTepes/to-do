import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alucard on 04-Oct-16.
 */
public class Task {
  private String mDescription;
  private boolean mCompleted;
  private LocalDateTime mCreatedAt;
  private static List<Task> instances = new ArrayList<>();
  private int mId;

  public Task(String description) {
    mDescription = description;
    mCompleted = false;
    mCreatedAt = LocalDateTime.now();
    instances.add(this);
    mId = instances.size();
  }

  public String getDescription() {
    return mDescription;
  }

  public void setDescription(String description) {
    mDescription = description;
  }

  public boolean isCompleted() {
    return mCompleted;
  }

  public LocalDateTime getCreatedAt() {
    return mCreatedAt;
  }

  public static List<Task> all(){
    return instances;
  }
  public static void clear() {
    instances.clear();
  }

  public int getId() {
    return mId;
  }

  public static Task find(int id) {
    return instances.get(id - 1);
  }
}
