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

//gui代码		
		setTitle("教授端界面");
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int option = JOptionPane.showConfirmDialog(null, "确定退出系统? ", "提示 ", JOptionPane.YES_NO_OPTION);
				if (option == JOptionPane.YES_OPTION)
				{
				    //修改登陆标记
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
						System.out.println("数据库连接失败！!");
						// e.printStackTrace();
					} catch (Exception e3) {
						// e.printStackTrace();
					}
					
					//结束
					System.exit(0);
				}
				else {
					return;

				}
			}
		});

	    //修改登陆标记
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
			System.out.println("数据库连接失败！!");
			// e.printStackTrace();
		} catch (Exception e3) {
			// e.printStackTrace();
		}
		
		//结束
		
		
		setResizable(false);// 不可调整大小

		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();// 获得屏幕尺寸
		int width = 800;// The application's width
		int height = 600;
		int x = (d.width - width) / 2;
		int y = (d.height - height) / 2;
		setBounds((d.width - width) / 2, (d.height - height) / 2, width, height);// 窗口的坐标和尺寸，这种方式居中

		setLayout(null);// 设置布局方式

//初始界面上部		
		JPanel uption = new HomePanel(0);
		uption.setLayout(null);
		uption.setBounds(0, 0, width, height / 4);// 上部大小
		add(uption);

		JLabel timelabel = new JLabel("");
		time = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				timelabel.setText(new SimpleDateFormat("yyyy年MM月dd日 EEEE hh:mm:ss").format(new Date()));
			}
		});
		time.start();
		timelabel.setText(new SimpleDateFormat("yyyy年MM月dd日 EEEE hh:mm:ss").format(new Date()));
		timelabel.setBounds(5, 120, 200, 20);
		timelabel.setFont(new Font("微软雅黑", Font.BOLD, 12));
		timelabel.setForeground(new Color(251, 178, 23));
		uption.add(timelabel);

		JButton Exit = new JButton("退出登录");
		Exit.setBounds(10, 10, 100, 30);// 大小
		Font font1 = new Font("宋体", Font.BOLD + Font.ITALIC, 14);
		Exit.setFont(font1);
		Exit.setForeground(Color.blue);
		Exit.setToolTipText("返回登录界面");
		Exit.setBorderPainted(false);// 不绘制边框
		Exit.setContentAreaFilled(false);// 取消填充物

		Exit.addMouseListener(new MouseAdapter() {
			@Override
			// 鼠标点击
			public void mouseClicked(MouseEvent e) {
				super.mouseEntered(e);
				JButton btn = (JButton) e.getComponent();
				btn.setBorderPainted(true);// 显示边框
				btn.setBorder(BorderFactory.createLoweredBevelBorder());
				int op = JOptionPane.showConfirmDialog(null, "是否要注销并返回登陆页面", "提示", JOptionPane.YES_NO_OPTION);
				if (op == JOptionPane.YES_OPTION) {
				    //修改登陆标记
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
						System.out.println("数据库连接失败！!");
						// e.printStackTrace();
					} catch (Exception e3) {
						// e.printStackTrace();
					}
					
					//结束
					dispose();
				} else if (op == JOptionPane.NO_OPTION) {

				}
				// 退回
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				JButton btn = (JButton) e.getComponent();
				btn.setForeground(new Color(0x33, 0x66, 0xcc));// 设置字体颜色
				btn.setBorderPainted(true);// 显示边框
				btn.setBorder(BorderFactory.createRaisedBevelBorder());
				btn.setRolloverEnabled(true);
			}

			@Override
			// 鼠标按住
			public void mousePressed(MouseEvent e) {
				JButton btn = (JButton) e.getComponent();
				btn.setBorderPainted(true);// 显示边框
				btn.setForeground(new Color(0x33, 0x66, 0xcc));// 设置字体颜色
				btn.setBorder(BorderFactory.createLoweredBevelBorder());
				btn.setRolloverEnabled(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				JButton btn = (JButton) e.getComponent();
				btn.setForeground(Color.blue);// 设置字体颜色
				btn.setBorderPainted(false);// 隐藏边框
			}
		});

		uption.add(Exit);

		JLabel welcome = new JLabel("欢迎!", JLabel.CENTER);
		Font ffont = new Font("宋体", 1, 40);
		welcome.setFont(ffont);
		welcome.setBounds(width / 2 - 75, height / 8 - 60, 150, 120);
		uption.add(welcome);

