/*The MIT License (MIT)

Copyright (c) 2015 Muhammad Alhadi B.

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.*/

public class Caesar {

    static char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

	public static void main(String[] args) {
		//Example: encrypting the "muhammad alhadi" with a key which equal 6
		int pos, k= 6;
		String toCrypt= "muhammad alhadi", strOut= "";
		for(int loop=0; loop< toCrypt.length(); loop++){
			if(toCrypt.charAt(loop)!=' '){
			pos= getCharPos(toCrypt.charAt(loop));
			pos= cryptPos(pos, k);
			strOut+= alphabet[pos];
			}
			else
				strOut+= " ";
		}
		
		System.out.println(strOut);
		
		//Example: decrypting what we've got after encryption in "strOut" with the same key
		toCrypt= strOut; strOut= "";
		for(int loop=0; loop< toCrypt.length(); loop++){
			if(toCrypt.charAt(loop)!=' '){
			pos= getCharPos(toCrypt.charAt(loop));
			pos= decryptPos(pos, k);
			strOut+= alphabet[pos];
			}
			else
				strOut+= " ";
		}
		
		System.out.println(strOut);
		
	}
	
	//Getting the new position of a character in function of the key
	public static int cryptPos(int pos, int key){
		int newPos= 0;
		newPos= pos+ key;
		if(newPos> 25)
			newPos-= 25;
		
		return newPos;
	}
	
	//Getting the original position of a character in function of the key
	public static int decryptPos(int pos, int key){
		int newPos= 0;
		newPos= pos- key;
		if(newPos< 0)
			newPos+= 25;
		
		return newPos;
	}

	//Getting the actual position of a character 
	public static int getCharPos(char c){
		int pos= 0;
		while(c!= alphabet[pos])
			pos++;
		return pos;
	}
}
