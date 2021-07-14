package bean;

public class Emp {
    private String empName;
    private String gender;
    //所属部门
    private Dept dept;

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public void show(){
        System.out.println(this.empName + "::" + this.gender);
        this.dept.show();
    }
}
