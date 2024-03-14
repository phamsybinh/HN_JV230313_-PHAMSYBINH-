import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Department {

    private static Scanner scanner = new Scanner(System.in);


    private static int nextId = 1;
    private int departmentId;
    private String departmentName;

    public Department(String departmentName) {
        this.departmentId = nextId++;
        this.departmentName = departmentName;
    }


    public int getDepartmentId() {
        return departmentId;
    }


    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}

//    private boolean checkCurrentName(String name) {
//        for (Department department : departmentList) {
//            if (department.getDepartmentName().equalsIgnoreCase(name)) {
//                return true;
//            }
//        }
//        return false;
//    }

//    private void setNameWithValidation() {
//        boolean validInput = false;
//        do {
//            System.out.println("Nhap vao ten phong ban: ");
//            String newName = scanner.nextLine();
//            if ((!newName.isEmpty()) ) {
//                validInput = true;
//                departmentName = newName;
//            } else {
//                System.out.println("Ten the loai khong hop le, vui long nhap lai.");
//            }
//        } while (!validInput);
//    }

//    public void input() {
//        setNameWithValidation();
//    }
//
//    public void addDepartment() {
//        Department department = new Department();
//
////        do {
//        try {
//            System.out.println("Them moi phong ban");
//            System.out.println("Ban them may phong ban");
//            int n = Integer.parseInt(scanner.nextLine());
//            for (int i = 0; i < n; i++) {
//                departmentId = departmentId+1;
//                System.out.println("Phong ban thu " + (i + 1));
//                department.input();
//                departmentList.add(department);
//
//            }
//        } catch (Exception e) {
//            System.out.println("Vui long nhap vao so nguyen");
//        }
//
////        } while ()
//
//    }
//    public void showInfo(){
//        for (Department department : departmentList) {
//            int total = 0;
//            for (Employee employee : Employee.getEmployeeList()) {
//                if (employee.getDepartmentId() == department.getDepartmentId()){
//                    total++;
//                }
//            }
//            System.out.printf("Ma phong ban: %d\tTen phong ban: S\tSo luong nhan vien: %d\n",department.getDepartmentId(),department.getDepartmentName(),total);
//        }
//
//    }
//}