//初始界面下部	
		JPanel Test = new HomePanel(1);
		Test.setLayout(null);
		Test.setBounds(0, height / 4, width, height / 4 * 3);// 下部大小
		add(Test);

		JLabel studentnum = new JLabel("教工号:" + this.pfr.ProID, JLabel.LEFT);
		studentnum.setFont(new Font("宋体", 1, 15));
		studentnum.setBounds(20, 10, 120, 30);
		Test.add(studentnum);
		JLabel studentname = new JLabel("姓名:" + pfr.name, JLabel.LEFT);
		studentname.setFont(new Font("宋体", 1, 15));
		studentname.setBounds(20, 40, 120, 30);
		Test.add(studentname);
		String passw = "******";
		JLabel studentpassw = new JLabel("密码:" + passw, JLabel.LEFT);
		studentpassw.setFont(new Font("宋体", 1, 15));
		studentpassw.setBounds(20, 70, 120, 30);
		Test.add(studentpassw);

		JButton exchange = new JButton("修改密码");
		exchange.setBounds(140, 72, 100, 25);// 大小
		Font font2 = new Font("宋体", Font.BOLD + Font.ITALIC, 12);
		exchange.setFont(font2);
		exchange.setForeground(Color.blue);
		exchange.setToolTipText("修改当前密码");
		exchange.setBorderPainted(false);// 不绘制边框
		exchange.setContentAreaFilled(false);// 取消填充物
		exchange.addMouseListener(new MouseAdapter() {
			@Override
			// 鼠标点击
			public void mouseClicked(MouseEvent e) {
				super.mouseEntered(e);

				JButton btn = (JButton) e.getComponent();
				btn.setBorderPainted(true);// 显示边框
				btn.setBorder(BorderFactory.createLoweredBevelBorder());

				JDialog expass = new JDialog();
				expass.setModal(true);
				expass.setTitle("修改密码界面");
				expass.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				expass.setResizable(false);// 不可调整大小

				Dimension d = Toolkit.getDefaultToolkit().getScreenSize();// 获得屏幕尺寸
				int width = 400;// The application's width
				int height = 250;
				expass.setBounds((d.width - width) / 2, (d.height - height) / 2, width, height);// 窗口的坐标和尺寸，这种方式居中
				expass.setLayout(null);// 设置布局方式

				JPasswordField new1 = new JPasswordField(10);
				JPasswordField new2 = new JPasswordField(10);
				JTextField old = new JTextField(10);
				old.setBounds(100, 10, 210, 30);
				new1.setBounds(100, 50, 210, 30);
				new2.setBounds(100, 90, 210, 30);

				JLabel oldpass = new JLabel("旧密码", JLabel.CENTER);
				Font font1 = new Font("微软雅黑", Font.BOLD, 12);
				oldpass.setFont(font1);
				oldpass.setBounds(50, 10, 40, 30);

				JLabel newpass1 = new JLabel("新密码", JLabel.CENTER);
				newpass1.setFont(font1);
				newpass1.setBounds(50, 50, 40, 30);
				JLabel newpass2 = new JLabel("再次输入", JLabel.CENTER);
				newpass2.setFont(font1);
				newpass2.setBounds(40, 90, 50, 30);

				expass.add(oldpass);
				expass.add(old);
				expass.add(newpass1);
				expass.add(new1);
				expass.add(newpass2);
				expass.add(new2);

				JButton Confirm = new JButton("确定");
				Confirm.setBounds(100, 150, 60, 30);// 大小
				Font font2 = new Font("宋体", Font.BOLD, 13);
				Confirm.setFont(font2);
				Confirm.setForeground(Color.blue);
				Confirm.setBorderPainted(true);// 不绘制边框
				// Confirm.setContentAreaFilled(false);//取消填充物
				Confirm.setBorder(BorderFactory.createEtchedBorder());

				Confirm.addMouseListener(new MouseAdapter() {
					@Override
					// 鼠标点击
					public void mouseClicked(MouseEvent e) {
						super.mouseEntered(e);
						JButton btn = (JButton) e.getComponent();
						btn.setBorderPainted(true);// 显示边框
						btn.setBorder(BorderFactory.createLoweredBevelBorder());
						// 添加提示代码，修改后的密码和关闭该窗口
						String info = old.getText().trim();// 获取文本框的内容,并且去掉首尾的空格
						String info2 = new String(new1.getPassword());
						String info3 = new String(new2.getPassword());
						info2.trim();
						info3.trim();
						boolean isLetter = false;
						boolean isNumber = false;
						if (info.equals(pfr.passw)) {
							if (!info2.equals(info3)) {
								JOptionPane.showMessageDialog(null, "两次输入新密码不相同！", "提示", JOptionPane.WARNING_MESSAGE);
							} else {

								for (int i = 0; i < info2.length(); i++) {
									if (Character.isLetter(info2.charAt(i))) // 用char包装类中的判断字母的方法判断每一个字符
										isLetter = true;
									if (Character.isDigit(info2.charAt(i))) // 用char包装类中的判断字母的方法判断每一个字符
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
											System.out.println("数据库连接失败！!");
											// e.printStackTrace();
										} catch (Exception e3) {
											// e.printStackTrace();
										}

										isLetter = false;
										isNumber = false;
										JOptionPane.showMessageDialog(null, "修改成功！新密码：" + info2, "提示",
												JOptionPane.WARNING_MESSAGE);
										expass.dispose();
									} else {
										JOptionPane.showMessageDialog(null, "新密码请至少包含数字和字母！", "提示",
												JOptionPane.WARNING_MESSAGE);
										isLetter = false;
										isNumber = false;
									}
								} else {
									JOptionPane.showMessageDialog(null, "新密码请至少大于等于6位！", "提示",
											JOptionPane.WARNING_MESSAGE);
								}
							}

						} else {
							JOptionPane.showMessageDialog(null, "旧密码输入错误！", "提示", JOptionPane.WARNING_MESSAGE);
						}
						// 添加确认和保存代码

					}

					@Override
					// 鼠标按住
					public void mousePressed(MouseEvent e) {
						JButton btn = (JButton) e.getComponent();
						btn.setBorderPainted(true);// 显示边框
						btn.setForeground(new Color(0x33, 0x66, 0xcc));// 设置字体颜色
						btn.setBorder(BorderFactory.createLoweredBevelBorder());
						btn.setRolloverEnabled(true);
					}

					@Override
					// 鼠标移入
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						JButton btn = (JButton) e.getComponent();
						btn.setForeground(new Color(0x33, 0x66, 0xcc));// 设置字体颜色
						btn.setBorderPainted(true);// 显示边框
						Border etchedBorder = new EtchedBorder(EtchedBorder.LOWERED);// 设置边框凹显
						btn.setBorder(etchedBorder);
						btn.setRolloverEnabled(true);
					}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						JButton btn = (JButton) e.getComponent();
						btn.setForeground(Color.blue);// 设置字体颜色
						btn.setBorder(BorderFactory.createEtchedBorder());
						btn.setBorderPainted(true);
					}
				});
				JButton Cencel = new JButton("取消");
				Cencel.setBounds(220, 150, 60, 30);// 大小
				Cencel.setFont(font2);
				Cencel.setForeground(Color.blue);
				Cencel.setBorderPainted(true);
				Cencel.setBorder(BorderFactory.createEtchedBorder());
				Cencel.addMouseListener(new MouseAdapter() {
					@Override
					// 鼠标点击
					public void mouseClicked(MouseEvent e) {
						super.mouseEntered(e);
						JButton btn = (JButton) e.getComponent();
						btn.setBorderPainted(true);// 显示边框
						btn.setBorder(BorderFactory.createLoweredBevelBorder());

						expass.dispose();

					}

					@Override
					// 鼠标按住
					public void mousePressed(MouseEvent e) {
						JButton btn = (JButton) e.getComponent();
						btn.setBorderPainted(true);// 显示边框
						btn.setForeground(new Color(0x33, 0x66, 0xcc));// 设置字体颜色
						btn.setBorder(BorderFactory.createLoweredBevelBorder());
						btn.setRolloverEnabled(true);
					}

					@Override
					// 鼠标移入
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						JButton btn = (JButton) e.getComponent();
						btn.setForeground(new Color(0x33, 0x66, 0xcc));// 设置字体颜色
						btn.setBorderPainted(true);// 显示边框
						Border etchedBorder = new EtchedBorder(EtchedBorder.LOWERED);// 设置边框凹显
						btn.setBorder(etchedBorder);
						btn.setRolloverEnabled(true);
					}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						JButton btn = (JButton) e.getComponent();
						btn.setForeground(Color.blue);// 设置字体颜色

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
				btn.setForeground(new Color(0x33, 0x66, 0xcc));// 设置字体颜色
				btn.setBorderPainted(true);// 显示边框
				btn.setBorder(BorderFactory.createRaisedBevelBorder());
				btn.setRolloverEnabled(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				JButton btn = (JButton) e.getComponent();
				btn.setForeground(Color.blue);// 设置字体颜色
				btn.setBorderPainted(false);// 隐藏边框
			}
		});
		Test.add(exchange);

		JButton lessonc = new JButton("选择授课");
		lessonc.setBounds(420, 72, 300, 50);// 大小
		Font font3 = new Font("微软雅黑", Font.BOLD, 20);
		lessonc.setFont(font3);
		lessonc.setForeground(new Color(219, 69, 32));
		lessonc.setToolTipText("选择下学期的授课计划");
		lessonc.setBorderPainted(true);// 不绘制边框
		lessonc.setBorder(BorderFactory.createEtchedBorder());
		lessonc.setContentAreaFilled(false);// 取消填充物

		boolean isstart[] = {true};// 选课是否开始的标志
		int[]  prost= {0};

		lessonc.addMouseListener(new MouseAdapter() {
			@Override
			// 鼠标点击
			public void mouseClicked(MouseEvent e) {
				super.mouseEntered(e);
				JButton btn = (JButton) e.getComponent();
				btn.setBorderPainted(true);// 显示边框
				btn.setBorder(BorderFactory.createLoweredBevelBorder());// 凹陷边框
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
						System.out.println("数据库连接失败！!");
						// e.printStackTrace();
					} catch (Exception e3) {
						// e.printStackTrace();
					}
					if(prost[0]==0)
					{
						JOptionPane.showMessageDialog(null, "与选课数据库连接失败！", "提示", JOptionPane.WARNING_MESSAGE);
					}else {
					if (!isstart[0]) {
					JOptionPane.showMessageDialog(null, "未到选课时间！", "提示", JOptionPane.WARNING_MESSAGE);
					prost[0]=0;
				}
				else {
					prost[0]=0;
					JDialog less = new JDialog();
					less.setModal(true);// 设置为模态

					less.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
					less.setResizable(false);// 不可调整大小

					Dimension d = Toolkit.getDefaultToolkit().getScreenSize();// 获得屏幕尺寸
					int width = 750;// The application's width
					int height = 500;
					less.setBounds((d.width - width) / 2, (d.height - height) / 2, width, height);// 窗口的坐标和尺寸，这种方式居中
					less.setLayout(null);// 设置布局方式

					// 图片托底
					JPanel Less = new HomePanel(2);
					Less.setLayout(null);
					Less.setBounds(0, 0, width, height);
					less.add(Less);
					Vector<String> sqlstack = new Vector<String>();

					less.addWindowListener(new WindowAdapter() {
						@Override
						public void windowClosing(WindowEvent e) {
							int option = JOptionPane.showConfirmDialog(null, "是否保存并退出? ", "提示 ",
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
									System.out.println("数据库连接失败！!");
									// e.printStackTrace();
								} catch (Exception e3) {
									// e.printStackTrace();
								}

								less.dispose();
							} else {

							}

						}
					});

					JLabel lessonn = new JLabel("按课程名检索", JLabel.CENTER);
					lessonn.setFont(new Font("微软雅黑", Font.BOLD, 13));
					lessonn.setBounds(10, 10, 100, 30);
					Less.add(lessonn);

					JTextField lessonname = new JTextField(10);
					lessonname.setBounds(120, 10, 120, 30);
					Less.add(lessonname);

					JLabel lessonc = new JLabel("按课程代码检索", JLabel.CENTER);
					lessonc.setFont(new Font("微软雅黑", Font.BOLD, 13));
					lessonc.setBounds(250, 10, 100, 30);
					Less.add(lessonc);

					JTextField lessoncode = new JTextField(10);
					lessoncode.setBounds(360, 10, 120, 30);
					Less.add(lessoncode);

					JTabbedPane tabbedPane = new JTabbedPane();
					tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);// 设置选项卡标签的布局方式为滚动布局

					Vector<String> temp2 = new Vector<String>();// 资格数组
					Vector<String> temp1 = new Vector<String>();
					temp1.add("课程名");
					temp1.add("课程代号");
					temp1.add("上课时间");

					Vector<String> tem2 = new Vector<String>();// 已选课程数组
//数据库调出数据
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
						System.out.println("数据库连接失败！!");
						// e.printStackTrace();
					} catch (Exception e3) {
						// e.printStackTrace();
					}
//获取结束							

					ModelDemo tablemodel = new ModelDemo(temp2, temp1);
					ModelDemo tablemodel2 = new ModelDemo(tem2, temp1);
					JTable table = new JTable(tablemodel);
					JTable table2 = new JTable(tablemodel2);

					table.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent e) {
							boolean pre2 = true;// 是否日程冲突，默认不冲突
							Vector<String> tem = new Vector<String>();
							int p2=-1;//保存日程冲突的课程位置
							if (e.getClickCount() == 2)// 实现双击事件
							{
								int row = ((JTable) e.getSource()).rowAtPoint(e.getPoint()); // 获得行位置
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
									JOptionPane.showMessageDialog(null, "与"+tem2.get(p2)+"日程冲突！", "提示", JOptionPane.WARNING_MESSAGE);
									p2=-1;
									return;
								}
							}
						}
					});

					table2.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent e) {
							if (e.getClickCount() == 2)// 实现双击事件
							{
								Vector<String> tem = new Vector<String>();
								int row = ((JTable) e.getSource()).rowAtPoint(e.getPoint()); // 获得行位置
								int option = JOptionPane.showConfirmDialog(null, "是否确认移除该课程? ", "提示 ",
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
					JScrollPane scrollpane = new JScrollPane(table);// 添加表格到滚动轴
					JScrollPane scrollpane2 = new JScrollPane(table2);
					tabbedPane.addTab("可选课表", scrollpane);
					tabbedPane.addTab("已选课表", scrollpane2);
					tabbedPane.setBounds(30, 70, 620, 370);
					tabbedPane.setSelectedIndex(0); // 设置索引为0的选项卡被选中
					Less.add(tabbedPane);

					JButton Search = new JButton("查询");
					Search.setBounds(500, 10, 100, 30);// 大小
					Font font2 = new Font("宋体", Font.BOLD, 13);
					Search.setFont(font2);
					Search.setForeground(Color.blue);
					Search.setBorderPainted(true);// 不绘制边框
					// Search.setContentAreaFilled(false);//取消填充物
					Search.setBorder(BorderFactory.createEtchedBorder());

					Search.addMouseListener(new MouseAdapter() {
						@Override
						// 鼠标点击
						public void mouseClicked(MouseEvent e) {
							super.mouseEntered(e);
							JButton btn = (JButton) e.getComponent();
							btn.setBorderPainted(true);// 显示边框
							btn.setBorder(BorderFactory.createLoweredBevelBorder());
							String info = lessonname.getText().trim();// 获取文本框的内容,并且去掉首尾的空格
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
						// 鼠标按住
						public void mousePressed(MouseEvent e) {
							JButton btn = (JButton) e.getComponent();
							btn.setBorderPainted(true);// 显示边框
							btn.setForeground(new Color(0x33, 0x66, 0xcc));// 设置字体颜色
							btn.setBorder(BorderFactory.createLoweredBevelBorder());
							btn.setRolloverEnabled(true);
						}

						@Override
						// 鼠标移入
						public void mouseEntered(MouseEvent e) {
							// TODO Auto-generated method stub
							JButton btn = (JButton) e.getComponent();
							btn.setForeground(new Color(0x33, 0x66, 0xcc));// 设置字体颜色
							btn.setBorderPainted(true);// 显示边框
							Border etchedBorder = new EtchedBorder(EtchedBorder.LOWERED);// 设置边框凹显
							btn.setBorder(etchedBorder);
							btn.setRolloverEnabled(true);
						}

						@Override
						public void mouseExited(MouseEvent e) {
							// TODO Auto-generated method stub
							JButton btn = (JButton) e.getComponent();
							btn.setForeground(Color.blue);// 设置字体颜色
							btn.setBorder(BorderFactory.createEtchedBorder());
							btn.setBorderPainted(true);
						}
					});
					JButton Reset = new JButton("重置");
					Reset.setBounds(620, 10, 100, 30);// 大小
					Reset.setFont(font2);
					Reset.setForeground(Color.blue);
					Reset.setBorderPainted(true);// 不绘制边框
					// Reset.setContentAreaFilled(false);//取消填充物
					Reset.setBorder(BorderFactory.createEtchedBorder());

					Reset.addMouseListener(new MouseAdapter() {
						@Override
						// 鼠标点击
						public void mouseClicked(MouseEvent e) {
							super.mouseEntered(e);
							JButton btn = (JButton) e.getComponent();
							btn.setBorderPainted(true);// 显示边框
							btn.setBorder(BorderFactory.createLoweredBevelBorder());

							lessonname.setText(" ");
							lessoncode.setText(" ");

						}

						@Override
						// 鼠标按住
						public void mousePressed(MouseEvent e) {
							JButton btn = (JButton) e.getComponent();
							btn.setBorderPainted(true);// 显示边框
							btn.setForeground(new Color(0x33, 0x66, 0xcc));// 设置字体颜色
							btn.setBorder(BorderFactory.createLoweredBevelBorder());
							btn.setRolloverEnabled(true);
						}

						@Override
						// 鼠标移入
						public void mouseEntered(MouseEvent e) {
							// TODO Auto-generated method stub
							JButton btn = (JButton) e.getComponent();
							btn.setForeground(new Color(0x33, 0x66, 0xcc));// 设置字体颜色
							btn.setBorderPainted(true);// 显示边框
							Border etchedBorder = new EtchedBorder(EtchedBorder.LOWERED);// 设置边框凹显
							btn.setBorder(etchedBorder);
							btn.setRolloverEnabled(true);
						}

						@Override
						public void mouseExited(MouseEvent e) {
							// TODO Auto-generated method stub
							JButton btn = (JButton) e.getComponent();
							btn.setForeground(Color.blue);// 设置字体颜色
							btn.setBorder(BorderFactory.createEtchedBorder());
							btn.setBorderPainted(true);
						}
					});

					Less.add(Reset);
					Less.add(Search);
					less.setVisible(true);
				} // 判断选课是否开始的回括号
				}
			}

			@Override
			// 鼠标按住
			public void mousePressed(MouseEvent e) {
				JButton btn = (JButton) e.getComponent();

				btn.setBorderPainted(true);// 显示边框
				btn.setForeground(new Color(255, 66, 93));// 设置字体颜色
				btn.setBorder(BorderFactory.createLoweredBevelBorder());
				btn.setRolloverEnabled(true);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				JButton btn = (JButton) e.getComponent();
				btn.setForeground(new Color(255, 66, 93));// 设置字体颜色
				btn.setBorderPainted(true);// 显示边框
				btn.setBorder(BorderFactory.createRaisedBevelBorder());
				btn.setRolloverEnabled(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				JButton btn = (JButton) e.getComponent();
				btn.setForeground(new Color(219, 69, 32));// 设置字体颜色
				btn.setBorder(BorderFactory.createEtchedBorder());
				btn.setBorderPainted(true);
			}
		});

		Test.add(lessonc);

		JButton givegrade = new JButton("给予成绩");
		givegrade.setBounds(420, 222, 300, 50);// 大小
		givegrade.setFont(font3);
		givegrade.setForeground(new Color(219, 69, 32));
		givegrade.setToolTipText("给予已授课程的学生成绩");
		givegrade.setBorderPainted(true);// 不绘制边框
		givegrade.setBorder(BorderFactory.createEtchedBorder());
		givegrade.setContentAreaFilled(false);// 取消填充物

		givegrade.addMouseListener(new MouseAdapter() {
			@Override
			// 鼠标点击
			public void mouseClicked(MouseEvent e) {
				super.mouseEntered(e);
				JButton btn = (JButton) e.getComponent();
				btn.setBorderPainted(true);// 显示边框
				btn.setBorder(BorderFactory.createLoweredBevelBorder());// 凹陷边框

				JDialog giveg = new JDialog();
				giveg.setModal(true);// 设置为模态

				giveg.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				giveg.setResizable(false);// 不可调整大小

				giveg.setTitle("选择要给予成绩的课程");

				Dimension d = Toolkit.getDefaultToolkit().getScreenSize();// 获得屏幕尺寸
				int width = 600;// The application's width
				int height = 400;
				giveg.setBounds((d.width - width) / 2, (d.height - height) / 2, width, height);// 窗口的坐标和尺寸，这种方式居中
				giveg.setLayout(null);// 设置布局方式

				// 图片托底
				JPanel Giveg = new HomePanel(2);
				Giveg.setLayout(null);
				Giveg.setBounds(0, 0, width, height);
				giveg.add(Giveg);

				JLabel welcome = new JLabel("请选择课程", JLabel.CENTER);
				Font ffont = new Font("微软雅黑", 1, 15);
				welcome.setFont(ffont);
				welcome.setBounds(width / 2 - 75, 10, 150, 30);

				Giveg.add(welcome);

				Vector<String> temp1 = new Vector<String>();
				temp1.add("课程名称");
				temp1.add("课程代码");
				temp1.add("所处年级");
				Vector<String> temp2 = new Vector<String>();
				// 数据库读取

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
					System.out.println("数据库连接失败！!");
					// e.printStackTrace();
				} catch (Exception e3) {
					// e.printStackTrace();
				}
				// 读取结束
				JTabbedPane tabbedPane = new JTabbedPane();
				tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);// 设置选项卡标签的布局方式为滚动布局
				ModelDemo tablemodel = new ModelDemo(temp2, temp1);
				JTable table = new JTable(tablemodel);

				table.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						if (e.getClickCount() == 2)// 实现双击事件
						{

							 int row =((JTable)e.getSource()).rowAtPoint(e.getPoint()); //获得行位置
							 String CID=temp2.get(row*3+1);//获取课程id
							JDialog classg = new JDialog();
							classg.setModal(true);// 设置为模态

							classg.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
							classg.setResizable(false);// 不可调整大小

							classg.setTitle("给予每位学生成绩");

							Dimension d = Toolkit.getDefaultToolkit().getScreenSize();// 获得屏幕尺寸
							int width = 700;// The application's width
							int height = 500;
							classg.setBounds((d.width - width) / 2, (d.height - height) / 2, width, height);// 窗口的坐标和尺寸，这种方式居中
							classg.setLayout(null);// 设置布局方式

							// 图片托底
							JPanel Classg = new HomePanel(2);
							Classg.setLayout(null);
							Classg.setBounds(0, 0, width, height);
							classg.add(Classg);
							
							Vector<String> temp1 = new Vector<String>();
							temp1.add("姓名");
							temp1.add("学号");
							temp1.add("课程名称");
							temp1.add("成绩");
							Vector<String> temp2 = new Vector<String>();
							// 数据库读取

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
								System.out.println("数据库连接失败！!");
								// e.printStackTrace();
							} catch (Exception e3) {
								// e.printStackTrace();
							}
							// 读取结束
							JTabbedPane tabbedPane = new JTabbedPane();
							tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);// 设置选项卡标签的布局方式为滚动布局
							ModelDemo tablemodel = new ModelDemo(temp2, temp1);
							JTable table = new JTable(tablemodel) {//返回输入值
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
							
							JScrollPane scrollpane = new JScrollPane(table);// 添加表格到滚动轴
							tabbedPane.addTab("已授课程", scrollpane);
							tabbedPane.setBounds(30, 20, 630, 320);
							tabbedPane.setSelectedIndex(0); // 设置索引为0的选项卡被选中
							Classg.add(tabbedPane);
							
							JButton Sa = new JButton("保存");
							Sa.setBounds(290, 370, 120, 40);// 大小
							Sa.setFont(font2);
							Sa.setForeground(Color.blue);
							Sa.setBorderPainted(true);
							Sa.setBorder(BorderFactory.createEtchedBorder());
							Sa.addMouseListener(new MouseAdapter() {
								@Override
								// 鼠标点击
								public void mouseClicked(MouseEvent e) {
									super.mouseEntered(e);
									JButton btn = (JButton) e.getComponent();
									btn.setBorderPainted(true);// 显示边框
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
											JOptionPane.showMessageDialog(null, "成绩格式不对（应为ABCDFI或空）！", "提示", JOptionPane.WARNING_MESSAGE);
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
										System.out.println("数据库连接失败！!");
										// e.printStackTrace();
									} catch (Exception e3) {
										// e.printStackTrace();
									}
									// 读取结束
									
									
									

								}

								@Override
								// 鼠标按住
								public void mousePressed(MouseEvent e) {
									JButton btn = (JButton) e.getComponent();
									btn.setBorderPainted(true);// 显示边框
									btn.setForeground(new Color(0x33, 0x66, 0xcc));// 设置字体颜色
									btn.setBorder(BorderFactory.createLoweredBevelBorder());
									btn.setRolloverEnabled(true);
								}

								@Override
								// 鼠标移入
								public void mouseEntered(MouseEvent e) {
									// TODO Auto-generated method stub
									JButton btn = (JButton) e.getComponent();
									btn.setForeground(new Color(0x33, 0x66, 0xcc));// 设置字体颜色
									btn.setBorderPainted(true);// 显示边框
									Border etchedBorder = new EtchedBorder(EtchedBorder.LOWERED);// 设置边框凹显
									btn.setBorder(etchedBorder);
									btn.setRolloverEnabled(true);
								}

								@Override
								public void mouseExited(MouseEvent e) {
									// TODO Auto-generated method stub
									JButton btn = (JButton) e.getComponent();
									btn.setForeground(Color.blue);// 设置字体颜色

									btn.setBorder(BorderFactory.createEtchedBorder());
									btn.setBorderPainted(true);
								}
							});
							Classg.add(Sa);
							
							
							classg.setVisible(true);

						}
					}
				});

				JScrollPane scrollpane = new JScrollPane(table);// 添加表格到滚动轴
				tabbedPane.addTab("已授课程", scrollpane);
				tabbedPane.setBounds(30, 40, 520, 300);
				tabbedPane.setSelectedIndex(0); // 设置索引为0的选项卡被选中
				Giveg.add(tabbedPane);

				giveg.setVisible(true);

			}

			@Override
			// 鼠标按住
			public void mousePressed(MouseEvent e) {
				JButton btn = (JButton) e.getComponent();

				btn.setBorderPainted(true);// 显示边框
				btn.setForeground(new Color(255, 66, 93));// 设置字体颜色
				btn.setBorder(BorderFactory.createLoweredBevelBorder());
				btn.setRolloverEnabled(true);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				JButton btn = (JButton) e.getComponent();
				btn.setForeground(new Color(255, 66, 93));// 设置字体颜色
				btn.setBorderPainted(true);// 显示边框
				btn.setBorder(BorderFactory.createRaisedBevelBorder());
				btn.setRolloverEnabled(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				JButton btn = (JButton) e.getComponent();
				btn.setForeground(new Color(219, 69, 32));// 设置字体颜色
				btn.setBorder(BorderFactory.createEtchedBorder());
				btn.setBorderPainted(true);
			}
		});
		Test.add(givegrade);

		// 校内通知栏
		JList list = new JList();
		DefaultListModel<String> dlm = new DefaultListModel();

		dlm.addElement("1.jkl");
		dlm.addElement("2.dd");
		dlm.addElement("3.qq");

		list.setModel(dlm);
		list.setBorder(BorderFactory.createTitledBorder("校内通知栏"));
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

	}// run函数结尾

