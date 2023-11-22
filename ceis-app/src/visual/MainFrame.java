package visual;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Event;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

import org.jdesktop.swingx.JXTaskPane;
import org.jdesktop.swingx.JXTaskPaneContainer;

import visual.dialog.DialogFindPerson;
import visual.dialog.control.DialogAccess;
import visual.dialog.localkey.DialogNewLocal;
import visual.dialog.newPersonal.DialogDocent;
import visual.dialog.newPersonal.DialogStudent;
import visual.dialog.newPersonal.DialogTecAd;
import visual.dialog.newPersonal.DialogVisitor;
import visual.dialog.rules.DialogNewRule;
import visual.own.OwnLabel;
import visual.own.OwnTabbedPane;
import visual.own.ToolButton;
import visual.show.PanelTabAbout;
import visual.show.PanelTabAccess;
import visual.show.PanelTabDocent;
import visual.show.PanelTabLocal;
import visual.show.PanelTabRequestKey;
import visual.show.PanelTabRules;
import visual.show.PanelTabSchemeKey;
import visual.show.PanelTabSchemeLocal;
import visual.show.PanelTabStudent;
import visual.show.PanelTabTecAd;
import visual.show.PanelTabVisitor;
import visual.show.report.PanelTabAccessWorker;
import visual.show.report.PanelTabFindKey;
import visual.show.report.PanelTabMoreRequestDocent;
import visual.show.report.PanelTabRequested;
import visual.show.report.PanelTabVisit;
import visual.util.SaveData;
import visual.util.forDBAction.DBActionButton;
import visual.util.forDBAction.InformationDisplayed;
import visual.util.forDBAction.TabInfo;
import visual.util.forDBAction.UpdateTabPanel;
import visual.util.forDBAction.enumeration.TypeInfo;
import ceis.CEIS;
import ceis.person.Person;
import ceis.person.Visitor;
import ceis.person.registered.StudentAssistant;
import ceis.person.registered.worker.Docent;
import ceis.person.registered.worker.TecnicAdmin;
import ceis.rules.Rule;
import ceis.rules.entities.Local;
import ceis.rules.entities.RulesEntities;
import exception.DontExistException;
import exception.DuplicityException;
import exception.EmptyDataShowException;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private String pathHelpDocument = "help/HelpDoc.pdf";  //  @jve:decl-index=0:
	
	private static InformationDisplayed displayInfo;  //  @jve:decl-index=0:

	private JPanel jContentPane = null;

	private JMenuBar menuBarCeis = null;

	private JMenu menuCeis = null;

	private JMenu menuPersonal = null;

	private JMenu menuReport = null;

	private JMenu menuHelp = null;

	private JMenu menuCeisRules = null;

	private JMenuItem itemNewRules = null;

	private JPopupMenu.Separator separator1 = null;

	private JMenuItem itemRequestRules = null;

	private JPopupMenu.Separator separator2 = null;

	private JMenuItem itemRegistryAccess = null;

	private JMenuItem itemRequestedKey = null;

	private JMenu menuScheme = null;

	private JMenuItem itemSchemeLocal = null;

	private JMenuItem itemSchemeKeys = null;

	private JPopupMenu.Separator separator4 = null;

	private JMenuItem itemExit = null;

	private JMenu menuPersonalNew = null;

	private JMenuItem itemDocente = null;

	private JMenuItem itemTecAd = null;

	private JMenuItem itemStudent = null;

	private JPopupMenu.Separator separator5 = null;

	private JMenuItem itemFindPersonal = null;

	private JMenu menuReportFind = null;

	private JMenuItem itemFindDocent = null;

	private JMenuItem itemFindTecAd = null;

	private JMenuItem itemFindStudent = null;

	private JPopupMenu.Separator separator6 = null;

	private JMenuItem itemFindVisitor = null;

	private JMenuItem contentHelp = null;

	private JPopupMenu.Separator separator7 = null;

	private JMenuItem about = null;

	private JPanel centerPanel = null;

	private JToolBar toolBar = null;

	private ToolButton addButton = null;

	private ToolButton modifyButton = null;

	private ToolButton deleteButton = null;

	private JToolBar.Separator separatorT1 = null;

	private ToolButton firstButton = null;

	private ToolButton prevButton = null;

	private ToolButton nextButton = null;

	private ToolButton lastButton = null;

	private JToolBar.Separator separatorT2 = null;

	private ToolButton helpButton = null;

	private OwnTabbedPane tabs = null;
	
	private JXTaskPane taskPaneNew;
	
	private JXTaskPane taskPaneReport;

	private JXTaskPaneContainer TaskPaneContainer = null;

	private JMenuItem itemMenuNewLocal = null;

	private JPopupMenu.Separator separator10 = null;

	private JMenuItem itemVisitor = null;

	private JPopupMenu.Separator separator11 = null;

	private JMenu menuRegistry = null;

	private JMenuItem itemAccesses = null;

	private JMenuItem itemKeyRequest = null;

	private JMenu menuNew = null;

	private JMenuItem itemSeeLocals = null;

	private JPopupMenu.Separator separator40 = null;

	private JMenuItem itemReport1 = null;

	private JMenuItem itemReport2 = null;

	private JMenuItem itemReport3_4 = null;

	private JMenuItem itemFindKey = null;

	private JMenuItem itemReport5 = null;

	/**
	 * This is the default constructor
	 */
	public MainFrame() {
		super();
		displayInfo = getInformationDisplayed();
		createTaskPane();
		initialize();
	}
	
	public static InformationDisplayed getInformationDisplayed(){
		if(displayInfo == null)
			displayInfo = new InformationDisplayed();
		return displayInfo;
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(455, 309);
		this.setFont(new Font("Calibri", Font.PLAIN, 12));
		this.setJMenuBar(getMenuBarCeis());
		this.setContentPane(getJContentPane());
		this.setTitle("Control de acceso al CEIS");
		this.setExtendedState(MAXIMIZED_BOTH);
		viewAbout();
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getTaskPaneContainer(), BorderLayout.WEST);
			jContentPane.add(getCenterPanel(), BorderLayout.CENTER);
		}
		return jContentPane;
	}

	/**
	 * This method initializes menuBarCeis	
	 * 	
	 * @return javax.swing.JMenuBar	
	 */
	private JMenuBar getMenuBarCeis() {
		if (menuBarCeis == null) {
			menuBarCeis = new JMenuBar();
			menuBarCeis.add(getMenuCeis());
			menuBarCeis.add(getMenuPersonal());
			menuBarCeis.add(getMenuReport());
			menuBarCeis.add(getMenuHelp());
		}
		return menuBarCeis;
	}

	/**
	 * This method initializes menuCeis	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getMenuCeis() {
		if (menuCeis == null) {
			menuCeis = new JMenu();
			menuCeis.setText("CEIS");
			menuCeis.setMnemonic(KeyEvent.VK_C);
			menuCeis.setFont(new Font("Calibri", Font.PLAIN, 12));
			menuCeis.add(getMenuNew());
			menuCeis.add(getMenuCeisRules());
			menuCeis.add(getSeparator2());
			menuCeis.add(getItemSeeLocals());
			menuCeis.add(getMenuRegistry());
			menuCeis.add(getMenuScheme());
			menuCeis.add(getSeparator4());
			menuCeis.add(getItemExit());
		}
		return menuCeis;
	}

	/**
	 * This method initializes menuPersonal	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getMenuPersonal() {
		if (menuPersonal == null) {
			menuPersonal = new JMenu();
			menuPersonal.setText("Personal");
			menuPersonal.setMnemonic(KeyEvent.VK_P);
			menuPersonal.setFont(new Font("Calibri", Font.PLAIN, 12));
			menuPersonal.add(getMenuPersonalNew());
			menuPersonal.add(getSeparator5());
			menuPersonal.add(getItemFindPersonal());
		}
		return menuPersonal;
	}

	/**
	 * This method initializes menuReport	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getMenuReport() {
		if (menuReport == null) {
			menuReport = new JMenu();
			menuReport.setText("Reportes");
			menuReport.setMnemonic(KeyEvent.VK_T);
			menuReport.setFont(new Font("Calibri", Font.PLAIN, 12));
			menuReport.add(getMenuReportFind());
			menuReport.add(getSeparator40());
			menuReport.add(getItemReport1());
			menuReport.add(getItemReport2());
			menuReport.add(getItemReport3_4());
			menuReport.add(getItemFindKey());
			menuReport.add(getItemReport5());
		}
		return menuReport;
	}

	/**
	 * This method initializes menuHelp	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getMenuHelp() {
		if (menuHelp == null) {
			menuHelp = new JMenu();
			menuHelp.setText("Ayuda");
			menuHelp.setMnemonic(KeyEvent.VK_Y);
			menuHelp.setFont(new Font("Calibri", Font.PLAIN, 12));
			menuHelp.add(getContentHelp());
			menuHelp.add(getSeparator7());
			menuHelp.add(getAbout());
		}
		return menuHelp;
	}

	/**
	 * This method initializes menuCeisRules	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getMenuCeisRules() {
		if (menuCeisRules == null) {
			menuCeisRules = new JMenu();
			menuCeisRules.setText("Reglas de acceso");
			menuCeisRules.setMnemonic(KeyEvent.VK_R);
			menuCeisRules.setFont(new Font("Calibri", Font.PLAIN, 12));
			menuCeisRules.add(getItemNewRules());
			menuCeisRules.add(getSeparator1());
			menuCeisRules.add(getItemRequestRules());
		}
		return menuCeisRules;
	}

	/**
	 * This method initializes itemNewRules	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getItemNewRules() {
		if (itemNewRules == null) {
			itemNewRules = new JMenuItem();
			itemNewRules.setText("Nueva");
			itemNewRules.setFont(new Font("Calibri", Font.PLAIN, 12));
			itemNewRules.setIcon(new ImageIcon(getClass().getResource("/icons/scheme.png")));
			itemNewRules.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, Event.CTRL_MASK | Event.SHIFT_MASK, false));
			itemNewRules.setMnemonic(KeyEvent.VK_N);
			itemNewRules.addActionListener(new java.awt.event.ActionListener() {   
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					try {
						newRule();
					}
					catch (DontExistException ex) {
						JOptionPane.showMessageDialog(MainFrame.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			
			});
		}
		return itemNewRules;
	}

	/**
	 * This method initializes separator1	
	 * 	
	 * @return javax.swing.JPopupMenu.Separator	
	 */
	private JPopupMenu.Separator getSeparator1() {
		if (separator1 == null) {
			separator1 = new JPopupMenu.Separator();
		}
		return separator1;
	}

	/**
	 * This method initializes itemRequestRules	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getItemRequestRules() {
		if (itemRequestRules == null) {
			itemRequestRules = new JMenuItem();
			itemRequestRules.setText("Ver reglas");
			itemRequestRules.setFont(new Font("Calibri", Font.PLAIN, 12));
			itemRequestRules.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, Event.CTRL_MASK, false));
			itemRequestRules.setMnemonic(KeyEvent.VK_S);
			itemRequestRules.addActionListener(new java.awt.event.ActionListener() {   
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					lookAtRules();
					toolBar.setVisible(true);
				}
			
			});
		}
		return itemRequestRules;
	}

	/**
	 * This method initializes separator2	
	 * 	
	 * @return javax.swing.JPopupMenu.Separator	
	 */
	private JPopupMenu.Separator getSeparator2() {
		if (separator2 == null) {
			separator2 = new JPopupMenu.Separator();
		}
		return separator2;
	}

	/**
	 * This method initializes itemRegistryAccess	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getItemRegistryAccess() {
		if (itemRegistryAccess == null) {
			itemRegistryAccess = new JMenuItem();
			itemRegistryAccess.setText("Registro de accesos");
			itemRegistryAccess.setFont(new Font("Calibri", Font.PLAIN, 12));
			itemRegistryAccess.setIcon(new ImageIcon(getClass().getResource("/icons/accesses.png")));
			itemRegistryAccess.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, Event.CTRL_MASK, false));
			itemRegistryAccess.setMnemonic(KeyEvent.VK_E);
			itemRegistryAccess.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try {
						PanelTabAccess contentPane = new PanelTabAccess();
						tabs.addTab("Registro de accesos", "Registro que comprende el listado con todas las personas que han accedido al CEIS y aun se encuentran en el", "src/icons/door_in.png", contentPane);
						displayInfo.add(new TabInfo(TypeInfo.SHOW_REGISTRY_ACCESS, contentPane));
						toolBar.setVisible(true);
					}
					catch (EmptyDataShowException ex) {
						JOptionPane.showMessageDialog(MainFrame.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
		}
		return itemRegistryAccess;
	}

	/**
	 * This method initializes itemRequestedKey	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getItemRequestedKey() {
		if (itemRequestedKey == null) {
			itemRequestedKey = new JMenuItem();
			itemRequestedKey.setText("Solicitudes de llaves");
			itemRequestedKey.setFont(new Font("Calibri", Font.PLAIN, 12));
			itemRequestedKey.setIcon(new ImageIcon(getClass().getResource("/icons/book_key.png")));
			itemRequestedKey.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, Event.CTRL_MASK, false));
			itemRequestedKey.setMnemonic(KeyEvent.VK_L);
			itemRequestedKey.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try {
						PanelTabRequestKey contentPane = new PanelTabRequestKey();
						tabs.addTab("Solicitudes de llaves", "Registro que comprende el listado con todas las personas que han solicitado lave de locales y aun la tienes", "src/icons/book_key.png", contentPane);
						displayInfo.add(new TabInfo(TypeInfo.SHOW_REGISTRY_ACCESS, contentPane));
						toolBar.setVisible(true);
					}
					catch (EmptyDataShowException ex) {
						JOptionPane.showMessageDialog(MainFrame.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
		}
		return itemRequestedKey;
	}

	/**
	 * This method initializes menuScheme	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getMenuScheme() {
		if (menuScheme == null) {
			menuScheme = new JMenu();
			menuScheme.setText("Trazas");
			menuScheme.setMnemonic(KeyEvent.VK_Z);
			menuScheme.setFont(new Font("Calibri", Font.PLAIN, 12));
			menuScheme.add(getItemSchemeLocal());
			menuScheme.add(getItemSchemeKeys());
		}
		return menuScheme;
	}

	/**
	 * This method initializes itemSchemeLocal	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getItemSchemeLocal() {
		if (itemSchemeLocal == null) {
			itemSchemeLocal = new JMenuItem();
			itemSchemeLocal.setText("Locales");
			itemSchemeLocal.setFont(new Font("Calibri", Font.PLAIN, 12));
			itemSchemeLocal.setIcon(new ImageIcon(getClass().getResource("/icons/door.png")));
			itemSchemeLocal.setMnemonic(KeyEvent.VK_C);
			itemSchemeLocal.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try {
						PanelTabSchemeLocal contentPane = new PanelTabSchemeLocal();
						tabs.addTab("Trazas - Locales", "Registro de las trazas generadas ante las entradas y salidas del personal a los locales", "src/icons/door.png", contentPane);
						displayInfo.add(new TabInfo(TypeInfo.SHOW_SCHEME_ACCESS, contentPane));
						toolBar.setVisible(true);
					}
					catch (EmptyDataShowException ex) {
						JOptionPane.showMessageDialog(MainFrame.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
		}
		return itemSchemeLocal;
	}

	/**
	 * This method initializes itemSchemeKeys	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getItemSchemeKeys() {
		if (itemSchemeKeys == null) {
			itemSchemeKeys = new JMenuItem();
			itemSchemeKeys.setText("Llaves");
			itemSchemeKeys.setFont(new Font("Calibri", Font.PLAIN, 12));
			itemSchemeKeys.setIcon(new ImageIcon(getClass().getResource("/icons/key.png")));
			itemSchemeKeys.setMnemonic(KeyEvent.VK_V);
			itemSchemeKeys.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try {
						PanelTabSchemeKey contentPane = new PanelTabSchemeKey();
						tabs.addTab("Trazas - Locales", "Registro de las trazas generadas ante las entradas y salidas del personal a los locales", "src/icons/key.png", contentPane);
						displayInfo.add(new TabInfo(TypeInfo.SHOW_SCHEME_KEY_REQUEST, contentPane));
						toolBar.setVisible(true);
					}
					catch (EmptyDataShowException ex) {
						JOptionPane.showMessageDialog(MainFrame.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
		}
		return itemSchemeKeys;
	}

	/**
	 * This method initializes separator4	
	 * 	
	 * @return javax.swing.JPopupMenu.Separator	
	 */
	private JPopupMenu.Separator getSeparator4() {
		if (separator4 == null) {
			separator4 = new JPopupMenu.Separator();
		}
		return separator4;
	}

	/**
	 * This method initializes itemExit	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getItemExit() {
		if (itemExit == null) {
			itemExit = new JMenuItem();
			itemExit.setText("Salir");
			itemExit.setFont(new Font("Calibri", Font.PLAIN, 12));
			itemExit.setIcon(new ImageIcon(getClass().getResource("/icons/exit.png")));
			itemExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, Event.CTRL_MASK | Event.SHIFT_MASK, false));
			itemExit.setMnemonic(KeyEvent.VK_A);
			itemExit.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.exit(0);
				}
			});
		}
		return itemExit;
	}

	/**
	 * This method initializes menuPersonalNew	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getMenuPersonalNew() {
		if (menuPersonalNew == null) {
			menuPersonalNew = new JMenu();
			menuPersonalNew.setText("Nuevo");
			menuPersonalNew.setFont(new Font("Calibri", Font.PLAIN, 12));
			menuPersonalNew.setMnemonic(KeyEvent.VK_N);
			menuPersonalNew.add(getItemDocente());
			menuPersonalNew.add(getItemTecAd());
			menuPersonalNew.add(getItemStudent());
			menuPersonalNew.add(getSeparator11());
			menuPersonalNew.add(getItemVisitor());
		}
		return menuPersonalNew;
	}

	/**
	 * This method initializes itemDocente	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getItemDocente() {
		if (itemDocente == null) {
			itemDocente = new JMenuItem();
			itemDocente.setText("Docente");
			itemDocente.setMnemonic(KeyEvent.VK_T);
			itemDocente.setIcon(new ImageIcon(getClass().getResource("/icons/user_green.png")));
			itemDocente.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, Event.CTRL_MASK, false));
			itemDocente.setFont(new Font("Calibri", Font.PLAIN, 12));
			itemDocente.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try {
						newDocent();
					} catch (DontExistException e1) {
						JOptionPane.showMessageDialog(MainFrame.this, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);;
					}
				}
			});
		}
		return itemDocente;
	}

	/**
	 * This method initializes itemTecAd	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getItemTecAd() {
		if (itemTecAd == null) {
			itemTecAd = new JMenuItem();
			itemTecAd.setText("Técnico/Administrativo");
			itemTecAd.setMnemonic(KeyEvent.VK_A);
			itemTecAd.setIcon(new ImageIcon(getClass().getResource("/icons/user_red.png")));
			itemTecAd.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, Event.CTRL_MASK, false));
			itemTecAd.setFont(new Font("Calibri", Font.PLAIN, 12));
			itemTecAd.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try {
						newTecAd();
					} catch (DontExistException ex) {
						JOptionPane.showMessageDialog(MainFrame.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					} catch (DuplicityException ex2) {
						JOptionPane.showMessageDialog(MainFrame.this, ex2.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
		}
		return itemTecAd;
	}

	/**
	 * This method initializes itemStudent	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getItemStudent() {
		if (itemStudent == null) {
			itemStudent = new JMenuItem();
			itemStudent.setText("Alumno Ayudante");
			itemStudent.setMnemonic(KeyEvent.VK_Y);
			itemStudent.setIcon(new ImageIcon(getClass().getResource("/icons/user_orange.png")));
			itemStudent.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, Event.CTRL_MASK, false));
			itemStudent.setFont(new Font("Calibri", Font.PLAIN, 12));
			itemStudent.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try {
						newStudent();
					} catch (DontExistException ex1) {
						JOptionPane.showMessageDialog(MainFrame.this, ex1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					} catch (DuplicityException ex2) {
						JOptionPane.showMessageDialog(MainFrame.this, ex2.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
		}
		return itemStudent;
	}

	/**
	 * This method initializes separator5	
	 * 	
	 * @return javax.swing.JPopupMenu.Separator	
	 */
	private JPopupMenu.Separator getSeparator5() {
		if (separator5 == null) {
			separator5 = new JPopupMenu.Separator();
		}
		return separator5;
	}

	/**
	 * This method initializes itemFindPersonal	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getItemFindPersonal() {
		if (itemFindPersonal == null) {
			itemFindPersonal = new JMenuItem();
			itemFindPersonal.setText("Buscar...");
			itemFindPersonal.setMnemonic(KeyEvent.VK_B);
			itemFindPersonal.setIcon(new ImageIcon(getClass().getResource("/icons/search.png")));
			itemFindPersonal.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, Event.CTRL_MASK, false));
			itemFindPersonal.setFont(new Font("Calibri", Font.PLAIN, 12));
			itemFindPersonal.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					DialogFindPerson dialog = new DialogFindPerson(MainFrame.this);
					dialog.setVisible(true);
				}
			});
		}
		return itemFindPersonal;
	}

	/**
	 * This method initializes menuReportFind	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getMenuReportFind() {
		if (menuReportFind == null) {
			menuReportFind = new JMenu();
			menuReportFind.setText("Buscar");
			menuReportFind.setMnemonic(KeyEvent.VK_B);
			menuReportFind.setFont(new Font("Calibri", Font.PLAIN, 12));
			menuReportFind.add(getItemFindDocent());
			menuReportFind.add(getItemFindTecAd());
			menuReportFind.add(getItemFindStudent());
			menuReportFind.add(getSeparator6());
			menuReportFind.add(getItemFindVisitor());
		}
		return menuReportFind;
	}

	/**
	 * This method initializes itemFindDocent	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getItemFindDocent() {
		if (itemFindDocent == null) {
			itemFindDocent = new JMenuItem();
			itemFindDocent.setText("Docentes");
			itemFindDocent.setMnemonic(KeyEvent.VK_T);
			itemFindDocent.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, Event.CTRL_MASK | Event.SHIFT_MASK, false));
			itemFindDocent.setIcon(new ImageIcon(getClass().getResource("/icons/user_green.png")));
			itemFindDocent.setFont(new Font("Calibri", Font.PLAIN, 12));
			itemFindDocent.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try{
						viewDocent();
					}
					catch(EmptyDataShowException ex){
						JOptionPane.showMessageDialog(MainFrame.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
		}
		return itemFindDocent;
	}

	/**
	 * This method initializes itemFindTecAd	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getItemFindTecAd() {
		if (itemFindTecAd == null) {
			itemFindTecAd = new JMenuItem();
			itemFindTecAd.setText("Técnicos/Administrativos");
			itemFindTecAd.setFont(new Font("Calibri", Font.PLAIN, 12));
			itemFindTecAd.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, Event.CTRL_MASK | Event.SHIFT_MASK, false));
			itemFindTecAd.setIcon(new ImageIcon(getClass().getResource("/icons/user_red.png")));
			itemFindTecAd.setMnemonic(KeyEvent.VK_A);
			itemFindTecAd.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try{
						viewTecAd();
					}
					catch(EmptyDataShowException ex){
						JOptionPane.showMessageDialog(MainFrame.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
		}
		return itemFindTecAd;
	}

	/**
	 * This method initializes itemFindStudent	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getItemFindStudent() {
		if (itemFindStudent == null) {
			itemFindStudent = new JMenuItem();
			itemFindStudent.setText("Alumnos Ayudantes");
			itemFindStudent.setMnemonic(KeyEvent.VK_Y);
			itemFindStudent.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, Event.CTRL_MASK | Event.SHIFT_MASK, false));
			itemFindStudent.setIcon(new ImageIcon(getClass().getResource("/icons/user_orange.png")));
			itemFindStudent.setFont(new Font("Calibri", Font.PLAIN, 12));
			itemFindStudent.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try{
						viewStudent();
					}
					catch(EmptyDataShowException ex){
						JOptionPane.showMessageDialog(MainFrame.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
		}
		return itemFindStudent;
	}

	/**
	 * This method initializes separator6	
	 * 	
	 * @return javax.swing.JPopupMenu.Separator	
	 */
	private JPopupMenu.Separator getSeparator6() {
		if (separator6 == null) {
			separator6 = new JPopupMenu.Separator();
		}
		return separator6;
	}

	/**
	 * This method initializes itemFindVisitor	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getItemFindVisitor() {
		if (itemFindVisitor == null) {
			itemFindVisitor = new JMenuItem();
			itemFindVisitor.setText("Visitantes");
			itemFindVisitor.setFont(new Font("Calibri", Font.PLAIN, 12));
			itemFindVisitor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK | Event.SHIFT_MASK, false));
			itemFindVisitor.setIcon(new ImageIcon(getClass().getResource("/icons/user_suit.png")));
			itemFindVisitor.setMnemonic(KeyEvent.VK_V);
			itemFindVisitor.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try{
						viewVisitor();
					}
					catch(EmptyDataShowException ex){
						JOptionPane.showMessageDialog(MainFrame.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
		}
		return itemFindVisitor;
	}

	/**
	 * This method initializes contentHelp	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getContentHelp() {
		if (contentHelp == null) {
			contentHelp = new JMenuItem();
			contentHelp.setText("Contenido de la ayuda");
			contentHelp.setMnemonic(KeyEvent.VK_N);
			contentHelp.setIcon(new ImageIcon(getClass().getResource("/icons/help.png")));
			contentHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0, false));
			contentHelp.setFont(new Font("Calibri", Font.PLAIN, 12));
			contentHelp.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try {
						Desktop.getDesktop().open(new File(pathHelpDocument));
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(MainFrame.this, "Ha ocurrido un error en la apertura del fichero de ayuda", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
		}
		return contentHelp;
	}

	/**
	 * This method initializes separator7	
	 * 	
	 * @return javax.swing.JPopupMenu.Separator	
	 */
	private JPopupMenu.Separator getSeparator7() {
		if (separator7 == null) {
			separator7 = new JPopupMenu.Separator();
		}
		return separator7;
	}

	/**
	 * This method initializes about	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getAbout() {
		if (about == null) {
			about = new JMenuItem();
			about.setText("Acerca de ...");
			about.setFont(new Font("Calibri", Font.PLAIN, 12));
			about.setIcon(new ImageIcon(getClass().getResource("/icons/information.png")));
			about.setMnemonic(KeyEvent.VK_A);
			about.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					viewAbout();
				}
			});
		}
		return about;
	}
	
	private void viewAbout() {
		PanelTabAbout contentTable = new PanelTabAbout();
		tabs.addTab("Acerca de..", "Acerca de Sistema informático para el control de acceso al CEIS", "src/icons/logo_cujae16x16.png", contentTable);
		displayInfo.add(new TabInfo( TypeInfo.SHOW_ABOUT, contentTable));
		toolBar.setVisible(true);		
	}

//	Panel at left of main frame with task pane
	private void createTaskPane(){
		OwnLabel label;
		
		//Insert task pane with action New o Nuevo
		taskPaneNew = new JXTaskPane("Nuevo");
		taskPaneNew.setFont(new Font("Calibri", 14, 12));
		label = new OwnLabel("Acceso", new ImageIcon("src/icons/door_in.png"), "Registrar una nueva entrada de personal al centro");
		label.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				newAccess(true);
			}
		});
		taskPaneNew.add(label);
		label = new OwnLabel("Solicitar llave", new ImageIcon("src/icons/key_go.png"), "Registrar una nueva solicitud de llave por parte del personal del centro");
		label.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				newAccess(false);
			}
		});
		taskPaneNew.add(label);
		label = new OwnLabel("Local", new ImageIcon("src/icons/door.png"), "Crear un registro para un nuevo local del centro");
		label.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				newLocalAndKey();
			}
		});
		taskPaneNew.add(label);
		label = new OwnLabel("Regla de acceso", new ImageIcon("src/icons/scheme.png"), "Crear una nueva regla de acceso orientada a un local o una llave");
		label.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				try {
					newRule();
				}
				catch (DontExistException ex) {
					JOptionPane.showMessageDialog(MainFrame.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		taskPaneNew.add(label);
		label = new OwnLabel("Visitante", new ImageIcon("src/icons/user_suit.png"), "Crear una entrada para un personal no registrado en el CEIS");
		label.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				try {
					newVisitor();
				}
				catch (DontExistException ex1) {
					JOptionPane.showMessageDialog(MainFrame.this, ex1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
				catch(DuplicityException ex2){
					JOptionPane.showMessageDialog(MainFrame.this, ex2.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		taskPaneNew.add(label);
		
		//Insert task pane with action Reference o Consultas
		taskPaneReport = new JXTaskPane("Reportes");
		taskPaneReport.setFont(new Font("Calibri", 14, 12));
		label = new OwnLabel("Docentes", new ImageIcon("src/icons/user_green.png"), "Obtener los docentes del centro");
		label.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				try {
					viewDocent();
				}
				catch (EmptyDataShowException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		taskPaneReport.add(label);
		label = new OwnLabel("Técnicos/Administrativos", new ImageIcon("src/icons/user_red.png"), "Obtener el personal técnico/administrativo");
		label.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				try {
					viewTecAd();
				}
				catch (EmptyDataShowException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		taskPaneReport.add(label);
		label = new OwnLabel("Alumnos ayudantes", new ImageIcon("src/icons/user_orange.png"), "Ver los alumnos ayudantes relacionados con el centro");
		label.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				try {
					viewStudent();
				}
				catch (EmptyDataShowException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		taskPaneReport.add(label);
		label = new OwnLabel("Visitantes", new ImageIcon("src/icons/user_suit.png"), "Ver el listado de todo el personal que ha accedido el centro en pos de visitante");
		label.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				try {
					viewVisitor();
				}
				catch (EmptyDataShowException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		taskPaneReport.add(label);
		
		label = new OwnLabel("Buscar accesos de trabajadores", new ImageIcon("src/icons/report.png"), "Buscar todos los accesos a locales llevados a cabo por trabajadores del centro");
		label.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				report1();
			}
		});
		taskPaneReport.add(label);
		label = new OwnLabel("Visitas recibidas", new ImageIcon("src/icons/group.png"), "Listado con todas las entradas de personal en calidad de visitante");
		label.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				report2();
			}
		});
		taskPaneReport.add(label);
		label = new OwnLabel("Solicitudes/Entregas de llaves", new ImageIcon("src/icons/key.png"), "Listado de las personas que solicitaron o entregaron llaves");
		label.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				report3();
			}
		});
		taskPaneReport.add(label);
		label = new OwnLabel("Buscar llave", new ImageIcon("src/icons/search.png"), "Localiza donde se encuentra o quien tiene la llave de determinado local");
		label.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				try {
					report4();
				}
				catch (EmptyDataShowException e1) {
					JOptionPane.showMessageDialog(MainFrame.this, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		taskPaneReport.add(label);
		label = new OwnLabel("Mas extracciones de llaves", new ImageIcon("src/icons/report_key.png"), "Determina que docente ha solicitado la mayor cantidad de veces una determinadoa llave");
		label.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				try {
					report5();
				}
				catch (EmptyDataShowException e1) {
					JOptionPane.showMessageDialog(MainFrame.this, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		taskPaneReport.add(label);
	}

	/**
	 * This method initializes centerPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getCenterPanel() {
		if (centerPanel == null) {
			centerPanel = new JPanel();
			centerPanel.setLayout(new BorderLayout());
			centerPanel.add(getTabs(), BorderLayout.CENTER);
			centerPanel.add(getToolBar(), BorderLayout.NORTH);
		}
		return centerPanel;
	}

	/**
	 * This method initializes toolBar	
	 * 	
	 * @return javax.swing.JToolBar	
	 */
	public JToolBar getToolBar() {
		if (toolBar == null) {
			toolBar = new JToolBar();
			toolBar.setEnabled(true);
			toolBar.setVisible(false);
			toolBar.add(getAddButton());
			toolBar.add(getModifyButton());
			toolBar.add(getDeleteButton());
			toolBar.add(getSeparatorT1());
			toolBar.add(getFirstButton());
			toolBar.add(getPrevButton());
			toolBar.add(getNextButton());
			toolBar.add(getLastButton());
			toolBar.add(getSeparatorT2());
			toolBar.add(getHelpButton());
		}
		return toolBar;
	}

	/**
	 * This method initializes addButton	
	 * 	
	 * @return visual.own.ToolButton	
	 */
	private ToolButton getAddButton() {
		if (addButton == null) {
			addButton = new ToolButton(new ImageIcon("src/icons/page_white_add.png"), new ImageIcon("src/icons/page_white_add_disabled.png"), "Añadir");
			addButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int index = tabs.getSelectedIndex();
					
					if(index >= 0){
						TypeInfo type = displayInfo.get(index).getTypeInfo();
						
						try{
							if(type == TypeInfo.SHOW_DOCENT)
								newDocent();
							else if(type == TypeInfo.SHOW_STUDENT)
								newStudent();
							else if(type == TypeInfo.SHOW_TECAD)
								newTecAd();
							else if(type == TypeInfo.SHOW_VISITOR)
								newVisitor();
							else if(type == TypeInfo.SHOW_LOCALS)
								newLocalAndKey();
							else if(type == TypeInfo.SHOW_RULES)
								newRule();
							UpdateTabPanel update = (UpdateTabPanel) displayInfo.get(index).getTab();
							update.update();
							
						}
						catch(DontExistException ex){
							JOptionPane.showMessageDialog(MainFrame.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						}
						catch (DuplicityException ex2) {
							JOptionPane.showMessageDialog(MainFrame.this, ex2.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						}
						catch (EmptyDataShowException ex3) {
							JOptionPane.showMessageDialog(MainFrame.this, ex3.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			});
		}
		return addButton;
	}

	/**
	 * This method initializes modifyButton	
	 * 	
	 * @return visual.own.ToolButton	
	 */
	private ToolButton getModifyButton() {
		if (modifyButton == null) {
			modifyButton = new ToolButton(new ImageIcon("src/icons/page_white_edit.png"), new ImageIcon("src/icons/page_white_edit_disabled.png"), "Modificar");
			modifyButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int index = tabs.getSelectedIndex();
					
					if(index >= 0){
						TypeInfo type = displayInfo.get(index).getTypeInfo();
						
						try{
							if(type == TypeInfo.SHOW_DOCENT){
								Docent docent = (Docent) ((PanelTabDocent)displayInfo.get(index).getTab()).getSelected();
								modifyDocent(docent);
							}
							else if(type == TypeInfo.SHOW_STUDENT){
								StudentAssistant student = (StudentAssistant) ((PanelTabStudent)displayInfo.get(index).getTab()).getSelected();
								modifyStudent(student);
							}
							else if(type == TypeInfo.SHOW_TECAD){
								TecnicAdmin tecad = (TecnicAdmin) ((PanelTabTecAd)displayInfo.get(index).getTab()).getSelected();
								modifyTecAd(tecad);
							}
							else if(type == TypeInfo.SHOW_VISITOR){
								Visitor vis = (Visitor) ((PanelTabVisitor)displayInfo.get(index).getTab()).getSelected();
								modifyVisitor(vis);
							}
							else if(type == TypeInfo.SHOW_LOCALS){
								Local loc = (Local)((PanelTabLocal)displayInfo.get(index).getTab()).getSelected();
								modifyLocal(loc);
							}
							else if((type == TypeInfo.SHOW_RULES)){
								Rule rule = (Rule)((PanelTabRules)displayInfo.get(index).getTab()).getSelected();
								modifyRule(rule);
							}
							UpdateTabPanel update = (UpdateTabPanel) displayInfo.get(index).getTab();
							update.update();
							
						}
						catch(DontExistException ex){
							JOptionPane.showMessageDialog(MainFrame.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						}
						catch (EmptyDataShowException ex3) {
							JOptionPane.showMessageDialog(MainFrame.this, ex3.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			});
		}
		return modifyButton;
	}

	/**
	 * This method initializes deleteButton	
	 * 	
	 * @return visual.own.ToolButton	
	 */
	private ToolButton getDeleteButton() {
		if (deleteButton == null) {
			deleteButton = new ToolButton(new ImageIcon("src/icons/page_white_delete.png"), new ImageIcon("src/icons/page_white_delete_disabled.png"), "Eliminar");
			deleteButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int index = tabs.getSelectedIndex();
					if(index >= 0){
						UpdateTabPanel update = (UpdateTabPanel)displayInfo.get(index).getTab();
						try {
							update.delete();
							update.update();
						}
						catch (DontExistException ex) {
							JOptionPane.showMessageDialog(MainFrame.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						} catch (EmptyDataShowException ex2) {
							JOptionPane.showMessageDialog(MainFrame.this, ex2.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			});
		}
		return deleteButton;
	}

	/**
	 * This method initializes separatorT1	
	 * 	
	 * @return javax.swing.JToolBar.Separator	
	 */
	private JToolBar.Separator getSeparatorT1() {
		if (separatorT1 == null) {
			separatorT1 = new JToolBar.Separator();
		}
		return separatorT1;
	}

	/**
	 * This method initializes firstButton	
	 * 	
	 * @return visual.own.ToolButton	
	 */
	private ToolButton getFirstButton() {
		if (firstButton == null) {
			firstButton = new ToolButton(new ImageIcon("src/icons/resultset_first.png"), new ImageIcon("src/icons/resultset_first_disabled.png"), "Primer elemento");
			firstButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int index = tabs.getSelectedIndex();
					if(index >=0 ){
						DBActionButton action = (DBActionButton) displayInfo.get(index).getTab();
						action.selectFirst();
					}
				}
			});
		}
		return firstButton;
	}

	/**
	 * This method initializes prevButton	
	 * 	
	 * @return visual.own.ToolButton	
	 */
	private ToolButton getPrevButton() {
		if (prevButton == null) {
			prevButton = new ToolButton(new ImageIcon("src/icons/resultset_previous.png"), new ImageIcon("src/icons/resultset_previous_disabled.png"), "Anterior elemento");
			prevButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int index = tabs.getSelectedIndex();
					if(index >=0 ){
						DBActionButton action = (DBActionButton) displayInfo.get(index).getTab();
						action.selectPrev();
					}
				}
			});
		}
		return prevButton;
	}

	/**
	 * This method initializes nextButton	
	 * 	
	 * @return visual.own.ToolButton	
	 */
	private ToolButton getNextButton() {
		if (nextButton == null) {
			nextButton = new ToolButton(new ImageIcon("src/icons/resultset_next.png"), new ImageIcon("src/icons/resultset_next_disabled.png"), "Siguiente elemento");
			nextButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int index = tabs.getSelectedIndex();
					if(index >=0 ){
						DBActionButton action = (DBActionButton) displayInfo.get(index).getTab();
						action.selectNext();
					}
				}
			});
		}
		return nextButton;
	}

	/**
	 * This method initializes lastButton	
	 * 	
	 * @return visual.own.ToolButton	
	 */
	private ToolButton getLastButton() {
		if (lastButton == null) {
			lastButton = new ToolButton(new ImageIcon("src/icons/resultset_last.png"), new ImageIcon("src/icons/resultset_last_disabled.png"), "Último elemento");
			lastButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int index = tabs.getSelectedIndex();
					if(index >=0 ){
						DBActionButton action = (DBActionButton) displayInfo.get(index).getTab();
						action.selectLast();
					}
				}
			});
		}
		return lastButton;
	}

	/**
	 * This method initializes separatorT2	
	 * 	
	 * @return javax.swing.JToolBar.Separator	
	 */
	private JToolBar.Separator getSeparatorT2() {
		if (separatorT2 == null) {
			separatorT2 = new JToolBar.Separator();
		}
		return separatorT2;
	}

	/**
	 * This method initializes helpButton	
	 * 	
	 * @return visual.own.ToolButton	
	 */
	private ToolButton getHelpButton() {
		if (helpButton == null) {
			helpButton = new ToolButton(new ImageIcon("src/icons/help.png"), null, "Contenido de la ayuda");
		}
		return helpButton;
	}

	/**
	 * This method initializes tabs	
	 * 	
	 * @return visual.own.OwnTabbedPane	
	 */
	private OwnTabbedPane getTabs() {
		if (tabs == null) {
			tabs = new OwnTabbedPane(getToolBar());
		}
		return tabs;
	}

	/**
	 * This method initializes TaskPaneContainer	
	 * 	
	 * @return org.jdesktop.swingx.JXTaskPaneContainer	
	 */
	private JXTaskPaneContainer getTaskPaneContainer() {
		if (TaskPaneContainer == null) {
			TaskPaneContainer = new JXTaskPaneContainer();
			TaskPaneContainer.setOpaque(true);
			TaskPaneContainer.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			TaskPaneContainer.add(taskPaneNew, null);
			TaskPaneContainer.add(taskPaneReport, null);
		}
		return TaskPaneContainer;
	}
	
	private void newDocent() throws DontExistException{
		DialogDocent dialog = new DialogDocent(MainFrame.this);
		dialog.setVisible(true);
		ArrayList<Person> list = dialog.getEntryList();
		if(list != null){
			try{
				SaveData.insertDataInCEIS(list);
			}
			catch(DuplicityException ex){
				JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		dialog = null;
		updateAll();
	}
	
	private void modifyDocent(Docent docent) throws DontExistException{
		DialogDocent dialog = new DialogDocent(MainFrame.this, docent);
		dialog.setVisible(true);
	}
	
	private void viewDocent() throws EmptyDataShowException{
		PanelTabDocent contentTable = null;
		contentTable = new PanelTabDocent();
		tabs.addTab("Docentes", "Personal docente del centro", "src/icons/user_green.png", new JScrollPane(contentTable));
		displayInfo.add(new TabInfo(TypeInfo.SHOW_DOCENT, contentTable));
		toolBar.setVisible(true);
	}
	
	private void newTecAd() throws DontExistException, DuplicityException{
		DialogTecAd dialog = new DialogTecAd(MainFrame.this);
		dialog.setVisible(true);
		ArrayList<Person> list = dialog.getEntryList();
		if(list != null)
				SaveData.insertDataInCEIS(list);
		Local local = null;
		String localString = null;
		for(int i = 0; i < list.size(); i++){
			localString = ((TecnicAdmin)list.get(i)).getDepartment();
			local = CEIS.getInstance().findLocal(localString);
			local.addWorker((TecnicAdmin)list.get(i));
		}

		dialog = null;
		updateAll();
	}
	
	private void modifyTecAd(TecnicAdmin tecad) throws DontExistException{
		DialogTecAd dialog = new DialogTecAd(MainFrame.this, tecad);
		dialog.setVisible(true);
	}
	
	private void viewTecAd() throws EmptyDataShowException{
		PanelTabTecAd contentTable = null;
		contentTable = new PanelTabTecAd();
		tabs.addTab("Técnicos/Administrativos", "Personal técnico/administrativo del centro", "src/icons/user_red.png", new JScrollPane(contentTable));
		displayInfo.add(new TabInfo(TypeInfo.SHOW_TECAD, contentTable));
		toolBar.setVisible(true);
	}
	
	private void newStudent() throws DontExistException, DuplicityException{
		DialogStudent dialog = new DialogStudent(MainFrame.this);
		dialog.setVisible(true);
		ArrayList<Person> list = dialog.getEntryList();
		if(list != null)
			SaveData.insertDataInCEIS(list);

		dialog = null;
		updateAll();
	}
	private void modifyStudent(StudentAssistant student) throws DontExistException{
		DialogStudent dialog = new DialogStudent(MainFrame.this, student);
		dialog.setVisible(true);
	}
	
	private void viewStudent() throws EmptyDataShowException{
		PanelTabStudent contentTable = null;
		contentTable = new PanelTabStudent();
		tabs.addTab("Alumnos Ayudantes", "Alumnos ayudantes relacionados con el centro", "src/icons/user_orange.png", new JScrollPane(contentTable));
		displayInfo.add(new TabInfo( TypeInfo.SHOW_STUDENT, contentTable));
		toolBar.setVisible(true);
	}
	
	private void newVisitor() throws DontExistException, DuplicityException{
		DialogVisitor dialog = new DialogVisitor(MainFrame.this);
		dialog.setVisible(true);
		ArrayList<Person> list = dialog.getVisitors();
		if(list != null)
			SaveData.insertDataInCEIS(list);
		dialog = null;
		updateAll();
	}
	private void modifyVisitor(Visitor vis) throws DontExistException{
		DialogVisitor dialog = new DialogVisitor(MainFrame.this, vis);
		dialog.setVisible(true);
	}
	
	private void viewVisitor() throws EmptyDataShowException{
		PanelTabVisitor contentTable = null;
		contentTable = new PanelTabVisitor();
		tabs.addTab("Visitantes", "Visitantes que han visitado en centro", "src/icons/user_suit.png", new JScrollPane(contentTable));
		displayInfo.add(new TabInfo( TypeInfo.SHOW_VISITOR, contentTable));
		toolBar.setVisible(true);
	}

	/**
	 * This method initializes itemMenuNewLocal	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getItemMenuNewLocal() {
		if (itemMenuNewLocal == null) {
			itemMenuNewLocal = new JMenuItem();
			itemMenuNewLocal.setText("Local");
			itemMenuNewLocal.setMnemonic(KeyEvent.VK_N);
			itemMenuNewLocal.setIcon(new ImageIcon(getClass().getResource("/icons/door.png")));
			itemMenuNewLocal.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, Event.CTRL_MASK, false));
			itemMenuNewLocal.setFont(new Font("Calibri", Font.PLAIN, 12));
			itemMenuNewLocal.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					newLocalAndKey();
				}
			});
		}
		return itemMenuNewLocal;
	}

	/**
	 * This method initializes separator10	
	 * 	
	 * @return javax.swing.JPopupMenu.Separator	
	 */
	private JPopupMenu.Separator getSeparator10() {
		if (separator10 == null) {
			separator10 = new JPopupMenu.Separator();
		}
		return separator10;
	}
	
	private void newLocalAndKey(){
		DialogNewLocal dialog = new DialogNewLocal(MainFrame.this, null);
		dialog.setVisible(true);
		ArrayList<RulesEntities> aux = dialog.getRulesEntities();
		if(aux != null)
			for(int i = 0; i < aux.size(); i++)
				CEIS.getInstance().addRuleEntity(aux.get(i));
		updateAll();
	}
	
	private void modifyLocal(Local loc){
		DialogNewLocal dialog = new DialogNewLocal(MainFrame.this, loc);
		dialog.setVisible(true);
	}
	
	private void modifyRule(Rule rule) throws DontExistException{
		if(rule != null){
			DialogNewRule dialog = new DialogNewRule(MainFrame.this, rule);
			dialog.setVisible(true);
		}
	}

	/**
	 * This method initializes itemVisitor	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getItemVisitor() {
		if (itemVisitor == null) {
			itemVisitor = new JMenuItem();
			itemVisitor.setText("Visitante");
			itemVisitor.setFont(new Font("Calibri", Font.PLAIN, 12));
			itemVisitor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK, false));
			itemVisitor.setIcon(new ImageIcon(getClass().getResource("/icons/user_suit.png")));
			itemVisitor.setMnemonic(KeyEvent.VK_V);
			itemVisitor.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try {
						newVisitor();
					}
					catch (DontExistException ex1) {
						JOptionPane.showMessageDialog(null, ex1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
					catch (DuplicityException ex2) {
						JOptionPane.showMessageDialog(null, ex2.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
		}
		return itemVisitor;
	}

	/**
	 * This method initializes separator11	
	 * 	
	 * @return javax.swing.JPopupMenu.Separator	
	 */
	private JPopupMenu.Separator getSeparator11() {
		if (separator11 == null) {
			separator11 = new JPopupMenu.Separator();
		}
		return separator11;
	}
	
	private void newRule() throws DontExistException{
		DialogNewRule dialog = new DialogNewRule(MainFrame.this, null);
		dialog.setVisible(true);
		updateAll();
	}

	/**
	 * This method initializes menuRegistry	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getMenuRegistry() {
		if (menuRegistry == null) {
			menuRegistry = new JMenu();
			menuRegistry.setText("Registros");
			menuRegistry.setFont(new Font("Calibri", Font.PLAIN, 12));
			menuRegistry.setMnemonic(KeyEvent.VK_G);
			menuRegistry.add(getItemRegistryAccess());
			menuRegistry.add(getItemRequestedKey());
		}
		return menuRegistry;
	}

	/**
	 * This method initializes itemAccesses	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getItemAccesses() {
		if (itemAccesses == null) {
			itemAccesses = new JMenuItem();
			itemAccesses.setText("Acceso");
			itemAccesses.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, Event.ALT_MASK | Event.CTRL_MASK, false));
			itemAccesses.setIcon(new ImageIcon(getClass().getResource("/icons/door_in.png")));
			itemAccesses.setFont(new Font("Calibri", Font.PLAIN, 12));
			itemAccesses.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					newAccess(true);
				}
			});
		}
		return itemAccesses;
	}

	/**
	 * This method initializes itemKeyRequest	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getItemKeyRequest() {
		if (itemKeyRequest == null) {
			itemKeyRequest = new JMenuItem();
			itemKeyRequest.setText("Solicitud de llave");
			itemKeyRequest.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, Event.ALT_MASK | Event.CTRL_MASK, false));
			itemKeyRequest.setIcon(new ImageIcon(getClass().getResource("/icons/key_go.png")));
			itemKeyRequest.setFont(new Font("Calibri", Font.PLAIN, 12));
			itemKeyRequest.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					newAccess(false);
				}
			});
		}
		return itemKeyRequest;
	}

	/**
	 * This method initializes menuNew	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getMenuNew() {
		if (menuNew == null) {
			menuNew = new JMenu();
			menuNew.setText("Nuevo");
			menuNew.add(getItemMenuNewLocal());
			menuNew.add(getSeparator10());
			menuNew.add(getItemAccesses());
			menuNew.add(getItemKeyRequest());
		}
		return menuNew;
	}

	/**
	 * This method initializes itemSeeLocals	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getItemSeeLocals() {
		if (itemSeeLocals == null) {
			itemSeeLocals = new JMenuItem();
			itemSeeLocals.setText("Ver locales");
			itemSeeLocals.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, Event.CTRL_MASK, false));
			itemSeeLocals.setMnemonic(KeyEvent.VK_V);
			itemSeeLocals.setFont(new Font("Calibri", Font.PLAIN, 12));
			itemSeeLocals.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					PanelTabLocal contentPane;
					try {
						contentPane = new PanelTabLocal();
						tabs.addTab("Locales", "Locales que se encuentran disponibles en el centro", "src/icons/door.png", new JScrollPane(contentPane));
						displayInfo.add(new TabInfo(TypeInfo.SHOW_LOCALS, contentPane));
						toolBar.setVisible(true);
					}
					catch (DontExistException ex) {
						JOptionPane.showMessageDialog(MainFrame.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
		}
		return itemSeeLocals;
	}
	
	private void lookAtRules(){
		PanelTabRules contentPane = null;
		try {
			contentPane = new PanelTabRules();
			tabs.addTab("Reglas", "Reglas de acceso y solicitudes de llaves asociadas a los locales", "src/icons/scheme.png", new JScrollPane(contentPane));
			displayInfo.add(new TabInfo(TypeInfo.SHOW_RULES, contentPane));
			toolBar.setVisible(true);
		}
		catch (DontExistException ex) {
			JOptionPane.showMessageDialog(MainFrame.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void newAccess(boolean localOrKey){
		DialogAccess dialog;
		try {
			dialog = new DialogAccess(MainFrame.this, localOrKey);
			dialog.setVisible(true);
		}
		catch (DontExistException ex) {
			JOptionPane.showMessageDialog(MainFrame.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		updateAll();
	}

	/**
	 * This method initializes separator40	
	 * 	
	 * @return javax.swing.JPopupMenu.Separator	
	 */
	private JPopupMenu.Separator getSeparator40() {
		if (separator40 == null) {
			separator40 = new JPopupMenu.Separator();
		}
		return separator40;
	}

	/**
	 * This method initializes itemReport1	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getItemReport1() {
		if (itemReport1 == null) {
			itemReport1 = new JMenuItem();
			itemReport1.setText("Buscar accesos de trabajadores");
			itemReport1.setFont(new Font("Calibri", Font.PLAIN, 12));
			itemReport1.setMnemonic(KeyEvent.VK_T);
			itemReport1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					report1();
				}
			});
		}
		return itemReport1;
	}

	private void report1() {
		PanelTabAccessWorker contentPane = new PanelTabAccessWorker();
		tabs.addTab("Acceso de trabajadores", "Listado de los trabajadores que han accedido al centro", "src/icons/report.png", contentPane);
		displayInfo.add(new TabInfo(TypeInfo.SHOW_REPORT_ACCESS_WORKER, contentPane));
		toolBar.setVisible(true);		
	}

	/**
	 * This method initializes itemReport2	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getItemReport2() {
		if (itemReport2 == null) {
			itemReport2 = new JMenuItem();
			itemReport2.setText("Visitas recibidas");
			itemReport2.setMnemonic(KeyEvent.VK_R);
			itemReport2.setFont(new Font("Calibri", Font.PLAIN, 12));
			itemReport2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					report2();
				}
			});
		}
		return itemReport2;
	}

	private void report2() {
		PanelTabVisit contentPane = new PanelTabVisit();
		tabs.addTab("Visitas", "Listado de los visitantes que han accedido al centro", "src/icons/group.png", contentPane);
		displayInfo.add(new TabInfo(TypeInfo.SHOW_REPORT_VISIT, contentPane));
		toolBar.setVisible(true);		
	}

	/**
	 * This method initializes itemReport3_4	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getItemReport3_4() {
		if (itemReport3_4 == null) {
			itemReport3_4 = new JMenuItem();
			itemReport3_4.setText("Solicitudes/Entregas de llaves");
			itemReport3_4.setFont(new Font("Calibri", Font.PLAIN, 12));
			itemReport3_4.setMnemonic(KeyEvent.VK_L);
			itemReport3_4.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					report3();
				}
			});
		}
		return itemReport3_4;
	}

	private void report3() {
		PanelTabRequested contentPane = new PanelTabRequested();
		tabs.addTab("LLaves", "Listado de las solicitudes/entregas de llaves", "src/icons/key.png", contentPane);
		displayInfo.add(new TabInfo(TypeInfo.SHOW_REPORT_REQUEST_DELIVERY_KEY, contentPane));
		toolBar.setVisible(true);		
	}

	/**
	 * This method initializes itemFindKey	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getItemFindKey() {
		if (itemFindKey == null) {
			itemFindKey = new JMenuItem();
			itemFindKey.setText("Buscar llave");
			itemFindKey.setMnemonic(KeyEvent.VK_A);
			itemFindKey.setFont(new Font("Calibri", Font.PLAIN, 12));
			itemFindKey.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try {
						report4();
					}
					catch (EmptyDataShowException e1) {
						JOptionPane.showMessageDialog(MainFrame.this, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
					
				}
			});
		}
		return itemFindKey;
	}

	private void report4() throws EmptyDataShowException {
		PanelTabFindKey contentPane = new PanelTabFindKey();
		tabs.addTab("Buscar llaves", "Indicador de la localizacion de las llaves de los locales", "src/icons/search.png", contentPane);
		displayInfo.add(new TabInfo(TypeInfo.SHOW_REPORT_FIND_KEY, contentPane));
		toolBar.setVisible(true);		
	}

	/**
	 * This method initializes itemReport5	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getItemReport5() {
		if (itemReport5 == null) {
			itemReport5 = new JMenuItem();
			itemReport5.setText("Docente con más extracciones de llaves");
			itemReport5.setMnemonic(KeyEvent.VK_C);
			itemReport5.setFont(new Font("Calibri", Font.PLAIN, 12));
			itemReport5.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try {
						report5();
					}
					catch (EmptyDataShowException e1) {
						JOptionPane.showMessageDialog(MainFrame.this, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
		}
		return itemReport5;
	}
	
	private void report5() throws EmptyDataShowException {
		PanelTabMoreRequestDocent contentPane = new PanelTabMoreRequestDocent();
		tabs.addTab("Docente con más solicitudes", "Localiza al docente que ha extraido la mayor cantidad de veces una determinada llave", "src/icons/report_key.png", contentPane);
		displayInfo.add(new TabInfo(TypeInfo.SHOW_REPORT_MORE_EXTRACTION, contentPane));
		toolBar.setVisible(true);		
	}

	private void updateAll(){
		if(tabs.getTabCount() > 0){
			for(int i = 0; i < tabs.getTabCount(); i++){
				try {
					((UpdateTabPanel)displayInfo.get(i).getTab()).update();
				} catch (EmptyDataShowException e) {};
			}
		}
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
