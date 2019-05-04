package Transfers;

public class TAccessory extends TProduct {
	
	private String _brand;
	private String _color;

	public TAccessory(String name, Integer stock, Double pvp, Integer provider, Integer platform, String brand, String color, String desc) {
		super(name, stock, pvp, TProduct.accessory, provider, platform, desc);
		this.set_brand(brand);
		this.set_color(color);
	}

	public TAccessory() {
		super();
	}

	public String get_brand() {
		return _brand;
	}

	public void set_brand(String _brand) {
		this._brand = _brand;
	}

	public String get_color() {
		return _color;
	}

	public void set_color(String _color) {
		this._color = _color;
	}

}
