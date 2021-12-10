package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class SaveTransaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTransaction;
	@OneToOne
	private UserDetails buyer;
	@OneToOne
	private UserDetails seller;
	@OneToOne
	private Car car;
	private Date date;
	
	public Integer getIdTransaction() {
		return idTransaction;
	}
	public void setIdTransaction(Integer idTransaction) {
		this.idTransaction = idTransaction;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public UserDetails getBuyer() {
		return buyer;
	}
	public void setBuyer(UserDetails buyer) {
		this.buyer = buyer;
	}
	public UserDetails getSeller() {
		return seller;
	}
	public void setSeller(UserDetails seller) {
		this.seller = seller;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	
	

}
