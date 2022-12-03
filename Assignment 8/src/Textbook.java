public class Textbook {

	public int sku;
	public String title;
	public double price;
	public int quantity;
	public Textbook left;
	public Textbook right;

	public Textbook(int sku) {
		this.sku = sku;
		title = "";
		price = 0;
		quantity = 0;
		left = right = null;

	}

	public void setSKU(int sku) {
		this.sku = sku;
	}

	public int getSKU() {
		return sku;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

}