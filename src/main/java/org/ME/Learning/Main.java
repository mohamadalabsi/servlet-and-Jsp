package org.ME.Learning;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


import java.math.BigDecimal;


public class Main {
    public static void main(String[] args) {
//!        insert the data into the database from Car class to car table // first example
//        Car myCar = new Car();
//        myCar.setId(553);
//        myCar.setModel("Sonata");
//        myCar.setMake("hyundai");
//        BigDecimal price = new BigDecimal("12050.49");
//        myCar.setPrice(price);


//!         insert and creat the data into the database from student class to student table // second example with to classes but one table
//        StudentName  sn = new StudentName();
//        sn.setFirstName("Mohammad");
//        sn.setLastName("Al Absi");
//
//        Student student = new Student();
//        student.setId(1);
//        student.setAge(20);
//        student.setName("Mohammad Al Absi");


//!         insert and creat the data into the database from student and laptop class to student and laptop table  one to one // second example
//
//        Laptop laptop = new Laptop();
//        laptop.setId(101);
//        laptop.setBrand("Dell");
//
//        Student student = new Student();
//        student.setRollNumber(1);
//        student.setName("Mohammad Al Absi");
//        student.setMarks(20);
//        student.setLaptop(laptop);


//!      insert and creat the data into the database from student and laptop class to student and laptop table (one to many one side) without making student object in laptop class - it will creat another table (student_table)// third example
//!      without making student object in laptop class it will make new table and we do not want that , we want it to behave like normal sql table and we have to mention the mapping // fourth example
//
//        Student student = new Student();
//        student.setRollNumber(1);
//        student.setName("Mohammad Al Absi");
//        student.setMarks(20);
//
//
//
//        Laptop laptop = new Laptop();
//        laptop.setId(101);
//        laptop.setBrand("Dell");
////        laptop.setStudent(student); without mentioning , the value in the laptop table of student_laptop is null
//
//        student.getLaptop().add(laptop);

////!      insert and creat the data into the database from student and laptop class to student and laptop table (many to many both sides) // fifth example
//!        here because it is many to many on both sides it will create new table for that
        Student student = new Student();
        student.setRollNumber(1);
        student.setName("Mohammad Al Absi");
        student.setMarks(20);



        Laptop laptop = new Laptop();
        laptop.setId(101);
        laptop.setBrand("Dell");
        laptop.getStudent().add(student);

        student.getLaptop().add(laptop);


        Configuration  con = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);

        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();  // just to get rid of the  line under buildSessionFactory that is why it is a service

        SessionFactory sf = con.buildSessionFactory(reg);
        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();
        session.save(student); //this is for inserting into the database
        session.save(laptop);

//         fetching the data from the database
//         myCar=(Car)session.get(Car.class, 50);
//         System.out.println(myCar);
        tx.commit();


    }
}