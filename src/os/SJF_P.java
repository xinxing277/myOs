package os;

import java.util.Collections;
import java.util.Comparator;
import static os.Commons.flush;
import static os.mainStart.*;
import static os.FCFS_P.recovery;
//���̵��ȣ��̽������ȣ�Ҫʵ����ռʽ
public class SJF_P{
    public static void Pcbscheduling(){
        sort();
        if (pcbs.size()!=0){
            //��pcbs������ʱ������

            //�������в��� ����cpu��ʱ���ж�����ֹͣ
            Pcb tmp = pcbs.get(0);
            tmp.setState('R');
            runningPcb=tmp;
            running(tmp);
        }

    }
    public static void sort(){
        Collections.sort(pcbs, new Comparator<Pcb>() {
            @Override
            public int compare(Pcb o1, Pcb o2) {
                return (o1.getServeTime()-o1.getservedTime()) < (o2.getServeTime()-o2.getservedTime()) ? -1 : ((o1.getServeTime()-o1.getservedTime()) == (o2.getservedTime()-o2.getservedTime()) ? 0 : 1);
            }
        });
    }
    public static boolean hasPrior(Pcb pcb){
        flush();
        sort();
        Pcb tmp=pcbs.get(0);
        if((tmp.getServeTime()-tmp.getservedTime())<(pcb.getServeTime()-pcb.getservedTime()))
            return true;
        return false;
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

        for(int i=0;i<pcb.getServeTime()-pcb.getservedTime();i+=timeSlide){
            if(hasPrior(pcb)){
                //�и����ȵ�
                return;
            }
            h+=timeSlide;
            pcb.setservedTime(pcb.getservedTime() + timeSlide);
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
        pcb.setState('W');
    }


}
