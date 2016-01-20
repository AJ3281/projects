import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class EmployeeInfo extends JFrame {
	


	private JPanel contentPane;
	private JTable accountstable;
	private JTable networktable;
	private JTable servertable;

	
	

	/**
	 **************************************************************************************************************
	 * Launch the application
	 **************************************************************************************************************
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeInfo frame = new EmployeeInfo();
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
	
	Connection connection = null;
	private JScrollPane scrollPane;
	private JTextField textFieldAid;
	private JTextField textFieldAresource;
	private JTextField textFieldAusername;
	private JTextField textFieldApassword;
	private JButton btnUpdateAccounts;
	private JTextField textFieldSearchAccounts;
	private JLabel lblNewLabel_2;
	private JPanel panelAccounts;
	private JPanel panelServer;
	private JPanel panelNetwork;
	private JLabel label;
	private JLabel label_1;
	private JLabel lblNetwork;
	private JLabel lblServer;
	private JLabel lblBDlogo;
	private JLabel lblNid;
	private JLabel lblCpuname;
	private JLabel lblDomain;
	private JLabel lblIp;
	private JLabel lblSubnet;
	private JLabel lblGateway;
	private JLabel lblDns;
	private JLabel lblDns_1;
	private JLabel lblMisc;
	private JTextField textFieldNid;
	private JTextField textFieldNetworkname;
	private JTextField textFieldDomain;
	private JTextField textFieldIP;
	private JTextField textFieldSubnet;
	private JTextField textFieldGateway;
	private JTextField textFieldDNS1;
	private JTextField textFieldDNS2;
	private JTextField textFieldMisc;
	private JTextField textFieldSearchNetwork;
	private JLabel lblSid;
	private JLabel lblNewLabel;
	private JLabel lblModel;
	private JLabel lblSerialnum;
	private JLabel lblApplication;
	private JLabel lblIp_1;
	private JLabel lblOs;
	private JLabel lblOskey;
	private JTextField textFieldSid;
	private JTextField textFieldMake;
	private JTextField textFieldModel;
	private JTextField textFieldSerialNum;
	private JTextField textFieldApplication;
	private JTextField textFieldIP2;
	private JTextField textFieldOS;
	private JTextField textFieldOSkey;
	private JTextField textFieldSearchServer;
	private JTextField textFieldMiscUser;
	private JTextField textFieldMiscPass;
	private JTextField textFieldRackID;
	private JLabel lblService;
	private JTextField textFieldService;
	private JLabel lblDevice;
	private JTextField textFieldDevice;
	private JLabel lblRackid_1;
	private JTextField textFieldRackID2;
	private JButton btnClearNetwork;
	private JButton btnClearServer;
	private JButton btnIp;
	private JButton btnIp2;
	private JLabel lblMac;
	private JTextField textFieldMac;
	private JTextField textFieldEthport;
	private JTable unusedtable;
	private JTextField textFieldUid;
	private JTextField textFieldDevice2;
	private JTextField textFieldMake2;
	private JTextField textFieldModel2;
	private JTextField textFieldSerialnum2;
	private JTextField textFieldApplication2;
	private JTextField textFieldIP3;
	private JTextField textFieldOS2;
	private JTextField textFieldOskey2;
	private JLabel lblSearchUnused;
	private JTextField textFieldSearchUnused;
	private JScrollPane scrollPane_1;
	/**
	 **************************************************************************************************************
	 * Automatically updates table after action
	 **************************************************************************************************************
	 */

	public void refreshAccountsTable() {
		
		try {
			String query = "select aid as 'ID', aresource as 'Resource', ausername as 'Username', apassword as 'Password', miscuser as 'Misc User', miscpass as 'Misc Password', service as 'Service', rackid as 'Rackid' from Accounts order by resource";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			accountstable.setModel(DbUtils.resultSetToTableModel(rs));
			pst.close();
			rs.close();
			
		} catch (Exception f) {
			f.printStackTrace();
		}
		
	}
	
public void refreshNetworkTable() {
		
		try {
			String query = "select nid as 'ID', networkname as 'Network', domain as 'Domain', ip as 'IP', mac as 'Mac', subnet as 'Subnet', gateway as 'Gateway', dns1 as 'DNS1', dns2 as 'DNS2', ethport as 'Ethport', misc as 'Misc' from Network order by network";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			networktable.setModel(DbUtils.resultSetToTableModel(rs));
			pst.close();
			rs.close();
			
		} catch (Exception f) {
			f.printStackTrace();
		}
		
	}

public void refreshServerTable() {
	
	try {
		String query = "select sid as 'ID', device as 'Device', make as 'Make', model as 'Model', serialnum as 'Serial Number', application as 'Application', ip, os, oskey as 'OS Key', rackid as 'Rackid' from Server order by rackid";
		PreparedStatement pst = connection.prepareStatement(query);
		ResultSet rs = pst.executeQuery();
		servertable.setModel(DbUtils.resultSetToTableModel(rs));
		pst.close();
		rs.close();
		
	} catch (Exception f) {
		f.printStackTrace();
	}
	
}

public void refreshUnusedTable() {
	
	try {
		String query = "select uid as 'ID', device as 'Device', make as 'Make', model as 'Model', serialnum as 'Serial Number', application as 'Application', ip as 'IP', os as 'OS', oskey as 'OSkey' from Unused ORDER BY make";
		PreparedStatement pst = connection.prepareStatement(query);
		ResultSet rs = pst.executeQuery();
		unusedtable.setModel(DbUtils.resultSetToTableModel(rs));
		pst.close();
		rs.close();
		
	} catch (Exception f) {
		f.printStackTrace();
	}
	
}
	
	/**
	 **************************************************************************************************************
	 * Constructor
	 **************************************************************************************************************
	 */
	
	public EmployeeInfo() {
		
		connection = DBHandler.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1297, 806);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/* Server **********************************************************************************************************************************************************************************************************************/
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(128, 128, 128));
		tabbedPane.setBounds(10, 106, 1236, 633);
		contentPane.add(tabbedPane);
		
		panelServer = new JPanel();
		panelServer.setBackground(new Color(70, 130, 180));
		tabbedPane.addTab("Server", null, panelServer, null);
		tabbedPane.setBackgroundAt(0, new Color(255, 255, 255));
		panelServer.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(258, 133, 940, 462);
		panelServer.add(scrollPane);
		
		servertable = new JTable();
		servertable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				try {
					int row = servertable.getSelectedRow();
					String selectTable = (servertable.getModel().getValueAt(row, 0).toString());
					String query = "select * from Server where sid = '"+selectTable+"'";
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					
					if(rs.next()) {
						
						
						String addsid = rs.getString("sid");
						textFieldSid.setText(addsid);
						
						String adddevice = rs.getString("device");
						textFieldDevice.setText(adddevice);
						
						String addmake = rs.getString("make");
						textFieldMake.setText(addmake);
						
						String addmodel = rs.getString("model");
						textFieldModel.setText(addmodel);
						
						String addserialnum = rs.getString("serialnum");
						textFieldSerialNum.setText(addserialnum);
						
						String application = rs.getString("application");
						textFieldApplication.setText(application);
						
						String IP = rs.getString("ip");
						textFieldIP2.setText(IP);
						
						String OS = rs.getString("os");
						textFieldOS.setText(OS);
						
						String OSkey = rs.getString("oskey");
						textFieldOSkey.setText(OSkey);
						
						String rackid = rs.getString("rackid");
						textFieldRackID2.setText(rackid);
						
						
						
						
					}
					
				
				} catch (Exception f) {
					
					JOptionPane.showMessageDialog(null, f);
					
				}
				
			}
		});
		scrollPane.setViewportView(servertable);
		
		lblServer = new JLabel("Server");
		lblServer.setBounds(565, 11, 200, 50);
		panelServer.add(lblServer);
		lblServer.setHorizontalAlignment(SwingConstants.CENTER);
		lblServer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		label_1 = new JLabel("Search");
		label_1.setBounds(955, 102, 46, 14);
		panelServer.add(label_1);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		lblSid = new JLabel("ID");
		lblSid.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSid.setBounds(23, 38, 76, 50);
		panelServer.add(lblSid);
		
		lblNewLabel = new JLabel("Make");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(23, 120, 76, 50);
		panelServer.add(lblNewLabel);
		
		lblModel = new JLabel("Model");
		lblModel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblModel.setBounds(23, 158, 76, 50);
		panelServer.add(lblModel);
		
		lblSerialnum = new JLabel("SerialNum");
		lblSerialnum.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSerialnum.setBounds(23, 198, 76, 50);
		panelServer.add(lblSerialnum);
		
		lblApplication = new JLabel("Application");
		lblApplication.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblApplication.setBounds(23, 238, 76, 50);
		panelServer.add(lblApplication);
		
		lblIp_1 = new JLabel("IP");
		lblIp_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIp_1.setBounds(23, 285, 60, 37);
		panelServer.add(lblIp_1);
		
		lblOs = new JLabel("OS");
		lblOs.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblOs.setBounds(23, 318, 60, 50);
		panelServer.add(lblOs);
		
		lblOskey = new JLabel("OSkey");
		lblOskey.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblOskey.setBounds(23, 358, 60, 50);
		panelServer.add(lblOskey);
		
		lblDevice = new JLabel("Device");
		lblDevice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDevice.setBounds(23, 95, 46, 14);
		panelServer.add(lblDevice);
		
		textFieldSid = new JTextField();
		textFieldSid.setBounds(111, 55, 105, 20);
		panelServer.add(textFieldSid);
		textFieldSid.setColumns(10);
		
		textFieldDevice = new JTextField();
		textFieldDevice.setBounds(111, 95, 105, 20);
		panelServer.add(textFieldDevice);
		textFieldDevice.setColumns(10);
		
		textFieldMake = new JTextField();
		textFieldMake.setBounds(111, 135, 105, 20);
		panelServer.add(textFieldMake);
		textFieldMake.setColumns(10);
		
		textFieldModel = new JTextField();
		textFieldModel.setBounds(111, 175, 105, 20);
		panelServer.add(textFieldModel);
		textFieldModel.setColumns(10);
		
		textFieldSerialNum = new JTextField();
		textFieldSerialNum.setBounds(111, 215, 105, 20);
		panelServer.add(textFieldSerialNum);
		textFieldSerialNum.setColumns(10);
		
		textFieldApplication = new JTextField();
		textFieldApplication.setBounds(111, 255, 105, 20);
		panelServer.add(textFieldApplication);
		textFieldApplication.setColumns(10);
		
		textFieldIP2 = new JTextField();
		textFieldIP2.setBounds(111, 295, 105, 20);
		panelServer.add(textFieldIP2);
		textFieldIP2.setColumns(10);
		
		textFieldOS = new JTextField();
		textFieldOS.setBounds(111, 335, 105, 20);
		panelServer.add(textFieldOS);
		textFieldOS.setColumns(10);
		
		textFieldOSkey = new JTextField();
		textFieldOSkey.setBounds(111, 375, 105, 20);
		panelServer.add(textFieldOSkey);
		textFieldOSkey.setColumns(10);
		
		textFieldRackID2 = new JTextField();
		textFieldRackID2.setBounds(111, 415, 105, 20);
		panelServer.add(textFieldRackID2);
		textFieldRackID2.setColumns(10);
		
	
		
		lblRackid_1 = new JLabel("Rackid");
		lblRackid_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRackid_1.setBounds(23, 416, 46, 14);
		panelServer.add(lblRackid_1);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query = "insert into server (sid, device, make, model, serialnum, application, IP, OS, OSkey, rackid) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1,textFieldSid.getText());
					pst.setString(2,textFieldDevice.getText());
					pst.setString(3,textFieldMake.getText());
					pst.setString(4,textFieldModel.getText());
					pst.setString(5,textFieldSerialNum.getText());
					pst.setString(6,textFieldApplication.getText());
					pst.setString(7,textFieldIP2.getText());
					pst.setString(8,textFieldOS.getText());
					pst.setString(9,textFieldOSkey.getText());
					pst.setString(10,textFieldRackID2.getText());
					
					pst.execute();
					textFieldSid.setText("");
					textFieldDevice.setText("");
					textFieldMake.setText("");
					textFieldModel.setText("");
					textFieldSerialNum.setText("");
					textFieldApplication.setText("");
					textFieldIP2.setText("");
					textFieldOS.setText("");
					textFieldOSkey.setText("");
					textFieldRackID2.setText("");
					
					//JOptionPane.showMessageDialog(null,"Data Inserted");
					
					pst.close();
					
					
					
				} catch (Exception f) {
					f.printStackTrace();
				}
				
				refreshServerTable();
				
			}
		});
		btnInsert.setBounds(116, 456, 89, 23);
		panelServer.add(btnInsert);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					String query = "update server set sid = '"+textFieldSid.getText()+ "' , device= '" + textFieldDevice.getText()+ 
								"' , make= '" + textFieldMake.getText()+ 
								"' , model= '" + textFieldModel.getText()+ "' , serialnum= '" + textFieldSerialNum.getText()+ 
								"' , application= '" + textFieldApplication.getText()+
							    "' , IP= '" + textFieldIP2.getText()+ 
								"' , OS= '" + textFieldOS.getText()+ "' , OSkey= '" + textFieldOSkey.getText()+ 
								"' , rackid= '" + textFieldRackID2.getText()+ 
								"'  where sid = '" + textFieldSid.getText()+ "' "; 
								
					PreparedStatement pst = connection.prepareStatement(query);

					
					pst.execute();
					textFieldSid.setText("");
					textFieldDevice.setText("");
					textFieldMake.setText("");
					textFieldModel.setText("");
					textFieldSerialNum.setText("");
					textFieldApplication.setText("");
					textFieldIP2.setText("");
					textFieldOS.setText("");
					textFieldOSkey.setText("");
					textFieldRackID2.setText("");
					
					//JOptionPane.showMessageDialog(null,"Data Updated");
					
					pst.close();
					
					
					
				} catch (Exception f) {
					f.printStackTrace();
				}
				
				refreshServerTable();
				
				
			}
		});
		btnUpdate.setBounds(116, 490, 89, 23);
		panelServer.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int action = JOptionPane.showConfirmDialog(null, "Do you really want to delete?", "Delete",JOptionPane.YES_NO_OPTION);
				if (action == 0) {
				
				try {
					String query = " delete from server where sid = '"+textFieldSid.getText()+"'  "; 
								
					PreparedStatement pst = connection.prepareStatement(query);

					
					pst.execute();
					textFieldSid.setText("");
					textFieldDevice.setText("");
					textFieldMake.setText("");
					textFieldModel.setText("");
					textFieldSerialNum.setText("");
					textFieldApplication.setText("");
					textFieldIP2.setText("");
					textFieldOS.setText("");
					textFieldOSkey.setText("");
					textFieldRackID2.setText("");
					
					//JOptionPane.showMessageDialog(null,"Data Deleted");
					
					pst.close();
					
					
					
				} catch (Exception f) {
					f.printStackTrace();
				}
				
				refreshServerTable();
				}
				
			}
		});
		btnDelete.setBounds(116, 524, 89, 23);
		panelServer.add(btnDelete);
		
		textFieldSearchServer = new JTextField();
		textFieldSearchServer.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				try {
									
					String query = "select * from server where LOWER(sid) LIKE ? "  + "OR LOWER(device) LIKE ?  " 
							 + "OR LOWER(make) LIKE ?  " + "OR LOWER(model) LIKE ? "  + "OR LOWER(serialnum) LIKE ? "
							 + "OR LOWER(application) LIKE ? "
							 + "OR LOWER(ip) LIKE ? " + "OR LOWER(os) LIKE ? " + "OR LOWER(oskey) LIKE ? "
							 + "OR LOWER(rackid) LIKE ? ";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, "%" + textFieldSearchServer.getText() + "%");
					pst.setString(2, "%" + textFieldSearchServer.getText() + "%");
					pst.setString(3, "%" + textFieldSearchServer.getText() + "%");
					pst.setString(4, "%" + textFieldSearchServer.getText() + "%");
					pst.setString(5,  "%" + textFieldSearchServer.getText() + "%");
					pst.setString(6,  "%" + textFieldSearchServer.getText() + "%");
					pst.setString(7,  "%" + textFieldSearchServer.getText() + "%");
					pst.setString(8,  "%" + textFieldSearchServer.getText() + "%");
					pst.setString(9,  "%" + textFieldSearchServer.getText() + "%");
					pst.setString(10,  "%" + textFieldSearchServer.getText() + "%");
			
					
					
					ResultSet rs = pst.executeQuery();
					
					
					servertable.setModel(DbUtils.resultSetToTableModel(rs));
					pst.close();
				
					
				} catch (Exception f) {
					f.printStackTrace();
				}
				
				
			}
		});
		textFieldSearchServer.setBounds(1025, 99, 157, 20);
		panelServer.add(textFieldSearchServer);
		textFieldSearchServer.setColumns(10);
		
		btnClearServer = new JButton("Clear");
		btnClearServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					
					textFieldSid.setText("");
					textFieldDevice.setText("");
					textFieldMake.setText("");
					textFieldModel.setText("");
					textFieldSerialNum.setText("");
					textFieldApplication.setText("");
					textFieldIP2.setText("");
					textFieldOS.setText("");
					textFieldOSkey.setText("");
					textFieldRackID2.setText("");
					

					
					
				} catch (Exception f) {
					f.printStackTrace();
				}
				
				refreshServerTable();
				
			}
		});
		btnClearServer.setBounds(116, 558, 89, 23);
		panelServer.add(btnClearServer);
		
		btnIp = new JButton("IP");
		btnIp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query = "select device, application, ip from Server where ip > 0 order by Cast (ip AS REAL)";
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					servertable.setModel(DbUtils.resultSetToTableModel(rs));
					pst.close();
					rs.close();
					
				} catch (Exception f) {
					f.printStackTrace();
				}
			}
		});
		btnIp.setBounds(1054, 54, 89, 23);
		panelServer.add(btnIp);
		
		/* Network **********************************************************************************************************************************************************************************************************************/
		
		
		
		panelNetwork = new JPanel();
		panelNetwork.setBackground(new Color(70, 130, 180));
		tabbedPane.addTab("Network", null, panelNetwork, null);
		tabbedPane.setBackgroundAt(1, new Color(255, 255, 255));
		panelNetwork.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(258, 133, 940, 462);
		panelNetwork.add(scrollPane);
		
		networktable = new JTable();
		networktable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					int row = networktable.getSelectedRow();
					String selectTable = (networktable.getModel().getValueAt(row, 0).toString());
					String query = "select * from Network where nid = '"+selectTable+"'";
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					
					if(rs.next()) {
						
						
						String addnid = rs.getString("nid");
						textFieldNid.setText(addnid);
						
						String addnetworkame = rs.getString("networkname");
						textFieldNetworkname.setText(addnetworkame);
						
						String adddomain = rs.getString("domain");
						textFieldDomain.setText(adddomain);
						
						String addip = rs.getString("ip");
						textFieldIP.setText(addip);
						
						String addmac = rs.getString("mac");
						textFieldMac.setText(addmac);
						
						String addsubnet = rs.getString("subnet");
						textFieldSubnet.setText(addsubnet);
						
						String addgateway = rs.getString("gateway");
						textFieldGateway.setText(addgateway);
						
						String adddns1 = rs.getString("dns1");
						textFieldDNS1.setText(adddns1);
						
						String adddns2 = rs.getString("dns2");
						textFieldDNS2.setText(adddns2);
						
						String addethport = rs.getString("ethport");
						textFieldEthport.setText(addethport);
						
						String addmisc = rs.getString("misc");
						textFieldMisc.setText(addmisc);
						
						
						
						
					}
					
				
				} catch (Exception f) {
					
					JOptionPane.showMessageDialog(null, f);
					
				}
				
			}
		});
		scrollPane.setViewportView(networktable);
		
		lblNetwork = new JLabel("Network ");
		lblNetwork.setBounds(565, 11, 200, 50);
		panelNetwork.add(lblNetwork);
		lblNetwork.setHorizontalAlignment(SwingConstants.CENTER);
		lblNetwork.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		label = new JLabel("Search");
		label.setBounds(955, 102, 46, 14);
		panelNetwork.add(label);
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		lblNid = new JLabel("Nid");
		lblNid.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNid.setBounds(23, 30, 46, 14);
		panelNetwork.add(lblNid);
		
		lblCpuname = new JLabel("Network");
		lblCpuname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCpuname.setBounds(23, 70, 85, 14);
		panelNetwork.add(lblCpuname);
		
		lblDomain = new JLabel("Domain");
		lblDomain.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDomain.setBounds(23, 115, 74, 14);
		panelNetwork.add(lblDomain);
		
		lblIp = new JLabel("IP");
		lblIp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIp.setBounds(23, 150, 46, 14);
		panelNetwork.add(lblIp);
		
		lblSubnet = new JLabel("Subnet");
		lblSubnet.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSubnet.setBounds(23, 230, 46, 14);
		panelNetwork.add(lblSubnet);
		
		lblGateway = new JLabel("Gateway");
		lblGateway.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGateway.setBounds(23, 267, 59, 20);
		panelNetwork.add(lblGateway);
		
		lblDns = new JLabel("DNS1");
		lblDns.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDns.setBounds(23, 310, 46, 14);
		panelNetwork.add(lblDns);
		
		lblDns_1 = new JLabel("DNS2");
		lblDns_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDns_1.setBounds(23, 350, 46, 14);
		panelNetwork.add(lblDns_1);
		
		lblMisc = new JLabel("Misc");
		lblMisc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMisc.setBounds(23, 430, 46, 14);
		panelNetwork.add(lblMisc);
		
		textFieldNid = new JTextField();
		textFieldNid.setBounds(111, 29, 105, 20);
		panelNetwork.add(textFieldNid);
		textFieldNid.setColumns(10);
		
		textFieldNetworkname = new JTextField();
		textFieldNetworkname.setBounds(111, 69, 105, 20);
		panelNetwork.add(textFieldNetworkname);
		textFieldNetworkname.setColumns(10);
		
		textFieldDomain = new JTextField();
		textFieldDomain.setBounds(111, 109, 105, 20);
		panelNetwork.add(textFieldDomain);
		textFieldDomain.setColumns(10);
		
		textFieldIP = new JTextField();
		textFieldIP.setBounds(111, 149, 105, 20);
		panelNetwork.add(textFieldIP);
		textFieldIP.setColumns(10);
		
		textFieldSubnet = new JTextField();
		textFieldSubnet.setBounds(111, 229, 105, 20);
		panelNetwork.add(textFieldSubnet);
		textFieldSubnet.setColumns(10);
		
		textFieldGateway = new JTextField();
		textFieldGateway.setBounds(111, 269, 105, 20);
		panelNetwork.add(textFieldGateway);
		textFieldGateway.setColumns(10);
		
		textFieldDNS1 = new JTextField();
		textFieldDNS1.setBounds(111, 309, 105, 20);
		panelNetwork.add(textFieldDNS1);
		textFieldDNS1.setColumns(10);
		
		textFieldDNS2 = new JTextField();
		textFieldDNS2.setBounds(111, 349, 105, 20);
		panelNetwork.add(textFieldDNS2);
		textFieldDNS2.setColumns(10);
		
		textFieldMisc = new JTextField();
		textFieldMisc.setBounds(111, 429, 105, 20);
		panelNetwork.add(textFieldMisc);
		textFieldMisc.setColumns(10);
		
		JButton btnInsertNetwork = new JButton("Insert");
		btnInsertNetwork.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query = "insert into network (nid, networkname, domain, ip, mac, subnet, gateway, DNS1, DNS2, ethport, Misc) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1,textFieldNid.getText());
					pst.setString(2,textFieldNetworkname.getText());
					pst.setString(3,textFieldDomain.getText());
					pst.setString(4,textFieldIP.getText());
					pst.setString(5,textFieldMac.getText());
					pst.setString(6,textFieldSubnet.getText());
					pst.setString(7,textFieldGateway.getText());
					pst.setString(8,textFieldDNS1.getText());
					pst.setString(9,textFieldDNS2.getText());
					pst.setString(10,textFieldEthport.getText());
					pst.setString(11,textFieldMisc.getText());
					
					pst.execute();
					
					textFieldNid.setText("");
					textFieldNetworkname.setText("");
					textFieldDomain.setText("");
					textFieldIP.setText("");
					textFieldMac.setText("");
					textFieldSubnet.setText("");
					textFieldGateway.setText("");
					textFieldDNS1.setText("");
					textFieldDNS2.setText("");
					textFieldEthport.setText("");
					textFieldMisc.setText("");
					
					
					//JOptionPane.showMessageDialog(null,"Data Inserted");
					
					pst.close();
					
					
					
				} catch (Exception f) {
					f.printStackTrace();
				}
				
				refreshNetworkTable();
				
				
			}
		});
		btnInsertNetwork.setBounds(116, 465, 89, 23);
		panelNetwork.add(btnInsertNetwork);
		
		JButton btnUpdateNetwork = new JButton("Update");
		btnUpdateNetwork.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query = "update network set nid = '"+textFieldNid.getText()+"' , networkname= '" + textFieldNetworkname.getText()+ 
								"' , domain= '" + textFieldDomain.getText()+ "' , IP= '" + textFieldIP.getText()+ 
								"' , MAC= '" + textFieldMac.getText()+ 
								"' , subnet= '" + textFieldSubnet.getText()+ "' , gateway= '" + textFieldGateway.getText()+ 
								"' , DNS1= '" + textFieldDNS1.getText()+ "' , DNS2= '" + textFieldDNS2.getText()+ 
								"' , ethport= '" + textFieldEthport.getText()+ "' , misc= '" + textFieldMisc.getText()+ 
								"'  where Nid = '" + textFieldNid.getText()+ "' "; 
								
					PreparedStatement pst = connection.prepareStatement(query);

					
					pst.execute();
					
					textFieldNid.setText("");
					textFieldNetworkname.setText("");
					textFieldDomain.setText("");
					textFieldIP.setText("");
					textFieldMac.setText("");
					textFieldSubnet.setText("");
					textFieldGateway.setText("");
					textFieldDNS1.setText("");
					textFieldDNS2.setText("");
					textFieldEthport.setText("");
					textFieldMisc.setText("");
					
					//JOptionPane.showMessageDialog(null,"Data Updated");
					
					pst.close();
					
					
					
				} catch (Exception f) {
					f.printStackTrace();
				}
				refreshNetworkTable();
				
			}
		});
		btnUpdateNetwork.setBounds(116, 499, 89, 23);
		panelNetwork.add(btnUpdateNetwork);
		
		JButton btnDeleteNetwork = new JButton("Delete");
		btnDeleteNetwork.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int action = JOptionPane.showConfirmDialog(null, "Do you really want to delete?", "Delete",JOptionPane.YES_NO_OPTION);
				if (action == 0) {
				
				try {
					String query = " delete from network where nid = '"+textFieldNid.getText()+"'  "; 
								
					PreparedStatement pst = connection.prepareStatement(query);

					
					pst.execute();
					
					textFieldNid.setText("");
					textFieldNetworkname.setText("");
					textFieldDomain.setText("");
					textFieldIP.setText("");
					textFieldMac.setText("");
					textFieldSubnet.setText("");
					textFieldGateway.setText("");
					textFieldDNS1.setText("");
					textFieldDNS2.setText("");
					textFieldEthport.setText("");
					textFieldMisc.setText("");
					
					//JOptionPane.showMessageDialog(null,"Data Deleted");
					
					pst.close();
					
					
					
				} catch (Exception f) {
					f.printStackTrace();
				}
				
				refreshNetworkTable();
				}
				
			}
		});
		btnDeleteNetwork.setBounds(116, 533, 89, 23);
		panelNetwork.add(btnDeleteNetwork);
		
		textFieldSearchNetwork = new JTextField();
		textFieldSearchNetwork.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				try {
					String query = "select * from network where LOWER(nid) LIKE ? "
							 + "OR LOWER(networkname) LIKE ?  " + "OR LOWER(domain) LIKE ? "  + "OR LOWER(ip) LIKE ? "
							 + "OR LOWER(mac) LIKE ? "
							 + "OR LOWER(subnet) LIKE ? " + "OR LOWER(gateway) LIKE ? " + "OR LOWER(dns1) LIKE ? "
							 + "OR LOWER(dns2) LIKE ? "  + "OR LOWER(ethport) LIKE ? "+ "OR LOWER(misc) LIKE ? ";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, "%" + textFieldSearchNetwork.getText() + "%");
					pst.setString(2, "%" + textFieldSearchNetwork.getText() + "%");
					pst.setString(3, "%" + textFieldSearchNetwork.getText() + "%");
					pst.setString(4, "%" + textFieldSearchNetwork.getText() + "%");
					pst.setString(5,  "%" + textFieldSearchNetwork.getText() + "%");
					pst.setString(6,  "%" + textFieldSearchNetwork.getText() + "%");
					pst.setString(7,  "%" + textFieldSearchNetwork.getText() + "%");
					pst.setString(8,  "%" + textFieldSearchNetwork.getText() + "%");
					pst.setString(9,  "%" + textFieldSearchNetwork.getText() + "%");
					pst.setString(10,  "%" + textFieldSearchNetwork.getText() + "%");
					pst.setString(11,  "%" + textFieldSearchNetwork.getText() + "%");
					ResultSet rs = pst.executeQuery();
					
					
					networktable.setModel(DbUtils.resultSetToTableModel(rs));
					pst.close();
				
					
				} catch (Exception f) {
					f.printStackTrace();
				}
				
			}
		});
		textFieldSearchNetwork.setBounds(1025, 99, 157, 20);
		panelNetwork.add(textFieldSearchNetwork);
		textFieldSearchNetwork.setColumns(10);
		
		btnClearNetwork = new JButton("Clear");
		btnClearNetwork.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					
					textFieldNid.setText("");
					textFieldNetworkname.setText("");
					textFieldDomain.setText("");
					textFieldIP.setText("");
					textFieldMac.setText("");
					textFieldSubnet.setText("");
					textFieldGateway.setText("");
					textFieldDNS1.setText("");
					textFieldDNS2.setText("");
					textFieldEthport.setText("");
					textFieldMisc.setText("");
					

					
					
					
				} catch (Exception f) {
					f.printStackTrace();
				}
				
				refreshNetworkTable();
				
				
			}
		});
		btnClearNetwork.setBounds(116, 567, 89, 23);
		panelNetwork.add(btnClearNetwork);
		
		btnIp2 = new JButton("IP");
		btnIp2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query = "select networkname, ip from Network where ip > 0 order by Cast (ip AS REAL)";
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					networktable.setModel(DbUtils.resultSetToTableModel(rs));
					pst.close();
					rs.close();
					
				} catch (Exception f) {
					f.printStackTrace();
				}
				
			}
		});
		btnIp2.setBounds(1054, 54, 89, 23);
		panelNetwork.add(btnIp2);
		
		lblMac = new JLabel("MAC");
		lblMac.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMac.setBounds(23, 190, 46, 14);
		panelNetwork.add(lblMac);
		
		textFieldMac = new JTextField();
		textFieldMac.setBounds(111, 189, 105, 20);
		panelNetwork.add(textFieldMac);
		textFieldMac.setColumns(10);
		
		JLabel lblEthport = new JLabel("Ethport");
		lblEthport.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEthport.setBounds(23, 387, 59, 20);
		panelNetwork.add(lblEthport);
		
		textFieldEthport = new JTextField();
		textFieldEthport.setBounds(111, 389, 105, 20);
		panelNetwork.add(textFieldEthport);
		textFieldEthport.setColumns(10);
		

		
		
		
		
		/* Accounts **********************************************************************************************************************************************************************************************************************/
		
		panelAccounts = new JPanel();
		panelAccounts.setBackground(new Color(70, 130, 180));
		tabbedPane.addTab("Accounts", null, panelAccounts, null);
		tabbedPane.setBackgroundAt(2, new Color(255, 255, 255));
		panelAccounts.setLayout(null);
		
		JLabel lblAccounts = new JLabel("Aid");
		lblAccounts.setBounds(22, 102, 68, 14);
		panelAccounts.add(lblAccounts);
		lblAccounts.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblResource = new JLabel("Resource");
		lblResource.setBounds(22, 146, 68, 14);
		panelAccounts.add(lblResource);
		lblResource.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblAusername = new JLabel("Username");
		lblAusername.setBounds(22, 186, 68, 14);
		panelAccounts.add(lblAusername);
		lblAusername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblApassword = new JLabel("Password");
		lblApassword.setBounds(22, 221, 68, 14);
		panelAccounts.add(lblApassword);
		lblApassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textFieldAid = new JTextField();
		textFieldAid.setBounds(111, 100, 105, 20);
		panelAccounts.add(textFieldAid);
		textFieldAid.setColumns(10);
		
		textFieldAresource = new JTextField();
		textFieldAresource.setBounds(111, 140, 105, 20);
		panelAccounts.add(textFieldAresource);
		textFieldAresource.setColumns(10);
		
		textFieldAusername = new JTextField();
		textFieldAusername.setBounds(111, 180, 105, 20);
		panelAccounts.add(textFieldAusername);
		textFieldAusername.setColumns(10);
		
		textFieldApassword = new JTextField();
		textFieldApassword.setBounds(111, 220, 105, 20);
		panelAccounts.add(textFieldApassword);
		textFieldApassword.setColumns(10);
		
		JButton btnInsertAccounts = new JButton("Insert");
		btnInsertAccounts.setBounds(116, 428, 89, 23);
		panelAccounts.add(btnInsertAccounts);
		
		btnUpdateAccounts = new JButton("Update");
		btnUpdateAccounts.setBounds(116, 462, 89, 23);
		panelAccounts.add(btnUpdateAccounts);
		
		JButton btnDeleteAccounts = new JButton("Delete");
		btnDeleteAccounts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int action = JOptionPane.showConfirmDialog(null, "Do you really want to delete?", "Delete",JOptionPane.YES_NO_OPTION);
				if (action == 0) {
				
				try {
					String query = " delete from accounts where aid = '"+textFieldAid.getText()+"'  "; 
								
					PreparedStatement pst = connection.prepareStatement(query);

					
					pst.execute();
					
					textFieldAid.setText("");
					textFieldAresource.setText("");
					textFieldAusername.setText("");
					textFieldApassword.setText("");
					textFieldMiscUser.setText("");
					textFieldMiscPass.setText("");
					textFieldRackID.setText("");
					textFieldService.setText("");
					
					
					
					//JOptionPane.showMessageDialog(null,"Data Deleted");
					
					pst.close();
					
					
					
				} catch (Exception f) {
					f.printStackTrace();
				}
				
				refreshAccountsTable();
				}
				
			}
		});
		btnDeleteAccounts.setBounds(116, 496, 89, 23);
		panelAccounts.add(btnDeleteAccounts);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(258, 133, 940, 462);
		panelAccounts.add(scrollPane);
		
		accountstable = new JTable();
		accountstable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					int row = accountstable.getSelectedRow();
					String selectTable = (accountstable.getModel().getValueAt(row, 0).toString());
					String query = "select * from Accounts where aid = '"+selectTable+"'";
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					
					if(rs.next()) {
						
						
						String addaid = rs.getString("aid");
						textFieldAid.setText(addaid);
						
						String addaresource = rs.getString("aresource");
						textFieldAresource.setText(addaresource);
						
						String addausername = rs.getString("ausername");
						textFieldAusername.setText(addausername);
						
						String addapassword = rs.getString("apassword");
						textFieldApassword.setText(addapassword);
						
						String addmiscuser = rs.getString("miscuser");
						textFieldMiscUser.setText(addmiscuser);
						
						String addmiscpass = rs.getString("miscpass");
						textFieldMiscPass.setText(addmiscpass);
						
						String addservice = rs.getString("service");
						textFieldService.setText(addservice);
						
						String addrackid = rs.getString("rackid");
						textFieldRackID.setText(addrackid);
																	
						
						
						
					}
					
				
				} catch (Exception f) {
					
					JOptionPane.showMessageDialog(null, f);
					
				}
				
				
			}
		});
		scrollPane.setViewportView(accountstable);
		
		
		JLabel lblSecondForm = new JLabel("Accounts");
		lblSecondForm.setBounds(565, 11, 200, 50);
		panelAccounts.add(lblSecondForm);
		lblSecondForm.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSecondForm.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblNewLabel_2 = new JLabel("Search");
		lblNewLabel_2.setBounds(955, 102, 46, 14);
		panelAccounts.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		textFieldSearchAccounts = new JTextField();
		textFieldSearchAccounts.setBounds(1025, 99, 157, 20);
		panelAccounts.add(textFieldSearchAccounts);
		
		JLabel lblNewLabel_3 = new JLabel("MiscUser");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(22, 261, 68, 14);
		panelAccounts.add(lblNewLabel_3);
		
		JLabel lblMiscpass = new JLabel("MiscPass");
		lblMiscpass.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMiscpass.setBounds(22, 301, 68, 14);
		panelAccounts.add(lblMiscpass);
		
		JLabel lblRackid = new JLabel("RackID");
		lblRackid.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRackid.setBounds(22, 381, 55, 14);
		panelAccounts.add(lblRackid);
		
		textFieldMiscUser = new JTextField();
		textFieldMiscUser.setBounds(111, 260, 105, 20);
		panelAccounts.add(textFieldMiscUser);
		textFieldMiscUser.setColumns(10);
		
		textFieldMiscPass = new JTextField();
		textFieldMiscPass.setBounds(111, 300, 105, 20);
		panelAccounts.add(textFieldMiscPass);
		textFieldMiscPass.setColumns(10);
		
		textFieldRackID = new JTextField();
		textFieldRackID.setBounds(111, 380, 105, 20);
		panelAccounts.add(textFieldRackID);
		textFieldRackID.setColumns(10);
		
		lblService = new JLabel("Service");
		lblService.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblService.setBounds(22, 341, 46, 14);
		panelAccounts.add(lblService);
		
		textFieldService = new JTextField();
		textFieldService.setBounds(111, 340, 105, 20);
		panelAccounts.add(textFieldService);
		textFieldService.setColumns(10);
		
		JButton btnClearAccounts = new JButton("Clear");
		btnClearAccounts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					
					textFieldAid.setText("");
					textFieldAresource.setText("");
					textFieldAusername.setText("");
					textFieldApassword.setText("");
					textFieldMiscUser.setText("");
					textFieldMiscPass.setText("");
					textFieldRackID.setText("");
					textFieldService.setText("");
					
	
					
				} catch (Exception f) {
					f.printStackTrace();
				}
				
				refreshAccountsTable();
				
				
			}
		});
		btnClearAccounts.setBounds(116, 530, 89, 23);
		panelAccounts.add(btnClearAccounts);
		
		JPanel panelUnused = new JPanel();
		panelUnused.setBackground(new Color(70, 130, 180));
		tabbedPane.addTab("Unused ", null, panelUnused, null);
		tabbedPane.setBackgroundAt(3, Color.WHITE);
		panelUnused.setLayout(null);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(258, 133, 940, 462);
		panelUnused.add(scrollPane_1);
		
		unusedtable = new JTable();
		scrollPane_1.setViewportView(unusedtable);
		
		unusedtable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				try {
					int row = unusedtable.getSelectedRow();
					String selectTable = (unusedtable.getModel().getValueAt(row, 0).toString());
					String query = "select * from Unused where uid = '"+selectTable+"'";
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					
					if(rs.next()) {
						
						
						String addsid = rs.getString("uid");
						textFieldUid.setText(addsid);
						
						String adddevice = rs.getString("device");
						textFieldDevice2.setText(adddevice);
						
						String addmake = rs.getString("make");
						textFieldMake2.setText(addmake);
						
						String addmodel = rs.getString("model");
						textFieldModel2.setText(addmodel);
						
						String addserialnum = rs.getString("serialnum");
						textFieldSerialnum2.setText(addserialnum);
						
						String application = rs.getString("application");
						textFieldApplication2.setText(application);
						
						String IP = rs.getString("ip");
						textFieldIP3.setText(IP);
						
						String OS = rs.getString("os");
						textFieldOS2.setText(OS);
						
						String OSkey = rs.getString("oskey");
						textFieldOskey2.setText(OSkey);					
						
						
						
					}
					
				
				} catch (Exception f) {
					
					JOptionPane.showMessageDialog(null, f);
					
				}
				
			}
		});
		
		
		JLabel lblUid = new JLabel("Uid");
		lblUid.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUid.setBounds(22, 61, 46, 14);
		panelUnused.add(lblUid);
		
		JLabel lblMake = new JLabel("Make");
		lblMake.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMake.setBounds(22, 141, 46, 14);
		panelUnused.add(lblMake);
		
		JLabel lblModel_1 = new JLabel("Model");
		lblModel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblModel_1.setBounds(22, 181, 46, 14);
		panelUnused.add(lblModel_1);
		
		JLabel lblDevice_1 = new JLabel("Device");
		lblDevice_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDevice_1.setBounds(22, 101, 46, 14);
		panelUnused.add(lblDevice_1);
		
		JLabel lblSerialNumber = new JLabel("SerialNum");
		lblSerialNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSerialNumber.setBounds(22, 221, 88, 14);
		panelUnused.add(lblSerialNumber);
		
		JLabel lblNewLabel_1 = new JLabel("Application");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(22, 261, 79, 14);
		panelUnused.add(lblNewLabel_1);
		
		JLabel lblOs_1 = new JLabel("OS");
		lblOs_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblOs_1.setBounds(22, 341, 46, 14);
		panelUnused.add(lblOs_1);
		
		JLabel lblIp_2 = new JLabel("IP");
		lblIp_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIp_2.setBounds(22, 301, 46, 14);
		panelUnused.add(lblIp_2);
		
		JLabel lblOskey_1 = new JLabel("OSkey");
		lblOskey_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblOskey_1.setBounds(22, 380, 46, 17);
		panelUnused.add(lblOskey_1);
		
		textFieldUid = new JTextField();
		textFieldUid.setBounds(111, 60, 105, 20);
		panelUnused.add(textFieldUid);
		textFieldUid.setColumns(10);
		
		textFieldDevice2 = new JTextField();
		textFieldDevice2.setBounds(111, 100, 105, 20);
		panelUnused.add(textFieldDevice2);
		textFieldDevice2.setColumns(10);
		
		textFieldMake2 = new JTextField();
		textFieldMake2.setBounds(111, 140, 105, 20);
		panelUnused.add(textFieldMake2);
		textFieldMake2.setColumns(10);
		
		textFieldModel2 = new JTextField();
		textFieldModel2.setBounds(111, 180, 105, 20);
		panelUnused.add(textFieldModel2);
		textFieldModel2.setColumns(10);
		
		textFieldSerialnum2 = new JTextField();
		textFieldSerialnum2.setText("");
		textFieldSerialnum2.setBounds(111, 220, 105, 20);
		panelUnused.add(textFieldSerialnum2);
		textFieldSerialnum2.setColumns(10);
		
		textFieldApplication2 = new JTextField();
		textFieldApplication2.setBounds(111, 260, 105, 20);
		panelUnused.add(textFieldApplication2);
		textFieldApplication2.setColumns(10);
		
		textFieldIP3 = new JTextField();
		textFieldIP3.setBounds(111, 300, 105, 20);
		panelUnused.add(textFieldIP3);
		textFieldIP3.setColumns(10);
		
		textFieldOS2 = new JTextField();
		textFieldOS2.setBounds(111, 340, 105, 20);
		panelUnused.add(textFieldOS2);
		textFieldOS2.setColumns(10);
		
		textFieldOskey2 = new JTextField();
		textFieldOskey2.setBounds(111, 380, 105, 20);
		panelUnused.add(textFieldOskey2);
		textFieldOskey2.setColumns(10);
		
		JButton btnInsertUnused = new JButton("Insert");
		btnInsertUnused.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query = "insert into unused (uid, device, make, model, serialnum, application, IP, OS, OSkey) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1,textFieldUid.getText());
					pst.setString(2,textFieldDevice2.getText());
					pst.setString(3,textFieldMake2.getText());
					pst.setString(4,textFieldModel2.getText());
					pst.setString(5,textFieldSerialnum2.getText());
					pst.setString(6,textFieldApplication2.getText());
					pst.setString(7,textFieldIP3.getText());
					pst.setString(8,textFieldOS2.getText());
					pst.setString(9,textFieldOskey2.getText());
					
					
					pst.execute();
					textFieldUid.setText("");
					textFieldDevice2.setText("");
					textFieldMake2.setText("");
					textFieldModel2.setText("");
					textFieldSerialnum2.setText("");
					textFieldApplication2.setText("");
					textFieldIP3.setText("");
					textFieldOS2.setText("");
					textFieldOskey2.setText("");
					
					
					//JOptionPane.showMessageDialog(null,"Data Inserted");
					
					pst.close();
					
					
					
				} catch (Exception f) {
					f.printStackTrace();
				}
				
				refreshUnusedTable();
				
			}
				
			
		});
		btnInsertUnused.setBounds(116, 435, 89, 23);
		panelUnused.add(btnInsertUnused);
		
		JButton btnUpdateUnused = new JButton("Update");
		btnUpdateUnused.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query = "update unused set uid = '"+textFieldUid.getText()+ "' , device= '" + textFieldDevice2.getText()+ 
								"' , make= '" + textFieldMake2.getText()+ 
								"' , model= '" + textFieldModel2.getText()+ "' , serialnum= '" + textFieldSerialnum2.getText()+ 
								"' , application= '" + textFieldApplication2.getText()+
							    "' , IP= '" + textFieldIP3.getText()+ 
								"' , OS= '" + textFieldOS2.getText()+ "' , OSkey= '" + textFieldOskey2.getText()+ 
								"'  where uid = '" + textFieldUid.getText()+ "' "; 
								
					PreparedStatement pst = connection.prepareStatement(query);

					
					pst.execute();
					textFieldUid.setText("");
					textFieldDevice2.setText("");
					textFieldMake2.setText("");
					textFieldModel2.setText("");
					textFieldSerialnum2.setText("");
					textFieldApplication2.setText("");
					textFieldIP3.setText("");
					textFieldOS2.setText("");
					textFieldOskey2.setText("");
					//JOptionPane.showMessageDialog(null,"Data Updated");
					
					pst.close();
					
					
					
				} catch (Exception f) {
					f.printStackTrace();
				}
				
				refreshUnusedTable();
				
				
			}
			
		});
		btnUpdateUnused.setBounds(116, 469, 89, 23);
		panelUnused.add(btnUpdateUnused);
		
		JButton btnDeleteUnused = new JButton("Delete");
		btnDeleteUnused.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int action = JOptionPane.showConfirmDialog(null, "Do you really want to delete?", "Delete",JOptionPane.YES_NO_OPTION);
				if (action == 0) {
				
				try {
					String query = " delete from unused where uid = '"+textFieldUid.getText()+"'  "; 
								
					PreparedStatement pst = connection.prepareStatement(query);

					
					pst.execute();
					textFieldUid.setText("");
					textFieldDevice2.setText("");
					textFieldMake2.setText("");
					textFieldModel2.setText("");
					textFieldSerialnum2.setText("");
					textFieldApplication2.setText("");
					textFieldIP3.setText("");
					textFieldOS2.setText("");
					textFieldOskey2.setText("");
					//JOptionPane.showMessageDialog(null,"Data Deleted");
					
					pst.close();
					
					
					
				} catch (Exception f) {
					f.printStackTrace();
				}
				
				refreshUnusedTable();
				}
			}
		});
		btnDeleteUnused.setBounds(116, 504, 89, 23);
		panelUnused.add(btnDeleteUnused);
		
		JButton btnClearUnused = new JButton("Clear");
		btnClearUnused.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					textFieldUid.setText("");
					textFieldDevice2.setText("");
					textFieldMake2.setText("");
					textFieldModel2.setText("");
					textFieldSerialnum2.setText("");
					textFieldApplication2.setText("");
					textFieldIP3.setText("");
					textFieldOS2.setText("");
					textFieldOskey2.setText("");

					
					
				} catch (Exception f) {
					f.printStackTrace();
				}
				
				refreshUnusedTable();
			}
		});
		btnClearUnused.setBounds(116, 540, 89, 23);
		panelUnused.add(btnClearUnused);
		
		lblSearchUnused = new JLabel("Search ");
		lblSearchUnused.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSearchUnused.setBounds(955, 102, 59, 14);
		panelUnused.add(lblSearchUnused);
		
		textFieldSearchUnused = new JTextField();
		textFieldSearchUnused.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				try {
					
					String query = "select * from unused where LOWER(uid) LIKE ? "  + "OR LOWER(device) LIKE ?  " 
							 + "OR LOWER(make) LIKE ?  " + "OR LOWER(model) LIKE ? "  + "OR LOWER(serialnum) LIKE ? "
							 + "OR LOWER(application) LIKE ? "
							 + "OR LOWER(ip) LIKE ? " + "OR LOWER(os) LIKE ? " + "OR LOWER(oskey) LIKE ? ";
					
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, "%" + textFieldSearchUnused.getText() + "%");
					pst.setString(2, "%" + textFieldSearchUnused.getText() + "%");
					pst.setString(3, "%" + textFieldSearchUnused.getText() + "%");
					pst.setString(4, "%" + textFieldSearchUnused.getText() + "%");
					pst.setString(5,  "%" + textFieldSearchUnused.getText() + "%");
					pst.setString(6,  "%" + textFieldSearchUnused.getText() + "%");
					pst.setString(7,  "%" + textFieldSearchUnused.getText() + "%");
					pst.setString(8,  "%" + textFieldSearchUnused.getText() + "%");
					pst.setString(9,  "%" + textFieldSearchUnused.getText() + "%");
					
			
					
					
					ResultSet rs = pst.executeQuery();
					
					
					unusedtable.setModel(DbUtils.resultSetToTableModel(rs));
					pst.close();
				
					
				} catch (Exception f) {
					f.printStackTrace();
				}
				
			}
		});
		textFieldSearchUnused.setBounds (1025, 99, 157, 20);
		panelUnused.add(textFieldSearchUnused);
		textFieldSearchUnused.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Unused");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(565, 11, 200, 50);
		panelUnused.add(lblNewLabel_4);
		
		btnInsertAccounts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query = "insert into accounts (aid, aresource, ausername, apassword, miscuser, miscpass,service,rackid) values (?, ?, ?, ?, ? ,? ,?, ?)";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1,textFieldAid.getText());
					pst.setString(2,textFieldAresource.getText());
					pst.setString(3,textFieldAusername.getText());
					pst.setString(4,textFieldApassword.getText());
					pst.setString(5,textFieldMiscUser.getText());
					pst.setString(6,textFieldMiscPass.getText());
					pst.setString(7,textFieldService.getText());
					pst.setString(8,textFieldRackID.getText());
					
					pst.execute();
					
					textFieldAid.setText("");
					textFieldAresource.setText("");
					textFieldAusername.setText("");
					textFieldApassword.setText("");
					textFieldMiscUser.setText("");
					textFieldMiscPass.setText("");
					textFieldRackID.setText("");
					textFieldService.setText("");
					
					
					//JOptionPane.showMessageDialog(null,"Data Inserted");
					
					pst.close();
					
					
					
				} catch (Exception f) {
					f.printStackTrace();
				}
				
				refreshAccountsTable();
				
				
			}
		});
		
		btnUpdateAccounts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query = "update accounts set aid = '"+textFieldAid.getText()+"' , aresource= '" + textFieldAresource.getText()+ 
								"' , ausername= '" + textFieldAusername.getText()+ "' , apassword= '" + textFieldApassword.getText()+
								"' , miscuser= '" + textFieldMiscUser.getText()+ "' , miscpass= '" + textFieldMiscPass.getText()+
								"' , service= '" + textFieldService.getText()+ "' , rackid= '" + textFieldRackID.getText()+ 
								"'  where Aid = '" + textFieldAid.getText()+ "' "; 
								
					PreparedStatement pst = connection.prepareStatement(query);

					
					pst.execute();
					
					textFieldAid.setText("");
					textFieldAresource.setText("");
					textFieldAusername.setText("");
					textFieldApassword.setText("");
					textFieldMiscUser.setText("");
					textFieldMiscPass.setText("");
					textFieldRackID.setText("");
					textFieldService.setText("");
					
					//JOptionPane.showMessageDialog(null,"Data Updated");
					
					pst.close();
					
					
					
				} catch (Exception f) {
					f.printStackTrace();
				}
				refreshAccountsTable();
				
			}
		});
		

	
		
		textFieldSearchAccounts.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				try {
					String query = "select * from accounts where LOWER(aid) LIKE ? "
							 + "OR LOWER(aresource) LIKE ?  " + "OR LOWER(ausername) LIKE ? "  + "OR LOWER(apassword) LIKE ? "
							 + "OR LOWER(miscuser) LIKE ? " + "OR LOWER(miscpass) LIKE ? " + "OR LOWER(service) LIKE ? "
							 + "OR LOWER(rackid) LIKE ? ";
					
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, "%" + textFieldSearchAccounts.getText() + "%");
					pst.setString(2, "%" + textFieldSearchAccounts.getText() + "%");
					pst.setString(3, "%" + textFieldSearchAccounts.getText() + "%");
					pst.setString(4, "%" + textFieldSearchAccounts.getText() + "%");
					pst.setString(5,  "%" + textFieldSearchAccounts.getText() + "%");
					pst.setString(6,  "%" + textFieldSearchAccounts.getText() + "%");
					pst.setString(7,  "%" + textFieldSearchAccounts.getText() + "%");
					pst.setString(8,  "%" + textFieldSearchAccounts.getText() + "%");
					ResultSet rs = pst.executeQuery();
					
					
					accountstable.setModel(DbUtils.resultSetToTableModel(rs));
					pst.close();
				
					
				} catch (Exception f) {
					f.printStackTrace();
				}
				
				
			}
		});
		
		/* Accounts Close **********************************************************************************************************************************************************************************************************************/

		

		
		
		lblBDlogo = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/BD.png")).getImage();
		lblBDlogo.setIcon(new ImageIcon(img));
		lblBDlogo.setBounds(505, 23, 268, 84);
		contentPane.add(lblBDlogo);


		
		/**
		 **************************************************************************************************************
		 * Calling table so it is displayed upon app start
		 **************************************************************************************************************
		 */
		
		refreshAccountsTable();
		refreshNetworkTable();
		refreshServerTable();
		refreshUnusedTable();
	}
}
