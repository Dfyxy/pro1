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
import javax.swing.border.Border;
import javax.swing.table.AbstractTableModel;
import javax.swing.border.*;

public class Jhzstudent extends JFrame {

	public Jhzstudent(String id,String name,String passw) {
		Stu=new Student(id,name,passw);
	}
	public Student Stu;
 	public Timer time;

	void run() {

		setTitle("ѧ���˽���");
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
						String sql = "update student set StuState = 0 " 
								+ " where StuID = "+Stu.StuID;
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

		setResizable(false);// ���ɵ�����С

		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();// �����Ļ�ߴ�
		int width = 800;// The application's width
		int height = 600;
		int x = (d.width - width) / 2;
		int y = (d.height - height) / 2;
		setBounds((d.width - width) / 2, (d.height - height) / 2, width, height);// ���ڵ�����ͳߴ磬���ַ�ʽ����

		setLayout(null);// ���ò��ַ�ʽ
		
		
	    //�޸ĵ�½���
		try {
			Connection con;
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://127.12.216.221:3306/test?serverTimezone=UTC&useSSL=false&user=root&password=123456";

			Class.forName(driver);
			con = DriverManager.getConnection(url);
			if (!con.isClosed()) {
				//System.out.println("Succeed connecting to the Database!");
			}
			Statement statement = con.createStatement();
			String sql = "update student set StuState = 1 " 
					+ " where StuID = "+Stu.StuID;
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
						//	System.out.println("Succeed connecting to the Database!");
						}
						Statement statement = con.createStatement();
						String sql = "update student set StuState = 0 " 
								+ " where StuID = "+Stu.StuID;
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

//		String stnum = "21172728";
		JLabel studentnum = new JLabel("ѧ��:" + Stu.StuID, JLabel.LEFT);
		studentnum.setFont(new Font("����", 1, 15));
		studentnum.setBounds(20, 10, 120, 30);
		Test.add(studentnum);
//		String stname = "�����";
		JLabel studentname = new JLabel("����:" + Stu.StuName, JLabel.LEFT);
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
				int x = (d.width - width) / 2;
				int y = (d.height - height) / 2;
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
						if (info.equals(Stu.StuPassw)) {
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
											String sql = "update student set StuPassword = " + "\"" + info2 + "\""
													+ " where StuID = " + Stu.StuID;
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
//						expass.dispose();

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

		JButton schedule = new JButton("���˿α�");
		schedule.setBounds(420, 72, 300, 50);// ��С
		Font font3 = new Font("΢���ź�", Font.BOLD, 20);
		schedule.setFont(font3);
		schedule.setForeground(new Color(219, 69, 32));
		schedule.setToolTipText("�鿴��ѧ�ڻ������α�");
		schedule.setBorderPainted(true);// �����Ʊ߿�
		schedule.setBorder(BorderFactory.createEtchedBorder());
		schedule.setContentAreaFilled(false);// ȡ�������
		schedule.addMouseListener(new MouseAdapter() {
			@Override
			// �����
			public void mouseClicked(MouseEvent e) {
				super.mouseEntered(e);
				JButton btn = (JButton) e.getComponent();
				btn.setBorderPainted(true);// ��ʾ�߿�
				btn.setBorder(BorderFactory.createLoweredBevelBorder());

				JDialog sche = new JDialog();
				sche.setModal(true);
				sche.setTitle("��ѯ�α����");
				sche.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				sche.setResizable(false);// ���ɵ�����С

				Dimension d = Toolkit.getDefaultToolkit().getScreenSize();// �����Ļ�ߴ�
				int width = 600;// The application's width
				int height = 450;
				int x = (d.width - width) / 2;
				int y = (d.height - height) / 2;
				sche.setBounds((d.width - width) / 2, (d.height - height) / 2, width, height);// ���ڵ�����ͳߴ磬���ַ�ʽ����
				sche.setLayout(null);// ���ò��ַ�ʽ

				// ͼƬ�е�
				JPanel Sche = new HomePanel(2);
				Sche.setLayout(null);
				Sche.setBounds(0, 0, width, height);
				sche.add(Sche);

				JLabel choic = new JLabel("ѡ��ѧ��", JLabel.CENTER);
				choic.setFont(new Font("����", 1, 15));
				choic.setBounds(10, 10, 120, 30);
				Sche.add(choic);

				String[] listData = new String[] { "ȫ��","��ѧ��","��һ��", "��һ��", "�����", "�����", "������", "������", "������",
						"������" };
				String[] listD;
				Integer gra=0;
				 //���ݿ����
				try {
					Connection con;
					String driver = "com.mysql.cj.jdbc.Driver";
					String url = "jdbc:mysql://127.12.216.221:3306/test?serverTimezone=UTC&useSSL=false&user=root&password=123456";

					Class.forName(driver);
					con = DriverManager.getConnection(url);
					if (!con.isClosed()) {
//						System.out.println("Succeed connecting to the Database!");
					}
					Statement statement = con.createStatement();
					String sql = "select GraduationTime from student where StuID = "+Stu.StuID;
					ResultSet rs = statement.executeQuery(sql);
					while(rs.next()) {
					    gra=rs.getInt("GraduationTime");
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
				
				//����
				gra=gra/10000%100-20;
				listD=new String[(listData.length-gra*2)];
				for(int i=0;i<(listData.length-gra*2);i++)
				{
					listD[i]=listData[i];
				}
				JComboBox<String> comboBox = new JComboBox<String>(listD);
				comboBox.setSelectedIndex(0);
				comboBox.setBounds(150, 12, 100, 25);
				comboBox.setFont(new Font("΢���ź�", Font.BOLD, 12));
				Sche.add(comboBox);

				JButton Search = new JButton("����");
				Search.setBounds(400, 10, 60, 30);// ��С
				Font font2 = new Font("����", Font.BOLD, 13);
				Search.setFont(font2);
				Search.setForeground(Color.blue);
				Search.setBorderPainted(true);// �����Ʊ߿�
				// Search.setContentAreaFilled(false);//ȡ�������
				Search.setBorder(BorderFactory.createEtchedBorder());

				// ����tab��table
				//String[] temp1 = { "�γ���", "�γ̴���", "����ϵ", "�Ͽ�ʱ��", "�Ⱦ�����", "�ڿν���", "�����꼶", "�γ̷���" };
				Vector<String> temp1= new Vector<String>();
				temp1.add("�γ���");
				temp1.add("�γ̴���");
				temp1.add("����ϵ");
				temp1.add("�Ͽ�ʱ��");
				temp1.add("�Ⱦ�����");
				temp1.add("�ڿν���");
				temp1.add("�����꼶");
				temp1.add("�γ̷���");
//				String[] temp2 = { "�ߵ���ѧ", "gs101", "����", "��һ����", "��", "cxk", "��һ��", "300", "�������", "cs120", "�����",
//						"�ܶ�����", "C���Ի���", "xz", "��һ��", "500" };
				Vector<String> temp3=new Vector<String>();
				Vector<String> temp2=new Vector<String>();
				try {
					Connection con;
					String driver = "com.mysql.cj.jdbc.Driver";
					String url = "jdbc:mysql://127.12.216.221:3306/test?serverTimezone=UTC&useSSL=false&user=root&password=123456";

					Class.forName(driver);
					con = DriverManager.getConnection(url);
					if (!con.isClosed()) {
//						System.out.println("Succeed connecting to the Database!");
					}
					Statement statement = con.createStatement();
					String sql = "SELECT\r\n" + 
							"	evercourse.CourseName,\r\n" + 
							"	evercourse.CourseID,\r\n" + 
							"	CourseDepartment,\r\n" + 
							"	CourseTime,\r\n" + 
							"	course.Condition,\r\n" + 
							"	Professor,\r\n" + 
							"	Class,\r\n" + 
							"	Money \r\n" + 
							"FROM\r\n" + 
							"	evercourse,\r\n" + 
							"	course \r\n" + 
							"WHERE\r\n" + 
							"	(evercourse.CourseID = course.CourseID \r\n" + 
							"	AND StuID = "+Stu.StuID+") OR (evercourse.CourseID=course.CourseID+\"*\"AND StuID = "+Stu.StuID+")";
					ResultSet rs = statement.executeQuery(sql);
					while(rs.next()) {
						temp2.add(rs.getString("evercourse.CourseName"));
						temp2.add(rs.getString("evercourse.CourseID"));
						temp2.add(rs.getString("CourseDepartment"));
						temp2.add(rs.getString("CourseTime"));
						temp2.add(rs.getString("course.Condition"));
						temp2.add(rs.getString("Professor"));
						temp2.add(rs.getString("Class"));
						temp2.add(rs.getString("Money"));
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
				// ���temp2Ϊ��ҲҪָ��һ���ո���ΪԪ��
				JTabbedPane tabbedPane = new JTabbedPane();
				tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);// ����ѡ���ǩ�Ĳ��ַ�ʽΪ��������
				ModelDemo tablemodel = new ModelDemo(temp2, temp1);
				JTable table = new JTable(tablemodel);
				// table.getColumnModel().getColumn(0).setPreferredWidth(200);//����ĳ�еĿ��
				// table.setRowHeight(1, 100);//����ĳ�е��и�
				// table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);//�ر��Զ������еĿ�ȣ��������Ҫ�����������ÿ�еĿ��
				JScrollPane scrollpane = new JScrollPane(table);// ��ӱ�񵽹�����
				tabbedPane.addTab("�γ̱��", scrollpane);
				tabbedPane.setBounds(30, 50, 520, 350);
				tabbedPane.setSelectedIndex(0); // ��������Ϊ0��ѡ���ѡ��
				Sche.add(tabbedPane);

				Search.addMouseListener(new MouseAdapter() {
					@Override
					// �����
					public void mouseClicked(MouseEvent e) {
						super.mouseEntered(e);
						JButton btn = (JButton) e.getComponent();
						btn.setBorderPainted(true);// ��ʾ�߿�
						btn.setBorder(BorderFactory.createLoweredBevelBorder());
						String temp = (String) comboBox.getSelectedItem();
						Vector<String> t = new Vector<String>();
						if (temp != null) {
							if (temp == "��һ��") {
								for (int i = 0; i < (temp2.size() / 8); i++) {
									if (temp2.get(i*8+6).equals("��һ��")){
										for (int y = 0; y < 8; y++) {

											t.add(temp2.get(i*8+y));
										}
									}
								}
								tablemodel.setTableData(t);
								tablemodel.fireTableDataChanged();
								t.removeAllElements();
							}else if(temp=="��ѧ��")
							{
								for(int i=0;i<(temp2.size()/8);i++)
								{
									//System.out.println(temp2.get(i*8+1).substring(temp2.get(i*8+1).length()-1, temp2.get(i*8+1).length()));
									if(temp2.get(i*8+1).substring(temp2.get(i*8+1).length()-1, temp2.get(i*8+1).length()).equals("*")) {
										for(int y=0;y<8;y++) {
											t.add(temp2.get(i*8+y));
										}
									}
								}
								tablemodel.setTableData(t);
								tablemodel.fireTableDataChanged();
								t.removeAllElements();
							}
							else if (temp == "ȫ��") {
								for (int i = 0; i < temp2.size(); i++) {
									t.add(temp2.get(i));
								}
								tablemodel.setTableData(t);
								tablemodel.fireTableDataChanged();
								t.removeAllElements();
							} else if (temp == "��һ��") {
								for (int i = 0; i < (temp2.size() / 8); i++) {
									if (temp2.get(i*8+6).equals("��һ��") ) {
										for (int y = 0; y < 8; y++) {

											t.add(temp2.get(i*8+y));
										}
									}
								}
								tablemodel.setTableData(t);
								tablemodel.fireTableDataChanged();
								t.removeAllElements();
							} else if (temp == "�����") {
								for (int i = 0; i < (temp2.size() / 8); i++) {
									if (temp2.get(i*8+6).equals("�����") ) {
										for (int y = 0; y < 8; y++) {

											t.add(temp2.get(i*8+y));
										}
									}
								}
								tablemodel.setTableData(t);
								tablemodel.fireTableDataChanged();
								t.removeAllElements();
							} else if (temp == "�����") {
								for (int i = 0; i < (temp2.size() / 8); i++) {
									if (temp2.get(i*8+6).equals( "�����")) {
										for (int y = 0; y < 8; y++) {

											t.add(temp2.get(i*8+y));
										}
									}
								}
								tablemodel.setTableData(t);
								tablemodel.fireTableDataChanged();
								t.removeAllElements();
							} else if (temp == "������") {
								for (int i = 0; i < (temp2.size() / 8); i++) {
									if (temp2.get(i*8+6).equals("������") ){
										for (int y = 0; y < 8; y++) {

											t.add(temp2.get(i*8+y));
										}
									}
								}
								tablemodel.setTableData(t);
								tablemodel.fireTableDataChanged();
								t.removeAllElements();
							} else if (temp == "������") {
								for (int i = 0; i < (temp2.size() / 8); i++) {
									if (temp2.get(i*8+6).equals("������")) {
										for (int y = 0; y < 8; y++) {

											t.add(temp2.get(i*8+y));
										}
									}
								}
								tablemodel.setTableData(t);
								tablemodel.fireTableDataChanged();
								t.removeAllElements();
							} else if (temp == "������") {
								for (int i = 0; i < (temp2.size() / 8); i++) {
									if (temp2.get(i*8+6).equals( "������") ){
										for (int y = 0; y < 8; y++) {

											t.add(temp2.get(i*8+y));
										}
									}
								}
								tablemodel.setTableData(t);
								tablemodel.fireTableDataChanged();
								t.removeAllElements();
							} else if (temp == "������") {
								for (int i = 0; i < (temp2.size() / 8); i++) {
									if (temp2.get(i*8+6).equals( "������")) {
										for (int y = 0; y < 8; y++) {

											t.add(temp2.get(i*8+y));
										}
									}
								}
								tablemodel.setTableData(t);
								tablemodel.fireTableDataChanged();
								t.removeAllElements();
							}
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
				Sche.add(Search);

				sche.setVisible(true);

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
		Test.add(schedule);

		JButton billinfo = new JButton("�˵�����");
		billinfo.setBounds(420, 152, 300, 50);// ��С���30
		billinfo.setFont(font3);
		billinfo.setForeground(new Color(219, 69, 32));
		billinfo.setToolTipText("�鿴��ѧ���˵�������ʷ�˵�");
		billinfo.setBorderPainted(true);// ���Ʊ߿�
		billinfo.setBorder(BorderFactory.createEtchedBorder());// ��̱߿�
		billinfo.setContentAreaFilled(false);// ȡ�������
		billinfo.addMouseListener(new MouseAdapter() {
			@Override
			// �����
			public void mouseClicked(MouseEvent e) {
				super.mouseEntered(e);
				JButton btn = (JButton) e.getComponent();
				btn.setBorderPainted(true);// ��ʾ�߿�
				btn.setBorder(BorderFactory.createLoweredBevelBorder());// ���ݱ߿�

				JDialog bill = new JDialog();
				bill.setModal(true);
				bill.setTitle("�˵��������");
				bill.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				bill.setResizable(false);// ���ɵ�����С

				Dimension d = Toolkit.getDefaultToolkit().getScreenSize();// �����Ļ�ߴ�
				int width = 600;// The application's width
				int height = 450;
				int x = (d.width - width) / 2;
				int y = (d.height - height) / 2;
				bill.setBounds((d.width - width) / 2, (d.height - height) / 2, width, height);// ���ڵ�����ͳߴ磬���ַ�ʽ����
				bill.setLayout(null);// ���ò��ַ�ʽ

				// ͼƬ�е�
				JPanel Bill = new HomePanel(2);
				Bill.setLayout(null);
				Bill.setBounds(0, 0, width, height);
				bill.add(Bill);

				JLabel choic = new JLabel("ѡ��ѧ��", JLabel.CENTER);
				choic.setFont(new Font("����", 1, 15));
				choic.setBounds(10, 10, 120, 30);
				Bill.add(choic);

				String[] listData = new String[] { "ȫ��", "��ѧ��","��һ��", "��һ��", "�����", "�����", "������", "������", "������",
						"������" };
				String[] listD;
				Integer gra=0;
				 //���ݿ����
				try {
					Connection con;
					String driver = "com.mysql.cj.jdbc.Driver";
					String url = "jdbc:mysql://127.12.216.221:3306/test?serverTimezone=UTC&useSSL=false&user=root&password=123456";

					Class.forName(driver);
					con = DriverManager.getConnection(url);
					if (!con.isClosed()) {
//						System.out.println("Succeed connecting to the Database!");
					}
					Statement statement = con.createStatement();
					String sql = "select GraduationTime from student where StuID = "+Stu.StuID;
					ResultSet rs = statement.executeQuery(sql);
					while(rs.next()) {
					    gra=rs.getInt("GraduationTime");
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
				
				//����
				gra=gra/10000%100-20;
				listD=new String[(listData.length-gra*2)];
				for(int i=0;i<(listData.length-gra*2);i++)
				{
					listD[i]=listData[i];
				}
				JComboBox<String> comboBox = new JComboBox<String>(listD);
				comboBox.setSelectedIndex(0);
				comboBox.setBounds(150, 12, 100, 25);
				comboBox.setFont(new Font("΢���ź�", Font.BOLD, 12));
				Bill.add(comboBox);

				JButton Search = new JButton("��ѯ");
				Search.setBounds(400, 10, 60, 30);// ��С
				Font font2 = new Font("����", Font.BOLD, 13);
				Search.setFont(font2);
				Search.setForeground(Color.blue);
				Search.setBorderPainted(true);// �����Ʊ߿�
				// Search.setContentAreaFilled(false);//ȡ�������
				Search.setBorder(BorderFactory.createEtchedBorder());

				// ����tab��table
			//	String[] temp1 = { "�γ���", "�γ̴���", "�����꼶", "�γ̷���" };
				Vector<String> temp1= new Vector<String>();
				temp1.add("�γ���");
				temp1.add("�γ̴���");
				temp1.add("�����꼶");
				temp1.add("�γ̷���");
				Vector<String> temp2= new Vector<String>();
				//String[] temp2;
			//	String[] temp3 = { "�ߵ���ѧ", "gs101", "��һ��", "300", "�������", "cs120", "��һ��", "500" };
				// String[] temp3= {" "};
				 //���ݿ����
				try {
					Connection con;
					String driver = "com.mysql.cj.jdbc.Driver";
					String url = "jdbc:mysql://127.12.216.221:3306/test?serverTimezone=UTC&useSSL=false&user=root&password=123456";

					Class.forName(driver);
					con = DriverManager.getConnection(url);
					if (!con.isClosed()) {
//						System.out.println("Succeed connecting to the Database!");
					}
					Statement statement = con.createStatement();
					String sql = "SELECT\r\n" + 
							"	evercourse.CourseID, \r\n" + 
							"	evercourse.CourseName, \r\n" + 
							"	course.Class, \r\n" + 
							"	course.Money\r\n" + 
							"FROM\r\n" + 
							"	evercourse,\r\n" + 
							"	course\r\n" + 
							"WHERE\r\n" + 
							"	(evercourse.CourseID = course.CourseID \r\n" + 
							"	AND StuID = "+Stu.StuID+") OR (evercourse.CourseID=course.CourseID+\"*\"AND StuID = "+Stu.StuID+")";
					ResultSet rs = statement.executeQuery(sql);
					while(rs.next()) {
						temp2.add(rs.getString("evercourse.CourseName"));
						temp2.add(rs.getString("evercourse.CourseID"));
						temp2.add(rs.getString("course.Class"));
						temp2.add(rs.getString("course.Money"));
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
				
				//����
				// ���temp2Ϊ��ҲҪָ��һ���ո���ΪԪ��
				Integer te = 0;
				if (temp2.size()!=0) {
					for (int i = 3; i <= temp2.size() - 1; i = i + 4) {
						te += Integer.parseInt(temp2.get(i));
					}
					temp2.add("�ܼ�");
					temp2.add(" ");
					temp2.add(" ");
					temp2.add(te.toString());
				}
				te = 0;

				JTabbedPane tabbedPane = new JTabbedPane();
				tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);// ����ѡ���ǩ�Ĳ��ַ�ʽΪ��������
				ModelDemo tablemodel = new ModelDemo(temp2, temp1);
				JTable table = new JTable(tablemodel);
				JTable table2 = new JTable();
				// table.getColumnModel().getColumn(0).setPreferredWidth(200);//����ĳ�еĿ��
				// table.setRowHeight(1, 100);//����ĳ�е��и�
				// table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);//�ر��Զ������еĿ�ȣ��������Ҫ�����������ÿ�еĿ��
				JScrollPane scrollpane = new JScrollPane(table);// ��ӱ�񵽹�����
				tabbedPane.addTab("ѧ���˵�", scrollpane);
				tabbedPane.setBounds(30, 50, 520, 350);
				tabbedPane.setSelectedIndex(0); // ��������Ϊ0��ѡ���ѡ��
				Bill.add(tabbedPane);

				Search.addMouseListener(new MouseAdapter() {
					@Override
					// �����
					public void mouseClicked(MouseEvent e) {
						super.mouseEntered(e);
						JButton btn = (JButton) e.getComponent();
						btn.setBorderPainted(true);// ��ʾ�߿�
						btn.setBorder(BorderFactory.createLoweredBevelBorder());
						String temp = (String) comboBox.getSelectedItem();
						Vector<String> t = new Vector<String>();
						Integer te = 0;
						if (temp != null) {
							if (temp == "��һ��") {
								for (int i = 0; i < (temp2.size() / 4); i++) {
									if (temp2.get(i*4+2).equals("��һ��") ) {
										for (int y = 0; y < 4; y++) {
											t.add(temp2.get(i*4+y));
										}
									}
								}
								if (!t.isEmpty()) {
									for (int i = 3; i <= t.size() - 1; i = i + 4) {
										te += Integer.parseInt(t.get(i));
									}
									t.add("�ܼ�");
									t.add(" ");
									t.add(" ");
									t.add(te.toString());
								}
								te = 0;
								tablemodel.setTableData(t);
								tablemodel.fireTableDataChanged();
								t.removeAllElements();
							} else if (temp == "ȫ��") {
								tablemodel.setTableData(temp2);
								tablemodel.fireTableDataChanged();
								t.removeAllElements();
							} else if (temp == "��һ��") {
								for (int i = 0; i < (temp2.size() / 4); i++) {
									if (temp2.get(i*4+2).equals("��һ��")) {
										for (int y = 0; y < 4; y++) {
											t.add(temp2.get(i*4+y));
										}
									}
								}
								if (!t.isEmpty()) {
									for (int i = 3; i <= t.size() - 1; i = i + 4) {
										te += Integer.parseInt(t.get(i));
									}
									t.add("�ܼ�");
									t.add(" ");
									t.add(" ");
									t.add(te.toString());
								}
								te = 0;
								tablemodel.setTableData(t);
								tablemodel.fireTableDataChanged();
								t.removeAllElements();
							}else if(temp=="��ѧ��") { 
								for(int i=0;i<(temp2.size()/4);i++)
								{
									if(temp2.get(i*4+1).substring(temp2.get(i*4+1).length()-1, temp2.get(i*4+1).length()).equals("*")) {
										for(int y=0;y<4;y++) {
											t.add(temp2.get(i*4+y));
										}
									}
								}
								if (!t.isEmpty()) {
									for (int i = 3; i <= t.size() - 1; i = i + 4) {
										te += Integer.parseInt(t.get(i));
									}
									t.add("�ܼ�");
									t.add(" ");
									t.add(" ");
									t.add(te.toString());
								}
								te = 0;
								tablemodel.setTableData(t);
								tablemodel.fireTableDataChanged();
								t.removeAllElements();
							}
							else if (temp == "�����") {
								for (int i = 0; i < (temp2.size() / 4); i++) {
									if (temp2.get(i*4+2).equals("�����")) {
										for (int y = 0; y < 4; y++) {
											t.add(temp2.get(i*4+y));
										}
									}
								}
								if (!t.isEmpty()) {
									for (int i = 3; i <= t.size() - 1; i = i + 4) {
										te += Integer.parseInt(t.get(i));
									}
									t.add("�ܼ�");
									t.add(" ");
									t.add(" ");
									t.add(te.toString());
								}
								te = 0;
								tablemodel.setTableData(t);
								tablemodel.fireTableDataChanged();
								t.removeAllElements();
							} else if (temp == "�����") {
								for (int i = 0; i < (temp2.size() / 4); i++) {
									if (temp2.get(i*4+2).equals("�����") ) {
										for (int y = 0; y < 4; y++) {
											t.add(temp2.get(i*4+y));
										}
									}
								}
								if (!t.isEmpty()) {
									for (int i = 3; i <= t.size() - 1; i = i + 4) {
										te += Integer.parseInt(t.get(i));
									}
									t.add("�ܼ�");
									t.add(" ");
									t.add(" ");
									t.add(te.toString());
								}
								te = 0;
								tablemodel.setTableData(t);
								tablemodel.fireTableDataChanged();
								t.removeAllElements();
							} else if (temp == "������") {
								for (int i = 0; i < (temp2.size() / 4); i++) {
									if (temp2.get(i*4+2).equals( "������")) {
										for (int y = 0; y < 4; y++) {
											t.add(temp2.get(i*4+y));
										}
									}
								}
								if (!t.isEmpty()) {
									for (int i = 3; i <= t.size() - 1; i = i + 4) {
										te += Integer.parseInt(t.get(i));
									}
									t.add("�ܼ�");
									t.add(" ");
									t.add(" ");
									t.add(te.toString());
								}
								te = 0;
								tablemodel.setTableData(t);
								tablemodel.fireTableDataChanged();
								t.removeAllElements();
							} else if (temp == "������") {
								for (int i = 0; i < (temp2.size() / 4); i++) {
									if (temp2.get(i*4+2).equals("������")){
										for (int y = 0; y < 4; y++) {
											t.add(temp2.get(i*4+y));
										}
									}
								}
								if (!t.isEmpty()) {
									for (int i = 3; i <= t.size() - 1; i = i + 4) {
										te += Integer.parseInt(t.get(i));
									}
									t.add("�ܼ�");
									t.add(" ");
									t.add(" ");
									t.add(te.toString());
								}
								te = 0;
								tablemodel.setTableData(t);
								tablemodel.fireTableDataChanged();
								t.removeAllElements();
							} else if (temp == "������") {
								for (int i = 0; i < (temp2.size() / 4); i++) {
									if (temp2.get(i*4+2).equals( "������") ){
										for (int y = 0; y < 4; y++) {
											t.add(temp2.get(i*4+y));
										}
									}
								}
								if (!t.isEmpty()) {
									for (int i = 3; i <= t.size() - 1; i = i + 4) {
										te += Integer.parseInt(t.get(i));
									}
									t.add("�ܼ�");
									t.add(" ");
									t.add(" ");
									t.add(te.toString());
								}
								te = 0;
								tablemodel.setTableData(t);
								tablemodel.fireTableDataChanged();
								t.removeAllElements();
							} else if (temp == "������") {
								for (int i = 0; i < (temp2.size() / 4); i++) {
									if (temp2.get(i*4+2).equals("������")) {
										for (int y = 0; y < 4; y++) {
											t.add(temp2.get(i*4+y));
										}
									}
								}
								if (!t.isEmpty()) {
									for (int i = 3; i <= t.size() - 1; i = i + 4) {
										te += Integer.parseInt(t.get(i));
									}
									t.add("�ܼ�");
									t.add(" ");
									t.add(" ");
									t.add(te.toString());
								}
								te = 0;
								tablemodel.setTableData(t);
								tablemodel.fireTableDataChanged();
								t.removeAllElements();
							}
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
				Bill.add(Search);

				bill.setVisible(true);

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
		Test.add(billinfo);
//ѡ��γ�
		JButton lessonc = new JButton("ѡ��γ�");
		lessonc.setBounds(420, 232, 300, 50);// ��С���30
		lessonc.setFont(font3);
		lessonc.setForeground(new Color(219, 69, 32));
		lessonc.setToolTipText("��ʼ��ѧ�ڵ�ѡ��");
		lessonc.setBorderPainted(true);// ���Ʊ߿�
		lessonc.setBorder(BorderFactory.createEtchedBorder());// ��̱߿�
		lessonc.setContentAreaFilled(false);// ȡ�������

		boolean isstart[] = {true};// ѡ���Ƿ�ʼ�ı�־
		// �˴���Ҫ��ѯ�γ̱��з��ϸ�ѧ�������꼶������ϵ����������ʦ�Ŀγ����ѧ�����޿��������ѧ���ݴ��
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
					"	info.Stuisstart\r\n" + 
					"FROM\r\n" + 
					"	info\r\n" + 
					"WHERE\r\n" + 
					"	info.Ver = 1";
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				if(Integer.parseInt(rs.getString("info.Stuisstart"))==0)
					isstart[0]=false;
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
		lessonc.addMouseListener(new MouseAdapter() {
			@Override
			// �����
			public void mouseClicked(MouseEvent e) {
				super.mouseEntered(e);
				JButton btn = (JButton) e.getComponent();
				btn.setBorderPainted(true);// ��ʾ�߿�
				btn.setBorder(BorderFactory.createLoweredBevelBorder());// ���ݱ߿�

				if (!isstart[0]) {
					JOptionPane.showMessageDialog(null, "δ��ѡ��ʱ�䣡", "��ʾ", JOptionPane.WARNING_MESSAGE);
				} else {// ��������ѡ��ʱ���ڵĴ���

					JDialog less = new JDialog();
					less.setModal(true);// ����Ϊģ̬
					
					Vector<String> temp1=new Vector<String>();
					temp1.add("�γ���");
					temp1.add("�γ̴���");
					temp1.add("�Ͽ�ʱ��");
					temp1.add("�Ⱦ�����");
					temp1.add("�ڿν���");
					temp1.add("�γ̷���");
					// ��������
					Vector<String> temp2=new Vector<String>();
					Vector<String> temp3=new Vector<String>();
					Vector<String> tem3=new Vector<String>();//���ڶ�ȡ���ݿ����ݴ�Ŀ���
					String[] tem1 = { "�ƻ�����", "�γ���", "�γ̴���", "�Ͽ�ʱ��", "�Ⱦ�����", "�ڿν���", "�γ̷���" };
					Vector<String> temp4=new Vector<String>();
					Vector<String> temp5=new Vector<String>();//�ʸ����Ϣ
					String isnowc=" ";
					for(int i=0;i<tem1.length;i++)
					{
						temp3.add(tem1[i]);
					}
					for(int i=0;i<42;i++)
					{
						if(i==0)
							temp4.add("��ѡ��1");
						else if(i==7)
							temp4.add("��ѡ��2");
						else if(i==14)
							temp4.add("��ѡ��3");
						else if(i==21)
							temp4.add("��ѡ��4");
						else if(i==28)
							temp4.add("��ѡ��1");
						else if(i==35)
							temp4.add("��ѡ��2");
						else
							temp4.add(" ");
					}
					Integer gra=0;
					 //���ݿ����
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

						 String sql = "select GraduationTime from student where StuID = "+Stu.StuID;
						 ResultSet rs = statement.executeQuery(sql);
						 while(rs.next()) {
							  gra=rs.getInt("GraduationTime");
						 }
						 gra=4-(gra/10000%100-20);
						 Vector <String>classlevel=new Vector<String>();
						 if(gra==1)
						 {
							 classlevel.add("��һ��");
							 classlevel.add("��һ��");
						 }else if(gra==2)
						 {
							 classlevel.add("�����");
							 classlevel.add("�����");
						 }else if(gra==3)
						 {
							 classlevel.add("������");
							 classlevel.add("������");
						 }else if(gra==4)
						 {
							 classlevel.add("������");
							 classlevel.add("������");
						 }

	
						 sql = "SELECT\r\n" + 
								"	course.CourseName, \r\n" + 
								"	course.CourseID, \r\n" + 
								"	course.CourseTime, \r\n" + 
								"	course.Condition, \r\n" + 
								"	course.Professor, \r\n" + 
								"	course.Money\r\n" + 
								"FROM\r\n" + 
								"	course\r\n" + 
								"WHERE\r\n" + 
								"	course.Class ="+"\""+classlevel.get(0)+"\""+" or course.Class= "+"\""+classlevel.get(1)+"\"";
						 rs = statement.executeQuery(sql);
						while(rs.next()) {
							temp2.add(rs.getString("course.CourseName"));
							temp2.add(rs.getString("course.CourseID"));
							temp2.add(rs.getString("course.CourseTime"));
							temp2.add(rs.getString("course.Condition"));
							temp2.add(rs.getString("course.Professor"));
							temp2.add(rs.getString("course.Money"));
						}
						sql="SELECT\r\n" + 
								"	templan.Base1, \r\n" + 
								"	templan.Base2, \r\n" + 
								"	templan.Base3, \r\n" + 
								"	templan.Base4, \r\n" + 
								"	templan.Temp1, \r\n" + 
								"	templan.Temp2\r\n" + 
								"FROM\r\n" + 
								"	templan\r\n" + 
								"WHERE\r\n" + 
								"	templan.StuID = "+Stu.StuID;
						 rs = statement.executeQuery(sql);
						while(rs.next()) {
							if(rs.getString("templan.Base1")!=null)
								tem3.add(rs.getString("templan.Base1"));	
							if(rs.getString("templan.Base2")!=null)
								tem3.add(rs.getString("templan.Base2"));	
							if(rs.getString("templan.Base3")!=null)
								tem3.add(rs.getString("templan.Base3"));	
							if(rs.getString("templan.Base4")!=null)
								tem3.add(rs.getString("templan.Base4"));	
							if(rs.getString("templan.Temp1")!=null)
								tem3.add(rs.getString("templan.Temp1"));	
							if(rs.getString("templan.Temp2")!=null)
								tem3.add(rs.getString("templan.Temp2"));	
						}
						sql="SELECT\r\n" + 
								"	evercourse.CourseName\r\n" + 
								"FROM\r\n" + 
								"	evercourse\r\n" + 
								"WHERE\r\n" + 
								"	evercourse.StuID = "+Stu.StuID;
						 rs = statement.executeQuery(sql);
							while(rs.next()) {
								temp5.add(rs.getString("evercourse.CourseName"));
							}
						sql="SELECT\r\n" + 
								"	nowc.CourseID\r\n" + 
								"FROM\r\n" + 
								"	nowc\r\n" + 
								"WHERE\r\n" + 
								"	nowc.StuID = "+Stu.StuID;
						rs = statement.executeQuery(sql);
							while(rs.next()) {
								isnowc=rs.getString("nowc.CourseID");
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
						System.out.println("?");
					}

					//����
					//�����ݴ��
					int x=0;
					for(int i=0;i<temp2.size();i+=6)
					{
						for(int j=0;j<tem3.size();j++)
						{
							if(temp2.get(i).equals(tem3.get(j)))
							{
								for(x=1;x<temp4.size();x+=7)//Ѱ�ҿ�λ
								{
									if(temp4.get(x).equals(" "))
										break;
								}
								for(int y=0;y<6;y++)//��ӵ�temp4
									temp4.set(x+y, temp2.get(i+y));				
								for(int y=0;y<6;y++)//ɾ��temp2
									temp2.remove(i);
								i-=6;
								x=0;
								break;
							}
						}
					}
					
					//temp2��temp4�����꣬tem3ʧȥ����

					boolean[] flag = { false, false, false };
// 	   	          boolean issave=false;//�Ƿ��ύ
// 	   	          boolean exchange=false;//�޸ı��
// 	   	          boolean save=false;//������

					if (temp4.get(1).equals(" ")) {
						less.setTitle("ѡ�ν��棨״̬����ѡ�μƻ���");
					} else if (isnowc.equals(" ")) {
						less.setTitle("ѡ�ν��棨״̬��δ�ύ��");
					} else if (!isnowc.equals(" ")) {
						less.setTitle("ѡ�ν��棨״̬�����ύ��");
						flag[0]=true;
					}

					less.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
					less.setResizable(false);// ���ɵ�����С

					Dimension d = Toolkit.getDefaultToolkit().getScreenSize();// �����Ļ�ߴ�
					int width = 900;// The application's width
					int height = 500;
					less.setBounds((d.width - width) / 2, (d.height - height) / 2, width, height);// ���ڵ�����ͳߴ磬���ַ�ʽ����
					less.setLayout(null);// ���ò��ַ�ʽ

					// ͼƬ�е�
					JPanel Less = new HomePanel(2);
					Less.setLayout(null);
					Less.setBounds(0, 0, width, height);
					less.add(Less);

					less.addWindowListener(new WindowAdapter() {
						@Override
						public void windowClosing(WindowEvent e) {
							if (flag[1] != false && flag[2] == false) {
								int option = JOptionPane.showConfirmDialog(null, "��δ���������,�Ƿ񱣴�? ", "��ʾ ",
										JOptionPane.YES_NO_OPTION);
								if (option == JOptionPane.YES_OPTION) {
									// �˴���ӱ���Ĵ���
									//���ݿ����
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
										Vector<String> sqlstack = new Vector<String>();
										Vector<String> lesname = new Vector<String>();
										lesname.add("Base1");
										lesname.add("Base2");
										lesname.add("Base3");
										lesname.add("Base4");
										lesname.add("Temp1");
										lesname.add("Temp2");
										int n=0;
										String t=null;
										for(int i=1;i<42;i+=7)
										{
											if(!temp4.get(i).equals(" "))
											{
												sqlstack.add("update templan set "+lesname.get(n)+"="+"\""+temp4.get(i)+"\""+" where StuID="+Stu.StuID);
											}else
											{
												sqlstack.add("update templan set "+lesname.get(n)+"="+t+" where StuID="+Stu.StuID);
											}
											n++;
										}
										n=0;
										for (int i = 0; i < sqlstack.size(); i++) {
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
									//��������
									JOptionPane.showMessageDialog(null, "����ɹ����뼰ʱ�ύ����", "��ʾ", JOptionPane.WARNING_MESSAGE);
									less.dispose();
								} else {
									less.dispose();
								}
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

					JLabel lessont = new JLabel("���ڿ���ʦ����", JLabel.CENTER);
					lessont.setFont(new Font("΢���ź�", Font.BOLD, 13));
					lessont.setBounds(490, 10, 100, 30);
					Less.add(lessont);

					JTextField lessonteacher = new JTextField(10);
					lessonteacher.setBounds(600, 10, 120, 30);
					Less.add(lessonteacher);

					JTabbedPane tabbedPane = new JTabbedPane();
					tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);// ����ѡ���ǩ�Ĳ��ַ�ʽΪ��������

					ModelDemo tablemodel = new ModelDemo(temp2, temp1);
					ModelDemo tablemodel2 = new ModelDemo(temp4, temp3);
					JTable table = new JTable(tablemodel);
					JTable table2 = new JTable(tablemodel2);
					table.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent e) {
							int y = 0;//��row������
							boolean pre = false;//�Ƿ������Ⱦ�����,Ĭ�ϲ�����
							boolean pre2 = true;//�Ƿ��ճ̳�ͻ��Ĭ�ϲ���ͻ
							int p2=-1;//�����ճ̳�ͻ�Ŀγ�λ��
							if (e.getClickCount() == 2)// ʵ��˫���¼�
							{
								int row = ((JTable) e.getSource()).rowAtPoint(e.getPoint()); // �����λ��
								if (!temp4.get(41).equals(" "))// �ж��Ƿ��п�λ
								{
									JOptionPane.showMessageDialog(null, "��ѡ�б�������", "��ʾ", JOptionPane.WARNING_MESSAGE);
									return;
								}
								if(temp2.get(row*6+3)!=null) {//�ж��Ⱦ�������ǰ��������Ϊ��
									for(int j=0;j<temp5.size();j++)
									{
										if(temp2.get(row * 6 + 3).equals(temp5.get(j)))
										{
											pre = true;
											break;
										}
									}
								}else
									pre=true;
								for (int i = 3; i < temp4.size(); i += 7) {
									if (temp2.get(row * 6 + 2).equals(temp4.get(i))) {
										pre2 = false;
										p2=i-2;
										break;
									}
								}
								if (pre == true  && pre2 == true)// �ж��Ⱦ��������ճ̳�ͻ
								{
									int option = JOptionPane.showConfirmDialog(null, "�Ƿ�Ҫ����ѡ�γ̼���ѡ���б� ", "��ʾ ",
											JOptionPane.YES_NO_OPTION);
									if (option == JOptionPane.YES_OPTION) {
										for (int i = 0; i < 42; i += 7)// Ѱ�ҵ�һ����λ
										{
											if (temp4.get(i + 1).equals(" ")) {
												y = i + 1;//�ҵ����ֵ����y
												break;
											}
										}
										for (int x = 0; x < 6; x++) {
											temp4.set(y, temp2.get(row * 6));
											temp2.remove(row * 6);
											y++;
										}
										y = 0;
										tablemodel.setTableData(temp2);
										tablemodel.fireTableDataChanged();
										tablemodel2.setTableData(temp4);
										tablemodel2.fireTableDataChanged();
										flag[0]=false;
										flag[1]=true;
										flag[2]=false;
										less.setTitle("ѡ�ν��棨״̬��δ���棩");
									}

								} else {
									if (pre2 == false)
										JOptionPane.showMessageDialog(null, "�� "+temp4.get(p2)+" �ճ̳�ͻ��", "��ʾ", JOptionPane.WARNING_MESSAGE);
									else
										JOptionPane.showMessageDialog(null, "�������Ⱦ�������", "��ʾ",
												JOptionPane.WARNING_MESSAGE);
									p2=-1;
									return;
								}
								// int row =((JTable)e.getSource()).rowAtPoint(e.getPoint()); //�����λ��
								// int col=((JTable)e.getSource()).columnAtPoint(e.getPoint()); //�����λ��
								// String cellVal=(String)(tablemodel.getValueAt(row,col)); //��õ����Ԫ������

							}
						}
					});

					table2.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent e) {
							int y = 0;
//							boolean pre = false;
//							boolean pre2=true;
							if (e.getClickCount() == 2)// ʵ��˫���¼�
							{
								int row = ((JTable) e.getSource()).rowAtPoint(e.getPoint()); // �����λ��
								if (temp4.get(row * 7 + 1).equals(" "))
									return;
								else {
									y = row;
									int option = JOptionPane.showConfirmDialog(null, "�Ƿ�ȷ���Ƴ��ÿγ�? ", "��ʾ ",
											JOptionPane.YES_NO_OPTION);
									if (option == JOptionPane.YES_OPTION) {
										for (int i = 0; i < 6; i++) {
											temp2.add(temp4.get(row * 7 + 1 + i));
											temp4.set(row * 7 + 1 + i, " ");
										}
										tablemodel.setTableData(temp2);
										tablemodel.fireTableStructureChanged();
										if (row != 5) {
											while (!temp4.get(y * 7 + 8).equals(" ")) {//�ж���һ���Ƿ�������
												for (int i = 1; i < 7; i++) {
													temp4.set(y * 7 + i, temp4.get(y * 7 + 7 + i));
													temp4.set(y * 7 + 7 + i, " ");
												}
												y++;
												if (y == 5)
													break;
											}
											tablemodel2.setTableData(temp4);
											tablemodel2.fireTableStructureChanged();
										}
										flag[0]=false;
										flag[1] = true;
										flag[2]=false;
										less.setTitle("ѡ�ν��棨״̬��δ���棩");
									}
								}
							}
						}
					});

					JButton  Saving= new JButton("����");
					Saving.setBounds(710, 220, 130, 50);// ��С���30
					Saving.setFont(font3);
					Saving.setForeground(new Color(219, 69, 32));
					Saving.setToolTipText("�ݴ�ѡ�μƻ�");
					Saving.setBorderPainted(true);// ���Ʊ߿�
					Saving.setBorder(BorderFactory.createEtchedBorder());// ��̱߿�
					//Saving.setContentAreaFilled(false);// ȡ�������					
					Saving.addMouseListener(new MouseAdapter() {
						@Override
						// �����
						public void mouseClicked(MouseEvent e) {
							//���ݿ����
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
								Vector<String> sqlstack = new Vector<String>();
								Vector<String> lesname = new Vector<String>();
								lesname.add("Base1");
								lesname.add("Base2");
								lesname.add("Base3");
								lesname.add("Base4");
								lesname.add("Temp1");
								lesname.add("Temp2");
								int n=0;
								String t=null;
								for(int i=1;i<42;i+=7)
								{
									if(!temp4.get(i).equals(" "))
									{
										sqlstack.add("update templan set "+lesname.get(n)+"="+"\""+temp4.get(i)+"\""+" where StuID="+Stu.StuID);
									}else
									{
										sqlstack.add("update templan set "+lesname.get(n)+"="+t+" where StuID="+Stu.StuID);
									}
									n++;
								}
								n=0;
								for (int i = 0; i < sqlstack.size(); i++) {
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
							//��������
							flag[0]=false;
						    flag[1]=false;
						    flag[2]=true;
						    less.setTitle("ѡ�ν��棨״̬���ѱ��棩");
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
					
					Less.add(Saving);
					
					
					JButton  Submit= new JButton("�ύ");
					Submit.setBounds(710, 300, 130, 50);// ��С���30
					Submit.setFont(font3);
					Submit.setForeground(new Color(219, 69, 32));
					Submit.setToolTipText("�ύѡ�μƻ���ϵͳ");
					Submit.setBorderPainted(true);// ���Ʊ߿�
					Submit.setBorder(BorderFactory.createEtchedBorder());// ��̱߿�
					//Submit.setContentAreaFilled(false);// ȡ�������


				
					Submit.addMouseListener(new MouseAdapter() {
						@Override
						// �����
						public void mouseClicked(MouseEvent e) {
							//�ύ��������
							//���ݿ����
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
								Vector<String> sqlstack = new Vector<String>();
								Vector<String> lesname = new Vector<String>();
								lesname.add("Base1");
								lesname.add("Base2");
								lesname.add("Base3");
								lesname.add("Base4");
								lesname.add("Temp1");
								lesname.add("Temp2");
								int n=0;
								String t=null;
								for(int i=1;i<42;i+=7)
								{
									if(!temp4.get(i).equals(" "))
									{
										sqlstack.add("update templan set "+lesname.get(n)+"="+"\""+temp4.get(i)+"\""+" where StuID="+Stu.StuID);
									}else
									{
										sqlstack.add("update templan set "+lesname.get(n)+"="+t+" where StuID="+Stu.StuID);
									}
									n++;
								}
								n=0;
								for (int i = 0; i < sqlstack.size(); i++) {
								statement.executeUpdate(sqlstack.get(i));
							}
								//�����Ǳ��浽�ݴ����
								sqlstack.removeAllElements();
								//����ɾ��nowc��tempc��ı���
								System.out.println(statement.executeUpdate("delete from nowc where StuID="+Stu.StuID));
								System.out.println(statement.executeUpdate("delete from tempc where StuID="+Stu.StuID));
								//ɾ������
								for(int i=0;i<4;i++)
								{
									if(!temp4.get(i*7+2).equals(" "))
									    sqlstack.add("insert into nowc values("+"\""+temp4.get(i*7+2)+"\","+Stu.StuID+")");
									else
										n=-1;
								}
								if(n!=-1)
								for(int i=4;i<6;i++)
								{
									if(!temp4.get(i*7+2).equals(" "))
									sqlstack.add("insert into tempc values("+"\""+temp4.get(i*7+2)+"\","+Stu.StuID+")");
								}
								n=0;
								for (int i = 0; i < sqlstack.size(); i++) {
								statement.executeUpdate(sqlstack.get(i));
							}//�����Ǵ浽nowc��tempc��
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
							//��������
							
							flag[0]=true;
						    flag[1]=false;
						    flag[2]=true;
						    less.setTitle("ѡ�ν��棨״̬�����ύ��");
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
					
					Less.add(Submit);
					
					JScrollPane scrollpane = new JScrollPane(table);// ��ӱ�񵽹�����
					JScrollPane scrollpane2 = new JScrollPane(table2);
					tabbedPane.addTab("��ѡ�α�", scrollpane);
					tabbedPane.addTab("��ѡ�α�", scrollpane2);

					tabbedPane.setBounds(30, 70, 620, 370);
					tabbedPane.setSelectedIndex(0); // ��������Ϊ0��ѡ���ѡ��
					Less.add(tabbedPane);

					JButton Search = new JButton("��ѯ");
					Search.setBounds(735, 10, 60, 30);// ��С
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
							String info3 = lessonteacher.getText().trim();
							if (info.equals("")) {
								if (info2.equals("")) {
									if (info3.equals("")) {
										tablemodel.setTableData(temp2);
										tablemodel.fireTableDataChanged();
									} else
										Selectlessontool1(info3, 4, tablemodel, temp2);
								} else {
									if (info3.equals(""))
										Selectlessontool1(info2, 1, tablemodel, temp2);
									else
										Selectlessontool2(info2, info3, 1, 4, tablemodel, temp2);

								}
							} else {
								if (info2.equals("")) {
									if (info3.equals(""))
										Selectlessontool1(info, 0, tablemodel, temp2);
									else
										Selectlessontool2(info, info3, 0, 4, tablemodel, temp2);
								} else {
									if (info3.equals(""))
										Selectlessontool2(info, info2, 0, 1, tablemodel, temp2);
									else
										Selectlessontool3(info, info2, info3, 0, 1, 4, tablemodel, temp2);
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
					Reset.setBounds(810, 10, 60, 30);// ��С
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
							lessonteacher.setText(" ");
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
					Less.add(Reset);
					Less.add(Search);
					less.setVisible(true);

				} // �ж�ѡ���Ƿ�ʼ�Ļ�����

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

		JButton gradeseek = new JButton("��ѯ�ɼ�");
		gradeseek.setBounds(420, 312, 300, 50);// ��С���30
		gradeseek.setFont(font3);
		gradeseek.setForeground(new Color(219, 69, 32));
		gradeseek.setToolTipText("��ѯ��ʷ�ɼ�");
		gradeseek.setBorderPainted(true);// ���Ʊ߿�
		gradeseek.setBorder(BorderFactory.createEtchedBorder());// ��̱߿�
		gradeseek.setContentAreaFilled(false);// ȡ�������
		gradeseek.addMouseListener(new MouseAdapter() {

				
				@Override
				// �����
				public void mouseClicked(MouseEvent e) {
					super.mouseEntered(e);
					JButton btn = (JButton) e.getComponent();
					btn.setBorderPainted(true);// ��ʾ�߿�
					btn.setBorder(BorderFactory.createLoweredBevelBorder());

					JDialog grade = new JDialog();
					grade.setModal(true);
					grade.setTitle("��ѯ�ɼ�����");
					grade.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
					grade.setResizable(false);// ���ɵ�����С

					Dimension d = Toolkit.getDefaultToolkit().getScreenSize();// �����Ļ�ߴ�
					int width = 600;// The application's width
					int height = 450;
					int x = (d.width - width) / 2;
					int y = (d.height - height) / 2;
					grade.setBounds((d.width - width) / 2, (d.height - height) / 2, width, height);// ���ڵ�����ͳߴ磬���ַ�ʽ����
					grade.setLayout(null);// ���ò��ַ�ʽ

					// ͼƬ�е�
					JPanel Grade = new HomePanel(2);
					Grade.setLayout(null);
					Grade.setBounds(0, 0, width, height);
					grade.add(Grade);

					JLabel choic = new JLabel("ѡ��ѧ��", JLabel.CENTER);
					choic.setFont(new Font("����", 1, 15));
					choic.setBounds(10, 10, 120, 30);
					Grade.add(choic);

					String[] listData = new String[] { "ȫ��", "��һ��", "��һ��", "�����", "�����", "������", "������", "������",
							"������" };
					String[] listD;
					Integer gra=0;
					 //���ݿ����
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
						String sql = "select GraduationTime from student where StuID = "+Stu.StuID;
						ResultSet rs = statement.executeQuery(sql);
						while(rs.next()) {
						    gra=rs.getInt("GraduationTime");
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
					
					//����
					gra=gra/10000%100-20;
					listD=new String[(listData.length-gra*2)];
					for(int i=0;i<(listData.length-gra*2);i++)
					{
						listD[i]=listData[i];
					}
					JComboBox<String> comboBox = new JComboBox<String>(listD);
					comboBox.setSelectedIndex(0);
					comboBox.setBounds(150, 12, 100, 25);
					comboBox.setFont(new Font("΢���ź�", Font.BOLD, 12));
					Grade.add(comboBox);

					JButton Search = new JButton("����");
					Search.setBounds(400, 10, 60, 30);// ��С
					Font font2 = new Font("����", Font.BOLD, 13);
					Search.setFont(font2);
					Search.setForeground(Color.blue);
					Search.setBorderPainted(true);// �����Ʊ߿�
					// Search.setContentAreaFilled(false);//ȡ�������
					Search.setBorder(BorderFactory.createEtchedBorder());

					
					
					// ����tab��table
					Vector <String>temp1=new Vector<String>();
					temp1.add("�γ���");
					temp1.add("�γ̴���");
					temp1.add("�ڿν���");
					temp1.add("�����꼶");
					temp1.add("�ɼ�");
					Vector<String> temp2=new Vector<String>();
					 //���ݿ����
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
						String sql = "SELECT\r\n" + 
								"	evercourse.CourseID, \r\n" + 
								"	course.CourseName, \r\n" + 
								"	course.Class, \r\n" + 
								"	evercourse.Grade, \r\n" + 
								"	professor.ProName\r\n" + 
								"FROM\r\n" + 
								"	evercourse,\r\n" + 
								"	course,\r\n" + 
								"	professor\r\n" + 
								"WHERE\r\n" + 
								"	professor.ProID = evercourse.ProID AND\r\n" + 
								"	evercourse.CourseID = course.CourseID AND\r\n" + 
								"	evercourse.StuID ="+Stu.StuID;
						ResultSet rs = statement.executeQuery(sql);
						while(rs.next()) {
							temp2.add(rs.getString("course.CourseName"));
							temp2.add(rs.getString("evercourse.CourseID"));
							temp2.add(rs.getString("professor.ProName"));
							temp2.add(rs.getString("course.Class"));
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
					
					//����
					// ���temp2Ϊ��ҲҪָ��һ���ո���ΪԪ��
					JTabbedPane tabbedPane = new JTabbedPane();
					tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);// ����ѡ���ǩ�Ĳ��ַ�ʽΪ��������
					ModelDemo tablemodel = new ModelDemo(temp2, temp1);
					JTable table = new JTable(tablemodel);
					// table.getColumnModel().getColumn(0).setPreferredWidth(200);//����ĳ�еĿ��
					// table.setRowHeight(1, 100);//����ĳ�е��и�
					// table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);//�ر��Զ������еĿ�ȣ��������Ҫ�����������ÿ�еĿ��
					JScrollPane scrollpane = new JScrollPane(table);// ��ӱ�񵽹�����
					tabbedPane.addTab("�ɼ����", scrollpane);
					tabbedPane.setBounds(30, 50, 520, 350);
					tabbedPane.setSelectedIndex(0); // ��������Ϊ0��ѡ���ѡ��
					Grade.add(tabbedPane);

					Search.addMouseListener(new MouseAdapter() {
						@Override
						// �����
						public void mouseClicked(MouseEvent e) {
							super.mouseEntered(e);
							JButton btn = (JButton) e.getComponent();
							btn.setBorderPainted(true);// ��ʾ�߿�
							btn.setBorder(BorderFactory.createLoweredBevelBorder());
							String temp = (String) comboBox.getSelectedItem();
							Vector<String> t = new Vector<String>();
							if (temp != null) {
								if (temp == "��һ��") {
									for (int i = 0; i < (temp2.size() / 5); i++) {
										if (temp2.get(i*5+3).equals("��һ��")) {
											for (int y = 0; y < 5; y++) {

												t.add(temp2.get(i*5+y));
											}
										}
									}
									tablemodel.setTableData(t);
									tablemodel.fireTableDataChanged();
									t.removeAllElements();
								} else if (temp == "ȫ��") {
									for (int i = 0; i < temp2.size(); i++) {
										t.add(temp2.get(i));
									}
									tablemodel.setTableData(t);
									tablemodel.fireTableDataChanged();
									t.removeAllElements();
								} else if (temp == "��һ��") {
									for (int i = 0; i < (temp2.size() / 5); i++) {
										if (temp2.get(i*5+3).equals("��һ��")) {
											for (int y = 0; y < 5; y++) {

												t.add(temp2.get(i*5+y));
											}
										}
									}
									tablemodel.setTableData(t);
									tablemodel.fireTableDataChanged();
									t.removeAllElements();
								} else if (temp == "�����") {
									for (int i = 0; i < (temp2.size() / 5); i++) {
										if (temp2.get(i*5+3).equals("�����")) {
											for (int y = 0; y < 5; y++) {

												t.add(temp2.get(i*5+y));
											}
										}
									}
									tablemodel.setTableData(t);
									tablemodel.fireTableDataChanged();
									t.removeAllElements();
								} else if (temp == "�����") {
									for (int i = 0; i < (temp2.size() / 5); i++) {
										if (temp2.get(i*5+3).equals("�����")) {
											for (int y = 0; y < 5; y++) {

												t.add(temp2.get(i*5+y));
											}
										}
									}
									tablemodel.setTableData(t);
									tablemodel.fireTableDataChanged();
									t.removeAllElements();
								} else if (temp == "������") {
									for (int i = 0; i < (temp2.size() / 5); i++) {
										if (temp2.get(i*5+3).equals("������")) {
											for (int y = 0; y < 5; y++) {

												t.add(temp2.get(i*5+y));
											}
										}
									}
									tablemodel.setTableData(t);
									tablemodel.fireTableDataChanged();
									t.removeAllElements();
								} else if (temp == "������") {
									for (int i = 0; i < (temp2.size() / 5); i++) {
										if (temp2.get(i*5+3).equals("������")) {
											for (int y = 0; y < 5; y++) {

												t.add(temp2.get(i*5+y));
											}
										}
									}
									tablemodel.setTableData(t);
									tablemodel.fireTableDataChanged();
									t.removeAllElements();
								} else if (temp == "������") {
									for (int i = 0; i < (temp2.size() / 5); i++) {
										if (temp2.get(i*5+3).equals("������")) {
											for (int y = 0; y < 5; y++) {

												t.add(temp2.get(i*5+y));
											}
										}
									}
									tablemodel.setTableData(t);
									tablemodel.fireTableDataChanged();
									t.removeAllElements();
								} else if (temp == "������") {
									for (int i = 0; i < (temp2.size() / 5); i++) {
										if (temp2.get(i*5+3).equals("������")) {
											for (int y = 0; y < 5; y++) {

												t.add(temp2.get(i*5+y));
											}
										}
									}
									tablemodel.setTableData(t);
									tablemodel.fireTableDataChanged();
									t.removeAllElements();
								}
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
					Grade.add(Search);

					grade.setVisible(true);
				
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
		Test.add(gradeseek);

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

	}

	public void Selectlessontool1(String info, int t, ModelDemo tablemodel, Vector<String> temp) {
		Vector<String> tem = new Vector<String>();
		for (int i = t; i < temp.size(); i += 6) {
			if (temp.get(i).indexOf(info)!=-1) {
				for (int j = i - t; j < i + 6 - t; j++) {
					tem.add(temp.get(j));
				}
			}
		}
		tablemodel.setTableData(tem);
		tablemodel.fireTableDataChanged();
	}

	public void Selectlessontool2(String info, String info2, int t, int r, ModelDemo tablemodel, Vector<String> temp) {
		Vector<String> tem = new Vector<String>();
		for (int i = t; i < temp.size(); i += 6) {
			if (temp.get(i).indexOf(info)!=-1 && temp.get(i + r - t).indexOf(info2)!=-1) {
				for (int j = i - t; j < i + 6 - t; j++) {
					tem.add(temp.get(j));
				}
			}
		}
		tablemodel.setTableData(tem);
		tablemodel.fireTableDataChanged();
	}

	public void Selectlessontool3(String info, String info2, String info3, int t, int r, int e, ModelDemo tablemodel,
			Vector<String> temp) {
		Vector<String> tem = new Vector<String>();
		for (int i = t; i < temp.size(); i += 6) {
			if (temp.get(i).indexOf(info)!=-1 && temp.get(i + r - t).indexOf(info2)!=-1 && temp.get(i + e - t).indexOf(info3)!=-1) {
				for (int j = i - t; j < i + 6 - t; j++) {
					tem.add(temp.get(j));
				}
			}
		}
		tablemodel.setTableData(tem);
		tablemodel.fireTableDataChanged();
	}

//������	
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
	class Student{
		private String StuID;
		private String StuName;
		private String StuPassw;
		Student(String StuID,String StuName,String StuPassw){
			this.StuID = StuID;
			this.StuName = StuName;
			this.StuPassw=StuPassw;
		}
		
		public void QueryResult(){
			Connection con;
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC";
			String user = "root";
			String password = "root";
			try {
				Class.forName(driver);
				con = DriverManager.getConnection(url,user,password);
				if(!con.isClosed()) {
					System.out.println("Succeed connecting to the Database!");
				}
				
				/*�г��ɼ���*/
				Statement statement = con.createStatement();
				String sql = "select CourseID,CourseName,Grade from evercourse where StuID = "+this.StuID;
				ResultSet rs = statement.executeQuery(sql);
				
				System.out.println("��ѯ�ɼ�ϵͳ");
				System.out.println("-----------------");
				System.out.println("�������ĳɼ��嵥��");
				System.out.println("-----------------");
				System.out.println("CourseID"+"\t"+"CourseName"+"\t"+"Grade");
				while(rs.next()) {
					System.out.println(rs.getString("CourseID")+"\t\t"+rs.getString("CourseName")+"\t\t"+rs.getString("Grade"));
				}
				rs.close();
				con.close();
			}catch(ClassNotFoundException e) {
				System.out.println("Sorry,can't find the Driver!");
			}catch(SQLException e) {
				System.out.println("���ݿ�ִ�г�����");
			}catch(Exception e) {
				System.out.println("������󣡣�");
			}		
		}
		
		public void ChangePassWord() {
			System.out.println("�޸�����ϵͳ");
			Connection con;
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC";
			String user = "root";
			String password = "root";
			try {
				Class.forName(driver);
				con = DriverManager.getConnection(url,user,password);
				if(!con.isClosed()) {
					System.out.println("Succeed connecting to the Database!");
				}
				
				System.out.println("--------------");
				System.out.println("�������µ����룺");
				System.out.println("--------------");
				
				String pw = "Zjh1013";
				/*�޸�����sql���*/
				Statement statement = con.createStatement();
				String sql = "update student set StuPassword = \""+pw+"\" where StuID = "+this.StuID;
				int Result = statement.executeUpdate(sql);
				if(Result == 0) {
					System.out.println("����ʧ��");
				}else {
					System.out.println("���³ɹ�");
				}
				con.close();
			}catch(ClassNotFoundException e) {
				System.out.println("Sorry,can't find the Driver!");
			}catch(SQLException e) {
				System.out.println("���ݿ�ִ�г�����");
			}catch(Exception e) {
				System.out.println("������󣡣�");
			}		
		}
	}
}
