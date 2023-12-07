package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controller.DangNhap_Controller;
import controller.Mouse_Controller;
import controller.QlbhController;
import controller.TrangChu_Controller;
import database.JDBC_DangNhap;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import java.awt.Component;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import java.awt.CardLayout;
import javax.swing.JSplitPane;
import java.awt.Dimension;
import resource.Color_Res;
import java.awt.event.MouseListener;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import java.awt.Cursor;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.net.PortUnreachableException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JScrollBar;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.JTabbedPane;

public class TrangChu_Vi extends JFrame {
	private Font font_TimDoanhThu = new Font("Tahoma", Font.PLAIN, 15);
	private Color_Res color = new Color_Res();
	private Placeholder placeholder = new Placeholder();
	private DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();

	private JPanel contentPane, panel_CardLayout;
	private JButton btn_DoanhThu, btn_ThongKe, btn_QuanLyKho, btn_QuanLyBanHang;
	private JButton btn_TimKiem_Kho, btn_Them, btn_Xoa, btn_CapNhat, btn_HuyBo, btn_DangXuat, btn_XuatFileExcel;
	private JTextField txt_HangCanTim_Kho;
	private JTable table_HangHoa, table_HangHoaThanhToan;
	private JTextField txt_TenSanPham;
	private JTextField txt_GiaBan;
	private JTextField txt_NhaSanXuat;
	private JTextField txt_NgaySanXuat;
	private JTextField txt_SoLuong;
	private JTextField txt_HanSuDung;
	private JTextField txt_HangCanTim_BanHang;
	private JButton btn_ThanhToan;
	private JButton btn_TimKiem_BanHang;
	private JTable table_HangHoaDaChon;
	private JTextField txt_SoLuongCanMua;
	private JButton btn_XacNhan;
	private JButton btn_XoaHang;
	private JButton btn_SuaSoLuong;
	private JButton btn_TroLai;
	private JTextField txt_HangCanTim_ThongKe;
	private JTable table_HangHoaLoc;
	private JButton btn_Xoa_ThongKe;
	private JButton btn_TimKiem_ThongKe;
	private JButton btn_Loc;
	private JTextField txt_DoanhThuNgay;
	private JTable table_DoanhThuNgay;
	private JTextField txt_DoanhThuThang;
	private JTable table_DoanhThuThang;
	private JTextField txt_DoanhThuNam;
	private JTable table_DoanhThuNam;
	private JButton btn_DoanhThuNgay;
	private JButton btn_DoanhThuThang;
	private JButton btn_DoanhThuNam;
	private DefaultTableModel model_HangHoa;
	public DefaultTableModel model_HangHoaThanhToan;
	private DefaultTableModel model_HangHoaLoc;
	private DefaultTableModel model_DoanhThuNgay;
	private DefaultTableModel model_DoanhThuThang;
	private DefaultTableModel model_DoanhThuNam;
	private DefaultTableModel model_HangHoaDaChon;
	
