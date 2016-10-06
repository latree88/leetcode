public class HashFunction{
	public static void main(String args[]){

		char[] key = {'u','b','u','n','t','u'};
		int size = 1007;

		int res = new HashFunction().hashCode(key, size);
		System.out.println(res);

	}

	public int hashCode(char[] key, int HASH_SIZE){
		int len = key.length;

		long ans = 0;
		for(int i = 0; i < len; i++){
			ans = (ans * 33 + (int)key[i]) % HASH_SIZE;
		
		}
		return (int)ans;

	}
}