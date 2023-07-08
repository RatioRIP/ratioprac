package rip.ratio.ratioprac.configuration;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Map;
import org.bukkit.plugin.java.JavaPlugin;
import org.spongepowered.configurate.CommentedConfigurationNode;
import org.spongepowered.configurate.hocon.HoconConfigurationLoader;
import rip.ratio.ratioprac.configuration.template.Template;

public class ConfigurationLoader {

  public static ConfigurationLoader instance;

  private final JavaPlugin plugin;
  private final LinkedHashSet<Template> templates;

  public CommentedConfigurationNode config;

  public ConfigurationLoader(JavaPlugin plugin) {
    instance = this;

    this.plugin = plugin;
    this.templates = new LinkedHashSet<>();
  }

  /**
   * Loads the config, exports it from the resources folder if it doesn't exist.
   */
  public void load() throws IOException {
    // create plugin directory if it doesn't exist
    File dataFolder = this.plugin.getDataFolder();

    if (!dataFolder.exists()) {
      dataFolder.mkdir();
    }

    // create inertia.conf if it doesn't exist
    File configFile = new File(dataFolder, "inertia.conf");

    if (!configFile.exists()) {
      this.plugin.saveResource("inertia.conf", false);
    }

    // load it
    HoconConfigurationLoader loader = HoconConfigurationLoader.builder()
        .file(configFile)
        .build();

    this.config = loader.load();
  }

  /**
   * Loads and returns a template, exports it from the resources folder it if it doesn't exist.
   *
   * @param path the path of the template, that doesn't include the template/ directory nor
   *             the file extension.
   *             <p>
   *             example: sidebar/title
   * @return the template object
   */
  public Template loadTemplate(String path) {
    // remove template://
    path = path.replace("template://", "");

    File file = new File(this.plugin.getDataFolder() + "/templates" + path);

    // if the file doesn't exist, create it
    if (!file.exists()) {
      this.plugin.saveResource("templates/" + path, false);
    }

    return new Template(path, file);
  }

  /**
   * Renders a template, loads it if it doesn't exist.
   *
   * @param path  the path of the template, see {@link this#loadTemplate}'s <code>path</code>
   * @param model the model
   * @return
   * @see <a href="https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93controller">MVC Pattern</a>
   */
  public String renderTemplate(String path, Map<String, Object> model) {
    // first we want to check if the template is in our cache
    Template template = this.templates.stream()
        .filter(t -> t.path.equals(path))
        .findFirst()
        .orElseGet(() -> {
          Template t = this.loadTemplate(path);
          this.templates.add(t);

          return t;
        });

    return template.render(model);
  }
}
