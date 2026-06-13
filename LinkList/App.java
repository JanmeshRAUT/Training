package LinkList;

public class App {
    public static void main(String[] args) {
        Navigation navigation = new Navigation();
        navigation.visit("https://www.google.com");
        navigation.visit("https://www.facebook.com");
        navigation.visit("https://www.twitter.com");
        System.out.println();
        navigation.displayHistory();
        System.out.println();
        navigation.back();
        System.out.println();
        navigation.currentPage();
        navigation.back();
        navigation.forward();
        navigation.displayHistory();
        navigation.visit("https://www.netflix.com");

        navigation.displayHistory();
        System.out.println();
        navigation.currentPage();
    }
}
