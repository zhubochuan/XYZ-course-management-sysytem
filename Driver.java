import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Driver {
	// store all course
	static List<Course> course = new ArrayList<Course>();
	// store all student
	static List<Student> student = new ArrayList<Student>();

	public static void main(String[] args) {
		Driver dr = new Driver();
		// initial course into system
		dr.initialCourse();
		// initial student into system
		dr.initialStudent();
		System.out.println("Welcome to XYZ Course System");
		System.out.println("=============================");
		dr.getCourse();
		System.out.println("-----------------------------");
		dr.getStudent();
		System.out.println("-----------------------------");
		// call the menu
		dr.menu();
	}

	// initial course and add them into system
	public void initialCourse() {
		Course Italian_Cooking = new Course("001", "Italian Cooking", 500, 1000);
		Course Seafood_Cooking = new Course("002", "Seafood Cooking", 700, 1000);
		Course Sewing = new Course("003", "Sewing", 300, 0);
		Course CreativeWriting = new Course("004", "Creative Writing", 200, 0);
		Course BusinessWriting = new Course("005", "Business Writing", 200, 0);
		course.add(Italian_Cooking);
		course.add(Seafood_Cooking);
		course.add(Sewing);
		course.add(CreativeWriting);
		course.add(BusinessWriting);
	}

	// initial student into system
	public void initialStudent() {
		Student James = new Student("James Smith", 35, "21 Baker Street");
		Student Jane = new Student("Jane Jones", 24);
		Student Larry = new Student("Larry Berry", 55, "1/9 Charles Court");
		student.add(James);
		student.add(Jane);
		student.add(Larry);
	}

	// get all course info
	public void getCourse() {
		for (Course c : course) {
			System.out.println(
					"Course Id:" + c.getId() + " Name:" + c.getName() + " fee" + c.getFee() + " cost" + c.getCost());
		}
	}

	// get all student info
	public void getStudent() {
		for (Student s : student) {
			System.out.println("Name: " + s.getName() + " Age:" + s.getAge() + " Address:" + s.getAddress());
		}
	}

	// menu which has actions
	public void menu() {

		System.out.println("=================");
		System.out.println("Course Management");
		System.out.println("=================");
		System.out.println("1.Add a student"); // has student number limit
		System.out.println("2.Withdraw a student");
		System.out.println("3.Display a student list for a course");
		System.out.println("4.Display the course figures"); // calculate cost and income, profit
		System.out.println("5.Quit");
		System.out.println("Enter an Option:");

		Scanner s1 = new Scanner(System.in);
		String c1 = s1.nextLine();
		switch (c1) {
		case "1": // add student
			enrol();
			break;
		case "2": // withdraw student
			withdraw();
			break;
		case "3": // display student list for a course
			studentlist();
			break;
		case "4": // display the course figures
			figures();
			break;
		case "5": // exit
			System.exit(0);
			break;
		default:
			System.out.println("error for menu choice");
			menu();
			break;
		}
	}

	// display student list for a course
	public void studentlist() {
		Scanner s1 = new Scanner(System.in);
		int flag = 1;
		do {
			System.out.println("enter course id:");
			System.out.println("-----------------");
			String input1 = s1.nextLine();
			// found course by id
			for (Course c : course) {
				if (c.getId().equals(input1)) {
					System.out.println("==Students in " + c.getName() + " ==");
					// show all student in this collection
					for (Student st : c.students) { // show all student
						System.out.println(st.getName() + " " + st.getAddress() + " " + st.getAge());
					}
					menu();
					flag = 0;
					break;
				} // end of found course by id
				// else {
				// System.out.println("course not found");
				// flag=1;
				// // menu();
				// // break;
				// }
			}
			if (flag == 1) {
				System.out.println("course not found");
				menu();
			}

		} while (flag != 0); // flag==0, it will stop
	}

	// get course figures, student counts, income, cost, profit
	public void figures() {

		for (Course c : course) {
			// Italian cooking
			if (c.getId().equals("001")) {
				double income = 0;

				for (Student s : c.students) { // all student in this course

					/*
					 * if student who select any course before, there is discount as 20% off
					 */
					if (s.course.size() > 1) {
						// 20%
						income += (0.8 * 500);
					} else {
						income += 500;
					}
				}
				System.out.println(c.getName() + ": Students " + c.students.size() + ", Cost " + 1000 + ", income:"
						+ income + ",profit " + (income - 1000));
			}
			//sea-food cooking
			if (c.getId().equals("002")) {
				double income = 0;

				for (Student s : c.students) { // all student in this course

					/*
					 * if student who select any course before, there is discount as 20% off
					 */
					if (s.course.size() > 1) {
						// 20%
						income += (0.8 * 700);
					} else {
						income += 700;
					}
				}
				System.out.println(c.getName() + ": Students " + c.students.size() + ", Cost " + 1000 + ", income:"
						+ income + ",profit " + (income - 1000));
			}
			//sewing
			if (c.getId().equals("003")) {
				double income = 0;
				double cost=0;
				
				for (Student s : c.students) { // all student in this course

					/*
					 * if student who select any course before, there is discount as 20% off
					 */
					if (s.course.size() > 1) {
						// 20%
						income += (0.8 * 300);
						cost+=100;
					} else {
						income += 300;
						cost+=100;
					}
				}
				System.out.println(c.getName() + ": Students " + c.students.size() + ", Cost " + cost + ", income:"
						+ income + ",profit " + (income - cost));
			}
			//creative writing
			if (c.getId().equals("004")) {
				double income = 0;
				double cost=0;
				
				for (Student s : c.students) { // all student in this course

					/*
					 * if student who select any course before, there is discount as 20% off
					 */
					if (s.course.size() > 1) {
						// 20%
						income += (0.8 * 200);
						cost+=800;
					} else {
						income += 200;
						cost+=800;
					}
				}
				System.out.println(c.getName() + ": Students " + c.students.size() + ", Cost " + cost + ", income:"
						+ income + ",profit " + (income - cost));
			}
			//business course
			//sea-food cooking
			if (c.getId().equals("005")) {
				double income = 0;
				double cost=0;
				for (Student s : c.students) { // all student in this course

					/*
					 * if student who select any course before, there is discount as 20% off
					 */
					if (s.course.size() > 1) {
						// 20%
						income += (0.8 * 200);
						cost+=600;
					} else {
						income += 200;
						cost+=600;
					}
				}
				System.out.println(c.getName() + ": Students " + c.students.size() + ", Cost " + cost + ", income:"
						+ income + ",profit " + (income - cost));
			}
		}
		menu();
	}// end of figures

	// withdraw a student from a course
	public void withdraw() {
		Scanner s1 = new Scanner(System.in);
		int flag = 1;
		do {
			System.out.println("enter student name:");
			System.out.println("----------------------");
			String intput1 = s1.nextLine();
			// found student name
			for (Student s : student) {
				if (s.getName().equals(intput1)) {
					System.out.println("name is found");
					// process depending on found student

					// current s is the student object
					Scanner s2 = new Scanner(System.in);//
					Loop: for (int i = 1; i <= course.size(); i++) {
						int flag2 = 0;
						System.out.println("enter NO " + i + " course Id to delete:");
						System.out.println("enter q to finish");
						String courseId = s2.next();
						for (Course c : course) {
							if (c.getId().equals(courseId)) {
								s.course.remove(c); // delete a course
								c.students.remove(s); // delete student from course

								flag2 = 0;
								break;
							}
							if (courseId.equals("q")) {
								System.out.println("finish withdraw course");
								// show course which student select
								System.out.println(s.getName() + " has withdraw:");
								for (Course c2 : s.course) {
									System.out.println(c2.getId() + " Name:" + c2.getName());
								}
								flag2 = 0;
								break Loop;
							} else {
								flag2 = 1;
							}
						}
						if (flag2 != 0) {
							System.out.println("error for course ID");// enter NO...course
							i--;
						}
					}

					// end select course for this student
					flag = 0;
					menu();
					break;
				}
			}
			if (flag == 1) {
				System.out.println("name not found");
				menu();
			}
		} while (flag != 0);
	}

	// input course number and return current student count
	public int studenNum(String id) { // input course
		int count = 0;
		for (Course c : course) {
			if (c.getId().equals(id)) {
				count = c.students.size();
			}
		}
		return count;
	}

	// enroll a student into the course
	public void enrol() {
		Scanner s1 = new Scanner(System.in);
		int flag = 1;
		do {
			System.out.println("enter student name:");
			System.out.println("enter \'add\'to add new student");
			System.out.println("----------------------");
			String intput1 = s1.nextLine();
			// found student name
			for (Student s : student) {
				if (s.getName().equals(intput1)) {
					System.out.println("name is found");
					// process depending on found student

					// current s is the student object
					Scanner s2 = new Scanner(System.in);//
					Loop: for (int i = 1; i <= course.size(); i++) {
						int flag2 = 0;
						System.out.println("enter NO " + i + " course Id:");
						System.out.println("enter q to finish");
						String courseId = s2.next();
						for (Course c : course) {
							if (c.getId().equals(courseId)) {
								// judge the max number of student
								if (c.getId().equals("003")) {
									System.out.println("sewing max student number is 10");
									// show available number
									System.out.println("Available number: " + (10 - c.students.size()));

									// sewing course
									if (c.students.size() <= 10) {
										s.course.add(c);
										c.students.add(s);
										System.out.println("sewing enrol successfully");
									} else {
										System.out.println("cannot add more students");
										menu();
									}

								}
								// 001 and 002
								// cooking course
								if (c.getId().equals("001") || c.getId().equals("002")) {
									System.out.println("cooking max student number is 10");
									int count001 = studenNum("001");
									int count002 = studenNum("002");

									System.out.println("Available number: " + (10 - count001 - count002));

									if ((count001 + count002) <= 10) {
										s.course.add(c);
										c.students.add(s);
										System.out.println("enroll successfully");
									} else {
										System.out.println("cannot add more students");
										menu();
									}
								}

								// 004 and 005
								// writing course
								if (c.getId().equals("004") || c.getId().equals("005")) {
									System.out.println("writng max student number is 15");

									int count004 = studenNum("004");
									int count005 = studenNum("005");

									System.out.println("Available number: " + (15 - count004 - count005));

									if ((count004 + count005) <= 15) {
										s.course.add(c);
										c.students.add(s);
									} else {
										System.out.println("cannot add more students");
										menu();
									}
								}

								// s.course.add(c); // add a course

								// c.students.add(s); // add student into course

								flag2 = 0;
								break;
							}
							if (courseId.equals("q")) {
								System.out.println("finish add course");
								// show course which student select
								System.out.println(s.getName() + " have selected:");
								for (Course c2 : s.course) {
									System.out.println(c2.getId() + " Name:" + c2.getName());
								}

								flag2 = 0;
								break Loop;
							} else {
								flag2 = 1;
							}
						}
						if (flag2 != 0) {
							System.out.println("error for course ID");// enter NO...course
							i--;
						}
					}

					// end select course for this student
					flag = 0;
					menu();
					break;
				}
				if (intput1.equals("add")) {
					// add new student into system

					Student nstudent;

					System.out.println("---add new student---");
					System.out.println("enter name:");
					Scanner ns = new Scanner(System.in);
					String nname = ns.nextLine();
					System.out.println("enter age:");
					int nage = ns.nextInt();
					System.out.println("enter address:");
					Scanner sadd = new Scanner(System.in);
					String naddress = sadd.nextLine();

					if (naddress.isEmpty()) {
						nstudent = new Student(nname, nage);
						student.add(nstudent);
					} else {
						nstudent = new Student(nname, nage, naddress);
						student.add(nstudent);
					}
					System.out.println("create finished");

					flag = 0;

					menu();
					break;
				}
			}
			if (flag == 1) {
				System.out.println("name not found");
				enrol();
			}
		} while (flag != 0);
	}
}
