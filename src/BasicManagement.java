import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class BasicManagement {
    private static List<Department> departments = new ArrayList<>();
    private static List<Employee> employees = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        mainService(scanner);

    }

    private static void mainService(Scanner scanner) {
        do {
//            try {
            System.out.println("*********************************MENU*******************************\n" +
                    "1. Quản lý phòng ban\n" +
                    "2. Quản lý nhân viên\n" +
                    "3. Thoát chương trình");
            System.out.println("Nhap vao tu 1-3 de chon phuong thuc");
            int n = Integer.parseInt(scanner.nextLine());
            switch (n) {
                case 1:
                    departmentService(scanner);
                    break;
                case 2:
                    employeeService(scanner);
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Vui long nhap tu 1-3 de chon phuong thuc");
                    break;
            }
//            } catch (Exception e){
//                System.err.println("Nhap sai dinh dang, vui long nhap lai");
//            }

        } while (true);
    }

    private static void departmentService(Scanner scanner) {

        do {
            try {
                System.out.println("**********************DEPARTMENT-MENU************************\n" +
                        "1. Thêm mới phòng ban [5 điểm]\n" +
                        "2. Hiển thị thông tin tất cả phòng ban [10 điểm]\n" +
                        "3. Sửa tên phòng ban [5 điểm]\n" +
                        "4. Xóa phòng ban [5 điểm]\n" +
                        "5. Tìm kiếm phòng ban [5 điểm]\n" +
                        "0. Quay lại");
                System.out.println("Nhap vao tu 0-5 de chon phuong thuc");
                int n = Integer.parseInt(scanner.nextLine());
                switch (n) {
                    case 1:
                        System.out.println("Them moi phong ban");
                        System.out.println("Ban them may phong ban");
                        int num = Integer.parseInt(scanner.nextLine());
                        for (int i = 0; i < num; i++) {
                            System.out.println("Phong ban thu " + (i + 1));
                            System.out.println("Nhap ten phong ban moi: ");
                            String departmentName = scanner.nextLine();
                            Department department = new Department(departmentName);
                            departments.add(department);
                            System.out.println("Them moi thanh cong");
                        }
                        break;
                    case 2:
                        System.out.println("Hiển thị thông tin tất cả phòng ban");
                        if (departments.isEmpty()) {
                            System.out.println("Danh sach phong ban trong");
                            break;
                        }
                        for (Department department : departments) {
                            int total = 0;
                            for (Employee employee : employees) {
                                if (employee.getDepartmentId() == department.getDepartmentId()) {
                                    total++;
                                }
                            }
                            System.out.println("Ma phong ban: " + department.getDepartmentId() + " Ten phong ban: " + department.getDepartmentName() + " So luong nhan vien: " + total);
                        }

                        break;
                    case 3:
                        if (departments.isEmpty()) {
                            System.out.println("Danh sách phòng ban trống.");
                            break;
                        }
                        System.out.println("Danh sach phong ban");
                        for (Department department : departments) {
                            System.out.println("Mã phòng ban: " + department.getDepartmentId() + ", Tên phòng ban: " + department.getDepartmentName());
                        }
                        System.out.println("Nhap ma phong ban can sua: ");
                        int departmentId = Integer.parseInt(scanner.nextLine());
                        Department department = findDepartmentById(departmentId);
                        if (department == null) {
                            System.out.println("Khong tim thay phong ban co ma " + departmentId);
                        }
                        System.out.println("Nhap ten moi cho phong ban: ");
                        String newName = scanner.nextLine();
                        department.setDepartmentName(newName);
                        System.out.println("Ten phong ban da duoc sua thanh cong");
                        break;
                    case 4:
                        if (departments.isEmpty()) {
                            System.out.println("Danh sách phòng ban trống.");
                            break;
                        }
                        System.out.println("Danh sách phòng ban:");
                        for (Department department1 : departments) {
                            System.out.println("Mã phòng ban: " + department1.getDepartmentId() + ", Tên phòng ban: " + department1.getDepartmentName());
                        }
                        System.out.print("Nhập mã phòng ban cần xóa: ");
                        int departmentId1 = scanner.nextInt();
                        scanner.nextLine(); // consume newline character
                        Department department1 = findDepartmentById(departmentId1);
                        if (department1 == null) {
                            System.out.println("Không tìm thấy phòng ban có mã " + departmentId1);
                            break;
                        }
                        if (isDepartmentHasEmployees(departmentId1)) {
                            System.out.println("Không thể xóa phòng ban có nhân viên.");
                            break;
                        }
                        departments.remove(department1);
                        System.out.println("Phòng ban đã được xóa thành công.");
                        break;
                    case 5:
                        if (departments.isEmpty()) {
                            System.out.println("Danh sách phòng ban trống.");
                            return;
                        }
                        System.out.print("Nhập tên phòng ban cần tìm kiếm: ");
                        String keyword = scanner.nextLine().toLowerCase();
                        List<Department> matchedDepartments = new ArrayList<>();
                        for (Department department2 : departments) {
                            if (department2.getDepartmentName().toLowerCase().contains(keyword)) {
                                matchedDepartments.add(department2);
                            }
                        }
                        if (matchedDepartments.isEmpty()) {
                            System.out.println("Không tìm thấy phòng ban nào phù hợp.");
                            return;
                        }
                        System.out.println("Kết quả tìm kiếm:");
                        for (Department department3 : matchedDepartments) {
                            System.out.println("Mã phòng ban: " + department3.getDepartmentId() + ", Tên phòng ban: " + department3.getDepartmentName());
                        }
                        break;
                    case 0:
                        mainService(scanner);
                        break;
                    default:
                        System.out.println("Vui long nhap tu 0-5 de chon phuong thuc");
                        break;
                }
            } catch (Exception e) {
                System.err.println("Nhap sai dinh dang, vui long nhap lai");
            }

        } while (true);
    }

    private static boolean isDepartmentHasEmployees(int departmentId) {
        for (Employee employee : employees) {
            if (employee.getDepartmentId() == departmentId) {
                return true;
            }
        }
        return false;
    }

    private static Department findDepartmentById(int departmentId) {
        for (Department department : departments) {
            if (department.getDepartmentId() == departmentId) {
                return department;
            }
        }
        return null;
    }

    private static void employeeService(Scanner scanner) {
        do {
            try {
                System.out.println("*************************EMPLOYEE-MENU**************************\n" +
                        "1. Thêm mới nhân viên [5 điểm]\n" +
                        "2. Hiển thị thông tin tất cả nhân viên [5 điểm]\n" +
                        "3. Xem chi tiết thông tin nhân viên [5 điểm]\n" +
                        "4. Thay đổi thông tin nhân viên [5 điểm]\n" +
                        "5. Xóa nhân viên [5 điểm]\n" +
                        "6. Hiển thị danh sách nhân viên theo phòng ban [10 điểm]\n" +
                        "7. Sắp xếp danh sách nhân viên [15 điểm]\n" +
                        "0. Quay lại");
                System.out.println("Nhap vao tu 0-7 de chon phuong thuc");
                int n = Integer.parseInt(scanner.nextLine());
                switch (n) {
                    case 1:
                        if (departments.isEmpty()) {
                            System.out.println("Danh sách phòng ban trống. Vui lòng thêm phòng ban trước.");
                            break;
                        }
                        System.out.print("Nhập tên nhân viên: ");
                        String employeeName = scanner.nextLine();
                        System.out.print("Nhập email: ");
                        String email = scanner.nextLine();
                        // Check email format
                        if (!isValidEmail(email)) {
                            System.out.println("Email không hợp lệ.");
                            return;
                        }
                        // Check email uniqueness
                        if (isEmailExist(email)) {
                            System.out.println("Email đã tồn tại.");
                            return;
                        }
                        System.out.print("Nhập số điện thoại: ");
                        String phoneNumber = scanner.nextLine();
                        // Check phone number format
                        if (!isValidPhoneNumber(phoneNumber)) {
                            System.out.println("Số điện thoại không hợp lệ.");
                            return;
                        }
                        // Check phone number uniqueness
                        if (isPhoneNumberExist(phoneNumber)) {
                            System.out.println("Số điện thoại đã tồn tại.");
                            return;
                        }
                        System.out.print("Nhập địa chỉ: ");
                        String address = scanner.nextLine();
                        System.out.println("Chọn gioi tinh nam/true, nu/false");
                        boolean gender = Boolean.parseBoolean(String.valueOf(scanner.nextBoolean()));
                        System.out.print("Nhập ngày sinh (dd/MM/yyyy): ");
                        String birthdayStr = scanner.nextLine();
                        Date birthday = parseDate(birthdayStr);
                        if (birthday == null) {
                            System.out.println("Ngày sinh không hợp lệ.");
                            return;
                        }
                        System.out.print("Nhập lương cơ bản: ");
                        float basicSalary = scanner.nextFloat();
                        System.out.print("Nhập phụ cấp: ");
                        float allowanceSalary = scanner.nextFloat();
                        System.out.print("Nhập hệ số lương: ");
                        float rate = scanner.nextFloat();
                        System.out.println("Danh sách phòng ban:");
                        for (Department department : departments) {
                            System.out.println("Mã phòng ban: " + department.getDepartmentId() + ", Tên phòng ban: " + department.getDepartmentName());
                        }
                        System.out.print("Nhập mã phòng ban: ");
                        int departmentId = scanner.nextInt();
                        scanner.nextLine(); // consume newline character
                        Employee employee = new Employee(employeeName, email, phoneNumber, address, gender, birthday, basicSalary, allowanceSalary, rate, departmentId);
                        employees.add(employee);
                        System.out.println("Nhân viên đã được thêm mới thành công.");
                        break;
                    case 2:
                        if (employees.isEmpty()) {
                            System.out.println("Danh sách nhân viên trống.");
                            break;
                        }
                        System.out.println("Danh sách nhân viên:");
                        for (Employee employee1 : employees) {
                            System.out.println(employee1);
                        }
                        break;
                    case 3:
                        if (employees.isEmpty()) {
                            System.out.println("Danh sách nhân viên trống.");
                            return;
                        }
                        System.out.print("Nhập mã nhân viên cần xem chi tiết: ");
                        int employeeId = scanner.nextInt();
                        scanner.nextLine();
                        Employee employee2 = findEmployeeById(employeeId);
                        if (employee2 == null) {
                            System.out.println("Không tìm thấy nhân viên có mã " + employeeId);
                            return;
                        }
                        System.out.println("Thông tin chi tiết nhân viên:");
                        System.out.println(employee2);
                        break;
                    case 4:
                        if (employees.isEmpty()) {
                            System.out.println("Danh sách nhân viên trống.");
                            return;
                        }
                        System.out.print("Nhập mã nhân viên cần sửa: ");
                        int employeeId1 = scanner.nextInt();
                        scanner.nextLine(); // consume newline character
                        Employee employee3 = findEmployeeById(employeeId1);
                        if (employee3 == null) {
                            System.out.println("Không tìm thấy nhân viên có mã " + employeeId1);
                            break;
                        }
                        break;
                    case 5:
                        if (employees.isEmpty()) {
                            System.out.println("Danh sách nhân viên trống.");
                            return;
                        }
                        System.out.print("Nhập mã nhân viên cần xóa: ");
                        int employeeId2 = scanner.nextInt();
                        scanner.nextLine(); // consume newline character
                        Employee employee4 = findEmployeeById(employeeId2);
                        if (employee4 == null) {
                            System.out.println("Không tìm thấy nhân viên có mã " + employeeId2);
                            return;
                        }
                        employees.remove(employee4);
                        System.out.println("Nhân viên đã được xóa thành công.");

                break;
                case 6:
                    if (departments.isEmpty()) {
                        System.out.println("Danh sách phòng ban trống.");
                        return;
                    }
                    System.out.println("Danh sách phòng ban:");
                    for (Department department : departments) {
                        System.out.println("Mã phòng ban: " + department.getDepartmentId() + ", Tên phòng ban: " + department.getDepartmentName());
                    }
                    System.out.print("Nhập mã phòng ban cần hiển thị nhân viên: ");
                    int departmentId3 = scanner.nextInt();
                    scanner.nextLine(); // consume newline character
                    List<Employee> employeesByDepartment = new ArrayList<>();
                    for (Employee employee5 : employees) {
                        if (employee5.getDepartmentId() == departmentId3) {
                            employeesByDepartment.add(employee5);
                        }
                    }
                    if (employeesByDepartment.isEmpty()) {
                        System.out.println("Không có nhân viên nào thuộc phòng ban có mã " + departmentId3);
                        return;
                    }
                    System.out.println("Danh sách nhân viên thuộc phòng ban:");
                    for (Employee employee6 : employeesByDepartment) {
                        System.out.println(employee6);
                    }
                    break;
                case 7:
                    
                    break;
                case 0:
                    mainService(scanner);
                    break;
                default:
                    System.out.println("Vui long nhap tu 1-3 de chon phuong thuc");
                    break;
            }
        } catch(Exception e){
            System.err.println("Nhap sai dinh dang, vui long nhap lai");
        }

    } while(true);
}

private static boolean isValidEmail(String email) {
    String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    return email.matches(emailRegex);
}

private static boolean isEmailExist(String email) {
    for (Employee employee : employees) {
        if (employee.getEmail().equals(email)) {
            return true;
        }
    }
    return false;
}

private static boolean isValidPhoneNumber(String phoneNumber) {
    String phoneRegex = "(/(84|0[3|5|7|8|9])+([0-9]{8})\\b/g)";
    return phoneNumber.matches(phoneRegex);
}

private static boolean isPhoneNumberExist(String phoneNumber) {
    for (Employee employee : employees) {
        if (employee.getPhoneNumber().equals(phoneNumber)) {
            return true;
        }
    }
    return false;
}

private static Date parseDate(String dateStr) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    dateFormat.setLenient(false);
    try {
        return dateFormat.parse(dateStr);
    } catch (Exception e) {
        return null;
    }
}

private static Employee findEmployeeById(int employeeId) {
    for (Employee employee : employees) {
        if (employee.getEmployeeId() == employeeId) {
            return employee;
        }
    }
    return null;
}
}
