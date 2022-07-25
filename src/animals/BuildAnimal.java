package animals;
import animals.birds.Duck;
import animals.pet.Cat;
import animals.pet.Dog;
import data.Commands;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BuildAnimal {

    public static void main(String[] args) throws IOException {

        ArrayList<Animal> animalList = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));



        while(true) {
            System.out.println("Введите команду add/list/exit: ");

            String str = reader.readLine().toUpperCase().trim();
            try {
                Commands c = Commands.valueOf(str);

                switch (c) {
                    case ADD:
                        System.out.println("Введите тип животного которого будем создавать: ");
                        String typeAnimal = reader.readLine();

                        if(typeAnimal.equals("cat")){
                            Animal cat = new Cat();
                            animalCreate(cat,reader,animalList);
                        }else if(typeAnimal.equals("dog")){
                            Animal dog = new Dog();
                            animalCreate(dog,reader,animalList);
                        }else if(typeAnimal.equals("duck")){
                            Animal duck = new Duck();
                            animalCreate(duck,reader,animalList);
                        }
                        break;

                    case LIST:
                        for (Animal a:animalList) {
                            System.out.println(a.toString());;
                        }
                        break;

                    case EXIT:
                        System.out.println("выход");
                        System.exit(0);
                }

            } catch (IllegalArgumentException e){
                System.out.println("Введена неверная команда, возможны только add/list/exit, попробуйте снова");
            }
        }
    }

    public static void animalCreate(Animal animal, BufferedReader reader, ArrayList<Animal> animalList) throws IOException {
        System.out.println("Введите имя животного: ");
        animal.setName(reader.readLine());

        boolean iterAge = true;
        boolean iterWeight = true;

        while (iterAge) {
            try {
                System.out.println("Введите возраст животного:");
                animal.setAge(Integer.parseInt(reader.readLine()));
                iterAge = false;

            } catch (NumberFormatException e) {
                System.out.println("Введен некорректный возраст животного, попробуйте снова!");
                iterAge = true;
            }
        }

        System.out.println("Введите цвет животного:");
        animal.setColor(reader.readLine());

        while (iterWeight) {
            try {
            System.out.println("Введите вес животного:");
            animal.setWeight(Integer.parseInt(reader.readLine()));
                iterWeight = false;
            } catch (NumberFormatException e) {
                System.out.println("Введен некорректный вес животного, попробуйте снова!");
                iterWeight = true;
            }
        }

        animalList.add(animal);
        animal.say();
    }
}
