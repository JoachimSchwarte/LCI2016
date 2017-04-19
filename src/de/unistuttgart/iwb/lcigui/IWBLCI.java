package de.unistuttgart.iwb.lcigui;

import java.awt.EventQueue;
import de.unistuttgart.iwb.lci.*;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.CardLayout;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.LinkedList;

import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class IWBLCI {
	
	/*
	 *   Globale Variablen
	 */

	private JFrame frmIwblciVersion;
	private JPanel panel = new JPanel();
	private CardLayout cl = new CardLayout(0, 0);
	private LinkedList<Fluss>allFlows = new LinkedList<Fluss>();
	private HashMap<String, Prozessmodul>allModules = new HashMap<String, Prozessmodul>();
	private HashMap<String, Produktsystem>allProSys = new HashMap<String, Produktsystem>();
	private HashMap<String, Bedarfsvektor>allBVs = new HashMap<String, Bedarfsvektor>();
	private HashMap<String, VorUndKoppelprodukte>allVKs = new HashMap<String, VorUndKoppelprodukte>();
	private HashMap<String, ModulNamenListe>allMNLs = new HashMap<String, ModulNamenListe>();
	private final Action newFlowAction = new SwingAction();
	private final Action newModuleAction = new SwingAction_1();
	private final Action newProductAction = new SwingAction_2();
	private final Action listFlowAction = new SwingAction_3();
	private final Action listModuleAction = new SwingAction_4();
	private final Action listProductAction = new SwingAction_5();
	private final Action calculateAction = new SwingAction_6();
	private JTextField txtName;
	private JTextField txtModName;
	private JTextField txtModName2;
	private JTextField txtFlussName;
	private JTextField txtVKName;
	private JTextField txtMenge;
	private JTextField txtPSName;
	private JTextField txtBV;
	private JTextField txtBVMenge;
	private JTable table = new JTable();
	private JTable table2 = new JTable();
	private JTable table3 = new JTable();
	private JTable table4 = new JTable();
	DefaultTableModel tm = new DefaultTableModel(0,3);
	DefaultTableModel tm2 = new DefaultTableModel(0,3);
	DefaultTableModel tm3 = new DefaultTableModel(0,3);
	DefaultTableModel tm4 = new DefaultTableModel(0,3);
	private final Action action = new SwingAction_7();
	private final Action action_1 = new SwingAction_8();
	private final Action action_2 = new SwingAction_9();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IWBLCI window = new IWBLCI();
					window.frmIwblciVersion.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public IWBLCI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmIwblciVersion = new JFrame();
		frmIwblciVersion.setTitle("IWB-LCI   Version 0.9");
		frmIwblciVersion.setBounds(100, 100, 600, 480);
		frmIwblciVersion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		
		frmIwblciVersion.getContentPane().add(panel, BorderLayout.CENTER);
		
		panel.setLayout(cl);
		
		/*
		 * Gestaltung der Panels
		 */
		
		// Panel 1
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, "neuFluss");
		panel_1.setLayout(new MigLayout("", "[108px,grow][108px][108px][108px,grow]", 
				"[20px][20px][20px][20px][20px][20px][20px,grow]"));
		JLabel lblNeuerFluss = new JLabel("Neuer Fluss");
		lblNeuerFluss.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_1.add(lblNeuerFluss, "flowy,cell 1 0 2 1,alignx center,growy");
		
		JLabel lblName = new JLabel("Name des Flusses");
		panel_1.add(lblName, "cell 1 1,grow");
		
		txtName = new JTextField();
		txtName.setText("");
		panel_1.add(txtName, "cell 2 1,grow");
		txtName.setColumns(10);
		
		JLabel lblTyp = new JLabel("Typ");
		panel_1.add(lblTyp, "cell 1 2,grow");
		
		JComboBox<FlussTyp> comboBox = new JComboBox<FlussTyp>();
		comboBox.setModel(new DefaultComboBoxModel<FlussTyp>(FlussTyp.values()));
		panel_1.add(comboBox, "cell 2 2,grow");
		
		JLabel lblEinheit = new JLabel("Einheit");
		panel_1.add(lblEinheit, "cell 1 3,grow");
		
		JComboBox<FlussEinheit> comboBox_1 = new JComboBox<FlussEinheit>();
		comboBox_1.setModel(new DefaultComboBoxModel<FlussEinheit>(FlussEinheit.values()));
		panel_1.add(comboBox_1, "cell 2 3,grow");
		
		JLabel lblStatusmeldung = new JLabel(">>> ... <<<");
		panel_1.add(lblStatusmeldung, "cell 0 5 4 1,alignx center");
		
		JButton btnSpeichern = new JButton("speichern");
		panel_1.add(btnSpeichern, "cell 1 4 2 1,alignx center");
		
		// Panel 2
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, "neuModul");
		panel_2.setLayout(new MigLayout("", "[108px,grow][108px][108px][108px,grow]", 
				"[20px][20px][20px][20px][20px][20px][20px][20px][20px,grow]"));
		JLabel lblNeuesProzessmodul = new JLabel("Neues Prozessmodul");
		lblNeuesProzessmodul.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_2.add(lblNeuesProzessmodul, "flowy,cell 1 0 2 1,alignx center,growy");
		
		JLabel lblModName = new JLabel("Name des Prozessmoduls");
		panel_2.add(lblModName, "cell 1 1,grow");
		
		txtModName = new JTextField();
		txtModName.setText("");
		panel_2.add(txtModName, "cell 2 1,grow");
		txtModName.setColumns(10);
		
		JLabel lblStatus2 = new JLabel(">>> ... <<<");
		panel_2.add(lblStatus2, "cell 0 6 4 1,alignx center");
		
		JButton btnSpei2 = new JButton("neues Prozessmodul anlegen");
		panel_2.add(btnSpei2, "cell 1 2 2 1,alignx center");
		
		JLabel lblFlussName = new JLabel("Name des Flusses");
		panel_2.add(lblFlussName, "cell 1 3,grow");
		
		txtFlussName = new JTextField();
		txtFlussName.setText("");
		panel_2.add(txtFlussName, "cell 2 3,grow");
		txtFlussName.setColumns(10);
		txtFlussName.setEnabled(false);
		
		JLabel lblMenge = new JLabel("Menge");
		panel_2.add(lblMenge, "cell 1 4,grow");
		
		txtMenge = new JTextField();
		txtMenge.setText("");
		panel_2.add(txtMenge, "cell 2 4,grow");
		txtMenge.setColumns(10);
		txtMenge.setEnabled(false);
		
		JButton btnAddFluss = new JButton("Fluss hinzufügen");
		btnAddFluss.setEnabled(false);
		panel_2.add(btnAddFluss, "cell 1 5,alignx center");
		
		JButton btnFertig = new JButton("fertig");
		btnFertig.setEnabled(false);
		panel_2.add(btnFertig, "cell 2 5,alignx center");

		// Panel 3
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3, "neuProdukt");	
		panel_3.setLayout(new MigLayout("", "[108px,grow][108px][108px][108px,grow]", 
				"[20px][20px][20px][20px][20px][20px][20px][20px][20px][20px][20px][20px,grow]"));
		JLabel lblNeuesProduktsystem = new JLabel("Neues Produktsystem");
		lblNeuesProduktsystem.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_3.add(lblNeuesProduktsystem, "flowy,cell 1 0 2 1,alignx center,growy");
		
		JLabel lblPSName = new JLabel("Name des Produktsystems");
		panel_3.add(lblPSName, "cell 1 1,grow");
		
		txtPSName = new JTextField();
		txtPSName.setText("");
		panel_3.add(txtPSName, "cell 2 1,grow");
		txtPSName.setColumns(10);
		
		JButton btnSpei3 = new JButton("neues Produktsystem anlegen");
		panel_3.add(btnSpei3, "cell 1 2 2 1,alignx center");
		
		JLabel lblModName2 = new JLabel("Prozessmodul/Subsystem");
		panel_3.add(lblModName2, "cell 1 3,grow");
		
		txtModName2 = new JTextField();
		txtModName2.setText("");
		panel_3.add(txtModName2, "cell 2 3,grow");
		txtModName2.setColumns(10);
		txtModName2.setEnabled(false);
		
		JButton btnAddMod = new JButton("Modul/System hinzufügen");
		btnAddMod.setEnabled(false);
		panel_3.add(btnAddMod, "cell 1 4,alignx center");
		
		JButton btnWeiter = new JButton("weiter");
		btnWeiter.setEnabled(false);
		panel_3.add(btnWeiter, "cell 2 4,alignx center");
		
		JLabel lblBV = new JLabel("Produkt im Bedarfsvektor");
		panel_3.add(lblBV, "cell 1 5,grow");
		
		txtBV = new JTextField();
		txtBV.setText("");
		panel_3.add(txtBV, "cell 2 5,grow");
		txtBV.setColumns(10);
		txtBV.setEnabled(false);
		
		JLabel lblBVMenge = new JLabel("Menge");
		panel_3.add(lblBVMenge, "cell 1 6,grow");
		
		txtBVMenge = new JTextField();
		txtBVMenge.setText("");
		panel_3.add(txtBVMenge, "cell 2 6,grow");
		txtBVMenge.setColumns(10);
		txtBVMenge.setEnabled(false);
		
		JButton btnAddBed = new JButton("Bedarfsvektor egänzen");
		btnAddBed.setEnabled(false);
		panel_3.add(btnAddBed, "cell 1 7,alignx center");
		
		JButton btnWei2 = new JButton("weiter");
		btnWei2.setEnabled(false);
		panel_3.add(btnWei2, "cell 2 7,alignx center");
		
		JLabel lblVKName = new JLabel("Vor- oder Koppelprodukt");
		panel_3.add(lblVKName, "cell 1 8,grow");
		
		txtVKName = new JTextField();
		txtVKName.setText("");
		panel_3.add(txtVKName, "cell 2 8,grow");
		txtVKName.setColumns(10);
		txtVKName.setEnabled(false);
		
		JButton btnAddVK = new JButton("VK-Fluss hinzufügen");
		btnAddVK.setEnabled(false);
		panel_3.add(btnAddVK, "cell 1 9,alignx center");
		
		JButton btnFertig2 = new JButton("fertig");
		btnFertig2.setEnabled(false);
		panel_3.add(btnFertig2, "cell 2 9,alignx center");
		
		JLabel lblStatus3 = new JLabel(">>> ... <<<");
		panel_3.add(lblStatus3, "cell 0 10 4 1,alignx center");

		// Panel 4
	
		JPanel panel_4 = new JPanel();
		panel.add(panel_4, "leer");
		panel_4.setLayout(new MigLayout("", "[108px,grow][200px][108px,grow]", 
				"[20px][20px][40px][20px][20px][20px][20px,grow][20px]"));
		JLabel lblInfo1 = new JLabel("IWB-LCI");
		lblInfo1.setFont(new Font("Tahoma", Font.BOLD, 26));
		panel_4.add(lblInfo1, "cell 1 2,alignx center,aligny top");
		JLabel lblInfo2 = new JLabel("Dr.-Ing. Joachim Schwarte");
		lblInfo2.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_4.add(lblInfo2, "cell 1 3,alignx center,aligny top");
		JLabel lblInfo3 = new JLabel("Insitut für Werkstoffe im Bauwesen");
		lblInfo3.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_4.add(lblInfo3, "cell 1 4,alignx center,aligny top");
		JLabel lblInfo4 = new JLabel("Universität Stuttgart");
		lblInfo4.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_4.add(lblInfo4, "cell 1 5,alignx center,aligny top");
		JLabel lblInfo5 = new JLabel("Version 0.903   19.04.2017");
		lblInfo5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_4.add(lblInfo5, "cell 1 7,alignx center,aligny top");

		// Panel 5
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5, "listeFluss");		
		panel_5.setLayout(new MigLayout("", "[74px,grow]", "[14px][grow]"));	
		JLabel lblListeDerFlsse = new JLabel("Liste der Fl\u00FCsse");
		lblListeDerFlsse.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_5.add(lblListeDerFlsse, "cell 0 0,alignx center,aligny top");		
		table.setModel(tm);
		TableColumnModel tcm = table.getColumnModel();
		tcm.getColumn(0).setHeaderValue("Name");
		tcm.getColumn(1).setHeaderValue("Typ");
		tcm.getColumn(2).setHeaderValue("Einheit");
		panel_5.add(new JScrollPane(table), "cell 0 1,alignx center,aligny top");
		
		// Panel 6
	
		JPanel panel_6 = new JPanel();
		panel.add(panel_6, "listeModul");
		panel_6.setLayout(new MigLayout("", "[74px,grow]", "[14px][grow]"));	
		JLabel lblListeDerProzessmodule = new JLabel("Liste der Prozessmodule");
		lblListeDerProzessmodule.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_6.add(lblListeDerProzessmodule, "cell 0 0,alignx center,aligny top");		
		table2.setModel(tm2);
		TableColumnModel tcm2 = table2.getColumnModel();
		tcm2.getColumn(0).setHeaderValue("Prozessmodul");
		tcm2.getColumn(1).setHeaderValue("Flussname");
		tcm2.getColumn(2).setHeaderValue("Menge");
		panel_6.add(new JScrollPane(table2), "cell 0 1,alignx center,aligny top");
		
		// Panel 7
		
		JPanel panel_7 = new JPanel();
		panel.add(panel_7, "listeProdukt");	
		panel_7.setLayout(new MigLayout("", "[74px,grow]", "[14px][grow]"));
		JLabel lblListeDerProduktsysteme = new JLabel("Liste der Produktsysteme");
		lblListeDerProduktsysteme.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_7.add(lblListeDerProduktsysteme, "cell 0 0,alignx center,aligny top");
		table3.setModel(tm3);
		TableColumnModel tcm3 = table3.getColumnModel();
		tcm3.getColumn(0).setHeaderValue("Produktsystem");
		tcm3.getColumn(1).setHeaderValue("Elementtyp");
		tcm3.getColumn(2).setHeaderValue("Elementname");
		panel_7.add(new JScrollPane(table3), "cell 0 1,alignx center,aligny top");
		
		// Panel 8
		
		JPanel panel_8 = new JPanel();
		panel.add(panel_8, "berechnen");
		panel_8.setLayout(new MigLayout("", "[74px,grow]", "[14px][grow]"));
		JLabel lblBerechnung = new JLabel("Umweltvektoren der Produktsysteme");
		lblBerechnung.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_8.add(lblBerechnung, "cell 0 0,alignx center,aligny top");
		table4.setModel(tm4);
		TableColumnModel tcm4 = table4.getColumnModel();
		tcm4.getColumn(0).setHeaderValue("Produktsystem");
		tcm4.getColumn(1).setHeaderValue("Fluss");
		tcm4.getColumn(2).setHeaderValue("Menge");
		panel_8.add(new JScrollPane(table4), "cell 0 1,alignx center,aligny top");
		
		cl.show(panel, "leer");
		
		/*
		 * Organisation der Menuleiste
		 */
		
		JMenuBar menuBar = new JMenuBar();
		frmIwblciVersion.setJMenuBar(menuBar);
		
		JMenu mnDatei = new JMenu("Datei");
		menuBar.add(mnDatei);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		mntmNewMenuItem.setAction(action);
		mnDatei.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("New menu item");
		mntmNewMenuItem_1.setAction(action_1);
		mnDatei.add(mntmNewMenuItem_1);
		
		JMenu mnNew = new JMenu("Neu");
		menuBar.add(mnNew);
		
		JMenuItem mntmFlow = new JMenuItem("Fluss");
		mntmFlow.setAction(newFlowAction);
		mnNew.add(mntmFlow);
		
		JMenuItem mntmProcessModule = new JMenuItem("Prozessmodul");
		mntmProcessModule.setAction(newModuleAction);
		mnNew.add(mntmProcessModule);
		
		JMenuItem mntmProductSystem = new JMenuItem("Produktsystem");
		mntmProductSystem.setAction(newProductAction);
		mnNew.add(mntmProductSystem);
		
		JMenu mnListe = new JMenu("Liste");
		menuBar.add(mnListe);
		
		JMenuItem mntmFlsse = new JMenuItem("Fl\u00FCsse");
		mntmFlsse.setAction(listFlowAction);
		mnListe.add(mntmFlsse);
		
		JMenuItem mntmProzessmodule = new JMenuItem("Prozessmodule");
		mntmProzessmodule.setAction(listModuleAction);
		mnListe.add(mntmProzessmodule);
		
		JMenuItem mntmProduktsysteme = new JMenuItem("Produktsysteme");
		mntmProduktsysteme.setAction(listProductAction);
		mnListe.add(mntmProduktsysteme);
		
		JMenu mnBerechnen = new JMenu("Berechnen");
		menuBar.add(mnBerechnen);
		
		JMenuItem mntmLci = new JMenuItem("LCI");
		mntmLci.setAction(calculateAction);
		mnBerechnen.add(mntmLci);
		
		JMenu mnHilfe = new JMenu("Hilfe");
		menuBar.add(mnHilfe);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("New menu item");
		mntmNewMenuItem_2.setAction(action_2);
		mnHilfe.add(mntmNewMenuItem_2);
		
		/*
		 * Aktivitäten der Schaltflächen
		 */
		
		btnSpeichern.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String name = txtName.getText();	
				FlussTyp typ = comboBox.getItemAt(comboBox.getSelectedIndex());
				FlussEinheit einheit = comboBox_1.getItemAt(comboBox_1.getSelectedIndex());
				if (name.equals("")) {
					lblStatusmeldung.setText(">>> Es wurde kein Name angegeben. <<<");
				} else {
					boolean nameVorhanden = false;
					for(Fluss pf : allFlows) {
						if (name.equals(pf.getName())) {
							nameVorhanden = true;
						}
					}
					if (nameVorhanden == true) {
						lblStatusmeldung.setText(">>> Der angegebene Name ist bereits vorhanden. <<<");
					} else {
						allFlows.add(new Fluss(name, typ, einheit));
						lblStatusmeldung.setText(">>> Anzahl Flussobjekte: " + allFlows.size() + " <<<");
						tm.addRow(new Object[] {name, typ, einheit});
						txtName.setText("");
						comboBox.setSelectedIndex(0);
						comboBox_1.setSelectedIndex(0);
					}	
				} 		
			}
		});


		btnSpei2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String name = txtModName.getText();	
				if (name.equals("")) {
					lblStatus2.setText(">>> Es wurde kein Name angegeben. <<<");
				} else {
					boolean nameVorhanden = false;
					
					for(String mod : allModules.keySet()) {
						if (name.equals(mod)) {
							nameVorhanden = true;
						}
					}
					for(String mod : allProSys.keySet()) {
						if (name.equals(mod)) {
							nameVorhanden = true;
						}
					}
					if (nameVorhanden == true) {
						lblStatus2.setText(">>> Der angegebene Name ist bereits vorhanden. <<<");
					} else {
						allModules.put(name, new Prozessmodul());
						tm2.addRow(new Object[] {name, "", ""});
						lblStatus2.setText(">>> Anzahl Prozessmodule: " + allModules.size() + " <<<");
						btnSpei2.setEnabled(false);
						txtModName.setEnabled(false);
						btnAddFluss.setEnabled(true);
						txtFlussName.setEnabled(true);
						txtMenge.setEnabled(true);
					}	
				} 		
			}
		});
		
		btnAddFluss.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String fname = txtFlussName.getText();
				String fmenge = txtMenge.getText();
				Double menge;
				try {
					menge = Double.parseDouble(fmenge);
				} catch (NumberFormatException e){
					menge = 0.0;
				}
				if (fname.equals("") || (menge == 0.0)) {
					lblStatus2.setText(">>> unvollständige Eingabe <<<");
				} else {
					boolean nameVorhanden = false;
					for(Fluss pf : allFlows) {
						if (fname.equals(pf.getName())) {
							nameVorhanden = true;
						}
					}
					if (nameVorhanden == true) {
						Fluss akFluss = null;
						for(Fluss pf : allFlows){
							if (fname.equals(pf.getName())){
								akFluss = pf;
							}
						}
						String mname = txtModName.getText();
						allModules.get(mname).addFluss(akFluss, menge);
						tm2.addRow(new Object[] {"" ,akFluss.getName() ,menge});
						txtFlussName.setText("");
						txtMenge.setText("");
						btnFertig.setEnabled(true);
						int anzPFluss = allModules.get(mname).getProduktflussvektor().size();
						int anzEFluss = allModules.get(mname).getElementarflussvektor().size();
						int anzGesamt = anzPFluss + anzEFluss;
						lblStatus2.setText(">>> Prozessmodul " + mname + " besitzt " +
								anzGesamt + " Flüsse <<<");
						
					} else {
						lblStatus2.setText(">>> unbekannter Flussname <<<");
					}					
				}
			}
		});
		
		btnFertig.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnSpei2.setEnabled(true);
				txtFlussName.setText("");
				txtMenge.setText("");
				txtModName.setText("");
				btnAddFluss.setEnabled(false);
				btnFertig.setEnabled(false);
				txtModName.setEnabled(true);
				txtFlussName.setEnabled(false);
				txtMenge.setEnabled(false);
				lblStatus2.setText(">>> ... <<<");
			}
		});
		
		btnSpei3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String name = txtPSName.getText();	
				if (name.equals("")) {
					lblStatus3.setText(">>> Es wurde kein Name angegeben. <<<");
				} else {
					boolean nameVorhanden = false;
					
					for(String mod : allModules.keySet()) {
						if (name.equals(mod)) {
							nameVorhanden = true;
						}
					}
					for(String mod : allProSys.keySet()) {
						if (name.equals(mod)) {
							nameVorhanden = true;
						}
					}
					if (nameVorhanden == true) {
						lblStatus3.setText(">>> Der angegebene Name ist bereits vorhanden. <<<");
					} else {
						allProSys.put(name, new Produktsystem(name, new HashMap<Fluss, Double>(), 
								new LinkedList<Fluss>()));
						tm3.addRow(new Object[] {name, "", ""});
						allMNLs.put(name, new ModulNamenListe());
						allBVs.put(name, new Bedarfsvektor());
						allVKs.put(name, new VorUndKoppelprodukte());
						lblStatus3.setText(">>> Anzahl Produktsysteme: " + allProSys.size() + " <<<");

						btnSpei3.setEnabled(false);
						txtPSName.setEnabled(false);
						btnAddMod.setEnabled(true);
						txtModName2.setEnabled(true);
					}	
				} 		
			}
		});
		
		btnAddMod.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String modname = txtModName2.getText();
				if (modname.equals("") || modname.equals(txtPSName.getText())) {
					if (modname.equals("")) {
						lblStatus3.setText(">>> unvollständige Eingabe <<<");
					}
					if (modname.equals(txtPSName.getText())) {
						lblStatus3.setText(">>> unzulässige Rekursion <<<");
					}
				} else {
					boolean nameVorhanden = false;
					boolean typmod = false;
					for(String modn2 : allModules.keySet()) {
						if (modname.equals(modn2)) {
							nameVorhanden = true;
							typmod = true;
						}
					}
					if (nameVorhanden == false) {
						for(String modn3 : allProSys.keySet()) {
							if (modname.equals(modn3)) {
								nameVorhanden = true;
								typmod = false;
							}
						}
					}
					if (nameVorhanden == true) {
						if (typmod == true){
							allProSys.get(txtPSName.getText()).addProzessmodul(allModules.get(modname));
							tm3.addRow(new Object[] {"","Prozessmodul", modname});							
						} else {
							allProSys.get(txtPSName.getText()).addProzessmodul(allProSys.get(modname));
							tm3.addRow(new Object[] {"","Subsystem", modname});	
						}
						allMNLs.get(txtPSName.getText()).addName(modname);
//						allMNLs.put(txtPSName.getText(), new ModulNamenListe());
//						allBVs.put(txtPSName.getText(), new Bedarfsvektor());
//						allVKs.put(txtPSName.getText(), new VorUndKoppelprodukte());
						lblStatus3.setText(">>> Produktsystem " + txtPSName.getText() +
								" besteht aus " + allProSys.get(txtPSName.getText()).getModulAnzahl() 
								+ " Elementen <<<");
						txtModName2.setText("");
						btnWeiter.setEnabled(true);
					} else {
						lblStatus3.setText(">>> Name ist weder Prozessmodul noch Produktsystem <<<");
					}					
				}
			}
		});
		
		btnWeiter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtModName2.setEnabled(false);
				txtModName2.setText("");
				btnAddMod.setEnabled(false);
				btnWeiter.setEnabled(false);
				txtBV.setEnabled(true);
				txtBVMenge.setEnabled(true);
				btnAddBed.setEnabled(true);
				lblStatus3.setText(">>> ... <<<");
			}
		});
		
		btnAddBed.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String fname = txtBV.getText();
				String fmenge = txtBVMenge.getText();
				Double menge;
				try {
					menge = Double.parseDouble(fmenge);
				} catch (NumberFormatException e){
					menge = 0.0;
				}
				if (fname.equals("") || (menge == 0.0)) {
					lblStatus3.setText(">>> unvollständige Eingabe <<<");
				} else {
					boolean nameVorhanden = false;
					for(Fluss pf : allFlows) {
						if (fname.equals(pf.getName())) {
							nameVorhanden = true;
						}
					}
					if (nameVorhanden == true) {
						Fluss akFluss = null;
						for(Fluss pf : allFlows){
							if (fname.equals(pf.getName())){
								akFluss = pf;
							}
						}
						allBVs.get(txtPSName.getText()).addFluss(akFluss, menge);
						allProSys.get(txtPSName.getText()).
							setBedarfsvektor(allBVs.get(txtPSName.getText()).getBV());
						tm3.addRow(new Object[] {"" ,"Bedarf" 
								,"" + akFluss.getName() + " ("+ menge + " " + akFluss.getEinheit()+")"});
						lblStatus3.setText(">>> Der Bedarfsvektor enthält " + 
								allBVs.get(txtPSName.getText()).getBV().size() + " Flüsse <<<");
						btnWei2.setEnabled(true);						
					} else {
						lblStatus3.setText(">>> unbekannter Flussname <<<");
					}					
				}
			}
		});
		
		btnWei2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtModName2.setEnabled(false);
				txtModName2.setText("");
				btnAddMod.setEnabled(false);
				btnWeiter.setEnabled(false);
				txtBV.setEnabled(false);
				txtBVMenge.setEnabled(false);
				btnWei2.setEnabled(false);
				txtBV.setText("");
				txtBVMenge.setText("");
				btnAddBed.setEnabled(false);
				txtVKName.setEnabled(true);
				btnAddVK.setEnabled(true);
				btnFertig2.setEnabled(true);
				
				lblStatus3.setText(">>> ... <<<");
			}
		});
		
		btnAddVK.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String vkname = txtVKName.getText();
				if (vkname.equals("")) {
					lblStatus3.setText(">>> unvollständige Eingabe <<<");
				} else {
					boolean nameVorhanden = false;
					for(Fluss pf : allFlows) {
						if (vkname.equals(pf.getName())) {
							nameVorhanden = true;
						}
					}					

					if (nameVorhanden == true) {
						Fluss akFluss = null;
						for(Fluss pf : allFlows){
							if (vkname.equals(pf.getName())){
								akFluss = pf;
							}
						}
						allVKs.get(txtPSName.getText()).addFluss(akFluss);
						allProSys.get(txtPSName.getText()).
							setVorUndKoppelProdukte(allVKs.get(txtPSName.getText()).getVk());
						tm3.addRow(new Object[] {"" ,"Vor- oder Koppelpr." 
								,akFluss.getName()});
						lblStatus3.setText(">>> Der VK-Vektor enthält " + 
								allVKs.get(txtPSName.getText()).getVk().size() + " Flüsse <<<");										
					} else {
						lblStatus3.setText(">>> unbekannter Flussname <<<");
					}					
				}
			}
		});

		btnFertig2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtPSName.setEnabled(true);
				txtPSName.setText("");
				btnSpei3.setEnabled(true);
				txtModName2.setEnabled(false);
				txtModName2.setText("");
				btnAddMod.setEnabled(false);
				btnWeiter.setEnabled(false);
				txtBV.setEnabled(false);
				txtBVMenge.setEnabled(false);
				btnWei2.setEnabled(false);
				txtBV.setText("");
				txtBVMenge.setText("");
				btnAddBed.setEnabled(false);
				txtVKName.setEnabled(false);
				txtVKName.setText("");
				btnAddVK.setEnabled(false);
				btnFertig2.setEnabled(false);
				
				lblStatus3.setText(">>> ... <<<");
			}
		});
	}
	
	/*
	 * Aktivitäten der Menupunkte
	 */

	private class SwingAction extends AbstractAction {
		private static final long serialVersionUID = 3159283296670804375L;
		public SwingAction() {
			putValue(NAME, "Fluss");
			putValue(SHORT_DESCRIPTION, "neues Flussobjekt erfassen");
		}
		public void actionPerformed(ActionEvent e) {
			cl.show(panel, "neuFluss");
		}
	}
	private class SwingAction_1 extends AbstractAction {
		private static final long serialVersionUID = 6190606710625748526L;
		public SwingAction_1() {
			putValue(NAME, "Prozessmodul");
			putValue(SHORT_DESCRIPTION, "neues Prozessmodul erfassen");
		}
		public void actionPerformed(ActionEvent e) {
			cl.show(panel, "neuModul");
		}
	}
	private class SwingAction_2 extends AbstractAction {
		private static final long serialVersionUID = -7757652453649226474L;
		public SwingAction_2() {
			putValue(NAME, "Produktsystem");
			putValue(SHORT_DESCRIPTION, "neues Produktsystem erfassen");
		}
		public void actionPerformed(ActionEvent e) {
			cl.show(panel, "neuProdukt");
		}
	}
	private class SwingAction_3 extends AbstractAction {
		private static final long serialVersionUID = 3929527112031439132L;
		public SwingAction_3() {
			putValue(NAME, "Fl\u00FCsse");
			putValue(SHORT_DESCRIPTION, "Liste aller Flüsse");
		}
		public void actionPerformed(ActionEvent e) {
			cl.show(panel, "listeFluss");
		}
	}
	private class SwingAction_4 extends AbstractAction {
		private static final long serialVersionUID = -23206034834972545L;
		public SwingAction_4() {
			putValue(NAME, "Prozessmodule");
			putValue(SHORT_DESCRIPTION, "Liste aller Prozessmodule");
		}
		public void actionPerformed(ActionEvent e) {
			cl.show(panel, "listeModul");
		}
	}
	private class SwingAction_5 extends AbstractAction {
		private static final long serialVersionUID = 9038442522125086919L;
		public SwingAction_5() {
			putValue(NAME, "Produktsysteme");
			putValue(SHORT_DESCRIPTION, "Liste aller Produktsysteme");
		}
		public void actionPerformed(ActionEvent e) {
			cl.show(panel, "listeProdukt");
		}
	}
	private class SwingAction_6 extends AbstractAction {
		private static final long serialVersionUID = 7449057427765901652L;
		public SwingAction_6() {
			putValue(NAME, "Sachbilanz berechnen");
			putValue(SHORT_DESCRIPTION, "Sachbilanz aller Produktsysteme");
		}
		public void actionPerformed(ActionEvent e) {
			cl.show(panel, "berechnen");
			tm4.setRowCount(0);
			HashMap<Fluss, Double> sysErgebnis = new HashMap<Fluss, Double>();
			if (allProSys.size() > 0) {
				for(String sysName : allProSys.keySet()) {
					tm4.addRow(new Object[] {sysName,"",""});
					Produktsystem sysAktuell = allProSys.get(sysName);
					if (sysAktuell.getElementarflussvektor().size() > 0) {
						sysErgebnis = sysAktuell.getElementarflussvektor();
						for(Fluss sysFluss : sysErgebnis.keySet()){
							tm4.addRow(new Object[] {"",sysFluss.getName(),"" + 
								sysErgebnis.get(sysFluss) + " " + sysFluss.getEinheit() + ""});
						}
					}					 
				}
			}
		}
	}
	private class SwingAction_7 extends AbstractAction {
		private static final long serialVersionUID = -8513272127372924276L;
		public SwingAction_7() {
			putValue(NAME, "Save");
			putValue(SHORT_DESCRIPTION, "Abspeichern aller Objekte");
		}
		public void actionPerformed(ActionEvent e) {
	        // JFileChooser-Objekt erstellen
	        JFileChooser chooser = new JFileChooser();
	        // Dialog zum Speichern von Dateien anzeigen
	        int rueckgabeWert = chooser.showSaveDialog(null);
	        if(rueckgabeWert == JFileChooser.APPROVE_OPTION) {
	        	try {
					FileOutputStream fs = new FileOutputStream(chooser.getSelectedFile());
					ObjectOutputStream os = new ObjectOutputStream(fs);
					os.writeInt(allFlows.size());
					for(Fluss pf : allFlows) {
						os.writeObject(pf.getName());
						os.writeObject(pf.getTyp());
						os.writeObject(pf.getEinheit());
					}	
					os.writeInt(allModules.size());
					for(String mn : allModules.keySet()) {
						os.writeObject(mn);
						Prozessmodul akModul = allModules.get(mn);
						os.writeInt(akModul.getElementarflussvektor().size());
						for(Fluss pf : akModul.getElementarflussvektor().keySet()){
							os.writeObject(pf.getName());
							os.writeObject(akModul.getElementarflussvektor().get(pf));
						}						
						os.writeInt(akModul.getProduktflussvektor().size());
						for(Fluss pf : akModul.getProduktflussvektor().keySet()){
							os.writeObject(pf.getName());
							os.writeObject(akModul.getProduktflussvektor().get(pf));
						}
					}
					os.writeInt(allProSys.size());
					for(String psm : allProSys.keySet()) {
						os.writeObject(psm);
						os.writeObject(allMNLs.get(psm));
						os.writeInt(allBVs.get(psm).getBV().size());
						for (Fluss bvf : allBVs.get(psm).getBV().keySet()) {
							os.writeObject(bvf.getName());
							os.writeObject(allBVs.get(psm).getBV().get(bvf));
						}

						os.writeInt(allVKs.get(psm).getVk().size());
						for (Fluss vkf : allVKs.get(psm).getVk()){
							os.writeObject(vkf.getName());
						}					
					}
					os.close();
					fs.close();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        }
			
		}
	}
	private class SwingAction_8 extends AbstractAction {
		private static final long serialVersionUID = -8070002616229474706L;
		public SwingAction_8() {
			putValue(NAME, "Load");
			putValue(SHORT_DESCRIPTION, "Laden eines Objektbestandes");
		}
		public void actionPerformed(ActionEvent e) {
	        // JFileChooser-Objekt erstellen
	        JFileChooser chooser = new JFileChooser();
	        // Dialog zum Speichern von Dateien anzeigen
	        int rueckgabeWert = chooser.showOpenDialog(null);
	        if(rueckgabeWert == JFileChooser.APPROVE_OPTION) {
	        	try {
					FileInputStream fs = new FileInputStream(chooser.getSelectedFile());
					ObjectInputStream os = new ObjectInputStream(fs);
					allFlows.clear();
					tm.setRowCount(0);
					int nrFlows = os.readInt();
					for (Integer i=0; i<nrFlows; i++){
						String name = os.readObject().toString();
						FlussTyp typ = (FlussTyp)os.readObject();
						FlussEinheit einheit = (FlussEinheit)os.readObject();
						allFlows.add(new Fluss(name, typ, einheit));
						tm.addRow(new Object[] {name, typ, einheit});
					}		
					allModules.clear();
					tm2.setRowCount(0);
					int nrMods = os.readInt();
					for (Integer i=0; i<nrMods; i++) {
						String mn = (String)os.readObject();
						allModules.put(mn, new Prozessmodul());
						tm2.addRow(new Object[] {mn, "", ""});
						int esize = os.readInt();
						for (int j=0; j<(esize); j++) {
							String fname = (String)os.readObject();
							Fluss akFluss = null;
							for(Fluss pf : allFlows){
								if(fname.equals(pf.getName())){
									akFluss = pf;
								}
							}								
							Double menge = (Double)os.readObject();
							allModules.get(mn).addFluss(akFluss, menge);
							tm2.addRow(new Object[] {"", akFluss.getName(), menge});						
						}
						int psize = os.readInt();
						for (int j=0; j<(psize); j++) {
							String fname = (String)os.readObject();
							Fluss akFluss = null;
							for(Fluss pf : allFlows){
								if(fname.equals(pf.getName())){
									akFluss = pf;
								}
							}								
							Double menge = (Double)os.readObject();
							allModules.get(mn).addFluss(akFluss, menge);
							tm2.addRow(new Object[] {"", akFluss.getName(), menge});						
						}
					}
					allProSys.clear();
					allMNLs.clear();
					allBVs.clear();
					allVKs.clear();
					tm3.setRowCount(0);
					int nrSys = os.readInt();
					
					for (Integer i=0; i<nrSys; i++) {
						String name = (String)os.readObject();
						
						if (allProSys.containsKey(name) == false) {
							allProSys.put(name, new Produktsystem(name, new HashMap<Fluss, Double>(), 
									new LinkedList<Fluss>()));							
						}						
						tm3.addRow(new Object[] {name, "", ""});
						allMNLs.put(name, new ModulNamenListe());
						allBVs.put(name, new Bedarfsvektor());
						allVKs.put(name, new VorUndKoppelprodukte());
						ModulNamenListe ml = (ModulNamenListe)os.readObject();
						for (String mni : ml.getMnl()) {
							boolean typmod = false;
							for(String modn2 : allModules.keySet()) {
								if (mni.equals(modn2)) {
									typmod = true;
								}
							}
							if (typmod == true){
								allProSys.get(name).addProzessmodul(allModules.get(mni));
								tm3.addRow(new Object[] {"","Prozessmodul", mni});							
							} else {
								if (allProSys.containsKey(mni) == false) {
									allProSys.put(mni, new Produktsystem(mni, new HashMap<Fluss, Double>(), 
											new LinkedList<Fluss>()));							
								}	
								allProSys.get(name).addProzessmodul(allProSys.get(mni));
								tm3.addRow(new Object[] {"","Subsystem", mni});	
							}
							allMNLs.get(name).addName(mni);
							
						}
						int nrbv = os.readInt();

						for (int j=0; j<nrbv; j++) {
							String bvname = (String)os.readObject();
							Double bvwert = (Double)os.readObject();
							Fluss akFluss = null;
							for(Fluss pf : allFlows){
								if (bvname.equals(pf.getName())){
									akFluss = pf;
								}
							}
							allBVs.get(name).addFluss(akFluss, bvwert);
							allProSys.get(name).
								setBedarfsvektor(allBVs.get(name).getBV());
							tm3.addRow(new Object[] {"" ,"Bedarf" 
									,"" + bvname + " ("+ bvwert + " " + akFluss.getEinheit()+")"});							
						}
						int nrvk = os.readInt();
						for (int j=0; j<nrvk; j++) {
							String vkname = (String)os.readObject();
							Fluss akFluss = null;
							for(Fluss pf : allFlows){
								if (vkname.equals(pf.getName())){
									akFluss = pf;
								}
							}
							allVKs.get(name).addFluss(akFluss);
							allProSys.get(name).setVorUndKoppelProdukte(allVKs.get(name).getVk());
							tm3.addRow(new Object[] {"" ,"Vor- oder Koppelpr." ,vkname});
							
						}					
					}
					os.close();
					fs.close();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        }
			
		}
	}
	private class SwingAction_9 extends AbstractAction {
		private static final long serialVersionUID = 8545097902506476895L;
		public SwingAction_9() {
			putValue(NAME, "Über");
			putValue(SHORT_DESCRIPTION, "Info");
		}
		public void actionPerformed(ActionEvent e) {
			cl.show(panel, "leer");
		}
	}
}
