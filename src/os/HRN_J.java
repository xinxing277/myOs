package os;

import java.util.Collections;
import java.util.Comparator;

import static os.FCFS_J.check;
import static os.IO_Manage.allocIO;
import static os.IO_Manage.searchIO;
import static os.Mem_Manage.allocMem;
import static os.Mem_Manage.searchMem;
import static os.mainStart.*;
import static os.mainStart.tasknum;

public class HRN_J {
    private  static void sort(){
        Collections.sort(jcbs, new Comparator<JCB>() {
            @Override
            public int compare(JCB o1, JCB o2) {
                return o1.getresponRatio()>o2.getresponRatio()? -1:(o1.getresponRatio()==o2.getresponRatio()? 0:1);
            }
        });
    }
    private static void flush(){
        //每次进行作业调度前刷新后备作业队列的响应比
        for (JCB j:jcbs){
            j.setResponRatio(1+(h-j.getArrivalTime())*1.0/j.getserveTime());
        }
    }
    public static void Jobscheduling() {
        flush();
        sort();
        for (int i = 0; i < jcbs.size(); i++) {
            if (jcbs.size() != 0 &&
                    pcbs_num - tasknum > 0 &&
                    jcbs.get(i).getArrivalTime() <= h) {//重点！！（敲黑板）
                //如果可以调度

                JCB jcb = jcbs.get(i);
                if (check(jcb)) {
                    //满足要求，建立PCB，插入就绪队列
                    //int id, int arrivalTime, int serveTime, int servedTime, int overTime, int memstartlocation, int memsize, int tapeDrive
                    Pcb pcb = new Pcb(jcb.getId(), (int) jcb.getArrivalTime(), (int) jcb.getserveTime(), 0, 0, 0, jcb.getMemsize(), jcb.getTapeDrive());
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

