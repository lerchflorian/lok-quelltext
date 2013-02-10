package lok;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Lokomotive {

	private static final int STATUS_HAELT = 0;
	private static final int STATUS_FAEHRT = 1;

	private final float zugkraftKg; 
	private int lokStatus; 
	private String lokfuehrerName;
	private String lokfuehrerId;
	private Date lokfuehrerSeit;
	private final List<Object> waggons; 

	public Lokomotive(float zugkraft) {
		this.zugkraftKg = zugkraft;
		this.waggons = new ArrayList<Object>();
		this.lokStatus = STATUS_HAELT;
	}

	public void losfahren() {
		if (this.lokStatus == STATUS_HAELT) {
			if (lokfuehrerName != null) {

				float gewicht = 0;
				for (Object w : waggons) {
					if (w instanceof Gueterwaggon) {
						gewicht += ((Gueterwaggon) w).liefereGewichtKg();
					} else if (w instanceof Personenwaggon) {
						gewicht += ((Personenwaggon) w).liefereKg();
					} else if (w instanceof Viehwaggon) {
						gewicht += ((Viehwaggon) w).liefereKg();
					}// if else
				}// for

				if (gewicht <= zugkraftKg) {
					this.lokStatus = STATUS_FAEHRT;
					System.out.println("Die Lok fährt los! Die Last betraegt "
							+ gewicht + "kg");
				} else {
					System.out
							.println("Fehler: Lokomotive kann nicht losfahren, da die Waggons zu schwer sind. Es müssen Waggons abgekoppelt werden!");
				} // if else

			} else {
				System.out.println("Fehler: Kein Lokfuehrer vorhanden!");
			}// if else
		} else {
			System.out.println("Die Lok faehrt bereits!");
		}// if else

	}// losfahren

	public void anhalten() {
		if (this.lokStatus == STATUS_FAEHRT) {
			this.lokStatus = STATUS_HAELT;
			System.out.println("Die Lok hält an");
		} else {
			System.out.println("Die Lok steht bereits!");
		}
	}// anhalten

	public void ankoppelnGueter(Gueterwaggon g) {
		if (this.lokStatus == STATUS_HAELT) {
			if (!this.waggons.contains(g))
				this.waggons.add(g);
		} else {
			System.out
					.println("Fehler: Waggons können nur angekoppelt werden, wenn die Lok steht!");
		}
	}// ankoppelnGueter

	public void ankoppelnPerso(Personenwaggon p) {
		if (this.lokStatus == STATUS_HAELT) {
			if (!this.waggons.contains(p))
				this.waggons.add(p);
		} else {
			System.out
					.println("Fehler: Waggons können nur angekoppelt werden, wenn die Lok steht!");
		}
	}// ankoppelnPerso

	public void ankoppelnVieh(Viehwaggon v) {
		if (this.lokStatus == STATUS_HAELT) {
			if (!this.waggons.contains(v))
				this.waggons.add(v);
		} else {
			System.out
					.println("Fehler: Waggons können nur angekoppelt werden, wenn die Lok steht!");
		}
	}// ankoppelnVieh

	public void ankoppelnKipp(Kippwaggon v) {
		if (this.lokStatus == STATUS_HAELT) {
			if (!this.waggons.contains(v))
				this.waggons.add(v);
		} else {
			System.out
					.println("Fehler: Waggons können nur angekoppelt werden, wenn die Lok steht!");
		}
	}// ankoppelnKipp

	public void abkoppelnGueter(Gueterwaggon g) {
		if (this.lokStatus == STATUS_HAELT) {
			this.waggons.remove(g);
		} else {
			System.out
					.println("Fehler: Waggons können nur abgekoppelt werden, wenn die Lok steht!");
		}

	}// abkoppelnGueter

	public void abkoppelnPerso(Personenwaggon p) {
		if (this.lokStatus == STATUS_HAELT) {
			this.waggons.remove(p);
		} else {
			System.out
					.println("Fehler: Waggons können nur abgekoppelt werden, wenn die Lok steht!");
		}
	}// abkoppelnPerso

	public void abkoppelnVieh(Viehwaggon v) {
		if (this.lokStatus == STATUS_HAELT) {
			this.waggons.remove(v);
		} else {
			System.out
					.println("Fehler: Waggons können nur abgekoppelt werden, wenn die Lok steht!");
		}
	}// abkoppelnVieh

	public void abkoppelnKipp(Kippwaggon v) {
		if (this.lokStatus == STATUS_HAELT) {
			this.waggons.remove(v);
		} else {
			System.out
					.println("Fehler: Waggons können nur abgekoppelt werden, wenn die Lok steht!");
		}
	}// abkoppelnKipp

	public void lokfuehrerSteigtEin(String name, String lokfuehrerId,
			Date lokfuehrerSeit) {
		//lokfuehrer steigt ein
		this.lokfuehrerName = name;
		this.lokfuehrerId = lokfuehrerId;
		this.lokfuehrerSeit = lokfuehrerSeit;
	}// lokfuehrerSteigtEin

	public void lokfuehrerSteigtAus() {
		this.lokfuehrerName = null;
		this.lokfuehrerId = null;
		this.lokfuehrerSeit = null;
	}// lokfuehrerSteigtAus

	public float getZugkraftKg() {
		return zugkraftKg;
	}// getZugkraftKg

	public String getLokfuehrerName() {
		return lokfuehrerName;
	}// getLokfuehrerName

}
