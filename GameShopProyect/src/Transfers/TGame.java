package Transfers;

public class TGame extends TProduct {

	private String _gender;
	private String _description;
	
	public TGame(String name, Integer stock, Double pvp, Integer provider, Integer platform, String description, String gender) {
		super(name, stock, pvp, TProduct.game, provider, platform);
		this._description = description;
		this._gender = gender;
	}

	public TGame() {
		super();
	}

	public String get_gender() {
		return _gender;
	}

	public void set_gender(String _gender) {
		this._gender = _gender;
	}

	public String get_description() {
		return _description;
	}

	public void set_description(String _description) {
		this._description = _description;
	}

}
