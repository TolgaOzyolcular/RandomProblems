import java.util.Arrays;
import java.util.HashMap;
import java.util.*;

// Problem is to calculate how many days it takes to send an update to all cell towers. the 1's represent cell towers that are already 
// updated, the 0 represent's cell towers that are yet to receive the update. Per day, only towers directly adjacent to the 1's can be 
// updated (above, beneath, beside).

public class CellTowerUpdate {
	public static void main (String[] args) {
		//creating a graph that we will be able to call diff algorithms to search through.		
		List<List<Integer>> grid = new ArrayList<List<Integer>>();
		List<Integer> row = new ArrayList<Integer>();
			row.add(1);
			row.add(0);
			row.add(0);
			row.add(0);
			row.add(0);
			
		List<Integer> row2 = new ArrayList<Integer>();
			row2.add(0);
			row2.add(1);
			row2.add(0);
			row2.add(0);
			row2.add(0);
			
		List<Integer> row3 = new ArrayList<Integer>();
			row3.add(0);
			row3.add(0);
			row3.add(1);
			row3.add(0);
			row3.add(0);
			
		List<Integer> row4 = new ArrayList<Integer>();
			row4.add(0);
			row4.add(0);
			row4.add(0);
			row4.add(1);
			row4.add(0);
		List<Integer> row5 = new ArrayList<Integer>();
			row5.add(0);
			row5.add(0);
			row5.add(0);
			row5.add(0);
			row5.add(1);
			
		grid.add(row);
		grid.add(row2);
		grid.add(row3);
		grid.add(row4);
		grid.add(row5);
		
		
		System.out.println(NumberOfDays(5, 5, grid));
		
	}
	
	public static int NumberOfDays(int rows, int columns, List<List<Integer>> grid) {
		
		int numDays = 0;		
		boolean continueLooping = true;
		
		while(continueLooping) {
			
			for(int i = 0; i < grid.size(); i++) {
				System.out.println(grid.get(i));
			}
			
			System.out.println(" ");
			
			boolean zeroFound = false;
			//first run through to change all 0's with an adjacent 1 to a 2
			for(int y = 0; y < rows; y++) {
				List<Integer> listX = grid.get(y);
				for(int x = 0; x < columns; x++) {
					if(listX.get(x) == 0) {
						//check x axis
						if(x > 0 && x < columns-1){
							if(listX.get(x-1) == 1 || listX.get(x+1) == 1)
								listX.set(x, 2);
						}
						else if (x > 0) {
							if(listX.get(x-1) == 1)
								listX.set(x, 2);
						}
						else if(x < columns-1) {
							if(listX.get(x+1) == 1)
								listX.set(x, 2);
						}
						//check y axis
						if(y > 0 && y < rows-1) {
							if(grid.get(y-1).get(x) == 1 || grid.get(y+1).get(x) == 1)
								listX.set(x, 2);
						}
						else if(y > 0) {
							if(grid.get(y-1).get(x) == 1)
								listX.set(x, 2);
						}
						else if(y < rows-1) {
							if(grid.get(y+1).get(x) == 1)
								listX.set(x, 2);
						}
						
						//numDays++;
					}
					
					grid.set(y, listX);
				}
							
			}
			
			for(int y = 0; y < rows; y++) {
				List<Integer> listX = grid.get(y);
				for(int x = 0; x < columns; x++) {
					if(listX.get(x) == 2) {
						listX.set(x, 1);						
						zeroFound = true;
					}
				}
				grid.set(y, listX);
			}
			
			if(zeroFound)
				numDays++;
			else
				continueLooping = false;
						
		}
		
		
		return numDays;
	}
}
