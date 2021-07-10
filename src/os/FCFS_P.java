package os;

import java.util.Collections;
import java.util.Comparator;

import static os.Mem_Manage.*;
import static os.IO_Manage.*;
import static os.mainStart.*;
import static os.userController.*;
//进程调度：先来先服务，管理进程控制块表pcbs
public class FCFS_P{
    public static void Pcbscheduling(){
            sort();
            if (pcbs.size()!=0){
                    //对pcbs按到达时间排序

                    //就绪队列不空 或者cpu暂时空闲都不能停止
                Pcb tmp = pcbs.get(0);
                runningPcb=tmp;
                tmp.setState('R');
                running(tmp);

            }
    }
    public static void sort(){
        Collections.sort(pcbs, new Comparator<Pcb>() {
            @Override
            public int compare(Pcb o1, Pcb o2) {
                return o1.getArrivalTime() < o2.getArrivalTime() ? -1 : (o1.getArrivalTime() == o2.getArrivalTime() ? 0 : 1);
            }
        });
    }
    public static void running(Pcb pcb){
        //进程运行,拨动时钟h，修改pcbs，donepcbs信息
        h+=pcb.getServeTime();
        pcb.setservedTime(pcb.getServeTime());
        pcb.setState('F');
        pcb.setOverTime(h);
        System.out.println(pcb);
        pcbs.remove(pcb);
        done_pcbs.add(pcb);
        recovery(pcb);
    }
    public static void waiting(){
        while (pcbs.size()==0){
            h++;
        }
    }

//    public static void display(Pcb pcb){
//        System.out.println(pcb);
//    }
    public static void recovery(Pcb pcb){
        //回收资源，处理pcb块,并且处理tasknum
        tasknum--;
        recoveryMem(pcb);
        recoveryIO(pcb);
    }



}
