/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import entities.Departament;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author dypad
 */
public class Program {


    public static void main(String[] args) throws ParseException {
       
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        System.out.println("Enter departament's name:");
        String departamentName = sc.next();
        System.out.println("Enter worker data:");
        System.out.println("Enter worker name: ");
        String workerName = sc.next();
        System.out.println("Level:");
        String workerLevel = sc.next();
        System.out.println("Base salary: ");
        double baseSalary = sc.nextDouble();
        
        Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), 
                baseSalary, new Departament(departamentName));
        
        System.out.println("How many contracts to this worker? ");
        int n = sc.nextInt();
        
        for (int i=1; i<=n; i++){
            System.out.println("Enter contract number #"+ i + "data:");
            System.out.print("Date (DD/MM/YYYY): ");
            Date contractDate = sdf.parse(sc.next());
            System.out.println("Value per hour:");
            double valuePerHour = sc.nextDouble();
            System.out.println("Duration(Hours):");
            int hour = sc.nextInt();
            HourContract contract = new HourContract(contractDate, valuePerHour, hour);
            worker.addContracts(contract);
            
        }
        
        System.out.println();
        System.out.println("Enter month and year to calculator the income:(MM/YYYY)");
        String monthAndYear = sc.next();
        int month = Integer.parseInt(monthAndYear.substring(0, 2));
        int year = Integer.parseInt(monthAndYear.substring(3));
        
        System.out.println("Name: "+ worker.getName());
        System.out.println("Departament: "+ worker.getDepartament().getName());
        System.out.println("Income for: "+ monthAndYear+":"+String.format("%.2f",worker.income(year, month)));
        
        
        
        
        
        sc.close();
    }
    
}
