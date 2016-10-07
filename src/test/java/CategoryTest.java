import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Alucard on 07-Oct-16.
 */
public class CategoryTest {

  @Test
  public void category_instantiatesCorrectly_true() {
    Category testCategory = new Category("Home");
    assertEquals(true, testCategory instanceof Category);
  }

  @Test
  public void getName_categoryInstantiatesWithName_Home() {
    Category testCategory = new Category("Home");
    assertEquals("Home", testCategory.getName());
  }

  @Test
  public void all_returnsAllInstancesOfCategory_true() {
    Category category1 = new Category("1");
    Category category2 = new Category("2");
    assertTrue(Category.all().contains(category1));
    assertTrue(Category.all().contains(category2));
  }

  @Test
  public void clear_emptiesAllCategoriesFromList_0() {
    Category testCategory = new Category("test");
    Category.clear();
    assertEquals(0, Category.all().size());
  }

  @Test
  public void getId_categoriesInstantiateWithAnId_1() {
    Category testCategory = new Category("test");
    assertEquals(1, testCategory.getId());
  }

  @Test
  public void find_returnsCategoryWithSameId_secondCategory() {
    Category.clear();
    Category firstCategory = new Category("1");
    Category secondCategory = new Category("2");
    assertEquals(Category.find(secondCategory.getId()), secondCategory);
  }

  @Test
  public void getTasks_initiallyReturnsEmptyList_ArrayList() {
    Category.clear();
    Category testCategory = new Category("Home");
    assertEquals(0, testCategory.getTasks().size());
  }

  @Test
  public void addTask_addsTaskToList_true() {
    Category testCategory = new Category("Home");
    Task testTask = new Task("test task");
    testCategory.addTask(testTask);
    assertTrue(testCategory.getTasks().contains(testTask));
  }

}
