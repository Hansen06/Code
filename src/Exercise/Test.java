package Exercise;

public class Test {

    static class Animal{
        int height = 0;

        public void eat(){
            System.out.println("animal eat");
        }
    }

    static class Dog extends Animal{
        int height = 2;
        public void eat(){
            System.out.println("Dog");
        }
    }

    public static void main(String[] args) {

        Animal a = new Dog();
        System.out.println(a.height + ":");
        a.eat();

    }

}

