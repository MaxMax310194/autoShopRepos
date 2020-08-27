package model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class RegAuto {

	private int idAuto;
	//@NotEmpty
	private String image;
	@NotEmpty
	@Size (max = 15 )
	private String nameAuto;
	@NotEmpty
	private String info;

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
	public RegAuto() {
		super();
	}
	public RegAuto(String image, String nameAuto, String info, double price) {
		super();
		this.image = image;
		this.nameAuto = nameAuto;
		this.info = info;
		this.price = price;
	}
	public RegAuto(int idAuto, String image, String nameAuto, String info, double price) {
		super();
		this.idAuto = idAuto;
		this.image = image;
		this.nameAuto = nameAuto;
		this.info = info;
		this.price = price;
	}
	@Override
	public String toString() {
		return "RegAuto [idAuto=" + idAuto + ", image=" + image + ", nameAuto=" + nameAuto + ", info=" + info
				+ ", price=" + price + "]";
	}
	
	
	
}
