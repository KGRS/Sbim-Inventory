/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MainFiles;

import Settings.AdministratorSettings;
import Tools.PurchaseSellingPriceEdit;
import Transactions.GRN;
import Transactions.IssueForMaterialRequisitionItemCodeWise;
import Transactions.IssueWithoutMaterialRequisitionItemCodeWise;
import Transactions.ItemDisposal;
import Transactions.ItemTransferBranchWise;
import Transactions.PurchaseOrder;
import Transactions.PurchaseRequisitionNote;
import Transactions.ReturnToSupplier;
import Transactions.StockEdit;
import com.jtattoo.plaf.smart.SmartLookAndFeel;
import com.jtattoo.plaf.texture.TextureLookAndFeel;
import db.ConnectSql;
import de.javasoft.plaf.synthetica.SyntheticaBlueMoonLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaClassyLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaOrangeMetallicLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaWhiteVisionLookAndFeel;
import functions.Informations;
import functions.ReadConfig;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import reports.BinCard;
import reports.StockReports;
import reports.TransactionReportsIssue;
import reports.TransactionReportsPurchase;
import reports.TransactionsComparison;

/**
 *
 * @author Ravindu
 */
public class IndexPage extends javax.swing.JFrame {

    private final String projectPath = System.getProperty("user.dir");
    public static String user = "";
    public static String employeeCode = "";
    public static String departmentCode = "";
    public static String subDepartmentCode = "";
    public static String departmentName = "";
    public static String subDepartmentName = "";
    public static String time = "";
    public static URL url = null;
    public static Date SYSTEM_DATE;
    private final String spliter = "--";

    public static BaseCategory BC = null;
    public static MainCategory MainCat = null;
    public static SubCategory SubCat = null;
    public static Item item = null;
    public static Supplier sup = null;
    public static Customer cus = null;
    public static UserUnites userUnites = null;

    public static PurchaseRequisitionNote purchaseRequisitionNote = null;
    public static PurchaseOrder po = null;
    public static GRN grn = null;
    public static ReturnToSupplier RetToSup = null;
    public static IssueForMaterialRequisitionItemCodeWise issueForMaterialRequisitionItemCodeWise = null;
    public static ItemDisposal ItemD = null;
    public static ItemTransferBranchWise IT = null;
    public static StockEdit stockedit = null;
    public static IssueWithoutMaterialRequisitionItemCodeWise issueWithoutMaterialRequisitionItemCodeWise = null;

    public static StockReports StRe = null;
    public static TransactionReportsPurchase TraRe = null;
    public static TransactionReportsIssue TraReIssue = null;
    public static BinCard Bin = null;
    public static TransactionsComparison transactionsComparison = null;
    public static PurchaseSellingPriceEdit PriceEdit = null;
    public static AdministratorSettings AdminSettings = null;

    public IndexPage() {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (InstantiationException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (IllegalAccessException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (UnsupportedLookAndFeelException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        url = getClass().getResource("/images/image.jpg");
        initComponents();
        java.util.Timer t = new java.util.Timer();
        t.schedule(new Informations(), 0, 1000);
        LoadHeading();
        LoadSystemDate();
        LoadCompanyDetails();
        // Setting extendign state maximum..        
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(projectPath + "/pictures/frameIcon/titleIcon.png"));

        LabelBackGroundPicture.setSize(screenSize);
        pnl_LeftPanel.revalidate();
        pnl_LeftPanel.repaint();

        String LogedUser = IndexPage.user;
        LabelUser.setText(LogedUser + spliter + employeeCode);
        
        String LogedUserDepartmentCode = IndexPage.departmentCode;
        String LogedUserDepartmentName = IndexPage.departmentName;
        labelDepartmentCode.setText(LogedUserDepartmentName + spliter + LogedUserDepartmentCode);
        
        String LogedUserSubDepartmentCode = IndexPage.subDepartmentCode;
        String LogedUserSubDepartmentName = IndexPage.subDepartmentName;
        labelSubDepartmentCode.setText(LogedUserSubDepartmentName + spliter + LogedUserSubDepartmentCode);

        Informations.setTimeAnd_date();

        ImageIcon imgThisImg = new ImageIcon(projectPath + "/pictures/Logo/ClientLogo.jpg");
        LabelClientLogo.setIcon(imgThisImg);
        ImageIcon DefaultBackGround = new ImageIcon(projectPath + "/pictures/DefaultBackgrounds/Basic/Inventory.jpg");
//        ImageIcon DefaultBackGround = new ImageIcon(projectPath + "/pictures/DefaultBackgrounds/loginBackground.jpg");
        LabelBackGroundPicture.setIcon(DefaultBackGround);
        dskPane_RightPanel.setBackground(new Color(255, 255, 255));
//        LabelClientLogo.setBackground(new Color(0, 0, 0));
        enableV();
        LabelUser.requestFocus();

//        String branch = ReadConfig.branch.trim();
//        LabelBranch.setText(branch);
//
//        String department = ReadConfig.department.trim();
//        labelDepartment.setText(department);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        pnl_BasePanel = new javax.swing.JPanel();
        spliPne_View = new javax.swing.JSplitPane();
        pnl_LeftPanel = new javax.swing.JPanel();
        LabelDate = new javax.swing.JLabel();
        LabelTime = new javax.swing.JLabel();
        LabelUser = new javax.swing.JLabel();
        LabelDate2 = new javax.swing.JLabel();
        PanelCompanyLogo = new javax.swing.JPanel();
        LabelClientLogo = new javax.swing.JLabel();
        TextCompanyName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        ButtonClickHere = new javax.swing.JButton();
        LabelDate3 = new javax.swing.JLabel();
        labelDepartmentCode = new javax.swing.JLabel();
        labelSubDepartmentCode = new javax.swing.JLabel();
        dskPane_RightPanel = new javax.swing.JDesktopPane();
        LabelBackGroundPicture = new javax.swing.JLabel();
        mnBar_menuBar = new javax.swing.JMenuBar();
        TabMenuMainFiles = new javax.swing.JMenu();
        MenuBaseCategory = new javax.swing.JMenuItem();
        MenuMainCategory = new javax.swing.JMenuItem();
        MenuSubCategory = new javax.swing.JMenuItem();
        MenuItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        MenuSupplier = new javax.swing.JMenuItem();
        MenuCustomer = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        MenuUserUnit = new javax.swing.JMenuItem();
        TabMenuTransactions = new javax.swing.JMenu();
        MenuPurchaseRequiesitionNote = new javax.swing.JMenuItem();
        menuPurchaseRequiesitionApprove = new javax.swing.JMenuItem();
        MenuPurchaseOrders = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        arrowMenuGRN = new javax.swing.JMenu();
        MenuGRNItemCodeWise = new javax.swing.JMenuItem();
        MenuGRNSerialCodeWise = new javax.swing.JMenuItem();
        arrowMenuReturnToSupplier = new javax.swing.JMenu();
        MenuReturnToSupplier = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        arrowMenuIssue = new javax.swing.JMenu();
        menuIssueForMaterialRequisition = new javax.swing.JMenuItem();
        menuIssueWithOutMaterialRequisition = new javax.swing.JMenuItem();
        jSeparator15 = new javax.swing.JPopupMenu.Separator();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator11 = new javax.swing.JPopupMenu.Separator();
        MenuDisposal = new javax.swing.JMenuItem();
        arrowMenuTransfer = new javax.swing.JMenu();
        MenuTransferBranch = new javax.swing.JMenuItem();
        menuItemUsageOfDepartment = new javax.swing.JMenuItem();
        jSeparator12 = new javax.swing.JPopupMenu.Separator();
        jMenu4 = new javax.swing.JMenu();
        MenuStockEdit = new javax.swing.JMenuItem();
        MenuStockEditDepartments = new javax.swing.JMenuItem();
        TabMenuReports = new javax.swing.JMenu();
        MenuStockReports = new javax.swing.JMenuItem();
        MenuDataReports = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        MenuPurchaseReport = new javax.swing.JMenuItem();
        MenuIssueReport = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        MenuItemBinCard = new javax.swing.JMenuItem();
        menuTransactionsComparison = new javax.swing.JMenuItem();
        jSeparator10 = new javax.swing.JPopupMenu.Separator();
        MenuLogReports = new javax.swing.JMenuItem();
        TabMenuTools = new javax.swing.JMenu();
        MenuPurSellPriceEdit = new javax.swing.JMenuItem();
        menuItemRemovePendingTransactions = new javax.swing.JMenuItem();
        jSeparator13 = new javax.swing.JPopupMenu.Separator();
        MenuNotifications = new javax.swing.JMenuItem();
        jSeparator14 = new javax.swing.JPopupMenu.Separator();
        MenuPersonalization = new javax.swing.JMenu();
        MenuItemDefault = new javax.swing.JMenuItem();
        MenuItemBlank = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        SubMenuWin = new javax.swing.JMenuItem();
        SubMenuLinux = new javax.swing.JMenuItem();
        SubMenuMetal = new javax.swing.JMenuItem();
        SubMenuRome = new javax.swing.JMenuItem();
        SubMenuCreamy = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        MenuNatureTouch = new javax.swing.JMenu();
        SubMenuBlackStone = new javax.swing.JMenuItem();
        SubMenuSunSet = new javax.swing.JMenuItem();
        SubMenuGreenPlanet = new javax.swing.JMenuItem();
        SubMenuSnowWhite = new javax.swing.JMenuItem();
        SubMenuWood = new javax.swing.JMenuItem();
        SubMenuBlueOcean = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        SubMenuSpiderMan = new javax.swing.JMenuItem();
        SubMenuDarkKnight = new javax.swing.JMenuItem();
        SubMenuManOfSteel = new javax.swing.JMenuItem();
        SubMenuGreenLantern = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        SubMenuSherlockHolmes = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        SubMenuAssassinsCreed = new javax.swing.JMenuItem();
        SubMenuCrysis3 = new javax.swing.JMenuItem();
        TabMenuSettings = new javax.swing.JMenu();
        MenuAdminSettings = new javax.swing.JMenuItem();
        MenuConnectionSettings = new javax.swing.JMenuItem();
        TabMenuHelp = new javax.swing.JMenu();
        MenuOnlineTutes = new javax.swing.JMenuItem();
        MenuUserManual = new javax.swing.JMenuItem();
        MenuAbout = new javax.swing.JMenuItem();

        jMenuItem6.setText("jMenuItem6");

        jMenu5.setText("jMenu5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnl_BasePanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 2, true));

        spliPne_View.setDividerLocation(150);

        pnl_LeftPanel.setBackground(new java.awt.Color(255, 255, 255));
        pnl_LeftPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 2, true));
        pnl_LeftPanel.setEnabled(false);
        pnl_LeftPanel.setPreferredSize(new java.awt.Dimension(200, 366));

        LabelDate.setForeground(new java.awt.Color(102, 102, 102));
        LabelDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelDate.setText("Date");
        LabelDate.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true));
        LabelDate.setMaximumSize(new java.awt.Dimension(34, 25));

