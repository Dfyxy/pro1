package jhz20200607;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;


import javax.swing.border.*;
import javax.swing.event.ChangeEvent;

public class Jhzprofessor extends JFrame {

	public Jhzprofessor(String id, String name, String passw) {
		pfr = new Professor(id, name, passw);
	}

	public Professor pfr;
	public Timer time;

	void run() {

//gui����		
		setTitle("���ڶ˽���");
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int option = JOptionPane.showConfirmDialog(null, "ȷ���˳�ϵͳ? ", "��ʾ ", JOptionPane.YES_NO_OPTION);
				if (option == JOptionPane.YES_OPTION)
				{
				    //�޸ĵ�½���
					try {
						Connection con;
						String driver = "com.mysql.cj.jdbc.Driver";
						String url = "jdbc:mysql://127.12.216.221:3306/test?serverTimezone=UTC&useSSL=false&user=root&password=123456";

						Class.forName(driver);
						con = DriverManager.getConnection(url);
						if (!con.isClosed()) {
//							System.out.println("Succeed connecting to the Database!");
						}
						Statement statement = con.createStatement();
						String sql = "update professor set ProState = 0 " 
								+ " where ProID = "+pfr.ProID;
						statement.executeUpdate(sql);

						con.close();
					} catch (ClassNotFoundException e1) {
						System.out.println("Sorry,can't find the Driver!");
						// e.printStackTrace();
					} catch (SQLException e2) {
						System.out.println("���ݿ�����ʧ�ܣ�!");
						// e.printStackTrace();
					} catch (Exception e3) {
						// e.printStackTrace();
					}
					
					//����
					System.exit(0);
				}
				else {
					return;

				}
			}
		});

	    //�޸ĵ�½���
		try {
			Connection con;
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://127.12.216.221:3306/test?serverTimezone=UTC&useSSL=false&user=root&password=123456";

			Class.forName(driver);
			con = DriverManager.getConnection(url);
			if (!con.isClosed()) {
	//			System.out.println("Succeed connecting to the Database!");
			}
			Statement statement = con.createStatement();
			String sql = "update professor set ProState = 1 " 
					+ " where ProID = "+pfr.ProID;
			statement.executeUpdate(sql);

			con.close();
		} catch (ClassNotFoundException e1) {
			System.out.println("Sorry,can't find the Driver!");
			// e.printStackTrace();
		} catch (SQLException e2) {
			System.out.println("���ݿ�����ʧ�ܣ�!");
			// e.printStackTrace();
		} catch (Exception e3) {
			// e.printStackTrace();
		}
		
		//����
		
		
		setResizable(false);// ���ɵ�����С

		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();// �����Ļ�ߴ�
		int width = 800;// The application's width
		int height = 600;
		int x = (d.width - width) / 2;
		int y = (d.height - height) / 2;
		setBounds((d.width - width) / 2, (d.height - height) / 2, width, height);// ���ڵ�����ͳߴ磬���ַ�ʽ����

		setLayout(null);// ���ò��ַ�ʽ

