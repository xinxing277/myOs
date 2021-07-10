package os;

import java.util.Collections;
import java.util.Comparator;
import static os.FCFS_J.check;
import static os.IO_Manage.allocIO;
import static os.IO_Manage.searchIO;
import static os.Mem_Manage.allocMem;
import static os.Mem_Manage.searchMem;
import static os.mainStart.*;

//作业调度就是：选择哪个作业，把他从jobs放到pcbs
public class SJF_J{
    public static void sort(){
        Collections.sort(jcbs, new Comparator<JCB>() {
            @Override
            public int compare(JCB o1, JCB o2) {
                return o1.getserveTime()<o2.getserveTime()? -1:(o1.getserveTime()==o2.getserveTime()? 0:1);
            }
        });
    }
    public static void Jobscheduling() {
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
