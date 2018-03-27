import java.util.*;
import java.util.stream.Stream;

//This problem is a string traversal problem where you must return all the repeated elements
//in the list except the elements given in negate list in alphabetical order

public class Problem1 {
	
	public static void main(String[] args) {
		String input = "This is is the input of of of the user user user where we are supposed "
				+ "supposed to find the most use use use words excepts the the ones that that are "
				+ "are given in the list list variable";
		
		List<String> negate = new ArrayList();
		negate.add("the");
		negate.add("use");
		negate.add("in");	
		
		System.out.println(OutputMethod(input, negate));
		
	}
	
	static List<String> OutputMethod(String a, List<String> b){
		
		List<String> temporaryList = new ArrayList();
		
		for(String word : a.split(" ")) {
			temporaryList.add(word);
		}
		
		//remove the words from the negate list
		
		String exclude;
		
		for(int i = 0; i<b.size(); i++) {
			exclude = b.get(i);
			temporaryList.removeAll(Collections.singleton(exclude));
		}
		
		HashSet singleWords = new HashSet();
		
		for(int i = 0; i<temporaryList.size(); i++) {
			String word = temporaryList.get(i);
			for(int j = i+1; j<temporaryList.size(); j++) {
				if(word.equals(temporaryList.get(j))) {
					singleWords.add(word);
				}
			}
		}
		
		temporaryList.clear();
		
		List<String> output = new ArrayList(singleWords);
		
		Collections.sort(output);
				
		return output;
		
	}
}
