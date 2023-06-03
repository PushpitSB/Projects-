Group CU Project Two Proposal

GROUP: CU
TA NAME: Rahul
FLIPGRID: https://flip.com/f39e5f30
TA EMAIL: rahul.choudhary@wisc.edu


x
Name
Email
Team
P1 Role
P2 Role
P3 Role
Skanda Vyas Srinivasan
svsrinivasa2@wisc.edu
Red
BD
DW
FD
Yashman Singh
ypsingh@wisc.edu
Red
FD
AE
BD
Samir Simha
ssimha2@wisc.edu
Red
FD
BD
AE
Zain Siddiqui
zsiddiqui6@wisc.edu
Red
BD
FD
DW
Colin Shaw
cjshaw3@wisc.edu
Blue
BD
DW
FD
Chaitanya Sharma
csharma4@wisc.edu
Blue
FD
AE
BD
Pushpit Singh
psingh76@wisc.edu
Blue
FD
BD
AE
Aditi Shah
aashah25@wisc.edu
Blue
BD
FD
DW



Project Title: Book Store Manager
Brief Project Description:

This project is a Red-Black Tree implementation tailored to a bookstore management interface. Its purpose is to assist bookstore managers in efficiently organizing their inventory. The dataset utilized for this project is the 7kLibrary dataset, which provides comprehensive information on various books, including their titles, authors, prices, and other characteristics. With the Red-Black Tree's self-balancing capability, the application ensures quick and efficient insertion, deletion, search, and update operations to manage the bookstore's inventory. Overall, this project offers an effective solution for bookstore managers looking to streamline their inventory management processes.
Representative Tasks Performed Using this Application:
First get information about the book called “Sharp Objects”. Then, sell that book, and use book information to show that the quantity has changed”. (demo by Data Wrangler)
Search for a book’s information titled “Thirst”, and note its genre. Next, search for books marked with the genre “Fiction” to show that “Thirst” is present in that list.(Demo by Algorithm Engineer)
Search for the information of a book called “CS400 team CU”, to show that it does not exist in the bookstore, next buy a book with the same title with any values for the other parameters. Search for the book again using get information to show that it has indeed been added to the bookstore(Demo by Algorithm Engineer

Initially check the account’s balance.Look up and then Sell 2 copies of the book “Slow States of Collapse: Poems”. Then, get the book's information to show that the quantity of that book has changed. Then check the balance again to show that the bookstore’s balance has changed. (demo by Backend Developer)
Check the balance of the account. Look up and then buy 5 copies of a book with the title “Behind Closed Doors”, and find the book again to show that the number of books have been changed. Then check the balance again to show that it has changed. (demo by Frontend Developer)


Data Wrangler (DW) Role: Skanda Vyas Srinivasan, Colin Shaw
The data wrangler uses a dataset to get information about the books to not only store them into objects, but to also load them from a file
Data Description:
The data wrangler makes use of a modified version of a free dataset from kaggle. The modified version contains the ISBN,Book Title, Book Author/Authors, Year of Publication, and the Categories with a delimiter separating these five fields. The file used is of type *.csv
Development Responsibilities:
The data wrangler’s job is to write code to define a single book object, and also to code an entire file of such objects.
The java interface for these classes to follow are : 


/**
 * This interface simulates a given book
 * @author Skanda Vyas
 *
 */
public interface BookInterface{
	//public Book(String title, String genre,String rating,double price)

	
/**
	 * Title of the book
	 * @return title of the book
	 */
	public String getTitle();
	
	/**
	 *  Returns the genre of the book
	 * @return genre of the book
	 */-
	public String getGenre();
	/**
	 * Returns the price of the book
	 * @return price of the book
	 */
	public double getPrice() ;
	/**
	 * Returns the book's rating on a scale of five
	 * @return the book's rating
	 */
	public String getRating() ;
	

	
	}



public interface BookReaderInterface {
   // public BookReaderInterface();
   public 	List<BookInterface> readBookFromFile(String filename) throws FileNotFoundException; // Scans data from a file and reads it as an object, giving it the proper attributes 
}
Presentation Responsibilities:
First get information about the book called “Sharp Objects”. Then, sell that book, and use book information to show that the quantity has changed

Algorithm Engineer (AE) Role: Yashman Singh, Chaitanya Sharma
The algorithm engineer extends the Sorted Collections interface  provided in the write up for the project. The job of an algorithm engineer is to develop an efficient system that can handle various operations and make interface classes.
Capabilities Added to Required Data Structure:
The capabilities include adding and removing books from the tree. Checking if a certain book exists in the store or not. Making a duplicate node interface for the backend to implement.
Development Responsibilities:
The listed interface is provided by the AE. Apart from that there will also be a BManager. java class which will contain the main method for the project.

import java.util.ArrayList;

public interface BooksTreeInterfaceAE<T extends Comparable<T>>{
   public boolean insert(T data) throws NullPointerException, IllegalArgumentException;

   public boolean remove(T data) throws NullPointerException, IllegalArgumentException;

   public boolean contains(T data);

   public int size();

   public boolean isEmpty();
   public String toString();

   public ArrayList toList();
}

Presentation Responsibilities:

Search for a book’s information titled “Thirst”, and note its genre. Next, search for books marked with the genre “Fiction” to show that “Thirst” is present in that list.
Search for the information of a book called “CS400 team CU”, to show that it does not exist in the bookstore, next buy a book with the same title with any values for the other parameters. Search for the book again using get information to show that it has indeed been added to the bookstore


Backend Developer (BD) Role: Samir Simha, Pushpit Singh
The backend developer writes code that makes use of Red Black Trees to store the information about the various books in the library. 
Backend Functionality Description:
   The Backend Developer is responsible for making sure all the inputs received from frontend is responded properly by using functions such as add and remove made by AE. 
Development Responsibilities:
Load Data that is returned by the DW
Adds book to RBT
Creates buyer order involving multiple book order 
Find books by title
Performs a Binary Search to go through the stock of available books and return stock information.
Performs Binary Search to find books within a given genre.
Performs Binary Search to find books with a particular title.
Returns information of a particular, given book.
Returns balance of store

public interface BookstoreBackendInterface {
 // public BookstoreBackendInterface(RBT<BookInterface>, BookReaderInterface);

 public int loadBooks(String filename) throws FileNotFoundException;
 public void addBooks(List<BookInterface> toAdd);
 public void removeBook(List<BookInterface> toRemove);
 public String checkStock();
 public String findBooksByGenre(String genre);
 public String getBookInformation(String title) throws FileNotFoundException;
 public double getBalance();
 public boolean isBookInStock(String title);
 public int getBookAmount(String title);
}

Presentation Responsibilities:
Initially check the account’s balance.Look up and then Sell 2 copies of the book “Slow States of Collapse: Poems”. Then, get the book's information to show that the quantity of that book has changed. Then check the balance again to show that the bookstore’s balance has changed.

Frontend Developer (FD) Role: Zain Siddiqui, Aditi Shah

The frontend developer is responsible for creating a text-based user interface where the user can access, buy and sell books. The user can also check the stock by genre, or book title. Users can also check the current balance of after buying or selling books.
Log of a Sample Execution of the App:
(Note: the red text is the user’s input)





Development Responsibilities:
public interface BookstoreFrontendInterface {
    //public BookstoreFrontendInterfaceXX(Scanner userInput, LibraryBackendInterface backend);
    public void runCommandLoop();
    public char mainMenuPrompt();
    public void loadBooksCommand();
    public void buyBooks();
    public void sellBooks();
    public void checkStockByAll();
    public void checkStockByGenre();
    Public void getBookInformation();
    Public void getBalance(); 
}
Presentation Responsibilities:
Check the balance of the account. Look up and then buy 5 copies of a book with the title “Behind Closed Doors”, and find the book again to show that the number of books have been changed. Then check the balance again to show that it has changed.

Scope and Signatures: 
Ideas for Scoping Up:
Add implementation to save and load current state of the bookstore.
Add/Search/Remove using the ISBN of the books.
Find books by price range
Ideas for Scoping Down:
Limit checking stock options to one method (either checkStockbyGenre or checkStockByAll)
Removing the money system from the project(removing book’s price,and etc.)
Outside Libraries and Other Tools:

We are not using any outside libraries other than the standard java library. We are however using this dataset from kaggle. The data wrangler is formatting this data as described previously.


Team Signatures: 
Name
Email
Team
Type Name As Signature
Skanda Vyas Srinivasan
svsrinivasa2@wisc.edu
Red
Skanda Vyas Srinivasan
Yashman Singh
ypsingh@wisc.edu
Red
Yashman Singh
Samir Simha
ssimha2@wisc.edu
Red
Samir Simha
Zain Siddiqui
zsiddiqui6@wisc.edu
Red
Zain Siddiqui
Colin Shaw
cjshaw3@wisc.edu
Blue
Colin Shaw
Chaitanya Sharma
csharma4@wisc.edu
Blue
Chaitanya Sharma
Pushpit Singh
psingh76@wisc.edu
Blue
Pushpit Singh
Aditi Shah
aashah25@wisc.edu
Blue
Aditi Shah



TA Feedback:
<During grading, your TA will share any questions or concerns that they have about this group proposal here.>
Team Response:
<After grading, if the TA Feedback above describes and required clarifications or changes to this proposal, please discuss as a group before acknowledging and addressing those concerns here.>

Proposal Amendments:
If your group needs to make any changes to what is described above after the proposal deadline, then 1) make sure everyone in your group agrees with those changes, 2) describe those changes in the first empty row below, and then 3) notify your group’s TA about those changes and whey are being made.  Your TA will then review your request and indicate whether they approve of such changes by adding their initials to the end of that amendment’s row below.

