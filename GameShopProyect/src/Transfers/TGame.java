package Transfers;

public class TGame extends TProduct {

	private String _gender;
	
	public TGame(String name, Integer stock, Double pvp, Integer provider, Integer platform, String description, String gender) {
		super(name, stock, pvp, TProduct.game, provider, platform, description);
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

}
