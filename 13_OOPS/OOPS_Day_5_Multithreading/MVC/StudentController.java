public class StudentController {
    Student model;
    StudentDetails view;
    
    public StudentController(Student model, StudentDetails view){
        this.model=model;
        this.view=view;
    }

    public String getStudentName(){
        return model.name;
    }
    public String getStudentRollNo(){
        return model.rollNo;
    }
    public void setStudentName(String name){
        model.name=name;
    }
    public void setStudentRollNo(String rollNo){
        model.rollNo=rollNo;
    }

    public void updateView(){
        view.printDetails(model.getName(), model.getRollNo());
    }
}
