package lib.entity;
import java.util.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ls")
@XmlAccessorType(XmlAccessType.FIELD)

public class EmployeeXML {
    //Tạo class MovieXML
    private List<Employee> employee;
    //List chứa movie
    
    ///getter và setter 
    public List<Employee> getEmployee() {
        return employee;
    }
    
    public void setEmployee(List<Employee> m) {
        this.employee = m;
    }
    
}
