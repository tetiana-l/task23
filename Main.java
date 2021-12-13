package Task23;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        Book book1 = new Book("Harry Potter", "J. K. Rowling", 223, 1997);

        String newXML = XMLConverter.convertToXML(book1);
        System.out.println(newXML);

    }
}

