package os;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static os.mainStart.*;
import static os.Mem_Manage.*;
import static os.IO_Manage.*;

//作业调度就是：选择哪个作业，把他从jobs放到pcbs
public class FCFS_J {
    public static void sort(){
        //按到达时间对jcbs排序
        Collections.sort(jcbs, new Comparator<JCB>() {
            @Override
            public int compare(JCB o1, JCB o2) {
                return o1.getArrivalTime()<o2.getArrivalTime()? -1:(o1.getArrivalTime()==o2.getArrivalTime()? 0:1);
            }
        });
    }
    public static boolean check(JCB jcb){
        //检查资源是否足够分配，不够则把作业尾插
        return (jcb.getMemsize() <= mem_size&&
                jcb.getTapeDrive() <= tapeDrive);
    }
    public static void Jobscheduling(){
        sort();
        for(int i=0;i<jcbs.size();i++) {
            //如果可以调度
            if (jcbs.size()!=0 &&
                    pcbs_num-tasknum>0&&
                        jcbs.get(i).getArrivalTime()<=h){
                JCB jcb = jcbs.get(i);
                if (check(jcb)) {
                    //满足要求，建立PCB，插入就绪队列

                    //int id, int arrivalTime, int serveTime, int servedTime, int overTime, int memstartlocation, int memsize, int tapeDrive
                    Pcb pcb = new Pcb(jcb.getId(), (int) jcb.getArrivalTime(), (int) jcb.getserveTime(), 0, 0, 0, jcb.getMemsize(), jcb.getTapeDrive());
                    //分配内存和外设
                    //重点！（敲黑板）不要直接分配！不然不同步
                    if(searchMem(pcb.getMemsize())!=null&&searchIO(pcb.gettapeDrive())>=pcb.gettapeDrive()){
                        allocMem(pcb);allocIO(pcb);
                        jcbs.remove(jcb);
                        pcbs.add(pcb);
                        //                                neicunnum.add(jcb.getId());
                        ++tasknum;
                    }
                    else {
                        //分配失败
                    }
                }
            }
        }

    }

}
