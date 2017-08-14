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
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Vector;

import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FilenameUtils;

/**
 * @author Dr.-Ing. Joachim Schwarte
 * @version 0.933
 */

public class IWBLCI {
	
	/*
	 *   Globale Variablen
	 */

	private JFrame frmIwblciVersion;
	private JPanel panel = new JPanel();
	private CardLayout cl = new CardLayout(0, 0);
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
	private final Action calculate2Action 	= new calculate2Action();
	private final Action xmlExportAction 	= new xmlExportAction();
	private final Action xmlImportAction 	= new xmlImportAction();
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
	// Panel 17; Neue Bewertungsmethode
	private JTextField txtP17n1; 	// Name der Bewertungsmethode
	private JTextField txtP17n2; 	// Name des Charakterisierungsfaktors
	// Panel 19; Neue Produktkomponente
	private JTextField txtP19n1; 	// Name der Produktkomponente
	private JTextField txtP19n2;	// Name der unquantifizierten Komponente
	private JTextField txtP19n3;	// Menge
	// Panel 21; Neue Produktkomponente
	private JTextField txtP21n1; 	// Name der Produktkomposition
	private JTextField txtP21n2;	// Name der Produktkomponente
	private JTable flowsTable 		= new JTable();
	private JTable modulesTable 	= new JTable();
	private JTable productsTable 	= new JTable();
	private JTable wksTable 		= new JTable();
	private JTable pbsTable 		= new JTable();
	private JTable cfsTable 		= new JTable();
	private JTable bmsTable 		= new JTable();
	private JTable pkentesTable 	= new JTable();
	private JTable pktionsTable 	= new JTable();
	private JTable resultsTable 	= new JTable();
	private JTable results2Table 	= new JTable();	
	private JComboBox<ObjektTyp> coboP23n1 = new JComboBox<ObjektTyp>();
	private JComboBox<String> coboP23n2 = new JComboBox<String>();
	private JComboBox<String> coboP23n3 = new JComboBox<String>();
	DefaultTableModel flowsTableModel 		= new DefaultTableModel(0,3);
	DefaultTableModel modulesTableModel 	= new DefaultTableModel(0,3);
	DefaultTableModel productsTableModel 	= new DefaultTableModel(0,3);
	DefaultTableModel wksTableModel 		= new DefaultTableModel(0,2);
	DefaultTableModel pbsTableModel 		= new DefaultTableModel(0,3);
	DefaultTableModel cfsTableModel 		= new DefaultTableModel(0,4);
	DefaultTableModel bmsTableModel 		= new DefaultTableModel(0,3);
	DefaultTableModel pkentesTableModel 	= new DefaultTableModel(0,3);
	DefaultTableModel pktionsTableModel 	= new DefaultTableModel(0,2);
	DefaultTableModel resultsTableModel 	= new DefaultTableModel(0,3);
	DefaultTableModel results2TableModel 	= new DefaultTableModel(0,3);

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
		frmIwblciVersion.setTitle("IWB-LCI   Version 0.933");
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
		JLabel lblInfo5 = new JLabel("Version 0.933   14.08.2017");
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
		JLabel lblTodo5 = new JLabel("Version 0.933   14.08.2017");
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
		
		// Panel 16
		
		JPanel panel_16 = new JPanel();
		panel.add(panel_16, "listeCFs");		
		panel_16.setLayout(new MigLayout("", "[74px,grow]", "[14px][grow]"));	
		JLabel lblListeDerCFs = new JLabel("Liste der Charakterisierungsfaktoren");
		lblListeDerCFs.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_16.add(lblListeDerCFs, "cell 0 0,alignx center,aligny top");		
		cfsTable.setModel(cfsTableModel);
		TableColumnModel tcm7 = cfsTable.getColumnModel();
		tcm7.getColumn(0).setHeaderValue("Name");
		tcm7.getColumn(1).setHeaderValue("Fluss");
		tcm7.getColumn(2).setHeaderValue("Wirkungskategorie");
		tcm7.getColumn(3).setHeaderValue("Faktor");
		panel_16.add(new JScrollPane(cfsTable), "cell 0 1,alignx center,aligny top");
		
		// Panel 17
		
		JPanel panel_17 = new JPanel();
		panel.add(panel_17, "neuBM");
		panel_17.setLayout(new MigLayout("", "[108px,grow][108px][108px][108px,grow]", 
				"[20px][20px][20px][20px][20px][20px][20px][20px][20px,grow]"));
		JLabel lblP17n2 = new JLabel("Neue Bewertungsmethode");
		lblP17n2.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_17.add(lblP17n2, "flowy,cell 1 0 2 1,alignx center,growy");
		
		JLabel lblP17n3 = new JLabel("Name der Bewertungsmethode");
		panel_17.add(lblP17n3, "cell 1 1,grow");
		
		txtP17n1 = new JTextField();
		txtP17n1.setText("");
		panel_17.add(txtP17n1, "cell 2 1,grow");
		txtP17n1.setColumns(10);
		
		JLabel lblP17n1 = new JLabel(">>> ... <<<");
		panel_17.add(lblP17n1, "cell 0 5 4 1,alignx center");
		
		JButton btnP17n1 = new JButton("neue Bewertungsmethode anlegen");
		panel_17.add(btnP17n1, "cell 1 2 2 1,alignx center");
		
		JLabel lblP17n4 = new JLabel("Name des Charakterisierungsfaktors");
		panel_17.add(lblP17n4, "cell 1 3,grow");
		
		txtP17n2 = new JTextField();
		txtP17n2.setText("");
		panel_17.add(txtP17n2, "cell 2 3,grow");
		txtP17n2.setColumns(10);
		txtP17n2.setEnabled(false);
		
		JButton btnP17n2 = new JButton("Charakterisierungsfaktor hinzuf\u00fcgen");
		btnP17n2.setEnabled(false);
		panel_17.add(btnP17n2, "cell 1 4,alignx center");
		
		JButton btnP17n3 = new JButton("fertig");
		btnP17n3.setEnabled(false);
		panel_17.add(btnP17n3, "cell 2 4,alignx center");

		cl.show(panel, "leer");
		
		// Panel 18
		
		JPanel panel_18 = new JPanel();
		panel.add(panel_18, "listeBMs");		
		panel_18.setLayout(new MigLayout("", "[74px,grow]", "[14px][grow]"));	
		JLabel lblListeDerBMs = new JLabel("Liste der Bewertungsmethoden");
		lblListeDerBMs.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_18.add(lblListeDerBMs, "cell 0 0,alignx center,aligny top");		
		bmsTable.setModel(bmsTableModel);
		TableColumnModel tcm8 = bmsTable.getColumnModel();
		tcm8.getColumn(0).setHeaderValue("Bewertungsmethode");
		tcm8.getColumn(1).setHeaderValue("Elementtyp");
		tcm8.getColumn(2).setHeaderValue("Elementname");
		panel_18.add(new JScrollPane(bmsTable), "cell 0 1,alignx center,aligny top");	
		
		// Panel 19
		
		JPanel panel_19 = new JPanel();
		panel.add(panel_19, "neuPKente");
		panel_19.setLayout(new MigLayout("", "[108px,grow][108px][108px][108px,grow]", 
				"[20px][20px][20px][20px][20px][20px][20px][20px][20px,grow]"));
		JLabel lblP19n2 = new JLabel("Neue Produktkomponente");
		lblP19n2.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_19.add(lblP19n2, "flowy,cell 1 0 2 1,alignx center,growy");
		
		JLabel lblP19n3 = new JLabel("Name der Produktkomponente");
		panel_19.add(lblP19n3, "cell 1 1,grow");
		
		txtP19n1 = new JTextField();
		txtP19n1.setText("");
		panel_19.add(txtP19n1, "cell 2 1,grow");
		txtP19n1.setColumns(10);
		
		JLabel lblP19n4 = new JLabel("Name der unquantifizierten Komponente");
		panel_19.add(lblP19n4, "cell 1 2,grow");
		
		txtP19n2 = new JTextField();
		txtP19n2.setText("");
		panel_19.add(txtP19n2, "cell 2 2,grow");
		txtP19n2.setColumns(10);
		
		JLabel lblP19n5 = new JLabel("Menge");
		panel_19.add(lblP19n5, "cell 1 3,grow");
		
		txtP19n3 = new JTextField();
		txtP19n3.setText("");
		panel_19.add(txtP19n3, "cell 2 3,grow");
		txtP19n3.setColumns(10);
		
		JButton btnP19n1 = new JButton("Produktkomponente hinzuf\u00fcgen");
		btnP19n1.setEnabled(true);
		panel_19.add(btnP19n1, "cell 1 4 2 1,alignx center");
		
		JLabel lblP19n1 = new JLabel(">>> ... <<<");
		panel_19.add(lblP19n1, "cell 0 5 5 1,alignx center");
		
		// Panel 20
		
		JPanel panel_20 = new JPanel();
		panel.add(panel_20, "listePKentes");		
		panel_20.setLayout(new MigLayout("", "[74px,grow]", "[14px][grow]"));	
		JLabel lblListeDerPKentes = new JLabel("Liste der Produktkomponenten");
		lblListeDerPKentes.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_20.add(lblListeDerPKentes, "cell 0 0,alignx center,aligny top");		
		pkentesTable.setModel(pkentesTableModel);
		TableColumnModel tcm9 = pkentesTable.getColumnModel();
		tcm9.getColumn(0).setHeaderValue("Produktkomponente");
		tcm9.getColumn(1).setHeaderValue("unquantifizierte Komp.");
		tcm9.getColumn(2).setHeaderValue("Menge");
		panel_20.add(new JScrollPane(pkentesTable), "cell 0 1,alignx center,aligny top");
		
		// Panel 21
		