//��ʼ�����ϲ�		
		JPanel uption = new HomePanel(0);
		uption.setLayout(null);
		uption.setBounds(0, 0, width, height / 4);// �ϲ���С
		add(uption);

		JLabel timelabel = new JLabel("");
		time = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				timelabel.setText(new SimpleDateFormat("yyyy��MM��dd�� EEEE hh:mm:ss").format(new Date()));
			}
		});
		time.start();
		timelabel.setText(new SimpleDateFormat("yyyy��MM��dd�� EEEE hh:mm:ss").format(new Date()));
		timelabel.setBounds(5, 120, 200, 20);
		timelabel.setFont(new Font("΢���ź�", Font.BOLD, 12));
		timelabel.setForeground(new Color(251, 178, 23));
		uption.add(timelabel);

		JButton Exit = new JButton("�˳���¼");
		Exit.setBounds(10, 10, 100, 30);// ��С
		Font font1 = new Font("����", Font.BOLD + Font.ITALIC, 14);
		Exit.setFont(font1);
		Exit.setForeground(Color.blue);
		Exit.setToolTipText("���ص�¼����");
		Exit.setBorderPainted(false);// �����Ʊ߿�
		Exit.setContentAreaFilled(false);// ȡ�������

		Exit.addMouseListener(new MouseAdapter() {
			@Override
			// �����
			public void mouseClicked(MouseEvent e) {
				super.mouseEntered(e);
				JButton btn = (JButton) e.getComponent();
				btn.setBorderPainted(true);// ��ʾ�߿�
				btn.setBorder(BorderFactory.createLoweredBevelBorder());
				int op = JOptionPane.showConfirmDialog(null, "�Ƿ�Ҫע�������ص�½ҳ��", "��ʾ", JOptionPane.YES_NO_OPTION);
				if (op == JOptionPane.YES_OPTION) {
				    //�޸ĵ�½���
					try {
						Connection con;
						String driver = "com.mysql.cj.jdbc.Driver";
						String url = "jdbc:mysql://127.12.216.221:3306/test?serverTimezone=UTC&useSSL=false&user=root&password=123456";

						Class.forName(driver);
						con = DriverManager.getConnection(url);
						if (!con.isClosed()) {
							System.out.println("Succeed connecting to the Database!");
						}
						Statement statement = con.createStatement();
						String sql = "update professor set ProState = 0 " 
								+ " where ProID = "+pfr.ProID;
						statement.executeUpdate(sql);

						con.close();
					} catch (ClassNotFoundException e1) {
						System.out.println("Sorry,can't find the Driver!");
						// e.printStackTrace();
					} catch (SQLException e2) {
						System.out.println("���ݿ�����ʧ�ܣ�!");
						// e.printStackTrace();
					} catch (Exception e3) {
						// e.printStackTrace();
					}
					
					//����
					dispose();
				} else if (op == JOptionPane.NO_OPTION) {

				}
				// �˻�
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				JButton btn = (JButton) e.getComponent();
				btn.setForeground(new Color(0x33, 0x66, 0xcc));// ����������ɫ
				btn.setBorderPainted(true);// ��ʾ�߿�
				btn.setBorder(BorderFactory.createRaisedBevelBorder());
				btn.setRolloverEnabled(true);
			}

			@Override
			// ��갴ס
			public void mousePressed(MouseEvent e) {
				JButton btn = (JButton) e.getComponent();
				btn.setBorderPainted(true);// ��ʾ�߿�
				btn.setForeground(new Color(0x33, 0x66, 0xcc));// ����������ɫ
				btn.setBorder(BorderFactory.createLoweredBevelBorder());
				btn.setRolloverEnabled(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				JButton btn = (JButton) e.getComponent();
				btn.setForeground(Color.blue);// ����������ɫ
				btn.setBorderPainted(false);// ���ر߿�
			}
		});

		uption.add(Exit);

		JLabel welcome = new JLabel("��ӭ!", JLabel.CENTER);
		Font ffont = new Font("����", 1, 40);
		welcome.setFont(ffont);
		welcome.setBounds(width / 2 - 75, height / 8 - 60, 150, 120);
		uption.add(welcome);

//��ʼ�����²�	
		JPanel Test = new HomePanel(1);
		Test.setLayout(null);
		Test.setBounds(0, height / 4, width, height / 4 * 3);// �²���С
		add(Test);

		JLabel studentnum = new JLabel("�̹���:" + this.pfr.ProID, JLabel.LEFT);
		studentnum.setFont(new Font("����", 1, 15));
		studentnum.setBounds(20, 10, 120, 30);
		Test.add(studentnum);
		JLabel studentname = new JLabel("����:" + pfr.name, JLabel.LEFT);
		studentname.setFont(new Font("����", 1, 15));
		studentname.setBounds(20, 40, 120, 30);
		Test.add(studentname);
		String passw = "******";
		JLabel studentpassw = new JLabel("����:" + passw, JLabel.LEFT);
		studentpassw.setFont(new Font("����", 1, 15));
		studentpassw.setBounds(20, 70, 120, 30);
		Test.add(studentpassw);

		JButton exchange = new JButton("�޸�����");
		exchange.setBounds(140, 72, 100, 25);// ��С
		Font font2 = new Font("����", Font.BOLD + Font.ITALIC, 12);
		exchange.setFont(font2);
		exchange.setForeground(Color.blue);
		exchange.setToolTipText("�޸ĵ�ǰ����");
		exchange.setBorderPainted(false);// �����Ʊ߿�
		exchange.setContentAreaFilled(false);// ȡ�������
		exchange.addMouseListener(new MouseAdapter() {
			@Override
			// �����
			public void mouseClicked(MouseEvent e) {
				super.mouseEntered(e);

				JButton btn = (JButton) e.getComponent();
				btn.setBorderPainted(true);// ��ʾ�߿�
				btn.setBorder(BorderFactory.createLoweredBevelBorder());

				JDialog expass = new JDialog();
				expass.setModal(true);
				expass.setTitle("�޸��������");
				expass.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				expass.setResizable(false);// ���ɵ�����С

				Dimension d = Toolkit.getDefaultToolkit().getScreenSize();// �����Ļ�ߴ�
				int width = 400;// The application's width
				int height = 250;
				expass.setBounds((d.width - width) / 2, (d.height - height) / 2, width, height);// ���ڵ�����ͳߴ磬���ַ�ʽ����
				expass.setLayout(null);// ���ò��ַ�ʽ

				JPasswordField new1 = new JPasswordField(10);
				JPasswordField new2 = new JPasswordField(10);
				JTextField old = new JTextField(10);
				old.setBounds(100, 10, 210, 30);
				new1.setBounds(100, 50, 210, 30);
				new2.setBounds(100, 90, 210, 30);

				JLabel oldpass = new JLabel("������", JLabel.CENTER);
				Font font1 = new Font("΢���ź�", Font.BOLD, 12);
				oldpass.setFont(font1);
				oldpass.setBounds(50, 10, 40, 30);

				JLabel newpass1 = new JLabel("������", JLabel.CENTER);
				newpass1.setFont(font1);
				newpass1.setBounds(50, 50, 40, 30);
				JLabel newpass2 = new JLabel("�ٴ�����", JLabel.CENTER);
				newpass2.setFont(font1);
				newpass2.setBounds(40, 90, 50, 30);

				expass.add(oldpass);
				expass.add(old);
				expass.add(newpass1);
				expass.add(new1);
				expass.add(newpass2);
				expass.add(new2);

				JButton Confirm = new JButton("ȷ��");
				Confirm.setBounds(100, 150, 60, 30);// ��С
				Font font2 = new Font("����", Font.BOLD, 13);
				Confirm.setFont(font2);
				Confirm.setForeground(Color.blue);
				Confirm.setBorderPainted(true);// �����Ʊ߿�
				// Confirm.setContentAreaFilled(false);//ȡ�������
				Confirm.setBorder(BorderFactory.createEtchedBorder());

				Confirm.addMouseListener(new MouseAdapter() {
					@Override
					// �����
					public void mouseClicked(MouseEvent e) {
						super.mouseEntered(e);
						JButton btn = (JButton) e.getComponent();
						btn.setBorderPainted(true);// ��ʾ�߿�
						btn.setBorder(BorderFactory.createLoweredBevelBorder());
						// �����ʾ���룬�޸ĺ������͹رոô���
						String info = old.getText().trim();// ��ȡ�ı��������,����ȥ����β�Ŀո�
						String info2 = new String(new1.getPassword());
						String info3 = new String(new2.getPassword());
						info2.trim();
						info3.trim();
						boolean isLetter = false;
						boolean isNumber = false;
						if (info.equals(pfr.passw)) {
							if (!info2.equals(info3)) {
								JOptionPane.showMessageDialog(null, "�������������벻��ͬ��", "��ʾ", JOptionPane.WARNING_MESSAGE);
							} else {

								for (int i = 0; i < info2.length(); i++) {
									if (Character.isLetter(info2.charAt(i))) // ��char��װ���е��ж���ĸ�ķ����ж�ÿһ���ַ�
										isLetter = true;
									if (Character.isDigit(info2.charAt(i))) // ��char��װ���е��ж���ĸ�ķ����ж�ÿһ���ַ�
										isNumber = true;
								}
								if (info2.length() >= 6) {
									if (isLetter == true && isNumber == true) {

										try {
											Connection con;
											String driver = "com.mysql.cj.jdbc.Driver";
											String url = "jdbc:mysql://127.12.216.221:3306/test?serverTimezone=UTC&useSSL=false&user=root&password=123456";

											Class.forName(driver);
											con = DriverManager.getConnection(url);
											if (!con.isClosed()) {
								//				System.out.println("Succeed connecting to the Database!");
											}
											Statement statement = con.createStatement();
											String sql = "update professor set ProPassword = " + "\"" + info2 + "\""
													+ " where ProID = " + pfr.ProID;
											statement.executeUpdate(sql);

											con.close();
										} catch (ClassNotFoundException e1) {
											System.out.println("Sorry,can't find the Driver!");
											// e.printStackTrace();
										} catch (SQLException e2) {
											System.out.println("���ݿ�����ʧ�ܣ�!");
											// e.printStackTrace();
										} catch (Exception e3) {
											// e.printStackTrace();
										}

										isLetter = false;
										isNumber = false;
										JOptionPane.showMessageDialog(null, "�޸ĳɹ��������룺" + info2, "��ʾ",
												JOptionPane.WARNING_MESSAGE);
										expass.dispose();
									} else {
										JOptionPane.showMessageDialog(null, "�����������ٰ������ֺ���ĸ��", "��ʾ",
												JOptionPane.WARNING_MESSAGE);
										isLetter = false;
										isNumber = false;
									}
								} else {
									JOptionPane.showMessageDialog(null, "�����������ٴ��ڵ���6λ��", "��ʾ",
											JOptionPane.WARNING_MESSAGE);
								}
							}

						} else {
							JOptionPane.showMessageDialog(null, "�������������", "��ʾ", JOptionPane.WARNING_MESSAGE);
						}
						// ���ȷ�Ϻͱ������

					}

					@Override
					// ��갴ס
					public void mousePressed(MouseEvent e) {
						JButton btn = (JButton) e.getComponent();
						btn.setBorderPainted(true);// ��ʾ�߿�
						btn.setForeground(new Color(0x33, 0x66, 0xcc));// ����������ɫ
						btn.setBorder(BorderFactory.createLoweredBevelBorder());
						btn.setRolloverEnabled(true);
					}

					@Override
					// �������
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						JButton btn = (JButton) e.getComponent();
						btn.setForeground(new Color(0x33, 0x66, 0xcc));// ����������ɫ
						btn.setBorderPainted(true);// ��ʾ�߿�
						Border etchedBorder = new EtchedBorder(EtchedBorder.LOWERED);// ���ñ߿���
						btn.setBorder(etchedBorder);
						btn.setRolloverEnabled(true);
					}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						JButton btn = (JButton) e.getComponent();
						btn.setForeground(Color.blue);// ����������ɫ
						btn.setBorder(BorderFactory.createEtchedBorder());
						btn.setBorderPainted(true);
					}
				});
				JButton Cencel = new JButton("ȡ��");
				Cencel.setBounds(220, 150, 60, 30);// ��С
				Cencel.setFont(font2);
				Cencel.setForeground(Color.blue);
				Cencel.setBorderPainted(true);
				Cencel.setBorder(BorderFactory.createEtchedBorder());
				Cencel.addMouseListener(new MouseAdapter() {
					@Override
					// �����
					public void mouseClicked(MouseEvent e) {
						super.mouseEntered(e);
						JButton btn = (JButton) e.getComponent();
						btn.setBorderPainted(true);// ��ʾ�߿�
						btn.setBorder(BorderFactory.createLoweredBevelBorder());

						expass.dispose();

					}

					@Override
					// ��갴ס
					public void mousePressed(MouseEvent e) {
						JButton btn = (JButton) e.getComponent();
						btn.setBorderPainted(true);// ��ʾ�߿�
						btn.setForeground(new Color(0x33, 0x66, 0xcc));// ����������ɫ
						btn.setBorder(BorderFactory.createLoweredBevelBorder());
						btn.setRolloverEnabled(true);
					}

					@Override
					// �������
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						JButton btn = (JButton) e.getComponent();
						btn.setForeground(new Color(0x33, 0x66, 0xcc));// ����������ɫ
						btn.setBorderPainted(true);// ��ʾ�߿�
						Border etchedBorder = new EtchedBorder(EtchedBorder.LOWERED);// ���ñ߿���
						btn.setBorder(etchedBorder);
						btn.setRolloverEnabled(true);
					}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						JButton btn = (JButton) e.getComponent();
						btn.setForeground(Color.blue);// ����������ɫ

						btn.setBorder(BorderFactory.createEtchedBorder());
						btn.setBorderPainted(true);
					}
				});

				expass.add(Confirm);
				expass.add(Cencel);
				expass.setVisible(true);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				JButton btn = (JButton) e.getComponent();
				btn.setForeground(new Color(0x33, 0x66, 0xcc));// ����������ɫ
				btn.setBorderPainted(true);// ��ʾ�߿�
				btn.setBorder(BorderFactory.createRaisedBevelBorder());
				btn.setRolloverEnabled(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				JButton btn = (JButton) e.getComponent();
				btn.setForeground(Color.blue);// ����������ɫ
				btn.setBorderPainted(false);// ���ر߿�
			}
		});
		Test.add(exchange);

		JButton lessonc = new JButton("ѡ���ڿ�");
		lessonc.setBounds(420, 72, 300, 50);// ��С
		Font font3 = new Font("΢���ź�", Font.BOLD, 20);
		lessonc.setFont(font3);
		lessonc.setForeground(new Color(219, 69, 32));
		lessonc.setToolTipText("ѡ����ѧ�ڵ��ڿμƻ�");
		lessonc.setBorderPainted(true);// �����Ʊ߿�
		lessonc.setBorder(BorderFactory.createEtchedBorder());
		lessonc.setContentAreaFilled(false);// ȡ�������

		boolean isstart[] = {true};// ѡ���Ƿ�ʼ�ı�־
		int[]  prost= {0};

		lessonc.addMouseListener(new MouseAdapter() {
			@Override
			// �����
			public void mouseClicked(MouseEvent e) {
				super.mouseEntered(e);
				JButton btn = (JButton) e.getComponent();
				btn.setBorderPainted(true);// ��ʾ�߿�
				btn.setBorder(BorderFactory.createLoweredBevelBorder());// ���ݱ߿�
					try {
						Connection con;
						String driver = "com.mysql.cj.jdbc.Driver";
						String url = "jdbc:mysql://127.12.216.221:3306/test?serverTimezone=UTC&useSSL=false&user=root&password=123456";

						Class.forName(driver);
						con = DriverManager.getConnection(url);
						if (!con.isClosed()) {
				//			System.out.println("Succeed connecting to the Database!");
						}
						Statement statement = con.createStatement();
						String sql = "SELECT\r\n" + 
								"	info.Proisstart\r\n" + 
								"FROM\r\n" + 
								"	info\r\n" + 
								"WHERE\r\n" + 
								"	info.Ver = 1";
						ResultSet rs = statement.executeQuery(sql);

						while (rs.next()) {
							if(Integer.parseInt(rs.getString("info.Proisstart"))==0)
								isstart[0]=false;
								prost[0]++;
						}
						con.close();
					} catch (ClassNotFoundException e1) {
						System.out.println("Sorry,can't find the Driver!");
						// e.printStackTrace();
					} catch (SQLException e2) {
						System.out.println("���ݿ�����ʧ�ܣ�!");
						// e.printStackTrace();
					} catch (Exception e3) {
						// e.printStackTrace();
					}
					if(prost[0]==0)
					{
						JOptionPane.showMessageDialog(null, "��ѡ�����ݿ�����ʧ�ܣ�", "��ʾ", JOptionPane.WARNING_MESSAGE);
					}else {
					if (!isstart[0]) {
					JOptionPane.showMessageDialog(null, "δ��ѡ��ʱ�䣡", "��ʾ", JOptionPane.WARNING_MESSAGE);
					prost[0]=0;
				}
				else {
					prost[0]=0;
					JDialog less = new JDialog();
					less.setModal(true);// ����Ϊģ̬

					less.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
					less.setResizable(false);// ���ɵ�����С

					Dimension d = Toolkit.getDefaultToolkit().getScreenSize();// �����Ļ�ߴ�
					int width = 750;// The application's width
					int height = 500;
					less.setBounds((d.width - width) / 2, (d.height - height) / 2, width, height);// ���ڵ�����ͳߴ磬���ַ�ʽ����
					less.setLayout(null);// ���ò��ַ�ʽ

					// ͼƬ�е�
					JPanel Less = new HomePanel(2);
					Less.setLayout(null);
					Less.setBounds(0, 0, width, height);
					less.add(Less);
					Vector<String> sqlstack = new Vector<String>();

					less.addWindowListener(new WindowAdapter() {
						@Override
						public void windowClosing(WindowEvent e) {
							int option = JOptionPane.showConfirmDialog(null, "�Ƿ񱣴沢�˳�? ", "��ʾ ",
									JOptionPane.YES_NO_OPTION);
							if (option == JOptionPane.YES_OPTION) {

								try {
									Connection con;
									String driver = "com.mysql.cj.jdbc.Driver";
									String url = "jdbc:mysql://127.12.216.221:3306/test?serverTimezone=UTC&useSSL=false&user=root&password=123456";

									Class.forName(driver);
									con = DriverManager.getConnection(url);
									if (!con.isClosed()) {
						//				System.out.println("Succeed connecting to the Database!");
									}
									Statement statement = con.createStatement();

									for (int i = 0; i < sqlstack.size(); i++) {
										System.out.println(sqlstack.get(i));
										statement.executeUpdate(sqlstack.get(i));
									}

									con.close();
								} catch (ClassNotFoundException e1) {
									System.out.println("Sorry,can't find the Driver!");
									// e.printStackTrace();
								} catch (SQLException e2) {
									System.out.println("���ݿ�����ʧ�ܣ�!");
									// e.printStackTrace();
								} catch (Exception e3) {
									// e.printStackTrace();
								}

								less.dispose();
							} else {

							}

						}
					});

					JLabel lessonn = new JLabel("���γ�������", JLabel.CENTER);
					lessonn.setFont(new Font("΢���ź�", Font.BOLD, 13));
					lessonn.setBounds(10, 10, 100, 30);
					Less.add(lessonn);

					JTextField lessonname = new JTextField(10);
					lessonname.setBounds(120, 10, 120, 30);
					Less.add(lessonname);

					JLabel lessonc = new JLabel("���γ̴������", JLabel.CENTER);
					lessonc.setFont(new Font("΢���ź�", Font.BOLD, 13));
					lessonc.setBounds(250, 10, 100, 30);
					Less.add(lessonc);

					JTextField lessoncode = new JTextField(10);
					lessoncode.setBounds(360, 10, 120, 30);
					Less.add(lessoncode);

					JTabbedPane tabbedPane = new JTabbedPane();
					tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);// ����ѡ���ǩ�Ĳ��ַ�ʽΪ��������

					Vector<String> temp2 = new Vector<String>();// �ʸ�����
					Vector<String> temp1 = new Vector<String>();
					temp1.add("�γ���");
					temp1.add("�γ̴���");
					temp1.add("�Ͽ�ʱ��");

					Vector<String> tem2 = new Vector<String>();// ��ѡ�γ�����
//���ݿ��������
					try {
						Connection con;
						String driver = "com.mysql.cj.jdbc.Driver";
						String url = "jdbc:mysql://127.12.216.221:3306/test?serverTimezone=UTC&useSSL=false&user=root&password=123456";
						// String user = "root";
						// String password = "root";
						Class.forName(driver);
						con = DriverManager.getConnection(url);
						if (!con.isClosed()) {
			//				System.out.println("Succeed connecting to the Database!");
						}
						Statement statement = con.createStatement();
						String sql = "select CourseName,CourseID,CourseTime from course where CourseID in (select CourseID from proauth where ProID = "
								+ pfr.ProID + ") and CourseID not in (select CourseID from nextprochoose where ProID = "
								+ pfr.ProID + ")";

						ResultSet rs = statement.executeQuery(sql);

						while (rs.next()) {
							temp2.add(rs.getString("CourseName"));
							temp2.add(rs.getString("CourseID"));
							temp2.add(rs.getString("CourseTime"));
						}

						sql = "select * from nextprochoose where ProID = " + pfr.ProID;
						rs = statement.executeQuery(sql);
						while (rs.next()) {
							tem2.add(rs.getString("CourseName"));
							tem2.add(rs.getString("CourseID"));
							tem2.add(rs.getString("CourseTime"));
						}
						rs.close();
						con.close();
					} catch (ClassNotFoundException e1) {
						System.out.println("Sorry,can't find the Driver!");
						// e.printStackTrace();
					} catch (SQLException e2) {
						System.out.println("���ݿ�����ʧ�ܣ�!");
						// e.printStackTrace();
					} catch (Exception e3) {
						// e.printStackTrace();
					}
//��ȡ����							

					ModelDemo tablemodel = new ModelDemo(temp2, temp1);
					ModelDemo tablemodel2 = new ModelDemo(tem2, temp1);
					JTable table = new JTable(tablemodel);
					JTable table2 = new JTable(tablemodel2);

					table.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent e) {
							boolean pre2 = true;// �Ƿ��ճ̳�ͻ��Ĭ�ϲ���ͻ
							Vector<String> tem = new Vector<String>();
							int p2=-1;//�����ճ̳�ͻ�Ŀγ�λ��
							if (e.getClickCount() == 2)// ʵ��˫���¼�
							{
								int row = ((JTable) e.getSource()).rowAtPoint(e.getPoint()); // �����λ��
								for (int i = 2; i < tem2.size(); i+=3) {
									if (temp2.get(row * 3 + 2).equals(tem2.get(i))) {
										pre2 = false;
										p2=i-2;
								//		System.out.println("?");
										break;
									}
								}
								if (pre2 == true) {
									for (int i = 0; i < 3; i++) {
										tem2.add(temp2.get(row * 3 + i));
										tem.add(temp2.get(row * 3 + i));
									}
									for (int i = 0; i < 3; i++) {
										temp2.remove(row * 3);
									}
									tablemodel.setTableData(temp2);
									tablemodel.fireTableDataChanged();
									tablemodel2.setTableData(tem2);
									tablemodel2.fireTableDataChanged();
									String sql = "insert into nextprochoose values(" + "\"" + tem.get(0) + "\",\""
											+ tem.get(2) + "\",\"" + tem.get(1) + "\",\"" + pfr.name + "\"," + pfr.ProID
											+ ")";
									sqlstack.add(sql);
								} else {
									JOptionPane.showMessageDialog(null, "��"+tem2.get(p2)+"�ճ̳�ͻ��", "��ʾ", JOptionPane.WARNING_MESSAGE);
									p2=-1;
									return;
								}
							}
						}
					});

					table2.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent e) {
							if (e.getClickCount() == 2)// ʵ��˫���¼�
							{
								Vector<String> tem = new Vector<String>();
								int row = ((JTable) e.getSource()).rowAtPoint(e.getPoint()); // �����λ��
								int option = JOptionPane.showConfirmDialog(null, "�Ƿ�ȷ���Ƴ��ÿγ�? ", "��ʾ ",
										JOptionPane.YES_NO_OPTION);
								if (option == JOptionPane.YES_OPTION) {
									for (int i = 0; i < 3; i++) {
										temp2.add(tem2.get(row * 3 + i));

									}
									for (int i = 0; i < 3; i++) {
										tem.add(tem2.get(row * 3));
										tem2.remove(row * 3);
									}
									tablemodel.setTableData(temp2);
									tablemodel.fireTableDataChanged();
									tablemodel2.setTableData(tem2);
									tablemodel2.fireTableDataChanged();
									String sql = "delete from nextprochoose where CourseID = \"" + tem.get(1)
											+ "\" and ProID = " + pfr.ProID;
									sqlstack.add(sql);
								}
							}
						}
					});
					JScrollPane scrollpane = new JScrollPane(table);// ��ӱ�񵽹�����
					JScrollPane scrollpane2 = new JScrollPane(table2);
					tabbedPane.addTab("��ѡ�α�", scrollpane);
					tabbedPane.addTab("��ѡ�α�", scrollpane2);
					tabbedPane.setBounds(30, 70, 620, 370);
					tabbedPane.setSelectedIndex(0); // ��������Ϊ0��ѡ���ѡ��
					Less.add(tabbedPane);

					JButton Search = new JButton("��ѯ");
					Search.setBounds(500, 10, 100, 30);// ��С
					Font font2 = new Font("����", Font.BOLD, 13);
					Search.setFont(font2);
					Search.setForeground(Color.blue);
					Search.setBorderPainted(true);// �����Ʊ߿�
					// Search.setContentAreaFilled(false);//ȡ�������
					Search.setBorder(BorderFactory.createEtchedBorder());

					Search.addMouseListener(new MouseAdapter() {
						@Override
						// �����
						public void mouseClicked(MouseEvent e) {
							super.mouseEntered(e);
							JButton btn = (JButton) e.getComponent();
							btn.setBorderPainted(true);// ��ʾ�߿�
							btn.setBorder(BorderFactory.createLoweredBevelBorder());
							String info = lessonname.getText().trim();// ��ȡ�ı��������,����ȥ����β�Ŀո�
							String info2 = lessoncode.getText().trim();
							Vector<String> tem = new Vector<String>();
							if (info.equals("")) {
								if (info2.equals("")) {
									tablemodel.setTableData(temp2);
									tablemodel.fireTableDataChanged();
								} else {
									for (int i = 1; i < temp2.size(); i += 3) {
										if (info2.equals(temp2.get(i))) {
											tem.add(temp2.get(i - 1));
											tem.add(temp2.get(i));
											tem.add(temp2.get(i + 1));
										}
									}
									tablemodel.setTableData(tem);
									tablemodel.fireTableStructureChanged();
									tem.removeAllElements();
								}
							} else {
								if (info2.equals("")) {
									for (int i = 0; i < temp2.size(); i += 3) {
										if (info.equals(temp2.get(i))) {
											tem.add(temp2.get(i));
											tem.add(temp2.get(i + 1));
											tem.add(temp2.get(i + 2));
										}
									}
									tablemodel.setTableData(tem);
									tablemodel.fireTableStructureChanged();
									tem.removeAllElements();
								} else {
									for (int i = 0; i < temp2.size(); i += 3) {
										if (info.equals(temp2.get(i)) && info2.equals(temp2.get(i + 1))) {
											tem.add(temp2.get(i));
											tem.add(temp2.get(i + 1));
											tem.add(temp2.get(i + 2));
										}
									}
									tablemodel.setTableData(tem);
									tablemodel.fireTableStructureChanged();
									tem.removeAllElements();
								}
							}
						}

						@Override
						// ��갴ס
						public void mousePressed(MouseEvent e) {
							JButton btn = (JButton) e.getComponent();
							btn.setBorderPainted(true);// ��ʾ�߿�
							btn.setForeground(new Color(0x33, 0x66, 0xcc));// ����������ɫ
							btn.setBorder(BorderFactory.createLoweredBevelBorder());
							btn.setRolloverEnabled(true);
						}

						@Override
						// �������
						public void mouseEntered(MouseEvent e) {
							// TODO Auto-generated method stub
							JButton btn = (JButton) e.getComponent();
							btn.setForeground(new Color(0x33, 0x66, 0xcc));// ����������ɫ
							btn.setBorderPainted(true);// ��ʾ�߿�
							Border etchedBorder = new EtchedBorder(EtchedBorder.LOWERED);// ���ñ߿���
							btn.setBorder(etchedBorder);
							btn.setRolloverEnabled(true);
						}

						@Override
						public void mouseExited(MouseEvent e) {
							// TODO Auto-generated method stub
							JButton btn = (JButton) e.getComponent();
							btn.setForeground(Color.blue);// ����������ɫ
							btn.setBorder(BorderFactory.createEtchedBorder());
							btn.setBorderPainted(true);
						}
					});
					JButton Reset = new JButton("����");
					Reset.setBounds(620, 10, 100, 30);// ��С
					Reset.setFont(font2);
					Reset.setForeground(Color.blue);
					Reset.setBorderPainted(true);// �����Ʊ߿�
					// Reset.setContentAreaFilled(false);//ȡ�������
					Reset.setBorder(BorderFactory.createEtchedBorder());

					Reset.addMouseListener(new MouseAdapter() {
						@Override
						// �����
						public void mouseClicked(MouseEvent e) {
							super.mouseEntered(e);
							JButton btn = (JButton) e.getComponent();
							btn.setBorderPainted(true);// ��ʾ�߿�
							btn.setBorder(BorderFactory.createLoweredBevelBorder());

							lessonname.setText(" ");
							lessoncode.setText(" ");

						}

						@Override
						// ��갴ס
						public void mousePressed(MouseEvent e) {
							JButton btn = (JButton) e.getComponent();
							btn.setBorderPainted(true);// ��ʾ�߿�
							btn.setForeground(new Color(0x33, 0x66, 0xcc));// ����������ɫ
							btn.setBorder(BorderFactory.createLoweredBevelBorder());
							btn.setRolloverEnabled(true);
						}

						@Override
						// �������
						public void mouseEntered(MouseEvent e) {
							// TODO Auto-generated method stub
							JButton btn = (JButton) e.getComponent();
							btn.setForeground(new Color(0x33, 0x66, 0xcc));// ����������ɫ
							btn.setBorderPainted(true);// ��ʾ�߿�
							Border etchedBorder = new EtchedBorder(EtchedBorder.LOWERED);// ���ñ߿���
							btn.setBorder(etchedBorder);
							btn.setRolloverEnabled(true);
						}

						@Override
						public void mouseExited(MouseEvent e) {
							// TODO Auto-generated method stub
							JButton btn = (JButton) e.getComponent();
							btn.setForeground(Color.blue);// ����������ɫ
							btn.setBorder(BorderFactory.createEtchedBorder());
							btn.setBorderPainted(true);
						}
					});

					Less.add(Reset);
					Less.add(Search);
					less.setVisible(true);
				} // �ж�ѡ���Ƿ�ʼ�Ļ�����
				}
			}

			@Override
			// ��갴ס
			public void mousePressed(MouseEvent e) {
				JButton btn = (JButton) e.getComponent();

				btn.setBorderPainted(true);// ��ʾ�߿�
				btn.setForeground(new Color(255, 66, 93));// ����������ɫ
				btn.setBorder(BorderFactory.createLoweredBevelBorder());
				btn.setRolloverEnabled(true);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				JButton btn = (JButton) e.getComponent();
				btn.setForeground(new Color(255, 66, 93));// ����������ɫ
				btn.setBorderPainted(true);// ��ʾ�߿�
				btn.setBorder(BorderFactory.createRaisedBevelBorder());
				btn.setRolloverEnabled(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				JButton btn = (JButton) e.getComponent();
				btn.setForeground(new Color(219, 69, 32));// ����������ɫ
				btn.setBorder(BorderFactory.createEtchedBorder());
				btn.setBorderPainted(true);
			}
		});

		Test.add(lessonc);

		JButton givegrade = new JButton("����ɼ�");
		givegrade.setBounds(420, 222, 300, 50);// ��С
		givegrade.setFont(font3);
		givegrade.setForeground(new Color(219, 69, 32));
		givegrade.setToolTipText("�������ڿγ̵�ѧ���ɼ�");
		givegrade.setBorderPainted(true);// �����Ʊ߿�
		givegrade.setBorder(BorderFactory.createEtchedBorder());
		givegrade.setContentAreaFilled(false);// ȡ�������

		givegrade.addMouseListener(new MouseAdapter() {
			@Override
			// �����
			public void mouseClicked(MouseEvent e) {
				super.mouseEntered(e);
				JButton btn = (JButton) e.getComponent();
				btn.setBorderPainted(true);// ��ʾ�߿�
				btn.setBorder(BorderFactory.createLoweredBevelBorder());// ���ݱ߿�

				JDialog giveg = new JDialog();
				giveg.setModal(true);// ����Ϊģ̬

				giveg.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				giveg.setResizable(false);// ���ɵ�����С

				giveg.setTitle("ѡ��Ҫ����ɼ��Ŀγ�");

				Dimension d = Toolkit.getDefaultToolkit().getScreenSize();// �����Ļ�ߴ�
				int width = 600;// The application's width
				int height = 400;
				giveg.setBounds((d.width - width) / 2, (d.height - height) / 2, width, height);// ���ڵ�����ͳߴ磬���ַ�ʽ����
				giveg.setLayout(null);// ���ò��ַ�ʽ

				// ͼƬ�е�
				JPanel Giveg = new HomePanel(2);
				Giveg.setLayout(null);
				Giveg.setBounds(0, 0, width, height);
				giveg.add(Giveg);

				JLabel welcome = new JLabel("��ѡ��γ�", JLabel.CENTER);
				Font ffont = new Font("΢���ź�", 1, 15);
				welcome.setFont(ffont);
				welcome.setBounds(width / 2 - 75, 10, 150, 30);

				Giveg.add(welcome);

				Vector<String> temp1 = new Vector<String>();
				temp1.add("�γ�����");
				temp1.add("�γ̴���");
				temp1.add("�����꼶");
				Vector<String> temp2 = new Vector<String>();
				// ���ݿ��ȡ

				try {
					Connection con;
					String driver = "com.mysql.cj.jdbc.Driver";
					String url = "jdbc:mysql://127.12.216.221:3306/test?serverTimezone=UTC&useSSL=false&user=root&password=123456";

					Class.forName(driver);
					con = DriverManager.getConnection(url);
					if (!con.isClosed()) {
				//		System.out.println("Succeed connecting to the Database!");
					}
					Statement statement = con.createStatement();
					String sql = "select CourseName,CourseID,Class from course where CourseID in (select CourseID from evercourse where ProID = "
							+ pfr.ProID + ")";

					ResultSet rs = statement.executeQuery(sql);

					while (rs.next()) {
						temp2.add(rs.getString("CourseName"));
						temp2.add(rs.getString("CourseID"));
						temp2.add(rs.getString("Class"));
					}

					rs.close();
					con.close();
				} catch (ClassNotFoundException e1) {
					System.out.println("Sorry,can't find the Driver!");
					// e.printStackTrace();
				} catch (SQLException e2) {
					System.out.println("���ݿ�����ʧ�ܣ�!");
					// e.printStackTrace();
				} catch (Exception e3) {
					// e.printStackTrace();
				}
				// ��ȡ����
				JTabbedPane tabbedPane = new JTabbedPane();
				tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);// ����ѡ���ǩ�Ĳ��ַ�ʽΪ��������
				ModelDemo tablemodel = new ModelDemo(temp2, temp1);
				JTable table = new JTable(tablemodel);

				table.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						if (e.getClickCount() == 2)// ʵ��˫���¼�
						{

							 int row =((JTable)e.getSource()).rowAtPoint(e.getPoint()); //�����λ��
							 String CID=temp2.get(row*3+1);//��ȡ�γ�id
							JDialog classg = new JDialog();
							classg.setModal(true);// ����Ϊģ̬

							classg.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
							classg.setResizable(false);// ���ɵ�����С

							classg.setTitle("����ÿλѧ���ɼ�");

							Dimension d = Toolkit.getDefaultToolkit().getScreenSize();// �����Ļ�ߴ�
							int width = 700;// The application's width
							int height = 500;
							classg.setBounds((d.width - width) / 2, (d.height - height) / 2, width, height);// ���ڵ�����ͳߴ磬���ַ�ʽ����
							classg.setLayout(null);// ���ò��ַ�ʽ

							// ͼƬ�е�
							JPanel Classg = new HomePanel(2);
							Classg.setLayout(null);
							Classg.setBounds(0, 0, width, height);
							classg.add(Classg);
							
							Vector<String> temp1 = new Vector<String>();
							temp1.add("����");
							temp1.add("ѧ��");
							temp1.add("�γ�����");
							temp1.add("�ɼ�");
							Vector<String> temp2 = new Vector<String>();
							// ���ݿ��ȡ

							try {
								Connection con;
								String driver = "com.mysql.cj.jdbc.Driver";
								String url = "jdbc:mysql://127.12.216.221:3306/test?serverTimezone=UTC&useSSL=false&user=root&password=123456";

								Class.forName(driver);
								con = DriverManager.getConnection(url);
								if (!con.isClosed()) {
				//					System.out.println("Succeed connecting to the Database!");
								}
								Statement statement = con.createStatement();
								String sql = "SELECT\r\n" + 
										"	evercourse.StuID,\r\n" + 
										"	evercourse.Grade,\r\n" + 
										"	evercourse.CourseName,\r\n" + 
										"	student.StuName \r\n" + 
										"FROM\r\n" + 
										"	evercourse,\r\n" + 
										"	student \r\n" + 
										"WHERE\r\n" + 
										"	evercourse.StuID = student.StuID \r\n" + 
										"	AND evercourse.ProID ="+pfr.ProID+
										"	AND evercourse.CourseID ="+"\""+CID+"\"";

								ResultSet rs = statement.executeQuery(sql);

								while (rs.next()) {
									temp2.add(rs.getString("student.StuName"));
									temp2.add(rs.getString("evercourse.StuID"));
									temp2.add(rs.getString("evercourse.CourseName"));
									temp2.add(rs.getString("evercourse.Grade"));
								}

								rs.close();
								con.close();
							} catch (ClassNotFoundException e1) {
								System.out.println("Sorry,can't find the Driver!");
								// e.printStackTrace();
							} catch (SQLException e2) {
								System.out.println("���ݿ�����ʧ�ܣ�!");
								// e.printStackTrace();
							} catch (Exception e3) {
								// e.printStackTrace();
							}
							// ��ȡ����
							JTabbedPane tabbedPane = new JTabbedPane();
							tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);// ����ѡ���ǩ�Ĳ��ַ�ʽΪ��������
							ModelDemo tablemodel = new ModelDemo(temp2, temp1);
							JTable table = new JTable(tablemodel) {//��������ֵ
								private static final long serialVersionUID = 1L;
								public void editingStopped(ChangeEvent changeevent)
							    {
									int r=getEditingRow();
									int c=getEditingColumn();
									super.editingStopped(changeevent);
									temp2.set(r*4+c,((String)tablemodel.getValueAt(r, c)).trim());
								//	System.out.println(temp2.get(r*4+c));
								}
							};
							
							JScrollPane scrollpane = new JScrollPane(table);// ��ӱ�񵽹�����
							tabbedPane.addTab("���ڿγ�", scrollpane);
							tabbedPane.setBounds(30, 20, 630, 320);
							tabbedPane.setSelectedIndex(0); // ��������Ϊ0��ѡ���ѡ��
							Classg.add(tabbedPane);
							
							JButton Sa = new JButton("����");
							Sa.setBounds(290, 370, 120, 40);// ��С
							Sa.setFont(font2);
							Sa.setForeground(Color.blue);
							Sa.setBorderPainted(true);
							Sa.setBorder(BorderFactory.createEtchedBorder());
							Sa.addMouseListener(new MouseAdapter() {
								@Override
								// �����
								public void mouseClicked(MouseEvent e) {
									super.mouseEntered(e);
									JButton btn = (JButton) e.getComponent();
									btn.setBorderPainted(true);// ��ʾ�߿�
									btn.setBorder(BorderFactory.createLoweredBevelBorder());
									
									
									Vector<String> tem=new Vector<String>();
									for(int i=3 ;i<temp2.size();i+=4)
									{
										
										if(temp2.get(i)==null)
										{
											tem.add("null"+temp2.get(i-2));
										}
										else if(!temp2.get(i).toUpperCase().equals("A")&&!temp2.get(i).toUpperCase().equals("B")&&!temp2.get(i).toUpperCase().equals("C")&&!temp2.get(i).toUpperCase().equals("D")&&!temp2.get(i).toUpperCase().equals("I")&&!temp2.get(i).toUpperCase().equals("F")&&!temp2.get(i).trim().equals(""))
										{
											JOptionPane.showMessageDialog(null, "�ɼ���ʽ���ԣ�ӦΪABCDFI��գ���", "��ʾ", JOptionPane.WARNING_MESSAGE);
											return ;
										}else {
											if(temp2.get(i).trim().equals(""))
											{
												tem.add("null"+temp2.get(i-2));
											}else
											{
												tem.add(temp2.get(i).toUpperCase()+temp2.get(i-2));
												
											}

										}
									}
									try {
										Connection con;
										String driver = "com.mysql.cj.jdbc.Driver";
										String url = "jdbc:mysql://127.12.216.221:3306/test?serverTimezone=UTC&useSSL=false&user=root&password=123456";

										Class.forName(driver);
										con = DriverManager.getConnection(url);
										if (!con.isClosed()) {
						//					System.out.println("Succeed connecting to the Database!");
										}
										Statement statement = con.createStatement();
										String sql="update evercourse set Grade=";
									    String sql2=" where StuID=" ;
									    String sql3=" and CourseID ="+CID;
									    String tempsql=new String();
										for(int i=0;i<tem.size();i++)
										{
											if(tem.get(i).substring(0,4).equals("null"))
											{
											    tempsql=sql+"null";
												tempsql=tempsql+sql2+tem.get(i).substring(4)+sql3;
											}else
											{
												tempsql=sql+"\""+tem.get(i).substring(0,1)+"\"";
												tempsql=tempsql+sql2+tem.get(i).substring(1)+sql3;
											}
											statement.executeUpdate(tempsql);
											tempsql=null;
										}
										con.close();
									} catch (ClassNotFoundException e1) {
										System.out.println("Sorry,can't find the Driver!");
										// e.printStackTrace();
									} catch (SQLException e2) {
										System.out.println("���ݿ�����ʧ�ܣ�!");
										// e.printStackTrace();
									} catch (Exception e3) {
										// e.printStackTrace();
									}
									// ��ȡ����
									
									
									

								}

								@Override
								// ��갴ס
								public void mousePressed(MouseEvent e) {
									JButton btn = (JButton) e.getComponent();
									btn.setBorderPainted(true);// ��ʾ�߿�
									btn.setForeground(new Color(0x33, 0x66, 0xcc));// ����������ɫ
									btn.setBorder(BorderFactory.createLoweredBevelBorder());
									btn.setRolloverEnabled(true);
								}

								@Override
								// �������
								public void mouseEntered(MouseEvent e) {
									// TODO Auto-generated method stub
									JButton btn = (JButton) e.getComponent();
									btn.setForeground(new Color(0x33, 0x66, 0xcc));// ����������ɫ
									btn.setBorderPainted(true);// ��ʾ�߿�
									Border etchedBorder = new EtchedBorder(EtchedBorder.LOWERED);// ���ñ߿���
									btn.setBorder(etchedBorder);
									btn.setRolloverEnabled(true);
								}

								@Override
								public void mouseExited(MouseEvent e) {
									// TODO Auto-generated method stub
									JButton btn = (JButton) e.getComponent();
									btn.setForeground(Color.blue);// ����������ɫ

									btn.setBorder(BorderFactory.createEtchedBorder());
									btn.setBorderPainted(true);
								}
							});
							Classg.add(Sa);
							
							
							classg.setVisible(true);

						}
					}
				});

				JScrollPane scrollpane = new JScrollPane(table);// ��ӱ�񵽹�����
				tabbedPane.addTab("���ڿγ�", scrollpane);
				tabbedPane.setBounds(30, 40, 520, 300);
				tabbedPane.setSelectedIndex(0); // ��������Ϊ0��ѡ���ѡ��
				Giveg.add(tabbedPane);

				giveg.setVisible(true);

			}

			@Override
			// ��갴ס
			public void mousePressed(MouseEvent e) {
				JButton btn = (JButton) e.getComponent();

				btn.setBorderPainted(true);// ��ʾ�߿�
				btn.setForeground(new Color(255, 66, 93));// ����������ɫ
				btn.setBorder(BorderFactory.createLoweredBevelBorder());
				btn.setRolloverEnabled(true);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				JButton btn = (JButton) e.getComponent();
				btn.setForeground(new Color(255, 66, 93));// ����������ɫ
				btn.setBorderPainted(true);// ��ʾ�߿�
				btn.setBorder(BorderFactory.createRaisedBevelBorder());
				btn.setRolloverEnabled(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				JButton btn = (JButton) e.getComponent();
				btn.setForeground(new Color(219, 69, 32));// ����������ɫ
				btn.setBorder(BorderFactory.createEtchedBorder());
				btn.setBorderPainted(true);
			}
		});
		Test.add(givegrade);

		// У��֪ͨ��
		JList list = new JList();
		DefaultListModel<String> dlm = new DefaultListModel();

		dlm.addElement("1.jkl");
		dlm.addElement("2.dd");
		dlm.addElement("3.qq");

		list.setModel(dlm);
		list.setBorder(BorderFactory.createTitledBorder("У��֪ͨ��"));
		list.setBounds(10, 110, width / 5 * 2, height / 4 * 3);
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (list.getSelectedIndex() != -1) {
					if (e.getClickCount() == 2) {
						dlm.removeElement(list.getSelectedValue());
						list.setModel(dlm);
					}
				}
			}

		});
		Test.add(list);

		setVisible(true);

	}// run������β