//工具类	
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
//	    	System.out.println("欢迎来到教师端!");
//	    	System.out.println("教工号："+ProID);
//	    	System.out.println("姓名："+name);
		}

		void MainMenus() {
			while (flag) {
				System.out.println("请选择要进行的服务");
				System.out.println("1：选择授课");
				System.out.println("2：登记成绩");
				System.out.println("3：修改密码");
				System.out.println("4：退出登录");
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
					System.out.println("输入错误！请重新输入！");
				}
			}
		}

		void SelectCourses() {
			System.out.println("你已经进入选择授课系统！");
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
				System.out.println("您的选课资格如下：");
				System.out.println("-----------------");
				while (rs.next()) {
					CourseName = rs.getString("CourseName");
					CourseTime = rs.getString("CourseTime");
					System.out.println(CourseName + "\t\t" + CourseTime);
				}

				sql = "select * from choose where ProID = " + this.ProID;
				rs = statement.executeQuery(sql);
				System.out.println("-----------------");
				System.out.println("您的先前选择的课");
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
				System.out.println("数据库连接失败！!");
				// e.printStackTrace();
			} catch (Exception e) {
				// e.printStackTrace();
			}
		}

		void SubmitGrade() {
			System.out.println("你已经进入提交成绩系统！");
		}

		void ChangePassword() {
			System.out.println("你已经进入修改密码系统！");

		}

		void QuitSystem() {
			System.out.println("确定要退出系统？y/n");

		}
