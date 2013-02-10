package lok;

import java.util.ArrayList;
import java.util.List;

public class Personenwaggon {

	private final int max;
	private final float leergewicht;

	private List<String> personen;

	public Personenwaggon(float leergewicht, int maxPersonen) {
		this.leergewicht = leergewicht;
		this.max = maxPersonen;
		this.personen = new ArrayList<String>();
	}

	public boolean fuegeHinzuPerson(String name) {
		boolean result = false;
		if (personen.size() < max) {
			personen.add(name);
			result = true;
			System.out.println("Person \"" + name + "\" hinzugef�gt");
		} else {
			System.out
					.println("Fehler: Person \""
							+ name
							+ "\" kann nicht hinzugef�gt werden, da die max. Personenzahl �berschritten werden w�rde!");
		}

		return result;
	}

	public int getMaxPersonen() {
		return max;
	}

	public float getLeergewicht() {
		return leergewicht;
	}

	public float liefereKg() {
		return leergewicht + personen.size() * 80;
	}

}
