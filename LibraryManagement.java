import java.util.*;

public class LibraryManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Book Name: ");
        String book = sc.nextLine();

        System.out.print("Enter Author: ");
        String author = sc.nextLine();

        System.out.print("Enter Member Name: ");
        String member = sc.nextLine();

        System.out.print("Enter Number of Days: ");
        int days = sc.nextInt();

        int fine = days > 14 ? (days - 14) * 5 : 0;

        System.out.println("\n--- LIBRARY RECORD ---");
        System.out.println("Book ID: " + id);
        System.out.println("Book: " + book);
        System.out.println("Author: " + author);
        System.out.println("Member: " + member);
        System.out.println("Fine: Rs." + fine);
    }
}