//������	
	public class Professor {
		public String ProID;
		public String name;
		public boolean flag;
		public String passw;

		Professor(String ProID, String name, String pass) {
			this.ProID = ProID;
			this.name = name;
			this.flag = true;
			this.passw = pass;
//	    	System.out.println("��ӭ������ʦ��!");
//	    	System.out.println("�̹��ţ�"+ProID);
//	    	System.out.println("������"+name);
		}

		void MainMenus() {
			while (flag) {
				System.out.println("��ѡ��Ҫ���еķ���");
				System.out.println("1��ѡ���ڿ�");
				System.out.println("2���Ǽǳɼ�");
				System.out.println("3���޸�����");
				System.out.println("4���˳���¼");
				Scanner sc = new Scanner(System.in);
				char c = sc.next().charAt(0);
				switch (c) {
				case '1':
					SelectCourses();
					break;
				case '2':
					SubmitGrade();
					break;
				case '3':
					ChangePassword();
					break;
				case '4':
					QuitSystem();
					flag = false;
					break;
				default:
					System.out.println("����������������룡");
				}
			}
		}

		void SelectCourses() {
			System.out.println("���Ѿ�����ѡ���ڿ�ϵͳ��");
			Connection con;
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC";
			String user = "root";
			String password = "root";
			try {
				Class.forName(driver);
				con = DriverManager.getConnection(url, user, password);
				if (!con.isClosed()) {
	//				System.out.println("Succeed connecting to the Database!");
				}
				Statement statement = con.createStatement();
				String sql = "select CourseName,CourseTime from course where CourseID in (select CourseID from coursechoose where ProID = "
						+ this.ProID + ")";
				ResultSet rs = statement.executeQuery(sql);
				String CourseName = null;
				String CourseTime = null;
				String CourseID = null;
				String Professor = null;
				int Proid = 0;
				System.out.println("-----------------");
				System.out.println("����ѡ���ʸ����£�");
				System.out.println("-----------------");
				while (rs.next()) {
					CourseName = rs.getString("CourseName");
					CourseTime = rs.getString("CourseTime");
					System.out.println(CourseName + "\t\t" + CourseTime);
				}

				sql = "select * from choose where ProID = " + this.ProID;
				rs = statement.executeQuery(sql);
				System.out.println("-----------------");
				System.out.println("������ǰѡ��Ŀ�");
				System.out.println("-----------------");
				while (rs.next()) {
					CourseName = rs.getString("CourseName");
					CourseTime = rs.getString("CourseTime");
					CourseID = rs.getString("CourseID");
					Professor = rs.getString("Professor");
					Proid = rs.getInt("ProID");
					System.out.println(
							CourseName + "\t\t" + CourseTime + "\t" + CourseID + "\t" + Professor + "\t" + Proid);
				}
				rs.close();
				con.close();
			} catch (ClassNotFoundException e) {
				System.out.println("Sorry,can't find the Driver!");
				// e.printStackTrace();
			} catch (SQLException e) {
				System.out.println("���ݿ�����ʧ�ܣ�!");
				// e.printStackTrace();
			} catch (Exception e) {
				// e.printStackTrace();
			}
		}

		void SubmitGrade() {
			System.out.println("���Ѿ������ύ�ɼ�ϵͳ��");
		}

		void ChangePassword() {
			System.out.println("���Ѿ������޸�����ϵͳ��");

		}

		void QuitSystem() {
			System.out.println("ȷ��Ҫ�˳�ϵͳ��y/n");

		}
//		public static void main(String[] args) {

//		}
	}

	class ModelDemo extends AbstractTableModel

	{
		/** * @author С�� */

		public Vector<String> TableData;// ������ű�����ݵ����Ա�

		public Vector<String> TableTitle;// ���� �б���

		public int columnl;

		// ע�⹹�캯���ǵ�һ��ִ�еģ����ڳ�ʼ�� TableData��TableTitle
		public ModelDemo(Vector<String> row, Vector<String> column) {
			TableData = new Vector<String>();
			TableTitle = new Vector<String>();
			columnl = column.size();
			for (int i = 0; i < column.size(); i++) {
				TableTitle.add(column.get(i));
			}
			for (int i = 0; i < row.size(); i++) {
				TableData.add(row.get(i));
			}

		}

		public ModelDemo(String[] row, String[] column) {
			TableData = new Vector<String>();
			TableTitle = new Vector<String>();
			columnl = column.length;
			if (row != null) {
				for (int i = 0; i < column.length; i++) {
					TableTitle.add(column[i]);
				}
			}

			for (int i = 0; i < row.length; i++) {
				TableData.add(row[i]);
			}
		}

		public void setTableData(Vector<String> row) {
			TableData.removeAllElements();
			for (int i = 0; i < row.size(); i++) {
				TableData.add(row.get(i));
			}
		}

		@Override

		public int getRowCount()

		{

			// �����Ǹ�֪���Ӧ���ж����У����Ƿ���TableData�Ϲҵ�String�������

			return TableData.size() / columnl;

		}

		@Override
		public String getColumnName(int columnIndex) {
			return TableTitle.get(columnIndex);

		}

		@Override

		public int getColumnCount()

		{

			// ��֪�������ñ�������Ĵ�С,����������TableData.size()�У�TableTitle.size()����

			return columnl;

		}

		@Override

		public Object getValueAt(int rowIndex, int columnIndex)

		{

			// ��ȡ�˱��Ĵ�С����Ȼ��Ҫ��ȡ���ݣ���������ֱ�ӷ��ض�Ӧ������

			// С�� ���Ǵ� 0��ʼ�ģ�С���±�Խ�� ������

			return TableData.get((rowIndex) * columnl + columnIndex);
			// ��ȡ���� Ӧ������

		}

		@Override

		public boolean isCellEditable(int rowIndex, int columnIndex)

		{

			// �������ʽ����ÿ����Ԫ��ı༭���Ե�

			// �������AbstractTableModel�Ѿ�ʵ�֣�Ĭ�ϵ��� ������༭״̬

			// ������������Ϊ����/������༭״̬
			if(columnIndex==3&&TableTitle.get(3).equals("�ɼ�"))
				return true;
			else
			    return false;// super.isCellEditable(rowIndex, columnIndex);

		}

		@Override

		public void setValueAt(Object aValue, int rowIndex, int columnIndex)

		{

			// ����Ԫ������ݷ����ı��ʱ����øú������赥Ԫ�������

			// ������һ�£������Ƿ���TableData �еģ�˵�����޸����ݾ����޸ĵ�

			// TableData�е����ݣ��������ǽ����ڴ˴���TableData�Ķ�Ӧ�����޸ļ���

			TableData.set(((rowIndex) * columnl + columnIndex), (String) aValue);
			super.setValueAt(aValue, rowIndex, columnIndex);

			//

			// ��ʵ����super�ķ����ǵ�����fireTableCellUpdated()ֻ��Ӧ������

			// ��Ӧ��Ԫ�������

			// fireTableCellUpdated(rowIndex, columnIndex);

		}


	}

	public class HomePanel extends JPanel {
		ImageIcon icon;
		Image img;

		public HomePanel(int i) {
			// /img/xxx.jpg �Ǵ���������ڱ�д����Ŀ��bin�ļ����µ�img�ļ����µ�һ��ͼƬ
			if (i == 0) {
				icon = new ImageIcon(getClass().getResource("/img/uption.jfif"));
				img = icon.getImage();
			} else if (i == 1) {
				icon = new ImageIcon(getClass().getResource("/img/shida.jfif"));
				img = icon.getImage();
			} else if (i == 2) {
				icon = new ImageIcon(getClass().getResource("/img/Searchlesson.jfif"));
				img = icon.getImage();
			}
			img = icon.getImage();
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			// ����������Ϊ�˱���ͼƬ���Ը��洰�����е�����С�������Լ����óɹ̶���С
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		}

	}
}
