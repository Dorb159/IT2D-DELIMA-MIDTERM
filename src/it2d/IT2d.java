package it2d;

import java.util.Scanner;

public class IT2d {
   

    public static void main(String[] args) {
        String response;
        IT2d employeeManager = new IT2d();

        do {
            Scanner sc=new Scanner(System.in);
            System.out.println("Choose an action:");
            System.out.println("1. ADD Attendace");
            System.out.println("2. VIEW Attendace");
            System.out.println("3. UPDATE Attendace");
            System.out.println("4. DELETE Attendace");
            System.out.println("5. EXIT");
            
            System.out.print("Enter action number: ");
            int action = sc.nextInt();
            
            switch (action) {
                case 1:
                    employeeManager.addEmployee();
                    break;
                case 2:
                    employeeManager.viewEmployees();
                    break;  
                case 3:
                    employeeManager.viewEmployees();
                    employeeManager.updateEmployee();
                    employeeManager.viewEmployees();
                    break;
                case 4:
                    employeeManager.viewEmployees();
                    employeeManager.deleteEmployee();
                    employeeManager.viewEmployees();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }

            System.out.print("Do you want to continue? (yes or no): ");
            response = sc.next();

        } while (response.equalsIgnoreCase("yes"));
        
        System.out.println("Thank you, see you!");
       
    }

    public void addEmployee() {
        Scanner sc = new Scanner(System.in);
       
        System.out.print("Attendace ID: ");
        String fname = sc.next();
        System.out.print("Date: ");
        String lname = sc.next();
        System.out.print("Status: ");
        String email = sc.next();
        System.out.print("Remarkst: ");
        String status = sc.next();

        String sql = "INSERT INTO tbl_Attendance (e_Attendace, e_Date, e_Status, e_Remarks) VALUES (?, ?, ?, ?)";
        config conf = new config();
        conf.addRecord(sql, fname, lname, email, status);
    }

    private void viewEmployees() {
        config conf = new config();
        String query = "SELECT * FROM tbl_Attendance";
        String[] headers = {"ID", "Attendance", "Date", "Status", "Remarks"};
        String[] columns = {"e_id", "e_Attendance", "e_Date", "e_Status", "e_Remarks"};

        conf.viewRecords(query, headers, columns);
    }

    private void updateEmployee() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the ID to update: ");
        int id = sc.nextInt();

        System.out.print("Change Attendance: ");
        String nfname = sc.next();
        System.out.print("Change Date: ");
        String nlname = sc.next();
        System.out.print("Change Status: ");
        String nemail = sc.next();
        System.out.print("New Remarks: ");
        String nstatus = sc.next();

        String qry = "UPDATE tbl_Attendance SET e_ID = ?, e_Attendance = ?, e_Date = ?, e_Status = ? WHERE e_Remarks = ?";
        config conf = new config();
        conf.updateRecord(qry, nfname, nlname, nemail, nstatus, id); 
    }

    private void deleteEmployee() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the ID to delete: ");
        int id = sc.nextInt();

        String qry = "DELETE FROM tbl_Attendance WHERE e_id = ?";
        config conf = new config();
        conf.deleteRecord(qry, id);
    }
}

