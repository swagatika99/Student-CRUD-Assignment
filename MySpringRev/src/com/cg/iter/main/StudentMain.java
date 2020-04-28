package com.cg.iter.main;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cg.iter.bean.Address;
import com.cg.iter.bean.Student;
import com.cg.iter.service.StudentService;

@Component
public class StudentMain {
	@Autowired
	private StudentService studService;

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("student.xml");
		StudentMain sm = ctx.getBean(StudentMain.class);
		sm.startApplication();
	}
	public void startApplication() {
		// Student stud = new Student(1234,"Anurag",9012341234L,"Java");
		//studService = (StudentService) ctx.getBean("service");		
		System.out.println(studService);
		Scanner scan = new Scanner(System.in);int choice = 0;
		while (true) {
			choice = getChoice(scan);
			switch (choice) {
			case 1:
				System.out.println("Create Student");
				System.out.println("Enter <houseId> <HouseName> <City>");
				Address addr = new Address(scan.nextInt(), scan.next(), scan.next());
				System.out.println("Enter <ID> <Name> <Mobile> <Subject>");
				Student stud = new Student(scan.nextInt(),scan.next(),
						          scan.nextLong(),scan.next(),addr);
				boolean success = studService.create(stud);
				if(success) {
					System.out.println("Student saved");
				}
				else {
					System.out.println("Could not save student");
				}
				break;
			case 2:
				System.out.println("Find Student");
				System.out.println("Enter the <id>");
				stud= studService.getstud(scan.nextInt());
				if(stud!=null)
				{
				System.out.println("Student found: " + stud);
				}
				else {
					System.out.println("Student  not found");
				}
				
				break;
			case 3:
				System.out.println("Update Student");
				System.out.println("Find Student : Enter <id>");
				stud = studService.getstud(scan.nextInt());
				System.out.println("Student found: " + stud);
				if (stud!= null) {
					System.out.println("Enter new <Subject> ");
					stud.setSubject(scan.next());
				
					boolean saved = studService.update(stud);
					if (saved)
						System.out.println("student table updated");
					else
						System.out.println("student table  could not be updated");
						}
				

				break;
			case 4:
				System.out.println("Delete Student");
				System.out.println("Enter the <id>");
				stud = studService.getstud(scan.nextInt());
				System.out.println("Author found: " + stud);
				if(stud!=null)
				{
					boolean delete=studService.delete(stud);
					if(delete) {
						System.out.println("Student data has been deleted");
					}
					else {
						System.out.println("Student data not deleted");
					}
				}

				break;
			case 5:
				System.out.println("Find Student Names");
				break;
			case 6:
				System.out.println("Exiting Program");
				System.exit(0);
				break;

			default:
				System.out.println("Enter 1 to 6 only");
				break;
			}
		}
	}
		private int getChoice(Scanner scan) {
			int choice = 0;
			System.out.println("STUDENT MANAGEMENT");
			System.out.println("1. Create Student");
			System.out.println("2. Find Student");
			System.out.println("3. Update Student");
			System.out.println("4. Delete Student");
			System.out.println("5. Find Student Names");
			System.out.println("6. Exit Program");
			System.out.println("Choose the option from above");
			try {
			choice = scan.nextInt();
			}catch (InputMismatchException e) {
				System.out.println("Please choose a number");
				scan.nextLine();
			}
			return choice;
		}		
		
		
		
		// System.out.println("Fetching bean");
		// Student stud = (Student) ctx.getBean("stud");
		// System.out.println(stud);
		// EntityManagerFactory emf =
		// Persistence.createEntityManagerFactory("studentity");
		// EntityManager em = emf.createEntityManager();
		// em.getTransaction().begin();
		// em.persist(stud);
		// em.getTransaction().commit();
		// System.out.println("Student saved");
		// Student stud1 = (Student) ctx.getBean("stud1");
		// System.out.println(stud1);
		// System.out.println(ctx.getBean("addr"));
	

}
