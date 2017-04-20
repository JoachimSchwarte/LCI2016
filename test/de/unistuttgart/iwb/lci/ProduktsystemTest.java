package de.unistuttgart.iwb.lci;
import static org.junit.Assert.*;
import java.util.HashMap;
import java.util.LinkedList;

import org.junit.Test;
public class ProduktsystemTest {
	Fluss F1 = new Fluss("A", FlussTyp.Elementar, FlussEinheit.kg);
	Fluss F2 = new Fluss("B", FlussTyp.Elementar, FlussEinheit.kg);
	Fluss F3 = new Fluss("C", FlussTyp.Elementar, FlussEinheit.kg);
	Fluss F4 = new Fluss("D", FlussTyp.Elementar, FlussEinheit.g);
	Fluss F5 = new Fluss("X", FlussTyp.Produkt, FlussEinheit.kg);
	Fluss F6 = new Fluss("Y", FlussTyp.Produkt, FlussEinheit.kg);
	Fluss F7 = new Fluss("Z", FlussTyp.Produkt, FlussEinheit.Stk);
	Prozessmodul Modul1 = new Prozessmodul();
	Prozessmodul Modul2 = new Prozessmodul();
	Prozessmodul Modul3 = new Prozessmodul();
	private void initialize() {
		Modul1.addFluss(F1, 50.);
		Modul1.addFluss(F3, -300.);
		Modul1.addFluss(F5, 100.);
		Modul2.addFluss(F1, 30.);
		Modul2.addFluss(F2, 15.);
		Modul2.addFluss(F3, -150.);
		Modul2.addFluss(F5, -25.);
		Modul2.addFluss(F6, 100.);
		Modul3.addFluss(F1, 10.);
		Modul3.addFluss(F2, 15.);
		Modul3.addFluss(F4, -5.);
		Modul3.addFluss(F6, -200.);
		Modul3.addFluss(F7, 1.);
	}
	@Test
	public void test1() {
		initialize();
		HashMap<Fluss, Double> f = new HashMap<Fluss, Double>();
		LinkedList<Fluss>vkp = new LinkedList<Fluss>();
		f.put(F7, 1.);
		Produktsystem ProduktZ1 = 
				new Produktsystem("EinsZweiDrei", f, vkp);
		ProduktZ1.addProzessmodul(Modul1);
		ProduktZ1.addProzessmodul(Modul2);
		ProduktZ1.addProzessmodul(Modul3);
		HashMap<Fluss, Double> g = ProduktZ1.getElementarflussvektor();
		assertEquals(95., g.get(F1), 0.01);
		assertEquals(45., g.get(F2), 0.01);
		assertEquals(-450., g.get(F3), 0.01);
		assertEquals(-5., g.get(F4), 0.01);	
	}
	@Test
	public void test2() {
		initialize();
		HashMap<Fluss, Double> f12 = new HashMap<Fluss, Double>();
		LinkedList<Fluss>vkp = new LinkedList<Fluss>();
		f12.put(F6, 100.);
		Produktsystem ProduktY = new Produktsystem("EinsZwei", f12, vkp);
		ProduktY.addProzessmodul(Modul1);
		ProduktY.addProzessmodul(Modul2);
		HashMap<Fluss, Double> f3 = new HashMap<Fluss, Double>();
		f3.put(F7, 1.);
		Produktsystem ProduktZ2 = 
				new Produktsystem("EinsZwei-Drei", f3, vkp);
		ProduktZ2.addProzessmodul(ProduktY);
		ProduktZ2.addProzessmodul(Modul3);
		HashMap<Fluss, Double> g = ProduktZ2.getElementarflussvektor();
		assertEquals(95., g.get(F1), 0.01);
		assertEquals(45., g.get(F2), 0.01);
		assertEquals(-450., g.get(F3), 0.01);
		assertEquals(-5., g.get(F4), 0.01);	
	}
	@Test
	public void test3() {
		initialize();
		HashMap<Fluss, Double> f23 = new HashMap<Fluss, Double>();
		LinkedList<Fluss>vkp23 = new LinkedList<Fluss>();
		f23.put(F7, 1.);
		vkp23.add(F5);
		Produktsystem ProduktZ3a = new Produktsystem("ZweiDrei", f23, vkp23);
		ProduktZ3a.addProzessmodul(Modul2);
		ProduktZ3a.addProzessmodul(Modul3);
		HashMap<Fluss, Double> f1u23 = new HashMap<Fluss, Double>();
		LinkedList<Fluss>vkp1u23 = new LinkedList<Fluss>();
		f1u23.put(F7, 1.);
		Produktsystem ProduktZ3 = 
				new Produktsystem("Eins-ZweiDrei", f1u23, vkp1u23);
		ProduktZ3.addProzessmodul(Modul1);
		ProduktZ3.addProzessmodul(ProduktZ3a);
		HashMap<Fluss, Double> g = ProduktZ3.getElementarflussvektor();
		assertEquals(95., g.get(F1), 0.01);
		assertEquals(45., g.get(F2), 0.01);
		assertEquals(-450., g.get(F3), 0.01);
		assertEquals(-5., g.get(F4), 0.01);	
	}
}
