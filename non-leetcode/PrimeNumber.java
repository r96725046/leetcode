import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PrimeNumber {
	private Set map = new HashSet();
	private List<List> res=new ArrayList<>();
	public static void main(String[] args) {
		PrimeNumber obj = new PrimeNumber();
		System.out.println(obj.findNumberOfWays("11373"));
		System.out.println(obj.findNumberOfWays("3175"));

	}

	public int findNumberOfWays(String input) {
		find(input, new ArrayList<>());
		return res.size();
	}

	public void find(String str,List<Integer> cur) {
		
		if (str.length() == 0) {
			res.add(new ArrayList<Integer>(cur));
			System.out.println(cur.toString());
			return;
		}
		for (int i = 0; i < str.length(); ++i) {
			String sub = str.substring(0, i + 1);
			int number = Integer.parseInt(sub);
			boolean isPrime = isPrime(number);
			if(isPrime){
				cur.add(number);
				find(str.substring(i + 1),	cur);
				cur.remove(cur.size()-1);
			}
		}

	}

	boolean isPrime(int n) {
		if (map.contains(n)) {
			return true;
		}
		if(n < 2)
			return false;
		if(n == 2)	// 2 is prime
			return true;
		//check if n is a multiple of 2
		if (n % 2 == 0)
			return false;
		//if not, then just check the odds
		for(int i=3; i<=n/2; i=i+2) {
			if(n % i == 0)
				return false;
		}
		map.add(n);
		return true;
	}
}