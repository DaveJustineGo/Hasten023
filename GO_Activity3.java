interface LibraryItem {
    void borrowItem();
    void returnItem();
    boolean isBorrowed();
}

class Book implements LibraryItem {
    private String title;
    private String author;
    private int publicationYear;
    private boolean borrowed;

    public Book(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.borrowed = false;
    }

    @Override
    public void borrowItem() {
        if (!borrowed) {
            borrowed = true;
            System.out.println("Book \"" + title + "\" has been borrowed.");
        } else {
            System.out.println("Book \"" + title + "\" is already borrowed.");
        }
    }

    @Override
    public void returnItem() {
        if (borrowed) {
            borrowed = false;
            System.out.println("Book \"" + title + "\" has been returned.");
        } else {
            System.out.println("Book \"" + title + "\" was not borrowed.");
        }
    }

    @Override
    public boolean isBorrowed() {
        return borrowed;
    }
}

class DVD implements LibraryItem {
    private String title;
    private String director;
    private int runningTime;
    private boolean borrowed;

    public DVD(String title, String director, int runningTime) {
        this.title = title;
        this.director = director;
        this.runningTime = runningTime;
        this.borrowed = false;
    }

    @Override
    public void borrowItem() {
        if (!borrowed) {
            borrowed = true;
            System.out.println("DVD \"" + title + "\" has been borrowed.");
        } else {
            System.out.println("DVD \"" + title + "\" is already borrowed.");
        }
    }

    @Override
    public void returnItem() {
        if (borrowed) {
            borrowed = false;
            System.out.println("DVD \"" + title + "\" has been returned.");
        } else {
            System.out.println("DVD \"" + title + "\" was not borrowed.");
        }
    }

    @Override
    public boolean isBorrowed() {
        return borrowed;
    }
}

abstract class LibraryUser {
    abstract void borrowItem(LibraryItem item);
    abstract void returnItem(LibraryItem item);
    abstract void printItemsBorrowed();
}

class Student extends LibraryUser {
    private LibraryItem[] borrowedItems = new LibraryItem[5]; 

    @Override
    void borrowItem(LibraryItem item) {
        for (int i = 0; i < borrowedItems.length; i++) {
            if (borrowedItems[i] == null) {
                borrowedItems[i] = item;
                item.borrowItem();
                return;
            }
        }
        System.out.println("Cannot borrow more items. Maximum limit reached.");
    }

    @Override
    void returnItem(LibraryItem item) {
        for (int i = 0; i < borrowedItems.length; i++) {
            if (borrowedItems[i] == item) {
                borrowedItems[i] = null;
                item.returnItem();
                return;
            }
        }
        System.out.println("Item not found in borrowed list.");
    }

    @Override
    void printItemsBorrowed() {
        System.out.println("Items borrowed by Student:");
        for (LibraryItem item : borrowedItems) {
            if (item != null) {
                System.out.println("- " + item.toString());
            }
        }
    }
}

class Teacher extends LibraryUser {
    private LibraryItem[] borrowedItems = new LibraryItem[10]; 

    @Override
    void borrowItem(LibraryItem item) {
        for (int i = 0; i < borrowedItems.length; i++) {
            if (borrowedItems[i] == null) {
                borrowedItems[i] = item;
                item.borrowItem();
                return;
            }
        }
        System.out.println("Cannot borrow more items. Maximum limit reached.");
    }

    @Override
    void returnItem(LibraryItem item) {
        for (int i = 0; i < borrowedItems.length; i++) {
            if (borrowedItems[i] == item) {
                borrowedItems[i] = null;
                item.returnItem();
                return;
            }
        }
        System.out.println("Item not found in borrowed list.");
    }

    @Override
    void printItemsBorrowed() {
        System.out.println("Items borrowed by Teacher:");
        for (LibraryItem item : borrowedItems) {
            if (item != null) {
                System.out.println("- " + item.toString());
            }
        }
    }
}

public class GO_Activity3 {
    public static void main(String[] args) {
        
        Book book1 = new Book("LoveStory of JERJER", "JC Ubalde", 1951);
        Book book2 = new Book("Brett and Nat", "Karlos Ubalde", 1960);
        DVD dvd1 = new DVD("Avengers", "Pio Carbonara", 148);
        DVD dvd2 = new DVD("SpiderMan", "Nick Van Longganisa", 142);

        
        Student student = new Student();
        Teacher teacher = new Teacher();

        
        student.borrowItem(book1);
        student.borrowItem(dvd1);
        teacher.borrowItem(book2);
        teacher.borrowItem(dvd2);
        
       
        student.printItemsBorrowed();
        teacher.printItemsBorrowed();

       
        student.returnItem(book1);
        teacher.returnItem(dvd2);

        
        student.printItemsBorrowed();
        teacher.printItemsBorrowed();
    }
}

