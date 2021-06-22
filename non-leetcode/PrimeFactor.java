import java.util.*;

public class PrimeFactor {
    
	public static void main(String[] args) {
		PrimeFactor obj = new PrimeFactor();
		obj.factor(315);
	}

	void factor(int n) {
		List<Integer> res=new ArrayList<>();
		while (n % 2 == 0){
            res.add(2);
            n/=2;
        }
		for(int i=3; i<=n/2; i=i+2) {
            while(n%i==0){
                res.add(i);
                n/=i;
            }
		}
        if(n>1)
            res.add(n);
        System.out.println(res.toString());

	}
}