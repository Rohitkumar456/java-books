package ModernJavaInAction.Chapter5;

public class Student {
    int id;
    String name;
    String stream;

    @Override
    public int hashCode() {
        return this.id;
    }

    @Override
    public boolean equals(Object o){
        if(!(o instanceof Student)) return false;
        else return ((Student) o).id == this.id;
    }

    Student(int id, String name, String stream){
        this.id = id;
        this.name = name;
        this.stream = stream;

    }
}