	public boolean functionCalled = false;
	private JLabel lbl_SoTienThanhToan;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrangChu_Vi frame = new TrangChu_Vi();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public TrangChu_Vi() {
		setPreferredSize(new Dimension(1300, 750));
		addWindowFocusListener(new WindowFocusListener() {


			public void windowGainedFocus(WindowEvent e) {
				requestFocusInWindow();
				if (!functionCalled ) {
					HienThiBangBanHang();
				}
			}

			public void windowLostFocus(WindowEvent e) {
				functionCalled = true;
			}
		});

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int luaChon = JOptionPane.showConfirmDialog(new JFrame(),
						"Bạn có chắc chắn muốn thoát khỏi chương trình?", "Xác nhận", JOptionPane.YES_NO_OPTION);

				if (luaChon == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setMinimumSize(new Dimension(1300, 750));
		setTitle("Phần mềm quản lý cửa hàng tạp hóa v1.0");
		setLocationRelativeTo(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setBounds(100, 100, 1200, 675);
		contentPane = new JPanel();

		setContentPane(contentPane);
		
		
		MouseListener mouseListener = new Mouse_Controller(null, null, this);
		ActionListener actionListener = new TrangChu_Controller(this);
		QlbhController qlbhController = new QlbhController(this);

		JSplitPane splitPane = new JSplitPane();
		splitPane.setDividerSize(0);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(splitPane,
				GroupLayout.DEFAULT_SIZE, 1286, Short.MAX_VALUE));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(splitPane,
				GroupLayout.DEFAULT_SIZE, 677, Short.MAX_VALUE));

		JPanel sidePanel = new JPanel();
		sidePanel.setMinimumSize(new Dimension(250, 675));
		sidePanel.setBackground(new Color(25, 55, 109));
		sidePanel.setBounds(100, 100, 200, 675);
		splitPane.setLeftComponent(sidePanel);

		JSeparator separator = new JSeparator();
		separator.setAlignmentY(0.0f);
		separator.setAlignmentX(0.0f);

		panel_CardLayout = new JPanel();
		panel_CardLayout.setMinimumSize(new Dimension(950, 675));
		splitPane.setRightComponent(panel_CardLayout);
		panel_CardLayout.setLayout(new CardLayout(0, 0));

		JPanel panel_QuanLyKho = new JPanel();
		panel_QuanLyKho.setBackground(new Color(240, 240, 240));
		panel_CardLayout.add(panel_QuanLyKho, "name_744579135716200");

		JPanel panel_TimKiem = new JPanel();

		JPanel panel_Bang = new JPanel();

		JPanel panel_ThongTinSanPham = new JPanel();

		JPanel panel = new JPanel();

		JPanel panel_ChuaNut = new JPanel();
		panel_ChuaNut.setLayout(new GridLayout(1, 0, 120, 0));

		GroupLayout gl_panel_QuanLyKho = new GroupLayout(panel_QuanLyKho);
		gl_panel_QuanLyKho
				.setHorizontalGroup(gl_panel_QuanLyKho.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_QuanLyKho.createSequentialGroup().addGap(59)
								.addComponent(panel_ChuaNut, GroupLayout.DEFAULT_SIZE, 933, Short.MAX_VALUE).addGap(42))
						.addGroup(gl_panel_QuanLyKho.createSequentialGroup().addContainerGap()
								.addComponent(panel_ThongTinSanPham, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addContainerGap())
						.addComponent(panel_TimKiem, GroupLayout.DEFAULT_SIZE, 1034, Short.MAX_VALUE)
						.addGroup(gl_panel_QuanLyKho.createSequentialGroup()
								.addComponent(panel_Bang, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addContainerGap())
						.addGroup(gl_panel_QuanLyKho.createSequentialGroup().addContainerGap()
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1014, Short.MAX_VALUE)
								.addContainerGap()));
		gl_panel_QuanLyKho.setVerticalGroup(gl_panel_QuanLyKho.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_QuanLyKho.createSequentialGroup()
						.addComponent(panel_TimKiem, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(panel_Bang, GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE).addGap(18)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(panel_ThongTinSanPham, GroupLayout.PREFERRED_SIZE, 154,
								GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(panel_ChuaNut, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addGap(27)));

		btn_Them = new JButton("Thêm");
		btn_Them.setIcon(
				new ImageIcon(TrangChu_Vi.class.getResource("/resource/Hopstarter-Button-Button-Add.24.png")));
		btn_Them.setForeground(Color.WHITE);
		btn_Them.setBackground(new Color(25, 55, 109));
		btn_Them.setBorderPainted(false);
		btn_Them.setFocusPainted(false);
		btn_Them.addMouseListener(mouseListener);
		btn_Them.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_Them.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_ChuaNut.add(btn_Them);

		btn_Xoa = new JButton("Xóa");
		btn_Xoa.setIcon(
				new ImageIcon(TrangChu_Vi.class.getResource("/resource/Hopstarter-Button-Button-Delete.24.png")));
		btn_Xoa.setBackground(new Color(25, 55, 109));
		btn_Xoa.setBorderPainted(false);
		btn_Xoa.setFocusPainted(false);
		btn_Xoa.addMouseListener(mouseListener);
		btn_Xoa.setForeground(Color.WHITE);
		btn_Xoa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_Xoa.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_ChuaNut.add(btn_Xoa);

		btn_CapNhat = new JButton("Cập nhật");
		btn_CapNhat.setIcon(new ImageIcon(
				TrangChu_Vi.class.getResource("/resource/Hopstarter-Soft-Scraps-Button-Refresh.24.png")));
		btn_CapNhat.setBackground(new Color(25, 55, 109));
		btn_CapNhat.setBorderPainted(false);
		btn_CapNhat.setFocusPainted(false);
		btn_CapNhat.addMouseListener(mouseListener);
		btn_CapNhat.setForeground(Color.WHITE);
		btn_CapNhat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_CapNhat.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_ChuaNut.add(btn_CapNhat);

		btn_HuyBo = new JButton("Hủy bỏ");
		btn_HuyBo.setIcon(
				new ImageIcon(TrangChu_Vi.class.getResource("/resource/Hopstarter-Button-Button-Close.24.png")));
		btn_HuyBo.setBorderPainted(false);
		btn_HuyBo.setFocusPainted(false);
		btn_HuyBo.addMouseListener(mouseListener);
		btn_HuyBo.setBackground(new Color(25, 55, 109));
		btn_HuyBo.setForeground(Color.WHITE);
		btn_HuyBo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_HuyBo.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_ChuaNut.add(btn_HuyBo);
		panel.setLayout(new GridLayout(0, 2, 500, 0));

		JLabel lblNewLabel_1 = new JLabel("THÔNG TIN SẢN PHẨM");
		lblNewLabel_1.setBorder(BorderFactory.createCompoundBorder(lblNewLabel_1.getBorder(),
				BorderFactory.createEmptyBorder(0, 15, 0, 0)));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		panel.add(lblNewLabel_1);

		JPanel panel_1 = new JPanel();
		panel.add(panel_1);

		btn_XuatFileExcel = new JButton("Xuất file Excel");
		btn_XuatFileExcel.setIcon(
				new ImageIcon(TrangChu_Vi.class.getResource("/resource/Fatcow-Farm-Fresh-Table-excel.24.png")));
		btn_XuatFileExcel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_XuatFileExcel.setBorder(new EmptyBorder(0, 0, 0, 0));
		btn_XuatFileExcel.setForeground(Color.WHITE);
		btn_XuatFileExcel.setBorderPainted(false);
		btn_XuatFileExcel.setFocusPainted(false);
		btn_XuatFileExcel.addMouseListener(mouseListener);
		btn_XuatFileExcel.setBackground(new Color(0, 128, 64));
		btn_XuatFileExcel.setFont(new Font("Tahoma", Font.BOLD, 16));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				gl_panel_1.createSequentialGroup().addContainerGap(77, Short.MAX_VALUE)
						.addComponent(btn_XuatFileExcel, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addComponent(btn_XuatFileExcel,
				GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE));
		panel_1.setLayout(gl_panel_1);
		panel_ThongTinSanPham.setLayout(new GridLayout(3, 2, 20, 20));

		JPanel panel_3 = new JPanel();
		panel_ThongTinSanPham.add(panel_3);

		JLabel lblNewLabel_2 = new JLabel("Tên sản phẩm:");
		lblNewLabel_2.setBorder(BorderFactory.createCompoundBorder(lblNewLabel_2.getBorder(),
				BorderFactory.createEmptyBorder(0, 10, 0, 0)));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));

		txt_TenSanPham = new JTextField();
		txt_TenSanPham.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txt_TenSanPham.setColumns(10);
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup().addComponent(lblNewLabel_2).addGap(18)
						.addComponent(txt_TenSanPham, GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)));
		gl_panel_3.setVerticalGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
				.addComponent(txt_TenSanPham, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE));
		panel_3.setLayout(gl_panel_3);

		JPanel panel_3_1 = new JPanel();
		panel_ThongTinSanPham.add(panel_3_1);

		JLabel lblNewLabel_2_1 = new JLabel("Giá bán:");
		lblNewLabel_2_1.setBorder(BorderFactory.createCompoundBorder(lblNewLabel_2_1.getBorder(),
				BorderFactory.createEmptyBorder(0, 10, 0, 0)));
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));

		txt_GiaBan = new JTextField();
		txt_GiaBan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txt_GiaBan.setColumns(10);
		GroupLayout gl_panel_3_1 = new GroupLayout(panel_3_1);
		gl_panel_3_1.setHorizontalGroup(gl_panel_3_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3_1.createSequentialGroup().addComponent(lblNewLabel_2_1).addGap(18)
						.addComponent(txt_GiaBan, GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)));
		gl_panel_3_1.setVerticalGroup(gl_panel_3_1.createParallelGroup(Alignment.LEADING)
				.addComponent(lblNewLabel_2_1, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
				.addComponent(txt_GiaBan, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE));
		panel_3_1.setLayout(gl_panel_3_1);

		JPanel panel_3_2 = new JPanel();
		panel_ThongTinSanPham.add(panel_3_2);

		JLabel lblNewLabel_2_2 = new JLabel("Nhà sản xuất:");
		lblNewLabel_2_2.setBorder(BorderFactory.createCompoundBorder(lblNewLabel_2_2.getBorder(),
				BorderFactory.createEmptyBorder(0, 10, 0, 0)));
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 18));

		txt_NhaSanXuat = new JTextField();
		txt_NhaSanXuat.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txt_NhaSanXuat.setColumns(10);
		GroupLayout gl_panel_3_2 = new GroupLayout(panel_3_2);
		gl_panel_3_2.setHorizontalGroup(gl_panel_3_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3_2.createSequentialGroup().addComponent(lblNewLabel_2_2).addGap(18)
						.addComponent(txt_NhaSanXuat, GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)));
		gl_panel_3_2.setVerticalGroup(gl_panel_3_2.createParallelGroup(Alignment.LEADING)
				.addComponent(lblNewLabel_2_2, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
				.addComponent(txt_NhaSanXuat, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE));
		panel_3_2.setLayout(gl_panel_3_2);

		JPanel panel_3_3 = new JPanel();
		panel_ThongTinSanPham.add(panel_3_3);

		JLabel lblNewLabel_2_3 = new JLabel("Ngày sản xuất:");
		lblNewLabel_2_3.setBorder(BorderFactory.createCompoundBorder(lblNewLabel_2_3.getBorder(),
				BorderFactory.createEmptyBorder(0, 10, 0, 0)));
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 18));

		txt_NgaySanXuat = new JTextField();
		txt_NgaySanXuat.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txt_NgaySanXuat.setColumns(10);
		GroupLayout gl_panel_3_3 = new GroupLayout(panel_3_3);
		gl_panel_3_3.setHorizontalGroup(gl_panel_3_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3_3.createSequentialGroup().addComponent(lblNewLabel_2_3).addGap(18)
						.addComponent(txt_NgaySanXuat, GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)));
		gl_panel_3_3.setVerticalGroup(gl_panel_3_3.createParallelGroup(Alignment.LEADING)
				.addComponent(lblNewLabel_2_3, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
				.addComponent(txt_NgaySanXuat, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE));
		panel_3_3.setLayout(gl_panel_3_3);

		JPanel panel_3_4 = new JPanel();
		panel_ThongTinSanPham.add(panel_3_4);

		JLabel lblNewLabel_2_4 = new JLabel("Số lượng:");
		lblNewLabel_2_4.setBorder(BorderFactory.createCompoundBorder(lblNewLabel_2_4.getBorder(),
				BorderFactory.createEmptyBorder(0, 10, 0, 0)));
		lblNewLabel_2_4.setFont(new Font("Tahoma", Font.PLAIN, 18));

		txt_SoLuong = new JTextField();
		txt_SoLuong.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txt_SoLuong.setColumns(10);
		GroupLayout gl_panel_3_4 = new GroupLayout(panel_3_4);
		gl_panel_3_4.setHorizontalGroup(gl_panel_3_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3_4.createSequentialGroup().addComponent(lblNewLabel_2_4).addGap(18)
						.addComponent(txt_SoLuong, GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)));
		gl_panel_3_4.setVerticalGroup(gl_panel_3_4.createParallelGroup(Alignment.LEADING)
				.addComponent(lblNewLabel_2_4, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
				.addComponent(txt_SoLuong, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE));
		panel_3_4.setLayout(gl_panel_3_4);

		JPanel panel_3_5 = new JPanel();
		panel_ThongTinSanPham.add(panel_3_5);

		JLabel lblNewLabel_2_5 = new JLabel("Hạn sử dụng:");
		lblNewLabel_2_5.setBorder(BorderFactory.createCompoundBorder(lblNewLabel_2_5.getBorder(),
				BorderFactory.createEmptyBorder(0, 10, 0, 0)));
		lblNewLabel_2_5.setFont(new Font("Tahoma", Font.PLAIN, 18));

		txt_HanSuDung = new JTextField();
		txt_HanSuDung.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txt_HanSuDung.setColumns(10);
		GroupLayout gl_panel_3_5 = new GroupLayout(panel_3_5);
		gl_panel_3_5.setHorizontalGroup(gl_panel_3_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3_5.createSequentialGroup().addComponent(lblNewLabel_2_5).addGap(18)
						.addComponent(txt_HanSuDung, GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)));
		gl_panel_3_5.setVerticalGroup(gl_panel_3_5.createParallelGroup(Alignment.LEADING)
				.addComponent(lblNewLabel_2_5, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
				.addComponent(txt_HanSuDung, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE));
		panel_3_5.setLayout(gl_panel_3_5);

		JScrollPane scrollPane = new JScrollPane();

		GroupLayout gl_panel_Bang = new GroupLayout(panel_Bang);
		gl_panel_Bang.setHorizontalGroup(
				gl_panel_Bang.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_Bang.createSequentialGroup()
						.addContainerGap().addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1014, Short.MAX_VALUE)));
		gl_panel_Bang.setVerticalGroup(gl_panel_Bang.createParallelGroup(Alignment.LEADING).addComponent(scrollPane,
				Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE));

		model_HangHoa = new DefaultTableModel(new Object[][] {},
				new String[] { "M\u00E3 s\u1EA3n ph\u1EA9m", "T\u00EAn s\u1EA3n ph\u1EA9m",
						"Nh\u00E0 s\u1EA3n xu\u1EA5t", "S\u1ED1 l\u01B0\u1EE3ng", "Gi\u00E1 b\u00E1n",
						"Ng\u00E0y s\u1EA3n xu\u1EA5t", "H\u1EA1n s\u1EED d\u1EE5ng" });
		table_HangHoa = new JTable(model_HangHoa);
		scrollPane.setViewportView(table_HangHoa);
		taoBang(table_HangHoa);

		panel_Bang.setLayout(gl_panel_Bang);

		txt_HangCanTim_Kho = new JTextField();
		txt_HangCanTim_Kho.setForeground(Color.GRAY);
		txt_HangCanTim_Kho.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txt_HangCanTim_Kho.setText("Nhập tên mặt hàng cần tìm...");
		txt_HangCanTim_Kho.setColumns(10);
		txt_HangCanTim_Kho.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txt_HangCanTim_Kho.getText().equals("Nhập tên mặt hàng cần tìm...")) {
					txt_HangCanTim_Kho.setText("");
					placeholder.removePlaceholerStyle(txt_HangCanTim_Kho);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txt_HangCanTim_Kho.getText().length() == 0) {
					txt_HangCanTim_Kho.setText("Nhập tên mặt hàng cần tìm...");
					placeholder.addPlaceholerStyle(txt_HangCanTim_Kho);
				}
			}
		});

		btn_TimKiem_Kho = new JButton("Tìm kiếm");
		btn_TimKiem_Kho.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_TimKiem_Kho
				.setIcon(new ImageIcon(TrangChu_Vi.class.getResource("/resource/Gakuseisean-Aire-Search.24.png")));
		btn_TimKiem_Kho.setBorderPainted(false);
		btn_TimKiem_Kho.setFocusPainted(false);
		btn_TimKiem_Kho.addMouseListener(mouseListener);
		btn_TimKiem_Kho.setBackground(new Color(25, 55, 109));
		btn_TimKiem_Kho.setForeground(Color.WHITE);
		btn_TimKiem_Kho.setFont(new Font("Tahoma", Font.BOLD, 15));
		GroupLayout gl_panel_TimKiem = new GroupLayout(panel_TimKiem);
		gl_panel_TimKiem.setHorizontalGroup(gl_panel_TimKiem.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_TimKiem.createSequentialGroup().addGap(74)
						.addComponent(txt_HangCanTim_Kho, GroupLayout.PREFERRED_SIZE, 448, GroupLayout.PREFERRED_SIZE)
						.addGap(50).addComponent(btn_TimKiem_Kho).addContainerGap(332, Short.MAX_VALUE)));
		gl_panel_TimKiem.setVerticalGroup(gl_panel_TimKiem.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_TimKiem.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_panel_TimKiem.createParallelGroup(Alignment.BASELINE)
								.addComponent(btn_TimKiem_Kho, GroupLayout.PREFERRED_SIZE, 32,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(txt_HangCanTim_Kho, GroupLayout.PREFERRED_SIZE, 33,
										GroupLayout.PREFERRED_SIZE))));
		panel_TimKiem.setLayout(gl_panel_TimKiem);
		panel_QuanLyKho.setLayout(gl_panel_QuanLyKho);
		
		
		
		
		
		
		
		///////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////////////////////////////////
		JPanel panel_QuanLyBanHang = new JPanel();
		panel_QuanLyBanHang.setBackground(new Color(240, 240, 240));
		panel_CardLayout.add(panel_QuanLyBanHang, "panel_QuanLyBanHang");

		JPanel panel_TimKiem_1 = new JPanel();

		txt_HangCanTim_BanHang = new JTextField();
		txt_HangCanTim_BanHang.setForeground(Color.GRAY);
		txt_HangCanTim_BanHang.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txt_HangCanTim_BanHang.setText("Nhập tên mặt hàng cần tìm...");
		txt_HangCanTim_BanHang.setColumns(10);
		txt_HangCanTim_BanHang.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txt_HangCanTim_BanHang.getText().equals("Nhập tên mặt hàng cần tìm...")) {
					txt_HangCanTim_BanHang.setText("");
					placeholder.removePlaceholerStyle(txt_HangCanTim_BanHang);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txt_HangCanTim_BanHang.getText().length() == 0) {
					txt_HangCanTim_BanHang.setText("Nhập tên mặt hàng cần tìm...");
					placeholder.addPlaceholerStyle(txt_HangCanTim_BanHang);
				}
			}
		});
		
		
		// Trả lại giá trị table nếu không tìm kiếm nữa		
		txt_HangCanTim_BanHang.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				// Xử lý khi có sự thay đổi (xoá)
				if(txt_HangCanTim_BanHang.getText().isEmpty()) {
					while(true) {
						DefaultTableModel modelBangBanHang = (DefaultTableModel) table_HangHoaThanhToan.getModel();
						int soLuongDong = modelBangBanHang.getRowCount();
						if(soLuongDong ==0) {
							break;
						}
						modelBangBanHang.removeRow(0);
						
					}
					HienThiBangBanHang();
				}
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});



		btn_TimKiem_BanHang = new JButton("Tìm kiếm");
		btn_TimKiem_BanHang.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_TimKiem_BanHang.addActionListener(qlbhController);
		btn_TimKiem_BanHang.addMouseListener(mouseListener);
		btn_TimKiem_BanHang
				.setIcon(new ImageIcon(TrangChu_Vi.class.getResource("/resource/Gakuseisean-Aire-Search.24.png")));
		btn_TimKiem_BanHang.setForeground(Color.WHITE);
		btn_TimKiem_BanHang.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_TimKiem_BanHang.setFocusPainted(false);
		btn_TimKiem_BanHang.setBorderPainted(false);
		btn_TimKiem_BanHang.setBackground(new Color(25, 55, 109));
		GroupLayout gl_panel_TimKiem_1 = new GroupLayout(panel_TimKiem_1);
		gl_panel_TimKiem_1.setHorizontalGroup(gl_panel_TimKiem_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_TimKiem_1.createSequentialGroup().addGap(74)
						.addComponent(txt_HangCanTim_BanHang, GroupLayout.PREFERRED_SIZE, 448,
								GroupLayout.PREFERRED_SIZE)
						.addGap(50).addComponent(btn_TimKiem_BanHang).addContainerGap(332, Short.MAX_VALUE)));
		gl_panel_TimKiem_1.setVerticalGroup(gl_panel_TimKiem_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_TimKiem_1.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_panel_TimKiem_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(txt_HangCanTim_BanHang, GroupLayout.PREFERRED_SIZE, 33,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btn_TimKiem_BanHang, GroupLayout.PREFERRED_SIZE, 32,
										GroupLayout.PREFERRED_SIZE))));
		panel_TimKiem_1.setLayout(gl_panel_TimKiem_1);

		JPanel panel_Bang_1 = new JPanel();
