import java.util.ArrayList;
import java.util.Scanner;
class Pay extends Payroll {

	static Scanner xd = new Scanner(System.in);
		
	static ArrayList<String> NAME = new ArrayList<>();
	static ArrayList<String> POSITION = new ArrayList <>();
	static ArrayList<Integer> ID = new ArrayList <>();
	static ArrayList<Double> GROSS = new ArrayList<>();

	static double taxDeduct = 0.05;
	static int index = 0;

	public static void setNewEmployee(int id, String name, String position){	

	ID.add(id);	
	NAME.add(name);
	POSITION.add(position);
	GROSS.add(0.0);
	
	}

	public static void payrollModule(int newid){
			
	if (ID.contains(newid)){
		System.out.println("Record Found!");
		verifyPosition(newid);	
		index -= index;	
			
	}
	else{
		System.out.println("\nRecord not Found!");
	}
	}
	
	public static void verifyPosition(int Id){	
	double posValue;
	do{
	if (Id == ID.get(index)){
		System.out.println("\nId: " + ID.get(index));
		System.out.println("Name: " + NAME.get(index));
		System.out.println("Position: " + POSITION.get(index));
		
			if("manager".equalsIgnoreCase(POSITION.get(index))){
				posValue = 1500.0;
			}
			else if("supervisor".equalsIgnoreCase(POSITION.get(index))){
				posValue = 1000.0;
			}
			else if("staff".equalsIgnoreCase(POSITION.get(index))){
				posValue = 600.0;
			}
			else{
				System.out.println("\nInvalid position!");
				break;
			}
				
		computePayroll(posValue);
		break;
	}
	else{
		index++;
	}
	}while(true);
	
	}
	
	public static void computePayroll(double posVal){
	double gross, tax, net;
			
		System.out.print("\nEnter days works: ");
		double dayWork = xd.nextInt();
		
		gross = comGrossPay(posVal, dayWork);
		System.out.println("\nGross Pay: " + gross);
		
		tax = comTax(gross);
		System.out.println("Tax: " + tax);
		
		net = comNetPay(gross, tax);
		System.out.println("Net Pay: " + net);
		
		GROSS.set(index, net);
	}
	
	public static void listEmployee(){	
	int no = 1;
		for (int i = 0; i < count; i++){
			System.out.println(no +". "+ ID.get(i) +" "+ NAME.get(i) +" "+ POSITION.get(i));		
			no++;
		}
	}
	
	public static void addOvertime(int newFindId){
				
		if (ID.contains(newFindId)){
			System.out.println("Record Found!");
			findPosition(newFindId);
			index -= index;
		}
		else{
			System.out.println("\nRecord not Found!");
		}
	}
	
	public static void findPosition(int findId){
	double posValue;
	double posGross;
	do{
		if (findId == ID.get(index)){
			System.out.println("\nId: " + ID.get(index));
			System.out.println("Name: " + NAME.get(index));
			System.out.println("Position: " + POSITION.get(index));	
			
				if("manager".equalsIgnoreCase(POSITION.get(index))){
					posValue = 1500.0;
				}
				else if("supervisor".equalsIgnoreCase(POSITION.get(index))){
					posValue = 1000.0;
				}
				else if("staff".equalsIgnoreCase(POSITION.get(index))){
					posValue = 600.0;
				}
				else{
					System.out.println("\nInvalid position!");
				break;
				}
			
			posGross = GROSS.get(index);
			computeOvertime(posValue, posGross);
			break;
			
		}
		else{
		index++;
		}
	}while(true);
	}
	
	public static void computeOvertime(double posVal, double posGro){
	double perH, payOt, nGross, nTax, nNetPay;
		
		System.out.print("\nEnter overtime hour/s: ");
		double overtime = xd.nextInt();
		
		perH = comHourRate(posVal);
		System.out.println("\nOvertime Rate: " + perH);
		
		payOt = comTotalOvertime(perH, overtime);
		System.out.println("Overtime Pay: " + payOt);
		System.out.println("\nResult:");
		
		nGross = comNewGross(posGro, payOt);
		System.out.println("New Gross Pay: " + nGross);
		
		nTax = comNewTax(nGross);
		System.out.println("New Tax: " + nTax);
		
		nNetPay = comNewNetPay(nGross, nTax);
		System.out.println("New Net Pay: " + nNetPay);
		
	}
	
	public static double comHourRate(double pos){
		double perHour = pos / 8;
		
		return perHour;
	}
	
	public static double comTotalOvertime(double rateH, double oTime){
		double payOvertime = rateH * oTime;
		
		return payOvertime;
	}
	
	public static double comNewGross(double oldGross, double otPay){
		double newGross = oldGross + otPay;
		newGross = Math.round(newGross * 100)/100.0;
		
		return newGross;
	}
		
	public static double comNewTax(double grossNew){
		double newTax = grossNew * taxDeduct;
		newTax = Math.round(newTax * 100)/100.0;
		
		return newTax;	
	}
	
	public static double comNewNetPay(double grossNew, double taxNew){
		double newNet = grossNew - taxNew;
		newNet = Math.round(newNet * 100)/100.0;
		
		return newNet;
	}
	
	
		
	public static double comGrossPay(double valuePos, double day){
		double totalGross = valuePos * day;
		
		return totalGross;
	}
	
	public static double comTax(double gross){
		double totalTax = gross * taxDeduct;
		totalTax = Math.round(totalTax * 100)/100.0;
		
		return totalTax;
	}
	
	public static double comNetPay(double gross, double tax){
		double totalNet = gross - tax;
		totalNet = Math.round(totalNet * 100)/100.0;
		
		return totalNet;
	}
	
}
