/*	
 * Beispielprojekt 
 * Sommersemester 2017
 */

package de.unistuttgart.iwb.lcigui;

import java.awt.EventQueue;
import de.unistuttgart.iwb.lci.*;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import net.miginfocom.swing.MigLayout;

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

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author Dr.-Ing. Joachim Schwarte
 * @version 0.926
 */

public class IWBLCI {
	
	/*
	 *   Globale Variablen
	 */

	private JFrame frmIwblciVersion;
	private JPanel panel = new JPanel();
	private CardLayout cl = new CardLayout(0, 0);
	private LinkedList<Fluss>allFlows = 
			new LinkedList<Fluss>();
	private HashMap<String, Prozessmodul>allModules =
			new HashMap<String, Prozessmodul>();
	private HashMap<String, Produktsystem>allProSys = 
			new HashMap<String, Produktsystem>();
	private HashMap<String, Bedarfsvektor>allBVs = 
			new HashMap<String, Bedarfsvektor>();
	private HashMap<String, VorUndKoppelprodukte>allVKs = 
			new HashMap<String, VorUndKoppelprodukte>();
	private HashMap<String, ModulNamenListe>allMNLs = 
			new HashMap<String, ModulNamenListe>();
	private LinkedList<Wirkungskategorie>allWKs = 
			new LinkedList<Wirkungskategorie>();
	private HashMap<String, ProduktBilanziert>allPBs = 
			new HashMap<String, ProduktBilanziert>();
	private HashMap<String, Bewertungsmethode>allBWs = 
			new HashMap<String, Bewertungsmethode>();
	private final Action newFlowAction 		= new newFlowAction();
	private final Action newModuleAction 	= new newModuleAction();
	private final Action newProductAction 	= new newProductAction();
	private final Action newWKAction 		= new newWKAction();
	private final Action newPBAction 		= new newPBAction();
	private final Action newCFAction 		= new newCFAction();
	private final Action newBMAction 		= new newBMAction();
	private final Action newPKenteAction 	= new newPKenteAction();
	private final Action newPKtionAction 	= new newPKtionAction();
	private final Action editModuleAction 	= new editModuleAction();
	private final Action listFlowAction 	= new listFlowAction();
	private final Action listModuleAction 	= new listModuleAction();
	private final Action listProductAction 	= new listProductAction();
	private final Action listWKsAction 	  	= new listWKsAction();
	private final Action listPBsAction 	  	= new listPBsAction();
	private final Action listCFsAction 	  	= new listCFsAction();
	private final Action listBMsAction 	  	= new listBMsAction();
	private final Action listPKentesAction 	= new listPKentesAction();
	private final Action listPKtionsAction 	= new listPKtionsAction();
	private final Action calculateAction 	= new calculateAction();
	private final Action saveAction 		= new saveAction();
	private final Action loadAction 		= new loadAction();
	private final Action aboutAction 		= new aboutAction();
	private JTextField txtName;
	private JTextField txtNameWK;
	private JTextField txtModName;
	private JTextField txtModName2;
	private JTextField txtModName3;
	private JTextField txtFlussName;
	private JTextField txtFlussName2;
	private JTextField txtVKName;
	private JTextField txtMenge;
	private JTextField txtMenge2;
	private JTextField txtPSName;
	private JTextField txtBV;
	private JTextField txtBVMenge;
	// Panel 12; Neue Produktdeklaration
	private JTextField txtP12n1; 	// Name des Produkts
	private JTextField txtP12n2;	// Wirkungskategorie
	private JTextField txtP12n3;	// Menge
	private JTextField txtP12n4;	// Bewertungsmethode
	// Panel 15; Neuer Charakterisierungsfaktor
	private JTextField txtP15n1; 	// Name des Charakterisierungsfaktors
	private JTextField txtP15n2;	// Name des Flusses
	private JTextField txtP15n3;	// Name der Wirkungskategorie
	private JTextField txtP15n4;	// Faktor
	private JTable flowsTable 		= new JTable();
	private JTable modulesTable 	= new JTable();
	private JTable productsTable 	= new JTable();
	private JTable wksTable 		= new JTable();
	private JTable pbsTable 		= new JTable();
//	private JTable cfsTable 		= new JTable();
//	private JTable bmsTable 		= new JTable();
//	private JTable pkentesTable 	= new JTable();
//	private JTable pktionsTable 	= new JTable();
	private JTable resultsTable 	= new JTable();
	DefaultTableModel flowsTableModel 		= new DefaultTableModel(0,3);
	DefaultTableModel modulesTableModel 	= new DefaultTableModel(0,3);
	DefaultTableModel productsTableModel 	= new DefaultTableModel(0,3);
	DefaultTableModel wksTableModel 		= new DefaultTableModel(0,2);
	DefaultTableModel pbsTableModel 		= new DefaultTableModel(0,3);
//	DefaultTableModel cfsTableModel 		= new DefaultTableModel(0,3);
//	DefaultTableModel bmsTableModel 		= new DefaultTableModel(0,3);
//	DefaultTableModel pkenteTableModel 		= new DefaultTableModel(0,3);
//	DefaultTableModel pktionTableModel 		= new DefaultTableModel(0,3);
	DefaultTableModel resultsTableModel 	= new DefaultTableModel(0,3);

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
		frmIwblciVersion.setTitle("IWB-LCI   Version 0.926");
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
		
		JButton btnAddFluss = new JButton("Fluss hinzuf\u00fcgen");
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
		
		JButton btnAddMod = new JButton("Modul/System hinzuf\u00fcgen");
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
		
		JButton btnAddBed = new JButton("Bedarfsvektor eg\u00e4nzen");
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
		
		JButton btnAddVK = new JButton("VK-Fluss hinzuf\u00fcgen");
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
		JLabel lblInfo3 = new JLabel("Insitut f\u00fcr Werkstoffe im Bauwesen");
		lblInfo3.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_4.add(lblInfo3, "cell 1 4,alignx center,aligny top");
		JLabel lblInfo4 = new JLabel("Universit\u00e4t Stuttgart");
		lblInfo4.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_4.add(lblInfo4, "cell 1 5,alignx center,aligny top");
		JLabel lblInfo5 = new JLabel("Version 0.926   20.07.2017");
		lblInfo5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_4.add(lblInfo5, "cell 1 7,alignx center,aligny top");

