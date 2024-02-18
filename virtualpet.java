import java.util.Scanner;
import java.io.*;

public class virtualpet implements java.io.Serializable{
public String petname;
public String petkind;
public int petage;
public String petfavfood;

public static void main(String [] args){
virtualpet perfectvirtualpet = new virtualpet();
perfectvirtualpet.printpetname();
perfectvirtualpet.printpetkind();
perfectvirtualpet.printpetage();
perfectvirtualpet.printpetfavfood();

perfectvirtualpet.petnamechange();
perfectvirtualpet.petkindchange();
perfectvirtualpet.petdob();
perfectvirtualpet.petfavfoodchange();
perfectvirtualpet.savepet();
}

public virtualpet(){
Scanner scannerReader = new Scanner(System.in);
System.out.println("Do you want to open a saved pet? Y/N");
if((scannerReader.next()).equals("Y")){

try{
FileInputStream inputfile = new FileInputStream("perfectvirtualpetserialized.ser");
ObjectInputStream input = new ObjectInputStream(inputfile);
virtualpet perfectvirtualpet = (virtualpet)input.readObject();
inputfile.close();
input.close();

this.petname = perfectvirtualpet.petname;
this.petkind = perfectvirtualpet.petkind;
this.petage = perfectvirtualpet.petage;
this.petfavfood = perfectvirtualpet.petfavfood;
}

catch(Exception e){
System.out.println(e.getMessage());
}
}

else{
System.out.println("What did you named your pet?");
this.petname = scannerReader.next();
System.out.println("What kind of pet do you have?");
this.petkind = scannerReader.next();
System.out.println("What's your pet's age?");
this.petage = scannerReader.nextInt();
System.out.println("What's your pet's favourite food?");
this.petfavfood = scannerReader.next();
}
}

public void printpetname(){
System.out.println("Your pet is called : " + petname);
}
public void printpetkind(){
System.out.println("Your pet kind is : " + petkind);
}
public void printpetage(){
System.out.println("Yor pet's age is : " + petage);
}
public void printpetfavfood(){
System.out.println("Your pet's fav food is : " + petfavfood);
}

public void petnamechange(){
Scanner scannerReader = new Scanner(System.in);
System.out.println("Do you want to change your pet's name? Y/N");
if ((scannerReader.next()).equals("Y")){
System.out.println("Please enter your pet's new name");
this.petname = scannerReader.next();
System.out.println("Your pet's new name is: " + petname);
}
else{
System.out.println("The current name is just perfect");
}
}

public void petkindchange(){
Scanner scannerReader = new Scanner(System.in);
System.out.println("Do you want to change your pet's kind? Y/N");
if ((scannerReader.next()).equals("Y")){
System.out.println("Please enter your pet's new kind");
this.petkind = scannerReader.next();
System.out.println("Your pet's new kind is: " + petkind);
}
else{
System.out.println("The current kind is just perfect");
}
}

public void petdob(){
Scanner scannerReader = new Scanner(System.in);
System.out.println("Did you celebrate your pet's birthday recently? Y/N");
if ((scannerReader.next()).equals("Y")){
petage += 1;
System.out.println("Happy Birthday!!!!");
this.printpetage();
}
else{
System.out.println("Oh I wish them happy birthday in advance");
}
}

public void petfavfoodchange(){
Scanner scannerReader = new Scanner(System.in);
System.out.println("Do you want to change your pet's favourite food? Y/N");
if ((scannerReader.next()).equals("Y")){
System.out.println("Please enter your pet's new favourite food");
this.petfavfood = scannerReader.next();
System.out.println("Your pet's new kind is: " + petfavfood);
}
else{
System.out.println("Oh I like his choice");
}
}

public void savepet(){
System.out.println("Would you like to save? Y/N");
Scanner scannerReader = new Scanner(System.in);
if((scannerReader.next()).equals("Y")){

try{
FileOutputStream outputFile = new FileOutputStream("perfectvirtualpetserialized.ser");
ObjectOutputStream output = new ObjectOutputStream(outputFile);
output.writeObject(this);
outputFile.close();
output.close();
System.out.println("You have sucesfully saved");
}

catch(Exception e){
System.out.println(e.getMessage());
}
}

else{
System.out.println("You have not saved your pet yet");
}
}
}