//
		JScrollPane scrollPane_1 = new JScrollPane();
		GroupLayout gl_panel_Bang_1 = new GroupLayout(panel_Bang_1);
		gl_panel_Bang_1.setHorizontalGroup(gl_panel_Bang_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_Bang_1.createSequentialGroup().addContainerGap().addComponent(scrollPane_1,
						GroupLayout.DEFAULT_SIZE, 1014, Short.MAX_VALUE)));
		gl_panel_Bang_1.setVerticalGroup(gl_panel_Bang_1.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE));

		model_HangHoaThanhToan = new DefaultTableModel(new Object[][] {},
				new String[] { "M\u00E3 s\u1EA3n ph\u1EA9m", "T\u00EAn s\u1EA3n ph\u1EA9m",
						"Nh\u00E0 s\u1EA3n xu\u1EA5t", "S\u1ED1 l\u01B0\u1EE3ng", "Gi\u00E1 b\u00E1n",
						"Ng\u00E0y s\u1EA3n xu\u1EA5t", "H\u1EA1n s\u1EED d\u1EE5ng" });
		table_HangHoaThanhToan = new JTable(model_HangHoaThanhToan);
		scrollPane_1.setViewportView(table_HangHoaThanhToan);
		taoBang(table_HangHoaThanhToan);

		panel_Bang_1.setLayout(gl_panel_Bang_1);

		btn_ThanhToan = new JButton("Thanh toán");
		btn_ThanhToan.addActionListener(actionListener);
		btn_ThanhToan.addActionListener(qlbhController);
		btn_ThanhToan.addMouseListener(mouseListener);
		btn_ThanhToan.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_ThanhToan.setIcon(new ImageIcon(TrangChu_Vi.class.getResource("/resource/money_1078670.png")));
		btn_ThanhToan.setForeground(Color.WHITE);
		btn_ThanhToan.setBackground(color.color_ManHinhChinh_XanhDuongDam);
		btn_ThanhToan.setBorderPainted(false);
		btn_ThanhToan.setFocusPainted(false);
		btn_ThanhToan.setFont(new Font("Tahoma", Font.BOLD, 18));
		GroupLayout gl_panel_QuanLyBanHang = new GroupLayout(panel_QuanLyBanHang);
		gl_panel_QuanLyBanHang.setHorizontalGroup(
			gl_panel_QuanLyBanHang.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_TimKiem_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addComponent(panel_Bang_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addGroup(gl_panel_QuanLyBanHang.createSequentialGroup()
					.addGap(808)
					.addComponent(btn_ThanhToan, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel_QuanLyBanHang.setVerticalGroup(
			gl_panel_QuanLyBanHang.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_QuanLyBanHang.createSequentialGroup()
					.addComponent(panel_TimKiem_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_Bang_1, GroupLayout.PREFERRED_SIZE, 568, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btn_ThanhToan, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
		);
		panel_QuanLyBanHang.setLayout(gl_panel_QuanLyBanHang);

		
		

		
		
		

//---------------------------------------------------------------		
		JPanel panel_ThongKe = new JPanel();
		panel_ThongKe.setBackground(new Color(240, 240, 240));
		panel_CardLayout.add(panel_ThongKe, "name_744579175876900");

		JPanel panel_TimKiem_1_2 = new JPanel();

		txt_HangCanTim_ThongKe = new JTextField();
		txt_HangCanTim_ThongKe.setText("Nhập tên mặt hàng cần tìm...");
		txt_HangCanTim_ThongKe.setForeground(Color.GRAY);
		txt_HangCanTim_ThongKe.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txt_HangCanTim_ThongKe.setColumns(10);
		txt_HangCanTim_ThongKe.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txt_HangCanTim_ThongKe.getText().equals("Nhập tên mặt hàng cần tìm...")) {
					txt_HangCanTim_ThongKe.setText("");
					placeholder.removePlaceholerStyle(txt_HangCanTim_ThongKe);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txt_HangCanTim_ThongKe.getText().length() == 0) {
					txt_HangCanTim_ThongKe.setText("Nhập tên mặt hàng cần tìm...");
					placeholder.addPlaceholerStyle(txt_HangCanTim_ThongKe);
				}
			}
		});

		btn_TimKiem_ThongKe = new JButton("Tìm kiếm");
		btn_TimKiem_ThongKe.addMouseListener(mouseListener);
		btn_TimKiem_ThongKe.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_TimKiem_ThongKe
				.setIcon(new ImageIcon(TrangChu_Vi.class.getResource("/resource/Gakuseisean-Aire-Search.24.png")));
		btn_TimKiem_ThongKe.setForeground(Color.WHITE);
		btn_TimKiem_ThongKe.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_TimKiem_ThongKe.setFocusPainted(false);
		btn_TimKiem_ThongKe.setBorderPainted(false);
		btn_TimKiem_ThongKe.setBackground(new Color(25, 55, 109));
		GroupLayout gl_panel_TimKiem_1_2 = new GroupLayout(panel_TimKiem_1_2);
		gl_panel_TimKiem_1_2.setHorizontalGroup(gl_panel_TimKiem_1_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_TimKiem_1_2.createSequentialGroup().addGap(74)
						.addComponent(txt_HangCanTim_ThongKe, GroupLayout.PREFERRED_SIZE, 448,
								GroupLayout.PREFERRED_SIZE)
						.addGap(49).addComponent(btn_TimKiem_ThongKe).addContainerGap(323, Short.MAX_VALUE)));
		gl_panel_TimKiem_1_2.setVerticalGroup(gl_panel_TimKiem_1_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_TimKiem_1_2.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_panel_TimKiem_1_2.createParallelGroup(Alignment.BASELINE)
								.addComponent(txt_HangCanTim_ThongKe, GroupLayout.PREFERRED_SIZE, 33,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btn_TimKiem_ThongKe, GroupLayout.PREFERRED_SIZE, 32,
										GroupLayout.PREFERRED_SIZE))));
		panel_TimKiem_1_2.setLayout(gl_panel_TimKiem_1_2);

		JPanel panel_5 = new JPanel();

		btn_Xoa_ThongKe = new JButton("Xóa");
		btn_Xoa_ThongKe.addMouseListener(mouseListener);
		btn_Xoa_ThongKe.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_Xoa_ThongKe.setIcon(
				new ImageIcon(TrangChu_Vi.class.getResource("/resource/Hopstarter-Button-Button-Delete.24.png")));
		btn_Xoa_ThongKe.setForeground(Color.WHITE);
		btn_Xoa_ThongKe.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn_Xoa_ThongKe.setFocusPainted(false);
		btn_Xoa_ThongKe.setBorderPainted(false);
		btn_Xoa_ThongKe.setBackground(new Color(25, 55, 109));

		JPanel panel_Bang_2 = new JPanel();

		JScrollPane scrollPane_2 = new JScrollPane();
		GroupLayout gl_panel_Bang_2 = new GroupLayout(panel_Bang_2);
		gl_panel_Bang_2.setHorizontalGroup(gl_panel_Bang_2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 1024, Short.MAX_VALUE).addGroup(gl_panel_Bang_2.createSequentialGroup().addContainerGap()
						.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 1014, Short.MAX_VALUE)));
		gl_panel_Bang_2.setVerticalGroup(
				gl_panel_Bang_2.createParallelGroup(Alignment.LEADING).addGap(0, 309, Short.MAX_VALUE).addComponent(
						scrollPane_2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE));

		model_HangHoaLoc = new DefaultTableModel(new Object[][] {},
				new String[] { "M\u00E3 s\u1EA3n ph\u1EA9m", "T\u00EAn s\u1EA3n ph\u1EA9m",
						"Nh\u00E0 s\u1EA3n xu\u1EA5t", "S\u1ED1 l\u01B0\u1EE3ng", "Gi\u00E1 b\u00E1n",
						"Ng\u00E0y s\u1EA3n xu\u1EA5t", "H\u1EA1n s\u1EED d\u1EE5ng" });
		table_HangHoaLoc = new JTable(model_HangHoaLoc);
		scrollPane_2.setViewportView(table_HangHoaLoc);
		taoBang(table_HangHoaLoc);

		panel_Bang_2.setLayout(gl_panel_Bang_2);
		GroupLayout gl_panel_ThongKe = new GroupLayout(panel_ThongKe);
		gl_panel_ThongKe
				.setHorizontalGroup(gl_panel_ThongKe.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, 1034, Short.MAX_VALUE)
						.addGroup(gl_panel_ThongKe.createSequentialGroup().addContainerGap(881, Short.MAX_VALUE)
								.addComponent(btn_Xoa_ThongKe, GroupLayout.PREFERRED_SIZE, 143,
										GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
						.addGroup(gl_panel_ThongKe.createSequentialGroup()
								.addComponent(panel_Bang_2, GroupLayout.DEFAULT_SIZE, 1024, Short.MAX_VALUE)
								.addContainerGap())
						.addGroup(gl_panel_ThongKe.createSequentialGroup()
								.addComponent(panel_TimKiem_1_2, GroupLayout.DEFAULT_SIZE, 1034, Short.MAX_VALUE)
								.addContainerGap()));
		gl_panel_ThongKe.setVerticalGroup(gl_panel_ThongKe.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_ThongKe.createSequentialGroup()
						.addComponent(panel_TimKiem_1_2, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(panel_Bang_2, GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE).addGap(18)
						.addComponent(btn_Xoa_ThongKe, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));

		String luaChonLoc[] = { "Lọc danh sách những sản phẩm đã quá hạn sử dụng",
				"Lọc top 20 sản phẩm có số lượng nhỏ nhất trong kho",
				"Lọc top 20 sản phẩm có số lượng lớn nhất trong kho",
				"Lọc top 20 sản phẩm có ngày sản xuất gần với ngày hiện tại nhất" };
		JComboBox comboBox_Loc = new JComboBox(luaChonLoc);
		comboBox_Loc.setFont(new Font("Tahoma", Font.PLAIN, 17));

		btn_Loc = new JButton("Lọc");
		btn_Loc.addMouseListener(mouseListener);
		btn_Loc.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_Loc.setIcon(new ImageIcon(TrangChu_Vi.class.getResource("/resource/filter.png")));
		btn_Loc.setForeground(Color.WHITE);
		btn_Loc.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn_Loc.setFocusPainted(false);
		btn_Loc.setBorderPainted(false);
		btn_Loc.setBackground(new Color(25, 55, 109));
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup().addGap(74)
						.addComponent(comboBox_Loc, GroupLayout.PREFERRED_SIZE, 516, GroupLayout.PREFERRED_SIZE)
						.addGap(29).addComponent(btn_Loc, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(272, Short.MAX_VALUE)));
		gl_panel_5.setVerticalGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel_5.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBox_Loc, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
								.addComponent(btn_Loc, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));
		panel_5.setLayout(gl_panel_5);
		panel_ThongKe.setLayout(gl_panel_ThongKe);

		JPanel panel_DoanhThu = new JPanel();
		panel_DoanhThu.setBackground(new Color(240, 240, 240));
		panel_CardLayout.add(panel_DoanhThu, "name_744579196753200");

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout gl_panel_DoanhThu = new GroupLayout(panel_DoanhThu);
		gl_panel_DoanhThu.setHorizontalGroup(gl_panel_DoanhThu.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 1034, Short.MAX_VALUE));
		gl_panel_DoanhThu.setVerticalGroup(gl_panel_DoanhThu.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 675, Short.MAX_VALUE));

		JPanel panel_DoanhThuNgay = new JPanel();
		tabbedPane.addTab("Tính doanh thu theo ngày", null, panel_DoanhThuNgay, null);

		JPanel panel_TimKiem_2 = new JPanel();

		txt_DoanhThuNgay = new JTextField();
		txt_DoanhThuNgay.setText("Nhập ngày cần thống kê doanh thu");
		txt_DoanhThuNgay.setForeground(Color.GRAY);
		txt_DoanhThuNgay.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_DoanhThuNgay.setColumns(10);
		txt_DoanhThuNgay.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txt_DoanhThuNgay.getText().equals("Nhập ngày cần thống kê doanh thu")) {
					txt_DoanhThuNgay.setText("");
					txt_DoanhThuNgay.setForeground(Color.black);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txt_DoanhThuNgay.getText().length() == 0) {
					txt_DoanhThuNgay.setText("Nhập ngày cần thống kê doanh thu");
					txt_DoanhThuNgay.setForeground(Color.gray);
				}
			}
		});

		btn_DoanhThuNgay = new JButton("Thống kê");
		btn_DoanhThuNgay.addMouseListener(mouseListener);
		btn_DoanhThuNgay.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_DoanhThuNgay.setIcon(new ImageIcon(
				TrangChu_Vi.class.getResource("/resource/Graphicloads-Flat-Finance-Dollar-stats.24.png")));
		btn_DoanhThuNgay.setForeground(Color.WHITE);
		btn_DoanhThuNgay.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_DoanhThuNgay.setFocusPainted(false);
		btn_DoanhThuNgay.setBorderPainted(false);
		btn_DoanhThuNgay.setBackground(new Color(25, 55, 109));
		GroupLayout gl_panel_TimKiem_2 = new GroupLayout(panel_TimKiem_2);
		gl_panel_TimKiem_2.setHorizontalGroup(gl_panel_TimKiem_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_TimKiem_2.createSequentialGroup().addGap(74)
						.addComponent(txt_DoanhThuNgay, GroupLayout.PREFERRED_SIZE, 266, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(btn_DoanhThuNgay, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(523, Short.MAX_VALUE)));
		gl_panel_TimKiem_2.setVerticalGroup(gl_panel_TimKiem_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_TimKiem_2.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_panel_TimKiem_2.createParallelGroup(Alignment.BASELINE)
								.addComponent(txt_DoanhThuNgay, GroupLayout.PREFERRED_SIZE, 33,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btn_DoanhThuNgay, GroupLayout.PREFERRED_SIZE, 32,
										GroupLayout.PREFERRED_SIZE))));
		panel_TimKiem_2.setLayout(gl_panel_TimKiem_2);

		JPanel panel_Bang_3 = new JPanel();

		JScrollPane scrollPane_3 = new JScrollPane();
		GroupLayout gl_panel_Bang_3 = new GroupLayout(panel_Bang_3);
		gl_panel_Bang_3.setHorizontalGroup(gl_panel_Bang_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_Bang_3.createSequentialGroup().addContainerGap()
						.addComponent(scrollPane_3, GroupLayout.DEFAULT_SIZE, 1014, Short.MAX_VALUE)
						.addContainerGap()));
		gl_panel_Bang_3.setVerticalGroup(gl_panel_Bang_3.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane_3, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE));

		model_DoanhThuNgay = new DefaultTableModel(new Object[][] {},
				new String[] { "M\u00E3 s\u1EA3n ph\u1EA9m", "T\u00EAn s\u1EA3n ph\u1EA9m",
						"Nh\u00E0 s\u1EA3n xu\u1EA5t", "S\u1ED1 l\u01B0\u1EE3ng", "T\u1ED5ng c\u1ED9ng",
						"Ng\u00E0y b\u00E1n" });
		table_DoanhThuNgay = new JTable(model_DoanhThuNgay);
		scrollPane_3.setViewportView(table_DoanhThuNgay);
		table_DoanhThuNgay.setRowHeight(30);
		table_DoanhThuNgay.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table_DoanhThuNgay.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 15));
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		table_DoanhThuNgay.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		table_DoanhThuNgay.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);

		table_DoanhThuNgay.getColumnModel().getColumn(0).setPreferredWidth(150);
		table_DoanhThuNgay.getColumnModel().getColumn(1).setPreferredWidth(400);
		table_DoanhThuNgay.getColumnModel().getColumn(2).setPreferredWidth(250);
		table_DoanhThuNgay.getColumnModel().getColumn(3).setPreferredWidth(102);
		table_DoanhThuNgay.getColumnModel().getColumn(4).setPreferredWidth(150);
		table_DoanhThuNgay.getColumnModel().getColumn(5).setPreferredWidth(150);

		panel_Bang_3.setLayout(gl_panel_Bang_3);

		JPanel panel_2_1 = new JPanel();

		JLabel lblNewLabel_5_2 = new JLabel("Doanh thu ngày");
		lblNewLabel_5_2.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel lbl_TienDoanhThuNgay = new JLabel("(ghi số tiền vào đây)");
		lbl_TienDoanhThuNgay.setForeground(new Color(0, 128, 0));
		lbl_TienDoanhThuNgay.setFont(new Font("Tahoma", Font.BOLD, 18));

		JLabel text_Ngay = new JLabel("dd/mm/yyyy:");
		text_Ngay.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GroupLayout gl_panel_2_1 = new GroupLayout(panel_2_1);
		gl_panel_2_1.setHorizontalGroup(gl_panel_2_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2_1.createSequentialGroup().addContainerGap(377, Short.MAX_VALUE)
						.addComponent(lblNewLabel_5_2).addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(text_Ngay, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
						.addGap(121)
						.addComponent(lbl_TienDoanhThuNgay, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		gl_panel_2_1.setVerticalGroup(gl_panel_2_1.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_2_1
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panel_2_1.createParallelGroup(Alignment.LEADING).addComponent(lbl_TienDoanhThuNgay)
						.addGroup(gl_panel_2_1.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_5_2)
								.addComponent(text_Ngay, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(12, Short.MAX_VALUE)));
		panel_2_1.setLayout(gl_panel_2_1);
		GroupLayout gl_panel_DoanhThuNgay = new GroupLayout(panel_DoanhThuNgay);
		gl_panel_DoanhThuNgay.setHorizontalGroup(gl_panel_DoanhThuNgay.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_DoanhThuNgay.createSequentialGroup()
						.addComponent(panel_TimKiem_2, GroupLayout.DEFAULT_SIZE, 1024, Short.MAX_VALUE)
						.addContainerGap())
				.addComponent(panel_Bang_3, GroupLayout.DEFAULT_SIZE, 1034, Short.MAX_VALUE)
				.addGroup(gl_panel_DoanhThuNgay.createSequentialGroup().addGap(10)
						.addComponent(panel_2_1, GroupLayout.DEFAULT_SIZE, 1014, Short.MAX_VALUE).addContainerGap()));
		gl_panel_DoanhThuNgay.setVerticalGroup(gl_panel_DoanhThuNgay.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_DoanhThuNgay.createSequentialGroup()
						.addComponent(panel_TimKiem_2, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel_Bang_3, GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE).addGap(18)
						.addComponent(panel_2_1, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));

		panel_DoanhThuNgay.setLayout(gl_panel_DoanhThuNgay);

		JPanel panel_DoanhThuThang = new JPanel();
		tabbedPane.addTab("Tính doanh thu theo tháng", null, panel_DoanhThuThang, null);

		JPanel panel_TimKiem_2_1 = new JPanel();

		txt_DoanhThuThang = new JTextField();
		txt_DoanhThuThang.setText("Nhập tháng cần thống kê doanh thu");
		txt_DoanhThuThang.setForeground(Color.GRAY);
		txt_DoanhThuThang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_DoanhThuThang.setColumns(10);
		txt_DoanhThuThang.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txt_DoanhThuThang.getText().equals("Nhập tháng cần thống kê doanh thu")) {
					txt_DoanhThuThang.setText("");
					txt_DoanhThuThang.setForeground(Color.black);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txt_DoanhThuThang.getText().length() == 0) {
					txt_DoanhThuThang.setText("Nhập tháng cần thống kê doanh thu");
					txt_DoanhThuThang.setForeground(Color.gray);
				}
			}
		});

		btn_DoanhThuThang = new JButton("Thống kê");
		btn_DoanhThuThang.addMouseListener(mouseListener);
		btn_DoanhThuThang.setIcon(new ImageIcon(
				TrangChu_Vi.class.getResource("/resource/Graphicloads-Flat-Finance-Dollar-stats.24.png")));
		btn_DoanhThuThang.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_DoanhThuThang.setForeground(Color.WHITE);
		btn_DoanhThuThang.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_DoanhThuThang.setFocusPainted(false);
		btn_DoanhThuThang.setBorderPainted(false);
		btn_DoanhThuThang.setBackground(new Color(25, 55, 109));
		GroupLayout gl_panel_TimKiem_2_1 = new GroupLayout(panel_TimKiem_2_1);
		gl_panel_TimKiem_2_1.setHorizontalGroup(gl_panel_TimKiem_2_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_TimKiem_2_1.createSequentialGroup().addGap(74)
						.addComponent(txt_DoanhThuThang, GroupLayout.PREFERRED_SIZE, 266, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(btn_DoanhThuThang, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(523, Short.MAX_VALUE)));
		gl_panel_TimKiem_2_1.setVerticalGroup(gl_panel_TimKiem_2_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_TimKiem_2_1.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_panel_TimKiem_2_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(txt_DoanhThuThang, GroupLayout.PREFERRED_SIZE, 33,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btn_DoanhThuThang, GroupLayout.PREFERRED_SIZE, 32,
										GroupLayout.PREFERRED_SIZE))));
		panel_TimKiem_2_1.setLayout(gl_panel_TimKiem_2_1);

		JPanel panel_Bang_3_1 = new JPanel();

		JScrollPane scrollPane_3_1 = new JScrollPane();
		GroupLayout gl_panel_Bang_3_1 = new GroupLayout(panel_Bang_3_1);
		gl_panel_Bang_3_1.setHorizontalGroup(
				gl_panel_Bang_3_1.createParallelGroup(Alignment.LEADING).addGap(0, 1029, Short.MAX_VALUE)
						.addGroup(gl_panel_Bang_3_1.createSequentialGroup().addContainerGap()
								.addComponent(scrollPane_3_1, GroupLayout.DEFAULT_SIZE, 1009, Short.MAX_VALUE)
								.addContainerGap()));
		gl_panel_Bang_3_1.setVerticalGroup(
				gl_panel_Bang_3_1.createParallelGroup(Alignment.LEADING).addGap(0, 524, Short.MAX_VALUE).addComponent(
						scrollPane_3_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE));

		model_DoanhThuThang = new DefaultTableModel(new Object[][] {},
				new String[] { "M\u00E3 s\u1EA3n ph\u1EA9m", "T\u00EAn s\u1EA3n ph\u1EA9m",
						"Nh\u00E0 s\u1EA3n xu\u1EA5t", "S\u1ED1 l\u01B0\u1EE3ng", "T\u1ED5ng c\u1ED9ng",
						"Ng\u00E0y b\u00E1n" });
		table_DoanhThuThang = new JTable(model_DoanhThuThang);
		scrollPane_3_1.setViewportView(table_DoanhThuThang);
		table_DoanhThuThang.setRowHeight(30);
		table_DoanhThuThang.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table_DoanhThuThang.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 15));
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		table_DoanhThuThang.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		table_DoanhThuThang.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);

		table_DoanhThuThang.getColumnModel().getColumn(0).setPreferredWidth(150);
		table_DoanhThuThang.getColumnModel().getColumn(1).setPreferredWidth(400);
		table_DoanhThuThang.getColumnModel().getColumn(2).setPreferredWidth(250);
		table_DoanhThuThang.getColumnModel().getColumn(3).setPreferredWidth(102);
		table_DoanhThuThang.getColumnModel().getColumn(4).setPreferredWidth(150);
		table_DoanhThuThang.getColumnModel().getColumn(5).setPreferredWidth(150);

		panel_Bang_3_1.setLayout(gl_panel_Bang_3_1);

		JPanel panel_2_1_1 = new JPanel();

		JLabel lblNewLabel_5_2_2 = new JLabel("Doanh thu tháng");
		lblNewLabel_5_2_2.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel text_Thang = new JLabel("(month):");
		text_Thang.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel lbl_TienDoanhThuThang = new JLabel("(ghi số tiền vào đây)");
		lbl_TienDoanhThuThang.setForeground(new Color(0, 128, 0));
		lbl_TienDoanhThuThang.setFont(new Font("Tahoma", Font.BOLD, 18));
		GroupLayout gl_panel_2_1_1 = new GroupLayout(panel_2_1_1);
		gl_panel_2_1_1.setHorizontalGroup(
				gl_panel_2_1_1.createParallelGroup(Alignment.TRAILING).addGap(0, 1009, Short.MAX_VALUE)
						.addGroup(gl_panel_2_1_1.createSequentialGroup().addContainerGap(372, Short.MAX_VALUE)
								.addComponent(lblNewLabel_5_2_2).addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(text_Thang, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
								.addGap(121).addComponent(lbl_TienDoanhThuThang, GroupLayout.PREFERRED_SIZE, 203,
										GroupLayout.PREFERRED_SIZE)
								.addContainerGap()));
		gl_panel_2_1_1.setVerticalGroup(gl_panel_2_1_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 47, Short.MAX_VALUE)
				.addGroup(gl_panel_2_1_1.createSequentialGroup().addContainerGap().addGroup(gl_panel_2_1_1
						.createParallelGroup(Alignment.LEADING).addComponent(lbl_TienDoanhThuThang)
						.addGroup(gl_panel_2_1_1.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_5_2_2)
								.addComponent(text_Thang, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(12, Short.MAX_VALUE)));
		panel_2_1_1.setLayout(gl_panel_2_1_1);
		GroupLayout gl_panel_DoanhThuThang = new GroupLayout(panel_DoanhThuThang);
		gl_panel_DoanhThuThang
				.setHorizontalGroup(
						gl_panel_DoanhThuThang.createParallelGroup(Alignment.LEADING).addGap(0, 1029, Short.MAX_VALUE)
								.addGroup(gl_panel_DoanhThuThang.createSequentialGroup()
										.addComponent(panel_TimKiem_2_1, GroupLayout.DEFAULT_SIZE, 1019,
												Short.MAX_VALUE)
										.addContainerGap())
								.addComponent(panel_Bang_3_1, GroupLayout.DEFAULT_SIZE, 1029, Short.MAX_VALUE)
								.addGroup(gl_panel_DoanhThuThang.createSequentialGroup().addGap(10)
										.addComponent(panel_2_1_1, GroupLayout.DEFAULT_SIZE, 1009, Short.MAX_VALUE)
										.addContainerGap()));
		gl_panel_DoanhThuThang.setVerticalGroup(gl_panel_DoanhThuThang.createParallelGroup(Alignment.LEADING)
				.addGap(0, 648, Short.MAX_VALUE)
				.addGroup(gl_panel_DoanhThuThang.createSequentialGroup()
						.addComponent(panel_TimKiem_2_1, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel_Bang_3_1, GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE).addGap(18)
						.addComponent(panel_2_1_1, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		panel_DoanhThuThang.setLayout(gl_panel_DoanhThuThang);

		JPanel panel_DoanhThuNam = new JPanel();
		tabbedPane.addTab("Tính doanh thu theo năm", null, panel_DoanhThuNam, null);

		JPanel panel_Bang_3_2 = new JPanel();

		JScrollPane scrollPane_3_2 = new JScrollPane();
		GroupLayout gl_panel_Bang_3_2 = new GroupLayout(panel_Bang_3_2);
		gl_panel_Bang_3_2.setHorizontalGroup(
				gl_panel_Bang_3_2.createParallelGroup(Alignment.LEADING).addGap(0, 1029, Short.MAX_VALUE)
						.addGroup(gl_panel_Bang_3_2.createSequentialGroup().addContainerGap()
								.addComponent(scrollPane_3_2, GroupLayout.DEFAULT_SIZE, 1009, Short.MAX_VALUE)
								.addContainerGap()));
		gl_panel_Bang_3_2.setVerticalGroup(
				gl_panel_Bang_3_2.createParallelGroup(Alignment.LEADING).addGap(0, 524, Short.MAX_VALUE).addComponent(
						scrollPane_3_2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE));

		model_DoanhThuNam = new DefaultTableModel(new Object[][] {},
				new String[] { "M\u00E3 s\u1EA3n ph\u1EA9m", "T\u00EAn s\u1EA3n ph\u1EA9m",
						"Nh\u00E0 s\u1EA3n xu\u1EA5t", "S\u1ED1 l\u01B0\u1EE3ng", "T\u1ED5ng c\u1ED9ng",
						"Ng\u00E0y b\u00E1n" });
		table_DoanhThuNam = new JTable(model_DoanhThuNam);
		scrollPane_3_2.setViewportView(table_DoanhThuNam);
		table_DoanhThuNam.setRowHeight(30);
		table_DoanhThuNam.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table_DoanhThuNam.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 15));
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		table_DoanhThuNam.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		table_DoanhThuNam.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);

		table_DoanhThuNam.getColumnModel().getColumn(0).setPreferredWidth(150);
		table_DoanhThuNam.getColumnModel().getColumn(1).setPreferredWidth(400);
		table_DoanhThuNam.getColumnModel().getColumn(2).setPreferredWidth(250);
		table_DoanhThuNam.getColumnModel().getColumn(3).setPreferredWidth(102);
		table_DoanhThuNam.getColumnModel().getColumn(4).setPreferredWidth(150);
		table_DoanhThuNam.getColumnModel().getColumn(5).setPreferredWidth(150);

		panel_Bang_3_2.setLayout(gl_panel_Bang_3_2);

		JPanel panel_2_1_2 = new JPanel();

		JLabel lblNewLabel_5_2_3 = new JLabel("Doanh thu năm");
		lblNewLabel_5_2_3.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel text_Nam = new JLabel("(year):");
		text_Nam.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel lbl_TienDoanhThuNam = new JLabel("(ghi số tiền vào đây)");
		lbl_TienDoanhThuNam.setForeground(new Color(0, 128, 0));
		lbl_TienDoanhThuNam.setFont(new Font("Tahoma", Font.BOLD, 18));
		GroupLayout gl_panel_2_1_2 = new GroupLayout(panel_2_1_2);
		gl_panel_2_1_2.setHorizontalGroup(gl_panel_2_1_2.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 1009, Short.MAX_VALUE)
				.addGroup(gl_panel_2_1_2.createSequentialGroup().addContainerGap(372, Short.MAX_VALUE)
						.addComponent(lblNewLabel_5_2_3).addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(text_Nam, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE).addGap(121)
						.addComponent(lbl_TienDoanhThuNam, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		gl_panel_2_1_2.setVerticalGroup(gl_panel_2_1_2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 47, Short.MAX_VALUE)
				.addGroup(gl_panel_2_1_2.createSequentialGroup().addContainerGap().addGroup(gl_panel_2_1_2
						.createParallelGroup(Alignment.LEADING).addComponent(lbl_TienDoanhThuNam)
						.addGroup(gl_panel_2_1_2.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_5_2_3)
								.addComponent(text_Nam, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(12, Short.MAX_VALUE)));
		panel_2_1_2.setLayout(gl_panel_2_1_2);

		JPanel panel_TimKiem_2_1_1 = new JPanel();

		txt_DoanhThuNam = new JTextField();
		txt_DoanhThuNam.setText("Nhập năm cần thống kê doanh thu");
		txt_DoanhThuNam.setForeground(Color.GRAY);
		txt_DoanhThuNam.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_DoanhThuNam.setColumns(10);
		txt_DoanhThuNam.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txt_DoanhThuNam.getText().equals("Nhập năm cần thống kê doanh thu")) {
					txt_DoanhThuNam.setText("");
					txt_DoanhThuNam.setForeground(Color.black);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txt_DoanhThuNam.getText().length() == 0) {
					txt_DoanhThuNam.setText("Nhập năm cần thống kê doanh thu");
					txt_DoanhThuNam.setForeground(Color.gray);
				}
			}
		});

		btn_DoanhThuNam = new JButton("Thống kê");
		btn_DoanhThuNam.addMouseListener(mouseListener);
		btn_DoanhThuNam.setIcon(new ImageIcon(
				TrangChu_Vi.class.getResource("/resource/Graphicloads-Flat-Finance-Dollar-stats.24.png")));
		btn_DoanhThuNam.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_DoanhThuNam.setForeground(Color.WHITE);
		btn_DoanhThuNam.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_DoanhThuNam.setFocusPainted(false);
		btn_DoanhThuNam.setBorderPainted(false);
		btn_DoanhThuNam.setBackground(new Color(25, 55, 109));
		GroupLayout gl_panel_TimKiem_2_1_1 = new GroupLayout(panel_TimKiem_2_1_1);
		gl_panel_TimKiem_2_1_1.setHorizontalGroup(gl_panel_TimKiem_2_1_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 1019, Short.MAX_VALUE)
				.addGroup(gl_panel_TimKiem_2_1_1.createSequentialGroup().addGap(74)
						.addComponent(txt_DoanhThuNam, GroupLayout.PREFERRED_SIZE, 266, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(btn_DoanhThuNam, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(523, Short.MAX_VALUE)));
		gl_panel_TimKiem_2_1_1.setVerticalGroup(
				gl_panel_TimKiem_2_1_1.createParallelGroup(Alignment.TRAILING).addGap(0, 43, Short.MAX_VALUE)
						.addGroup(gl_panel_TimKiem_2_1_1.createSequentialGroup()
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(gl_panel_TimKiem_2_1_1.createParallelGroup(Alignment.BASELINE)
										.addComponent(txt_DoanhThuNam, GroupLayout.PREFERRED_SIZE, 33,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(btn_DoanhThuNam, GroupLayout.PREFERRED_SIZE, 32,
												GroupLayout.PREFERRED_SIZE))));
		panel_TimKiem_2_1_1.setLayout(gl_panel_TimKiem_2_1_1);
		GroupLayout gl_panel_DoanhThuNam = new GroupLayout(panel_DoanhThuNam);
		gl_panel_DoanhThuNam.setHorizontalGroup(gl_panel_DoanhThuNam.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_Bang_3_2, GroupLayout.DEFAULT_SIZE, 1029, Short.MAX_VALUE)
				.addGroup(gl_panel_DoanhThuNam.createSequentialGroup().addGap(10)
						.addComponent(panel_2_1_2, GroupLayout.DEFAULT_SIZE, 1009, Short.MAX_VALUE).addContainerGap())
				.addGroup(Alignment.TRAILING,
						gl_panel_DoanhThuNam.createSequentialGroup()
								.addComponent(panel_TimKiem_2_1_1, GroupLayout.DEFAULT_SIZE, 1029, Short.MAX_VALUE)
								.addContainerGap()));
		gl_panel_DoanhThuNam.setVerticalGroup(gl_panel_DoanhThuNam.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_DoanhThuNam.createSequentialGroup()
						.addComponent(panel_TimKiem_2_1_1, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel_Bang_3_2, GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE).addGap(18)
						.addComponent(panel_2_1_2, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		panel_DoanhThuNam.setLayout(gl_panel_DoanhThuNam);
		panel_DoanhThu.setLayout(gl_panel_DoanhThu);

		JPanel panel_XacNhanThanhToan = new JPanel();
		panel_XacNhanThanhToan.setName("panel_XacNhanThanhToan");
		panel_XacNhanThanhToan.setBackground(UIManager.getColor("Button.background"));
		panel_CardLayout.add(panel_XacNhanThanhToan, "name_744579216675900");

		JPanel panel_TimKiem_1_1 = new JPanel();

		
		
		

		
		
		
//////////////////////////////////////////////////////////////////////////////////////////////////////	
		JLabel lblNewLabel_3 = new JLabel("DANH SÁCH CÁC MẶT HÀNG ĐÃ CHỌN:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		GroupLayout gl_panel_TimKiem_1_1 = new GroupLayout(panel_TimKiem_1_1);
		gl_panel_TimKiem_1_1.setHorizontalGroup(gl_panel_TimKiem_1_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_TimKiem_1_1.createSequentialGroup().addGap(43).addComponent(lblNewLabel_3)
						.addContainerGap(629, Short.MAX_VALUE)));
		gl_panel_TimKiem_1_1.setVerticalGroup(
				gl_panel_TimKiem_1_1.createParallelGroup(Alignment.TRAILING).addGroup(gl_panel_TimKiem_1_1
						.createSequentialGroup().addContainerGap(13, Short.MAX_VALUE).addComponent(lblNewLabel_3)));
		panel_TimKiem_1_1.setLayout(gl_panel_TimKiem_1_1);

		JPanel panel_Bang_1_1 = new JPanel();

		JScrollPane scrollPane_1_1 = new JScrollPane();
		GroupLayout gl_panel_Bang_1_1 = new GroupLayout(panel_Bang_1_1);
		gl_panel_Bang_1_1.setHorizontalGroup(gl_panel_Bang_1_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_Bang_1_1.createSequentialGroup().addContainerGap().addComponent(scrollPane_1_1,
						GroupLayout.DEFAULT_SIZE, 1014, Short.MAX_VALUE)));
		gl_panel_Bang_1_1.setVerticalGroup(gl_panel_Bang_1_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_Bang_1_1.createSequentialGroup()
						.addComponent(scrollPane_1_1, GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
						.addContainerGap()));

		model_HangHoaDaChon = new DefaultTableModel(new Object[][] {},
				new String[] { "M\u00E3 s\u1EA3n ph\u1EA9m", "T\u00EAn s\u1EA3n ph\u1EA9m",
						"Nh\u00E0 s\u1EA3n xu\u1EA5t", "S\u1ED1 l\u01B0\u1EE3ng", "Gi\u00E1 b\u00E1n",
						"Ng\u00E0y s\u1EA3n xu\u1EA5t", "H\u1EA1n s\u1EED d\u1EE5ng" });
		table_HangHoaDaChon = new JTable(model_HangHoaDaChon);
		scrollPane_1_1.setViewportView(table_HangHoaDaChon);
		taoBang(table_HangHoaDaChon);

		panel_Bang_1_1.setLayout(gl_panel_Bang_1_1);

		JPanel panel_2 = new JPanel();

		JPanel panel_4 = new JPanel();
		GroupLayout gl_panel_XacNhanThanhToan = new GroupLayout(panel_XacNhanThanhToan);
		gl_panel_XacNhanThanhToan.setHorizontalGroup(gl_panel_XacNhanThanhToan.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_TimKiem_1_1, GroupLayout.DEFAULT_SIZE, 1034, Short.MAX_VALUE)
				.addGroup(gl_panel_XacNhanThanhToan.createSequentialGroup().addContainerGap()
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 1014, Short.MAX_VALUE).addContainerGap())
				.addGroup(gl_panel_XacNhanThanhToan.createSequentialGroup()
						.addComponent(panel_Bang_1_1, GroupLayout.DEFAULT_SIZE, 1024, Short.MAX_VALUE)
						.addContainerGap())
				.addGroup(gl_panel_XacNhanThanhToan.createSequentialGroup().addContainerGap()
						.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 1014, Short.MAX_VALUE).addContainerGap()));
		gl_panel_XacNhanThanhToan.setVerticalGroup(gl_panel_XacNhanThanhToan.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_XacNhanThanhToan.createSequentialGroup()
						.addComponent(panel_TimKiem_1_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(panel_Bang_1_1, GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));

		btn_XoaHang = new JButton("Xóa hàng");
		btn_XoaHang.addActionListener(qlbhController);
		btn_XoaHang.addMouseListener(mouseListener);
		btn_XoaHang.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_XoaHang.setForeground(Color.WHITE);
		btn_XoaHang.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_XoaHang.setFocusPainted(false);
		btn_XoaHang.setBorderPainted(false);
		btn_XoaHang.setBackground(Color.RED);

		JLabel lblNewLabel_5_1 = new JLabel("Sửa số lượng cần mua:");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.PLAIN, 20));

		txt_SoLuongCanMua = new JTextField();
		txt_SoLuongCanMua.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txt_SoLuongCanMua.setColumns(10);

		btn_SuaSoLuong = new JButton("Chỉnh sửa");
		btn_SuaSoLuong.addActionListener(qlbhController);
		btn_SuaSoLuong.addMouseListener(mouseListener);
		btn_SuaSoLuong.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_SuaSoLuong.setForeground(Color.WHITE);
		btn_SuaSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_SuaSoLuong.setFocusPainted(false);
		btn_SuaSoLuong.setBorderPainted(false);
		btn_SuaSoLuong.setBackground(color.color_ManHinhChinh_XanhDuongDam);
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(gl_panel_4.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
				gl_panel_4.createSequentialGroup().addContainerGap()
						.addComponent(lblNewLabel_5_1, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
								.addComponent(btn_SuaSoLuong, GroupLayout.PREFERRED_SIZE, 127,
										GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel_4.createSequentialGroup()
										.addComponent(txt_SoLuongCanMua, GroupLayout.PREFERRED_SIZE, 118,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, 510, Short.MAX_VALUE)
										.addComponent(btn_XoaHang, GroupLayout.PREFERRED_SIZE, 121,
												GroupLayout.PREFERRED_SIZE)))
						.addContainerGap()));
		gl_panel_4.setVerticalGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup().addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_4.createSequentialGroup().addContainerGap()
								.addGroup(gl_panel_4.createParallelGroup(Alignment.TRAILING)
										.addComponent(txt_SoLuongCanMua, GroupLayout.PREFERRED_SIZE, 26,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_5_1, GroupLayout.PREFERRED_SIZE, 25,
												GroupLayout.PREFERRED_SIZE)))
						.addComponent(btn_XoaHang, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(btn_SuaSoLuong, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(62, Short.MAX_VALUE)));
		panel_4.setLayout(gl_panel_4);

		btn_XacNhan = new JButton("Xác nhận");
		btn_XacNhan.addActionListener(qlbhController);
		btn_XacNhan.addMouseListener(mouseListener);
		btn_XacNhan.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_XacNhan.setIcon(new ImageIcon(TrangChu_Vi.class.getResource("/resource/check_6785304.png")));
		btn_XacNhan.setForeground(Color.WHITE);
		btn_XacNhan.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn_XacNhan.setFocusPainted(false);
		btn_XacNhan.setBorderPainted(false);
		btn_XacNhan.setBackground(new Color(25, 55, 109));

		lbl_SoTienThanhToan = new JLabel();
		lbl_SoTienThanhToan.setForeground(new Color(0, 128, 0));
		lbl_SoTienThanhToan.setFont(new Font("Tahoma", Font.BOLD, 18));

		JLabel lblNewLabel_5 = new JLabel("Số tiền cần thanh toán:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));

		btn_TroLai = new JButton("Trở lại");
		btn_XacNhan.addActionListener(qlbhController);
		btn_TroLai.addActionListener(actionListener);
		btn_TroLai.addMouseListener(mouseListener);
		btn_TroLai.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_TroLai.setIcon(new ImageIcon(TrangChu_Vi.class.getResource("/resource/back.png")));
		btn_TroLai.setForeground(Color.WHITE);
		btn_TroLai.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn_TroLai.setFocusPainted(false);
		btn_TroLai.setBorderPainted(false);
		btn_TroLai.setBackground(new Color(25, 55, 109));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
						.addComponent(btn_TroLai, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 272, Short.MAX_VALUE).addComponent(lblNewLabel_5)
						.addGap(18)
						.addComponent(lbl_SoTienThanhToan, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(btn_XacNhan, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		gl_panel_2.setVerticalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup().addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
								.addComponent(btn_XacNhan, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
								.addComponent(lbl_SoTienThanhToan).addComponent(lblNewLabel_5))
						.addGroup(gl_panel_2.createSequentialGroup().addContainerGap().addComponent(btn_TroLai,
								GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panel_2.setLayout(gl_panel_2);
		panel_XacNhanThanhToan.setLayout(gl_panel_XacNhanThanhToan);
		contentPane.setLayout(gl_contentPane);

		
		
		
		
		
		
		///////////////////////////////////////////////////////////////////////
		btn_QuanLyKho = new JButton("QUẢN LÝ KHO");
		btn_QuanLyKho.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_QuanLyKho.setBorderPainted(false);
		btn_QuanLyKho.setHorizontalAlignment(SwingConstants.LEFT);
		btn_QuanLyKho.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn_QuanLyKho.setBorder(new EmptyBorder(0, 10, 0, 0));
		btn_QuanLyKho.setBackground(new Color(25, 55, 109));
		btn_QuanLyKho.setForeground(Color.WHITE);
		btn_QuanLyKho.setIcon(new ImageIcon(TrangChu_Vi.class.getResource("/resource/icons8-warehouse-38.png")));
		btn_QuanLyKho.setPreferredSize(new Dimension(250, 50));
		btn_QuanLyKho.setFocusPainted(false);
		btn_QuanLyKho.addMouseListener(mouseListener);
		btn_QuanLyKho.addActionListener(actionListener);

		btn_QuanLyBanHang = new JButton("QUẢN LÝ BÁN HÀNG");
		btn_QuanLyBanHang.addActionListener(new ActionListener() {
		});
		btn_QuanLyBanHang.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_QuanLyBanHang.setBorderPainted(false);
		btn_QuanLyBanHang.setHorizontalAlignment(SwingConstants.LEFT);
		btn_QuanLyBanHang.setIcon(new ImageIcon(TrangChu_Vi.class.getResource("/resource/icons8-sell-35.png")));
		btn_QuanLyBanHang.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn_QuanLyBanHang.setForeground(Color.WHITE);
		btn_QuanLyBanHang.setBackground(new Color(25, 55, 109));
		btn_QuanLyBanHang.setBorder(new EmptyBorder(0, 10, 0, 0));
		btn_QuanLyBanHang.setPreferredSize(new Dimension(250, 50));
		btn_QuanLyBanHang.setFocusPainted(false);
		btn_QuanLyBanHang.addMouseListener(mouseListener);
		btn_QuanLyBanHang.addActionListener(actionListener);

		btn_ThongKe = new JButton("THỐNG KÊ");
		btn_ThongKe.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_ThongKe.setBorderPainted(false);
		btn_ThongKe.setBorder(new EmptyBorder(0, 10, 0, 0));
		btn_ThongKe.setHorizontalAlignment(SwingConstants.LEFT);
		btn_ThongKe.setBackground(new Color(25, 55, 109));
		btn_ThongKe.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn_ThongKe.setIcon(new ImageIcon(TrangChu_Vi.class.getResource("/resource/icons8-results-40.png")));
		btn_ThongKe.setForeground(Color.WHITE);
		btn_ThongKe.setPreferredSize(new Dimension(250, 50));
		btn_ThongKe.setFocusPainted(false);
		btn_ThongKe.addMouseListener(mouseListener);
		btn_ThongKe.addActionListener(actionListener);

		btn_DoanhThu = new JButton("DOANH THU");
		btn_DoanhThu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_DoanhThu.setBorderPainted(false);
		btn_DoanhThu.setHorizontalAlignment(SwingConstants.LEFT);
		btn_DoanhThu.setIcon(new ImageIcon(TrangChu_Vi.class.getResource("/resource/icons8-dollar-40.png")));
		btn_DoanhThu.setForeground(Color.WHITE);
		btn_DoanhThu.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn_DoanhThu.setBackground(new Color(25, 55, 109));
		btn_DoanhThu.setBorder(new EmptyBorder(0, 10, 0, 0));
		btn_DoanhThu.setPreferredSize(new Dimension(250, 50));
		btn_DoanhThu.setFocusPainted(false);
		btn_DoanhThu.addMouseListener(mouseListener);
		btn_DoanhThu.addActionListener(actionListener);

		btn_DangXuat = new JButton("Đăng xuất");
		btn_DangXuat.addActionListener(actionListener);
		btn_DangXuat.setIcon(new ImageIcon(TrangChu_Vi.class.getResource("/resource/icons8-log-out-20.png")));
		btn_DangXuat.setBorderPainted(false);
		btn_DangXuat.setFocusPainted(false);
		btn_DangXuat.addMouseListener(mouseListener);
		btn_DangXuat.setBackground(Color.RED);
		btn_DangXuat.setForeground(Color.WHITE);
		btn_DangXuat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_DangXuat.setFont(new Font("Tahoma", Font.PLAIN, 15));

		GroupLayout gl_sidePanel = new GroupLayout(sidePanel);
		gl_sidePanel.setHorizontalGroup(gl_sidePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_sidePanel.createSequentialGroup()
						.addGroup(gl_sidePanel.createParallelGroup(Alignment.LEADING)
								.addComponent(btn_QuanLyKho, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btn_QuanLyBanHang, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btn_ThongKe, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btn_DoanhThu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_sidePanel.createSequentialGroup().addGap(18).addComponent(separator,
										GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE))
								.addComponent(btn_DangXuat))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		gl_sidePanel.setVerticalGroup(gl_sidePanel.createParallelGroup(Alignment.LEADING).addGroup(gl_sidePanel
				.createSequentialGroup().addGap(133)
				.addComponent(separator, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(btn_QuanLyKho, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE)
				.addGap(18)
				.addComponent(btn_QuanLyBanHang, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE)
				.addGap(18)
				.addComponent(btn_ThongKe, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE)
				.addGap(18)
				.addComponent(btn_DoanhThu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED, 242, Short.MAX_VALUE).addComponent(btn_DangXuat)
				.addGap(32)));
		sidePanel.setLayout(gl_sidePanel);

		pack();
	}

	private void taoBang(JTable table) {
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table.setRowHeight(30);
		table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 15));
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(0).setPreferredWidth(150);
		table.getColumnModel().getColumn(1).setPreferredWidth(400);
		table.getColumnModel().getColumn(2).setPreferredWidth(250);
		table.getColumnModel().getColumn(3).setPreferredWidth(150);
		table.getColumnModel().getColumn(4).setPreferredWidth(150);
		table.getColumnModel().getColumn(5).setPreferredWidth(170);
		table.getColumnModel().getColumn(6).setPreferredWidth(170);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	}

	public void chuyenSangManHinhQuanLyBanHang() {
		// TODO Auto-generated method stub
		cardLayout.show(panel_CardLayout, "panel_QuanLyBanHang");
	}

	public void chuyenSangManHinhQuanLyKho() {
		// TODO Auto-generated method stub
		cardLayout.show(panel_CardLayout, "panel_QuanLyKho");
	}

	public void chuyenSangManHinhDoanhThu() {
		// TODO Auto-generated method stub
		cardLayout.show(panel_CardLayout, "panel_DoanhThu");
	}

	public void chuyenSangManHinhThongKe() {
		// TODO Auto-generated method stub
		cardLayout.show(panel_CardLayout, "panel_ThongKe");
	}

	
	
	
	
	
	
	
	
	
	
///////////////////////////////////////////////////////////////////////////////	
	public void chuyenSangManHinhXacNhan() {
		// TODO Auto-generated method stub
		cardLayout.show(panel_CardLayout, "panel_XacNhanThanhToan");
	}

	public void chuyenMauNenXanhNhat(String textInButton) {
		// TODO Auto-generated method stub
		if (textInButton.equals("DOANH THU")) {
			btn_DoanhThu.setBackground(color.color_ManHinhChinh_XanhDuongNhat);
		} else if (textInButton.equals("THỐNG KÊ")) {
			btn_ThongKe.setBackground(color.color_ManHinhChinh_XanhDuongNhat);
		} else if (textInButton.equals("QUẢN LÝ BÁN HÀNG")) {
			btn_QuanLyBanHang.setBackground(color.color_ManHinhChinh_XanhDuongNhat);
		} else if (textInButton.equals("QUẢN LÝ KHO")) {
			btn_QuanLyKho.setBackground(color.color_ManHinhChinh_XanhDuongNhat);
		} else if (textInButton.equals("Tìm kiếm")) {
			btn_TimKiem_Kho.setBackground(color.color_ManHinhChinh_XanhDuongNhat);
			btn_TimKiem_BanHang.setBackground(color.color_ManHinhChinh_XanhDuongNhat);
			btn_TimKiem_ThongKe.setBackground(color.color_ManHinhChinh_XanhDuongNhat);
		} else if (textInButton.equals("Thêm")) {
			btn_Them.setBackground(color.color_ManHinhChinh_XanhDuongNhat);
		} else if (textInButton.equals("Xóa")) {
			btn_Xoa.setBackground(color.color_ManHinhChinh_XanhDuongNhat);
			btn_Xoa_ThongKe.setBackground(color.color_ManHinhChinh_XanhDuongNhat);
		} else if (textInButton.equals("Cập nhật")) {
			btn_CapNhat.setBackground(color.color_ManHinhChinh_XanhDuongNhat);
		} else if (textInButton.equals("Hủy bỏ")) {
			btn_HuyBo.setBackground(color.color_ManHinhChinh_XanhDuongNhat);
		} else if (textInButton.equals("Thanh toán")) {
			btn_ThanhToan.setBackground(color.color_ManHinhChinh_XanhDuongNhat);
		} else if (textInButton.equals("Xác nhận")) {
			btn_XacNhan.setBackground(color.color_ManHinhChinh_XanhDuongNhat);
		} else if (textInButton.equals("Trở lại")) {
			btn_TroLai.setBackground(color.color_ManHinhChinh_XanhDuongNhat);
		} else if (textInButton.equals("Chỉnh sửa")) {
			btn_SuaSoLuong.setBackground(color.color_ManHinhChinh_XanhDuongNhat);
		} else if (textInButton.equals("Lọc")) {
			btn_Loc.setBackground(color.color_ManHinhChinh_XanhDuongNhat);
		} else if (textInButton.equals("Thống kê")) {
			btn_DoanhThuNgay.setBackground(color.color_ManHinhChinh_XanhDuongNhat);
			btn_DoanhThuThang.setBackground(color.color_ManHinhChinh_XanhDuongNhat);
			btn_DoanhThuNam.setBackground(color.color_ManHinhChinh_XanhDuongNhat);
		}
	}

	public void chuyenMauNenXanhDam(String textInButton) {
		// TODO Auto-generated method stub
		if (textInButton.equals("DOANH THU")) {
			btn_DoanhThu.setBackground(color.color_ManHinhChinh_XanhDuongDam);
		} else if (textInButton.equals("THỐNG KÊ")) {
			btn_ThongKe.setBackground(color.color_ManHinhChinh_XanhDuongDam);
		} else if (textInButton.equals("QUẢN LÝ BÁN HÀNG")) {
			btn_QuanLyBanHang.setBackground(color.color_ManHinhChinh_XanhDuongDam);
		} else if (textInButton.equals("QUẢN LÝ KHO")) {
			btn_QuanLyKho.setBackground(color.color_ManHinhChinh_XanhDuongDam);
		} else if (textInButton.equals("Tìm kiếm")) {
			btn_TimKiem_Kho.setBackground(color.color_ManHinhChinh_XanhDuongDam);
			btn_TimKiem_BanHang.setBackground(color.color_ManHinhChinh_XanhDuongDam);
			btn_TimKiem_ThongKe.setBackground(color.color_ManHinhChinh_XanhDuongDam);
		} else if (textInButton.equals("Thêm")) {
			btn_Them.setBackground(color.color_ManHinhChinh_XanhDuongDam);
		} else if (textInButton.equals("Xóa")) {
			btn_Xoa.setBackground(color.color_ManHinhChinh_XanhDuongDam);
			btn_Xoa_ThongKe.setBackground(color.color_ManHinhChinh_XanhDuongDam);
		} else if (textInButton.equals("Cập nhật")) {
			btn_CapNhat.setBackground(color.color_ManHinhChinh_XanhDuongDam);
		} else if (textInButton.equals("Hủy bỏ")) {
			btn_HuyBo.setBackground(color.color_ManHinhChinh_XanhDuongDam);
		} else if (textInButton.equals("Thanh toán")) {
			btn_ThanhToan.setBackground(color.color_ManHinhChinh_XanhDuongDam);
		} else if (textInButton.equals("Xác nhận")) {
			btn_XacNhan.setBackground(color.color_ManHinhChinh_XanhDuongDam);
		} else if (textInButton.equals("Trở lại")) {
			btn_TroLai.setBackground(color.color_ManHinhChinh_XanhDuongDam);
		} else if (textInButton.equals("Chỉnh sửa")) {
			btn_SuaSoLuong.setBackground(color.color_ManHinhChinh_XanhDuongDam);
		} else if (textInButton.equals("Lọc")) {
			btn_Loc.setBackground(color.color_ManHinhChinh_XanhDuongDam);
		} else if (textInButton.equals("Thống kê")) {
			btn_DoanhThuNgay.setBackground(color.color_ManHinhChinh_XanhDuongDam);
			btn_DoanhThuThang.setBackground(color.color_ManHinhChinh_XanhDuongDam);
			btn_DoanhThuNam.setBackground(color.color_ManHinhChinh_XanhDuongDam);
		}
	}

	public void chuyenMauNenXanhLucNhat() {
		// TODO Auto-generated method stub
		btn_XuatFileExcel.setBackground(new Color(27, 164, 102));
	}

	public void chuyenMauNenDoTham(String textInButton) {
		// TODO Auto-generated method stub
		if (textInButton.equals("Đăng xuất")) {
			btn_DangXuat.setBackground(new Color(183, 4, 4));
		} else if (textInButton.equals("Xóa hàng")) {
			btn_XoaHang.setBackground(new Color(183, 4, 4));
		}
	}

	public void chuyenMauNenXanhLucDam() {
		// TODO Auto-generated method stub
		btn_XuatFileExcel.setBackground(new Color(0, 128, 64));
	}

	public void chuyenMauNenDo(String textInButton) {
		// TODO Auto-generated method stub
		if (textInButton.equals("Đăng xuất")) {
			btn_DangXuat.setBackground(Color.RED);
		} else if (textInButton.equals("Xóa hàng")) {
			btn_XoaHang.setBackground(Color.RED);
		}

	}

	public void chuyenVeManHinhDangNhap() {
		// TODO Auto-generated method stub
		int luaChon = JOptionPane.showConfirmDialog(new JFrame(), "Bạn có chắc chắn muốn đăng xuất khỏi chương trình?",
				"Xác nhận", JOptionPane.YES_NO_OPTION);

		if (luaChon == JOptionPane.YES_OPTION) {
			DangNhap_View loginView = new DangNhap_View();
			loginView.pack();
			loginView.setLocationRelativeTo(null);
			loginView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			loginView.setVisible(true);
			this.dispose();
		}
	}
	
	public void HienThiBangBanHang() {
		try {
			Connection con;
			con = JDBC_DangNhap.getConnection();
			String sql = "select * from HangHoa";
			Statement statement= con.createStatement();
			ResultSet rs=statement.executeQuery(sql);
			DefaultTableModel modelBangBanHang = (DefaultTableModel) table_HangHoaThanhToan.getModel();
			while(rs.next()) {
				String maSanPham=rs.getString(1);
				String tenSanPham=rs.getString(2);
				String nhaSanXuat=rs.getString(3);
				int soLuong=rs.getInt(4);
				int gia=rs.getInt(5);
				Date ngaySanXuat = rs.getDate(6);
				Date hanSuDung = rs.getDate(7);
				modelBangBanHang.addRow(new Object[]{maSanPham, tenSanPham, nhaSanXuat, soLuong,gia,ngaySanXuat,hanSuDung});	
				
			}
			JDBC_DangNhap.closeConnection(con);
		} catch (SQLException e1) {

			e1.printStackTrace();
		}
	}
	
	public void TimKiemBanHang() {
		String tenSp = txt_HangCanTim_BanHang.getText();
		if (tenSp.length() > 0) {
			DefaultTableModel modelBangBanHang = (DefaultTableModel) table_HangHoaThanhToan.getModel();
			int soLuongDong = modelBangBanHang.getRowCount();
			ArrayList<String> maSanPhamCanXoa = new ArrayList<String>();
			for(int i = 0; i < soLuongDong; i++) {
				String tenSanPhamTrongBang = modelBangBanHang.getValueAt(i, 1) + "";
				
				if(!tenSp.equals(tenSanPhamTrongBang)) {
					maSanPhamCanXoa.add(modelBangBanHang.getValueAt(i, 0) + "");
				}
			}
			for (String ma : maSanPhamCanXoa) {
				soLuongDong = modelBangBanHang.getRowCount();
				for(int i = 0; i < soLuongDong; i++) {
					if (ma.equals(modelBangBanHang.getValueAt(i, 0) + "")) {
						modelBangBanHang.removeRow(i);
						break;
					}
				}
				
			}
		}
	}
	

	public void HienThiBangDaChon() {
		// Lấy dữ liệu từ bảng qlbh
		DefaultTableModel modelBangBanHang = (DefaultTableModel) table_HangHoaThanhToan.getModel();
		int selectRow = table_HangHoaThanhToan.getSelectedRow();
		String maSp = modelBangBanHang.getValueAt(selectRow, 0) + "";
		String tenSp = modelBangBanHang.getValueAt(selectRow, 1) + "";
		String nhaSx = modelBangBanHang.getValueAt(selectRow, 2) + "";
		int soLuongSp = Integer.valueOf(modelBangBanHang.getValueAt(selectRow, 3) + "");
		int giaSp = Integer.valueOf(modelBangBanHang.getValueAt(selectRow, 4) + "");
		Date ngaySx = Date.valueOf(modelBangBanHang.getValueAt(selectRow, 5) + "");
		Date hanSd = Date.valueOf(modelBangBanHang.getValueAt(selectRow, 6) + "");
		
		// Thêm vào bảng mặt hàng đã chọn
		DefaultTableModel modelBangDaChon = (DefaultTableModel) table_HangHoaDaChon.getModel();
		modelBangDaChon.addRow(new Object[]{maSp, tenSp, nhaSx, soLuongSp,giaSp,ngaySx,hanSd});	

		// Hiện thị số tiền thanh toán
		int soTienThanhToan = soLuongSp * giaSp;
		lbl_SoTienThanhToan.setText(String.valueOf(soTienThanhToan));
	}

	public void XoaHangDaChon() {
		DefaultTableModel modelBangDaChon = (DefaultTableModel) table_HangHoaDaChon.getModel();
		int selectRow = table_HangHoaDaChon.getSelectedRow();
		modelBangDaChon.removeRow(selectRow);
		
	}
	
	public void ChinhSuaDaChon() {
		int soLuongCanMua = Integer.valueOf(txt_SoLuongCanMua.getText());
		System.out.print(soLuongCanMua);
		DefaultTableModel modelBangDaChon = (DefaultTableModel) table_HangHoaDaChon.getModel();
		int selectRow = table_HangHoaThanhToan.getSelectedRow();
		modelBangDaChon.setValueAt(soLuongCanMua, selectRow, 3);
		
	}

	public void XacNhanDaChon() {
		// TODO Auto-generated method stub
		
	}

	public void TroLaiBangBanHang() {
		// TODO Auto-generated method stub
		
	}
}
