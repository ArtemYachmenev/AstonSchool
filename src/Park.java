public class Park {
    String name;

    public Park(String name) {
        this.name = name;
    }

    void createParkInfo(){
        ParkInfo info=new ParkInfo("9:00-18:00", "for child", 250);
        System.out.println("working hours: "+info.workingHours+"\ngeneral information: "+info.generalInformation+
                "\ncost: "+info.cost);
    }
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
