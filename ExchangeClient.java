/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author atamarkin2
 */
public class ExchangeClient {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        String[] tickers = { "AAPL", "ATVI", "FB", "EA", "GOOG", "MSFT", "SBUX", "SNY", "TSLA", "TWTR"};
        Ticker[] currentInfo = new Ticker[tickers.length];
        for (int i = 0; i < tickers.length; ++i) {
        	currentInfo[i] = new Ticker(command("ORDERS " + tickers[i]));
        }
        for (int i = 0; i < currentInfo.length; ++i) {
        	System.out.println(currentInfo.toString());
        }
    }
    
    private static double[] getBidAsk(String str) {
    	double[] result = new double[2];
    	String[] list = str.split("\\s+");
    	int bid = Arrays.asList(list).indexOf("BID");
    	result[0] = Double.parseDouble(list[bid + 2]);
    	int ask = Arrays.asList(list).indexOf("ASK");
    	result[1] = Double.parseDouble(list[ask + 2]);
    	return result;
    }
    
    private static String command(String input) throws IOException {
    	//String[] list = input.split("\\s+");
    	//System.out.println(Arrays.toString(list));
    	Socket socket = new Socket("codebb.cloudapp.net", 17429);
        PrintWriter pout = new PrintWriter(socket.getOutputStream());
        BufferedReader bin = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        pout.println("GreenBeans darshan");
        //for (int i = 0; i < list.length; i++) {
            pout.println(input);
        //}
        System.out.println();
        pout.println("CLOSE_CONNECTION");
        pout.flush();
        String line;
        String result = "";
        while ((line = bin.readLine()) != null) {
            result += line;
        }
        pout.close();
        bin.close();
        return result;
    }
    
    

}