		// Panel 5
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5, "listeFluss");		
		panel_5.setLayout(new MigLayout("", "[74px,grow]", "[14px][grow]"));	
		JLabel lblListeDerFlsse = new JLabel("Liste der Fl\u00FCsse");
		lblListeDerFlsse.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_5.add(lblListeDerFlsse, "cell 0 0,alignx center,aligny top");		
		flowsTable.setModel(flowsTableModel);
		TableColumnModel tcm = flowsTable.getColumnModel();
		tcm.getColumn(0).setHeaderValue("Name");
		tcm.getColumn(1).setHeaderValue("Typ");
		tcm.getColumn(2).setHeaderValue("Einheit");
		panel_5.add(new JScrollPane(flowsTable), "cell 0 1,alignx center,aligny top");
		
		// Panel 6
	
		JPanel panel_6 = new JPanel();
		panel.add(panel_6, "listeModul");
		panel_6.setLayout(new MigLayout("", "[74px,grow]", "[14px][grow]"));	
		JLabel lblListeDerProzessmodule = new JLabel("Liste der Prozessmodule");
		lblListeDerProzessmodule.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_6.add(lblListeDerProzessmodule, "cell 0 0,alignx center,aligny top");		
		modulesTable.setModel(modulesTableModel);
		TableColumnModel tcm2 = modulesTable.getColumnModel();
		tcm2.getColumn(0).setHeaderValue("Prozessmodul");
		tcm2.getColumn(1).setHeaderValue("Flussname");
		tcm2.getColumn(2).setHeaderValue("Menge");
		panel_6.add(new JScrollPane(modulesTable), "cell 0 1,alignx center,aligny top");
		
		// Panel 7
		
		JPanel panel_7 = new JPanel();
		panel.add(panel_7, "listeProdukt");	
		panel_7.setLayout(new MigLayout("", "[74px,grow]", "[14px][grow]"));
		JLabel lblListeDerProduktsysteme = new JLabel("Liste der Produktsysteme");
		lblListeDerProduktsysteme.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_7.add(lblListeDerProduktsysteme, "cell 0 0,alignx center,aligny top");
		productsTable.setModel(productsTableModel);
		TableColumnModel tcm3 = productsTable.getColumnModel();
		tcm3.getColumn(0).setHeaderValue("Produktsystem");
		tcm3.getColumn(1).setHeaderValue("Elementtyp");
		tcm3.getColumn(2).setHeaderValue("Elementname");
		panel_7.add(new JScrollPane(productsTable), "cell 0 1,alignx center,aligny top");
		
		// Panel 8
		
		JPanel panel_8 = new JPanel();
		panel.add(panel_8, "berechnen");
		panel_8.setLayout(new MigLayout("", "[74px,grow]", "[14px][grow]"));
		JLabel lblBerechnung = new JLabel("Umweltvektoren der Produktsysteme");
		lblBerechnung.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_8.add(lblBerechnung, "cell 0 0,alignx center,aligny top");
		resultsTable.setModel(resultsTableModel);
		TableColumnModel tcm4 = resultsTable.getColumnModel();
		tcm4.getColumn(0).setHeaderValue("Produktsystem");
		tcm4.getColumn(1).setHeaderValue("Fluss");
		tcm4.getColumn(2).setHeaderValue("Menge");
		panel_8.add(new JScrollPane(resultsTable), "cell 0 1,alignx center,aligny top");
		
		// Panel 9
		
		JPanel panel_9 = new JPanel();
		panel.add(panel_9, "todo");
		panel_9.setLayout(new MigLayout("", "[108px,grow][200px][108px,grow]", 
				"[20px][20px][40px][20px][20px][20px][20px,grow][20px]"));
		JLabel lblTodo1 = new JLabel("IWB-LCI");
		lblTodo1.setFont(new Font("Tahoma", Font.BOLD, 26));
		panel_9.add(lblTodo1, "cell 1 2,alignx center,aligny top");
		JLabel lblTodo2 = new JLabel("");
		lblTodo2.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_9.add(lblTodo2, "cell 1 3,alignx center,aligny top");
		JLabel lblTodo3 = new JLabel("Diese Funktion ist noch nicht verfügbar");		
		lblTodo3.setFont(new Font("Tahoma", Font.ITALIC, 14));
		panel_9.add(lblTodo3, "cell 1 4,alignx center,aligny top");
		JLabel lblTodo4 = new JLabel("");
		lblTodo4.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_9.add(lblTodo4, "cell 1 5,alignx center,aligny top");
		JLabel lblTodo5 = new JLabel("Version 0.926   20.07.2017");
		lblTodo5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_9.add(lblTodo5, "cell 1 7,alignx center,aligny top");
		
		// Panel 10
		
		JPanel panel_10 = new JPanel();
		panel.add(panel_10, "editModul");
		panel_10.setLayout(new MigLayout("", "[108px,grow][108px][108px][108px,grow]", 
				"[20px][20px][20px][20px][20px][20px][20px][20px][20px,grow]"));
		JLabel lblEditProzessmodul = new JLabel("Prozessmodul editieren");
		lblEditProzessmodul.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_10.add(lblEditProzessmodul, "flowy,cell 1 0 2 1,alignx center,growy");
		
		JLabel lblModName3 = new JLabel("Name des Prozessmoduls");
		panel_10.add(lblModName3, "cell 1 1,grow");
		
		txtModName3 = new JTextField();
		txtModName3.setText("");
		panel_10.add(txtModName3, "cell 2 1,grow");
		txtModName3.setColumns(10);
		
		JLabel lblStatus4 = new JLabel(">>> ... <<<");
		panel_10.add(lblStatus4, "cell 0 6 4 1,alignx center");
		
		JButton btnEditModul = new JButton("vorhandene Flussdaten des Moduls bearbeiten");
		panel_10.add(btnEditModul, "cell 1 2 2 1,alignx center");
		
		JLabel lblFlussName1 = new JLabel("Name des Flusses");
		panel_10.add(lblFlussName1, "cell 1 3,grow");
		
		txtFlussName2 = new JTextField();
		txtFlussName2.setText("");
		panel_10.add(txtFlussName2, "cell 2 3,grow");
		txtFlussName2.setColumns(10);
		txtFlussName2.setEnabled(false);
		
		JLabel lblMenge2 = new JLabel("Menge");
		panel_10.add(lblMenge2, "cell 1 4,grow");
		
		txtMenge2 = new JTextField();
		txtMenge2.setText("");
		panel_10.add(txtMenge2, "cell 2 4,grow");
		txtMenge2.setColumns(10);
		txtMenge2.setEnabled(false);
		
		JButton btnEditFluss = new JButton("Fluss hinzuf\u00fcgen oder bearbeiten");
		btnEditFluss.setEnabled(false);
		panel_10.add(btnEditFluss, "cell 1 5,alignx center");
		
		JButton btnFertig3 = new JButton("fertig");
		btnFertig3.setEnabled(false);
		panel_10.add(btnFertig3, "cell 2 5,alignx center");
				
		// Panel 11
		
		JPanel panel_11 = new JPanel();
		panel.add(panel_11, "neuWK");
		panel_11.setLayout(new MigLayout("", "[108px,grow][108px][108px][108px,grow]", 
				"[20px][20px][20px][20px][20px][20px][20px][20px][20px,grow]"));
		JLabel lblNewWK = new JLabel("Neue Wirkungskategorie");
		lblNewWK.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_11.add(lblNewWK, "flowy,cell 1 0 2 1,alignx center,growy");	

		JLabel lblName2 = new JLabel("Name der Wirkungskategorie");
		panel_11.add(lblName2, "cell 1 1,grow");
		
		txtNameWK = new JTextField();
		txtNameWK.setText("");
		panel_11.add(txtNameWK, "cell 2 1,grow");
		txtNameWK.setColumns(10);
		
		JLabel lblIndi = new JLabel("Indikator");
		panel_11.add(lblIndi, "cell 1 2,grow");
		
		JComboBox<Wirkungsindikator> comboBoxWK = new JComboBox<Wirkungsindikator>();
		comboBoxWK.setModel(new DefaultComboBoxModel<Wirkungsindikator>(Wirkungsindikator.values()));
		panel_11.add(comboBoxWK, "cell 2 2,grow");
		
		JLabel lblStatusWK = new JLabel(">>> ... <<<");
		panel_11.add(lblStatusWK, "cell 0 4 4 1,alignx center");
		
		JButton btnSpeiWK = new JButton("speichern");
		panel_11.add(btnSpeiWK, "cell 1 3 2 1,alignx center");	
		
		// Panel 12
		
		JPanel panel_12 = new JPanel();
		panel.add(panel_12, "neuPB");
		panel_12.setLayout(new MigLayout("", "[108px,grow][108px][108px][108px,grow]", 
				"[20px][20px][20px][20px][20px][20px][20px][20px][20px][20px][20px,grow]"));
		JLabel lblP12n2 = new JLabel("Neue Produktdeklaration");
		lblP12n2.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_12.add(lblP12n2, "flowy,cell 1 0 2 1,alignx center,growy");
		
		JLabel lblP12n3 = new JLabel("Name der Produktdeklaration");
		panel_12.add(lblP12n3, "cell 1 1,grow");
		
		txtP12n1 = new JTextField();
		txtP12n1.setText("");
		panel_12.add(txtP12n1, "cell 2 1,grow");
		txtP12n1.setColumns(10);
		
		JLabel lblP12n6 = new JLabel("Bewertungsmethode");
		panel_12.add(lblP12n6, "cell 1 2,grow");
		
		txtP12n4 = new JTextField();
		txtP12n4.setText("");
		panel_12.add(txtP12n4, "cell 2 2,grow");
		txtP12n4.setColumns(10);
		
		JLabel lblP12n8 = new JLabel("... neu anlegen, wenn nicht vorhanden");
		panel_12.add(lblP12n8, "cell 1 3,grow");
		
		JCheckBox chbP12n1 = new JCheckBox();
		panel_12.add(chbP12n1, "cell 2 3,grow");
		chbP12n1.setEnabled(true);
		
		JLabel lblP12n1 = new JLabel(">>> ... <<<");
		panel_12.add(lblP12n1, "cell 0 9 4 1,alignx center");
		
		JButton btnP12n1 = new JButton("neue Produktdeklaration anlegen");
		panel_12.add(btnP12n1, "cell 1 4 2 1,alignx center");
		
		JLabel lblP12n4 = new JLabel("Wirkungskategorie");
		panel_12.add(lblP12n4, "cell 1 5,grow");
		
		txtP12n2 = new JTextField();
		txtP12n2.setText("");
		panel_12.add(txtP12n2, "cell 2 5,grow");
		txtP12n2.setColumns(10);
		txtP12n2.setEnabled(false);
		
		JLabel lblP12n7 = new JLabel("... ggf. in Bewertungsmethode neu anlegen");
		panel_12.add(lblP12n7, "cell 1 6,grow");
		
		JCheckBox chbP12n2 = new JCheckBox();
		panel_12.add(chbP12n2, "cell 2 6,grow");
		chbP12n2.setEnabled(false);
		
		JLabel lblP12n5 = new JLabel("Menge");
		panel_12.add(lblP12n5, "cell 1 7,grow");
		
		txtP12n3 = new JTextField();
		txtP12n3.setText("");
		panel_12.add(txtP12n3, "cell 2 7,grow");
		txtP12n3.setColumns(10);
		txtP12n3.setEnabled(false);
		
		JButton btnP12n2 = new JButton("Wirkung hinzuf\u00fcgen");
		btnP12n2.setEnabled(false);
		panel_12.add(btnP12n2, "cell 1 8,alignx center");
		
		JButton btnP12n3 = new JButton("fertig");
		btnP12n3.setEnabled(false);
		panel_12.add(btnP12n3, "cell 2 8,alignx center");
		
		// Panel 13
		
		JPanel panel_13 = new JPanel();
		panel.add(panel_13, "listeWKs");		
		panel_13.setLayout(new MigLayout("", "[74px,grow]", "[14px][grow]"));	
		JLabel lblListeDerWKs = new JLabel("Liste der Wirkungskategorien");
		lblListeDerWKs.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_13.add(lblListeDerWKs, "cell 0 0,alignx center,aligny top");		
		wksTable.setModel(wksTableModel);
		TableColumnModel tcm5 = wksTable.getColumnModel();
		tcm5.getColumn(0).setHeaderValue("Name");
		tcm5.getColumn(1).setHeaderValue("Wirkungsindikator");
		panel_13.add(new JScrollPane(wksTable), "cell 0 1,alignx center,aligny top");
		
		// Panel 14
		
		JPanel panel_14 = new JPanel();
		panel.add(panel_14, "listePBs");
		panel_14.setLayout(new MigLayout("", "[74px,grow]", "[14px][grow]"));	
		JLabel lblListeDerPBs = new JLabel("Liste der Produktdeklarationen");
		lblListeDerPBs.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_14.add(lblListeDerPBs, "cell 0 0,alignx center,aligny top");		
		pbsTable.setModel(pbsTableModel);
		TableColumnModel tcm6 = pbsTable.getColumnModel();
		tcm6.getColumn(0).setHeaderValue("Produkt / Bewertung");
		tcm6.getColumn(1).setHeaderValue("Wirkungskategorie");
		tcm6.getColumn(2).setHeaderValue("Menge");
		panel_14.add(new JScrollPane(pbsTable), "cell 0 1,alignx center,aligny top");
		
		// Panel 15
		
		JPanel panel_15 = new JPanel();
		panel.add(panel_15, "neuCF");
		panel_15.setLayout(new MigLayout("", "[108px,grow][108px][108px][108px,grow]", 
				"[20px][20px][20px][20px][20px][20px][20px][20px][20px][20px][20px,grow]"));
		JLabel lblP15n2 = new JLabel("Neuer Charakterisierungsfaktor");
		lblP15n2.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_15.add(lblP15n2, "flowy,cell 1 0 2 1,alignx center,growy");
		
		JLabel lblP15n3 = new JLabel("Name der Charakterisierungsfaktors");
		panel_15.add(lblP15n3, "cell 1 1,grow");
		
		txtP15n1 = new JTextField();
		txtP15n1.setText("");
		panel_15.add(txtP15n1, "cell 2 1,grow");
		txtP15n1.setColumns(10);
		
		JLabel lblP15n4 = new JLabel("Name des Flusses");
		panel_15.add(lblP15n4, "cell 1 2,grow");
		
		txtP15n2 = new JTextField();
		txtP15n2.setText("");
		panel_15.add(txtP15n2, "cell 2 2,grow");
		txtP15n2.setColumns(10);
		
		JLabel lblP15n5 = new JLabel("Name der Wirkungskategorie");
		panel_15.add(lblP15n5, "cell 1 3,grow");
		
		txtP15n3 = new JTextField();
		txtP15n3.setText("");
		panel_15.add(txtP15n3, "cell 2 3,grow");
		txtP15n3.setColumns(10);
		
		JLabel lblP15n6 = new JLabel("Faktor");
		panel_15.add(lblP15n6, "cell 1 4,grow");
		
		txtP15n4 = new JTextField();
		txtP15n4.setText("");
		panel_15.add(txtP15n4, "cell 2 4,grow");
		txtP15n4.setColumns(10);
		
		JButton btnP15n1 = new JButton("speichern");
		panel_15.add(btnP15n1, "cell 1 5 2 1,alignx center");	
		
		JLabel lblP15n1 = new JLabel(">>> ... <<<");
		panel_15.add(lblP15n1, "cell 0 6 4 1,alignx center");
		
		cl.show(panel, "leer");
		
		/*
		 * Organisation der Menuleiste
		 */
		
		JMenuBar menuBar = new JMenuBar();
		frmIwblciVersion.setJMenuBar(menuBar);
		
		JMenu mnDatei = new JMenu("Datei");
		menuBar.add(mnDatei);
		
		JMenuItem mntmNewMenuItem = new JMenuItem();
		mntmNewMenuItem.setAction(saveAction);
		mnDatei.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem();
		mntmNewMenuItem_1.setAction(loadAction);
		mnDatei.add(mntmNewMenuItem_1);
		
		JMenu mnNew = new JMenu("Neu");
		menuBar.add(mnNew);
		
		JMenuItem mntmFlow = new JMenuItem();
		mntmFlow.setAction(newFlowAction);
		mnNew.add(mntmFlow);
		
		JMenuItem mntmProcessModule = new JMenuItem();
		mntmProcessModule.setAction(newModuleAction);
		mnNew.add(mntmProcessModule);
		
		JMenuItem mntmProductSystem = new JMenuItem();
		mntmProductSystem.setAction(newProductAction);
		mnNew.add(mntmProductSystem);
		
		JMenuItem mntmWK = new JMenuItem();
		mntmWK.setAction(newWKAction);
		mnNew.add(mntmWK);
		
		JMenuItem mntmPB = new JMenuItem();
		mntmPB.setAction(newPBAction);
		mnNew.add(mntmPB);
		
		JMenuItem mntmCF = new JMenuItem();
		mntmCF.setAction(newCFAction);
		mnNew.add(mntmCF);
		
		JMenuItem mntmBM = new JMenuItem();
		mntmBM.setAction(newBMAction);
		mnNew.add(mntmBM);
		
		JMenuItem mntmPKente = new JMenuItem();
		mntmPKente.setAction(newPKenteAction);
		mnNew.add(mntmPKente);
		
		JMenuItem mntmPKtion = new JMenuItem();
		mntmPKtion.setAction(newPKtionAction);
		mnNew.add(mntmPKtion);				
			
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		JMenuItem mntmEditPM = new JMenuItem("Prozessmodule");
		mntmEditPM.setAction(editModuleAction);
		mnEdit.add(mntmEditPM);
		
		JMenu mnListe = new JMenu("Liste");
		menuBar.add(mnListe);
		
		JMenuItem mntmFlsse = new JMenuItem();
		mntmFlsse.setAction(listFlowAction);
		mnListe.add(mntmFlsse);
		
		JMenuItem mntmProzessmodule = new JMenuItem();
		mntmProzessmodule.setAction(listModuleAction);
		mnListe.add(mntmProzessmodule);
		
		JMenuItem mntmProduktsysteme = new JMenuItem();
		mntmProduktsysteme.setAction(listProductAction);
		mnListe.add(mntmProduktsysteme);

		JMenuItem mntmWKs = new JMenuItem();
		mntmWKs.setAction(listWKsAction);
		mnListe.add(mntmWKs);

		JMenuItem mntmPBs = new JMenuItem();
		mntmPBs.setAction(listPBsAction);
		mnListe.add(mntmPBs);	
		
		JMenuItem mntmCFs = new JMenuItem();
		mntmCFs.setAction(listCFsAction);
		mnListe.add(mntmCFs);

		JMenuItem mntmBMs = new JMenuItem();
		mntmBMs.setAction(listBMsAction);
		mnListe.add(mntmBMs);		

		JMenuItem mntmPKentes = new JMenuItem();
		mntmPKentes.setAction(listPKentesAction);
		mnListe.add(mntmPKentes);

		JMenuItem mntmPKtions = new JMenuItem();
		mntmPKtions.setAction(listPKtionsAction);
		mnListe.add(mntmPKtions);
		
		JMenu mnBerechnen = new JMenu("Berechnen");
		menuBar.add(mnBerechnen);
		
		JMenuItem mntmLci = new JMenuItem("LCI");
		mntmLci.setAction(calculateAction);
		mnBerechnen.add(mntmLci);
		
		JMenu mnHilfe = new JMenu("Hilfe");
		menuBar.add(mnHilfe);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("New menu item");
		mntmNewMenuItem_2.setAction(aboutAction);
		mnHilfe.add(mntmNewMenuItem_2);
		
		/*
		 * Aktivitäten der Schaltflächen
		 */
		
		/*
		 * neuer Fluss
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
						txtName.setText("");
						comboBox.setSelectedIndex(0);
						comboBox_1.setSelectedIndex(0);
					}	
				} 		
			}
		});

		/*
		 * neues Prozessmodul
		 */
		
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
					lblStatus2.setText(">>> unvollst\u00e4ndige Eingabe <<<");
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
						txtFlussName.setText("");
						txtMenge.setText("");
						btnFertig.setEnabled(true);
						int anzPFluss = allModules.get(mname).getProduktflussvektor().size();
						int anzEFluss = allModules.get(mname).getElementarflussvektor().size();
						int anzGesamt = anzPFluss + anzEFluss;
						lblStatus2.setText(">>> Prozessmodul " + mname + " besitzt " +
								anzGesamt + " Fl\u00fcsse <<<");
						
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

		/*
		 * neues Produktsystem
		 */
		
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
						lblStatus3.setText(">>> unvollst\u00e4ndige Eingabe <<<");
					}
					if (modname.equals(txtPSName.getText())) {
						lblStatus3.setText(">>> unzul\u00e4ssige Rekursion <<<");
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
						} else {
							allProSys.get(txtPSName.getText()).addProzessmodul(allProSys.get(modname));
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
					lblStatus3.setText(">>> unvollst\u00e4ndige Eingabe <<<");
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
						lblStatus3.setText(">>> Der Bedarfsvektor enth\u00e4lt " + 
								allBVs.get(txtPSName.getText()).getBV().size() + " Fl\u00dcsse <<<");
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
					lblStatus3.setText(">>> unvollst\u00e4ndige Eingabe <<<");
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
						lblStatus3.setText(">>> Der VK-Vektor enth\u00e4lt " + 
								allVKs.get(txtPSName.getText()).getVk().size() + " Fl\u00fcsse <<<");										
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
		
		/*
		 * neue Wirkungskategorie
		 */
		
		btnSpeiWK.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String name = txtNameWK.getText();	
				Wirkungsindikator wi = comboBoxWK.getItemAt(comboBoxWK.getSelectedIndex());
				if (name.equals("")) {
					lblStatusWK.setText(">>> Es wurde kein Name angegeben. <<<");
				} else {
					boolean nameVorhanden = false;
					for(Wirkungskategorie wk : allWKs) {
						if (name.equals(wk.getName())) {
							nameVorhanden = true;
						}
					}
					if (nameVorhanden == true) {
						lblStatusWK.setText(">>> Der angegebene Name ist bereits vorhanden. <<<");
					} else {
						allWKs.add(new Wirkungskategorie(name, wi));
						lblStatusWK.setText(">>> Anzahl Wirkungskategorien: " + allWKs.size() + " <<<");
						txtNameWK.setText("");
						comboBoxWK.setSelectedIndex(0);
					}	
				} 		
			}
		});
		
		/*
		 * neue Produktdeklaration (= neues ProduktBilanziert-Objekt)
		 */

		btnP12n1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String name = txtP12n1.getText();	
				if (name.equals("")) {
					lblP12n1.setText(">>> Es wurde kein Name angegeben. <<<");
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
					for(String mod : allPBs.keySet()) {
						if (name.equals(mod)) {
							nameVorhanden = true;
						}
					}
					
					// auch Produktkomponente und Produktkomposition müssen 
					// ausgeschlossen werden!!!
					
					if (nameVorhanden == true) {
						lblP12n1.setText(">>> Der angegebene Name ist bereits vorhanden. <<<");
					} else {
						String bwName = txtP12n4.getText();	
						boolean bwNew = chbP12n1.isSelected();
						boolean bwVorhanden = allBWs.keySet().contains(bwName);

						if (bwVorhanden == false) {
							lblP12n1.setText(">>> Die Bewertungsmethode ist unbekannt. <<<");
							if (bwNew == true) {
								Bewertungsmethode bwNeu = new Bewertungsmethode(bwName);
								allBWs.put(bwName, bwNeu);
								allPBs.put(name, new ProduktBilanziert(name));
								allPBs.get(name).setBM(bwNeu);
								lblP12n1.setText(">>> Anzahl Produktdeklarationen: " + allPBs.size() + " <<<");
								btnP12n1.setEnabled(false);
								txtP12n1.setEnabled(false);
								btnP12n2.setEnabled(true);
								txtP12n2.setEnabled(true);
								txtP12n3.setEnabled(true);	
								txtP12n4.setEnabled(false);	
								chbP12n1.setEnabled(false);							
								chbP12n2.setEnabled(true);
								chbP12n1.setSelected(false);		
								chbP12n2.setSelected(false);		
							} 
						} else {
							allPBs.put(name, new ProduktBilanziert(name));
							allPBs.get(name).setBM(allBWs.get(bwName));
							lblP12n1.setText(">>> Anzahl Produktdeklarationen: " + allPBs.size() + " <<<");
							btnP12n1.setEnabled(false);
							txtP12n1.setEnabled(false);
							btnP12n2.setEnabled(true);
							txtP12n2.setEnabled(true);
							txtP12n3.setEnabled(true);	
							txtP12n4.setEnabled(false);	
							chbP12n1.setEnabled(false);
							chbP12n2.setEnabled(true);	
							chbP12n1.setSelected(false);		
							chbP12n2.setSelected(false);
						}
					} 
				} 		
			}
		});
		
		btnP12n2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String fname = txtP12n2.getText();
				boolean wkNew = chbP12n2.isSelected();
				String fmenge = txtP12n3.getText();
				Double menge;
				try {
					menge = Double.parseDouble(fmenge);
				} catch (NumberFormatException e){
					menge = 0.0;
				}
				if (fname.equals("") || (menge == 0.0)) {
					lblP12n1.setText(">>> unvollst\u00e4ndige Eingabe <<<");
				} else {
					boolean nameVorhanden = false;
					for(Wirkungskategorie wk1 : allWKs) {
						if (fname.equals(wk1.getName())) {
							nameVorhanden = true;
						}
					}
					if (nameVorhanden == true) {
						Wirkungskategorie wk2 = null;
						for(Wirkungskategorie wk1 : allWKs){
							if (fname.equals(wk1.getName())){
								wk2 = wk1;
							}
						}

						String mname = txtP12n1.getText();
						String bmName = txtP12n4.getText();
						if (wkNew == true) {
							allBWs.get(bmName).addWK(wk2);
						}
						if (allBWs.get(bmName).kategorieListe().contains(wk2)) {
							allPBs.get(mname).addWirkung(wk2, menge);
							txtP12n2.setText("");
							txtP12n3.setText("");
							btnP12n3.setEnabled(true);
							int anzPWKs = allPBs.get(mname).getWirkungsvektor(allBWs.get(bmName)).size();					
							lblP12n1.setText(">>> Die Produktdeklaration " + mname + " besitzt " +
									anzPWKs + " Wirkungen <<<");
						} else {
							lblP12n1.setText(">>> Die Wirkungskategorie ist nicht Bestandteil"
									+ " der Bewertungsmethode <<<");
						}						
					} else {
						lblP12n1.setText(">>> unbekannte Wirkung <<<");
					}					
				}
			}
		});
		
		btnP12n3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnP12n1.setEnabled(true);
				txtP12n2.setText("");
				txtP12n3.setText("");
				txtP12n1.setText("");
				txtP12n4.setText("");
				btnP12n2.setEnabled(false);
				btnP12n3.setEnabled(false);
				txtP12n1.setEnabled(true);
				txtP12n2.setEnabled(false);
				txtP12n3.setEnabled(false);
				txtP12n4.setEnabled(true);					
				chbP12n1.setEnabled(true);
				chbP12n2.setEnabled(false);	
				chbP12n1.setSelected(false);		
				chbP12n2.setSelected(false);
				lblP12n1.setText(">>> ... <<<");
			}
		});

	
		/*
		 * Prozessmodul editieren
		 */
	
		btnEditModul.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String name = txtModName3.getText();	
				if (name.equals("")) {
					lblStatus4.setText(">>> Es wurde kein Name angegeben. <<<");
				} else {
					boolean nameModules = false;			
					
					for(String mod : allModules.keySet()) {
						if (name.equals(mod)) {
							nameModules = true;
						}
					}
					if (nameModules == false) {
						lblStatus4.setText(">>> Es gibt kein Modul mit diesem Namen. <<<");
					} else {
						lblStatus4.setText(">>> Mengenangabe 0 l\u00f6scht einen vorhandenen Fluss. <<<");
						btnEditModul.setEnabled(false);
						txtModName3.setEnabled(false);
						btnEditFluss.setEnabled(true);
						btnFertig3.setEnabled(true);
						txtFlussName2.setEnabled(true);
						txtMenge2.setEnabled(true);
						
					}				
				}			
			}		
		});
		
		btnEditFluss.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String fname = txtFlussName2.getText();
				String fmenge = txtMenge2.getText();
				Double menge = 0.0;
				Boolean mengeZahl = true;
				try {
						menge = Double.parseDouble(fmenge);
					} catch (NumberFormatException e){
						mengeZahl = false;
				}
				if (fname.equals("") || (mengeZahl == false)) {
					lblStatus4.setText(">>> unkorrekte oder unvollst\u00e4ndige Eingabe <<<");
				} else {
					boolean nameVorhanden = false;
					Fluss fo = allFlows.getFirst();
					for(Fluss pf : allFlows) {
						if (fname.equals(pf.getName())) {
							nameVorhanden = true;
							fo = pf;
						}
					}
					if (nameVorhanden == true) {
						Boolean nameInModul = false;
						String mname = txtModName3.getText();
						if (allModules.get(mname).getElementarflussvektor().
								containsKey(fo)){
							nameInModul = true;
						}
						if (allModules.get(mname).getProduktflussvektor().
								containsKey(fo)){
							nameInModul = true;
						}
						if (nameInModul==true) {
							if (menge == 0.0) {
								allModules.get(mname).removeFluss(fo);
								lblStatus4.setText(">>> Der angegebene Fluss wurde aus dem Modul gel\u00f6scht. <<<");
							} else {
								allModules.get(mname).removeFluss(fo);
								allModules.get(mname).addFluss(fo, menge);
								lblStatus4.setText(">>> Die Mengenangabe wurde ge\u00e4ndert. <<<");
							}
						} else {
							if (menge == 0.0) {
								lblStatus4.setText(">>> Mengenangabe fehlt. <<<");
							} else {
								allModules.get(mname).addFluss(fo, menge);
								lblStatus4.setText(">>> Der Fluss wurde hinzugef\u00dcgt. <<<");								
							}							
						}				
					} else {
						lblStatus4.setText(">>> unbekannter Flussname <<<");
					}					
				}
			}
		});
		
		btnFertig3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnEditModul.setEnabled(true);
				txtFlussName2.setText("");
				txtMenge2.setText("");
				txtModName3.setText("");
				btnEditFluss.setEnabled(false);
				btnFertig3.setEnabled(false);
				txtModName3.setEnabled(true);
				txtFlussName2.setEnabled(false);
				txtMenge2.setEnabled(false);
				lblStatus4.setText(">>> ... <<<");
			}
		});
	}
	
	/*
	 * Actions der Menupunkte
	 */

	private class newFlowAction extends AbstractAction {
		private static final long serialVersionUID = 3159283296670804375L;
		public newFlowAction() {
			putValue(NAME, "Fluss");
			putValue(SHORT_DESCRIPTION, "neues Flussobjekt erfassen");
		}
		public void actionPerformed(ActionEvent e) {
			cl.show(panel, "neuFluss");
		}
	}
	private class newModuleAction extends AbstractAction {
		private static final long serialVersionUID = 6190606710625748526L;
		public newModuleAction() {
			putValue(NAME, "Prozessmodul");
			putValue(SHORT_DESCRIPTION, "neues Prozessmodul erfassen");
		}
		public void actionPerformed(ActionEvent e) {
			cl.show(panel, "neuModul");
		}
	}
	private class newProductAction extends AbstractAction {
		private static final long serialVersionUID = -7757652453649226474L;
		public newProductAction() {
			putValue(NAME, "Produktsystem");
			putValue(SHORT_DESCRIPTION, "neues Produktsystem erfassen");
		}
		public void actionPerformed(ActionEvent e) {
			cl.show(panel, "neuProdukt");
		}
	}
	
	private class newWKAction extends AbstractAction {	
		private static final long serialVersionUID = 226480034134794912L;
		public newWKAction() {
			putValue(NAME, "Wirkungskategorie");
			putValue(SHORT_DESCRIPTION, "neue Wirkungskategorie erfassen");
		}
		public void actionPerformed(ActionEvent e) {
			cl.show(panel, "neuWK");
		}
	}
	private class newPBAction extends AbstractAction {
		private static final long serialVersionUID = -7489938933445684497L;
		public newPBAction() {
			putValue(NAME, "Produktdeklaration");
			putValue(SHORT_DESCRIPTION, "neue Produktdeklaration erfassen");
		}
		public void actionPerformed(ActionEvent e) {
			cl.show(panel, "neuPB");
		}
	}
	private class newCFAction extends AbstractAction {
		private static final long serialVersionUID = -7489938933445684497L;
		public newCFAction() {
			putValue(NAME, "Charakterisierungsfaktor");
			putValue(SHORT_DESCRIPTION, "neuen Charakterisierungsfaktor erfassen");
		}
		public void actionPerformed(ActionEvent e) {
			cl.show(panel, "neuCF");
		}
	}
	private class newBMAction extends AbstractAction {
		private static final long serialVersionUID = -7489938933445684497L;
		public newBMAction() {
			putValue(NAME, "Bewertungsmethode");
			putValue(SHORT_DESCRIPTION, "neue Bewertungsmethode erfassen");
		}
		public void actionPerformed(ActionEvent e) {
			cl.show(panel, "todo");
		}
	}
	private class newPKenteAction extends AbstractAction {
		private static final long serialVersionUID = -7489938933445684497L;
		public newPKenteAction() {
			putValue(NAME, "Produktkomponente");
			putValue(SHORT_DESCRIPTION, "neue Produktkomponente erfassen");
		}
		public void actionPerformed(ActionEvent e) {
			cl.show(panel, "todo");
		}
	}
	private class newPKtionAction extends AbstractAction {
		private static final long serialVersionUID = -7489938933445684497L;
		public newPKtionAction() {
			putValue(NAME, "Produktkomposition");
			putValue(SHORT_DESCRIPTION, "neue Produktkomposition erfassen");
		}
		public void actionPerformed(ActionEvent e) {
			cl.show(panel, "todo");
		}
	}
	
	private class editModuleAction extends AbstractAction {
		private static final long serialVersionUID = -4615227267646047497L;
		public editModuleAction() {
			putValue(NAME, "Prozessmodul");
			putValue(SHORT_DESCRIPTION, "Prozessmodul editieren");
		}
		public void actionPerformed(ActionEvent e) {
			cl.show(panel, "editModul");
		}
	}

	private class listFlowAction extends AbstractAction {
		private static final long serialVersionUID = 3929527112031439132L;
		public listFlowAction() {
			putValue(NAME, "Fl\u00FCsse");
			putValue(SHORT_DESCRIPTION, "Liste aller Fl\u00fcsse");
		}
		public void actionPerformed(ActionEvent e) {
			flowsTableModel.setRowCount(0);
			for(Fluss fluss : allFlows) {
				flowsTableModel.addRow(new Object[] {fluss.getName(), fluss.getTyp(), fluss.getEinheit()});
			}
			
			cl.show(panel, "listeFluss");
		}
	}
	private class listModuleAction extends AbstractAction {
		private static final long serialVersionUID = -23206034834972545L;
		public listModuleAction() {
			putValue(NAME, "Prozessmodule");
			putValue(SHORT_DESCRIPTION, "Liste aller Prozessmodule");
		}
		public void actionPerformed(ActionEvent e) {
			modulesTableModel.setRowCount(0);
			for(String mn : allModules.keySet()) {
				Prozessmodul akModul = allModules.get(mn);
				modulesTableModel.addRow(new Object[] {mn, "", ""});
				for(Fluss pf : akModul.getElementarflussvektor().keySet()){
					modulesTableModel.addRow(new Object[] {"", pf.getName(), 
							akModul.getElementarflussvektor().get(pf)});
				}						
				for(Fluss pf : akModul.getProduktflussvektor().keySet()){
					modulesTableModel.addRow(new Object[] {"", pf.getName(), 
							akModul.getProduktflussvektor().get(pf)});				
				}
			}		
			cl.show(panel, "listeModul");
		}
	}
	private class listProductAction extends AbstractAction {
		private static final long serialVersionUID = 9038442522125086919L;
		public listProductAction() {
			putValue(NAME, "Produktsysteme");
			putValue(SHORT_DESCRIPTION, "Liste aller Produktsysteme");
		}
		public void actionPerformed(ActionEvent e) {
			productsTableModel.setRowCount(0);
			for(String psn : allProSys.keySet()) {
				productsTableModel.addRow(new Object[] {psn, "", ""});
				for (String mni : allMNLs.get(psn).getMnl()){
					boolean typmod = false;
					for(String modn2 : allModules.keySet()) {
						if (mni.equals(modn2)) {
							typmod = true;
						}
					}
					if (typmod == true){
						productsTableModel.addRow(new Object[] {"","Prozessmodul", mni});							
					} else {
						productsTableModel.addRow(new Object[] {"","Subsystem", mni});	
					}					
				}
				for (Fluss bvf : allBVs.get(psn).getBV().keySet()) {
					productsTableModel.addRow(new Object[] {"" ,"Bedarf" 
							,"" + bvf.getName() + " (" + allBVs.get(psn).getBV().get(bvf) + 
							" " + bvf.getEinheit()+")"});		
				}			
			}			
			cl.show(panel, "listeProdukt");
		}
	}
	private class listWKsAction extends AbstractAction {
		private static final long serialVersionUID = 3929527112031439132L;
		public listWKsAction() {
			putValue(NAME, "Wirkungskategorien");
			putValue(SHORT_DESCRIPTION, "Liste aller Wirkungskategorien");
		}
		public void actionPerformed(ActionEvent e) {
			wksTableModel.setRowCount(0);
			for(Wirkungskategorie wk : allWKs) {
				wksTableModel.addRow(new Object[] {wk.getName(), wk.getEinheit()});
			}
			
			cl.show(panel, "listeWKs");
		}
	}
	private class listPBsAction extends AbstractAction {
		private static final long serialVersionUID = 3929527112031439132L;
		public listPBsAction() {
			putValue(NAME, "Produktdeklarationen");
			putValue(SHORT_DESCRIPTION, "Liste aller Produktdeklarationen");
		}
		public void actionPerformed(ActionEvent e) {
			pbsTableModel.setRowCount(0);
			for(String mn : allPBs.keySet()) {
				ProduktBilanziert akPB = allPBs.get(mn);
				pbsTableModel.addRow(new Object[] {mn + " / " + akPB.getBM().getName(), "", ""});
				Bewertungsmethode akBM = akPB.getBM();
				for(Wirkungskategorie w : akPB.getWirkungsvektor(akBM).keySet()){
					pbsTableModel.addRow(new Object[] {"", w.getName(), 
							akPB.getWirkungsvektor(akBM).get(w)});
				}						
			}		
			cl.show(panel, "listePBs");
		}
	}
	private class listCFsAction extends AbstractAction {
		private static final long serialVersionUID = 3929527112031439132L;
		public listCFsAction() {
			putValue(NAME, "Charakterisierungsfaktoren");
			putValue(SHORT_DESCRIPTION, "Liste aller Charakterisierungsfaktoren");
		}
		public void actionPerformed(ActionEvent e) {
			cl.show(panel, "todo");
		}
	}
	private class listBMsAction extends AbstractAction {
		private static final long serialVersionUID = 3929527112031439132L;
		public listBMsAction() {
			putValue(NAME, "Bewertungsmethoden");
			putValue(SHORT_DESCRIPTION, "Liste aller Bewertungsmethoden");
		}
		public void actionPerformed(ActionEvent e) {
			cl.show(panel, "todo");
		}
	}
	private class listPKentesAction extends AbstractAction {
		private static final long serialVersionUID = 3929527112031439132L;
		public listPKentesAction() {
			putValue(NAME, "Produktkomponenten");
			putValue(SHORT_DESCRIPTION, "Liste aller Produktkomponenten");
		}
		public void actionPerformed(ActionEvent e) {
			cl.show(panel, "todo");
		}
	}
	private class listPKtionsAction extends AbstractAction {
		private static final long serialVersionUID = 3929527112031439132L;
		public listPKtionsAction() {
			putValue(NAME, "Produktkompositionen");
			putValue(SHORT_DESCRIPTION, "Liste aller Produktkompositionen");
		}
		public void actionPerformed(ActionEvent e) {
			cl.show(panel, "todo");
		}
	}

	private class calculateAction extends AbstractAction {
		private static final long serialVersionUID = 7449057427765901652L;
		public calculateAction() {
			putValue(NAME, "Sachbilanz berechnen");
			putValue(SHORT_DESCRIPTION, "Sachbilanz aller Produktsysteme");
		}
		public void actionPerformed(ActionEvent e) {		
			resultsTableModel.setRowCount(0);
			HashMap<Fluss, Double> sysErgebnis = new HashMap<Fluss, Double>();
			if (allProSys.size() > 0) {
				for(String sysName : allProSys.keySet()) {
					resultsTableModel.addRow(new Object[] {sysName,"",""});
					Produktsystem sysAktuell = allProSys.get(sysName);
					try {
						if (sysAktuell.getElementarflussvektor().size() > 0) {
							sysErgebnis = sysAktuell.getElementarflussvektor();
							for(Fluss sysFluss : sysErgebnis.keySet()){
								resultsTableModel.addRow(new Object[] {"",sysFluss.getName(),"" + 
									sysErgebnis.get(sysFluss) + " " + sysFluss.getEinheit() + ""});
							}
						}
					} catch (ArithmeticException vz) {
							resultsTableModel.addRow(new Object[] 
									{"",vz.getMessage(),""});					
					}					 
				}
			}
			cl.show(panel, "berechnen");
		}
	}
	private class saveAction extends AbstractAction {
		private static final long serialVersionUID = -8513272127372924276L;
		public saveAction() {
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
	private class loadAction extends AbstractAction {
		private static final long serialVersionUID = -8070002616229474706L;
		public loadAction() {
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
					int nrFlows = os.readInt();
					for (Integer i=0; i<nrFlows; i++){
						String name = os.readObject().toString();
						FlussTyp typ = (FlussTyp)os.readObject();
						FlussEinheit einheit = (FlussEinheit)os.readObject();
						allFlows.add(new Fluss(name, typ, einheit));
					}		
					allModules.clear();
					int nrMods = os.readInt();
					for (Integer i=0; i<nrMods; i++) {
						String mn = (String)os.readObject();
						allModules.put(mn, new Prozessmodul());
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
						}
					}
					allProSys.clear();
					allMNLs.clear();
					allBVs.clear();
					allVKs.clear();
					int nrSys = os.readInt();
					
					for (Integer i=0; i<nrSys; i++) {
						String name = (String)os.readObject();
						
						if (allProSys.containsKey(name) == false) {
							allProSys.put(name, new Produktsystem(name, new HashMap<Fluss, Double>(), 
									new LinkedList<Fluss>()));							
						}						
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
							} else {
								if (allProSys.containsKey(mni) == false) {
									allProSys.put(mni, new Produktsystem(mni, new HashMap<Fluss, Double>(), 
											new LinkedList<Fluss>()));							
								}	
								allProSys.get(name).addProzessmodul(allProSys.get(mni));
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
	private class aboutAction extends AbstractAction {
		private static final long serialVersionUID = 8545097902506476895L;
		public aboutAction() {
			putValue(NAME, "\u00dcber");
			putValue(SHORT_DESCRIPTION, "Info");
		}
		public void actionPerformed(ActionEvent e) {
			cl.show(panel, "leer");
		}
	}
}
