public class Sieve{

 public Sieve(){}

 public void primesTo(int n){
   LinkedQueue<Integer> results = primesToWrapper(n);
   System.out.println("Primes up to " + n + " are: " + results.toString().substring(1,results.toString().length()-1) );
 }

 private LinkedQueue<Integer> primesToWrapper(int n){
   LinkedQueue<Integer> primes = new LinkedQueue();
   LinkedQueue<Integer> numbers = new LinkedQueue();
   int counter = 2;
   while(counter <= n){
     numbers.enqueue(counter);
     counter++;
   }
   int p = numbers.first();
   while(p <= Math.sqrt(n)){
     primes.enqueue(p);
     numbers.dequeue();
     LinkedQueue<Integer> tempStore = new LinkedQueue();
     counter = numbers.first();
     while(!numbers.isEmpty()){
       counter = numbers.first();
       if(counter % p != 0) tempStore.enqueue(counter);
       numbers.dequeue();
     }
     numbers = tempStore;
     p = numbers.first();
   }
   while(!numbers.isEmpty()) {
    primes.enqueue(numbers.first());
    numbers.dequeue();
  }
   return primes;
 }

}
