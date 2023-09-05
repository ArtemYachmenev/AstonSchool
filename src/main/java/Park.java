package main.java;

public class Park {
    String name;

    public Park(String name) {
        this.name = name;
    }

    //метод создающий ифнормацию по внутреннему классу ParkInfo и выводящий ее
    void createParkInfo(String workingHours, String generalInformation, int cost){
        ParkInfo info=new ParkInfo(workingHours, generalInformation,cost);
        System.out.println("name: "+name+"\nworking hours: "+info.workingHours+"\ngeneral information: "+info.generalInformation+
                "\ncost: "+info.cost);
    }
    //внутренний класс хранящий информацию об аттракционах
     class ParkInfo{
        String workingHours;
        String generalInformation;
        int cost;


        public ParkInfo(String workingHours, String generalInformation, int cost) {
            this.workingHours = workingHours;
            this.generalInformation = generalInformation;
            this.cost = cost;
        }

    }
}
