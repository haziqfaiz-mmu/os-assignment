import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class RoundRobin {

    Queue <Process> processQueue = new LinkedList<Process>();
    ArrayList<Process> waitList = new ArrayList<Process>();
    HashMap<String,Integer> ganttChart;
    
    public void userInput(){
         
        Scanner input = new Scanner(System.in); 
        System.out.print("Enter number of process: ");
        int numberOfProcess = input.nextInt();  

        for(int i=0;i<numberOfProcess;i++){
        
            System.out.print("Enter process ID: ");
            String processID = input.next();
            
            System.out.print("Enter burst time: ");
            int burstTime = input.nextInt();
            System.out.print("Enter arrival time: ");
            int arrivalTime = input.nextInt();

            waitList.add(new Process(processID,burstTime,arrivalTime));
        }

        Collections.sort(waitList);
        System.out.println(waitList);
    }

    public void addToProcessQueue(ArrayList<Process> waitList, Queue<Process> processQueue){
        processQueue.add(waitList.get(0));
        waitList.remove(0);

    }

    public void RRProcess(Queue<Process> processQueue){

        int quantumTime = 3;

        //add the first element in the wait queue into process queue tehn remove it from wait queue

        while(!waitList.isEmpty() && !processQueue.isEmpty()){
            int time = 0;
            int totalTime=0;

            //add the first process into process queue
            if(time <= waitList.get(0).getArrivalTime()){
                addToProcessQueue(waitList, processQueue);
            }

            Process headProcess = processQueue.element();//get the first process in the queue

            while(time <= quantumTime && headProcess.getIsCompleted()){
               
                headProcess.setRemainingBurstTime(headProcess.getRemainingBurstTime()-time);

                while(waitList.get(0).getArrivalTime()<=time){
                    addToProcessQueue(waitList, processQueue);
                }
                
                time++;
                totalTime = totalTime+time;
            }
            
            processQueue.poll();
            //if still not finish put it back in the process queue
            if(headProcess.getCurrentBurstTime()>0){
                processQueue.add(headProcess);
            }
            time =0; ;
        }

    }

    
}
