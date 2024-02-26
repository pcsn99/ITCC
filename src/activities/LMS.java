package activities;


import java.util.Scanner;

public class LMS {
	static LMS lms = new LMS();
		static Teacher teach = lms.new Teacher();
		static Student stud = lms.new Student();
		static Book book1 = lms.new Book("The Feynman Lecture on Physics", "Science/Education", "Feynman", "Addison-Wesley", "1964");
		static Book book2 = lms.new Book("Sapiens: A Brief History of Humankind", "History/Education", "Yuval Harari", "Harper", "2014");
		static Book book3 = lms.new Book("To Kill a Mockingbird", "Fiction", "Harper Lee", "J.B. Lippincott & Co.", "1960");
		static Book book4 = lms.new Book("Dune", "Science Fiction", "Frank Herbert", "Chilton Books", "1965");
		static Book book5 = lms.new Book("Dune Messiah", "Science Fiction", "Frank Herbert", "Putnam", "1969");
		static Book book6 = lms.new Book("Children of Dune", "Science Fiction", "Frank Herbert", "Putnam", "1976");
		static DVD dvd1 = lms.new DVD("Inception", "Science Fiction/Action", "Christopher Nolan", "148 minutes", "2010");
		static DVD dvd2 = lms.new DVD("The Shawnshank Redemption", "Drama", "Frank Darabont", "142 minutes","1994");
		static DVD dvd3 = lms.new DVD("The Dark Knight", "Action/Crime", "Christopher Nolan","152 minutes","2008");
		
		interface LibraryItem{
		void borrowItem();
		void returnItem();
		void displayItem();
		void displayfullInfo();
		boolean isBorrowed();
;	}

	abstract class LibraryUser{
		void borrowBook(Book book) {
			book.borrowItem();
		}

		void returnBook(Book book) {
			book.returnItem();
		}

		void borrowItem(LibraryItem item) {
			item.borrowItem();
		}
		void returnItem(LibraryItem item) {
			item.returnItem();
		}
		abstract void printItemsBorrowed();
	}
	class Student extends LibraryUser{
		void printItemsBorrowed() {
			if (book1.checkUser()==1) {
				book1.displayfullInfo();
				System.out.println("------------------------");
			}
			if (book2.checkUser()==1) {
				book2.displayfullInfo();
				System.out.println("------------------------");
			}
			if (book3.checkUser()==1) {
				book3.displayfullInfo();
				System.out.println("------------------------");
			}
			if (book4.checkUser()==1) {
				book4.displayfullInfo();
				System.out.println("------------------------");
			}
			if (book5.checkUser()==1) {
				book5.displayfullInfo();
				System.out.println("------------------------");
			}
			if (book6.checkUser()==1) {
				book6.displayfullInfo();
				System.out.println("------------------------");
			}
		}
	}

	

	class Teacher extends LibraryUser{
		void printItemsBorrowed() {
			if (book1.checkUser()==2) {
				book1.displayfullInfo();
				System.out.println("------------------------");
			}
			if (book2.checkUser()==2) {
				book2.displayfullInfo();
				System.out.println("------------------------");
			}
			if (book3.checkUser()==2) {
				book3.displayfullInfo();
				System.out.println("------------------------");
			}
			if (book4.checkUser()==2) {
				book4.displayfullInfo();
				System.out.println("------------------------");
			}
			if (book5.checkUser()==2) {
				book5.displayfullInfo();
				System.out.println("------------------------");
			}
			if (book6.checkUser()==2) {
				book6.displayfullInfo();
				System.out.println("------------------------");
			}
		}
	}
	
	class Book implements LibraryItem{
		String title;
		String genre;
		String author;
		String publisher;
		String publishingYear;
		int status = 0;
		boolean availability = true;
		int user;
		
		Book(String title, String genre, String author, String publisher, String publishingYear) {
			this.title=title;
			this.genre=genre;
			this.author=author;
			this.publisher=publisher;
			this.publishingYear=publishingYear;
		}
		
		public void displayfullInfo() {
			System.out.println("Title: "+title);
			System.out.println("Genre: "+genre);
			System.out.println("Author: "+author);
			System.out.println("Publisher: "+publisher +", "+publishingYear);
		}
		
		public void displayItem() {
			System.out.println("Title: "+title);
			System.out.println("   Author: "+author);
		}
		
		public int checkUser() {
			return user;
		}
		public void borrowItem() {
			status = 1;
		}

