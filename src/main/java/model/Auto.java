package model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "auto")
public class Auto {

	@Id
	@GeneratedValue
	@Column(name="idAuto")
	private int idAuto;
	@Column(name="image")
	private String image;
	@Column(name="nameAuto")
	private String nameAuto;
	@Column(name="info")
	private String info;
	@Column(name="price")
	private double price;
	public int getIdAuto() {
		return idAuto;
	}
	public void setIdAuto(int idAuto) {
		this.idAuto = idAuto;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getNameAuto() {
		return nameAuto;
	}
	public void setNameAuto(String nameAuto) {
		this.nameAuto = nameAuto;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Auto() {
		super();
	}
	public Auto(String image, String nameAuto, String info, double price) {
		super();
		this.image = image;
		this.nameAuto = nameAuto;
		this.info = info;
		this.price = price;
	}
	public Auto(int idAuto, String image, String nameAuto, String info, double price) {
		super();
		this.idAuto = idAuto;
		this.image = image;
		this.nameAuto = nameAuto;
		this.info = info;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Auto [idAuto=" + idAuto + ", image=" + image + ", nameAuto=" + nameAuto + ", info=" + info + ", price="
				+ price + "]";
	}
	

	
	
}
