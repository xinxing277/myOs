package os;

import javafx.scene.layout.GridPane;
import javafx.scene.shape.Shape;

import static os.mainStart.*;

public class Commons {
    public static void flush() {
        //ÿ��һ��ʱ��ˢ�¾������У�����ѡ�������
        //FCFS_Jobscheduling();
        switch (JcbKind) {
            case 1:
                FCFS_J.Jobscheduling();
                break;
            case 2:
                SJF_J.Jobscheduling();
                break;
            case 3:
                HRN_J.Jobscheduling();
                break;
        }
    }
    public static void schedual(){
        switch (PcbKind){
            case 1:
                FCFS_P.Pcbscheduling();
                break;
            case 2:
                SJF_P.Pcbscheduling();
                break;
            case 3:
                RR_P.Pcbscheduling();
                break;
            case 4:
                LRU_P.Pcbscheduling();
                break;
        }
    }
    public static double estimate(){
        //����ƽ����תʱ��
        double timeSum=0;
        for (Pcb p:done_pcbs){
            timeSum+=((p.getOverTimeTime()-p.getArrivalTime())*1.0/p.getServeTime());
        }
        return timeSum/done_pcbs.size();
    }
}
