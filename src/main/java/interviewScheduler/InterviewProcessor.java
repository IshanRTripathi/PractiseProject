package interviewScheduler;

import java.util.List;
import java.util.concurrent.BlockingQueue;

public class InterviewProcessor implements Runnable{

    private BlockingQueue<String> queue;

    private List<String> candidates = List.of("Ishan", "Pooks", "Ayush", "Samriddhi", "Dabbu");

    public InterviewProcessor(BlockingQueue<String> queue){
        this.queue= queue;
    }

    @Override
    public void run() {
        System.out.println("Starting interview for candidates" + candidates);
        for(int i=0; i<candidates.size(); i++){
            String candidateName= candidates.get(i);
            try {
                queue.put(candidateName);
                System.out.println("SCHEDULED: "+candidateName+"'s interview scheduled !");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