        LabelTime.setForeground(new java.awt.Color(102, 102, 102));
        LabelTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTime.setText("Time");
        LabelTime.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true));
        LabelTime.setMaximumSize(new java.awt.Dimension(34, 25));
        LabelTime.setMinimumSize(new java.awt.Dimension(25, 16));

        LabelUser.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        LabelUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelUser.setText("User");
        LabelUser.setMaximumSize(new java.awt.Dimension(34, 25));

        LabelDate2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        LabelDate2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelDate2.setText("Welcome");
        LabelDate2.setMaximumSize(new java.awt.Dimension(34, 25));

        PanelCompanyLogo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true));

        javax.swing.GroupLayout PanelCompanyLogoLayout = new javax.swing.GroupLayout(PanelCompanyLogo);
        PanelCompanyLogo.setLayout(PanelCompanyLogoLayout);
        PanelCompanyLogoLayout.setHorizontalGroup(
            PanelCompanyLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LabelClientLogo, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
        );
        PanelCompanyLogoLayout.setVerticalGroup(
            PanelCompanyLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LabelClientLogo, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        TextCompanyName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TextCompanyName.setText("Company name");
        TextCompanyName.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TextCompanyName.setEnabled(false);

        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(" Hi... need any help?");

        ButtonClickHere.setText("Click here");
        ButtonClickHere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonClickHereActionPerformed(evt);
            }
        });

        LabelDate3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        LabelDate3.setForeground(new java.awt.Color(102, 102, 102));
        LabelDate3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelDate3.setText("You are at");
        LabelDate3.setMaximumSize(new java.awt.Dimension(34, 25));

        labelDepartmentCode.setForeground(new java.awt.Color(102, 102, 102));
        labelDepartmentCode.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelDepartmentCode.setText("Department");
        labelDepartmentCode.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true));
        labelDepartmentCode.setMaximumSize(new java.awt.Dimension(34, 25));

        labelSubDepartmentCode.setForeground(new java.awt.Color(102, 102, 102));
        labelSubDepartmentCode.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSubDepartmentCode.setText("Sub department");
        labelSubDepartmentCode.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true));
        labelSubDepartmentCode.setMaximumSize(new java.awt.Dimension(34, 25));

        javax.swing.GroupLayout pnl_LeftPanelLayout = new javax.swing.GroupLayout(pnl_LeftPanel);
        pnl_LeftPanel.setLayout(pnl_LeftPanelLayout);
        pnl_LeftPanelLayout.setHorizontalGroup(
            pnl_LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_LeftPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelUser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LabelDate2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LabelDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LabelTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelCompanyLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextCompanyName)
                    .addComponent(ButtonClickHere, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LabelDate3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelDepartmentCode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelSubDepartmentCode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnl_LeftPanelLayout.setVerticalGroup(
            pnl_LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_LeftPanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ButtonClickHere)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 185, Short.MAX_VALUE)
                .addComponent(LabelDate2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LabelUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(LabelDate3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelDepartmentCode, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelSubDepartmentCode, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(LabelDate, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LabelTime, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(PanelCompanyLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextCompanyName, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        spliPne_View.setLeftComponent(pnl_LeftPanel);

        dskPane_RightPanel.setBackground(new java.awt.Color(204, 204, 204));
        dskPane_RightPanel.setForeground(new java.awt.Color(204, 204, 204));

        LabelBackGroundPicture.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LabelBackGroundPicture.setLabelFor(LabelBackGroundPicture);
        LabelBackGroundPicture.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        dskPane_RightPanel.add(LabelBackGroundPicture);
        LabelBackGroundPicture.setBounds(0, 0, 940, 660);

        spliPne_View.setRightComponent(dskPane_RightPanel);

        javax.swing.GroupLayout pnl_BasePanelLayout = new javax.swing.GroupLayout(pnl_BasePanel);
        pnl_BasePanel.setLayout(pnl_BasePanelLayout);
        pnl_BasePanelLayout.setHorizontalGroup(
            pnl_BasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spliPne_View, javax.swing.GroupLayout.DEFAULT_SIZE, 1093, Short.MAX_VALUE)
        );
        pnl_BasePanelLayout.setVerticalGroup(
            pnl_BasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spliPne_View, javax.swing.GroupLayout.DEFAULT_SIZE, 663, Short.MAX_VALUE)
        );

        TabMenuMainFiles.setMnemonic('f');
        TabMenuMainFiles.setText("Data Files");
        TabMenuMainFiles.setPreferredSize(new java.awt.Dimension(80, 19));
        TabMenuMainFiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TabMenuMainFilesActionPerformed(evt);
            }
        });

        MenuBaseCategory.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        MenuBaseCategory.setText("Base Category");
        MenuBaseCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuBaseCategoryActionPerformed(evt);
            }
        });
        TabMenuMainFiles.add(MenuBaseCategory);

        MenuMainCategory.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        MenuMainCategory.setText("Main Category");
        MenuMainCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuMainCategoryActionPerformed(evt);
            }
        });
        TabMenuMainFiles.add(MenuMainCategory);

        MenuSubCategory.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        MenuSubCategory.setText("Sub Category");
        MenuSubCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuSubCategoryActionPerformed(evt);
            }
        });
        TabMenuMainFiles.add(MenuSubCategory);

        MenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        MenuItem.setText("Item");
        MenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemActionPerformed(evt);
            }
        });
        TabMenuMainFiles.add(MenuItem);
        TabMenuMainFiles.add(jSeparator1);

        MenuSupplier.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        MenuSupplier.setText("Supplier");
        MenuSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuSupplierActionPerformed(evt);
            }
        });
        TabMenuMainFiles.add(MenuSupplier);

        MenuCustomer.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        MenuCustomer.setText("Customer");
        MenuCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuCustomerActionPerformed(evt);
            }
        });
        TabMenuMainFiles.add(MenuCustomer);
        TabMenuMainFiles.add(jSeparator6);

        MenuUserUnit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        MenuUserUnit.setText("User Unit");
        MenuUserUnit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuUserUnitActionPerformed(evt);
            }
        });
        TabMenuMainFiles.add(MenuUserUnit);

        mnBar_menuBar.add(TabMenuMainFiles);

        TabMenuTransactions.setMnemonic('t');
        TabMenuTransactions.setText("Transaction");
        TabMenuTransactions.setMaximumSize(new java.awt.Dimension(100, 32767));
        TabMenuTransactions.setPreferredSize(new java.awt.Dimension(80, 19));

        MenuPurchaseRequiesitionNote.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.ALT_MASK));
        MenuPurchaseRequiesitionNote.setText("Purchase Requisition Note");
        MenuPurchaseRequiesitionNote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuPurchaseRequiesitionNoteActionPerformed(evt);
            }
        });
        TabMenuTransactions.add(MenuPurchaseRequiesitionNote);

        menuPurchaseRequiesitionApprove.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK));
        menuPurchaseRequiesitionApprove.setText("Purchase Requisition Approve");
        menuPurchaseRequiesitionApprove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPurchaseRequiesitionApproveActionPerformed(evt);
            }
        });
        TabMenuTransactions.add(menuPurchaseRequiesitionApprove);

        MenuPurchaseOrders.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.ALT_MASK));
        MenuPurchaseOrders.setText("Purchase Orders");
        MenuPurchaseOrders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuPurchaseOrdersActionPerformed(evt);
            }
        });
        TabMenuTransactions.add(MenuPurchaseOrders);
        TabMenuTransactions.add(jSeparator4);

        arrowMenuGRN.setText("GRN");

        MenuGRNItemCodeWise.setText("GRN (Item code wise)");
        MenuGRNItemCodeWise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuGRNItemCodeWiseActionPerformed(evt);
            }
        });
        arrowMenuGRN.add(MenuGRNItemCodeWise);

        MenuGRNSerialCodeWise.setText("GRN (Serial code wise)");
        arrowMenuGRN.add(MenuGRNSerialCodeWise);

        TabMenuTransactions.add(arrowMenuGRN);

        arrowMenuReturnToSupplier.setText("Return to Supplier");

        MenuReturnToSupplier.setText("Return to Supplier (Item code wise)");
        MenuReturnToSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuReturnToSupplierActionPerformed(evt);
            }
        });
        arrowMenuReturnToSupplier.add(MenuReturnToSupplier);

        jMenuItem4.setText("Return to Supplier (Serial code wise)");
        arrowMenuReturnToSupplier.add(jMenuItem4);

        TabMenuTransactions.add(arrowMenuReturnToSupplier);
        TabMenuTransactions.add(jSeparator5);

        arrowMenuIssue.setText("Issue to Departments");

        menuIssueForMaterialRequisition.setText("Issue for Material Requisition (Item code wise)");
        menuIssueForMaterialRequisition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuIssueForMaterialRequisitionActionPerformed(evt);
            }
        });
        arrowMenuIssue.add(menuIssueForMaterialRequisition);

        menuIssueWithOutMaterialRequisition.setText("Issue without Material Requisition (Item code wise)");
        menuIssueWithOutMaterialRequisition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuIssueWithOutMaterialRequisitionActionPerformed(evt);
            }
        });
        arrowMenuIssue.add(menuIssueWithOutMaterialRequisition);
        arrowMenuIssue.add(jSeparator15);

        jMenuItem2.setText("Issue for Material Requisition (Serial code wise)");
        arrowMenuIssue.add(jMenuItem2);

        jMenuItem3.setText("Issue without Material Requisition (Serial code wise)");
        arrowMenuIssue.add(jMenuItem3);

        TabMenuTransactions.add(arrowMenuIssue);
        TabMenuTransactions.add(jSeparator11);

        MenuDisposal.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.ALT_MASK));
        MenuDisposal.setText("Item Disposal");
        MenuDisposal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuDisposalActionPerformed(evt);
            }
        });
        TabMenuTransactions.add(MenuDisposal);

        arrowMenuTransfer.setText("Item Transfer");

        MenuTransferBranch.setText("Item Transfer (Branch wise)");
        MenuTransferBranch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuTransferBranchActionPerformed(evt);
            }
        });
        arrowMenuTransfer.add(MenuTransferBranch);

        TabMenuTransactions.add(arrowMenuTransfer);

        menuItemUsageOfDepartment.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.ALT_MASK));
        menuItemUsageOfDepartment.setText("Usage of Departments");
        menuItemUsageOfDepartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemUsageOfDepartmentActionPerformed(evt);
            }
        });
        TabMenuTransactions.add(menuItemUsageOfDepartment);
        TabMenuTransactions.add(jSeparator12);

        jMenu4.setText("Stock Edit");

        MenuStockEdit.setText("Stock Edit (Main Stores)");
        MenuStockEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuStockEditActionPerformed(evt);
            }
        });
        jMenu4.add(MenuStockEdit);

        MenuStockEditDepartments.setText("Stock Edit (Departments)");
        MenuStockEditDepartments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuStockEditDepartmentsActionPerformed(evt);
            }
        });
        jMenu4.add(MenuStockEditDepartments);

        TabMenuTransactions.add(jMenu4);

        mnBar_menuBar.add(TabMenuTransactions);

        TabMenuReports.setText("Reports");
        TabMenuReports.setPreferredSize(new java.awt.Dimension(80, 19));

        MenuStockReports.setText("Stock Reports");
        MenuStockReports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuStockReportsActionPerformed(evt);
            }
        });
        TabMenuReports.add(MenuStockReports);

        MenuDataReports.setText("Data Reports");
        MenuDataReports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuDataReportsActionPerformed(evt);
            }
        });
        TabMenuReports.add(MenuDataReports);

        jMenu3.setText("Transaction Reports");

        MenuPurchaseReport.setText("Purchase");
        MenuPurchaseReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuPurchaseReportActionPerformed(evt);
            }
        });
        jMenu3.add(MenuPurchaseReport);

        MenuIssueReport.setText("Issue");
        MenuIssueReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuIssueReportActionPerformed(evt);
            }
        });
        jMenu3.add(MenuIssueReport);

        TabMenuReports.add(jMenu3);
        TabMenuReports.add(jSeparator2);

        MenuItemBinCard.setText("Bin Card (item wise)");
        MenuItemBinCard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemBinCardActionPerformed(evt);
            }
        });
        TabMenuReports.add(MenuItemBinCard);

        menuTransactionsComparison.setText("Transactions Comparison");
        menuTransactionsComparison.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuTransactionsComparisonActionPerformed(evt);
            }
        });
        TabMenuReports.add(menuTransactionsComparison);
        TabMenuReports.add(jSeparator10);

        MenuLogReports.setText("Log Reports");
        MenuLogReports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuLogReportsActionPerformed(evt);
            }
        });
        TabMenuReports.add(MenuLogReports);

        mnBar_menuBar.add(TabMenuReports);

        TabMenuTools.setText("Tools");
        TabMenuTools.setMaximumSize(new java.awt.Dimension(70, 32767));
        TabMenuTools.setPreferredSize(new java.awt.Dimension(80, 19));

        MenuPurSellPriceEdit.setText("Purchase/Selling Price Edit ");
        MenuPurSellPriceEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuPurSellPriceEditActionPerformed(evt);
            }
        });
        TabMenuTools.add(MenuPurSellPriceEdit);

        menuItemRemovePendingTransactions.setText("Remove Pending Transactions");
        TabMenuTools.add(menuItemRemovePendingTransactions);
        TabMenuTools.add(jSeparator13);

        MenuNotifications.setText("Notifications");
        MenuNotifications.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuNotificationsActionPerformed(evt);
            }
        });
        TabMenuTools.add(MenuNotifications);
        TabMenuTools.add(jSeparator14);

        MenuPersonalization.setText("Personalization");

        MenuItemDefault.setText("Default");
        MenuItemDefault.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemDefaultActionPerformed(evt);
            }
        });
        MenuPersonalization.add(MenuItemDefault);

        MenuItemBlank.setText("Blank");
        MenuItemBlank.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemBlankActionPerformed(evt);
            }
        });
        MenuPersonalization.add(MenuItemBlank);
        MenuPersonalization.add(jSeparator9);

        SubMenuWin.setText("Windows Look");
        SubMenuWin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubMenuWinActionPerformed(evt);
            }
        });
        MenuPersonalization.add(SubMenuWin);

        SubMenuLinux.setText("Linux Look");
        SubMenuLinux.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubMenuLinuxActionPerformed(evt);
            }
        });
        MenuPersonalization.add(SubMenuLinux);

        SubMenuMetal.setText("Metal");
        SubMenuMetal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubMenuMetalActionPerformed(evt);
            }
        });
        MenuPersonalization.add(SubMenuMetal);

        SubMenuRome.setText("Rome");
        SubMenuRome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubMenuRomeActionPerformed(evt);
            }
        });
        MenuPersonalization.add(SubMenuRome);

        SubMenuCreamy.setText("Creamy");
        SubMenuCreamy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubMenuCreamyActionPerformed(evt);
            }
        });
        MenuPersonalization.add(SubMenuCreamy);
        MenuPersonalization.add(jSeparator3);

        MenuNatureTouch.setText("Nature Touch");

        SubMenuBlackStone.setText("Black Stone");
        SubMenuBlackStone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubMenuBlackStoneActionPerformed(evt);
            }
        });
        MenuNatureTouch.add(SubMenuBlackStone);

        SubMenuSunSet.setText("Sun Set");
        SubMenuSunSet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubMenuSunSetActionPerformed(evt);
            }
        });
        MenuNatureTouch.add(SubMenuSunSet);

        SubMenuGreenPlanet.setText("Green Planet");
        SubMenuGreenPlanet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubMenuGreenPlanetActionPerformed(evt);
            }
        });
        MenuNatureTouch.add(SubMenuGreenPlanet);

        SubMenuSnowWhite.setText("Snow White");
        SubMenuSnowWhite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubMenuSnowWhiteActionPerformed(evt);
            }
        });
        MenuNatureTouch.add(SubMenuSnowWhite);

        SubMenuWood.setText("Wood");
        SubMenuWood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubMenuWoodActionPerformed(evt);
            }
        });
        MenuNatureTouch.add(SubMenuWood);

        SubMenuBlueOcean.setText("Blue Ocean");
        SubMenuBlueOcean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubMenuBlueOceanActionPerformed(evt);
            }
        });
        MenuNatureTouch.add(SubMenuBlueOcean);

        MenuPersonalization.add(MenuNatureTouch);

        jMenu1.setText("Movie Touch");

        SubMenuSpiderMan.setText("Spider Man");
        SubMenuSpiderMan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubMenuSpiderManActionPerformed(evt);
            }
        });
        jMenu1.add(SubMenuSpiderMan);

        SubMenuDarkKnight.setText("Dark Knight");
        SubMenuDarkKnight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubMenuDarkKnightActionPerformed(evt);
            }
        });
        jMenu1.add(SubMenuDarkKnight);

        SubMenuManOfSteel.setText("Man Of Steel");
        SubMenuManOfSteel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubMenuManOfSteelActionPerformed(evt);
            }
        });
        jMenu1.add(SubMenuManOfSteel);

        SubMenuGreenLantern.setText("Green Lantern");
        SubMenuGreenLantern.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubMenuGreenLanternActionPerformed(evt);
            }
        });
        jMenu1.add(SubMenuGreenLantern);
        jMenu1.add(jSeparator7);

        SubMenuSherlockHolmes.setText("Sherlock Holmes");
        SubMenuSherlockHolmes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubMenuSherlockHolmesActionPerformed(evt);
            }
        });
        jMenu1.add(SubMenuSherlockHolmes);

        MenuPersonalization.add(jMenu1);

        jMenu2.setText("Game Touch");

        SubMenuAssassinsCreed.setText("Assassin's Creed");
        SubMenuAssassinsCreed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubMenuAssassinsCreedActionPerformed(evt);
            }
        });
        jMenu2.add(SubMenuAssassinsCreed);

        SubMenuCrysis3.setText("Crysis 3");
        SubMenuCrysis3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubMenuCrysis3ActionPerformed(evt);
            }
        });
        jMenu2.add(SubMenuCrysis3);

        MenuPersonalization.add(jMenu2);

        TabMenuTools.add(MenuPersonalization);

        mnBar_menuBar.add(TabMenuTools);

        TabMenuSettings.setText("Settings");
        TabMenuSettings.setMaximumSize(new java.awt.Dimension(80, 32767));

        MenuAdminSettings.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        MenuAdminSettings.setText("Administrator Settings");
        MenuAdminSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuAdminSettingsActionPerformed(evt);
            }
        });
        TabMenuSettings.add(MenuAdminSettings);

        MenuConnectionSettings.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        MenuConnectionSettings.setText("Connection Settings");
        MenuConnectionSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuConnectionSettingsActionPerformed(evt);
            }
        });
        TabMenuSettings.add(MenuConnectionSettings);

        mnBar_menuBar.add(TabMenuSettings);

        TabMenuHelp.setText("Help");
        TabMenuHelp.setMaximumSize(new java.awt.Dimension(70, 32767));

        MenuOnlineTutes.setText("Tutorials");
        TabMenuHelp.add(MenuOnlineTutes);

        MenuUserManual.setText("User Manual");
        TabMenuHelp.add(MenuUserManual);

        MenuAbout.setText("About");
        TabMenuHelp.add(MenuAbout);

        mnBar_menuBar.add(TabMenuHelp);

        setJMenuBar(mnBar_menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1097, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnl_BasePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 667, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnl_BasePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LoadHeading() {
        try {
            Statement stmt;
            stmt = ConnectSql.conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rset = stmt.executeQuery("SELECT MODULE_NAME, VERSION, BUSINESS_NAME FROM Modules where MODULE_CODE = '2'");
            if (rset.next()) {
                String MODULE_NAME = rset.getString("MODULE_NAME");
                String VERSION = rset.getString("VERSION");
                String BUSINESS_NAME = rset.getString("BUSINESS_NAME");

                String heading = MODULE_NAME + " " + VERSION + " - " + BUSINESS_NAME;
                this.setTitle(heading);
            }
            rset.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(this, "Please contact for support.");
        }
    }

    private void LoadSystemDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String DATE = ReadConfig.Date;

        if (DATE.equals("MANUAL")) {
            try {
                Statement stmt;
                stmt = ConnectSql.conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rset = stmt.executeQuery("SELECT sysDate FROM SystemDate");
                if (rset.next()) {
                    LabelDate.setText(sdf.format(rset.getDate("sysDate")));
                }
                rset.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                JOptionPane.showMessageDialog(this, "Please contact for support.");
            }
        } else if (DATE.equals("SQL")) {
            try {
                Statement stmt = ConnectSql.conn.createStatement();
                ResultSet rset = stmt.executeQuery("Select getdate() as date");
                if (rset.next()) {
                    String SQLdate = rset.getString("date");
                    String SplSqlDate[] = SQLdate.split(" ");
                    LabelDate.setText(SplSqlDate[0]);

                    String Query = "update SystemDate set sysDate =  '" + LabelDate.getText() + "'";
                    stmt.execute(Query);

                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                JOptionPane.showMessageDialog(this, "Please contact for support.");
            }
        }
    }

    private void LoadCompanyDetails() {
        try {
            Statement stmt;
            stmt = ConnectSql.conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rset = stmt.executeQuery("SELECT Companyname FROM ClientCompany");
            if (rset.next()) {
                TextCompanyName.setText(rset.getString("Companyname"));
            }
            rset.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(this, "Please contact for support.");
        }
    }

private void MenuMainCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuMainCategoryActionPerformed
    if (MainCat != null) {
        if (!MainCat.isVisible()) {
            MainCat.setVisible(true);
        }
    } else {
        MainCat = new MainCategory();
        dskPane_RightPanel.add(MainCat);
        MainCat.setVisible(true);
    }

}//GEN-LAST:event_MenuMainCategoryActionPerformed