		JPanel panel_21 = new JPanel();
		panel.add(panel_21, "neuPKtion");
		panel_21.setLayout(new MigLayout("", "[108px,grow][108px][108px][108px,grow]", 
				"[20px][21px][20px][20px][20px][20px][20px][20px][20px,grow]"));
		JLabel lblP21n2 = new JLabel("Neue Produktkomposition");
		lblP21n2.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_21.add(lblP21n2, "flowy,cell 1 0 2 1,alignx center,growy");
		
		JLabel lblP21n3 = new JLabel("Name der neuen Produktkomposition");
		panel_21.add(lblP21n3, "cell 1 1,grow");
		
		txtP21n1 = new JTextField();
		txtP21n1.setText("");
		panel_21.add(txtP21n1, "cell 2 1,grow");
		txtP21n1.setColumns(10);
		
		JButton btnP21n1 = new JButton("Produktkomposition anlegen");
		btnP21n1.setEnabled(true);
		panel_21.add(btnP21n1, "cell 1 2 2 1,alignx center");
		
		JLabel lblP21n4 = new JLabel("Name der hinzuzufügenden Produktkomponente");
		panel_21.add(lblP21n4, "cell 1 3,grow");
		
		txtP21n2 = new JTextField();
		txtP21n2.setText("");
		panel_21.add(txtP21n2, "cell 2 3,grow");
		txtP21n2.setColumns(10);
		txtP21n2.setEnabled(false);
		
		JButton btnP21n2 = new JButton("Produktkomponente hinzufügen");
		btnP21n2.setEnabled(false);
		panel_21.add(btnP21n2, "cell 1 4,alignx center");
		
		JButton btnP21n3 = new JButton("fertig");
		btnP21n3.setEnabled(false);
		panel_21.add(btnP21n3, "cell 2 4,alignx center");
		
		JLabel lblP21n1 = new JLabel(">>> ... <<<");
		panel_21.add(lblP21n1, "cell 0 5 5 1,alignx center");
		
		// Panel 22
		
		JPanel panel_22 = new JPanel();
		panel.add(panel_22, "listePKtions");		
		panel_22.setLayout(new MigLayout("", "[74px,grow]", "[14px][grow]"));	
		JLabel lblListeDerPKtions = new JLabel("Liste der Produktkomponsitionen");
		lblListeDerPKtions.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_22.add(lblListeDerPKtions, "cell 0 0,alignx center,aligny top");		
		pktionsTable.setModel(pktionsTableModel);
		TableColumnModel tcm10 = pktionsTable.getColumnModel();
		tcm10.getColumn(0).setHeaderValue("Produktkomposition");
		tcm10.getColumn(1).setHeaderValue("Produktkomponente");
		panel_22.add(new JScrollPane(pktionsTable), "cell 0 1,alignx center,aligny top");
		
		// Panel 23
		
		JPanel panel_23 = new JPanel();
		panel.add(panel_23, "berechnen2");		
		panel_23.setLayout(new MigLayout("", "[108px,grow][108px][108px][108px,grow]", 
				"[20px][20px][20px][20px][20px][20px][20px][20px][20px,grow]"));	
		JLabel lblWirkung = new JLabel("Wirkungsabsch\u00e4tzung");
		lblWirkung.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_23.add(lblWirkung, "cell 1 0 2 1,alignx center,aligny top");
		
		JLabel lblP23n1 = new JLabel("Objekt-Typ");
		panel_23.add(lblP23n1, "cell 1 1,grow");		
		
		coboP23n1.setModel(new DefaultComboBoxModel<ObjektTyp>(ObjektTyp.values()));
		panel_23.add(coboP23n1, "cell 2 1,grow");
		
		JLabel lblP23n2 = new JLabel("Objekt-Name");
		panel_23.add(lblP23n2, "cell 1 2,grow");
		
		panel_23.add(coboP23n2, "cell 2 2,grow");
		coboP23n2.setEnabled(false);
		
		JLabel lblP23n3 = new JLabel("Bewertungsmethode");
		panel_23.add(lblP23n3, "cell 1 3,grow");
		
		panel_23.add(coboP23n3, "cell 2 3,grow");
		coboP23n3.setEnabled(false);
		
		JButton btnP23n1 = new JButton("Berechnungsergebnisse anzeigen");
		btnP23n1.setEnabled(false);
		panel_23.add(btnP23n1, "cell 1 4 2 0,alignx center");
		
		results2Table.setModel(results2TableModel);
		TableColumnModel tcm11 = results2Table.getColumnModel();
		tcm11.getColumn(0).setHeaderValue("Wirkungskategorie");
		tcm11.getColumn(1).setHeaderValue("Wert");
		tcm11.getColumn(2).setHeaderValue("Wirkungsindikator");
		panel_23.add(new JScrollPane(results2Table), "cell 0 5 4 10,alignx center,aligny top");
	
		
		/*
		 * Organisation der Menuleiste
		 */
		
		JMenuBar menuBar = new JMenuBar();
		frmIwblciVersion.setJMenuBar(menuBar);
		
		JMenu mnDatei = new JMenu("Datei");
		menuBar.add(mnDatei);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem();
		mntmNewMenuItem_3.setAction(xmlExportAction);
		mnDatei.add(mntmNewMenuItem_3);	
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem();
		mntmNewMenuItem_4.setAction(xmlImportAction);
		mnDatei.add(mntmNewMenuItem_4);
		
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
		
		JMenuItem mntmLci = new JMenuItem();
		mntmLci.setAction(calculateAction);
		mnBerechnen.add(mntmLci);
		
		JMenuItem mntmWirk = new JMenuItem();
		mntmWirk.setAction(calculate2Action);
		mnBerechnen.add(mntmWirk);
		
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
		
