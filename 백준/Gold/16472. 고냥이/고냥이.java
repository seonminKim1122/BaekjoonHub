import java.io.*;
import java.util.*;

class Main {
	
	static int[] DAT = new int[26];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		char[] sentence = br.readLine().toCharArray();
		
		int start = 0;
		int end = 1;
		
		int types = 0;
		if (DAT[sentence[start] - 'a'] == 0) {
			types++;
		}
		DAT[sentence[start] - 'a']++;
		
		if (DAT[sentence[end] - 'a'] == 0) {
			types++;
		}
		DAT[sentence[end] - 'a']++;
		
		int result = end - start + 1;
		while (end < sentence.length) {
			if (types <= N) {
				// end 를 늘리기!
				end++;
				if (end >= sentence.length) break;
				
				if (DAT[sentence[end] - 'a'] == 0) {
					types++;
				}
				
				DAT[sentence[end] - 'a']++;
				if (types <= N) {
					result = Math.max(result,  end - start + 1);
				}
				
			} else {
				// start 를 줄이기!
				DAT[sentence[start] - 'a']--;
				if (DAT[sentence[start] - 'a'] == 0) {
					types--;
				}
				
				start++;
			}
		}
		
		System.out.println(result);
	}
}
