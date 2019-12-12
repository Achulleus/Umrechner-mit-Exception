package Binaer;

import java.lang.reflect.Array;
import java.util.Scanner;

public class Rechner extends BinareException {
	
static void wandleBinInDez() throws BinareException {
	
	Scanner eingabe = new Scanner(System.in);
	System.out.println("Bitte gib eine Dualzahl ein!");
	
	int binZahl = eingabe.nextInt();
	int anzahlVerschiebung=0;
	int dezZahl=0;
	int restWert=0;
	boolean check = false;
	int z = 0;
	int minStellen = 8;
	
	while (binZahl !=0){
		restWert=binZahl % 10;
		dezZahl = dezZahl+(int)(restWert*(Math.pow(2, anzahlVerschiebung)));	
		binZahl=binZahl / 10;
		anzahlVerschiebung=anzahlVerschiebung+1;
	}
	
	String s = Integer.toString(binZahl);
	char [] c = s.toCharArray();
	for(int i = 0; i<s.length(); i++) {
		if((c[i]==0) || (c[i]==1)) z++;
	}
	if(z==s.length()) check = true;
	
	if((check == false) || (s.length()<minStellen)) throw new BinareException("Falsche eingabe oder zu wenig Stellen.");
	
	System.out.println(dezZahl);
}	

	public static void main(String[] args) {
		boolean durchgefuert = false;
		do {
			try{
				wandleBinInDez();
				durchgefuert = true;
			}catch(BinareException b){
				b.printStackTrace();
			}
		}while(durchgefuert==false);
	}
}
