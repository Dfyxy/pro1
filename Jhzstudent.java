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

		setTitle("学生端界面");
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
						String sql = "update student set StuState = 0 " 
								+ " where StuID = "+Stu.StuID;
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

		setResizable(false);// 不可调整大小

		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();// 获得屏幕尺寸
		int width = 800;// The application's width
		int height = 600;
		int x = (d.width - width) / 2;
		int y = (d.height - height) / 2;
		setBounds((d.width - width) / 2, (d.height - height) / 2, width, height);// 窗口的坐标和尺寸，这种方式居中

		setLayout(null);// 设置布局方式
		
		
	    //修改登陆标记
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
			System.out.println("数据库连接失败！!");
			// e.printStackTrace();
		} catch (Exception e3) {
			// e.printStackTrace();
		}
		
		//结束

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

//		String stnum = "21172728";
		JLabel studentnum = new JLabel("学号:" + Stu.StuID, JLabel.LEFT);
		studentnum.setFont(new Font("宋体", 1, 15));
		studentnum.setBounds(20, 10, 120, 30);
		Test.add(studentnum);
//		String stname = "纪皓中";
		JLabel studentname = new JLabel("姓名:" + Stu.StuName, JLabel.LEFT);
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
				int x = (d.width - width) / 2;
				int y = (d.height - height) / 2;
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
						if (info.equals(Stu.StuPassw)) {
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
											String sql = "update student set StuPassword = " + "\"" + info2 + "\""
													+ " where StuID = " + Stu.StuID;
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
//						expass.dispose();

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

		JButton schedule = new JButton("个人课表");
		schedule.setBounds(420, 72, 300, 50);// 大小
		Font font3 = new Font("微软雅黑", Font.BOLD, 20);
		schedule.setFont(font3);
		schedule.setForeground(new Color(219, 69, 32));
		schedule.setToolTipText("查看本学期或以往课表");
		schedule.setBorderPainted(true);// 不绘制边框
		schedule.setBorder(BorderFactory.createEtchedBorder());
		schedule.setContentAreaFilled(false);// 取消填充物
		schedule.addMouseListener(new MouseAdapter() {
			@Override
			// 鼠标点击
			public void mouseClicked(MouseEvent e) {
				super.mouseEntered(e);
				JButton btn = (JButton) e.getComponent();
				btn.setBorderPainted(true);// 显示边框
				btn.setBorder(BorderFactory.createLoweredBevelBorder());

				JDialog sche = new JDialog();
				sche.setModal(true);
				sche.setTitle("查询课表界面");
				sche.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				sche.setResizable(false);// 不可调整大小

				Dimension d = Toolkit.getDefaultToolkit().getScreenSize();// 获得屏幕尺寸
				int width = 600;// The application's width
				int height = 450;
				int x = (d.width - width) / 2;
				int y = (d.height - height) / 2;
				sche.setBounds((d.width - width) / 2, (d.height - height) / 2, width, height);// 窗口的坐标和尺寸，这种方式居中
				sche.setLayout(null);// 设置布局方式

				// 图片托底
				JPanel Sche = new HomePanel(2);
				Sche.setLayout(null);
				Sche.setBounds(0, 0, width, height);
				sche.add(Sche);

				JLabel choic = new JLabel("选择学期", JLabel.CENTER);
				choic.setFont(new Font("宋体", 1, 15));
				choic.setBounds(10, 10, 120, 30);
				Sche.add(choic);

				String[] listData = new String[] { "全部","本学期","大一上", "大一下", "大二上", "大二下", "大三上", "大三下", "大四上",
						"大四下" };
				String[] listD;
				Integer gra=0;
				 //数据库调用
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
					System.out.println("数据库连接失败！!");
					// e.printStackTrace();
				} catch (Exception e3) {
					// e.printStackTrace();
				}
				
				//结束
				gra=gra/10000%100-20;
				listD=new String[(listData.length-gra*2)];
				for(int i=0;i<(listData.length-gra*2);i++)
				{
					listD[i]=listData[i];
				}
				JComboBox<String> comboBox = new JComboBox<String>(listD);
				comboBox.setSelectedIndex(0);
				comboBox.setBounds(150, 12, 100, 25);
				comboBox.setFont(new Font("微软雅黑", Font.BOLD, 12));
				Sche.add(comboBox);

				JButton Search = new JButton("查找");
				Search.setBounds(400, 10, 60, 30);// 大小
				Font font2 = new Font("宋体", Font.BOLD, 13);
				Search.setFont(font2);
				Search.setForeground(Color.blue);
				Search.setBorderPainted(true);// 不绘制边框
				// Search.setContentAreaFilled(false);//取消填充物
				Search.setBorder(BorderFactory.createEtchedBorder());

				// 设置tab和table
				//String[] temp1 = { "课程名", "课程代码", "所属系", "上课时间", "先决条件", "授课教授", "所处年级", "课程费用" };
				Vector<String> temp1= new Vector<String>();
				temp1.add("课程名");
				temp1.add("课程代码");
				temp1.add("所属系");
				temp1.add("上课时间");
				temp1.add("先决条件");
				temp1.add("授课教授");
				temp1.add("所处年级");
				temp1.add("课程费用");
//				String[] temp2 = { "高等数学", "gs101", "公共", "周一上午", "无", "cxk", "大一上", "300", "程序设计", "cs120", "计算机",
//						"周二下午", "C语言基础", "xz", "大一下", "500" };
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
					System.out.println("数据库连接失败！!");
					// e.printStackTrace();
				} catch (Exception e3) {
					// e.printStackTrace();
				}
				// 如果temp2为空也要指定一个空格作为元素
				JTabbedPane tabbedPane = new JTabbedPane();
				tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);// 设置选项卡标签的布局方式为滚动布局
				ModelDemo tablemodel = new ModelDemo(temp2, temp1);
				JTable table = new JTable(tablemodel);
				// table.getColumnModel().getColumn(0).setPreferredWidth(200);//设置某列的宽度
				// table.setRowHeight(1, 100);//设置某行的行高
				// table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);//关闭自动调整列的宽度，如果不需要则必须先设置每列的宽度
				JScrollPane scrollpane = new JScrollPane(table);// 添加表格到滚动轴
				tabbedPane.addTab("课程表格", scrollpane);
				tabbedPane.setBounds(30, 50, 520, 350);
				tabbedPane.setSelectedIndex(0); // 设置索引为0的选项卡被选中
				Sche.add(tabbedPane);

				Search.addMouseListener(new MouseAdapter() {
					@Override
					// 鼠标点击
					public void mouseClicked(MouseEvent e) {
						super.mouseEntered(e);
						JButton btn = (JButton) e.getComponent();
						btn.setBorderPainted(true);// 显示边框
						btn.setBorder(BorderFactory.createLoweredBevelBorder());
						String temp = (String) comboBox.getSelectedItem();
						Vector<String> t = new Vector<String>();
						if (temp != null) {
							if (temp == "大一上") {
								for (int i = 0; i < (temp2.size() / 8); i++) {
									if (temp2.get(i*8+6).equals("大一上")){
										for (int y = 0; y < 8; y++) {

											t.add(temp2.get(i*8+y));
										}
									}
								}
								tablemodel.setTableData(t);
								tablemodel.fireTableDataChanged();
								t.removeAllElements();
							}else if(temp=="本学期")
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
							else if (temp == "全部") {
								for (int i = 0; i < temp2.size(); i++) {
									t.add(temp2.get(i));
								}
								tablemodel.setTableData(t);
								tablemodel.fireTableDataChanged();
								t.removeAllElements();
							} else if (temp == "大一下") {
								for (int i = 0; i < (temp2.size() / 8); i++) {
									if (temp2.get(i*8+6).equals("大一下") ) {
										for (int y = 0; y < 8; y++) {

											t.add(temp2.get(i*8+y));
										}
									}
								}
								tablemodel.setTableData(t);
								tablemodel.fireTableDataChanged();
								t.removeAllElements();
							} else if (temp == "大二上") {
								for (int i = 0; i < (temp2.size() / 8); i++) {
									if (temp2.get(i*8+6).equals("大二上") ) {
										for (int y = 0; y < 8; y++) {

											t.add(temp2.get(i*8+y));
										}
									}
								}
								tablemodel.setTableData(t);
								tablemodel.fireTableDataChanged();
								t.removeAllElements();
							} else if (temp == "大二下") {
								for (int i = 0; i < (temp2.size() / 8); i++) {
									if (temp2.get(i*8+6).equals( "大二下")) {
										for (int y = 0; y < 8; y++) {

											t.add(temp2.get(i*8+y));
										}
									}
								}
								tablemodel.setTableData(t);
								tablemodel.fireTableDataChanged();
								t.removeAllElements();
							} else if (temp == "大三上") {
								for (int i = 0; i < (temp2.size() / 8); i++) {
									if (temp2.get(i*8+6).equals("大三上") ){
										for (int y = 0; y < 8; y++) {

											t.add(temp2.get(i*8+y));
										}
									}
								}
								tablemodel.setTableData(t);
								tablemodel.fireTableDataChanged();
								t.removeAllElements();
							} else if (temp == "大三下") {
								for (int i = 0; i < (temp2.size() / 8); i++) {
									if (temp2.get(i*8+6).equals("大三下")) {
										for (int y = 0; y < 8; y++) {

											t.add(temp2.get(i*8+y));
										}
									}
								}
								tablemodel.setTableData(t);
								tablemodel.fireTableDataChanged();
								t.removeAllElements();
							} else if (temp == "大四上") {
								for (int i = 0; i < (temp2.size() / 8); i++) {
									if (temp2.get(i*8+6).equals( "大四上") ){
										for (int y = 0; y < 8; y++) {

											t.add(temp2.get(i*8+y));
										}
									}
								}
								tablemodel.setTableData(t);
								tablemodel.fireTableDataChanged();
								t.removeAllElements();
							} else if (temp == "大四下") {
								for (int i = 0; i < (temp2.size() / 8); i++) {
									if (temp2.get(i*8+6).equals( "大四下")) {
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
				Sche.add(Search);

				sche.setVisible(true);

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
		Test.add(schedule);

		JButton billinfo = new JButton("账单详情");
		billinfo.setBounds(420, 152, 300, 50);// 大小间隔30
		billinfo.setFont(font3);
		billinfo.setForeground(new Color(219, 69, 32));
		billinfo.setToolTipText("查看本学期账单或者历史账单");
		billinfo.setBorderPainted(true);// 绘制边框
		billinfo.setBorder(BorderFactory.createEtchedBorder());// 雕刻边框
		billinfo.setContentAreaFilled(false);// 取消填充物
		billinfo.addMouseListener(new MouseAdapter() {
			@Override
			// 鼠标点击
			public void mouseClicked(MouseEvent e) {
				super.mouseEntered(e);
				JButton btn = (JButton) e.getComponent();
				btn.setBorderPainted(true);// 显示边框
				btn.setBorder(BorderFactory.createLoweredBevelBorder());// 凹陷边框

				JDialog bill = new JDialog();
				bill.setModal(true);
				bill.setTitle("账单详情界面");
				bill.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				bill.setResizable(false);// 不可调整大小

				Dimension d = Toolkit.getDefaultToolkit().getScreenSize();// 获得屏幕尺寸
				int width = 600;// The application's width
				int height = 450;
				int x = (d.width - width) / 2;
				int y = (d.height - height) / 2;
				bill.setBounds((d.width - width) / 2, (d.height - height) / 2, width, height);// 窗口的坐标和尺寸，这种方式居中
				bill.setLayout(null);// 设置布局方式

				// 图片托底
				JPanel Bill = new HomePanel(2);
				Bill.setLayout(null);
				Bill.setBounds(0, 0, width, height);
				bill.add(Bill);

				JLabel choic = new JLabel("选择学期", JLabel.CENTER);
				choic.setFont(new Font("宋体", 1, 15));
				choic.setBounds(10, 10, 120, 30);
				Bill.add(choic);

				String[] listData = new String[] { "全部", "本学期","大一上", "大一下", "大二上", "大二下", "大三上", "大三下", "大四上",
						"大四下" };
				String[] listD;
				Integer gra=0;
				 //数据库调用
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
					System.out.println("数据库连接失败！!");
					// e.printStackTrace();
				} catch (Exception e3) {
					// e.printStackTrace();
				}
				
				//结束
				gra=gra/10000%100-20;
				listD=new String[(listData.length-gra*2)];
				for(int i=0;i<(listData.length-gra*2);i++)
				{
					listD[i]=listData[i];
				}
				JComboBox<String> comboBox = new JComboBox<String>(listD);
				comboBox.setSelectedIndex(0);
				comboBox.setBounds(150, 12, 100, 25);
				comboBox.setFont(new Font("微软雅黑", Font.BOLD, 12));
				Bill.add(comboBox);

				JButton Search = new JButton("查询");
				Search.setBounds(400, 10, 60, 30);// 大小
				Font font2 = new Font("宋体", Font.BOLD, 13);
				Search.setFont(font2);
				Search.setForeground(Color.blue);
				Search.setBorderPainted(true);// 不绘制边框
				// Search.setContentAreaFilled(false);//取消填充物
				Search.setBorder(BorderFactory.createEtchedBorder());

				// 设置tab和table
			//	String[] temp1 = { "课程名", "课程代码", "所处年级", "课程费用" };
				Vector<String> temp1= new Vector<String>();
				temp1.add("课程名");
				temp1.add("课程代码");
				temp1.add("所处年级");
				temp1.add("课程费用");
				Vector<String> temp2= new Vector<String>();
				//String[] temp2;
			//	String[] temp3 = { "高等数学", "gs101", "大一上", "300", "程序设计", "cs120", "大一下", "500" };
				// String[] temp3= {" "};
				 //数据库调用
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
					System.out.println("数据库连接失败！!");
					// e.printStackTrace();
				} catch (Exception e3) {
					// e.printStackTrace();
				}
				
				//结束
				// 如果temp2为空也要指定一个空格作为元素
				Integer te = 0;
				if (temp2.size()!=0) {
					for (int i = 3; i <= temp2.size() - 1; i = i + 4) {
						te += Integer.parseInt(temp2.get(i));
					}
					temp2.add("总计");
					temp2.add(" ");
					temp2.add(" ");
					temp2.add(te.toString());
				}
				te = 0;

				JTabbedPane tabbedPane = new JTabbedPane();
				tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);// 设置选项卡标签的布局方式为滚动布局
				ModelDemo tablemodel = new ModelDemo(temp2, temp1);
				JTable table = new JTable(tablemodel);
				JTable table2 = new JTable();
				// table.getColumnModel().getColumn(0).setPreferredWidth(200);//设置某列的宽度
				// table.setRowHeight(1, 100);//设置某行的行高
				// table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);//关闭自动调整列的宽度，如果不需要则必须先设置每列的宽度
				JScrollPane scrollpane = new JScrollPane(table);// 添加表格到滚动轴
				tabbedPane.addTab("学期账单", scrollpane);
				tabbedPane.setBounds(30, 50, 520, 350);
				tabbedPane.setSelectedIndex(0); // 设置索引为0的选项卡被选中
				Bill.add(tabbedPane);

				Search.addMouseListener(new MouseAdapter() {
					@Override
					// 鼠标点击
					public void mouseClicked(MouseEvent e) {
						super.mouseEntered(e);
						JButton btn = (JButton) e.getComponent();
						btn.setBorderPainted(true);// 显示边框
						btn.setBorder(BorderFactory.createLoweredBevelBorder());
						String temp = (String) comboBox.getSelectedItem();
						Vector<String> t = new Vector<String>();
						Integer te = 0;
						if (temp != null) {
							if (temp == "大一上") {
								for (int i = 0; i < (temp2.size() / 4); i++) {
									if (temp2.get(i*4+2).equals("大一上") ) {
										for (int y = 0; y < 4; y++) {
											t.add(temp2.get(i*4+y));
										}
									}
								}
								if (!t.isEmpty()) {
									for (int i = 3; i <= t.size() - 1; i = i + 4) {
										te += Integer.parseInt(t.get(i));
									}
									t.add("总计");
									t.add(" ");
									t.add(" ");
									t.add(te.toString());
								}
								te = 0;
								tablemodel.setTableData(t);
								tablemodel.fireTableDataChanged();
								t.removeAllElements();
							} else if (temp == "全部") {
								tablemodel.setTableData(temp2);
								tablemodel.fireTableDataChanged();
								t.removeAllElements();
							} else if (temp == "大一下") {
								for (int i = 0; i < (temp2.size() / 4); i++) {
									if (temp2.get(i*4+2).equals("大一下")) {
										for (int y = 0; y < 4; y++) {
											t.add(temp2.get(i*4+y));
										}
									}
								}
								if (!t.isEmpty()) {
									for (int i = 3; i <= t.size() - 1; i = i + 4) {
										te += Integer.parseInt(t.get(i));
									}
									t.add("总计");
									t.add(" ");
									t.add(" ");
									t.add(te.toString());
								}
								te = 0;
								tablemodel.setTableData(t);
								tablemodel.fireTableDataChanged();
								t.removeAllElements();
							}else if(temp=="本学期") { 
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
									t.add("总计");
									t.add(" ");
									t.add(" ");
									t.add(te.toString());
								}
								te = 0;
								tablemodel.setTableData(t);
								tablemodel.fireTableDataChanged();
								t.removeAllElements();
							}
							else if (temp == "大二上") {
								for (int i = 0; i < (temp2.size() / 4); i++) {
									if (temp2.get(i*4+2).equals("大二上")) {
										for (int y = 0; y < 4; y++) {
											t.add(temp2.get(i*4+y));
										}
									}
								}
								if (!t.isEmpty()) {
									for (int i = 3; i <= t.size() - 1; i = i + 4) {
										te += Integer.parseInt(t.get(i));
									}
									t.add("总计");
									t.add(" ");
									t.add(" ");
									t.add(te.toString());
								}
								te = 0;
								tablemodel.setTableData(t);
								tablemodel.fireTableDataChanged();
								t.removeAllElements();
							} else if (temp == "大二下") {
								for (int i = 0; i < (temp2.size() / 4); i++) {
									if (temp2.get(i*4+2).equals("大二下") ) {
										for (int y = 0; y < 4; y++) {
											t.add(temp2.get(i*4+y));
										}
									}
								}
								if (!t.isEmpty()) {
									for (int i = 3; i <= t.size() - 1; i = i + 4) {
										te += Integer.parseInt(t.get(i));
									}
									t.add("总计");
									t.add(" ");
									t.add(" ");
									t.add(te.toString());
								}
								te = 0;
								tablemodel.setTableData(t);
								tablemodel.fireTableDataChanged();
								t.removeAllElements();
							} else if (temp == "大三上") {
								for (int i = 0; i < (temp2.size() / 4); i++) {
									if (temp2.get(i*4+2).equals( "大三上")) {
										for (int y = 0; y < 4; y++) {
											t.add(temp2.get(i*4+y));
										}
									}
								}
								if (!t.isEmpty()) {
									for (int i = 3; i <= t.size() - 1; i = i + 4) {
										te += Integer.parseInt(t.get(i));
									}
									t.add("总计");
									t.add(" ");
									t.add(" ");
									t.add(te.toString());
								}
								te = 0;
								tablemodel.setTableData(t);
								tablemodel.fireTableDataChanged();
								t.removeAllElements();
							} else if (temp == "大三下") {
								for (int i = 0; i < (temp2.size() / 4); i++) {
									if (temp2.get(i*4+2).equals("大三下")){
										for (int y = 0; y < 4; y++) {
											t.add(temp2.get(i*4+y));
										}
									}
								}
								if (!t.isEmpty()) {
									for (int i = 3; i <= t.size() - 1; i = i + 4) {
										te += Integer.parseInt(t.get(i));
									}
									t.add("总计");
									t.add(" ");
									t.add(" ");
									t.add(te.toString());
								}
								te = 0;
								tablemodel.setTableData(t);
								tablemodel.fireTableDataChanged();
								t.removeAllElements();
							} else if (temp == "大四上") {
								for (int i = 0; i < (temp2.size() / 4); i++) {
									if (temp2.get(i*4+2).equals( "大四上") ){
										for (int y = 0; y < 4; y++) {
											t.add(temp2.get(i*4+y));
										}
									}
								}
								if (!t.isEmpty()) {
									for (int i = 3; i <= t.size() - 1; i = i + 4) {
										te += Integer.parseInt(t.get(i));
									}
									t.add("总计");
									t.add(" ");
									t.add(" ");
									t.add(te.toString());
								}
								te = 0;
								tablemodel.setTableData(t);
								tablemodel.fireTableDataChanged();
								t.removeAllElements();
							} else if (temp == "大四下") {
								for (int i = 0; i < (temp2.size() / 4); i++) {
									if (temp2.get(i*4+2).equals("大四下")) {
										for (int y = 0; y < 4; y++) {
											t.add(temp2.get(i*4+y));
										}
									}
								}
								if (!t.isEmpty()) {
									for (int i = 3; i <= t.size() - 1; i = i + 4) {
										te += Integer.parseInt(t.get(i));
									}
									t.add("总计");
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
				Bill.add(Search);

				bill.setVisible(true);

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
		Test.add(billinfo);
//选择课程
		JButton lessonc = new JButton("选择课程");
		lessonc.setBounds(420, 232, 300, 50);// 大小间隔30
		lessonc.setFont(font3);
		lessonc.setForeground(new Color(219, 69, 32));
		lessonc.setToolTipText("开始本学期的选课");
		lessonc.setBorderPainted(true);// 绘制边框
		lessonc.setBorder(BorderFactory.createEtchedBorder());// 雕刻边框
		lessonc.setContentAreaFilled(false);// 取消填充物

		boolean isstart[] = {true};// 选课是否开始的标志
		// 此处需要查询课程表中符合该学生所在年级及所属系的所有有老师的课程项，该学生曾修课所有项，该学生暂存表
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
			System.out.println("数据库连接失败！!");
			// e.printStackTrace();
		} catch (Exception e3) {
			// e.printStackTrace();
		}
		lessonc.addMouseListener(new MouseAdapter() {
			@Override
			// 鼠标点击
			public void mouseClicked(MouseEvent e) {
				super.mouseEntered(e);
				JButton btn = (JButton) e.getComponent();
				btn.setBorderPainted(true);// 显示边框
				btn.setBorder(BorderFactory.createLoweredBevelBorder());// 凹陷边框

				if (!isstart[0]) {
					JOptionPane.showMessageDialog(null, "未到选课时间！", "提示", JOptionPane.WARNING_MESSAGE);
				} else {// 以下是在选课时间内的代码

					JDialog less = new JDialog();
					less.setModal(true);// 设置为模态
					
					Vector<String> temp1=new Vector<String>();
					temp1.add("课程名");
					temp1.add("课程代码");
					temp1.add("上课时间");
					temp1.add("先决条件");
					temp1.add("授课教授");
					temp1.add("课程费用");
					// 测试数据
					Vector<String> temp2=new Vector<String>();
					Vector<String> temp3=new Vector<String>();
					Vector<String> tem3=new Vector<String>();//用于读取数据库中暂存的课名
					String[] tem1 = { "计划类型", "课程名", "课程代码", "上课时间", "先决条件", "授课教授", "课程费用" };
					Vector<String> temp4=new Vector<String>();
					Vector<String> temp5=new Vector<String>();//资格表信息
					String isnowc=" ";
					for(int i=0;i<tem1.length;i++)
					{
						temp3.add(tem1[i]);
					}
					for(int i=0;i<42;i++)
					{
						if(i==0)
							temp4.add("必选课1");
						else if(i==7)
							temp4.add("必选课2");
						else if(i==14)
							temp4.add("必选课3");
						else if(i==21)
							temp4.add("必选课4");
						else if(i==28)
							temp4.add("备选课1");
						else if(i==35)
							temp4.add("备选课2");
						else
							temp4.add(" ");
					}
					Integer gra=0;
					 //数据库调用
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
							 classlevel.add("大一上");
							 classlevel.add("大一下");
						 }else if(gra==2)
						 {
							 classlevel.add("大二上");
							 classlevel.add("大二下");
						 }else if(gra==3)
						 {
							 classlevel.add("大三上");
							 classlevel.add("大三下");
						 }else if(gra==4)
						 {
							 classlevel.add("大四上");
							 classlevel.add("大四下");
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
						System.out.println("数据库连接失败！!");
						// e.printStackTrace();
					} catch (Exception e3) {
						// e.printStackTrace();
						System.out.println("?");
					}

					//结束
					//处理暂存表
					int x=0;
					for(int i=0;i<temp2.size();i+=6)
					{
						for(int j=0;j<tem3.size();j++)
						{
							if(temp2.get(i).equals(tem3.get(j)))
							{
								for(x=1;x<temp4.size();x+=7)//寻找空位
								{
									if(temp4.get(x).equals(" "))
										break;
								}
								for(int y=0;y<6;y++)//添加到temp4
									temp4.set(x+y, temp2.get(i+y));				
								for(int y=0;y<6;y++)//删除temp2
									temp2.remove(i);
								i-=6;
								x=0;
								break;
							}
						}
					}
					
					//temp2和temp4处理完，tem3失去作用

					boolean[] flag = { false, false, false };
// 	   	          boolean issave=false;//是否提交
// 	   	          boolean exchange=false;//修改标记
// 	   	          boolean save=false;//保存标记

					if (temp4.get(1).equals(" ")) {
						less.setTitle("选课界面（状态：无选课计划）");
					} else if (isnowc.equals(" ")) {
						less.setTitle("选课界面（状态：未提交）");
					} else if (!isnowc.equals(" ")) {
						less.setTitle("选课界面（状态：已提交）");
						flag[0]=true;
					}

					less.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
					less.setResizable(false);// 不可调整大小

					Dimension d = Toolkit.getDefaultToolkit().getScreenSize();// 获得屏幕尺寸
					int width = 900;// The application's width
					int height = 500;
					less.setBounds((d.width - width) / 2, (d.height - height) / 2, width, height);// 窗口的坐标和尺寸，这种方式居中
					less.setLayout(null);// 设置布局方式

					// 图片托底
					JPanel Less = new HomePanel(2);
					Less.setLayout(null);
					Less.setBounds(0, 0, width, height);
					less.add(Less);

					less.addWindowListener(new WindowAdapter() {
						@Override
						public void windowClosing(WindowEvent e) {
							if (flag[1] != false && flag[2] == false) {
								int option = JOptionPane.showConfirmDialog(null, "有未保存的内容,是否保存? ", "提示 ",
										JOptionPane.YES_NO_OPTION);
								if (option == JOptionPane.YES_OPTION) {
									// 此处添加保存的代码
									//数据库操作
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
										System.out.println("数据库连接失败！!");
										// e.printStackTrace();
									} catch (Exception e3) {
										// e.printStackTrace();
									}
									//操作结束
									JOptionPane.showMessageDialog(null, "保存成功（请及时提交！）", "提示", JOptionPane.WARNING_MESSAGE);
									less.dispose();
								} else {
									less.dispose();
								}
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

					JLabel lessont = new JLabel("按授课老师检索", JLabel.CENTER);
					lessont.setFont(new Font("微软雅黑", Font.BOLD, 13));
					lessont.setBounds(490, 10, 100, 30);
					Less.add(lessont);

					JTextField lessonteacher = new JTextField(10);
					lessonteacher.setBounds(600, 10, 120, 30);
					Less.add(lessonteacher);

					JTabbedPane tabbedPane = new JTabbedPane();
					tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);// 设置选项卡标签的布局方式为滚动布局

					ModelDemo tablemodel = new ModelDemo(temp2, temp1);
					ModelDemo tablemodel2 = new ModelDemo(temp4, temp3);
					JTable table = new JTable(tablemodel);
					JTable table2 = new JTable(tablemodel2);
					table.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent e) {
							int y = 0;//存row辅助用
							boolean pre = false;//是否满足先决条件,默认不满足
							boolean pre2 = true;//是否日程冲突，默认不冲突
							int p2=-1;//保存日程冲突的课程位置
							if (e.getClickCount() == 2)// 实现双击事件
							{
								int row = ((JTable) e.getSource()).rowAtPoint(e.getPoint()); // 获得行位置
								if (!temp4.get(41).equals(" "))// 判断是否有空位
								{
									JOptionPane.showMessageDialog(null, "已选列表已满！", "提示", JOptionPane.WARNING_MESSAGE);
									return;
								}
								if(temp2.get(row*6+3)!=null) {//判断先决条件的前提是它不为空
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
								if (pre == true  && pre2 == true)// 判断先决条件和日程冲突
								{
									int option = JOptionPane.showConfirmDialog(null, "是否要把所选课程加入选课列表 ", "提示 ",
											JOptionPane.YES_NO_OPTION);
									if (option == JOptionPane.YES_OPTION) {
										for (int i = 0; i < 42; i += 7)// 寻找第一个空位
										{
											if (temp4.get(i + 1).equals(" ")) {
												y = i + 1;//找到后把值赋给y
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
										less.setTitle("选课界面（状态：未保存）");
									}

								} else {
									if (pre2 == false)
										JOptionPane.showMessageDialog(null, "与 "+temp4.get(p2)+" 日程冲突！", "提示", JOptionPane.WARNING_MESSAGE);
									else
										JOptionPane.showMessageDialog(null, "不满足先决条件！", "提示",
												JOptionPane.WARNING_MESSAGE);
									p2=-1;
									return;
								}
								// int row =((JTable)e.getSource()).rowAtPoint(e.getPoint()); //获得行位置
								// int col=((JTable)e.getSource()).columnAtPoint(e.getPoint()); //获得列位置
								// String cellVal=(String)(tablemodel.getValueAt(row,col)); //获得点击单元格数据

							}
						}
					});

					table2.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent e) {
							int y = 0;
//							boolean pre = false;
//							boolean pre2=true;
							if (e.getClickCount() == 2)// 实现双击事件
							{
								int row = ((JTable) e.getSource()).rowAtPoint(e.getPoint()); // 获得行位置
								if (temp4.get(row * 7 + 1).equals(" "))
									return;
								else {
									y = row;
									int option = JOptionPane.showConfirmDialog(null, "是否确认移除该课程? ", "提示 ",
											JOptionPane.YES_NO_OPTION);
									if (option == JOptionPane.YES_OPTION) {
										for (int i = 0; i < 6; i++) {
											temp2.add(temp4.get(row * 7 + 1 + i));
											temp4.set(row * 7 + 1 + i, " ");
										}
										tablemodel.setTableData(temp2);
										tablemodel.fireTableStructureChanged();
										if (row != 5) {
											while (!temp4.get(y * 7 + 8).equals(" ")) {//判断下一行是否有数据
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
										less.setTitle("选课界面（状态：未保存）");
									}
								}
							}
						}
					});

					JButton  Saving= new JButton("保存");
					Saving.setBounds(710, 220, 130, 50);// 大小间隔30
					Saving.setFont(font3);
					Saving.setForeground(new Color(219, 69, 32));
					Saving.setToolTipText("暂存选课计划");
					Saving.setBorderPainted(true);// 绘制边框
					Saving.setBorder(BorderFactory.createEtchedBorder());// 雕刻边框
					//Saving.setContentAreaFilled(false);// 取消填充物					
					Saving.addMouseListener(new MouseAdapter() {
						@Override
						// 鼠标点击
						public void mouseClicked(MouseEvent e) {
							//数据库操作
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
								System.out.println("数据库连接失败！!");
								// e.printStackTrace();
							} catch (Exception e3) {
								// e.printStackTrace();
							}
							//操作结束
							flag[0]=false;
						    flag[1]=false;
						    flag[2]=true;
						    less.setTitle("选课界面（状态：已保存）");
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
					
					Less.add(Saving);
					
					
					JButton  Submit= new JButton("提交");
					Submit.setBounds(710, 300, 130, 50);// 大小间隔30
					Submit.setFont(font3);
					Submit.setForeground(new Color(219, 69, 32));
					Submit.setToolTipText("提交选课计划到系统");
					Submit.setBorderPainted(true);// 绘制边框
					Submit.setBorder(BorderFactory.createEtchedBorder());// 雕刻边框
					//Submit.setContentAreaFilled(false);// 取消填充物


				
					Submit.addMouseListener(new MouseAdapter() {
						@Override
						// 鼠标点击
						public void mouseClicked(MouseEvent e) {
							//提交包括保存
							//数据库操作
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
								//以上是保存到暂存表中
								sqlstack.removeAllElements();
								//首先删除nowc和tempc里的表项
								System.out.println(statement.executeUpdate("delete from nowc where StuID="+Stu.StuID));
								System.out.println(statement.executeUpdate("delete from tempc where StuID="+Stu.StuID));
								//删除结束
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
							}//以上是存到nowc和tempc中
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
							//操作结束
							
							flag[0]=true;
						    flag[1]=false;
						    flag[2]=true;
						    less.setTitle("选课界面（状态：已提交）");
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
					
					Less.add(Submit);
					
					JScrollPane scrollpane = new JScrollPane(table);// 添加表格到滚动轴
					JScrollPane scrollpane2 = new JScrollPane(table2);
					tabbedPane.addTab("可选课表", scrollpane);
					tabbedPane.addTab("已选课表", scrollpane2);

					tabbedPane.setBounds(30, 70, 620, 370);
					tabbedPane.setSelectedIndex(0); // 设置索引为0的选项卡被选中
					Less.add(tabbedPane);

					JButton Search = new JButton("查询");
					Search.setBounds(735, 10, 60, 30);// 大小
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
					Reset.setBounds(810, 10, 60, 30);// 大小
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
							lessonteacher.setText(" ");
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
					Less.add(Reset);
					Less.add(Search);
					less.setVisible(true);

				} // 判断选课是否开始的回括号

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

		JButton gradeseek = new JButton("查询成绩");
		gradeseek.setBounds(420, 312, 300, 50);// 大小间隔30
		gradeseek.setFont(font3);
		gradeseek.setForeground(new Color(219, 69, 32));
		gradeseek.setToolTipText("查询历史成绩");
		gradeseek.setBorderPainted(true);// 绘制边框
		gradeseek.setBorder(BorderFactory.createEtchedBorder());// 雕刻边框
		gradeseek.setContentAreaFilled(false);// 取消填充物
		gradeseek.addMouseListener(new MouseAdapter() {

				
				@Override
				// 鼠标点击
				public void mouseClicked(MouseEvent e) {
					super.mouseEntered(e);
					JButton btn = (JButton) e.getComponent();
					btn.setBorderPainted(true);// 显示边框
					btn.setBorder(BorderFactory.createLoweredBevelBorder());

					JDialog grade = new JDialog();
					grade.setModal(true);
					grade.setTitle("查询成绩界面");
					grade.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
					grade.setResizable(false);// 不可调整大小

					Dimension d = Toolkit.getDefaultToolkit().getScreenSize();// 获得屏幕尺寸
					int width = 600;// The application's width
					int height = 450;
					int x = (d.width - width) / 2;
					int y = (d.height - height) / 2;
					grade.setBounds((d.width - width) / 2, (d.height - height) / 2, width, height);// 窗口的坐标和尺寸，这种方式居中
					grade.setLayout(null);// 设置布局方式

					// 图片托底
					JPanel Grade = new HomePanel(2);
					Grade.setLayout(null);
					Grade.setBounds(0, 0, width, height);
					grade.add(Grade);

					JLabel choic = new JLabel("选择学期", JLabel.CENTER);
					choic.setFont(new Font("宋体", 1, 15));
					choic.setBounds(10, 10, 120, 30);
					Grade.add(choic);

					String[] listData = new String[] { "全部", "大一上", "大一下", "大二上", "大二下", "大三上", "大三下", "大四上",
							"大四下" };
					String[] listD;
					Integer gra=0;
					 //数据库调用
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
						System.out.println("数据库连接失败！!");
						// e.printStackTrace();
					} catch (Exception e3) {
						// e.printStackTrace();
					}
					
					//结束
					gra=gra/10000%100-20;
					listD=new String[(listData.length-gra*2)];
					for(int i=0;i<(listData.length-gra*2);i++)
					{
						listD[i]=listData[i];
					}
					JComboBox<String> comboBox = new JComboBox<String>(listD);
					comboBox.setSelectedIndex(0);
					comboBox.setBounds(150, 12, 100, 25);
					comboBox.setFont(new Font("微软雅黑", Font.BOLD, 12));
					Grade.add(comboBox);

					JButton Search = new JButton("查找");
					Search.setBounds(400, 10, 60, 30);// 大小
					Font font2 = new Font("宋体", Font.BOLD, 13);
					Search.setFont(font2);
					Search.setForeground(Color.blue);
					Search.setBorderPainted(true);// 不绘制边框
					// Search.setContentAreaFilled(false);//取消填充物
					Search.setBorder(BorderFactory.createEtchedBorder());

					
					
					// 设置tab和table
					Vector <String>temp1=new Vector<String>();
					temp1.add("课程名");
					temp1.add("课程代码");
					temp1.add("授课教授");
					temp1.add("所处年级");
					temp1.add("成绩");
					Vector<String> temp2=new Vector<String>();
					 //数据库调用
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
						System.out.println("数据库连接失败！!");
						// e.printStackTrace();
					} catch (Exception e3) {
						// e.printStackTrace();
					}
					
					//结束
					// 如果temp2为空也要指定一个空格作为元素
					JTabbedPane tabbedPane = new JTabbedPane();
					tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);// 设置选项卡标签的布局方式为滚动布局
					ModelDemo tablemodel = new ModelDemo(temp2, temp1);
					JTable table = new JTable(tablemodel);
					// table.getColumnModel().getColumn(0).setPreferredWidth(200);//设置某列的宽度
					// table.setRowHeight(1, 100);//设置某行的行高
					// table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);//关闭自动调整列的宽度，如果不需要则必须先设置每列的宽度
					JScrollPane scrollpane = new JScrollPane(table);// 添加表格到滚动轴
					tabbedPane.addTab("成绩表格", scrollpane);
					tabbedPane.setBounds(30, 50, 520, 350);
					tabbedPane.setSelectedIndex(0); // 设置索引为0的选项卡被选中
					Grade.add(tabbedPane);

					Search.addMouseListener(new MouseAdapter() {
						@Override
						// 鼠标点击
						public void mouseClicked(MouseEvent e) {
							super.mouseEntered(e);
							JButton btn = (JButton) e.getComponent();
							btn.setBorderPainted(true);// 显示边框
							btn.setBorder(BorderFactory.createLoweredBevelBorder());
							String temp = (String) comboBox.getSelectedItem();
							Vector<String> t = new Vector<String>();
							if (temp != null) {
								if (temp == "大一上") {
									for (int i = 0; i < (temp2.size() / 5); i++) {
										if (temp2.get(i*5+3).equals("大一上")) {
											for (int y = 0; y < 5; y++) {

												t.add(temp2.get(i*5+y));
											}
										}
									}
									tablemodel.setTableData(t);
									tablemodel.fireTableDataChanged();
									t.removeAllElements();
								} else if (temp == "全部") {
									for (int i = 0; i < temp2.size(); i++) {
										t.add(temp2.get(i));
									}
									tablemodel.setTableData(t);
									tablemodel.fireTableDataChanged();
									t.removeAllElements();
								} else if (temp == "大一下") {
									for (int i = 0; i < (temp2.size() / 5); i++) {
										if (temp2.get(i*5+3).equals("大一下")) {
											for (int y = 0; y < 5; y++) {

												t.add(temp2.get(i*5+y));
											}
										}
									}
									tablemodel.setTableData(t);
									tablemodel.fireTableDataChanged();
									t.removeAllElements();
								} else if (temp == "大二上") {
									for (int i = 0; i < (temp2.size() / 5); i++) {
										if (temp2.get(i*5+3).equals("大二上")) {
											for (int y = 0; y < 5; y++) {

												t.add(temp2.get(i*5+y));
											}
										}
									}
									tablemodel.setTableData(t);
									tablemodel.fireTableDataChanged();
									t.removeAllElements();
								} else if (temp == "大二下") {
									for (int i = 0; i < (temp2.size() / 5); i++) {
										if (temp2.get(i*5+3).equals("大二下")) {
											for (int y = 0; y < 5; y++) {

												t.add(temp2.get(i*5+y));
											}
										}
									}
									tablemodel.setTableData(t);
									tablemodel.fireTableDataChanged();
									t.removeAllElements();
								} else if (temp == "大三上") {
									for (int i = 0; i < (temp2.size() / 5); i++) {
										if (temp2.get(i*5+3).equals("大三上")) {
											for (int y = 0; y < 5; y++) {

												t.add(temp2.get(i*5+y));
											}
										}
									}
									tablemodel.setTableData(t);
									tablemodel.fireTableDataChanged();
									t.removeAllElements();
								} else if (temp == "大三下") {
									for (int i = 0; i < (temp2.size() / 5); i++) {
										if (temp2.get(i*5+3).equals("大三下")) {
											for (int y = 0; y < 5; y++) {

												t.add(temp2.get(i*5+y));
											}
										}
									}
									tablemodel.setTableData(t);
									tablemodel.fireTableDataChanged();
									t.removeAllElements();
								} else if (temp == "大四上") {
									for (int i = 0; i < (temp2.size() / 5); i++) {
										if (temp2.get(i*5+3).equals("大四上")) {
											for (int y = 0; y < 5; y++) {

												t.add(temp2.get(i*5+y));
											}
										}
									}
									tablemodel.setTableData(t);
									tablemodel.fireTableDataChanged();
									t.removeAllElements();
								} else if (temp == "大四下") {
									for (int i = 0; i < (temp2.size() / 5); i++) {
										if (temp2.get(i*5+3).equals("大四下")) {
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
					Grade.add(Search);

					grade.setVisible(true);
				
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
		Test.add(gradeseek);

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

//工具类	
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
				
				/*列出成绩单*/
				Statement statement = con.createStatement();
				String sql = "select CourseID,CourseName,Grade from evercourse where StuID = "+this.StuID;
				ResultSet rs = statement.executeQuery(sql);
				
				System.out.println("查询成绩系统");
				System.out.println("-----------------");
				System.out.println("您以往的成绩清单：");
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
				System.out.println("数据库执行出错！！");
			}catch(Exception e) {
				System.out.println("其余错误！！");
			}		
		}
		
		public void ChangePassWord() {
			System.out.println("修改密码系统");
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
				System.out.println("请输入新的密码：");
				System.out.println("--------------");
				
				String pw = "Zjh1013";
				/*修改密码sql语句*/
				Statement statement = con.createStatement();
				String sql = "update student set StuPassword = \""+pw+"\" where StuID = "+this.StuID;
				int Result = statement.executeUpdate(sql);
				if(Result == 0) {
					System.out.println("更新失败");
				}else {
					System.out.println("更新成功");
				}
				con.close();
			}catch(ClassNotFoundException e) {
				System.out.println("Sorry,can't find the Driver!");
			}catch(SQLException e) {
				System.out.println("数据库执行出错！！");
			}catch(Exception e) {
				System.out.println("其余错误！！");
			}		
		}
	}
}
