public class Main {
    public static void main(String[] args) {

        Topic mooc = new Topic("MOOC 2019", "online kurssi", "web");
        System.out.println(mooc);

        Topic dummies = new Topic("Java for dummies", "online kurssi", "web");

        System.out.println(dummies);

        mooc.complete();
        System.out.println(mooc);
    }
}
