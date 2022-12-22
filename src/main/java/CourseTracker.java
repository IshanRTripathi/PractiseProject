import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseTracker {
    Map<String, List<String>> courseMapping = new HashMap<>();
    List<String> allCourses = new ArrayList<>();

    volatile int x;
    void initialise(String course, String dependentCourse) {
        if(!courseMapping.containsKey(dependentCourse)){
            courseMapping.put(dependentCourse, new ArrayList<>());
        }
        courseMapping.get(dependentCourse).add(course);
        allCourses.add(course);
    }

    List<String> getPathToCourse() {
        String randomCourse = allCourses.get((int)((Math.random()*73)%allCourses.size()));
        System.out.println("Finding path for course: " + randomCourse);
        List<String> path = new ArrayList<>();

        while(true) {
            String current = randomCourse;
            boolean flag = false;
            path.add(current);
            for(Map.Entry<String, List<String>> entry : courseMapping.entrySet()) {
                if(entry.getValue().contains(current)) {
                    System.out.println("\tCourse: " + current + " is dependent on " + entry.getKey());
                    current = entry.getKey();
                    flag = true;
                    path.add(current);
                }
            }
            if(!flag) {
                break;
            }
        }
        System.out.println(path);
        return path;
    }

    public static void main(String[] args) {
        CourseTracker tracker = new CourseTracker();
        tracker.initialise("X", "A");
        tracker.initialise("Y", "B");
        tracker.initialise("D", "Y");
        tracker.initialise("D", "X");
        tracker.initialise("E", "");


        tracker.getPathToCourse();
        tracker.getPathToCourse();
        tracker.getPathToCourse();
        tracker.getPathToCourse();
    }
}
