/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ciscoscanner;

import com.jcraft.jsch.UIKeyboardInteractive;
import com.jcraft.jsch.UserInfo;

/**
 *
 * @author SAT-7
 */
public abstract class MyUserInfo implements UserInfo, UIKeyboardInteractive
{
        @Override
        public String getPassword(){ return null; }
        @Override
        public boolean promptYesNo(String str){ return false; }
        @Override
        public String getPassphrase(){ return null; }
        @Override
        public boolean promptPassphrase(String message){ return false; }
        @Override
        public boolean promptPassword(String message){ return false; }
        @Override
        public void showMessage(String message){ }
        @Override
        public String[] promptKeyboardInteractive(String destination,String name,String instruction,String[] prompt,boolean[] echo)
        {
            return null;
        }
}

