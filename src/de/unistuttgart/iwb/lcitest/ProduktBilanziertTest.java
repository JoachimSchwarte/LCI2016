/*	
 * Beispielprojekt / Wirkungsabschätzung
 * Sommersemester 2017
 */

package de.unistuttgart.iwb.lcitest;

/**
 * @author Dr.-Ing. Joachim Schwarte
 * @version 0.911
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
	Bewertungsmethode BM1 = new Bewertungsmethode("TestMethode1");
	Bewertungsmethode BM2 = new Bewertungsmethode("TestMethode2");
	ProduktBilanziert PB1 = new ProduktBilanziert("TestProdukt1");

	@Test
	public void test() {
		BM1.addFaktor(C11);
		BM1.addFaktor(C22);
		BM1.addFaktor(C33);
		BM1.addFaktor(C12);
		BM1.addFaktor(C23);
		BM2.addFaktor(C12);
		BM2.addFaktor(C22);
		assertEquals(BM1.kategorieListe().size(), 3);
		assertEquals(BM2.kategorieListe().size(), 1);
		assertEquals(W1.getName(), "Klimawandel");
		assertEquals(PB1.getName(), "TestProdukt1");
		PB1.addWirkung(W1, 3.);
		PB1.addWirkung(W2, 5.);
		PB1.addWirkung(W3, 7.);
		assertEquals(PB1.getWirkungsvektor(BM1).size(), 3);
		assertEquals(PB1.getWirkungsvektor(BM2).size(), 1);
		assertEquals(PB1.getWirkungsvektor(BM1).get(W2), 5., .001);
	}
	
}