		btnSpeichern.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String name = txtName.getText();	
				FlussTyp typ = comboBox.getItemAt(comboBox.getSelectedIndex());
				FlussEinheit einheit = comboBox_1.getItemAt(comboBox_1.getSelectedIndex());
				if (name.equals("")) {
					lblStatusmeldung.setText(">>> Es wurde kein Name angegeben. <<<");
				} else {
					if (Fluss.containsName(name)) {
						lblStatusmeldung.setText(">>> Der angegebene Name ist bereits vorhanden. <<<");
					} else {
						Fluss.instance(name, typ, einheit);
						lblStatusmeldung.setText(">>> Anzahl Flussobjekte: " + Fluss.getAllNames().size() + " <<<");
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
		
		btnSpei2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String name = txtModName.getText();	
				if (name.equals("")) {
					lblStatus2.setText(">>> Es wurde kein Name angegeben. <<<");
				} else {
					if (NameCheck.containsFVName(name)) {
						lblStatus2.setText(">>> Der angegebene Name ist bereits vorhanden. <<<");
					} else {
						Prozessmodul.instance(name);
						lblStatus2.setText(">>> Anzahl Prozessmodule: " + Prozessmodul.getAllInstances().size() + " <<<");
						btnSpei2.setEnabled(false);
						txtModName.setEnabled(false);
						btnAddFluss.setEnabled(true);
						txtFlussName.setEnabled(true);
						txtMenge.setEnabled(true);
					}	
				} 		
			}
		});
		
		btnAddFluss.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
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
					if (Fluss.containsName(fname)) {
						Fluss akFluss = Fluss.getInstance(fname);
						String mname = txtModName.getText();
						Prozessmodul.getInstance(mname).addFluss(akFluss, menge);
						txtFlussName.setText("");
						txtMenge.setText("");
						btnFertig.setEnabled(true);
						int anzPFluss = Prozessmodul.getInstance(mname).getProduktflussvektor().size();
						int anzEFluss = Prozessmodul.getInstance(mname).getElementarflussvektor().size();
						int anzGesamt = anzPFluss + anzEFluss;
						lblStatus2.setText(">>> Prozessmodul " + mname + " besitzt " +
								anzGesamt + " Fl\u00fcsse <<<");
						
					} else {
						lblStatus2.setText(">>> unbekannter Flussname <<<");
					}					
				}
			}
		});
		
		btnFertig.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
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
		
		btnSpei3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String name = txtPSName.getText();	
				if (name.equals("")) {
					lblStatus3.setText(">>> Es wurde kein Name angegeben. <<<");
				} else {
					boolean nameVorhanden = false;
					
					for(String mod : Prozessmodul.getAllInstances().keySet()) {
						if (name.equals(mod)) {
							nameVorhanden = true;
						}
					}
					for(String mod : Produktsystem.getAllInstances().keySet()) {
						if (name.equals(mod)) {
							nameVorhanden = true;
						}
					}
					if (nameVorhanden == true) {
						lblStatus3.setText(">>> Der angegebene Name ist bereits vorhanden. <<<");
					} else {
						Produktsystem.instance(name, new HashMap<Fluss, Double>(), 
								new LinkedList<Fluss>());
						lblStatus3.setText(">>> Anzahl Produktsysteme: " + Produktsystem.getAllInstances().size() + " <<<");

						btnSpei3.setEnabled(false);
						txtPSName.setEnabled(false);
						btnAddMod.setEnabled(true);
						txtModName2.setEnabled(true);
					}	
				} 		
			}
		});
		
		btnAddMod.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
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
					for(String modn2 : Prozessmodul.getAllInstances().keySet()) {
						if (modname.equals(modn2)) {
							nameVorhanden = true;
							typmod = true;
						}
					}
					if (nameVorhanden == false) {
						for(String modn3 : Produktsystem.getAllInstances().keySet()) {
							if (modname.equals(modn3)) {
								nameVorhanden = true;
								typmod = false;
							}
						}
					}
					if (nameVorhanden == true) {
						if (typmod == true){
							Produktsystem.getAllInstances().get(txtPSName.getText()).addProzessmodul(Prozessmodul.getInstance(modname));
						} else {
							Produktsystem.getAllInstances().get(txtPSName.getText()).addProzessmodul(Produktsystem.getAllInstances().get(modname));
						}
						lblStatus3.setText(">>> Produktsystem " + txtPSName.getText() +
								" besteht aus " + Produktsystem.getAllInstances().get(txtPSName.getText()).getModulAnzahl() 
								+ " Elementen <<<");
						txtModName2.setText("");
						btnWeiter.setEnabled(true);
					} else {
						lblStatus3.setText(">>> Name ist weder Prozessmodul noch Produktsystem <<<");
					}					
				}
			}
		});
		
		btnWeiter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
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
		
		btnAddBed.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
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
					if (Fluss.containsName(fname)) {
						Fluss akFluss = Fluss.getInstance(fname);
						Produktsystem.getInstance(txtPSName.getText()).addBedarf(akFluss, Double.parseDouble(txtBVMenge.getText()));
						lblStatus3.setText(">>> Der Bedarfsvektor enth\u00e4lt " + 
								Produktsystem.getInstance(txtPSName.getText()).getBedarfsvektor().size() + " Fl\u00dcsse <<<");
						btnWei2.setEnabled(true);	
						txtBV.setText("");
						txtBVMenge.setText("");
					} else {
						lblStatus3.setText(">>> unbekannter Flussname <<<");
					}					
				}
			}
		});
		
		btnWei2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
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
		
		btnAddVK.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String vkname = txtVKName.getText();
				if (vkname.equals("")) {
					lblStatus3.setText(">>> unvollst\u00e4ndige Eingabe <<<");
				} else {					
					if (Fluss.containsName(vkname)) {
						Fluss akFluss = Fluss.getInstance(vkname);
						Produktsystem.getInstance(txtPSName.getText()).addVuK(akFluss);
						txtVKName.setText("");
						lblStatus3.setText(">>> Der VK-Vektor enth\u00e4lt " + 
								Produktsystem.getInstance(txtPSName.getText()).getVorUndKoppelprodukte().size() + " Fl\u00fcsse <<<");										
					} else {
						lblStatus3.setText(">>> unbekannter Flussname <<<");
					}					
				}
			}
		});

		btnFertig2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
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
		
		btnSpeiWK.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String name = txtNameWK.getText();	
				Wirkungsindikator wi = comboBoxWK.getItemAt(comboBoxWK.getSelectedIndex());
				if (name.equals("")) {
					lblStatusWK.setText(">>> Es wurde kein Name angegeben. <<<");
				} else {
					if (Wirkungskategorie.containsName(name)) {
						lblStatusWK.setText(">>> Der angegebene Name ist bereits vorhanden. <<<");
					} else {
						Wirkungskategorie.instance(name, wi);
						lblStatusWK.setText(">>> Anzahl Wirkungskategorien: " + Wirkungskategorie.getAllInstances().size() + " <<<");
						txtNameWK.setText("");
						comboBoxWK.setSelectedIndex(0);
					}	
				} 		
			}
		});
		
		/*
		 * neue Produktdeklaration (= neues ProduktBilanziert-Objekt)
		 */

		btnP12n1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String name = txtP12n1.getText();	
				if (name.equals("")) {
					lblP12n1.setText(">>> Es wurde kein Name angegeben. <<<");
				} else {
					if (NameCheck.containsWVName(name)) {
						lblP12n1.setText(">>> Der angegebene Name ist bereits vorhanden. <<<");
					} else {
						String bwName = txtP12n4.getText();	
						boolean bwNew = chbP12n1.isSelected();
						if (Bewertungsmethode.containsName(bwName) == false) {
							lblP12n1.setText(">>> Die Bewertungsmethode ist unbekannt. <<<");
							if (bwNew == true) {
								Bewertungsmethode bwNeu = Bewertungsmethode.instance(bwName);
								ProduktBilanziert.instance(name);
								ProduktBilanziert.getAllInstances().get(name).setBM(bwNeu);
								lblP12n1.setText(">>> Anzahl Produktdeklarationen: " + ProduktBilanziert.getAllInstances().size() + " <<<");
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
							ProduktBilanziert.instance(name);
							ProduktBilanziert.getAllInstances().get(name).setBM(Bewertungsmethode.instance(bwName));
							lblP12n1.setText(">>> Anzahl Produktdeklarationen: " + ProduktBilanziert.getAllInstances().size() + " <<<");
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
		
		btnP12n2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
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
					if (Wirkungskategorie.containsName(fname)) {
						Wirkungskategorie wk2 = Wirkungskategorie.getAllInstances().get(fname);
						String mname = txtP12n1.getText();
						String bmName = txtP12n4.getText();
						if (wkNew == true) {
							Bewertungsmethode.instance(bmName).addWK(wk2);
						}
						if (Bewertungsmethode.instance(bmName).kategorieListe().keySet().contains(wk2.getName())) {
							ProduktBilanziert.getAllInstances().get(mname).addWirkung(wk2, menge);
							txtP12n2.setText("");
							txtP12n3.setText("");
							btnP12n3.setEnabled(true);
							int anzPWKs = ProduktBilanziert.getAllInstances().get(mname).getWirkungsvektor(Bewertungsmethode.instance(bmName)).size();					
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
		
		btnP12n3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
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
		 * neuer Charakterisierungsfaktor (= neues CharakterFaktor-Objekt)
		 */		
		
		btnP15n1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String cfName = txtP15n1.getText();
				String flName = txtP15n2.getText();
				String wkName = txtP15n3.getText();
				String fakStr = txtP15n4.getText();
				Double faktor = 0.0;
				Boolean faktorZahl = true;
				try {
						faktor = Double.parseDouble(fakStr);
					} catch (NumberFormatException e){
						faktorZahl = false;
				}
				if (CharakterFaktor.containsName(cfName) == false &&
						cfName.equals("") == false &&
						Fluss.containsName(flName) == true &&
						Wirkungskategorie.containsName(wkName) == true &&
						faktorZahl == true) {
					CharakterFaktor.instance(cfName, 
							Fluss.getInstance(flName), Wirkungskategorie.getAllInstances().get(wkName) , faktor);
					txtP15n1.setText("");
					txtP15n2.setText("");
					txtP15n3.setText("");
					txtP15n4.setText("");
					lblP15n1.setText(">>> Anzahl Charakterisierungfaktoren: "
							+ CharakterFaktor.getAllInstances().size() + " <<<");					
				} else {
					if (faktorZahl == false) {
						lblP15n1.setText(">>> Es wurde kein Zahlenwert angegeben <<<"); 
					}
					if (Wirkungskategorie.containsName(wkName) == false && wkName.equals("") == false) {
						lblP15n1.setText(">>> Die Wirkungskategorie ist unbekannt <<<"); 
					}
					if (Fluss.containsName(flName) == false && flName.equals("") == false) {
						lblP15n1.setText(">>> Der Fluss ist unbekannt <<<"); 
					}
					if (CharakterFaktor.containsName(cfName) == true) {
						lblP15n1.setText(">>> Der Name des Charakterisierungfaktors existiert bereits <<<"); 
					}
					if (cfName.equals("") || wkName.equals("") || flName.equals("") || fakStr.equals("")) {
						lblP15n1.setText(">>> Unvollst\u00e4ndige Eingabe <<<");
					}
				}				
			}
		});
		
		/*
		 * neue Bewertungsmethode
		 */		
		
		btnP17n1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String bmName = txtP17n1.getText();
				if (Bewertungsmethode.containsName(bmName) == false &&
						(bmName.equals("") == false)) {
					Bewertungsmethode.instance(bmName);	
					txtP17n1.setEnabled(false);
					btnP17n1.setEnabled(false);
					btnP17n2.setEnabled(true);
					txtP17n2.setEnabled(true);
					lblP17n1.setText(">>> Anzahl Bewertungsmethoden: "
							+ Bewertungsmethode.getAllBWs().size() + " <<<");
				} else {
					if (bmName.equals("")) {
						lblP17n1.setText(">>> Es wurde kein Name angegeben <<<"); 						
					} else {
						lblP17n1.setText(">>> Der angegebene Name ist bereits vorhanden <<<");
					}
				}
			}
		});
		
		btnP17n2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String bmName = txtP17n1.getText();
				String cfName = txtP17n2.getText();
				if (Bewertungsmethode.instance(bmName).getFaktorSet().containsKey(cfName) == false &&
						cfName.equals("") == false &&
						CharakterFaktor.getAllInstances().containsKey(cfName)) {
					Bewertungsmethode.instance(bmName).addFaktor(CharakterFaktor.getAllInstances().get(cfName));	
					btnP17n3.setEnabled(true);
					txtP17n2.setText("");
					lblP17n1.setText(">>> Diese Methode enthält "
							+ Bewertungsmethode.instance(bmName).getFaktorSet().size() 
							+ " Faktoren die " 
							+ Bewertungsmethode.instance(bmName).kategorieListe().size()
							+ " Kategorien betreffen <<<");
				} else {
					if (Bewertungsmethode.instance(bmName).getFaktorSet().containsKey(cfName) == true) {
						lblP17n1.setText(">>> Der angegebene Charakterisierungsfaktor ist bereits vorhanden <<<");
					}
					if (CharakterFaktor.getAllInstances().containsKey(cfName) == false) {
						lblP17n1.setText(">>> Den angegebene Charakterisierungsfaktor gibt es nicht <<<");
					}
					if (cfName.equals("")) {
						lblP17n1.setText(">>> Es wurde kein Name angegeben <<<"); 						
					} 
				}
			}
		});
		
		btnP17n3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				lblP17n1.setText(">>> ... <<<");
				txtP17n1.setText("");
				txtP17n2.setText("");
				txtP17n1.setEnabled(true);
				txtP17n2.setEnabled(false);
				btnP17n1.setEnabled(true);
				btnP17n2.setEnabled(false);
				btnP17n3.setEnabled(false);
			
			}
		});
		
		/*
		 * neue Produktkomponente
		 */		
		
		btnP19n1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String pkName = txtP19n1.getText();
				String koName = txtP19n2.getText();
				String menStr = txtP19n3.getText();
				Double menge = 0.0;
				Boolean mengeZahl = true;
				try {
						menge = Double.parseDouble(menStr);
					} catch (NumberFormatException e){
						mengeZahl = false;
				}
				if (NameCheck.containsWVName(pkName) == false &&
						pkName.equals("") == false &&
						NameCheck.containsWVName(koName) == true &&
						mengeZahl == true) {
					Wirkungsvektor kompo = Prozessmodul.instance("dummy");
					if (Prozessmodul.containsName(koName)) {
						kompo = Prozessmodul.getInstance(koName);					
					}
					Prozessmodul.removeInstance("dummy");
					if (Produktsystem.containsName(koName)) {
						kompo = Produktsystem.getInstance(koName);					
					}
					if (ProduktBilanziert.containsName(koName)) {
						kompo = ProduktBilanziert.getInstance(koName);					
					}
					if (Produktkomponente.containsName(koName)) {
						kompo = Produktkomponente.get(koName);					
					}
					if (Produktkomposition.containsName(koName)) {
						kompo = Produktkomposition.getInstance(koName);					
					}				
					Produktkomponente.newInstance(pkName, kompo, menge);
					txtP19n1.setText("");
					txtP19n2.setText("");
					txtP19n3.setText("");	
					lblP19n1.setText(">>> Anzahl Produktkomponenten: "
							+ Produktkomponente.getAllInstances().size() + " <<<");
				} else {
					if (mengeZahl == false) {
						lblP19n1.setText(">>> Es wurde kein Zahlenwert angegeben <<<"); 
					}
					if (NameCheck.containsWVName(koName) == false) {
						lblP19n1.setText(">>> Die unquantifizierte Komponente existiert nicht <<<");
					}
					if (NameCheck.containsWVName(pkName) == true) {
						lblP19n1.setText(">>> Die Produktkomponente existiert bereits <<<");
					}
					if (pkName.equals("") || koName.equals("") || menStr.equals("")) {
						lblP19n1.setText(">>> Unvollst\u00e4ndige Eingabe <<<");
					}
				}				
			}
		});
		
		/*
		 * neue Produktkomposition
		 */		
		
		btnP21n1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String PKtionName = txtP21n1.getText();
				if (NameCheck.containsWVName(PKtionName) == false &&
						PKtionName.equals("") == false) {
					Produktkomposition.instance(PKtionName);	
					txtP21n1.setEnabled(false);
					txtP21n2.setEnabled(true);
					btnP21n1.setEnabled(false);
					btnP21n2.setEnabled(true);
					lblP21n1.setText(">>> Anzahl Produktkompositionen: " +
							Produktkomposition.getAllInstances().size() +
							" <<<");				 
				} else {
					if (NameCheck.containsWVName(PKtionName) == true) {
						lblP21n1.setText(">>> Der angegebene Name ist bereits vergeben <<<");
					}
					if (PKtionName.equals("")) {
						lblP21n1.setText(">>> Es wurde kein Name angegeben <<<");
					}
				}
			}

		});
		
		btnP21n2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String PKtionName = txtP21n1.getText();
				String PKenteName = txtP21n2.getText();
				if (NameCheck.containsWVName(PKenteName) == true) {
					Wirkungsvektor kompo = Prozessmodul.instance("dummy");
					if (Prozessmodul.containsName(PKenteName)) {
						kompo = Prozessmodul.getInstance(PKenteName);					
					}
					Prozessmodul.removeInstance("dummy");
					if (Produktsystem.containsName(PKenteName)) {
						kompo = Produktsystem.getInstance(PKenteName);					
					}
					if (ProduktBilanziert.containsName(PKenteName)) {
						kompo = ProduktBilanziert.getInstance(PKenteName);					
					}
					if (Produktkomponente.containsName(PKenteName)) {
						kompo = Produktkomponente.get(PKenteName);					
					}
					if (Produktkomposition.containsName(PKenteName)) {
						kompo = Produktkomposition.getInstance(PKenteName);					
					}
					Produktkomposition.instance(PKtionName).addKomponente(kompo);
					int koAnz = Produktkomposition.instance(PKtionName).getKompAnz();
					lblP21n1.setText(">>> Die Produktkomposition besitzt " +
							koAnz + " Komponenten <<<");
					btnP21n3.setEnabled(true);	
					txtP21n2.setText("");
				} else {
					if (NameCheck.containsWVName(PKenteName) == false) {
						lblP21n1.setText(">>> Die Komponente ist unbekannt <<<");
					}
					if (PKenteName.equals(""))
						lblP21n1.setText(">>> Es wurde kein Name angegeben <<<");
				}			
			}
		});
		
		btnP21n3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				lblP21n1.setText(">>> ... <<<");
				txtP21n1.setText("");
				txtP21n2.setText("");
				txtP21n1.setEnabled(true);
				txtP21n2.setEnabled(false);
				btnP21n1.setEnabled(true);
				btnP21n2.setEnabled(false);
				btnP21n3.setEnabled(false);
			
			}
		});
	
		/*
		 * Prozessmodul editieren
		 */
	
		btnEditModul.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String name = txtModName3.getText();	
				if (name.equals("")) {
					lblStatus4.setText(">>> Es wurde kein Name angegeben. <<<");
				} else {
					boolean nameModules = false;			
					
					for(String mod : Prozessmodul.getAllInstances().keySet()) {
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
		
		btnEditFluss.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
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
					if (Fluss.containsName(fname)) {
						Fluss fo = Fluss.getInstance(fname);
						Boolean nameInModul = false;
						String mname = txtModName3.getText();
						if (Prozessmodul.getInstance(mname).getElementarflussvektor().
								containsKey(fo)){
							nameInModul = true;
						}
						if (Prozessmodul.getInstance(mname).getProduktflussvektor().
								containsKey(fo)){
							nameInModul = true;
						}
						if (nameInModul==true) {
							if (menge == 0.0) {
								Prozessmodul.getInstance(mname).removeFluss(fo);
								lblStatus4.setText(">>> Der angegebene Fluss wurde aus dem Modul gel\u00f6scht. <<<");
							} else {
								Prozessmodul.getInstance(mname).removeFluss(fo);
								Prozessmodul.getInstance(mname).addFluss(fo, menge);
								lblStatus4.setText(">>> Die Mengenangabe wurde ge\u00e4ndert. <<<");
							}
						} else {
							if (menge == 0.0) {
								lblStatus4.setText(">>> Mengenangabe fehlt. <<<");
							} else {
								Prozessmodul.getInstance(mname).addFluss(fo, menge);
								lblStatus4.setText(">>> Der Fluss wurde hinzugef\u00dcgt. <<<");								
							}							
						}				
					} else {
						lblStatus4.setText(">>> unbekannter Flussname <<<");
					}					
				}
			}
		});
		
		btnFertig3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
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
		
		/*
		 * Wirkungsabschätzung
		 */
		
		coboP23n1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coboP23n2.setEnabled(true);
				coboP23n3.setEnabled(false);
				results2TableModel.setRowCount(0);
				if (coboP23n1.getSelectedItem().toString().equals("Prozessmodul")) {
					Vector<String> nameVektor = new Vector<String>();
					for (String obName : Prozessmodul.getAllInstances().keySet()) {
						nameVektor.addElement(obName);
					}
					coboP23n2.setModel(new DefaultComboBoxModel<String>(nameVektor));
				}
				if (coboP23n1.getSelectedItem().toString().equals("Produktsystem")) {
					Vector<String> nameVektor = new Vector<String>();
					for (String obName : Produktsystem.getAllInstances().keySet()) {
						nameVektor.addElement(obName);
					}
					coboP23n2.setModel(new DefaultComboBoxModel<String>(nameVektor));
				}
				if (coboP23n1.getSelectedItem().toString().equals("Produktdeklaration")) {
					Vector<String> nameVektor = new Vector<String>();
					for (String obName : ProduktBilanziert.getAllInstances().keySet()) {
						nameVektor.addElement(obName);
					}
					coboP23n2.setModel(new DefaultComboBoxModel<String>(nameVektor));
				}
				if (coboP23n1.getSelectedItem().toString().equals("Produktkomponente")) {
					Vector<String> nameVektor = new Vector<String>();
					for (String obName : Produktkomponente.getAllInstances().keySet()) {
						nameVektor.addElement(obName);
					}
					coboP23n2.setModel(new DefaultComboBoxModel<String>(nameVektor));
				}
				if (coboP23n1.getSelectedItem().toString().equals("Produktkomposition")) {
					Vector<String> nameVektor = new Vector<String>();
					for (String obName : Produktkomposition.getAllInstances().keySet()) {
						nameVektor.addElement(obName);
					}
					coboP23n2.setModel(new DefaultComboBoxModel<String>(nameVektor));
				}				
			}		
		});
		coboP23n2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Vector<String> methVektor = new Vector<String>();
				for (String methName : Bewertungsmethode.getAllBWs().keySet()) {
					methVektor.addElement(methName);
				}
				coboP23n3.setModel(new DefaultComboBoxModel<String>(methVektor));
				coboP23n3.setEnabled(true);
			}
		});
		coboP23n3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnP23n1.setEnabled(true);
			}
		});
		btnP23n1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				coboP23n2.setEnabled(false);
				coboP23n3.setEnabled(false);
				btnP23n1.setEnabled(false);
				if (coboP23n1.getSelectedItem().toString().equals("Prozessmodul")) {
					Prozessmodul akObj = Prozessmodul.getInstance(coboP23n2.getSelectedItem().toString());
					Bewertungsmethode akMeth = Bewertungsmethode.instance(coboP23n3.getSelectedItem().toString());
					for (Wirkungskategorie wName : akObj.getWirkungsvektor(akMeth).keySet()) {
						results2TableModel.addRow(new Object[] {wName.getName(), 
								akObj.getWirkungsvektor(akMeth).get(wName), 
								wName.getEinheit().toString()});
					}
				}
				if (coboP23n1.getSelectedItem().toString().equals("Produktsystem")) {
					Produktsystem akObj = Produktsystem.getInstance(coboP23n2.getSelectedItem().toString());
					Bewertungsmethode akMeth = Bewertungsmethode.instance(coboP23n3.getSelectedItem().toString());
					for (Wirkungskategorie wName : akObj.getWirkungsvektor(akMeth).keySet()) {
						results2TableModel.addRow(new Object[] {wName.getName(), 
								akObj.getWirkungsvektor(akMeth).get(wName), 
								wName.getEinheit().toString()});
					}
				}
				if (coboP23n1.getSelectedItem().toString().equals("Produktdeklaration")) {
					ProduktBilanziert akObj = ProduktBilanziert.getInstance(coboP23n2.getSelectedItem().toString());
					Bewertungsmethode akMeth = Bewertungsmethode.instance(coboP23n3.getSelectedItem().toString());
					for (Wirkungskategorie wName : akObj.getWirkungsvektor(akMeth).keySet()) {
						results2TableModel.addRow(new Object[] {wName.getName(), 
								akObj.getWirkungsvektor(akMeth).get(wName), 
								wName.getEinheit().toString()});
					}
				}
				if (coboP23n1.getSelectedItem().toString().equals("Produktkomponente")) {
					Produktkomponente akObj = Produktkomponente.getInstance(coboP23n2.getSelectedItem().toString());
					Bewertungsmethode akMeth = Bewertungsmethode.instance(coboP23n3.getSelectedItem().toString());
					for (Wirkungskategorie wName : akObj.getWirkungsvektor(akMeth).keySet()) {
						results2TableModel.addRow(new Object[] {wName.getName(), 
								akObj.getWirkungsvektor(akMeth).get(wName), 
								wName.getEinheit().toString()});
					}
				}
				if (coboP23n1.getSelectedItem().toString().equals("Produktkomposition")) {
					Produktkomposition akObj = Produktkomposition.getInstance(coboP23n2.getSelectedItem().toString());
					Bewertungsmethode akMeth = Bewertungsmethode.instance(coboP23n3.getSelectedItem().toString());
					for (Wirkungskategorie wName : akObj.getWirkungsvektor(akMeth).keySet()) {
						results2TableModel.addRow(new Object[] {wName.getName(), 
								akObj.getWirkungsvektor(akMeth).get(wName), 
								wName.getEinheit().toString()});
					}
				}
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
			cl.show(panel, "neuBM");
		}
	}
	private class newPKenteAction extends AbstractAction {
		private static final long serialVersionUID = -7489938933445684497L;
		public newPKenteAction() {
			putValue(NAME, "Produktkomponente");
			putValue(SHORT_DESCRIPTION, "neue Produktkomponente erfassen");
		}
		public void actionPerformed(ActionEvent e) {
			cl.show(panel, "neuPKente");
		}
	}
	private class newPKtionAction extends AbstractAction {
		private static final long serialVersionUID = -7489938933445684497L;
		public newPKtionAction() {
			putValue(NAME, "Produktkomposition");
			putValue(SHORT_DESCRIPTION, "neue Produktkomposition erfassen");
		}
		public void actionPerformed(ActionEvent e) {
			cl.show(panel, "neuPKtion");
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
			for(String flussname : Fluss.getAllInstances().keySet()) {
				Fluss fluss = Fluss.getInstance(flussname);
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
			for(String mn : Prozessmodul.getAllInstances().keySet()) {
				Prozessmodul akModul = Prozessmodul.getInstance(mn);
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
			for(String psn : Produktsystem.getAllInstances().keySet()) {
				productsTableModel.addRow(new Object[] {psn, "", ""});
				for (Flussvektoren mnif : Produktsystem.getInstance(psn).getModulliste()){
					String mni = mnif.getName();
					boolean typmod = false;
					for(String modn2 : Prozessmodul.getAllInstances().keySet()) {
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
				for (Fluss bvf : Produktsystem.getInstance(psn).getBedarfsvektor().keySet()) {
					productsTableModel.addRow(new Object[] {"" ,"Bedarf" 
							,"" + bvf.getName() + " (" + 
							Produktsystem.getInstance(psn).getBedarfsvektor().get(bvf) + 
							" " + bvf.getEinheit()+")"});
				}
				for (Fluss vk : Produktsystem.getInstance(psn).getVorUndKoppelprodukte()) {
					productsTableModel.addRow(new Object[] {"" ,"Vor- oder Koppelpr." 
							,vk.getName() });		
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
			for(String wkName : Wirkungskategorie.getAllInstances().keySet()) {
				wksTableModel.addRow(new Object[] {Wirkungskategorie.getAllInstances().get(wkName).getName(), 
						Wirkungskategorie.getAllInstances().get(wkName).getEinheit()});
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
			for(String mn : ProduktBilanziert.getAllInstances().keySet()) {
				ProduktBilanziert akPB = ProduktBilanziert.getAllInstances().get(mn);
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
			cfsTableModel.setRowCount(0);
			for (String cf : CharakterFaktor.getAllInstances().keySet()) {
				CharakterFaktor akcf = CharakterFaktor.getAllInstances().get(cf);
				cfsTableModel.addRow(new Object[] {akcf.getName(), akcf.getFluss().getName(),
						akcf.getWirkung().getName(), akcf.getWert()});
			}
			cl.show(panel, "listeCFs");
		}
	}
	private class listBMsAction extends AbstractAction {
		private static final long serialVersionUID = 3929527112031439132L;
		public listBMsAction() {
			putValue(NAME, "Bewertungsmethoden");
			putValue(SHORT_DESCRIPTION, "Liste aller Bewertungsmethoden");
		}
		public void actionPerformed(ActionEvent e) {
			bmsTableModel.setRowCount(0);
			for (String bmName : Bewertungsmethode.getAllBWs().keySet()) {
				bmsTableModel.addRow(new Object[] {bmName, "", ""});
				for (String katName : Bewertungsmethode.instance(bmName).kategorieListe().keySet()) {
					bmsTableModel.addRow(new Object[] {"", "Wirkungskategorie", katName});
				}
				for (String cfName : Bewertungsmethode.instance(bmName).getFaktorSet().keySet()) {
					bmsTableModel.addRow(new Object[] {"", "Charakterisierungsfaktor", cfName});
				}
			}		
			cl.show(panel, "listeBMs");
		}
	}
	private class listPKentesAction extends AbstractAction {
		private static final long serialVersionUID = 3929527112031439132L;
		public listPKentesAction() {
			putValue(NAME, "Produktkomponenten");
			putValue(SHORT_DESCRIPTION, "Liste aller Produktkomponenten");
		}
		public void actionPerformed(ActionEvent e) {
			pkentesTableModel.setRowCount(0);
			for (String pkenteName : Produktkomponente.getAllInstances().keySet()) {
				String pkunquName = Produktkomponente.getInstance(pkenteName).getKomponente().getName();
				double menge = Produktkomponente.getInstance(pkenteName).getMenge();
				pkentesTableModel.addRow(new Object[] {pkenteName, pkunquName, menge});
			}
			cl.show(panel, "listePKentes");
		}
	}
	private class listPKtionsAction extends AbstractAction {
		private static final long serialVersionUID = 3929527112031439132L;
		public listPKtionsAction() {
			putValue(NAME, "Produktkompositionen");
			putValue(SHORT_DESCRIPTION, "Liste aller Produktkompositionen");
		}
		public void actionPerformed(ActionEvent e) {
			pktionsTableModel.setRowCount(0);
			for (String pktionName : Produktkomposition.getAllInstances().keySet()) {
				pktionsTableModel.addRow(new Object[] {pktionName, ""});
				for (Wirkungsvektor wv : Produktkomposition.instance(pktionName).getZusammensetzung()) {
					pktionsTableModel.addRow(new Object[] {"", wv.getName()});
				}
			}
			cl.show(panel, "listePKtions");
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
			if (Produktsystem.getAllInstances().size() > 0) {
				for(String sysName : Produktsystem.getAllInstances().keySet()) {
					resultsTableModel.addRow(new Object[] {sysName,"",""});
					Produktsystem sysAktuell = Produktsystem.getAllInstances().get(sysName);
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
	
	private class calculate2Action extends AbstractAction {
		private static final long serialVersionUID = 7449057427765901652L;
		public calculate2Action() {
			putValue(NAME, "Wirkungsabsch\u00e4tzung berechnen");
			putValue(SHORT_DESCRIPTION, "Wirkungsabsch\u00e4tzung f\u00fcr einzelne Objekte");
		}
		public void actionPerformed(ActionEvent e) {
			cl.show(panel, "berechnen2");
			coboP23n2.setEnabled(false);
			coboP23n3.setEnabled(false);
		}
	}
	
	private class xmlExportAction extends AbstractAction {
		private static final long serialVersionUID = -4377920048321969857L;
		public xmlExportAction() {
			putValue(NAME, "XML-Export");
			putValue(SHORT_DESCRIPTION, "Exportieren des Objektbestandes in eine XML-Datei");
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
	            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	            DocumentBuilder builder = factory.newDocumentBuilder();
	            Document document = builder.newDocument();
	        
	            Element root = document.createElement("XML");
	            document.appendChild(root);
	            
	            Element allefluesse = document.createElement("Fl\u00fcsse");
	            root.appendChild(allefluesse);
	            
	            for(String pfname : Fluss.getAllInstances().keySet()) {
	            	Fluss pf = Fluss.getInstance(pfname); 
	            	Element fluss = document.createElement("Fluss");
	            	allefluesse.appendChild(fluss);
	            	Element name = document.createElement("Fluss-Name");
		            fluss.appendChild(name);
		            name.appendChild(document.createTextNode(pf.getName()));
		            Element typ = document.createElement("Fluss-Typ");
		            fluss.appendChild(typ);
		            typ.appendChild(document.createTextNode(pf.getTyp().toString()));
		            Element einheit = document.createElement("Fluss-Einheit");
		            fluss.appendChild(einheit);
		            einheit.appendChild(document.createTextNode(pf.getEinheit().toString()));
				}
	            
	            Element allemodule = document.createElement("Prozessmodule");
	            root.appendChild(allemodule);
	            
				for(String mn : Prozessmodul.getAllInstances().keySet()) {
					Prozessmodul akModul = Prozessmodul.getInstance(mn);
					Element prozessmodul = document.createElement("Prozessmodul");
					allemodule.appendChild(prozessmodul);
					Element name = document.createElement("Prozessmodul-Name");
					prozessmodul.appendChild(name);
					name.appendChild(document.createTextNode(akModul.getName()));
					Element efv = document.createElement("Elementarflussvektor");
					prozessmodul.appendChild(efv);	            
		            for(Fluss pf : akModul.getElementarflussvektor().keySet()){
		            	Element fluss = document.createElement("EFV-Element");
						efv.appendChild(fluss);	
		            	Element fname = document.createElement("FV-Element-Name");
		            	fluss.appendChild(fname);
		            	fname.appendChild(document.createTextNode(pf.getName()));
		            	Element menge = document.createElement("FV-Element-Menge");
		            	fluss.appendChild(menge);
		            	menge.appendChild(document.createTextNode(akModul.getElementarflussvektor().get(pf).toString()));
		            }
		            Element pfv = document.createElement("Produktflussvektor");
					prozessmodul.appendChild(pfv);	  
		            for(Fluss pf : akModul.getProduktflussvektor().keySet()){
		            	Element fluss = document.createElement("PFV-Element");
						pfv.appendChild(fluss);
		            	Element fname = document.createElement("FV-Element-Name");
		            	fluss.appendChild(fname);
		            	fname.appendChild(document.createTextNode(pf.getName()));
		            	Element menge = document.createElement("FV-Element-Menge");
		            	fluss.appendChild(menge);
		            	menge.appendChild(document.createTextNode(akModul.getProduktflussvektor().get(pf).toString()));
		            }

				}
				
				Element alleprosys = document.createElement("Produktsysteme");
	            root.appendChild(alleprosys);
	            
	            for(String psm : Produktsystem.getAllInstances().keySet()) {
	            	Produktsystem akProSys = Produktsystem.getAllInstances().get(psm);
					Element produktsystem = document.createElement("Produktsystem");
					alleprosys.appendChild(produktsystem);
					Element name = document.createElement("Produktsystem-Name");
					produktsystem.appendChild(name);
					name.appendChild(document.createTextNode(akProSys.getName()));
					Element modullist = document.createElement("PS-Module");
					produktsystem.appendChild(modullist);
					for (Flussvektoren mod  : Produktsystem.getInstance(psm).getModulliste()) {
						String modname = mod.getName();
						Element modul = document.createElement("PS-Modul");
						modullist.appendChild(modul);
						Element mname = document.createElement("PSM-Name");
						modul.appendChild(mname);
						mname.appendChild(document.createTextNode(modname));
					}					
					Element bv = document.createElement("Bedarfsvektor");
					produktsystem.appendChild(bv);		            	
	            	for (Fluss bvf : Produktsystem.getInstance(psm).getBedarfsvektor().keySet()) {
	            		Element bedarf = document.createElement("BV-Element");
	            		bv.appendChild(bedarf);
	            		Element fluss =  document.createElement("BV-Element-Name");
	            		bedarf.appendChild(fluss);
	            		fluss.appendChild(document.createTextNode(bvf.getName()));
	            		Element menge = document.createElement("BV-Element-Menge");
	            		bedarf.appendChild(menge);
	            		menge.appendChild(document.createTextNode(Produktsystem.getInstance(psm).
	            				getBedarfsvektor().get(bvf).toString()));
	            	}
	            	Element vuk = document.createElement("Vor-und-Koppelprodukte");
					produktsystem.appendChild(vuk);
	            	for (Fluss vkf : Produktsystem.getInstance(psm).getVorUndKoppelprodukte()){
	            		Element produkt = document.createElement("VuK-Element");
	            		vuk.appendChild(produkt);
	            		Element prodname =  document.createElement("VuK-Element-Name");
	            		produkt.appendChild(prodname);
	            		prodname.appendChild(document.createTextNode(vkf.getName()));
	            	}	            	
	            }
	            
	            Element alleWKs = document.createElement("Wirkungskategorien");
	            root.appendChild(alleWKs);
	            
	            for(String wkname : Wirkungskategorie.getAllInstances().keySet()) {
	            	Wirkungskategorie wk = Wirkungskategorie.getAllInstances().get(wkname); 
	            	Element wk2 = document.createElement("Wirkungskategorie");
	            	alleWKs.appendChild(wk2);
	            	Element name = document.createElement("WK-Name");
	            	wk2.appendChild(name);
		            name.appendChild(document.createTextNode(wk.getName()));
		            Element einheit = document.createElement("WK-Einheit");
		            wk2.appendChild(einheit);
		            einheit.appendChild(document.createTextNode(wk.getEinheit().toString()));
				}
	            
	            Element alleCFs = document.createElement("Charakterisierungsfaktoren");
	            root.appendChild(alleCFs);
	            
	            for(String cfname : CharakterFaktor.getAllInstances().keySet()) {
	            	CharakterFaktor cf = CharakterFaktor.getAllInstances().get(cfname); 
	            	Element cf2 = document.createElement("Charakterisierungsfaktor");
	            	alleCFs.appendChild(cf2);
	            	Element name = document.createElement("CF-Name");
	            	cf2.appendChild(name);
		            name.appendChild(document.createTextNode(cf.getName()));
	            	Element fluss = document.createElement("CF-Fluss");
	            	cf2.appendChild(fluss);
	            	fluss.appendChild(document.createTextNode(cf.getFluss().getName()));
	            	Element wirk = document.createElement("CF-Wirkung");
	            	cf2.appendChild(wirk);
	            	wirk.appendChild(document.createTextNode(cf.getWirkung().getName()));
	            	Element wert = document.createElement("CF-Wert");
	            	cf2.appendChild(wert);
	            	wert.appendChild(document.createTextNode(cf.getWert().toString()));

				}
	            
	            Element alleBMs = document.createElement("Bewertungsmethoden");
	            root.appendChild(alleBMs);
	            
	            for(String bmname : Bewertungsmethode.getAllBWs().keySet()) {
	            	Bewertungsmethode bm = Bewertungsmethode.instance(bmname); 
	            	Element bm2 = document.createElement("Bewertungsmethode");
	            	alleBMs.appendChild(bm2);
	            	Element name = document.createElement("BM-Name");
	            	bm2.appendChild(name);
		            name.appendChild(document.createTextNode(bm.getName()));
		            
		            Element faktoren = document.createElement("BM-Faktoren");
	            	bm2.appendChild(faktoren);
		            for (String fname : bm.getFaktorSet().keySet()) {
		            	Element faktor = document.createElement("BM-Faktor");
		            	faktoren.appendChild(faktor);
		            	faktor.appendChild(document.createTextNode(fname));		            	
		            }
		            Element kategorien = document.createElement("BM-Kategorien");
	            	bm2.appendChild(kategorien);
		            for (String kname : bm.kategorieListe().keySet()) {
		            	Element kat = document.createElement("BM-Kategorie");
		            	kategorien.appendChild(kat);
		            	kat.appendChild(document.createTextNode(kname));		            	
		            }
	            }
	            
	            Element allePDs = document.createElement("Produktdeklarationen");
	            root.appendChild(allePDs);
	            
	            for(String pdname : ProduktBilanziert.getAllInstances().keySet()) {
	            	ProduktBilanziert pd = ProduktBilanziert.getInstance(pdname); 
	            	Element pd2 = document.createElement("Produktdeklaration");
	            	allePDs.appendChild(pd2);
	            	Element name = document.createElement("PD-Name");
	            	pd2.appendChild(name);
		            name.appendChild(document.createTextNode(pd.getName()));
		            Element methode = document.createElement("PD-Methode");
	            	pd2.appendChild(methode);
		            methode.appendChild(document.createTextNode(pd.getBM().getName()));
		            Element wirkung = document.createElement("PD-Wirkungen");
	            	pd2.appendChild(wirkung);
	            	for (Wirkungskategorie w : pd.getWirkungsvektor(pd.getBM()).keySet()) {
	            		Element w2 = document.createElement("PD-Wirkung");
	            		wirkung.appendChild(w2);
	            		Element wname = document.createElement("PDW-Name");
		            	w2.appendChild(wname);
		            	wname.appendChild(document.createTextNode(w.getName()));
		            	Element wwert = document.createElement("PDW-Wert");
		            	w2.appendChild(wwert);
		            	wwert.appendChild(document.createTextNode(pd.getWirkungsvektor(pd.getBM()).get(w).toString()));
	            	}
	            }
	            
	            Element allePKentes = document.createElement("Produktkomponenten");
	            root.appendChild(allePKentes);
	            
	            for(String pkentename : Produktkomponente.getAllInstances().keySet()) {
	            	Produktkomponente pkente = Produktkomponente.get(pkentename);
	            	Element pk2 = document.createElement("Produktkomponente");
	            	allePKentes.appendChild(pk2);
	            	Element name = document.createElement("PKomponente-Name");
	            	pk2.appendChild(name);
	            	name.appendChild(document.createTextNode(pkente.getName()));
	            	Element prod = document.createElement("PKomponente-Produkt");
	            	pk2.appendChild(prod);
	            	prod.appendChild(document.createTextNode(pkente.getKomponente().getName()));
	            	Element menge = document.createElement("PKomponente-Menge");
	            	pk2.appendChild(menge);
	            	menge.appendChild(document.createTextNode(pkente.getMenge().toString()));
	            }
	            
	            Element allePKtions = document.createElement("Produktkompositionen");
	            root.appendChild(allePKtions);
	            
	            for(String pktionname : Produktkomposition.getAllInstances().keySet()) {
	            	Produktkomposition pktion = Produktkomposition.getInstance(pktionname);
	            	Element pk2 = document.createElement("Produktkomposition");
	            	allePKtions.appendChild(pk2);
	            	Element name = document.createElement("PKomposition-Name");
	            	pk2.appendChild(name);
	            	name.appendChild(document.createTextNode(pktion.getName()));
	            	Element zusa = document.createElement("PKomposition-Zusammensetzung");
	            	pk2.appendChild(zusa);
	            	for (Wirkungsvektor w : Produktkomposition.getInstance(pktionname).getZusammensetzung()) {
	            		Element z2 = document.createElement("PKZ-Bestandteil");
		            	zusa.appendChild(z2);
		            	z2.appendChild(document.createTextNode(w.getName()));
	            	}            	
	            }
	            
		        // JFileChooser-Objekt erstellen
		        JFileChooser chooser = new JFileChooser();
		        FileFilter filter = new FileNameExtensionFilter("XML-Dateien (*.xml)", "xml");
		        chooser.setFileFilter(filter);

		        // Dialog zum Speichern von Dateien anzeigen
		        int rueckgabeWert = chooser.showSaveDialog(null);
		        if(rueckgabeWert == JFileChooser.APPROVE_OPTION) {	        	
		        	DOMSource domSource = new DOMSource(document);
		        	File fileOutput = chooser.getSelectedFile();
		        	if (FilenameUtils.getExtension(fileOutput.getName()).equalsIgnoreCase("xml")) {
		        	    // filename is OK as-is
		        	} else {
		        		fileOutput = new File(fileOutput.toString() + ".xml");  // append .xml if "foo.jpg.xml" is OK
		        	}
		        	
		        	StreamResult streamResult = new StreamResult(fileOutput);
		            TransformerFactory tf = TransformerFactory.newInstance();

		            Transformer serializer = tf.newTransformer();
		            serializer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		            serializer.setOutputProperty(OutputKeys.INDENT, "yes");
		            serializer.transform(domSource, streamResult);
		        }
		        
	        } catch(ParserConfigurationException e) {
	            e.printStackTrace();
	        } catch(Throwable e) {
	            e.printStackTrace();
	        } 
		}
		
	}
	
	private class xmlImportAction extends AbstractAction {
		private static final long serialVersionUID = -4377920048321969857L;
		public xmlImportAction() {
			putValue(NAME, "XML-Import");
			putValue(SHORT_DESCRIPTION, "Importieren eines Objektbestandes aus einer XML-Datei");
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
	        // JFileChooser-Objekt erstellen
	        JFileChooser chooser = new JFileChooser();
	        FileFilter filter = new FileNameExtensionFilter("XML-Dateien (*.xml)", "xml");
	        chooser.setFileFilter(filter);
	        
	        // Dialog zum Laden von Dateien anzeigen
	        int rueckgabeWert = chooser.showOpenDialog(null);
	        if(rueckgabeWert == JFileChooser.APPROVE_OPTION) {
	        	File fileInput = chooser.getSelectedFile();
	        	DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	        	try {
					DocumentBuilder db = dbf.newDocumentBuilder();
					try {
						Document dom = db.parse(fileInput);
						Element docEle = dom.getDocumentElement();
						
						NameCheck.clear();
						
						Fluss.clear();
						NodeList nl = docEle.getElementsByTagName("Fluss");
						for (int i = 0; i < nl.getLength(); i++) {
							NodeList nlc = nl.item(i).getChildNodes();
							String flussname = "";
							String flusstyp = "";
							String flusseinheit = "";
							for (int j = 0; j < nlc.getLength(); j++) {
								if (nlc.item(j).getNodeName().equals("Fluss-Name")) {
									flussname = nlc.item(j).getTextContent();
								}
								if (nlc.item(j).getNodeName().equals("Fluss-Typ")) {
									flusstyp = nlc.item(j).getTextContent();
								}
								if (nlc.item(j).getNodeName().equals("Fluss-Einheit")) {
									flusseinheit = nlc.item(j).getTextContent();
								}	
							}
							FlussTyp ft = FlussTyp.valueOf(flusstyp);
							FlussEinheit fe = FlussEinheit.valueOf(flusseinheit);
							Fluss.instance(flussname, ft, fe);
						}
						Prozessmodul.clear();
						nl = docEle.getElementsByTagName("Prozessmodul");
						for (int i = 0; i < nl.getLength(); i++) {
							NodeList nlc = nl.item(i).getChildNodes();
							String pmname = "";	
							String fvename = "";	
							String fvemenge = "";
							HashMap<Fluss, Double> pmfv = new HashMap<Fluss, Double>();						
							for (int j = 0; j < nlc.getLength(); j++) {							
								if (nlc.item(j).getNodeName().equals("Prozessmodul-Name")) {									
									pmname = nlc.item(j).getTextContent();
								}
								if (nlc.item(j).getNodeName().equals("Elementarflussvektor") ||
										nlc.item(j).getNodeName().equals("Produktflussvektor")) {									
									NodeList nlc2 = nlc.item(j).getChildNodes();
									for (int k = 0; k < nlc2.getLength(); k++) {
										if (nlc2.item(k).getNodeName().equals("EFV-Element") ||
												nlc2.item(k).getNodeName().equals("PFV-Element")) {											
											NodeList nlc3 = nlc2.item(k).getChildNodes();
											for (int l = 0; l < nlc3.getLength(); l++) {
												if (nlc3.item(l).getNodeName().equals("FV-Element-Name")) {
													fvename = nlc3.item(l).getTextContent();
												}
												if (nlc3.item(l).getNodeName().equals("FV-Element-Menge")) {
													fvemenge = nlc3.item(l).getTextContent();
													Fluss akFluss = Fluss.getInstance(fvename);
													pmfv.put(akFluss, Double.parseDouble(fvemenge));
												}
											}											
										}
									}
								}
							}
							Prozessmodul.instance(pmname);
							for (Fluss akFluss : pmfv.keySet()) {
								Prozessmodul.getInstance(pmname).addFluss(akFluss, pmfv.get(akFluss));
							}
						}
						Produktsystem.clear();
						nl = docEle.getElementsByTagName("Produktsystem");
						HashMap<String, LinkedList<String>> mnls = new HashMap<String, LinkedList<String>>();
						for (int i = 0; i < nl.getLength(); i++) {
							NodeList nlc = nl.item(i).getChildNodes();
							String psname = "";	
							String bvename = "";
							String bvemenge = "";	
							LinkedList<String> mnl = new LinkedList<String>();
							HashMap<Fluss, Double> bv = new HashMap<Fluss, Double>();
							LinkedList<Fluss> vuk = new LinkedList<Fluss>();
							for (int j = 0; j < nlc.getLength(); j++) {	
								if (nlc.item(j).getNodeName().equals("Produktsystem-Name")) {
									psname = nlc.item(j).getTextContent();
								}
								if (nlc.item(j).getNodeName().equals("PS-Module")) {
									NodeList nlc2 = nlc.item(j).getChildNodes();
									for (int k = 0; k < nlc2.getLength(); k++) {
										if (nlc2.item(k).getNodeName().equals("PS-Modul")) {
											NodeList nlc3 = nlc2.item(k).getChildNodes();
											for (int l = 0; l < nlc3.getLength(); l++) {
												if (nlc3.item(l).getNodeName().equals("PSM-Name")) {
													String modname = nlc3.item(l).getTextContent();	
													mnl.add(modname);
												}											
											}										
										}
									}
								}
								if (nlc.item(j).getNodeName().equals("Bedarfsvektor")) {
									NodeList nlc2 = nlc.item(j).getChildNodes();
									for (int k = 0; k < nlc2.getLength(); k++) {
										if (nlc2.item(k).getNodeName().equals("BV-Element")) {
											NodeList nlc3 = nlc2.item(k).getChildNodes();
											for (int l = 0; l < nlc3.getLength(); l++) {
												if (nlc3.item(l).getNodeName().equals("BV-Element-Name")) {
													bvename = nlc3.item(l).getTextContent();
												}
												if (nlc3.item(l).getNodeName().equals("BV-Element-Menge")) {
													bvemenge = nlc3.item(l).getTextContent();
													Fluss akFluss = Fluss.getInstance(bvename);
													bv.put(akFluss, Double.parseDouble(bvemenge));
												}
											}											
										}
									}
								}
								if (nlc.item(j).getNodeName().equals("Vor-und-Koppelprodukte")) {
									NodeList nlc2 = nlc.item(j).getChildNodes();
									for (int k = 0; k < nlc2.getLength(); k++) {
										if (nlc2.item(k).getNodeName().equals("VuK-Element")) {
											NodeList nlc3 = nlc2.item(k).getChildNodes();
											for (int l = 0; l < nlc3.getLength(); l++) {
												if (nlc3.item(l).getNodeName().equals("VuK-Element-Name")) {
													String flname = nlc3.item(l).getTextContent();
													Fluss akFluss = Fluss.getInstance(flname);
													vuk.add(akFluss);
												}											
											}										
										}
									}									
								}							
							}
							Produktsystem.instance(psname, bv, vuk);
							mnls.put(psname, mnl);																			
						}
						for (String psname : mnls.keySet()) {
							LinkedList<String> mnl = mnls.get(psname);
							for (String m : mnl) {
								if (Prozessmodul.containsName(m)) {
									Produktsystem.getInstance(psname).addProzessmodul(Prozessmodul.getInstance(m));
								} else {
									Produktsystem.getInstance(psname).addProzessmodul(Produktsystem.getInstance(m));
								} 
							}
						}
						Wirkungskategorie.clear();
						nl = docEle.getElementsByTagName("Wirkungskategorie");
						for (int i = 0; i < nl.getLength(); i++) {
							NodeList nlc = nl.item(i).getChildNodes();
							String wkname = "";
							String wkeinheit = "";
							for (int j = 0; j < nlc.getLength(); j++) {
								if (nlc.item(j).getNodeName().equals("WK-Name")) {
									wkname = nlc.item(j).getTextContent();
								}
								if (nlc.item(j).getNodeName().equals("WK-Einheit")) {
									wkeinheit = nlc.item(j).getTextContent();
								}	
							}
							Wirkungsindikator wi = Wirkungsindikator.valueOf(wkeinheit);
							Wirkungskategorie.instance(wkname, wi);
						}
						CharakterFaktor.clear();
						nl = docEle.getElementsByTagName("Charakterisierungsfaktor");
						for (int i = 0; i < nl.getLength(); i++) {
							NodeList nlc = nl.item(i).getChildNodes();
							String cfname = "";
							String cffluss = "";
							String cfwirkung = "";
							String cfwert = "";
							for (int j = 0; j < nlc.getLength(); j++) {
								if (nlc.item(j).getNodeName().equals("CF-Name")) {
									cfname = nlc.item(j).getTextContent();
								}
								if (nlc.item(j).getNodeName().equals("CF-Fluss")) {
									cffluss = nlc.item(j).getTextContent();
								}
								if (nlc.item(j).getNodeName().equals("CF-Wirkung")) {
									cfwirkung = nlc.item(j).getTextContent();
								}
								if (nlc.item(j).getNodeName().equals("CF-Wert")) {
									cfwert = nlc.item(j).getTextContent();
								}
							}
							Fluss akFluss = Fluss.getInstance(cffluss);
							Wirkungskategorie akWirk = null;
							for (String wkst : Wirkungskategorie.getAllInstances().keySet()) {
								if(cfwirkung.equals(wkst)){
									akWirk = Wirkungskategorie.getAllInstances().get(wkst);									
								}	
							}
							Double akWert = Double.parseDouble(cfwert);
							CharakterFaktor.instance(cfname, akFluss, akWirk, akWert);
						}
						Bewertungsmethode.clear();
						nl = docEle.getElementsByTagName("Bewertungsmethode");
						for (int i = 0; i < nl.getLength(); i++) {
							NodeList nlc = nl.item(i).getChildNodes();
							String bmname = "";							
							HashMap<String, CharakterFaktor> fakset = new HashMap<String, CharakterFaktor>();
							HashMap<String, Wirkungskategorie> katset = new HashMap<String, Wirkungskategorie>();
							for (int j = 0; j < nlc.getLength(); j++) {	
								if (nlc.item(j).getNodeName().equals("BM-Name")) {
									bmname = nlc.item(j).getTextContent();
								}
								if (nlc.item(j).getNodeName().equals("BM-Faktoren")) {
									NodeList nlc2 = nlc.item(j).getChildNodes();
									for (int k = 0; k < nlc2.getLength(); k++) {
										if (nlc2.item(k).getNodeName().equals("BM-Faktor")) {
											String fakname = nlc2.item(k).getTextContent();
											fakset.put(fakname, CharakterFaktor.getAllInstances().get(fakname));
										}
									}										
								}
								if (nlc.item(j).getNodeName().equals("BM-Kategorien")) {
									NodeList nlc2 = nlc.item(j).getChildNodes();
									for (int k = 0; k < nlc2.getLength(); k++) {
										if (nlc2.item(k).getNodeName().equals("BM-Kategorie")) {
											String katname = nlc2.item(k).getTextContent();
											katset.put(katname, Wirkungskategorie.getAllInstances().get(katname));
										}
									}
								}
							}
							Bewertungsmethode akbm = Bewertungsmethode.instance(bmname);
							for (String fn : fakset.keySet()) {
								akbm.addFaktor(fakset.get(fn));
							}
							fakset.clear();
							for (String kn : katset.keySet()) {
								akbm.addWK(katset.get(kn));
							}
							katset.clear();
						}
						
						ProduktBilanziert.clear();
						nl = docEle.getElementsByTagName("Produktdeklaration");
						for (int i = 0; i < nl.getLength(); i++) {
							NodeList nlc = nl.item(i).getChildNodes();
							String pdname = "";	
							String pdmethode = "";	
							String pdwname = "";
							String pdwwert = "";
							HashMap<Wirkungskategorie, Double> pdwv = new HashMap<Wirkungskategorie, Double>();
							for (int j = 0; j < nlc.getLength(); j++) {
								if (nlc.item(j).getNodeName().equals("PD-Name")) {
									pdname = nlc.item(j).getTextContent();
								}
								if (nlc.item(j).getNodeName().equals("PD-Methode")) {
									pdmethode = nlc.item(j).getTextContent();
								}
								if (nlc.item(j).getNodeName().equals("PD-Wirkungen")) {
									NodeList nlc2 = nlc.item(j).getChildNodes();
									for (int k = 0; k < nlc2.getLength(); k++) {
										if (nlc2.item(k).getNodeName().equals("PD-Wirkung")) {
											NodeList nlc3 = nlc2.item(k).getChildNodes();
											for (int l = 0; l < nlc3.getLength(); l++) {
												if (nlc3.item(l).getNodeName().equals("PDW-Name")) {
													pdwname = nlc3.item(l).getTextContent();
												}
												if (nlc3.item(l).getNodeName().equals("PDW-Wert")) {
													pdwwert = nlc3.item(l).getTextContent();
												}
											}
											pdwv.put(Wirkungskategorie.getAllInstances().get(pdwname), Double.parseDouble(pdwwert));
										}
									}
								}
							}
							ProduktBilanziert akpb = ProduktBilanziert.instance(pdname);
							akpb.setBM(Bewertungsmethode.getAllBWs().get(pdmethode));
							for (Wirkungskategorie w : pdwv.keySet()) {
								akpb.addWirkung(w, pdwv.get(w));
							}	
							pdwv.clear();
						}

						Produktkomponente.clear();
						nl = docEle.getElementsByTagName("Produktkomponente");
						for (int i = 0; i < nl.getLength(); i++) {
							NodeList nlc = nl.item(i).getChildNodes();
							String pkname = "";
							String pkprod = "";
							String pkmenge = "";
							for (int j = 0; j < nlc.getLength(); j++) {
								if (nlc.item(j).getNodeName().equals("PKomponente-Name")) {
									pkname = nlc.item(j).getTextContent();
								}
								if (nlc.item(j).getNodeName().equals("PKomponente-Produkt")) {
									pkprod = nlc.item(j).getTextContent();
								}
								if (nlc.item(j).getNodeName().equals("PKomponente-Menge")) {
									pkmenge = nlc.item(j).getTextContent();
								}								
							}
							Wirkungsvektor kompo = Prozessmodul.instance("dummy");
							if (Prozessmodul.containsName(pkprod)) {
								kompo = Prozessmodul.getInstance(pkprod);					
							}
							Prozessmodul.removeInstance("dummy");
							if (Produktsystem.containsName(pkprod)) {
								kompo = Produktsystem.getInstance(pkprod);					
							}
							if (ProduktBilanziert.containsName(pkprod)) {
								kompo = ProduktBilanziert.getInstance(pkprod);					
							}
							if (Produktkomponente.containsName(pkprod)) {
								kompo = Produktkomponente.get(pkprod);					
							}
							if (Produktkomposition.containsName(pkprod)) {
								kompo = Produktkomposition.getInstance(pkprod);					
							}				
							Produktkomponente.newInstance(pkname, kompo, Double.parseDouble(pkmenge));
						}
						
						Produktkomposition.clear();
						nl = docEle.getElementsByTagName("Produktkomposition");
						HashMap<String, LinkedList<String>> knls = new HashMap<String, LinkedList<String>>();
						for (int i = 0; i < nl.getLength(); i++) {
							NodeList nlc = nl.item(i).getChildNodes();
							String koname = "";	
							LinkedList<String> zusa = new LinkedList<String>();
							for (int j = 0; j < nlc.getLength(); j++) {
								if (nlc.item(j).getNodeName().equals("PKomposition-Name")) {
									koname = nlc.item(j).getTextContent();
								}
								if (nlc.item(j).getNodeName().equals("PKomposition-Zusammensetzung")) {
									NodeList nlc2 = nlc.item(j).getChildNodes();
									for (int k = 0; k < nlc2.getLength(); k++) {
										if (nlc2.item(k).getNodeName().equals("PKZ-Bestandteil")) {
											zusa.add(nlc2.item(k).getTextContent());									
										}										
									}								
								}
							}
							Produktkomposition.instance(koname);
							knls.put(koname, zusa);							
						}
						for (String koname : knls.keySet()) {
							for (String pkprod : knls.get(koname)) {
								Wirkungsvektor kompo = Prozessmodul.instance("dummy");
								if (Prozessmodul.containsName(pkprod)) {
									kompo = Prozessmodul.getInstance(pkprod);					
								}
								Prozessmodul.removeInstance("dummy");
								if (Produktsystem.containsName(pkprod)) {
									kompo = Produktsystem.getInstance(pkprod);					
								}
								if (ProduktBilanziert.containsName(pkprod)) {
									kompo = ProduktBilanziert.getInstance(pkprod);					
								}
								if (Produktkomponente.containsName(pkprod)) {
									kompo = Produktkomponente.get(pkprod);					
								}
								if (Produktkomposition.containsName(pkprod)) {
									kompo = Produktkomposition.getInstance(pkprod);					
								}
								Produktkomposition.getInstance(koname).addKomponente(kompo);								
							}
						}						
						
					} catch (SAXException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}				
				} catch (ParserConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
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
