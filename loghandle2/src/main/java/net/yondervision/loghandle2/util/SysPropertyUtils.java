package net.yondervision.loghandle2.util;



import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by javajiao on 15-5-20.
 */
public class SysPropertyUtils {

    private static String sysProperty;
    private static String sysProperty_weblogic;
    
    static {
        sysProperty = System.getProperty("sun.java.command");
        sysProperty_weblogic= System.getProperty("weblogic.Name");
    }

    private static String getWASNodeName() {
        String nodeName = null;
        if(sysProperty != null && !sysProperty.isEmpty()){
            String[] s = sysProperty.split("\\s+");
            nodeName = s[s.length-2];
        }else{
            nodeName="default";
        }
        return nodeName.trim();
    }


    public static String getLocalhostIP(){
    	String ip=null;
    try {
    	ip=	InetAddress.getLocalHost().getHostAddress().toString();
	} catch (UnknownHostException e) {
		ip="127.0.0.1";
	}
	return ip;
    }
    public static String getLocalhostname(){
    	String name=null;
    try {
    	name=	InetAddress.getLocalHost().getHostName().toString();
	} catch (UnknownHostException e) {
		name="Unknow";
	}
	return name;
    }
}
