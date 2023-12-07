package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Main {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date now = new Date();
		try {
			System.out.println("ROOM NUMBER: ");
			int number = sc.nextInt();
			System.out.println("Check-in Date: ");
			Date checkIn = sdf.parse(sc.next());
			System.out.println("Check-out Date: ");
			Date checkOut = sdf.parse(sc.next());
		
			Reservation reserva = new Reservation(number, checkIn, checkOut);
			System.out.println(reserva);
			System.out.println("It's time to update the dates.");
				
			System.out.println("New check-in date: ");
			checkIn = sdf.parse(sc.next());
			System.out.println("New check-out date: ");
			checkOut = sdf.parse(sc.next());
			
			reserva.updateDates(checkIn, checkOut);
			System.out.println(reserva);
		} catch (ParseException e ) {
			System.out.println("Invalid date format");
		}catch(DomainException e) {
			System.out.println("Errir: " + e.getMessage());
		} catch(RuntimeException e) {
			System.out.println("Erro inesperado: " + e);
		}
			}
	
			
		
		
		}


