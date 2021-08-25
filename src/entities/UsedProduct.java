package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product {
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Date manufacturedate;
	
	public UsedProduct() {
	}

	public UsedProduct(String name, Double price, Date manufacturedate) {
		super(name, price);
		this.manufacturedate = manufacturedate;
	}

	public Date getManufacturedate() {
		return manufacturedate;
	}

	public void setManufacturedate(Date manufacturedate) {
		this.manufacturedate = manufacturedate;
	}
	@Override
	public String priceTag () {
		return getName() 
				+ " (used) $ "
				+ String.format("%.2f", getPrice())
				+ " (Manufacture date: " 
				+ sdf.format(manufacturedate)
				+ ")";
	}
}
