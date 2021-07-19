package top.retarders.inertia.configuration.template;

import com.hubspot.jinjava.Jinjava;
import java.io.File;
import java.util.Map;

public class Template {

  public static Jinjava jinjava = new Jinjava();

  public String path;
  public File file;

  public Template(String path, File file) {
    this.path = path;
    this.file = file;

    // read file into a string (and no! this doesn't update unless the plugin is reloaded)
  }

  /**
   * Renders a template and returns it. In case the template has multiple lines,
   * a \n is placed between them.
   *
   * @param model the model
   * @return the rendered model
   * @see <a href="https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93controller">MVC Pattern</a>
   */
  public String render(Map<String, Object> model) {
    return null;
  }
}
