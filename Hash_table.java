import java.util.*;

public class Hash_table {
	// creation of hash table
	public static class Hash_insertion {
		int key;
		int value;

		Hash_insertion(int key1, int value1) {
			this.key = key1;
			this.value = value1;
		}

		Hash_insertion() {

		}

		public int getkey() {
			return key;
		}

		public int getvalue() {
			return value;
		}
	}
  // function for Hash_map
	public static class Hash_Map {
		int table_size = 17;
		Hash_insertion[] O_table;
		int count;

		Hash_Map() {
         //Intially  Storing the null values in the Hash_table
			O_table = new Hash_insertion[table_size];
			for (int i = 0; i < table_size; i++) {
				O_table[i] = null;
			}
			count = 0;

		}

		// function to get the value when a key is entered;
		public int get_value(int key) {
			int hash = key % 17;
			// Linear probing when there is collision
			while (O_table[hash] != null && O_table[hash].getkey() != key) {
				hash = (hash + 1) % 17;
			}
			if (O_table[hash] == null) {
				return -1;
			} else
				System.out.print(key + " :" + O_table[hash].getvalue() + "\n");
			return O_table[hash].getvalue();

		}

		// function to put the value for the corresponding key
		public void put(int key, int value) {

			int hash = key % 17;
			// Linear probing when there is collision
			while (O_table[hash] != null && O_table[hash].getkey() != key) {
				hash = (hash + 1) % 17;
			}
			O_table[hash] = new Hash_insertion(key, value);
			count++;

		}

		// function to recreate table when load factor is greater than 0.5
		public void check_lamda() {
			float lamda = (float) (count) / table_size;
			System.out.println( "load factor: " + lamda);
			int new_table_size = 0;
			if (lamda > 0.5) {
				new_table_size = 2 * table_size;
				int temp = new_table_size + 1;
				temp=get_next_prime(temp);
				Hash_insertion[] N_table;
				N_table = new Hash_insertion[temp];
				for (int i = 0; i < temp; i++) {
					N_table[i] = null;
				}
                // if the load factor is more than 0.5, the table size is doubled and the old table is copied into New table;
				for (int i = 0; i < table_size; i++) {
					if (O_table[i] != null) {
						N_table[i] = new Hash_insertion(O_table[i].getkey(), O_table[i].getvalue());
					}
				}
				System.out.println("New_table");
				for (int i = 0; i < temp; i++) {
					if (N_table[i] != null) {
						System.out.print( N_table[i].getkey() + " :" + N_table[i].getvalue() + "\n" );
					}
				}
				O_table=null;
				O_table = N_table;
				table_size = temp;
			} else
				return;
		}
         // Function to get the next prime number after  doubling the size of Old_table
		public static int get_next_prime(int temp) {
			boolean isPrime = false;
			while (!isPrime) {
				isPrime = true;
				for (int i = 3; i < temp; i++) {
					if (temp % i == 0) {
						isPrime = false;
						break;
					}
				}
				if (!isPrime) {
					temp = temp + 2;
				}
			}
			System.out.println("The table size is doubled and chosen to be next prime number :" + temp);
			return temp;

		}

	}

	public static void main(String args[]) {
		Hash_Map obj11 = new Hash_Map();
		//Generating the random numbers for key;
		Random random_generator = new Random();
		
		for (int i=1; i<=17; i++){
			// Checking the value of load factor after each insertion
			obj11.check_lamda();
			int randomInt =  random_generator.nextInt(1000000000);
			obj11.put(randomInt,i );
		    obj11.get_value(randomInt);
		}
		


	}

}
