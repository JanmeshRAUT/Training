package LinkList;

import java.util.LinkedList;
import java.util.List;

public class Navigation {
    List<Tab> historyList= new LinkedList<>();
    List<Tab> forwardList = new LinkedList<>();

    public void visit(String url, String title) {
        Tab tab = new Tab(url, title);
        historyList.add(tab);
        forwardList.clear();
    }

    public void back(){
        if(historyList.size()<=1){
            System.out.println("No previous page in history.");
            return;
        } else {
            Tab currentTab = historyList.removeLast();
            forwardList.addLast(currentTab);
            System.out.println("Navigated back to: " + historyList.getLast().getTitle());
        }
    }
    public void forward(){
        if(forwardList.isEmpty()){
            System.out.println("No forward page available.");
            return;
        } else {
            Tab nextTab = forwardList.removeLast();
            historyList.addLast(nextTab);
            System.out.println("Navigated forward to: " + historyList.getLast().getTitle());
        }
    }

    public void displayHistory() {
        
        if (historyList.isEmpty()) {
            System.out.println("No browsing history available.");
        } else {
            System.out.println("Browsing History:");
            for (Tab tab : historyList) {
                System.out.println(tab.getTitle() + " - " + tab.getUrl());
            }
        }
    }
    public void currentPage(){
        if(historyList.isEmpty()){
            System.out.println("No current page available.");
        } else {
            System.out.println("Current Page: " + historyList.getLast().getTitle());
        }
    }

    
    
}