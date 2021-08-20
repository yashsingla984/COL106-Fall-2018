import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class checker
{
	public static void main ( String args [])
	{
		BufferedReader br = null;
		RoutingMapTree r = new RoutingMapTree();	

		try {
			String actionString;
			br = new BufferedReader(new FileReader("actions.txt"));
			int cnt=0;
			while ((actionString = br.readLine()) != null) {
				//System.out.println("reached checker");
				//System.out.println(actionString);
				String x=r.performAction(actionString);
				//System.out.println(x);
				//System.out.println(cnt+" "+(actionString));
				//System.out.println(r.performAction(actionString));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	}
}
