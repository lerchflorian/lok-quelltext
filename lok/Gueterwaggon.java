package lok;

public class Gueterwaggon {

	private final float max;
	private final float leer;
	private float gewicht;

	public Gueterwaggon(float leergewichtKg, float max) {
		this.leer = leergewichtKg;
		this.max = max;
		this.gewicht = 0;
	}

	public boolean fuegeHinzuGut(float kg) {
		boolean result = false;
		if (this.gewicht + kg <= max) {
			this.gewicht += kg;
			result = true;
			System.out.println("Gut mit "+kg+"kg hinzugefügt");
		} else {
			System.out.println("Fehler: Gut mit "+kg+"kg kann nicht hinzugefügt werden, da das max. Gewicht überschritten werden würde!");
		}
		return result;
	}

	public float getMaxKg() {
		return max;
	}

	public float getLeergewichtKg() {
		return leer;
	}

	public float liefereGewichtKg() {
		return leer+gewicht;
	}

}
