
public class App{
    public static void main(String[] args) throws Exception{
        //new instance
        Cell A = new Cell();
        A.name = "Iphone";
        A.OS = "IOS";
        A.storage = 256;
        A.size = 6.1f;

        System.out.format("name: %s - size: %.2f - storage: %d - OS: %s \n", A.name, A.size, A.storage, A.OS);
    }
}
public class Cell {
    String name;
    String OS;
    int storage;
    float size;
}