		public void returnItem() {
			this.user=0;
			status = 0;
		}
		
		public void borrowedBy(int user) {
			this.user=user;
			
		}

		public boolean isBorrowed() {
			if (status ==1) {
				return true;
			}
			else if(status ==0) {
				return false;
			}
			return false;
		}
	}
	
	class DVD{
		String title;
		String genre;
		String director;
		String length;
		String releaseYear;
		int status = 0;
		int user;
		
		DVD(String title, String genre, String director, String length, String releaseYear) {
			this.title=title;
			this.genre=genre;
			this.director=director;
			this.length=length;
			this.releaseYear=releaseYear;
		}
		
		public void displayfullInfo() {
			System.out.println("Title: "+title + "("+releaseYear+")");
			System.out.println("Genre: "+genre);
			System.out.println("Director: "+director);
			System.out.println("Length: "+length);
		}
		
		public void displayItem() {
			System.out.println("Title: "+title + " ("+ releaseYear +")");
			System.out.println("Genre: "+genre);
		}

		public void borrowItem() {
			status = 1;
		}

		public void returnItem() {
			this.user=0;
			status = 0;
		}
		
		public void borrowedBy(int user) {
			this.user=user;
			
		}

		public boolean isBorrowed() {
			if (status ==1) {
				return true;
			}
			else if(status ==0) {
				return false;
			}
			return false;
		}
	}

