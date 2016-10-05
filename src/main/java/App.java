import java.util.ArrayList;
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
      model.put("tasks", req.session().attribute("tasks"));
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/tasks", (req, res) -> {
      Map<String, Object> model = new HashMap<>();

      ArrayList<Task> tasks = req.session().attribute("tasks");
      if (tasks == null) {
        // create arraylist and save it to session
        tasks = new ArrayList<Task>();
        req.session().attribute("tasks", tasks);
      }

      String description = req.queryParams("description");
      Task newTask = new Task(description);
      tasks.add(newTask);

      model.put("template", "templates/success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
