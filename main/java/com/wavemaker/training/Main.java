package com.wavemaker.training;

import com.wavemaker.training.db.dao.AddressDAO;
import com.wavemaker.training.db.dao.DepartmentDAO;
import com.wavemaker.training.db.dao.EmployeeDAO;
import com.wavemaker.training.db.model.Address;
import com.wavemaker.training.db.model.department;
import com.wavemaker.training.db.model.employee;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static EmployeeDAO employeeDAO = new EmployeeDAO();

    private static DepartmentDAO departmentDAO = new DepartmentDAO();

    private static AddressDAO addressDAO = new AddressDAO();

    public void printemployee() throws SQLException {
        List<employee> ListOfemployee = employeeDAO.ListOf();
        if (ListOfemployee != null) {
            for (employee emp : ListOfemployee) {
                System.out.println(emp);
            }
        }
    }

    public void printdepartment() throws SQLException {
        List<department> ListOfdepartment = departmentDAO.listOfdepartment();
        if (ListOfdepartment != null) {
            for (department dep : ListOfdepartment) {
                System.out.println(dep);
            }
        }
    }

    public void printaddress() throws SQLException{
        List<Address> ListOfaddress = addressDAO.ListOf();
        if(ListOfaddress != null ){
            for(Address addr : ListOfaddress){
                System.out.println(addr);
            }
        }
    }

    public static void main(String[] args) throws SQLException {

        Scanner intInput = new Scanner(System.in);
        Scanner stringInput = new Scanner(System.in);

        int choice1 = 0;
        int choice2 = 0;

        do {
            System.out.println("1.employee table");
            System.out.println("2.department table");
            System.out.println("3.address table");
            System.out.println("4.exit");
            System.out.print("enter your table to perform actions :");
            choice1 = intInput.nextInt();

            if (choice1 == 1) {
                do {
                    System.out.println("1.display employee table");
                    System.out.println("2.search from table");
                    System.out.println("3.insert into table");
                    System.out.println("4.update data into table ");
                    System.out.println("5.delete data from table");
                    System.out.println("6.exit");
                    choice2 = intInput.nextInt();

                    if (choice2 == 1) {

                        new Main().printemployee();

                    } else if (choice2 == 2) {
                        employee employeeObject = new employee();
                        System.out.println("enter user id to be searched");
                        employeeObject.setId(intInput.nextInt());

                        employeeDAO.search(employeeObject);

                    } else if (choice2 == 3) {
                        employee employeeObject = new employee();
                        System.out.println("enter user id to be inserted ");
                        employeeObject.setId(intInput.nextInt());
                        System.out.println("enter user name to be inserted");
                        employeeObject.setName(stringInput.nextLine());
                        System.out.println("enter user mobile to be inserted");
                        employeeObject.setMobile(stringInput.nextLine());
                        System.out.println("enter user department_id to be inserted");
                        employeeObject.setDepartment_id(intInput.nextInt());
                        System.out.println("enter address_id to be inserted");
                        employeeObject.setAddress_id(intInput.nextInt());

                        employeeDAO.insert(employeeObject);


                    } else if (choice2 == 4) {
                        employee employeeObject = new employee();
                        System.out.println("enter user id to be updated ");
                        employeeObject.setId(intInput.nextInt());
                        System.out.println("enter user name to be updated");
                        employeeObject.setName(stringInput.nextLine());
                        System.out.println("enter user mobile to be updated");
                        employeeObject.setMobile(stringInput.nextLine());

                        employeeDAO.update(employeeObject);

                    } else if (choice2 == 5) {
                        employee employeeObject = new employee();
                        System.out.println("enter user id to be deleted");
                        employeeObject.setId(intInput.nextInt());

                        employeeDAO.delete(employeeObject);

                    }
                } while (choice2 != 6);

            } else if (choice1 == 2) {
                do {
                    System.out.println("1.display address table");
                    System.out.println("2.search from table");
                    System.out.println("3.insert into table");
                    System.out.println("4.update data into table ");
                    System.out.println("5.delete data from table");
                    System.out.println("6.exit");
                    choice2 = intInput.nextInt();

                    if (choice2 == 1) {

                        new Main().printdepartment();

                    } else if (choice2 == 2) {
                        department departmentObject = new department();
                        System.out.println("enter user id to be searched");
                        departmentObject.setId(intInput.nextInt());

                        departmentDAO.search(departmentObject);

                    } else if (choice2 == 3) {
                        department departmentObject = new department();
                        System.out.println("enter id to be inserted ");
                        departmentObject.setId(intInput.nextInt());
                        System.out.println("enter name to be inserted");
                        departmentObject.setName(stringInput.nextLine());
                        System.out.println("enter Locality to be inserted");
                        departmentObject.setLocality(stringInput.nextLine());

                        departmentDAO.insert(departmentObject);


                    } else if (choice2 == 4) {
                        department departmentObject = new department();
                        System.out.println("enter id to be updated ");
                        departmentObject.setId(intInput.nextInt());
                        System.out.println("enter  name to be updated");
                        departmentObject.setName(stringInput.nextLine());
                        System.out.println("enter locality to be updated");
                        departmentObject.setLocality(stringInput.nextLine());

                        departmentDAO.update(departmentObject);

                    } else if (choice2 == 5) {
                        department departmentObject = new department();
                        System.out.println("enter department id to be deleted");
                        departmentObject.setId(intInput.nextInt());

                        departmentDAO.delete(departmentObject);

                    }
                } while (choice2 != 6);

            } else if (choice1 == 3) {
                do {
                    System.out.println("1.display address table");
                    System.out.println("2.search from table");
                    System.out.println("3.insert into table");
                    System.out.println("4.update data into table ");
                    System.out.println("5.delete data from table");
                    System.out.println("6.exit");
                    choice2 = intInput.nextInt();

                    if (choice2 == 1) {

                        new Main().printaddress();

                    } else if (choice2 == 2) {
                        Address address = new Address();
                        System.out.println("enter user id to be searched");
                        address.setId(intInput.nextInt());

                        addressDAO.search(address);

                    } else if (choice2 == 3) {
                        Address address = new Address();
                        System.out.println("enter id to be inserted ");
                       address.setId(intInput.nextInt());
                        System.out.println("enter street to be inserted");
                        address.setStreet(stringInput.nextLine());
                        System.out.println("enter city to be inserted");
                        address.setCity(stringInput.nextLine());
                        System.out.println("enter state to be inserted");
                        address.setState(stringInput.nextLine());
                        System.out.println("enter zip_code to be inserted ");
                        address.setZip_code(intInput.nextInt());

                        addressDAO.insert(address);


                    } else if (choice2 == 4) {
                        Address address = new Address();
                        System.out.println("enter id to be updated ");
                        address.setId(intInput.nextInt());
                        System.out.println("enter street to be update");
                        address.setStreet(stringInput.nextLine());
                        System.out.println("enter city to be updated");
                        address.setCity(stringInput.nextLine());
                        System.out.println("enter state to be updated");
                        address.setState(stringInput.nextLine());
                        System.out.println("enter zip_code to be updated");
                        address.setZip_code(intInput.nextInt());

                        addressDAO.update(address);

                    } else if (choice2 == 5) {
                        Address address = new Address();
                        department departmentObject = new department();
                        System.out.println("enter department id to be deleted");
                        address.setId(intInput.nextInt());

                        new Main().addressDAO.delete(address);

                    }else {
                        choice2 = 6;
                    }
                } while (choice2 != 6);

            }else{
                choice1 =4;
            }

        } while (choice1 != 4);
    }
}