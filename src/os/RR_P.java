package os;

import static os.FCFS_P.recovery;
import static os.mainStart.*;
public class RR_P{
    //ʱ��ƬΪmain�������timeSlide
    public static void Pcbscheduling(){
        if (pcbs.size()!=0){
            //��pcbs������ʱ������

            //�������в��� ����cpu��ʱ���ж�����ֹͣ
            Pcb tmp = pcbs.remove(0);
            tmp.setState('R');
            runningPcb=tmp;
            running(tmp);
        }

    }

    public static void running(Pcb pcb){
        //��������,����ʱ��h���޸�pcbs��donepcbs��Ϣ
        //ʱ��ˢ��pcb��ʵ����ռʽ
//        h+=pcb.getServeTime();
//        pcb.setservedTime(pcb.getServeTime());
//        pcb.setState('F');
//        pcb.setOverTime(h);
//        pcbs.remove(pcb);
//        done_pcbs.add(pcb);
//        recovery(pcb);

        for(int i=0;i<timeSlide;i++){

            h++;
            pcb.setservedTime(pcb.getservedTime() + 1);
            if(pcb.getservedTime()>=pcb.getServeTime()){
                pcb.setOverTime(h);
                pcb.setState('F');
                System.out.println(pcb);
                pcbs.remove(pcb);
                done_pcbs.add(pcb);
                recovery(pcb);

                return;
            }

        }
        //ʱ��Ƭ����������δ����
        pcbs.add(pcb);
        pcb.setState('W');
    }


}
