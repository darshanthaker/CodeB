import java.util.Arrays;

public class Ticker {
    	public String name;
    	public double[] bidAsk;
    	
    	public Ticker(String line) {
    		getBidAsk(line);
    	}
    	
    	private void getBidAsk(String str) {
        	double[] result = new double[2];
        	String[] list = str.split("\\s+");
        	name = list[2]; //where the ticker occurs
        	int bid = Arrays.asList(list).indexOf("BID");
        	result[0] = Double.parseDouble(list[bid + 2]);
        	int ask = Arrays.asList(list).indexOf("ASK");
        	result[1] = Double.parseDouble(list[ask + 2]);
        	bidAsk = result;
        }
    	
    	public String toString() {
    		return name + ": " + Arrays.toString(bidAsk);
    	}
    }