public class Start {
    public static void main(String[] args) {
        Person p=new Person();

        Class<?>person=p.getClass();
        myInfo infor=person.getAnnotation(myInfo.class);
        System.out.println(infor.age()+" "+ infor.name()+" "+infor.city());

    }
}
