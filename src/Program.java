import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import models.entities.Reservation;
import models.exceptions.DomainException;

public class Program {
    public static void main(String[] args){
        
        Locale.setDefault(Locale.US);
        Scanner tec = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try{
            System.out.print("Room number: ");
            int roomNumber = Integer.parseInt(tec.nextLine());

            System.out.print("Check-in date (dd/MM/yyyy): ");
            Date checkIn = sdf.parse(tec.nextLine());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            Date checkOut = sdf.parse(tec.nextLine());

            Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println("\nEnter data to update the reservation:");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkIn = sdf.parse(tec.nextLine());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkOut = sdf.parse(tec.nextLine());

            reservation.updateDates(checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

        }catch(ParseException e){
            System.out.println("Invalid date format");
        }catch(DomainException e){
            System.out.println("Error in reservation: " + e.getMessage());
        }catch(RuntimeException e){
            System.out.println("Unexpected error");
        }

        tec.close();
    }
}
