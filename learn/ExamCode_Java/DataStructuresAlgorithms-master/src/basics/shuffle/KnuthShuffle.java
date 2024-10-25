package basics.shuffle;

import static basics.sorting.utils.SortUtils.exchange;

import java.util.Random;

public class KnuthShuffle {
	
	public static int[] shuffle(int[] input){
		
		Random random=new Random();
		
		for (int i=0;i<input.length;i++){
			int rand=random.nextInt(i+1); //i+1 is non-inclusive
			
			exchange(input, i, rand);
			
		}
		
		return input;
		
	}

}
