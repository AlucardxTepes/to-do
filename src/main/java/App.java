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
      model.put("template", "template/task-form.vtl");
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
      model.put("temeplate", "templates/success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
