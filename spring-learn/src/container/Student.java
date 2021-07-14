package container;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Student {
    private String name;
    private String[] message;
    private List<String> read;
    private Map<String, String> info;
    private Set<String> classes;

    public void setName(String name) {
        this.name = name;
    }

    public void setMessage(String[] message) {
        this.message = message;
    }

    public void setRead(List<String> read) {
        this.read = read;
    }

    public void setInfo(Map<String, String> info) {
        this.info = info;
    }

    public void setClasses(Set<String> classes) {
        this.classes = classes;
    }

    public String show() {
        return "Student{" +
                "name='" + name + '\'' +
                ", message=" + Arrays.toString(message) +
                ", read=" + read +
                ", info=" + info +
                ", classes=" + classes +
                '}';
    }
}
