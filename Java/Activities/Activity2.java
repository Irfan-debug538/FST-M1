
public class Activity2 {
	public static void main(String[] args) {
		int[] numbers = {10,77,10,54,-11,10};
		
		int sum = 0;
		for (int num: numbers) {
			if (num == 10) {
				sum += num;
				
			}
		}
		System.out.println(sum);
	}

}
