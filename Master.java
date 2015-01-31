public Master
{

    public static void main(String[] args)
    {
        HashMap<ArrayList<ArrayList<String>>> hash = new HashMap<ArrayList<ArrayList<String>>>();
        Polling poller = new Polling();
        poller.poll();
        hash = poller.getHash();
        
    }
}
