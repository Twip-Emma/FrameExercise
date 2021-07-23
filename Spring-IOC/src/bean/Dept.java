package bean;

public class Dept {
    private String deptName;

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public void show(){
        System.out.println(this.deptName);
    }
}
