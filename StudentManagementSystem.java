package com;

import java.sql.SQLException;
import java.util.Scanner;

public class StudentManagementSystem {

    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        student s = new student();
        admin ad = new admin();
        
        System.out.println("*** Student Management System ***");
        System.out.println("Login as 'student' or 'admin':");
        String login = sc.next();
        
        switch (login.toLowerCase()) { // Case-insensitive check for login type
        case "student":
            while (true) {
                System.out.println("Choose any one of the operations:\n1. ADD\n2. VIEW\n3. EXIT");
                int b = sc.nextInt();
                
                switch (b) {
                case 1:
                    System.out.println("Enter Student ID:");
                    int sid = sc.nextInt();
                    
                    System.out.println("Enter Student NAME:");
                    String sname = sc.next();
                    
                    System.out.println("Enter COURSE:");
                    String scourse = sc.next();
                    
                    System.out.println("Enter DATE OF JOIN:");
                    String dateofjoin = sc.next();
                    
                    System.out.println("Enter DEPARTMENT:");
                    String department = sc.next();
                    
                    System.out.println("Enter STREAM:");
                    String stream = sc.next();
                    
                    System.out.println("Enter MARKS:");
                    int marks = sc.nextInt();
                    
                    int n = s.insert(sid, sname, scourse, dateofjoin, department, stream, marks);
                    String r = (n > 0) ? "Record Added to DB" : "Record not Added to DB";
                    System.out.println(r);
                    break;
                    
                case 2:
                    s.select();
                    break;
                    
                case 3:
                    System.out.println("Operation Terminated");
                    return;
                    
                default:
                    System.out.println("Invalid Option! Please try again.");
                }
            }
            
        case "admin":
            System.out.println("New, Existing, or Management?");
            String n = sc.next();
            
            if (n.equalsIgnoreCase("New")) {
                System.out.println("Create login credentials");
                System.out.println("Enter Username:");
                String username = sc.next();
                
                System.out.println("Enter Password:");
                String password = sc.next();
                int m = ad.insert(username, password);
                String res = (m > 0) ? "Saved" : "Not Saved";
                System.out.println(res);
            } 
            
            if (n.equalsIgnoreCase("Management")) {
                System.out.println("ADMIN details:");
                ad.select();
                System.out.println("STUDENT details:");
                s.select();
            } 
            
            if (n.equalsIgnoreCase("Existing")) {
                System.out.println("Enter Username:");
                String username = sc.next();
                System.out.println("Enter Password:");
                String password = sc.next();
                
                if (ad.search(username, password)) {
                    System.out.println("Login Success");
                } else {
                    System.out.println("Invalid Username or Password.");
                    break;
                }
                
                while (true) {
                    System.out.println("Choose any one of the operations:\n1. ADD\n2. VIEW\n3. UPDATE\n4. DELETE\n5. SEARCH BY COURSE\n6. EXIT");
                    int a = sc.nextInt();
                    
                    switch (a) {
                    case 1:
                        System.out.println("Enter Student ID:");
                        int sid = sc.nextInt();
                        
                        System.out.println("Enter Student NAME:");
                        String sname = sc.next();
                        
                        System.out.println("Enter COURSE:");
                        String scourse = sc.next();
                        
                        System.out.println("Enter DATE OF JOIN:");
                        String dateofjoin = sc.next();
                        
                        System.out.println("Enter DEPARTMENT:");
                        String department = sc.next();
                        
                        System.out.println("Enter STREAM:");
                        String stream = sc.next();
                        
                        System.out.println("Enter MARKS:");
                        int marks = sc.nextInt();
                        
                        int m = s.insert(sid, sname, scourse, dateofjoin, department, stream, marks);
                        String res = (m > 0) ? "Values Inserted" : "Values Not Inserted";
                        System.out.println(res);
                        break;
                        
                    case 2:
                        s.select();
                        break;
                        
                    case 3:
                        System.out.println("Enter Student ID whose record to be updated:");
                        int sidUpdate = sc.nextInt();
                        
                        System.out.println("Enter Student NAME:");
                        String snameUpdate = sc.next();
                        
                        System.out.println("Enter updated COURSE:");
                        String scourseUpdate = sc.next();
                        
                        System.out.println("Enter updated DEPARTMENT:");
                        String departmentUpdate = sc.next();
                        
                        System.out.println("Enter updated STREAM:");
                        String streamUpdate = sc.next();
                        
                        System.out.println("Enter updated MARKS:");
                        int marksUpdate = sc.nextInt();
                        
                        int updateRes = s.update(sidUpdate, snameUpdate, scourseUpdate, departmentUpdate, streamUpdate, marksUpdate);
                        String updateMsg = (updateRes > 0) ? "Values Updated" : "Values Not Updated";
                        System.out.println(updateMsg);
                        break;
                        
                    case 4:
                        System.out.println("Enter Student ID whose record to be deleted:");
                        int sidDelete = sc.nextInt();
                        
                        System.out.println("Enter Student NAME:");
                        String snameDelete = sc.next();
                        
                        int deleteRes = s.delete(sidDelete, snameDelete);
                        String deleteMsg = (deleteRes > 0) ? "Values Deleted" : "Values Not Deleted";
                        System.out.println(deleteMsg);
                        break;
                        
                    case 5:
                        System.out.println("Enter COURSE:");
                        String scourseSearch = sc.next();
                        s.selectByCourse(scourseSearch);
                        break;
                        
                    case 6:
                        System.out.println("APP CLOSED");
                        return;
                        
                    default:
                        System.out.println("Invalid Option! Please try again.");
                    }
                }
            }
            break;
            
        default:
            System.out.println("Invalid Login Option!");
        }
        sc.close();
    }
}
