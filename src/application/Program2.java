package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
	
		DepartmentDao departmentDao = DaoFactory.createDepartametDao();
		
		System.out.println("=== TEST 1: department findbyID ==== ");
		Department department = departmentDao.findById(3);
		System.out.println(department);
		
		System.out.println("\n=== TEST 2: department findAll ==== ");
		List<Department> list = departmentDao.findAll();
		for(Department obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TEST 3: department insert ==== ");
		Department newDepartment = new Department(null, "Coxinha");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! new id= "+ newDepartment.getId());
		
		System.out.println("\n=== TEST 4: department update ==== ");
		department = departmentDao.findById(7);
		department.setName("Esfira");
		departmentDao.update(department);
		System.out.println("update completed");
		
		System.out.println("\n=== TEST 5: department delete ==== ");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed");
		
		
		sc.close();
		
	}

}
