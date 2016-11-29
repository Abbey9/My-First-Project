import java.util.Scanner;

//This class shows basic details related to a Bank Account

class BankAccount{
int accountno;
int amt;

//This is a constructor initialises the instance variables

BankAccount(int accountno,int amt){
this.accountno=accountno;
this.amt=amt;
 }
 
//This is a instance Method calculates total balance after the required amount is withdrawn 
void withdraw(){
Scanner sc=new Scanner(System.in);
System.out.println("Enter the amount you want to withdraw:");
this.amt=this.amt-sc.nextInt();

}
//This is a instance Method calculates total balance after the required amount is deposited.
void deposit(){
Scanner sc=new Scanner(System.in);
System.out.println("Enter the amount you want to deposit:");
this.amt=this.amt+sc.nextInt();
}
//This shows the Total Balance in the Bank Account
void showAmtDetails(){
System.out.println("Total amount is :"+amt);
}
//This method shows interest rate for one year
public int getRateOfInterest(){
	return 1;
 }
}

class Credit{
	//Here we are passing object ac of BankAccount class to the method
	public static void addInterest(BankAccount ac){
	int rate=ac.getRateOfInterest();
	ac.amt+=(ac.amt*rate*1)/100;
 }
}

class SavingAccount extends BankAccount{

SavingAccount(int accno, int balance){	
super(accno, balance);
 }		
}

class CurrentAccount extends BankAccount{

CurrentAccount(int accno,int balance){
super(accno,balance);
 }
}

class BankApplication{
public static void main(String args[]){
Scanner sc=new Scanner(System.in);
System.out.println("Welcome to the Bank\n");
System.out.println("***************************");
System.out.println("\nEnter the Account Number:");
int acno=sc.nextInt();
System.out.println("Enter the Balance Amount:");
int bal=sc.nextInt();
System.out.println("Enter your Account Pin: 1 for Savings Account and 2 for Current Account");
int pin=sc.nextInt();
System.out.println("Enter the option: Press 2 to Withdraw (to draw the money) or Press 1 Deposit(to deposit the money)");
int n=sc.nextInt();

switch(pin){
case 1: System.out.println("You selected Savings Account");
        SavingAccount sac=new SavingAccount(acno,bal); 
		System.out.println("Interest is addded for a year");
		Credit.addInterest(sac);
        sac.showAmtDetails();
		System.out.println("****************************");
        switch(n){
	    case 1: 
		  sac.deposit();
          sac.showAmtDetails();
		  break;
		
        case 2:
          sac.withdraw();
          sac.showAmtDetails();
		  break;
		
		default: System.out.println("Option invalid"); 
		  break;
        }
		break;
		
       
case 2: System.out.println("You selected Current Account");
        CurrentAccount cac=new CurrentAccount(acno,bal);
        System.out.println("Interest  is added for a year");
		Credit.addInterest(cac);
        cac.showAmtDetails();
		System.out.println("******************************");
		switch(n){
       
		case 1:
		 cac.deposit();
         cac.showAmtDetails();
		 break;
		
		case 2:
         cac.withdraw();
         cac.showAmtDetails();
		 break;
		
		default: 
		System.out.println("Option invalid");
		break;
		}
      
	  break;  
        
default: System.out.println("Your invalid account");
         break;
}

 }	
}
