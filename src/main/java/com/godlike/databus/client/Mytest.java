package com.godlike.databus.client;

import java.rmi.registry.LocateRegistry;

import javax.management.MBeanServerConnection;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXConnectorServerFactory;
import javax.management.remote.JMXServiceURL;

public class Mytest {
	
	public static void main(String args[]) {
		final String objectNameStr = "dustin:type=status,name=remoteJMX";    
		final String jmxRmiStr =  "service:jmx:rmi://localhost/jndi/rmi://127.0.0.1:1099/jmxrmi";    
		 try    
		   {    
			    LocateRegistry.createRegistry(9999);
		        final ObjectName objectName = new ObjectName(objectNameStr);    
		        final JMXServiceURL jmxUrl = new JMXServiceURL(jmxRmiStr);    
		        final JMXConnector jmxConnector = JMXConnectorFactory.connect(jmxUrl);    
		        final MBeanServerConnection mbsc = jmxConnector.getMBeanServerConnection();  
		        System.out.println("b");
		   } catch (Exception e) {
			   e.printStackTrace();
		   }
	}

}
