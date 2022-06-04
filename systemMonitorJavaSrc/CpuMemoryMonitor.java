/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package systemmanager;

import com.sun.management.OperatingSystemMXBean;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

/**
 *
 * @author Saubali
 */
public class CpuMemoryMonitor {
    public void CpuMemoryMonitoring() throws Exception{
        OperatingSystemMXBean operatingSystemMXBean = (com.sun.management.OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        //OperatingSystemMXBean operatingSystemMXBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        DatabaseConnection dbConnect=new DatabaseConnection();
        
        while(true){
            try{
                Thread.sleep(60000);
            }
            catch(Exception e){}
            double cpuLoad=operatingSystemMXBean.getSystemCpuLoad();
            long currentTimeMillis=System.currentTimeMillis();
            long memoryInByte=operatingSystemMXBean.getTotalPhysicalMemorySize()-operatingSystemMXBean.getFreePhysicalMemorySize();
            System.out.println("Cpu load:"+operatingSystemMXBean.getSystemCpuLoad()+"    RAM usage:"+memoryInByte);
            dbConnect.connectDB(cpuLoad, memoryInByte,currentTimeMillis);
        }
    }
}
