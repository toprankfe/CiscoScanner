/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ciscoscanner;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.UserInfo;
import javax.swing.JOptionPane;


/**
 *
 * @author SAT-7
 */
public class sshShell 
{

    private String username;
    private String password;
    private String hostname;
    private String port;
    String sessionID;
    Channel channel;
    JSch jsch = new JSch();
    Session session;
    
    
    public sshShell(){} 
    
    public sshShell(String username, String password, String hostname, String port)
    {
        this.username = username;
        this.password = password;
        this.hostname = hostname;
        this.port = port;
    }
                 
    public void callShell() throws JSchException
    {
         
        try{ 
            
            
            session = jsch.getSession(username, hostname, Integer.parseInt(port));
            session.setPassword(password);
            UserInfo ui = new MyUserInfo()
            {
                @Override
                public void showMessage(String message)
                {
                    JOptionPane.showMessageDialog(null, message);
                }
                @Override
                public boolean promptYesNo(String message)
                {
                    Object[] options={ "yes", "no" };
                    int foo=JOptionPane.showOptionDialog(null,
                    message,
                    "Warning",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.WARNING_MESSAGE,
                    null, options, options[0]);
                    return foo==1;
                }
            };
            session.setUserInfo(ui);
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect(30000); // making a connection with timeout.
            this.channel = session.openChannel("shell");
            channel.connect(3*1000);
            this.sessionID = channel.getSession().toString();
            
            
            
            
        } catch(JSchException e){System.out.println(e);}
           
    }
    public String sessionOK()
    {
        if (sessionID != null)
        {
            return "Connected";
        }
        return "Not Connected";
    }
    public void closeChannel() throws JSchException
    {
        this.channel.disconnect();
        
    }
}
    
    



 
    