Number
Description
TA Approval
1
The dataset is being changed to this dataset

The Book interface needs to be changed due to the change in the dataset, which leads to a change in the data fields of the class.
These changes will not really change the rest of the implementations in this project and only serves to use another dataset instead of the given one in order to make
New Interface for Book:
/**
* This class simulates a given book
* @author skand
*
*/
public interface BookInterface{
	 // public BookInterface(String title, String author, int ISBN, int year, String genre,int price);
	/**
	 * Title of the book
	 * @return title of the book
	 */
	public String getTitle();
	
	/**
	 * Returns the genre of the book
	 * @return genre of the book
	 */
	public String getGenre();
	/**
	 * Returns the price of the book
	 * @return price of the book
	 */
	public double getPrice() ;
	/**
	 * Returns the number of books available
	 * @return the number of books available
	 */
	public int getQuantity();
	/**
	 * Returns the book's rating on a scale of five
	 * @return the book's rating
	 */
	public String getRating() ;
	
	}




Info: This is being done as there were some problems with the dataset that I found earlier, using this new dataset will be optimum for this project.
R.C.
2
Changed the interface slightly to accommodate other features.
import java.util.ArrayList;

public interface BooksTreeInterfaceAE<T extends Comparable<T>>{
   public boolean insert(T data) throws NullPointerException, IllegalArgumentException;

   public boolean remove(T data) throws NullPointerException, IllegalArgumentException;

   public boolean contains(T data);

   public int size();

   public boolean isEmpty();
   public String toString();

   public ArrayList toList();
}




3




4




5




6




7




8






