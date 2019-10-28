import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

public class MesoLexicographical extends MesoSortedAbstract
{
	
	private HashMap<String, Integer> asciiVal = new HashMap<String, Integer>();
	private HashMap<String, Integer> sortedAsciiMap;
	
	public MesoLexicographical(HashMap<String, Integer> asciiVal) {
		
		HashMap<String, Integer> sorted = (HashMap<String, Integer>) sortedMap(asciiVal);
		
            
		for (Entry<String, Integer> out : sorted.entrySet()) {
			System.out.println(out.getKey() + " " + out.getValue());
		}
	
	}

	@Override
	Map<String, Integer> sortedMap(HashMap<String, Integer> unsorted) {
		this.asciiVal = unsorted;
		
	
	    TreeMap<String, Integer> sortedKeys = new TreeMap<>(unsorted);
	        Set<Entry<String, Integer>> sortedAsciiMap = sortedKeys.entrySet();
		
//		ArrayList<String> asciiValArray = new ArrayList<String>();
//		
//		for(Entry<String, Integer> out : asciiVal.entrySet()) {
//			asciiValArray.add(out.getKey());
//		}
//		
//		for(int i = 0; i < asciiValArray.size(); ++i) {
//	            for (int j = i + 1; j < 4; ++j) {
//	                if (asciiValArray.get(i).compareTo(asciiValArray.get(j)) > 0) {
//	                    // swap words[i] with words[j[
//	                    String temp = asciiValArray.get(i);
//	                    asciiValArray.set(i, asciiValArray.get(j));
//	                    asciiValArray.set(j, temp);
//	                }
//	            }
//	        }
//	       
//	        for(int i = 0; i < asciiValArray.size(); i++) {
//	            sortedAsciiMap.put(asciiValArray.get(i), 76);
//	        }
		
		return (Map<String, Integer>) sortedAsciiMap;
	}

}