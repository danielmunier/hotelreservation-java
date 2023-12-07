package model.entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {
	private Integer number;
	private Date checkin;
	private Date checkout;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	
	public Reservation(Integer number, Date checkin, Date checkout) {
		if(!checkin.after(new Date())) {
			throw new DomainException("Reservation date must occur after the actual date");
		}
			this.number = number;
			this.checkin = checkin;
			this.checkout = checkout;
	}

	
	
	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Date getCheckin() {
		return checkin;
	}

	public Date getCheckout() {
		return checkout;
	}
	
	public long duration() {
		long difference = checkout.getTime() - checkin.getTime();
		return TimeUnit.DAYS.convert(difference, TimeUnit.MILLISECONDS);
	}
	
	public void updateDates(Date checkin, Date checkout) {
		Date now = new Date();
		if(this.checkin.before(now) || this.checkout.before(now)) {
			throw new DomainException("Reservation dates for update must be corrected");
		}
		if(!checkin.after(now)) {
			throw new DomainException("Reservation date must occur after the actual date");
		}
		
		this.checkin = checkin;
		this.checkout = checkout;
		 
	}
	
	@Override
	public String toString() {
		return "Number: "
				+ this.number
				+ "\nCheckin: " + sdf.format(checkin)
				+ "\nCheckout: "+ sdf.format(checkout)
				+ "\nDuration: "+ duration()
				;
	}
	
	
}