private void enableV(){
    MenuPurchaseRequiesitionNote.setVisible(false);
    menuPurchaseRequiesitionApprove.setVisible(false);
    MenuPurchaseOrders.setVisible(false);
    menuItemUsageOfDepartment.setVisible(false);
    jSeparator4.setVisible(false);
    TabMenuSettings.setVisible(false);
    MenuCustomer.setVisible(false);
    jMenuItem2.setVisible(false);
    jMenuItem3.setVisible(false);
    MenuStockEditDepartments.setVisible(false);
}

private void TabMenuMainFilesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TabMenuMainFilesActionPerformed

}//GEN-LAST:event_TabMenuMainFilesActionPerformed

private void MenuSubCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuSubCategoryActionPerformed

    if (SubCat != null) {
        if (!SubCat.isVisible()) {
            SubCat.setVisible(true);
        }
    } else {
        SubCat = new SubCategory();
        dskPane_RightPanel.add(SubCat);
        SubCat.setVisible(true);
    }

}//GEN-LAST:event_MenuSubCategoryActionPerformed

    private void MenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemActionPerformed

        if (item != null) {
            if (!item.isVisible()) {
                item.setVisible(true);
            }
        } else {
            item = new Item();
            dskPane_RightPanel.add(item);
            item.setVisible(true);
        }

    }//GEN-LAST:event_MenuItemActionPerformed

    private void MenuPurchaseOrdersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuPurchaseOrdersActionPerformed
//        JOptionPane.showMessageDialog(this, "This form is still under developing.\n We "
//                + "promise to you to provide this feature as soon as possiable.");

        if (po != null) {
            if (!po.isVisible()) {
                po.setVisible(true);
            }
        } else {
            po = new PurchaseOrder();
            dskPane_RightPanel.add(po);
            po.setVisible(true);
        }

    }//GEN-LAST:event_MenuPurchaseOrdersActionPerformed

    private void MenuGRNItemCodeWiseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuGRNItemCodeWiseActionPerformed
        if (grn != null) {
            if (!grn.isVisible()) {
                grn.setVisible(true);
            }
        } else {
            grn = new GRN();
            dskPane_RightPanel.add(grn);
            grn.setVisible(true);
        }

    }//GEN-LAST:event_MenuGRNItemCodeWiseActionPerformed

    private void MenuReturnToSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuReturnToSupplierActionPerformed
        if (RetToSup != null) {
            if (!RetToSup.isVisible()) {
                RetToSup.setVisible(true);
            }
        } else {
            RetToSup = new ReturnToSupplier();
            dskPane_RightPanel.add(RetToSup);
            RetToSup.setVisible(true);
        }

    }//GEN-LAST:event_MenuReturnToSupplierActionPerformed

    private void SubMenuCreamyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubMenuCreamyActionPerformed
//        try {
//            SyntheticaWhiteVisionLookAndFeel feel = new SyntheticaWhiteVisionLookAndFeel();
//            setThisLookandFeel(feel);
//        } catch (ParseException ex) {
//            Logger.getLogger(IndexPage.class.getName()).log(Level.SEVERE, null, ex);
//        }
        Properties props = new Properties();
        SmartLookAndFeel.setCurrentTheme(props);
        try {
            // select the Look and Feel //
            UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
            ImageIcon imgThisImg = new ImageIcon(projectPath + "/pictures/DefaultBackgrounds/Basic/Creamy.jpg");
            LabelBackGroundPicture.setIcon(imgThisImg);
//            UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.mcwin lookandfeel");
//            UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
        } catch (ClassNotFoundException ex) {
        } catch (InstantiationException ex) {
        } catch (IllegalAccessException ex) {
        } catch (UnsupportedLookAndFeelException ex) {
        }


    }//GEN-LAST:event_SubMenuCreamyActionPerformed

    private void SubMenuMetalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubMenuMetalActionPerformed
//        QuaquaLookAndFeel feel = new QuaquaLookAndFeel();
//        setThisLookandFeel(feel);
        try {
            // Set cross-platform Java L&F (also called "Metal")
            UIManager.setLookAndFeel(
                    UIManager.getCrossPlatformLookAndFeelClassName());
            ImageIcon imgThisImg = new ImageIcon(projectPath + "/pictures/DefaultBackgrounds/Metal.jpg");
            LabelBackGroundPicture.setIcon(imgThisImg);
            dskPane_RightPanel.setBackground(new Color(204, 204, 204));
        } catch (UnsupportedLookAndFeelException e) {
            // handle exception
        } catch (ClassNotFoundException e) {
            // handle exception
        } catch (InstantiationException e) {
            // handle exception
        } catch (IllegalAccessException e) {
            // handle exception
        }
    }//GEN-LAST:event_SubMenuMetalActionPerformed

    private void SubMenuGreenPlanetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubMenuGreenPlanetActionPerformed
//        UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel
        UIManager.removeAuxiliaryLookAndFeel(null);
        UIManager.removePropertyChangeListener(null);
        try {
            com.jtattoo.plaf.acryl.AcrylLookAndFeel.setTheme("Green", "INSERT YOUR LICENSE KEY HERE", "my company");
            UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
            ImageIcon imgThisImg = new ImageIcon(projectPath + "/pictures/DefaultBackgrounds/GreenPlanet.jpg");
            LabelBackGroundPicture.setIcon(imgThisImg);
            dskPane_RightPanel.setBackground(new Color(0, 102, 0));

        } catch (ClassNotFoundException ex) {
        } catch (InstantiationException ex) {
        } catch (IllegalAccessException ex) {
        } catch (UnsupportedLookAndFeelException ex) {
        }
    }//GEN-LAST:event_SubMenuGreenPlanetActionPerformed

    private void SubMenuWinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubMenuWinActionPerformed
//        try {
//            String lookandfeel = UIManager.getSystemLookAndFeelClassName();
//            UIManager.setLookAndFeel(lookandfeel);
//            SwingUtilities.updateComponentTreeUI(this);
//            this.repaint();
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(IndexPage.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            Logger.getLogger(IndexPage.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            Logger.getLogger(IndexPage.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (UnsupportedLookAndFeelException ex) {
//            Logger.getLogger(IndexPage.class.getName()).log(Level.SEVERE, null, ex); 
//        }
//        dskPane_RightPanel.removeAll();
        try {

            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            ImageIcon imgThisImg = new ImageIcon(projectPath + "/pictures/DefaultBackgrounds/Basic/WindowsLook.jpg");
            LabelBackGroundPicture.setIcon(imgThisImg);
            dskPane_RightPanel.setBackground(new Color(255, 255, 255));
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (InstantiationException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (IllegalAccessException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (UnsupportedLookAndFeelException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }//GEN-LAST:event_SubMenuWinActionPerformed

    private void MenuSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuSupplierActionPerformed
        if (sup != null) {
            if (!sup.isVisible()) {
                sup.setVisible(true);
            }
        } else {
            sup = new Supplier();
            dskPane_RightPanel.add(sup);
            sup.setVisible(true);
        }
    }//GEN-LAST:event_MenuSupplierActionPerformed

    private void MenuDataReportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuDataReportsActionPerformed
        JOptionPane.showMessageDialog(this, "This form is still under developing.\n We "
                + "promise to you to provide this feature as soon as possiable.");
    }//GEN-LAST:event_MenuDataReportsActionPerformed

    private void MenuCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuCustomerActionPerformed
        if (cus != null) {
            if (!cus.isVisible()) {
                cus.setVisible(true);
            }
        } else {
            cus = new Customer();
            dskPane_RightPanel.add(cus);
            cus.setVisible(true);
        }
    }//GEN-LAST:event_MenuCustomerActionPerformed

    private void SubMenuWoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubMenuWoodActionPerformed
        try {
            UIManager.setLookAndFeel(new SyntheticaClassyLookAndFeel());
            ImageIcon imgThisImg = new ImageIcon(projectPath + "/pictures/DefaultBackgrounds/Wood.jpg");
            LabelBackGroundPicture.setIcon(imgThisImg);
            dskPane_RightPanel.setBackground(new Color(102, 51, 0));
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (UnsupportedLookAndFeelException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_SubMenuWoodActionPerformed

    private void SubMenuBlackStoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubMenuBlackStoneActionPerformed
//        try {
//            UIManager.setLookAndFeel(new SyntheticaBlackEyeLookAndFeel());
//            ImageIcon imgThisImg = new ImageIcon(projectPath + "/pictures/DefaultBackgrounds/DarkNight.jpg");
//            LabelBackGroundPicture.setIcon(imgThisImg);
//            dskPane_RightPanel.setBackground(Color.BLACK);
//        } catch (Exception e) { //
//            JOptionPane.showMessageDialog(null, e.getMessage());
//        }

        try {
            //here you can put the selected theme class name in JTattoo
//            UIManager.setLookAndFeel(new  TextureLookAndFeel());
            UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
            ImageIcon imgThisImg = new ImageIcon(projectPath + "/pictures/DefaultBackgrounds/DarkNight.jpg");
            LabelBackGroundPicture.setIcon(imgThisImg);
            dskPane_RightPanel.setBackground(Color.BLACK);

        } catch (ClassNotFoundException ex) {
        } catch (InstantiationException ex) {
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IndexPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IndexPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_SubMenuBlackStoneActionPerformed

    private void SubMenuSunSetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubMenuSunSetActionPerformed
        try {
            UIManager.setLookAndFeel(new SyntheticaOrangeMetallicLookAndFeel());
            ImageIcon imgThisImg = new ImageIcon(projectPath + "/pictures/DefaultBackgrounds/SunSet.jpg");
            LabelBackGroundPicture.setIcon(imgThisImg);
            dskPane_RightPanel.setBackground(Color.ORANGE);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (UnsupportedLookAndFeelException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_SubMenuSunSetActionPerformed

    private void SubMenuSnowWhiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubMenuSnowWhiteActionPerformed
        try {
            UIManager.setLookAndFeel(new SyntheticaWhiteVisionLookAndFeel());
            ImageIcon imgThisImg = new ImageIcon(projectPath + "/pictures/DefaultBackgrounds/SnowWhite.jpg");
            LabelBackGroundPicture.setIcon(imgThisImg);
            dskPane_RightPanel.setBackground(Color.WHITE);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (UnsupportedLookAndFeelException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_SubMenuSnowWhiteActionPerformed

    private void SubMenuBlueOceanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubMenuBlueOceanActionPerformed
        try {
            UIManager.setLookAndFeel(new SyntheticaBlueMoonLookAndFeel());
            ImageIcon imgThisImg = new ImageIcon(projectPath + "/pictures/DefaultBackgrounds/BlueOcean.jpg");
            LabelBackGroundPicture.setIcon(imgThisImg);
            dskPane_RightPanel.setBackground(new Color(0, 0, 91));
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (UnsupportedLookAndFeelException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_SubMenuBlueOceanActionPerformed

    private void SubMenuLinuxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubMenuLinuxActionPerformed
//        try {
//            UIManager.setLookAndFeel(
//                    ch.randelshofer.quaqua.QuaquaManager.getLookAndFeel());
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e.getMessage());
//        }

        try {
            ImageIcon imgThisImg = new ImageIcon(projectPath + "/pictures/DefaultBackgrounds/Basic/LinuxLook.jpg");
            LabelBackGroundPicture.setIcon(imgThisImg);
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (InstantiationException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (IllegalAccessException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (UnsupportedLookAndFeelException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }//GEN-LAST:event_SubMenuLinuxActionPerformed

    private void SubMenuSpiderManActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubMenuSpiderManActionPerformed
        try {
//            com.jtattoo.plaf.acryl.AcrylLookAndFeel.setTheme("Green", "INSERT YOUR LICENSE KEY HERE", "my company");
            UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
            ImageIcon imgThisImg = new ImageIcon(projectPath + "/pictures/DefaultBackgrounds/Movie Touch/SpiderMan.jpg");
            LabelBackGroundPicture.setIcon(imgThisImg);
            dskPane_RightPanel.setBackground(new Color(0, 0, 0));

        } catch (ClassNotFoundException ex) {
        } catch (InstantiationException ex) {
        } catch (IllegalAccessException ex) {
        } catch (UnsupportedLookAndFeelException ex) {
        }
    }//GEN-LAST:event_SubMenuSpiderManActionPerformed

    private void SubMenuRomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubMenuRomeActionPerformed
        try {
            //here you can put the selected theme class name in JTattoo
//            com.jtattoo.plaf.texture.TextureLookAndFeel.setTheme("Green", "INSERT YOUR LICENSE KEY HERE", "Dark Knight");
            UIManager.setLookAndFeel(new TextureLookAndFeel());
            UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
            ImageIcon imgThisImg = new ImageIcon(projectPath + "/pictures/DefaultBackgrounds/Historical/Rome.jpg");
            LabelBackGroundPicture.setIcon(imgThisImg);
            dskPane_RightPanel.setBackground(new Color(255, 204, 153));

        } catch (ClassNotFoundException ex) {
        } catch (InstantiationException ex) {
        } catch (IllegalAccessException ex) {
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        }
    }//GEN-LAST:event_SubMenuRomeActionPerformed

    private void MenuStockEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuStockEditActionPerformed

        if (stockedit != null) {
            if (!stockedit.isVisible()) {
                stockedit.setVisible(true);
            }
        } else {
            stockedit = new StockEdit();
            dskPane_RightPanel.add(stockedit);
            stockedit.setVisible(true);
        }

    }//GEN-LAST:event_MenuStockEditActionPerformed

    private void SubMenuDarkKnightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubMenuDarkKnightActionPerformed
        try {
//            com.jtattoo.plaf.acryl.AcrylLookAndFeel.setTheme("Black", "INSERT YOUR LICENSE KEY HERE", "Dark Knight");
            UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
            ImageIcon imgThisImg = new ImageIcon(projectPath + "/pictures/DefaultBackgrounds/Movie Touch/DarkKnight.jpg");
            LabelBackGroundPicture.setIcon(imgThisImg);
            dskPane_RightPanel.setBackground(new Color(0, 0, 0));

        } catch (ClassNotFoundException ex) {
        } catch (InstantiationException ex) {
        } catch (IllegalAccessException ex) {
        } catch (UnsupportedLookAndFeelException ex) {
        }
    }//GEN-LAST:event_SubMenuDarkKnightActionPerformed

    private void SubMenuManOfSteelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubMenuManOfSteelActionPerformed
        try {

            UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
            ImageIcon imgThisImg = new ImageIcon(projectPath + "/pictures/DefaultBackgrounds/Movie Touch/ManOfSteel.jpg");
            LabelBackGroundPicture.setIcon(imgThisImg);
            dskPane_RightPanel.setBackground(new Color(0, 0, 20));

        } catch (ClassNotFoundException ex) {
        } catch (InstantiationException ex) {
        } catch (IllegalAccessException ex) {
        } catch (UnsupportedLookAndFeelException ex) {
        }
    }//GEN-LAST:event_SubMenuManOfSteelActionPerformed

    private void SubMenuSherlockHolmesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubMenuSherlockHolmesActionPerformed
        UIManager.removeAuxiliaryLookAndFeel(null);
        UIManager.removePropertyChangeListener(null);
        try {
            com.jtattoo.plaf.acryl.AcrylLookAndFeel.setTheme("Black", "INSERT YOUR LICENSE KEY HERE", "Dark Knight");
            UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
            ImageIcon imgThisImg = new ImageIcon(projectPath + "/pictures/DefaultBackgrounds/Movie Touch/SherlockHolmes.jpg");
            LabelBackGroundPicture.setIcon(imgThisImg);
            dskPane_RightPanel.setBackground(new Color(0, 0, 0));

        } catch (ClassNotFoundException ex) {
        } catch (InstantiationException ex) {
        } catch (IllegalAccessException ex) {
        } catch (UnsupportedLookAndFeelException ex) {
        }

//        try {
//            UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }//GEN-LAST:event_SubMenuSherlockHolmesActionPerformed

    private void SubMenuCrysis3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubMenuCrysis3ActionPerformed
        UIManager.removeAuxiliaryLookAndFeel(null);
        UIManager.removePropertyChangeListener(null);
        try {
            com.jtattoo.plaf.acryl.AcrylLookAndFeel.setTheme("Red", "INSERT YOUR LICENSE KEY HERE", "Dark Knight");
            UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
            ImageIcon imgThisImg = new ImageIcon(projectPath + "/pictures/DefaultBackgrounds/Game Touch/Crysis3.jpg");
            LabelBackGroundPicture.setIcon(imgThisImg);
            dskPane_RightPanel.setBackground(new Color(102, 0, 0));

        } catch (ClassNotFoundException ex) {
        } catch (InstantiationException ex) {
        } catch (IllegalAccessException ex) {
        } catch (UnsupportedLookAndFeelException ex) {
        }
    }//GEN-LAST:event_SubMenuCrysis3ActionPerformed

    private void SubMenuAssassinsCreedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubMenuAssassinsCreedActionPerformed
        try {
            com.jtattoo.plaf.acryl.AcrylLookAndFeel.setTheme("Black", "INSERT YOUR LICENSE KEY HERE", "Dark Knight");
            UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
            ImageIcon imgThisImg = new ImageIcon(projectPath + "/pictures/DefaultBackgrounds/Game Touch/AssassinsCreed.jpg");
            LabelBackGroundPicture.setIcon(imgThisImg);
            dskPane_RightPanel.setBackground(new Color(0, 0, 0));

        } catch (ClassNotFoundException ex) {
        } catch (InstantiationException ex) {
        } catch (IllegalAccessException ex) {
        } catch (UnsupportedLookAndFeelException ex) {
        }
    }//GEN-LAST:event_SubMenuAssassinsCreedActionPerformed

    private void SubMenuGreenLanternActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubMenuGreenLanternActionPerformed
        try {
            com.jtattoo.plaf.acryl.AcrylLookAndFeel.setTheme("Green", "INSERT YOUR LICENSE KEY HERE", "my company");
            UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
            ImageIcon imgThisImg = new ImageIcon(projectPath + "/pictures/DefaultBackgrounds/Movie Touch/GreenLantern.jpg");
            LabelBackGroundPicture.setIcon(imgThisImg);
            dskPane_RightPanel.setBackground(new Color(0, 102, 0));

        } catch (ClassNotFoundException ex) {
        } catch (InstantiationException ex) {
        } catch (IllegalAccessException ex) {
        } catch (UnsupportedLookAndFeelException ex) {
        }
    }//GEN-LAST:event_SubMenuGreenLanternActionPerformed

    private void MenuStockReportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuStockReportsActionPerformed
        if (StRe != null) {
            if (!StRe.isVisible()) {
                StRe.setVisible(true);
            }
        } else {
            StRe = new StockReports();
            dskPane_RightPanel.add(StRe);
            StRe.setVisible(true);
        }

    }//GEN-LAST:event_MenuStockReportsActionPerformed

    private void MenuAdminSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuAdminSettingsActionPerformed
        JOptionPane.showMessageDialog(this, "This form is still under developing.\n We "
                + "promise to you to provide this feature as soon as possiable.");

//        if (AdminSettings != null) {
//            if (!AdminSettings.isVisible()) {
//                AdminSettings.setVisible(true);
//            }
//        } else {
//            AdminSettings = new AdministratorSettings();
//            dskPane_RightPanel.add(AdminSettings);
//            AdminSettings.setVisible(true);
//        }

    }//GEN-LAST:event_MenuAdminSettingsActionPerformed

    private void MenuConnectionSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuConnectionSettingsActionPerformed
//        AdministratorSettings AdminSettings = new AdministratorSettings();
//        dskPane_RightPanel.add(AdminSettings);
//        dskPane_RightPanel.repaint();
//        dskPane_RightPanel.revalidate();
//        AdminSettings.setVisible(true);
    }//GEN-LAST:event_MenuConnectionSettingsActionPerformed

    private void MenuPurSellPriceEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuPurSellPriceEditActionPerformed
        if (PriceEdit != null) {
            if (!PriceEdit.isVisible()) {
                PriceEdit.setVisible(true);
            }
        } else {
            PriceEdit = new PurchaseSellingPriceEdit();
            dskPane_RightPanel.add(PriceEdit);
            PriceEdit.setVisible(true);
        }

    }//GEN-LAST:event_MenuPurSellPriceEditActionPerformed

    private void MenuTransferBranchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuTransferBranchActionPerformed
        if (IT != null) {
            if (!IT.isVisible()) {
                IT.setVisible(true);
            }
        } else {
            IT = new ItemTransferBranchWise();
            dskPane_RightPanel.add(IT);
            IT.setVisible(true);
        }

    }//GEN-LAST:event_MenuTransferBranchActionPerformed

    private void ButtonClickHereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonClickHereActionPerformed
        try {
            File foler = new File(projectPath + "/Video Tutorials/"); // path to the directory to be opened
            Desktop desktop = null;
            if (Desktop.isDesktopSupported()) {
                desktop = Desktop.getDesktop();
            }
            desktop.open(foler);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(this, "Please contact for support.");
        }

    }//GEN-LAST:event_ButtonClickHereActionPerformed

    private void MenuItemDefaultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemDefaultActionPerformed
        try {

            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            ImageIcon imgThisImg = new ImageIcon(projectPath + "/pictures/DefaultBackgrounds/Basic/Inventory.jpg");
//            ImageIcon imgThisImg = new ImageIcon(projectPath + "/pictures/DefaultBackgrounds/loginBackground.jpg");
            LabelBackGroundPicture.setIcon(imgThisImg);
            dskPane_RightPanel.setBackground(new Color(255, 255, 255));
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (InstantiationException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (IllegalAccessException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (UnsupportedLookAndFeelException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_MenuItemDefaultActionPerformed

    private void MenuDisposalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuDisposalActionPerformed
        if (ItemD != null) {
            if (!ItemD.isVisible()) {
                ItemD.setVisible(true);
            }
        } else {
            ItemD = new ItemDisposal();
            dskPane_RightPanel.add(ItemD);
            ItemD.setVisible(true);
        }

    }//GEN-LAST:event_MenuDisposalActionPerformed

    private void MenuPurchaseReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuPurchaseReportActionPerformed
        if (TraRe != null) {
            if (!TraRe.isVisible()) {
                TraRe.setVisible(true);
            }
        } else {
            TraRe = new TransactionReportsPurchase();
            dskPane_RightPanel.add(TraRe);
            TraRe.setVisible(true);
        }

    }//GEN-LAST:event_MenuPurchaseReportActionPerformed

    private void MenuIssueReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuIssueReportActionPerformed
        if (TraReIssue != null) {
            if (!TraReIssue.isVisible()) {
                TraReIssue.setVisible(true);
            }
        } else {
            TraReIssue = new TransactionReportsIssue();
            dskPane_RightPanel.add(TraReIssue);
            TraReIssue.setVisible(true);
        }

    }//GEN-LAST:event_MenuIssueReportActionPerformed

    private void MenuUserUnitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuUserUnitActionPerformed
        if (userUnites != null) {
            if (!userUnites.isVisible()) {
                userUnites.setVisible(true);
            }
        } else {
            userUnites = new UserUnites();
            dskPane_RightPanel.add(userUnites);
            userUnites.setVisible(true);
        }
    }//GEN-LAST:event_MenuUserUnitActionPerformed

    private void MenuLogReportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuLogReportsActionPerformed
        JOptionPane.showMessageDialog(this, "This form is still under developing.\n We "
                + "promise to you to provide this feature as soon as possiable.");
    }//GEN-LAST:event_MenuLogReportsActionPerformed

    private void MenuNotificationsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuNotificationsActionPerformed
        JOptionPane.showMessageDialog(this, "This form is still under developing.\n We "
                + "promise to you to provide this feature as soon as possiable.");
    }//GEN-LAST:event_MenuNotificationsActionPerformed

    private void MenuBaseCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuBaseCategoryActionPerformed
        if (BC != null) {
            if (!BC.isVisible()) {
                BC.setVisible(true);
            }
        } else {
            BC = new BaseCategory();
            dskPane_RightPanel.add(BC);
            BC.setVisible(true);
        }

    }//GEN-LAST:event_MenuBaseCategoryActionPerformed

    private void MenuItemBinCardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemBinCardActionPerformed
        if (Bin != null) {
            if (!Bin.isVisible()) {
                Bin.setVisible(true);
            }
        } else {
            Bin = new BinCard();
            dskPane_RightPanel.add(Bin);
            Bin.setVisible(true);
        }

    }//GEN-LAST:event_MenuItemBinCardActionPerformed

    private void menuTransactionsComparisonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuTransactionsComparisonActionPerformed
        if (transactionsComparison != null) {
            if (!transactionsComparison.isVisible()) {
                transactionsComparison.setVisible(true);
            }
        } else {
            transactionsComparison = new TransactionsComparison();
            dskPane_RightPanel.add(transactionsComparison);
            transactionsComparison.setVisible(true);
        }
    }//GEN-LAST:event_menuTransactionsComparisonActionPerformed

    private void menuIssueForMaterialRequisitionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuIssueForMaterialRequisitionActionPerformed
        if (issueForMaterialRequisitionItemCodeWise != null) {
            if (!issueForMaterialRequisitionItemCodeWise.isVisible()) {
                issueForMaterialRequisitionItemCodeWise.setVisible(true);
            }
        } else {
            issueForMaterialRequisitionItemCodeWise = new IssueForMaterialRequisitionItemCodeWise();
            dskPane_RightPanel.add(issueForMaterialRequisitionItemCodeWise);
            issueForMaterialRequisitionItemCodeWise.setVisible(true);
        }
    }//GEN-LAST:event_menuIssueForMaterialRequisitionActionPerformed

    private void MenuPurchaseRequiesitionNoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuPurchaseRequiesitionNoteActionPerformed
