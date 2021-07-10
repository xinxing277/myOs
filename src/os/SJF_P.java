package os;

import java.util.Collections;
import java.util.Comparator;
import static os.Commons.flush;
import static os.mainStart.*;
import static os.FCFS_P.recovery;
//进程调度：短进程优先，要实现抢占式
public class SJF_P{
    public static void Pcbscheduling(){
        sort();
        if (pcbs.size()!=0){
            //对pcbs按到达时间排序

            //就绪队列不空 或者cpu暂时空闲都不能停止
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
        //进程运行,拨动时钟h，修改pcbs，donepcbs信息
        //时常刷新pcb，实现抢占式
//        h+=pcb.getServeTime();
//        pcb.setservedTime(pcb.getServeTime());
//        pcb.setState('F');
//        pcb.setOverTime(h);
//        pcbs.remove(pcb);
//        done_pcbs.add(pcb);
//        recovery(pcb);

        for(int i=0;i<pcb.getServeTime()-pcb.getservedTime();i+=timeSlide){
            if(hasPrior(pcb)){
                //有更优先的
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
