import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import models.entities.Reservation;

public class Program {
    public static void main(String[] args) throws ParseException {
        
        Locale.setDefault(Locale.US);
        Scanner tec = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room number: ");
        int roomNumber = Integer.parseInt(tec.nextLine());

        System.out.print("Check-in date (dd/MM/yyyy): ");
        Date checkIn = sdf.parse(tec.nextLine());
        System.out.print("Check-out date (dd/MM/yyyy): ");
        Date checkOut = sdf.parse(tec.nextLine());


        if (!checkOut.after(checkIn)){
            System.out.println("Error in reservation: Check-out date must be after check-in date");
        }else{
            Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println("\nEnter data to update the reservation:");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkIn = sdf.parse(tec.nextLine());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkOut = sdf.parse(tec.nextLine());


            String error = reservation.updateDates(checkIn, checkOut);

            if (error != null){
                System.out.println("Error in reservation: " + error);
            }else{
                System.out.println("Reservation: " + reservation);
            }
           

            
        }

       

        tec.close();
    }
}
