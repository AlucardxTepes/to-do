import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.staticFileLocation;

/**
 * Created by Alucard on 04-Oct-16.
 */
public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (req, res) -> {
      Map<String, Object> model = new HashMap<>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/tasks/new", (request, response) ->{
      Map<String, Object> model = new HashMap<>();
      model.put("template", "templates/task-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/tasks", (req, res) -> {
      Map<String, Object> model = new HashMap<>();
      model.put("tasks", Task.all());
      model.put("template", "templates/tasks.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/tasks", (req, res) -> {
      Map<String, Object> model = new HashMap<>();
      String description = req.queryParams("description");
      Task newTask = new Task(description);
      model.put("template", "templates/success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/tasks/:id", (req, res) ->{
      Map<String, Object> model = new HashMap<>();
      Task task = Task.find(Integer.parseInt(req.params(":id")));
      model.put("task", task);
      model.put("template", "templates/task.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    // Categories

    get("/categories/new", (req, res) -> {
      Map<String, Object> model = new HashMap<>();
      model.put("template", "templates/category-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/categories", (req, res) -> {
      Map<String, Object> model = new HashMap<>();
      String name = req.queryParams("name");
      Category newCategory = new Category(name);
      model.put("template", "templates/category-success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/categories", (req, res) -> {
      Map<String, Object> model = new HashMap<>();
      model.put("categories", Category.all());
      model.put("template", "templates/categories.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/categories/:id", (req, res) -> {
      Map<String, Object> model = new HashMap<>();
      Category category = Category.find(Integer.parseInt(req.params("id")));
      model.put("category", category);
      model.put("template", "templates/category.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/categories/:id/tasks/new", (req, res) -> {
      Map<String, Object> model = new HashMap<>();
      Category category = Category.find(Integer.parseInt(req.params("id")));
      model.put("category", category);
      model.put("template", "templates/category-tasks-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/categories/:id/tasks", (req, res) -> {
      Map<String, Object> model = new HashMap<>();
      Category category = Category.find(Integer.parseInt(req.queryParams("categoryId")));
      String description = req.queryParams("description");
      Task newTask = new Task(description);
      model.put("category", category);
      model.put("template", "templates/category-tasks-success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
