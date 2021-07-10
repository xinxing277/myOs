package os;

import java.util.Collections;
import java.util.Comparator;
import static os.FCFS_J.check;
import static os.IO_Manage.allocIO;
import static os.IO_Manage.searchIO;
import static os.Mem_Manage.allocMem;
import static os.Mem_Manage.searchMem;
import static os.mainStart.*;

//��ҵ���Ⱦ��ǣ�ѡ���ĸ���ҵ��������jobs�ŵ�pcbs
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
                    jcbs.get(i).getArrivalTime() <= h) {//�ص㣡�����úڰ壩
                //������Ե���

                    JCB jcb = jcbs.get(i);
                    if (check(jcb)) {
                        //����Ҫ�󣬽���PCB�������������
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
                            //����ʧ��
                        }

                    }
            }

        }
    }

}
