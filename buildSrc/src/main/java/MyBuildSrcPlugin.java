import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class MyBuildSrcPlugin implements Plugin<Project> {
    @Override
    public void apply(Project project) {
        System.out.println("this is third plugin");
    }
}
