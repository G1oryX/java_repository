import entity.Person;
public class Main {

    public static void main(String[] args) {

        System.out.println("Hello Worldghg!");
        Dao dao=new Dao(Person.class);

        dao.Init();
    }

}
