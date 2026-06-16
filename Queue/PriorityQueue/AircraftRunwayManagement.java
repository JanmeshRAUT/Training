package Queue.PriorityQueue;

import java.util.PriorityQueue;

public class AircraftRunwayManagement {
    PriorityQueue<Aircraft> runwayQueue=new PriorityQueue<>();


    public void addAircraft(Aircraft aircraft){
        runwayQueue.add(aircraft);
    }

    public void addMultipleAircrafts(Aircraft[] aircrafts){
        for (Aircraft aircraft : aircrafts) {
            addAircraft(aircraft);
        }
    }

    public void allocateRunway(){
        if (!runwayQueue.isEmpty()){
            Aircraft nextAircraft=runwayQueue.poll();
            System.out.println("Allocating runway to: "+nextAircraft);
        }else {
            System.out.println("No aircrafts waiting for runway.");
        }
    }
    public void viewNextAircraft(){
        if (!runwayQueue.isEmpty()){
            Aircraft nextAircraft=runwayQueue.peek();
            System.out.println("Next aircraft for runway allocation: "+nextAircraft);
        }else {
            System.out.println("No aircrafts waiting for runway.");
        }
    }

    public void displayRunwayQueue(){
        if (runwayQueue.isEmpty()){
            System.out.println("No aircrafts waiting for runway.");
        }else {
            System.out.println("Current runway queue:");
            for (Aircraft aircraft : runwayQueue) {
                System.out.println(aircraft);
            }
        }
    }


    public void totalAircraftsWaiting(){
        System.out.println("Total aircrafts waiting for runway: "+runwayQueue.size());
    }

    public void resetRunwayQueue(){
        runwayQueue.clear();
        System.out.println("Runway queue cleared.");
    }

    

}