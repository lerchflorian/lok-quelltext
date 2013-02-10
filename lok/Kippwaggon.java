package lok;

public class Kippwaggon {

	private final float maxKg;
	private final float leergewichtKg;
	private float kg;
	private boolean gekippt;

	/**
	 * @param maxKg
	 * @param leergewichtKg
	 * @param kg
	 */
	public Kippwaggon(float maxKg, float leergewichtKg) {
		super();
		this.maxKg = maxKg;
		this.leergewichtKg = leergewichtKg;
		this.kg = 0;
		this.gekippt = false;
	}// constructor

	public boolean beladen(float kg) {
		boolean result = false;
		if (this.isGekippt()) {
			System.out
					.println("Fehler: Beladung nicht m�glich, da der Waggon noch gekippt ist!");
		} else {
			if (this.kg + kg <= maxKg) {

				this.kg += kg;
				result = true;
				System.out.println("Weitere " + kg
						+ "kg der Ladung hinzugef�gt.");
			} else {
				System.out
						.println("Fehler: Beladung von "
								+ kg
								+ "kg kann nicht hinzugef�gt werden, da das max. Gewicht �berschritten werden w�rde!");
			}// if else
		}// if
		return result;
	}// beladen

	public void kippen() {
		this.kg = 0;
		this.gekippt = true;
	}// kippen

	/**
	 * Aufrichten der Beladefl�che. Damit ist der Kippwaggon bereit, neu beladen
	 * zu werden.
	 */
	public void aufrichten() {
		this.gekippt = false;
	}// aufrichten

	public boolean isGekippt() {
		return this.gekippt;
	}// isGekippt

	/**
	 * @return the leergewichtKg
	 */
	public float getLeergewichtKg() {
		return leergewichtKg;
	}// getLeergewichtKg

}// class
