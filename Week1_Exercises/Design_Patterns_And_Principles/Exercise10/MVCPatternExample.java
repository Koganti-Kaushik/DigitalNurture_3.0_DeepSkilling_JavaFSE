package Exercise10;

public class MVCPatternExample {
    static class Student {
        private String studentId;
        private String studentName;
        private String studentGrade;

        public Student(String studentId, String studentName, String studentGrade) {
            this.studentId = studentId;
            this.studentName = studentName;
            this.studentGrade = studentGrade;
        }

        public String getStudentId() {
            return studentId;
        }

        public void setStudentId(String studentId) {
            this.studentId = studentId;
        }

        public String getStudentName() {
            return studentName;
        }

        public void setStudentName(String studentName) {
            this.studentName = studentName;
        }

        public String getStudentGrade() {
            return studentGrade;
        }

        public void setStudentGrade(String studentGrade) {
            this.studentGrade = studentGrade;
        }
    }

    static class StudentView {
        public void displayStudentDetails(String name, String id, String grade) {
            System.out.printf("Student Information:%nName: %s%nID: %s%nGrade: %s%n", name, id, grade);
        }
    }

    static class StudentController {
        private Student model;
        private StudentView view;

        public StudentController(Student model, StudentView view) {
            this.model = model;
            this.view = view;
        }

        public void setStudentName(String name) {
            model.setStudentName(name);
        }

        public String getStudentName() {
            return model.getStudentName();
        }

        public void setStudentId(String id) {
            model.setStudentId(id);
        }

        public String getStudentId() {
            return model.getStudentId();
        }

        public void setStudentGrade(String grade) {
            model.setStudentGrade(grade);
        }

        public String getStudentGrade() {
            return model.getStudentGrade();
        }

        public void updateView() {
            view.displayStudentDetails(model.getStudentName(), model.getStudentId(), model.getStudentGrade());
        }
    }

    public static void main(String[] args) {
        Student student = new Student("101", "Ravi Shankar", "A");
        StudentView view = new StudentView();
        StudentController controller = new StudentController(student, view);

        controller.updateView();
        controller.setStudentName("Anil Kumar");
        controller.setStudentGrade("B");
        controller.updateView();
    }
}