//        JOptionPane.showMessageDialog(this, "This form is still under developing.\n We "
//                + "promise to you to provide this feature as soon as possiable.");

        if (purchaseRequisitionNote != null) {
            if (!purchaseRequisitionNote.isVisible()) {
                purchaseRequisitionNote.setVisible(true);
            }
        } else {
            purchaseRequisitionNote = new PurchaseRequisitionNote();
            dskPane_RightPanel.add(purchaseRequisitionNote);
            purchaseRequisitionNote.setVisible(true);
        }

    }//GEN-LAST:event_MenuPurchaseRequiesitionNoteActionPerformed

    private void menuPurchaseRequiesitionApproveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPurchaseRequiesitionApproveActionPerformed
        JOptionPane.showMessageDialog(this, "This form is still under developing.\n We "
                + "promise to you to provide this feature as soon as possiable.");
    }//GEN-LAST:event_menuPurchaseRequiesitionApproveActionPerformed

    private void menuItemUsageOfDepartmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemUsageOfDepartmentActionPerformed
        JOptionPane.showMessageDialog(this, "This form is still under developing.\n We "
                + "promise to you to provide this feature as soon as possiable.");
    }//GEN-LAST:event_menuItemUsageOfDepartmentActionPerformed

    private void MenuStockEditDepartmentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuStockEditDepartmentsActionPerformed
        JOptionPane.showMessageDialog(this, "This form is still under developing.\n We "
                + "promise to you to provide this feature as soon as possiable.");
    }//GEN-LAST:event_MenuStockEditDepartmentsActionPerformed

    private void MenuItemBlankActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemBlankActionPerformed
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            ImageIcon imgThisImg = new ImageIcon(projectPath + "/pictures/DefaultBackgrounds/loginBackground.jpg");
            LabelBackGroundPicture.setIcon(imgThisImg);
            dskPane_RightPanel.setBackground(new Color(255, 255, 255));
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (InstantiationException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (IllegalAccessException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (UnsupportedLookAndFeelException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_MenuItemBlankActionPerformed

    private void menuIssueWithOutMaterialRequisitionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuIssueWithOutMaterialRequisitionActionPerformed
        if (issueWithoutMaterialRequisitionItemCodeWise != null) {
            if (!issueWithoutMaterialRequisitionItemCodeWise.isVisible()) {
                issueWithoutMaterialRequisitionItemCodeWise.setVisible(true);
            }
        } else {
            issueWithoutMaterialRequisitionItemCodeWise = new IssueWithoutMaterialRequisitionItemCodeWise();
            dskPane_RightPanel.add(issueWithoutMaterialRequisitionItemCodeWise);
            issueWithoutMaterialRequisitionItemCodeWise.setVisible(true);
        }
    }//GEN-LAST:event_menuIssueWithOutMaterialRequisitionActionPerformed

    public static JMenu getOpenWindowMenuItem() {
        return TabMenuSettings;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
        } catch (InstantiationException ex) {
        } catch (IllegalAccessException ex) {
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new IndexPage().setVisible(true);
            }
        });
    }

    public JMenu getOpenMenuWindowMenu() {
        return TabMenuSettings;
    }

    /**
     *
     * @return RightPanel Desktop pane
     */
    public static JDesktopPane getDesktopPane() {
        return dskPane_RightPanel;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonClickHere;
    private javax.swing.JLabel LabelBackGroundPicture;
    private javax.swing.JLabel LabelClientLogo;
    public static javax.swing.JLabel LabelDate;
    private javax.swing.JLabel LabelDate2;
    private javax.swing.JLabel LabelDate3;
    public static javax.swing.JLabel LabelTime;
    private javax.swing.JLabel LabelUser;
    private javax.swing.JMenuItem MenuAbout;
    private javax.swing.JMenuItem MenuAdminSettings;
    private javax.swing.JMenuItem MenuBaseCategory;
    private javax.swing.JMenuItem MenuConnectionSettings;
    public static javax.swing.JMenuItem MenuCustomer;
    public static javax.swing.JMenuItem MenuDataReports;
    private javax.swing.JMenuItem MenuDisposal;
    public static javax.swing.JMenuItem MenuGRNItemCodeWise;
    private javax.swing.JMenuItem MenuGRNSerialCodeWise;
    private javax.swing.JMenuItem MenuIssueReport;
    public static javax.swing.JMenuItem MenuItem;
    private javax.swing.JMenuItem MenuItemBinCard;
    private javax.swing.JMenuItem MenuItemBlank;
    private javax.swing.JMenuItem MenuItemDefault;
    private javax.swing.JMenuItem MenuLogReports;
    public static javax.swing.JMenuItem MenuMainCategory;
    private javax.swing.JMenu MenuNatureTouch;
    private javax.swing.JMenuItem MenuNotifications;
    private javax.swing.JMenuItem MenuOnlineTutes;
    public static javax.swing.JMenu MenuPersonalization;
    private javax.swing.JMenuItem MenuPurSellPriceEdit;
    public static javax.swing.JMenuItem MenuPurchaseOrders;
    private javax.swing.JMenuItem MenuPurchaseReport;
    private javax.swing.JMenuItem MenuPurchaseRequiesitionNote;
    public static javax.swing.JMenuItem MenuReturnToSupplier;
    private javax.swing.JMenuItem MenuStockEdit;
    private javax.swing.JMenuItem MenuStockEditDepartments;
    private javax.swing.JMenuItem MenuStockReports;
    public static javax.swing.JMenuItem MenuSubCategory;
    public static javax.swing.JMenuItem MenuSupplier;
    private javax.swing.JMenuItem MenuTransferBranch;
    private javax.swing.JMenuItem MenuUserManual;
    private javax.swing.JMenuItem MenuUserUnit;
    private javax.swing.JPanel PanelCompanyLogo;
    private javax.swing.JMenuItem SubMenuAssassinsCreed;
    private javax.swing.JMenuItem SubMenuBlackStone;
    private javax.swing.JMenuItem SubMenuBlueOcean;
    private javax.swing.JMenuItem SubMenuCreamy;
    private javax.swing.JMenuItem SubMenuCrysis3;
    private javax.swing.JMenuItem SubMenuDarkKnight;
    private javax.swing.JMenuItem SubMenuGreenLantern;
    private javax.swing.JMenuItem SubMenuGreenPlanet;
    private javax.swing.JMenuItem SubMenuLinux;
    private javax.swing.JMenuItem SubMenuManOfSteel;
    private javax.swing.JMenuItem SubMenuMetal;
    private javax.swing.JMenuItem SubMenuRome;
    private javax.swing.JMenuItem SubMenuSherlockHolmes;
    private javax.swing.JMenuItem SubMenuSnowWhite;
    private javax.swing.JMenuItem SubMenuSpiderMan;
    private javax.swing.JMenuItem SubMenuSunSet;
    private javax.swing.JMenuItem SubMenuWin;
    private javax.swing.JMenuItem SubMenuWood;
    private javax.swing.JMenu TabMenuHelp;
    public static javax.swing.JMenu TabMenuMainFiles;
    public static javax.swing.JMenu TabMenuReports;
    private static javax.swing.JMenu TabMenuSettings;
    public static javax.swing.JMenu TabMenuTools;
    public static javax.swing.JMenu TabMenuTransactions;
    public static javax.swing.JTextField TextCompanyName;
    private javax.swing.JMenu arrowMenuGRN;
    private javax.swing.JMenu arrowMenuIssue;
    private javax.swing.JMenu arrowMenuReturnToSupplier;
    private javax.swing.JMenu arrowMenuTransfer;
    public static javax.swing.JDesktopPane dskPane_RightPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator10;
    private javax.swing.JPopupMenu.Separator jSeparator11;
    private javax.swing.JPopupMenu.Separator jSeparator12;
    private javax.swing.JPopupMenu.Separator jSeparator13;
    private javax.swing.JPopupMenu.Separator jSeparator14;
    private javax.swing.JPopupMenu.Separator jSeparator15;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    public static javax.swing.JLabel labelDepartmentCode;
    public static javax.swing.JLabel labelSubDepartmentCode;
    private javax.swing.JMenuItem menuIssueForMaterialRequisition;
    private javax.swing.JMenuItem menuIssueWithOutMaterialRequisition;
    private javax.swing.JMenuItem menuItemRemovePendingTransactions;
    private javax.swing.JMenuItem menuItemUsageOfDepartment;
    private javax.swing.JMenuItem menuPurchaseRequiesitionApprove;
    private javax.swing.JMenuItem menuTransactionsComparison;
    private javax.swing.JMenuBar mnBar_menuBar;
    private javax.swing.JPanel pnl_BasePanel;
    private javax.swing.JPanel pnl_LeftPanel;
    private javax.swing.JSplitPane spliPne_View;
    // End of variables declaration//GEN-END:variables

}
