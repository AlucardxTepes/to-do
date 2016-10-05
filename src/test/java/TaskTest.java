import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

/**
 * Created by Alucard on 04-Oct-16.
 */
public class TaskTest {

  @Test
  public void Task_instantiatesCorrectly_true() {
    Task myTask = new Task("mow the lawn");
    assertEquals(true, myTask instanceof Task);
  }

  @Test
  public void Task_instantiatesWithDescription_String(){
    Task myTask = new Task("Mow the lawn");
    assertEquals("Mow the lawn", myTask.getDescription());
  }

  @Test
  public void Task_isFalseAfterInstantiation_false() {
    Task myTask = new Task("test");
    assertFalse(myTask.isCompleted());
  }

  @Test
  public void getCreatedAt_instantiatesWithCurrentTime_today() {
    Task myTask = new Task("test");
    assertEquals(LocalDateTime.now().getDayOfWeek(),
            myTask.getCreatedAt().getDayOfWeek());
  }

  @Test
  public void all_returnsAllInstancesOfTask_true() {
    Task firstTask = new Task("test1");
    Task secondTask = new Task("test2");
    assertTrue(Task.all().contains(firstTask));
    assertTrue(Task.all().contains(secondTask));
  }

  @Test
  public void clear_emptiesAllTasksFromArrayList_0() {
    Task myTask = new Task("test");
    Task.clear();
    assertEquals(Task.all().size(), 0);
  }

  @Test
  public void getId_tasksInstantiateWithAnID_1() {
    Task.clear();
    Task myTask = new Task("test");
    assertEquals(1, myTask.getId());
  }

  @Test
  public void find_returnsTaskWithSameId_secondTask() {
    Task firstTask = new Task("test1");
    Task secondTask = new Task("task2");
    assertEquals(Task.find(secondTask.getId()), secondTask);
  }

}
