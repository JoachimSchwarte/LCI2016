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
import java.util.HashMap;
import org.junit.Test;
import de.unistuttgart.iwb.lci.*;

public class ProzessmodulTest {

	@SuppressWarnings("unused")
	@Test
	public void test() {
		Fluss F1 = new Fluss("A", FlussTyp.Elementar, FlussEinheit.kg);
		Fluss F2 = new Fluss("B", FlussTyp.Elementar, FlussEinheit.kg);
		Fluss F3 = new Fluss("C", FlussTyp.Elementar, FlussEinheit.kg);
		Fluss F4 = new Fluss("D", FlussTyp.Elementar, FlussEinheit.g);
		Fluss F5 = new Fluss("X", FlussTyp.Produkt, FlussEinheit.kg);
		Fluss F6 = new Fluss("Y", FlussTyp.Produkt, FlussEinheit.kg);
		Fluss F7 = new Fluss("Z", FlussTyp.Produkt, FlussEinheit.Stk);
		Prozessmodul Modul1 = new Prozessmodul();
		Modul1.addFluss(F1, 50.);
		Modul1.addFluss(F3, -300.);
		Modul1.addFluss(F5, 100.);
		HashMap<Fluss, Double> H1 = Modul1.getElementarflussvektor();
		HashMap<Fluss, Double> H2 = Modul1.getProduktflussvektor();
		assertEquals(2, H1.size());
		assertEquals(1, H2.size());		
	}
}
