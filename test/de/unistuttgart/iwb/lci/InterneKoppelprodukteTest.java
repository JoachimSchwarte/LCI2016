package de.unistuttgart.iwb.lci;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.LinkedList;

import org.junit.Test;

public class InterneKoppelprodukteTest {
	Fluss A = new Fluss("A", FlussTyp.Elementar, FlussEinheit.Stk);
	Fluss B = new Fluss("B", FlussTyp.Elementar, FlussEinheit.Stk);
	Fluss C = new Fluss("C", FlussTyp.Elementar, FlussEinheit.Stk);
	Fluss D = new Fluss("D", FlussTyp.Elementar, FlussEinheit.Stk);
	Fluss E = new Fluss("E", FlussTyp.Elementar, FlussEinheit.Stk);
	Fluss F = new Fluss("F", FlussTyp.Elementar, FlussEinheit.Stk);
	Fluss X = new Fluss("X", FlussTyp.Produkt, FlussEinheit.Stk);
	Fluss Y = new Fluss("Y", FlussTyp.Produkt, FlussEinheit.Stk);
	Fluss Z = new Fluss("Z", FlussTyp.Produkt, FlussEinheit.Stk);
	Fluss W = new Fluss("W", FlussTyp.Produkt, FlussEinheit.Stk);
	Fluss V = new Fluss("V", FlussTyp.Produkt, FlussEinheit.Stk);
	Prozessmodul Modul1 = new Prozessmodul();
	Prozessmodul Modul2 = new Prozessmodul();
	Prozessmodul Modul3 = new Prozessmodul();
	Prozessmodul Modul4 = new Prozessmodul();
	Prozessmodul Modul5 = new Prozessmodul();
	private void initialize() {
		Modul1.addFluss(A, 1.);
		Modul1.addFluss(B, 1.);
		Modul1.addFluss(E, -1.);
		Modul1.addFluss(X, 1.);
		Modul2.addFluss(A, 1.);
		Modul2.addFluss(C, 1.);
		Modul2.addFluss(F, -1.);
		Modul2.addFluss(X, -20.);
		Modul2.addFluss(Z, 1.);
		Modul3.addFluss(A, 1.);
		Modul3.addFluss(D, 1.);
		Modul3.addFluss(F, -2.);
		Modul3.addFluss(X, 1.);
		Modul3.addFluss(Y, 1.);
		Modul4.addFluss(C, 1.);
		Modul4.addFluss(D, 1.);
		Modul4.addFluss(E, -2.);
		Modul4.addFluss(Y, -2.);
		Modul4.addFluss(W, 1.);
		Modul5.addFluss(B, 1.);
		Modul5.addFluss(C, 1.);
		Modul5.addFluss(E, -1.);
		Modul5.addFluss(F, -1.);
		Modul5.addFluss(Z, -2.);
		Modul5.addFluss(W, -3.);
		Modul5.addFluss(V, 1.);
	}
	@Test
	public void test1() {
		initialize();
		HashMap<Fluss, Double> f = new HashMap<Fluss, Double>();
		LinkedList<Fluss>vkp = new LinkedList<Fluss>();
		f.put(V, 1.);
		Produktsystem EinsBisFünf = 
				new Produktsystem("", f, vkp);
		EinsBisFünf.addProzessmodul(Modul1);
		EinsBisFünf.addProzessmodul(Modul2);
		EinsBisFünf.addProzessmodul(Modul3);
		EinsBisFünf.addProzessmodul(Modul4);
		EinsBisFünf.addProzessmodul(Modul5);
		HashMap<Fluss, Double> g = 
				EinsBisFünf.getElementarflussvektor();
		double uA = g.get(A);
		double uB = g.get(B);
		double uC = g.get(C);
		double uD = g.get(D);
		double uE = g.get(E);
		double uF = g.get(F);
		System.out.print("A = " + uA + "   ");
		System.out.print("B = " + uB + "   ");
		System.out.print("C = " + uC + "   ");
		System.out.print("D = " + uD + "   ");
		System.out.print("E = " + uE + "   ");
		System.out.println("F = " + uF + "   ");


		HashMap<Fluss, Double> f34 = new HashMap<Fluss, Double>();
		LinkedList<Fluss>vkp1 = new LinkedList<Fluss>();
		f34.put(W, 1.);
		vkp1.add(X);
		Produktsystem DreiUndVier = 
				new Produktsystem("", f34, vkp1);
		DreiUndVier.addProzessmodul(Modul3);
		DreiUndVier.addProzessmodul(Modul4);
		HashMap<Fluss, Double> f2 = new HashMap<Fluss, Double>();
		LinkedList<Fluss>vkp2 = new LinkedList<Fluss>();
		f2.put(V, 1.);
		Produktsystem Gesamt = 
				new Produktsystem("", f2, vkp2);
		Gesamt.addProzessmodul(Modul1);
		Gesamt.addProzessmodul(Modul2);
		Gesamt.addProzessmodul(Modul5);
		Gesamt.addProzessmodul(DreiUndVier);
		HashMap<Fluss, Double> g2 = Gesamt.getElementarflussvektor();
		assertEquals(uA, g2.get(A), 0.01);
		assertEquals(uB, g2.get(B), 0.01);
		assertEquals(uC, g2.get(C), 0.01);
		assertEquals(uD, g2.get(D), 0.01);
		assertEquals(uE, g2.get(E), 0.01);
		assertEquals(uF, g2.get(F), 0.01);
	}
}
