package os;

import static os.FCFS_P.recovery;
import static os.mainStart.*;
public class RR_P{
    //时间片为main函数里的timeSlide
    public static void Pcbscheduling(){
        if (pcbs.size()!=0){
            //对pcbs按到达时间排序

            //就绪队列不空 或者cpu暂时空闲都不能停止
            Pcb tmp = pcbs.remove(0);
            tmp.setState('R');
            runningPcb=tmp;
            running(tmp);
        }

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
        //时间片结束，进程未结束
        pcbs.add(pcb);
        pcb.setState('W');
    }


}
