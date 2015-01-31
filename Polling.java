import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.*;

public class Polling
{
	private final String USERNAME = "GreenBeans";
	private final String PASSWD = "darshan";
	HashMap<String, ArrayList<ArrayList<String>>> hash = new HashMap<String, ArrayList<ArrayList<String>>>();
	//ArrayList<String> networths = new ArrayList<String>();
	
	/*public static void main(String[] args)
	{
		Polling poller = new Polling();
		try
		{
			poller.poll();
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}*/
	
	public void poll() throws IOException
	{
		Socket socket = new Socket("codebb.cloudapp.net", 17429);
        PrintWriter pout = new PrintWriter(socket.getOutputStream());
        BufferedReader bin = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        pout.println(USERNAME + " " + PASSWD);
        pout.println("SECURITIES");
        
        pout.println("CLOSE_CONNECTION");
        pout.flush();
        String line;
        while ((line = bin.readLine()) != null) {
            //System.out.println(line);
            
            String[] sectmp = line.split(" ");
            //System.out.println(sectmp.length);
            for (int i = 1; i < sectmp.length; i = i + 4)
            {
            	ArrayList<ArrayList<String>> values = new ArrayList<ArrayList<String>>();
            	ArrayList<String> sec = new ArrayList<String>();
            	String name = sectmp[i];
            	String networth = sectmp[i + 1];
            	String dividend = sectmp[i + 2];
            	String volatility = sectmp[i + 3];
            	sec.add(networth);
            	sec.add(dividend);
            	sec.add(volatility);
            	values.add(sec);
            	hash.put(name, values);
            }
            
        }
        
        System.out.println(hash.values());
        pout.close();
        bin.close();
	}
	
	
}
    