//		public static void main(String[] args) {

//		}
	}

	class ModelDemo extends AbstractTableModel

	{
		/** * @author 小悠 */

		public Vector<String> TableData;// 用来存放表格数据的线性表

		public Vector<String> TableTitle;// 表格的 列标题

		public int columnl;

		// 注意构造函数是第一个执行的，用于初始化 TableData，TableTitle
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

			// 这里是告知表格应该有多少行，我们返回TableData上挂的String数组个数

			return TableData.size() / columnl;

		}

		@Override
		public String getColumnName(int columnIndex) {
			return TableTitle.get(columnIndex);

		}

		@Override

		public int getColumnCount()

		{

			// 告知列数，用标题数组的大小,这样表格就是TableData.size()行，TableTitle.size()列了

			return columnl;

		}

		@Override

		public Object getValueAt(int rowIndex, int columnIndex)

		{

			// 获取了表格的大小，当然还要获取数据，根据坐标直接返回对应的数据

			// 小心 都是从 0开始的，小心下标越界 的问题

			return TableData.get((rowIndex) * columnl + columnIndex);
			// 提取出对 应的数据

		}

		@Override

		public boolean isCellEditable(int rowIndex, int columnIndex)

		{

			// 这个函数式设置每个单元格的编辑属性的

			// 这个函数AbstractTableModel已经实现，默认的是 不允许编辑状态

			// 这里我们设置为允许/不允许编辑状态
			if(columnIndex==3&&TableTitle.get(3).equals("成绩"))
				return true;
			else
			    return false;// super.isCellEditable(rowIndex, columnIndex);

		}

		@Override

		public void setValueAt(Object aValue, int rowIndex, int columnIndex)

		{

			// 当单元格的数据发生改变的时候掉用该函数重设单元格的数据

			// 我们想一下，数据是放在TableData 中的，说白了修改数据就是修改的

			// TableData中的数据，所以我们仅仅在此处将TableData的对应数据修改即可

			TableData.set(((rowIndex) * columnl + columnIndex), (String) aValue);
			super.setValueAt(aValue, rowIndex, columnIndex);

			//

			// 其实这里super的方法是调用了fireTableCellUpdated()只对应更新了

			// 对应单元格的数据

			// fireTableCellUpdated(rowIndex, columnIndex);

		}


	}

	public class HomePanel extends JPanel {
		ImageIcon icon;
		Image img;

		public HomePanel(int i) {
			// /img/xxx.jpg 是存放在你正在编写的项目的bin文件夹下的img文件夹下的一个图片
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
			// 下面这行是为了背景图片可以跟随窗口自行调整大小，可以自己设置成固定大小
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		}

	}
}
