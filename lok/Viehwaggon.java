package lok;

public class Viehwaggon {

	private final float maxKg;
	private final int maxVieh;
	private final float leer;
	private float kg;
	private int vieh;

	public Viehwaggon(float leergewicht, float maxKg, int maxVieh) {
		this.leer = leergewicht;
		this.maxKg = maxKg;
		this.maxVieh = maxVieh;
		this.kg = 0;
		this.vieh = 0;
	}

	public boolean fuegeHinzuVieh(float kg) {
		boolean result = false;
		if ((this.kg + kg <= maxKg) && (this.vieh + 1 <= this.maxVieh)) {
			this.kg += kg;
			this.vieh++;
			result = true;
			System.out.println(this.vieh +". Vieh mit "+kg+"kg hinzugef�gt");
		} else {
			System.out.println("Fehler: Vieh mit "+kg+"kg kann nicht hinzugef�gt werden, da entweder das max. Gewicht oder die max. Viehanzahl �berschritten werden w�rde!");
		}
		return result;
	}

	public float getMaxKg() {
		return maxKg;
	}

	public int getMaxVieh() {
		return maxVieh;
	}

	public float getLeergewicht() {
		return leer;
	}

	public float liefereKg() {
		return leer+kg;
	}

}
