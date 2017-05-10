/*	
 * Beispielprojekt / Wirkungsabschätzung
 * Sommersemester 2017
 */

package de.unistuttgart.iwb.lcitest;

/**
 * @author Dr.-Ing. Joachim Schwarte
 * @version 0.910
 */

import static org.junit.Assert.*;
import org.junit.Test;
import de.unistuttgart.iwb.lci.*;

public class ProduktBilanziertTest {
	
	Wirkungskategorie W1 = new Wirkungskategorie("Klimawandel", Wirkungsindikator.kgCO2Aeqv);
	Wirkungskategorie W2 = new Wirkungskategorie("Versauerung", Wirkungsindikator.kgSO2Aeqv);
	Wirkungskategorie W3 = new Wirkungskategorie("Ozonloch", Wirkungsindikator.kgR11Aeqv);
	Fluss F1 = new Fluss("A", FlussTyp.Elementar, FlussEinheit.kg);
	Fluss F2 = new Fluss("B", FlussTyp.Elementar, FlussEinheit.kg);
	Fluss F3 = new Fluss("C", FlussTyp.Elementar, FlussEinheit.kg);
	CharakterFaktor C11 = new CharakterFaktor("c11", F1, W1, 1.);
	CharakterFaktor C22 = new CharakterFaktor("c22", F2, W2, 1.);
	CharakterFaktor C33 = new CharakterFaktor("c33", F3, W3, 1.);
	CharakterFaktor C12 = new CharakterFaktor("c12", F1, W2, 0.15);
	CharakterFaktor C23 = new CharakterFaktor("c23", F2, W3, 0.25);
	Bewertungsmethode BM = new Bewertungsmethode("TestMethode");

	@Test
	public void test() {
		BM.addFaktor(C11);
		BM.addFaktor(C22);
		BM.addFaktor(C33);
		BM.addFaktor(C12);
		BM.addFaktor(C23);
		assertEquals(BM.kategorieListe().size(), 3);		
	}
	
}
