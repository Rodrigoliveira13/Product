package entities;

public class ImportedProduct extends Product {

	private Double customsFree;

	public ImportedProduct() {
		
	}
	
	public ImportedProduct(String name, Double price, Double customsFree) {
		super(name, price);
		this.customsFree = customsFree;
	}

	public Double getCustomsFree() {
		return customsFree;
	}

	public void setCustomsFree(Double customsFree) {
		this.customsFree = customsFree;
	}
	
	public double totalPrice() {
		return getPrice() + customsFree;
	}
	
	@Override
	public String priceTag () {
		return getName() 
				+ " (used) $ "
				+ String.format("%.2f", totalPrice())
				+ " (Customs fee: $ " 
				+ String.format("%.2f", customsFree)
				+ ")";
	}

}