	public static void Mainmenu() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("---------------------");
		System.out.println("Select Library to be accessed");
		System.out.println("1. Student Library");
		System.out.println("2. Teacher's Library");
		System.out.println("3. Display Borrowed Items");
		try {
			int choice = scanner.nextInt();
			
			switch (choice) {
				
			case 1:
				System.out.println("-----------------------");
				studentMenu();
				break;
			
			case 2:
				System.out.println("-----------------------");
				teacherMenu();
				break;
			
			case 3:
				System.out.println("Items Borrowed by Teachers:");
				teach.printItemsBorrowed();
				System.out.println("");
				System.out.println("Items Borrowed by Students:");
				stud.printItemsBorrowed();
				Mainmenu();
				break;
			
			default:
				System.out.println("Error, please try again\n");
				Mainmenu();
			}
			
			
		}catch(java.util.InputMismatchException e) {
			System.out.println("Error, please try again\n");
			Mainmenu();
		}
	}
	
	public static void studentMenu() {
		Scanner choice = new Scanner(System.in);
		
		System.out.println("Welcome Student!");
		System.out.println("1. Borrow Book");
		System.out.println("2. Borrow DVD");
		System.out.println("3. Return Item");
		System.out.println("4. Back");

		System.out.println("Enter integer of your choice.");
		try {
			int option = choice.nextInt();
			
			switch(option){
				case 1:
					studentLib();
					break;
				case 2:
					DVDLib();
				case 3:
				case 4:
					Mainmenu();
				default:
					System.out.println("Error, please try again\n");
					studentMenu();
			}
			
		}catch(java.util.InputMismatchException e) {
			System.out.println("Error, please try again\n");
			studentMenu();
		}
	}
	
	public static void teacherMenu() {
Scanner choice = new Scanner(System.in);
		
		System.out.println("Welcome Teacher!");
		System.out.println("1. Borrow Book");
		System.out.println("2. Borrow DVD");
		System.out.println("3. Return Item");
		System.out.println("4. Back");

		System.out.println("Enter integer of your choice.");
		try {
			int option = choice.nextInt();
			
			switch(option){
				case 1:
					studentLib();
					break;
				case 2:
					DVDLib();
				case 3:
				case 4:
					Mainmenu();
				default:
					System.out.println("Error, please try again\n");
					studentMenu();
			}
			
		}catch(java.util.InputMismatchException e) {
			System.out.println("Error, please try again\n");
			studentMenu();
		}
	}
	
	public static int itemChoice() {
		Scanner choice = new Scanner(System.in);
		System.out.println("1. Borrow   2. Back");
		try {
		int option = choice.nextInt();
		switch (option){
			case 1:
				return 1;
			case 2:
				return 2;
			default:
				System.out.println("try again");
				itemChoice();
		}
		
		}catch(java.util.InputMismatchException e) {
			System.out.println("Error, please try again\n");
			itemChoice();
		}
		return 2;
	}
	
	public static void studentLib() {
		Scanner choice = new Scanner(System.in);
		System.out.println("--- STUDENT LIBRARY ---");
		
		System.out.print("1. ");
		book1.displayItem();
		System.out.print("2. ");
		book2.displayItem();
		System.out.print("3. ");
		book3.displayItem();
		System.out.print("4. ");
		book4.displayItem();
		System.out.print("5. ");
		book5.displayItem();
		System.out.print("6. ");
		book6.displayItem();
		System.out.println("7. Back");
		System.out.println("");
		System.out.println("   Enter Book integer: ");
		int option = choice.nextInt();
		
	try {
		Scanner ignore = new Scanner(System.in);
		
		switch(option) {
		case 1:
			book1.displayfullInfo();
			if (book1.isBorrowed()==false) {
				int x = itemChoice();
				if (x == 1) {
					book1.borrowItem();
					book1.borrowedBy(1);
					System.out.println("Book borrowed successfully");
					studentLib();
				}
				
				else if (x==2) {
					studentLib();
				}	
			}
			else if(book1.isBorrowed()==true) {
				System.out.println("** Not Available** ");
				System.out.println("");
				System.out.println("1. Back");
				ignore.nextLine();
				studentLib();
				
			}
			break;
		case 2:
			book2.displayfullInfo();
			if (book2.isBorrowed()==false) {
				int x = itemChoice();
				if (x == 1) {
					book2.borrowItem();
					book2.borrowedBy(1);
					System.out.println("Book borrowed successfully");
					studentLib();
				}
				
				else if (x==2) {
					studentLib();
				}	
			}
			else if(book2.isBorrowed()==true) {
				System.out.println("** Not Available** ");
				System.out.println("");
				System.out.println("1. Back");
				ignore.nextLine();
				studentLib();
				
			}
			break;
		case 3:
			book3.displayfullInfo();
			if (book3.isBorrowed()==false) {
				int x = itemChoice();
				if (x == 1) {
					book3.borrowItem();
					book3.borrowedBy(1);
					System.out.println("Book borrowed successfully");
					studentLib();
				}
				
				else if (x==2) {
					studentLib();
				}	
			}
			else if(book3.isBorrowed()==true) {
				System.out.println("** Not Available** ");
				System.out.println("");
				System.out.println("1. Back");
				ignore.nextLine();
				studentLib();
				
			}
			break;
		case 4:
			book4.displayfullInfo();
			if (book4.isBorrowed()==false) {
				int x = itemChoice();
				if (x == 1) {
					book4.borrowItem();
					book4.borrowedBy(1);
					System.out.println("Book borrowed successfully");
					studentLib();
				}
				
				else if (x==2) {
					studentLib();
				}	
			}
			else if(book4.isBorrowed()==true) {
				System.out.println("** Not Available** ");
				System.out.println("");
				System.out.println("1. Back");
				ignore.nextLine();
				studentLib();
				
			}
			break;
		case 5:
			book5.displayfullInfo();
			if (book5.isBorrowed()==false) {
				int x = itemChoice();
				if (x == 1) {
					book5.borrowItem();
					book5.borrowedBy(1);
					System.out.println("Book borrowed successfully");
					studentLib();
				}
				
				else if (x==2) {
					studentLib();
				}	
			}
			else if(book5.isBorrowed()==true) {
				System.out.println("** Not Available** ");
				System.out.println("");
				System.out.println("1. Back");
				ignore.nextLine();
				studentLib();
				
			}
			break;
		case 6:
			book6.displayfullInfo();
			if (book6.isBorrowed()==false) {
				int x = itemChoice();
				if (x == 1) {
					book6.borrowItem();
					book6.borrowedBy(1);
					System.out.println("Book borrowed successfully");
					studentLib();
				}
				
				else if (x==2) {
					studentLib();
				}	
			}
			else if(book6.isBorrowed()==true) {
				System.out.println("** Not Available** ");
				System.out.println("");
				System.out.println("1. Back");
				ignore.nextLine();
				studentLib();
				
			}
			break;
		
		case 7:
			studentMenu();
			break;
		default:
			
		}
		}catch(java.util.InputMismatchException e) {
	System.out.println("Error, please try again\n");
	studentLib();
}		
		
			
		
		
	}
	
	public static void teacherLib() {
		Scanner choice = new Scanner(System.in);
		System.out.println("--- TEACHER LIBRARY ---");
		//was planning to add more books for teacher but ran out of time
		
		System.out.print("1. ");
		book1.displayItem();
		System.out.print("2. ");
		book2.displayItem();
		System.out.print("3. ");
		book3.displayItem();
		System.out.print("4. ");
		book4.displayItem();
		System.out.print("5. ");
		book5.displayItem();
		System.out.print("6. ");
		book6.displayItem();
		System.out.println("7. Back");
		System.out.println("");
		System.out.println("   Enter Book integer: ");
		int option = choice.nextInt();
		
	try {
		Scanner ignore = new Scanner(System.in);
		
		switch(option) {
		case 1:
			book1.displayfullInfo();
			if (book1.isBorrowed()==false) {
				int x = itemChoice();
				if (x == 1) {
					book1.borrowItem();
					book1.borrowedBy(2);
					System.out.println("Book borrowed successfully");
					teacherLib();
				}
				
				else if (x==2) {
					teacherLib();
				}	
			}
			else if(book1.isBorrowed()==true) {
				System.out.println("** Not Available** ");
				System.out.println("");
				System.out.println("1. Back");
				ignore.nextLine();
				teacherLib();
				
			}
			break;
		case 2:
			book2.displayfullInfo();
			if (book2.isBorrowed()==false) {
				int x = itemChoice();
				if (x == 1) {
					
					book2.borrowItem();
					book2.borrowedBy(2);
					System.out.println("Book borrowed successfully");
					teacherLib();
				}
				
				else if (x==2) {
					teacherLib();
				}	
			}
			else if(book2.isBorrowed()==true) {
				System.out.println("** Not Available** ");
				System.out.println("");
				System.out.println("1. Back");
				ignore.nextLine();
				teacherLib();
				
			}
			break;
		case 3:
			book3.displayfullInfo();
			if (book3.isBorrowed()==false) {
				int x = itemChoice();
				if (x == 1) {
					book3.borrowItem();
					book3.borrowedBy(2);
					System.out.println("Book borrowed successfully");
					teacherLib();
				}
				
				else if (x==2) {
					teacherLib();
				}	
			}
			else if(book3.isBorrowed()==true) {
				System.out.println("** Not Available** ");
				System.out.println("");
				System.out.println("1. Back");
				ignore.nextLine();
				teacherLib();
				
			}
			break;
		case 4:
			book4.displayfullInfo();
			if (book4.isBorrowed()==false) {
				int x = itemChoice();
				if (x == 1) {
					book4.borrowItem();
					book4.borrowedBy(2);
					System.out.println("Book borrowed successfully");
					teacherLib();
				}
				
				else if (x==2) {
					teacherLib();
				}	
			}
			else if(book4.isBorrowed()==true) {
				System.out.println("** Not Available** ");
				System.out.println("");
				System.out.println("1. Back");
				ignore.nextLine();
				teacherLib();
				
			}
			break;
		case 5:
			book5.displayfullInfo();
			if (book5.isBorrowed()==false) {
				int x = itemChoice();
				if (x == 1) {
					book5.borrowItem();
					book5.borrowedBy(2);
					System.out.println("Book borrowed successfully");
					teacherLib();
				}
				
				else if (x==2) {
					teacherLib();
				}	
			}
			else if(book5.isBorrowed()==true) {
				System.out.println("** Not Available** ");
				System.out.println("");
				System.out.println("1. Back");
				ignore.nextLine();
				teacherLib();
				
			}
			break;
		case 6:
			book6.displayfullInfo();
			if (book6.isBorrowed()==false) {
				int x = itemChoice();
				if (x == 1) {
					book6.borrowItem();
					book6.borrowedBy(2);
					System.out.println("Book borrowed successfully");
					teacherLib();
				}
				
				else if (x==2) {
					teacherLib();
				}	
			}
			else if(book6.isBorrowed()==true) {
				System.out.println("** Not Available** ");
				System.out.println("");
				System.out.println("1. Back");
				ignore.nextLine();
				teacherLib();
				
			}
			break;
		
		case 7:
			teacherMenu();
			break;
		default:
			
		}
		}catch(java.util.InputMismatchException e) {
	System.out.println("Error, please try again\n");
	teacherLib();
}		
		
			
		
		
	}
	
	public static void DVDLib() {

		Scanner choice = new Scanner(System.in);
		System.out.println("--- DVD Library ---");
		System.out.print("1. ");
		dvd1.displayItem();
		System.out.print("2. ");
		dvd2.displayItem();
		System.out.print("3. ");
		dvd3.displayItem();
		System.out.println("/n  Enter integer of choice");
		int option = choice.nextInt();
		try {
			Scanner ignore = new Scanner(System.in);
			
			switch(option) {
			case 1:
				dvd1.displayfullInfo();
				if (dvd1.isBorrowed()==false) {
					int x = itemChoice();
					if (x == 1) {
						dvd1.borrowItem();
						System.out.println("DVD borrowed successfully");
						DVDLib();
					}
					
					else if (x==2) {
						DVDLib();
					}	
				}
				else if(dvd1.isBorrowed()==true) {
					System.out.println("** Not Available** ");
					System.out.println("");
					System.out.println("1. Back");
					ignore.nextLine();
					DVDLib();
					
				}
				break;
			case 2:
				dvd2.displayfullInfo();
				if (dvd2.isBorrowed()==false) {
					int x = itemChoice();
					if (x == 1) {
						dvd2.borrowItem();
						System.out.println("DVD borrowed successfully");
						DVDLib();
					}
					
					else if (x==2) {
						DVDLib();
					}	
				}
				else if(dvd2.isBorrowed()==true) {
					System.out.println("** Not Available** ");
					System.out.println("");
					System.out.println("1. Back");
					ignore.nextLine();
					DVDLib();
					
				}
				break;
			case 3:
				dvd3.displayfullInfo();
				if (dvd3.isBorrowed()==false) {
					int x = itemChoice();
					if (x == 1) {
						dvd3.borrowItem();
						System.out.println("DVD borrowed successfully");
						DVDLib();
					}
					
					else if (x==2) {
						DVDLib();;
					}	
				}
				else if(dvd3.isBorrowed()==true) {
					System.out.println("** Not Available** ");
					System.out.println("");
					System.out.println("1. Back");
					ignore.nextLine();
					DVDLib();
					
				}
				break;
			
			case 7:
				studentMenu();
				break;
			default:
				
			}
			}catch(java.util.InputMismatchException e) {
		System.out.println("Error, please try again\n");
		studentLib();
	}
	}

	public static void returnItem() {
		Scanner option = new Scanner(System.in);
		
		System.out.println("--- Borrowed Items ---");
		if(book1.isBorrowed()==true) {
			System.out.print("1. ");
			book1.displayfullInfo();
		}
		if(book2.isBorrowed()==true) {
			System.out.print("2. ");
			book2.displayfullInfo();
		}
		if(book3.isBorrowed()==true) {
			System.out.print("3. ");
			book3.displayfullInfo();
		}
		if(book4.isBorrowed()==true) {
			System.out.print("4. ");
			book4.displayfullInfo();
		}
		if(book5.isBorrowed()==true) {
			System.out.print("5. ");
			book5.displayfullInfo();
		}
		if(book6.isBorrowed()==true) {
			System.out.print("6. ");
			book6.displayfullInfo();
		}
		if(dvd1.isBorrowed()==true) {
			System.out.print("7. ");
			dvd1.displayfullInfo();
		}
		if(dvd2.isBorrowed()==true) {
			System.out.print("8. ");
			dvd2.displayfullInfo();
		}
		if(dvd3.isBorrowed()==true) {
			System.out.print("9. ");
			dvd3.displayfullInfo();
		}
		System.out.println("/n Enter integer of Item you want to return");
		int choice = option.nextInt();
		
		switch(choice) {
		case 1:
			book1.returnItem();
			System.out.println("Return Complete.");
			Mainmenu();
		case 2:
			book2.returnItem();
			System.out.println("Return Complete.");
			Mainmenu();
		case 3:
			book3.returnItem();
			System.out.println("Return Complete.");
			Mainmenu();
		case 4:
			book4.returnItem();
			System.out.println("Return Complete.");
			Mainmenu();
		case 5:
			book5.returnItem();
			System.out.println("Return Complete.");
			Mainmenu();
		case 6:
			book6.returnItem();
			System.out.println("Return Complete.");
			Mainmenu();
		case 7:
			dvd1.returnItem();
			System.out.println("Return Complete.");
			Mainmenu();
		case 8:
			dvd2.returnItem();
			System.out.println("Return Complete.");
			Mainmenu();
		case 9:
			dvd3.returnItem();
			System.out.println("Return Complete.");
			Mainmenu();
		default:
			System.out.println("Error. Try Again.");
			returnItem();
		}
	}
	
	public static void main(String args[]) {

		Scanner scanner = new Scanner(System.in);
		Mainmenu();
		System.out.println("");

	}

}

