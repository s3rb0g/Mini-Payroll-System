import java.util.*;
import java.util.Scanner;
public class Payroll {

		static int count;	
	
	public static void main(String [] args) {
		
		int uid; 
		String uname;
		String uposition;
	
		Scanner xd = new Scanner(System.in);
		Pay roll = new Pay();
		
	do {	
		System.out.println("****************************");
		System.out.println("\nPayroll System");
		System.out.println("1 - New Employee");
		System.out.println("2 - Payroll");
		System.out.println("3 - List of Employee");
		System.out.println("4 - Add Overtime");
		System.out.println("5 - Exit");
		
		System.out.print("\nChoose your option: ");
			char press = xd.next().charAt(0);
		System.out.println("****************************");
		
	if (press == '1') {
		System.out.println("\nNew Emloyee Module");
		System.out.println("==================");
		System.out.print("Employee id: ");
			uid = xd.nextInt();
		System.out.print("Name: ");
			uname = xd.next();
		System.out.print("Position: ");
			uposition = xd.next();
				
		roll.setNewEmployee(uid, uname, uposition);
		count++;
		}

	else if (press == '2'){
		System.out.println("\nPayroll Module");
		System.out.println("==============");
		System.out.print("Employee ID: ");
			int eid = xd.nextInt();

		roll.payrollModule(eid);
		}

	else if (press == '3'){
		System.out.println("\nList of Employee Module");
		System.out.println("=======================");
		
		roll.listEmployee();
		}
	
	else if(press == '4'){
		System.out.println("\nAdd Overtime");
		System.out.println("============");
		System.out.print("Enter ID: ");
			int idFind = xd.nextInt();
			
		roll.addOvertime(idFind);
	}
		
	else if (press == '5'){
		System.out.print("\nThank you! Bye!");
		System.exit(0);
		}

	else{
		System.out.println("Invalid input!");
		}
		
}while(true);
}
	
}
