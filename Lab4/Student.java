class Student implements Comparable<Student> // сравнивает студентов
{
    String name;
    Integer age;
    Integer id;
    Student(String name,Integer age,Integer id)
    {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    Integer getId()
    {
        return id;
    }

    public String toString()
    {
        return "Name - " + name + ", Age - " + age.toString() + ", ID - " + id.toString();
    }

    public int compareTo(Student student)// буду сравнивать по id
    {
        return id.compareTo(student.getId());
    }

}