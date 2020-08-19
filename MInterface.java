package jhz20200607;


import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import java.awt.*;
import java.awt.event.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class MInterface extends JFrame{
	public String name;
	public MInterface() {}
	void startup() {    
		
        Font headfont = new Font("微软雅黑",Font.BOLD,22);
        Font textfont = new Font("微软雅黑",Font.BOLD,12);
		
		//MainInterface
    	
		setTitle("用户登录");
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();// 获得屏幕尺寸
		int width = 800;// The application's width
		int height = 600;
		int x = (d.width - width) / 2;
		int y = (d.height - height) / 2;
		setBounds((d.width - width) / 2, (d.height - height) / 2, width, height);// 窗口的坐标和尺寸，这种方式居中


        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        
        addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int option = JOptionPane.showConfirmDialog(null, "确定退出系统? ", "提示 ", JOptionPane.YES_NO_OPTION);
				
				if (option == JOptionPane.YES_OPTION)
					dispose();
				else {
					return;

				}
			}
		});
        
        //mainpanel
        JPanel mainpanel = new JPanel();    
        add(mainpanel);
        mainpanel.setLayout(null);
        
       
        //headText
        JLabel headText = new JLabel("教务系统登录");
        headText.setBounds(305,100,200,100);
        headText.setFont(headfont);
        mainpanel.add(headText);
        
        //userLabel
        JLabel userLabel = new JLabel("用户名");
        userLabel.setBounds(220,200,80,25);
        userLabel.setFont(textfont);
        mainpanel.add(userLabel);   
        
        //userText
        JTextField userText = new JTextField(20);
        userText.setBounds(290,200,185,25);
        mainpanel.add(userText);
        
        //passwordLabel
        JLabel passwordLabel = new JLabel("密码");
        passwordLabel.setBounds(220,230,80,25);
        passwordLabel.setFont(textfont);
        mainpanel.add(passwordLabel);
        
        //passwordText
        // *** for security, use ****** instead of 123456 ***
        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(290,230,185,25);
        mainpanel.add(passwordText);
        
        //loginButton
        JButton loginButton = new JButton("登录");
        loginButton.setBounds(270,280,80,25);
        loginButton.setFont(textfont);
        mainpanel.add(loginButton);
        
        
        //loginMouseListener
        loginButton.addMouseListener(new MouseAdapter(){

			@Override
			public void mouseClicked(MouseEvent e) {
				
				//closeThisWindow();
				String username = userText.getText();
				String password = new String(passwordText.getPassword());
				
				
				//empty username or passwd
				if(username == null || username.isEmpty() || password == null || password.isEmpty()) {
					JOptionPane.showMessageDialog(null,"请输入完整信息！","提示",JOptionPane.WARNING_MESSAGE); 
				}
				
				else {

					
					int usernameValue = Integer.parseInt(username);
	
					//invalid username 
					if(!isStudent(usernameValue) && !isProfessor(usernameValue) && !isAdmin(usernameValue)) {
						JOptionPane.showMessageDialog(null,"用户名不存在！","提示",JOptionPane.WARNING_MESSAGE); 
					}
					
					
					else {
						//check username and passwd
						
						if (passwordMatch(username,password)) {
							
							if(isStudent(usernameValue)) {
								Jhzstudent stud = new Jhzstudent(username,name,password);
								stud.run();
								}
							else if(isProfessor(usernameValue)) {
								Jhzprofessor prof = new Jhzprofessor(username,name,password);
								prof.run();
							}
							else if(isAdmin(usernameValue)) {			
//								AdminInterface admin = new AdminInterface();
//								admin.run();
							}
						}
						
						//username and passwd not match
						else {
						
							JOptionPane.showMessageDialog(null,"密码不正确！","提示",JOptionPane.WARNING_MESSAGE); 
						}
					}
				}

					
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				JButton btn = (JButton) e.getComponent();
				btn.setBorderPainted(true);// 显示边框
				btn.setForeground(new Color(0x33, 0x66, 0xcc));// 设置字体颜色
				btn.setBorder(BorderFactory.createLoweredBevelBorder());
				btn.setRolloverEnabled(true);
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
        
        
        //forgotPasswordButton        
        JButton forgotPassword = new JButton("忘记密码");
        forgotPassword.setBounds(370,280,100,25);
        forgotPassword.setFont(textfont);
        mainpanel.add(forgotPassword);
        
        
        //forgotPasswordMouseListener
        forgotPassword.addMouseListener(new MouseAdapter() {
        	
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//change-password frame
				JFrame changepswd = new JFrame("忘记密码");
				Dimension d = Toolkit.getDefaultToolkit().getScreenSize();// 获得屏幕尺寸
				int width = 800;// The application's width
				int height = 600;
				int x = (d.width - width) / 2;
				int y = (d.height - height) / 2;
				changepswd.setBounds((d.width - width) / 2, (d.height - height) / 2, width, height);// 窗口的坐标和尺寸，这种方式居中

		        //changepswd.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				changepswd.setResizable(false);
				changepswd.setVisible(true);
				
				//change-password panel
		        JPanel pswdpanel = new JPanel();    
		        changepswd.add(pswdpanel);
		        pswdpanel.setBounds(0,0,800,600);
		        pswdpanel.setLayout(null);
		        
		        //headText
		        JLabel headText = new JLabel("修改密码");
		        headText.setBounds(330,50,200,100);
		        headText.setFont(headfont);
		        pswdpanel.add(headText);
		        
		        //usernameLabel
		        JLabel usernameLabel = new JLabel("用户名");
		        usernameLabel.setBounds(250,150,80,25);
		        usernameLabel.setFont(textfont);
		        pswdpanel.add(usernameLabel);   
		        
		        //oldlabel
				JLabel oldlabel = new JLabel("旧密码");
				oldlabel.setBounds(250, 190, 80, 25);
				oldlabel.setFont(textfont);
				pswdpanel.add(oldlabel);

				//newlabel
				JLabel newlabel = new JLabel("新密码");
				newlabel.setBounds(250, 230, 80, 25);
				newlabel.setFont(textfont);
				pswdpanel.add(newlabel);
				
				//confirmlabel
				JLabel confirmlabel = new JLabel("确认密码");
				confirmlabel.setBounds(240, 270, 80, 25);
				confirmlabel.setFont(textfont);
				pswdpanel.add(confirmlabel);
				
				//usernameText
		        JTextField usernameText = new JTextField(20);
		        usernameText.setBounds(300,150,185,25);
		        pswdpanel.add(usernameText);
				
				//oldpassword
				JPasswordField oldpswd = new JPasswordField(20);
				oldpswd.setBounds(300, 190, 185, 25);
				pswdpanel.add(oldpswd);

				
				//newpassword
				JPasswordField newpswd = new JPasswordField(20);
				newpswd.setBounds(300, 230, 185, 25);
				pswdpanel.add(newpswd);

				
				//confirmpassword
				JPasswordField confirmpswd = new JPasswordField(20);
				confirmpswd.setBounds(300, 270, 185, 25);
				pswdpanel.add(confirmpswd);
				
				
				//confirmbutton
				JButton confirmbutton = new JButton("确定");
				confirmbutton.setBounds(290,330,80,25);
				confirmbutton.setFont(textfont);
				pswdpanel.add(confirmbutton);
				
				
				//confirmbutton_mouselistener
				confirmbutton.addMouseListener(new MouseAdapter() {
					
					
					/***not complete***/
					@Override
					public void mouseClicked(MouseEvent e) {
						super.mouseEntered(e);
						JButton btn = (JButton) e.getComponent();
						btn.setBorderPainted(true);
						btn.setBorder(BorderFactory.createLoweredBevelBorder());
						
						String username = usernameText.getText();
						String oldpassword = new String(oldpswd.getPassword());
						String newpassword = new String(newpswd.getPassword());
						String confirmpassword = new String(confirmpswd.getPassword());
						
						if(username == null || username.isEmpty() || oldpassword == null || oldpassword.isEmpty()) {
							JOptionPane.showMessageDialog(null,"请输入完整信息！","提示",JOptionPane.WARNING_MESSAGE); 
						}
						
						else {

							
							int usernameValue = Integer.parseInt(username);
			
							//invalid username 
							if(!isStudent(usernameValue) && !isProfessor(usernameValue) && !isAdmin(usernameValue)) {
								JOptionPane.showMessageDialog(null,"用户名不存在！","提示",JOptionPane.WARNING_MESSAGE); 
							}
							else {

								if(changePassword(username,oldpassword,newpassword,confirmpassword)==true) {
									JOptionPane.showMessageDialog(null,"修改密码成功！","提示",JOptionPane.INFORMATION_MESSAGE);
									changepswd.dispose();
								}
								else {
									JOptionPane.showMessageDialog(null,"修改密码失败：用户名有效","提示",JOptionPane.WARNING_MESSAGE); 
								}
							}
						}
							
						

						


					}

					@Override
					public void mousePressed(MouseEvent e) {
						JButton btn = (JButton) e.getComponent();
						btn.setBorderPainted(true);// 显示边框
						btn.setForeground(new Color(0x33, 0x66, 0xcc));// 设置字体颜色
						btn.setBorder(BorderFactory.createLoweredBevelBorder());
						btn.setRolloverEnabled(true);
					}

					@Override
					public void mouseEntered(MouseEvent e) {
						JButton btn = (JButton) e.getComponent();
						btn.setForeground(new Color(0x33, 0x66, 0xcc));// 设置字体颜色
						btn.setBorderPainted(true);// 显示边框
						Border etchedBorder = new EtchedBorder(EtchedBorder.LOWERED);// 设置边框凹显
						btn.setBorder(etchedBorder);
						btn.setRolloverEnabled(true);
					}

					@Override
					public void mouseExited(MouseEvent e) {
						JButton btn = (JButton) e.getComponent();
						btn.setForeground(Color.blue);// 设置字体颜色
						btn.setBorder(BorderFactory.createEtchedBorder());
						btn.setBorderPainted(true);
					}
				
				});
				
				
				//cancelbutton
				JButton cancelbutton = new JButton("取消");
				cancelbutton.setBounds(400,330,80,25);
				cancelbutton.setFont(textfont);
				pswdpanel.add(cancelbutton);
				
				
				//cancelbutton_mouselistener
				cancelbutton.addMouseListener(new MouseAdapter() {
					
					@Override
					public void mouseClicked(MouseEvent e) {
						super.mouseEntered(e);
						JButton btn = (JButton) e.getComponent();
						btn.setBorderPainted(true);// 显示边框
						btn.setBorder(BorderFactory.createLoweredBevelBorder());

						changepswd.dispose();

					}

					@Override
					public void mousePressed(MouseEvent e) {
						JButton btn = (JButton) e.getComponent();
						btn.setBorderPainted(true);// 显示边框
						btn.setForeground(new Color(0x33, 0x66, 0xcc));// 设置字体颜色
						btn.setBorder(BorderFactory.createLoweredBevelBorder());
						btn.setRolloverEnabled(true);
					}

					@Override
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
				
				
			
			} 

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				JButton btn = (JButton) e.getComponent();
				btn.setBorderPainted(true);// 显示边框
				btn.setForeground(new Color(0x33, 0x66, 0xcc));// 设置字体颜色
				btn.setBorder(BorderFactory.createLoweredBevelBorder());
				btn.setRolloverEnabled(true);
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

        
        
        setVisible(true);
    }

	

	private boolean changePassword(String username,String oldpassword,String newpassword,String confirmpassword) {

		int rowcount1 = 0;
		int rowcount2 = 0;
		boolean flag =false;
		int id = Integer.parseInt(username);
		if(passwordMatch(username, oldpassword)&&newpassword.equals(confirmpassword)) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");// System.out.println("驱动加载成功");
				Connection conn = DriverManager.getConnection(
						"jdbc:mysql://127.12.216.221:3306/test?useSSL=false&serverTimezone=UTC", "root", "123456");
				// System.out.println("数据库连接成功");
				Statement statement = conn.createStatement();
				String sql ="select *from student where StuID="+id+" and StuPassword='"+oldpassword+"'";
				//System.out.println(sql);
			ResultSet result1 = statement.executeQuery(sql);
			while(result1.next())
				rowcount1++;
		       sql ="select *from professor where ProID="+id+" and Propassword='"+oldpassword+"'";
		       //System.out.println(sql);
			ResultSet result2 = statement.executeQuery(sql);
			while(result2.next())
				rowcount2++;
			if(id==1&&oldpassword.equals("000000"))
				flag=true;
			if(id==2&&oldpassword.equals("000000"))
			     flag=true;
			if(rowcount1>0) {//说明输入的账号和密码是学生端的
				 sql = "update student set StuPassword='"+newpassword+"'"+" where  StuID="+id;
				 statement.execute(sql);
			}
			if(rowcount2>0) {//说明输入的账号和密码是教授端的
				sql = "update professor set Propassword='"+newpassword+"'"+" where ProID="+id;
				statement.execute(sql);
			}
			if(flag==true) {//说明输入的账号和密码是管理员端的
				return false;
			}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return true;
		}
		else 
			return false;

	}
	

	private boolean passwordMatch(String username, String password) {
		int rowcount1 = 0;
		int rowcount2 = 0;
		boolean flag=false;
		int id = Integer.parseInt(username);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");// System.out.println("驱动加载成功");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://127.12.216.221:3306/test?useSSL=false&serverTimezone=UTC", "root", "123456");
			// System.out.println("数据库连接成功");
			Statement statement = conn.createStatement();
			String sql ="select *from student where StuID="+id+" and StuPassword='"+password+"'";
			//System.out.println(sql);
		ResultSet result1 = statement.executeQuery(sql);
		while(result1.next())
		{
			this.name=result1.getString("StuName");
			rowcount1++;
		}
	       sql ="select *from professor where ProID="+id+" and Propassword='"+password+"'";
	       //System.out.println(sql);
		ResultSet result2 = statement.executeQuery(sql);

		while(result2.next())
		{
			rowcount2++;
			this.name=result2.getString("ProName");
		}
		conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(id==1&&password.equals("000000"))
			flag=true;
		if(id==2&&password.equals("000000"))
			flag=true;
		if(rowcount1!=0||rowcount2!=0||flag == true)
			return true;
		else 
			return false;	
		}


	private boolean isStudent(int usernum) {
		if(usernum >= 21100000 && usernum <= 21200000) 
			return true;
		else 
			return false;
		}
	
	private boolean isProfessor(int usernum) {
		if(usernum >= 10000 && usernum < 12000 || usernum >= 20000 && usernum <= 21000) 
			return true;
		else 
			return false;
	}
   
	//administrators are composed of admin1 and admin2
	private boolean isAdmin(int usernum) {
		if(usernum == 1 || usernum == 2) {
			return true;
		}
		return false;
	}


}
