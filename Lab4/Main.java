import java.util.ArrayList;
class Main
{
    public static void main(String[] args)
    {
        System.out.println();
        System.out.println("THE FIRST TREE:");
        Student student1 =  new Student("Kate", 19, 23236);
        Student student2 = new Student("Alex", 18, 23232);
        Student student3 = new Student("Anna", 20, 23237);
        Student student4 = new Student("Ivan", 17, 23234);
        Student student5 = new Student("Olga", 21, 23231);
        Student student6 = new Student("Petya", 21, 23233);
        Student student7 = new Student("Tanya", 21, 23235);

        Tree<Student> firstTree = new Tree<>(student1); // дерево с корнем Катя

        ArrayList<Student> students = new ArrayList<>();
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
        students.add(student6);
        students.add(student7);

        for( Student student:students)
        {
            firstTree.insert(student);
        }

        System.out.println("«Вершина-Левый-Правый»:");
        firstTree.vertexLeftRightBypass(); //обход дерева «Вершина-Левый-Правый» = прямой обход
        System.out.println();

        System.out.println("«Левый- Вершина -Правый»:");
        firstTree.leftVertexRightBypass(); // обход дерева «Левый- Вершина -Правый» = симметричный обход
        System.out.println();

        System.out.println("«Левый-Правый- Вершина»:");
        firstTree.leftRightVertexBypass(); // Обход дерева «Левый-Правый- Вершина» = постпорядковый обход
        System.out.println();

        if(firstTree.find(student1)==null)
        {
            System.out.println("There is no such student");
        } else
            System.out.println("Student: " + student1 + " has been found");
        System.out.println();

        System.out.println("Max:");
        System.out.println(firstTree.getMax(firstTree.getRoot()).value);
        System.out.println("Min:");
        System.out.println(firstTree.getMin(firstTree.getRoot()).value);
        System.out.println();

        System.out.println("After deleting the node:");
        firstTree.delete(student2);
        firstTree.vertexLeftRightBypass();

        System.out.println();
        System.out.println("THE SECOND TREE:");

        Tree<Integer> secondTree = new Tree<>(6); // дерево с корнем Катя

        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(4);
        numbers.add(2);
        numbers.add(5);
        numbers.add(8);
        numbers.add(7);
        numbers.add(9);

        for( Integer num : numbers)
        {
            secondTree.insert(num);
        }

        System.out.println("«Вершина-Левый-Правый»:");
        secondTree.vertexLeftRightBypass(); //обход дерева «Вершина-Левый-Правый» = прямой обход
        System.out.println();

    }
}
