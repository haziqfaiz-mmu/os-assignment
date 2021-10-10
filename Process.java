public class Process implements Comparable<Process> {

    private String processID;
    private int burstTime;
    private int arrivalTime;
    private int priority;
    private int currentBurstTime;
    private boolean isCompleted;
    private int remainingBurstTime;
    private int waitTime;
    private int turnAroundTime;

    //EMPTY CONSTRUCTOR
    public Process() {}

    //CONSTRUCTOR WITH PID, BURST, ARRIVAL
    public Process(String processID, int burstTime, int arrivalTime) {
		
        this.processID = processID;
        this.burstTime = burstTime;
        this.arrivalTime = arrivalTime;
        this.priority =0;
        this.currentBurstTime = 0;
        this.isCompleted = false;
        this.remainingBurstTime = burstTime;
        this.waitTime = 0;
        this.turnAroundTime = 0;
    }

    //CONSTRUCTOR WITH PID, BURST, ARRIVAL, PRIORITY
    public Process(String processID, int burstTime, int arrivalTime,int priority) {
		
        this.processID = processID;
        this.burstTime = burstTime;
        this.arrivalTime = arrivalTime;
        this.priority = priority;
        this.currentBurstTime = 0;
        this.isCompleted = false;
        this.remainingBurstTime = burstTime;
        this.waitTime = 0;
        this.turnAroundTime = 0;
    }

    //GETTERS AND SETTERS

    public String getProcessID(){return this.processID;}

    public int getBurstTime(){return this.burstTime;}

    public int getArrivalTime(){return this.arrivalTime;}

    public int getPriority(){return this.priority;}

    public int getCurrentBurstTime(){return this.burstTime;}

    public Boolean getIsCompleted(){return this.isCompleted;}

    public int getRemainingBurstTime(){return this.remainingBurstTime;}

    public int getWaitTime(){return this.waitTime;}

    public int getTurnAroundTime(){return this.turnAroundTime;}

    public void setprocessID(String processID){this.processID = processID;}

    public void setBurstTime(int burstTime){this.burstTime=burstTime;}

    public void setArrivalTime(int arrivalTime){this.arrivalTime=arrivalTime;}

    public void setPriority(int priority){this.priority=priority;}

    public void setCurrentBurstTime(int burstTime){this.burstTime = burstTime;}

    public void setIsCompleted(Boolean isCompleted){this.isCompleted=isCompleted;}

    public void setRemainingBurstTime(int remainingBurstTime){this.remainingBurstTime = remainingBurstTime;}

    public void setWaitTime(int waitTime){this.waitTime=waitTime;}

    public void setTurnAroundTime(int turnAroundTime){this.turnAroundTime=turnAroundTime;}

    public String toString(){
        return this.processID;
    }

    public int compareTo(Process p){

        int arrivalTimeDifference = this.getArrivalTime()-p.arrivalTime;
        int burstTimeDifference = this.burstTime-p.burstTime;
        int processIDDifference = this.getProcessID().compareTo(p.processID);

        if(arrivalTimeDifference == 0){
            if(burstTimeDifference == 0){
                return processIDDifference;
            }
            else return burstTimeDifference;
        }
        else return arrivalTimeDifference;
    }

    public void markProcessDone(){
        if(this.remainingBurstTime==0){
            setIsCompleted(true);
        }
    }
}
