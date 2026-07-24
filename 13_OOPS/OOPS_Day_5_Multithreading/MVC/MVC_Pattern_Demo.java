public class MVC_Pattern_Demo {
    public static void main(String[] args) {
        Student model = retriveStudentFromDatabase();
        StudentDetails view = new StudentDetails();
        StudentController controller = new StudentController(model, view);

        controller.updateView();
        controller.setStudentName("Cat Noir");
        controller.updateView();
    }
    static Student retriveStudentFromDatabase(){
        Student student = new Student();
        student.setName("Adrien");
        student.setRollNo("1");
        return student;
    }
}
