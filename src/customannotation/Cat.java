package customannotation;

@VeryImportant
public class Cat {

    private  String name;

    public Cat(String name) {
        this.name = name;
    }

    @RunImmediately(times = 4)
    public  void mewaw() {
        System.out.println("MEAU");
    }

    @ImportantString
    public String getName() {
        return name;
    }
}
