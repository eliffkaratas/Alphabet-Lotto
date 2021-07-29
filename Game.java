public class Game {
	static int playercount1 = 0; // çýkan harfler için ilk oyuncu sayacý
	static int playercount2 = 0; // çýkan harfler için ikinci oyuncu sayacý
	static int bag1count = 0;
	static Stack player1 = new Stack(8);
	static Stack player2 = new Stack(8);
	static Stack bag1 = new Stack (26);
	static Stack bag2 = new Stack (26);
	static char selectedLetter = 0; // random atýlan harf
	static int firstcounter1 = 0; // çinko þartý için sayaç
	static int firstcounter2 = 0;
	static int secondcounter1 = 0; // çinko þartý için sayaç
	static int secondcounter2 = 0;
	static int winningcounter1 = 0; // kazanma þartý için sayaç
	static int winningcounter2 = 0;
	static int first_cinko1 = 0;
	static int first_cinko2 = 0;
	static int cinko1 = 0;
	static int cinko2 = 0;
	static int points1 = 0; // toplam puanlar
	static int points2 = 0;
	static int tie = 0; // eþitlik durumu için kazanýlan para
	public static void main(String[] args) {
		FirstScreen1(); // player1 için ekran yazdýrma
		FirstScreen2(); // player2 için ekran yazdýrma
		boolean flag=false;
		while(!flag) {		
			GameScreen();	// oyunun döndüðü fonksiyonun çaðrýlmasý
			flag=Winner();
		}
	}
	
	public static void FirstScreen1 () {
		boolean flag = false;
		boolean flag2 = false;
		while(flag != true)
		{   // random harf atama iþlemleri
			char letter1 = (char)(((Math.random()*14))+65);
			char letter2 = (char)(((Math.random()*14))+65);
			char letter3 = (char)(((Math.random()*14))+65);
			char letter4 = (char)(((Math.random()*14))+65);
			
			//birbirine eþit olmama durumu
			if((letter1 != letter2)&&(letter3!=letter4)&&(letter1!=letter3)&&(letter2!=letter4)&&(letter2!=letter3)&&(letter1 != letter4))
			{
				flag = true;
				System.out.print("Player1: " + letter1 + " " + letter2 + " " + letter3 + " " + letter4 + " ");
				player1.push(letter1);
				player1.push(letter2);
				player1.push(letter3);
				player1.push(letter4);
			}
			else
			{
				flag = false;
			}
		}
		while(flag2 != true)
		{
			char letter1 = (char)(((Math.random()*12))+79);
			char letter2 = (char)(((Math.random()*12))+79);
			char letter3 = (char)(((Math.random()*12))+79);
			char letter4 = (char)(((Math.random()*12))+79);
			if((letter1 != letter2)&&(letter3!=letter4)&&(letter1!=letter3)&&(letter2!=letter4)&&(letter2!=letter3)&&(letter1!=letter4))
			{
				flag2 = true;
				System.out.print(letter1 + " " + letter2 + " " + letter3 + " " + letter4);
				player1.push(letter1);
				player1.push(letter2);
				player1.push(letter3);
				player1.push(letter4);
			}
			else
			{
				flag2 = false;
			}
		}
		System.out.print("                    ");
		System.out.print("Bag1 : ");
		for(int i = 90; i >= 65; i--) {
			char letter = (char) i;
			bag1.push(letter);
			System.out.print((char)i + " ");
		}
	}
	
	public static void FirstScreen2() {
		boolean flag3 = false;
		boolean flag4 = false;
		while(flag3 != true)
		{   // random harf atama iþlemleri
			char letter1 = (char)(((Math.random()*14))+65);
			char letter2 = (char)(((Math.random()*14))+65);
			char letter3 = (char)(((Math.random()*14))+65);
			char letter4 = (char)(((Math.random()*14))+65);
				
			//birbirine eþit olmama durumu
			if((letter1 != letter2)&&(letter3!=letter4)&&(letter1!=letter3)&&(letter2!=letter4)&&(letter2!=letter3)&&(letter1!=letter4))
			{
				flag3 = true;
				System.out.println("");
				System.out.print("Player2: " + letter1 + " " + letter2 + " " + letter3 + " " + letter4 + " ");
				player2.push(letter1);
				player2.push(letter2);
				player2.push(letter3);
				player2.push(letter4);
			}
			else
			{
				flag3 = false;
			}
		}
		while(flag4 != true){
			char letter1 = (char)(((Math.random()*12))+79);
			char letter2 = (char)(((Math.random()*12))+79);
			char letter3 = (char)(((Math.random()*12))+79);
			char letter4 = (char)(((Math.random()*12))+79);
			if((letter1 != letter2)&&(letter3!=letter4)&&(letter1!=letter3)&&(letter2!=letter4)&&(letter2!=letter3)&&(letter1!=letter4))
			{
				flag4 = true;
				System.out.print(letter1 + " " + letter2 + " " + letter3 + " " + letter4);
				player2.push(letter1);
				player2.push(letter2);
				player2.push(letter3);
				player2.push(letter4);
			}
			else
			{
				flag4 = false;
			}
		}
		System.out.print("                    ");
		System.out.print("Bag2 : ");
	}
	
	public static void GameScreen() {
		Stack player1temp = new Stack(8-playercount1); // tempe atarken kaç tane harf azalmýþsa stack boyutu ona göre azalýyor
		Stack player2temp = new Stack(8-playercount2); 
		Stack bag1temp = new Stack (26-bag1count); // bag1 için de kaç tane harf stackten çýkarýlmýþsa tempe atarken stack boyutu azalýyor
		
			selectedLetter = (char)(((Math.random() * 26))+65); // random harf atama 
			System.out.println("");
			
		 while(!(bag1.isEmpty())) { // bag1den harf çýkarma iþlemleri
				char element = (Character)bag1.peek();
				if(element != selectedLetter) {
				bag1temp.push(bag1.pop());
				}
				else if(element == selectedLetter) {
					bag2.push(bag1.pop());
					bag1temp.push(bag1.pop()); // çýkarýlan harften sonrasýný tempe atma
					bag1count++; // temp boyutunu azaltmak için sayaç artmasý
				}
			}
		while(!(bag1.isEmpty())) {
			bag1.push(bag1temp.pop());
		 }
		while(!(bag1temp.isEmpty())) {
			bag1.push(bag1temp.pop()); // bag1e geri pushlama
		 }
		 
		while(!(player1.isEmpty())) {
				char element = 0;
				if(player1.peek() != null) {
				element = (Character)player1.peek(); // en üstteki harfin random atýlan harfle eþitlik kontrolü
				}
				if(element != selectedLetter) {
				player1temp.push(player1.pop()); // eþit deðilse tempe atma
				}
				else if(element == selectedLetter) {
					player1.pop(); // eþitse harfin çýkarýlmasý ve geri kalanlarýn tempe atýlmasý
					player1temp.push(player1.pop());
					winningcounter1++; // kazanma durum kontrolü için sayaç artmasý
					playercount1++; // temp boyutunu azaltmak için sayaç artmasý
					if((element >= (char)65 && element <= (char)78)) {
						firstcounter1++; // çinko durum kontrolü için sayaç artmasý
						}
					else if((element >= (char)79 && element <= (char)90)) {
						secondcounter1++;
					}
				}
			}
		while(!(player1.isEmpty())) {
			 player1.push(player1temp.pop());
		 }
		while(!(player1temp.isEmpty())) {
			 player1.push(player1temp.pop()); // player1e harflerin geri pushlanmasý
		 }
		
		while(!(player2.isEmpty())) { // player2deki yapýlan iþlemlerin aynýsý
			char element = 0;
			if(player2.peek() != null) {
			element = (Character)player2.peek();
			}
			if(element != selectedLetter) {
			player2temp.push(player2.pop());
			}
			else if(element == selectedLetter) {
				player2.pop();
				player2temp.push(player2.pop());
				winningcounter2++; // kazanma durum kontrolü için sayaç artmasý
				playercount2++;
				if((element >= (char)65 && element <= (char)78)) {
					firstcounter2++; // çinko durum kontrolü için sayaç artmasý
					}
				else if((element >= (char)79 && element <= (char)90)) {
					secondcounter2++;
				}
			}
		}
		while(!(player2.isEmpty())) {
			 player2.push(player2temp.pop());
		 }
		while(!(player2temp.isEmpty())) {
			 player2.push(player2temp.pop());
		 }
		
		System.out.println("");  // yazdýrma
		System.out.print("Player1: ");
		printPlayer(player1);
		System.out.print("                    ");
		System.out.print("Bag1   ");
		printBag1(bag1);
		System.out.println("");
		System.out.print("Player2: ");
		printPlayer(player2);
		System.out.print("                    ");
		System.out.print("Bag2   ");
		printBag2(bag2);
		System.out.println("");
		System.out.print("selected number: " + selectedLetter);
		System.out.println("");
		}
		
	public static boolean Winner() { // oyuncularýn kazandýklarý sayaçlar durumu saðladýðý an ve sonrasý yazdýrýlýyor.
		boolean flag1 = true;
		boolean flag2 = true;
		if(firstcounter1 == 4 && secondcounter1 == 0) { // player1 için birinci çinko durum þartý
			first_cinko1 = 10;
			System.out.print("Player1 gets : " +  "$" + first_cinko1 + " (Birinci çinko)"); // yazdýrma
		}
		else if(firstcounter1 == 0 && secondcounter1 == 4) {
			first_cinko1 = 10;
			System.out.print("Player1 gets : " +  "$" + first_cinko1 + " (Birinci çinko)"); // yazdýrma
		}
		if(firstcounter2 == 4 && secondcounter2 == 0) { // player2 için birinci çinko durum þartý
			first_cinko2 = 10;
			System.out.println("");
			System.out.print("Player2 gets : " +  "$" + first_cinko2 + " (Birinci çinko)"); // yazdýrma
		}
		else if(firstcounter2 == 0 && secondcounter2 == 4) {
			first_cinko2 = 10;
			System.out.println("");
			System.out.print("Player2 gets : " +  "$" + first_cinko2 + " (Birinci çinko)"); // yazdýrma
		}
		else if(winningcounter2 != 8 && winningcounter1 == 8) { // player1 kazanma durumu
			cinko1 = 30;
			System.out.println("");
			flag1=false;
			flag2 = false;
			System.out.println("Player1 is the winner!");
		}
		else if(winningcounter1 != 8 && winningcounter2 == 8) { // player2 kazanma durumu
			cinko2 = 30;
			System.out.println("");
			flag1=false;
			flag2 = false;
			System.out.println("Player2 is the winner!");
		}
		points1 = first_cinko1 + cinko1; // kazanýlan paranýn toplanýlmasý
		points2 = first_cinko2 + cinko2;
		if(flag2 == false) {
		System.out.println("");
		System.out.print("Player1 gets: " + "$" + points1); // her oyuncunun kazandýðý paralarýn ayrý ayrý yazdýrýlmasý
		System.out.println("");
		System.out.print("Player2 gets: " + "$" + points2);
		}
		else if(winningcounter1 == winningcounter2 && winningcounter1==8 && winningcounter1!=0) { // eþitlik kontrolü
			tie = (points1+points2)/2;
			flag1=false;
			System.out.println("");
			System.out.print("Player1 gets: " + "$" + points1); // her oyuncunun kazandýðý paralarýn ayrý ayrý yazdýrýlmasý
			System.out.println("");
			System.out.print("Player2 gets: " + "$" + points2);
			System.out.println("");
			System.out.print("No one is winner. Money will be shared. All players get " + "$" + tie + ".");
		}
		return!flag1;
	}

	public static void printPlayer(Stack s) { // player için print fonksiyonu
		Stack tempstack = new Stack(8);
		while (! (s.isEmpty())) {
			System.out.print(s.peek() + " ");
			tempstack.push(s.pop());
		}
		while (! (tempstack.isEmpty())) {
			s.push(tempstack.pop());
		}
	}
	public static void printBag1(Stack s) { // bag1 için print fonksiyonu
		Stack tempstack = new Stack(26-bag1count);
		while (! (s.isEmpty())) {
			System.out.print(s.peek() + " ");
			tempstack.push(s.pop());
		}
		while (! (tempstack.isEmpty())) {
			s.push(tempstack.pop());
		}
	}
	public static void printBag2(Stack s) {
		Stack tempstack = new Stack(bag1count); // bag2 için print fonksiyonu
		while (! (s.isEmpty())) {
			System.out.print(s.peek() + " ");
			tempstack.push(s.pop());
		}
		while (! (tempstack.isEmpty())) {
			s.push(tempstack.pop());
		}
	}
}