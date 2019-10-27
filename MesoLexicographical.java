import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MesoLexicographical extends MesoSortedAbstract
{
	
	private HashMap<String, Integer> asciiVal = new HashMap<String, Integer>();
	private HashMap<String, Integer> sortedAsciiMap;
	
	public MesoLexicographical(HashMap<String, Integer> asciiVal) {
		this.asciiVal = asciiVal;
		Map<String, Integer> sorted = sortedMap(asciiVal);
		
            System.out.println(sorted);
//		for (Entry<String, Integer> sorted : sortedAsciiMap) {
//			System.out.println();
//		}
	
	}

	@Override
	Map<String, Integer> sortedMap(HashMap<String, Integer> unsorted) {
		
		sortedAsciiMap = new HashMap<String, Integer>();
		ArrayList<String> asciiValArray = MesoEquivalent.sameAvgArray;
		
		for(int i = 0; i < asciiValArray.size(); ++i) {
	            for (int j = i + 1; j < 4; ++j) {
	                if (asciiValArray.get(i).compareTo(asciiValArray.get(j)) > 0) {
	                    // swap words[i] with words[j[
	                    String temp = asciiValArray.get(i);
	                    asciiValArray.set(i, asciiValArray.get(j));
	                    asciiValArray.set(j, temp);
	                }
	            }
	        }
	       
	        for(int i = 0; i < asciiValArray.size(); i++) {
	            sortedAsciiMap.put(asciiValArray.get(i), 73);
	        }
		
		return sortedAsciiMap;
	}

}