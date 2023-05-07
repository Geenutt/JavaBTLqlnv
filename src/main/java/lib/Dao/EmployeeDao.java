package lib.Dao;
import java.util.ArrayList;
import java.util.List;
import lib.entity.*;
import lib.utils.*;
/**
 * @author
 */
public final class EmployeeDao {
    //Thay tên file "movie.xml" bằng file muốn đọc(FIle cần đọc phải được đặt trong project)
    private static final String EMPLOYEE_FILE_NAME="Employee.xml";
    //Tạo 1 list movie 
    private List<Employee> listEmployees;
    
    //Constructor
    public EmployeeDao() {
        listEmployees = readListEmployees();
    }
    EmployeeXML employeeXML = new EmployeeXML();
    //Đọc file XMl được cấp và trả về List<Movie>
    public List<Employee> readListEmployees(){
        //Tạo 1 instance List<Movie>
        List<Employee> list = new ArrayList<>();
        //Tạo 1 instance của MovieXML và gán dữ liệu sử dụng hàm đọc file XML từ FileUtils
        employeeXML = (EmployeeXML) FileUtils.readXMLFile(EMPLOYEE_FILE_NAME, EmployeeXML.class);
        //Gán dữ liệu nếu như file không null
        if (employeeXML != null) {
            list = employeeXML.getEmployee();
        }
        return list;
    }
    //lưu các đối tượng movie vào file movie.xml
    public void writeListEmployees(List<Employee> listMovies) {
        //Tạo 1 instance của MovieXML
       
        employeeXML.setEmployee(listMovies);
        FileUtils.writeXMLtoFile(EMPLOYEE_FILE_NAME, employeeXML);
    }
    public void writeListEmployees(ArrayList<Employee> listMovies) {
        //Tạo 1 instance của MovieXML
        employeeXML = new EmployeeXML();
        employeeXML.setEmployee(listMovies);
        FileUtils.writeXMLtoFile(EMPLOYEE_FILE_NAME, employeeXML);
    }
    public ArrayList<Employee> getListEmployee() {
        listEmployees = readListEmployees();
        return (ArrayList<Employee>)listEmployees;
    }
    public void addEmployee(Employee m){
        listEmployees = readListEmployees();
        listEmployees.add(m);
        writeListEmployees(listEmployees);
    }
    public void removeEmployee(Employee m){
        listEmployees = readListEmployees();
        listEmployees.remove(m);
        writeListEmployees(listEmployees);
    }
    //Set số vé đã bán cho movie được đưa vào với 1 vé hoặc Num vé 
//    public void setEmployee(Employee movie) {
//        listEmployees=readListEmployees();
//        for (Employee m : listEmployees) {
//            if (m.getName().equals(movie.getName())) {
//                m.setSold(m.getSold()+1);
//                break;
//            }
//        }
//        writeListMovies(listMovies);
//    }
    //Overload hàm setVé
//    public void setMovie(Employee movie,int Num) {
//        listMovies=readListMovies();
//        for (Movie m : listMovies) {
//            if (m.getName().equals(movie.getName())) {
//                m.setSold(m.getSold()+Num);
//                break;
//            }
//        }
//        writeListMovies(listEmployees);
//    }
    public void setMovie1(Employee a) {
        listEmployees=readListEmployees();
        for (Employee m : listEmployees) {
            if (m.getName().equals(a.getName())) {
                m.setID(a.getID());
                m.setName(a.getName());
                m.setAge(a.getAge());
                m.setEmail(a.getEmail());
                m.setPosition(a.getPosition());
                m.setSalary(a.getSalary());
            }
        }
        writeListEmployees(listEmployees);
    }
    
    //Getter và Setter
    public List<Employee> getListEmployees() {
        return listEmployees;
    }
    public void setListEmployees(List<Employee> listEmployees) {
        this.listEmployees = listEmployees;
        writeListEmployees(listEmployees);
    }
}

