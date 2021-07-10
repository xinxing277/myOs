package os;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static os.mainStart.*;
import static os.Mem_Manage.*;
import static os.IO_Manage.*;

//��ҵ���Ⱦ��ǣ�ѡ���ĸ���ҵ��������jobs�ŵ�pcbs
public class FCFS_J {
    public static void sort(){
        //������ʱ���jcbs����
        Collections.sort(jcbs, new Comparator<JCB>() {
            @Override
            public int compare(JCB o1, JCB o2) {
                return o1.getArrivalTime()<o2.getArrivalTime()? -1:(o1.getArrivalTime()==o2.getArrivalTime()? 0:1);
            }
        });
    }
    public static boolean check(JCB jcb){
        //�����Դ�Ƿ��㹻���䣬���������ҵβ��
        return (jcb.getMemsize() <= mem_size&&
                jcb.getTapeDrive() <= tapeDrive);
    }
    public static void Jobscheduling(){
        sort();
        for(int i=0;i<jcbs.size();i++) {
            //������Ե���
            if (jcbs.size()!=0 &&
                    pcbs_num-tasknum>0&&
                        jcbs.get(i).getArrivalTime()<=h){
                JCB jcb = jcbs.get(i);
                if (check(jcb)) {
                    //����Ҫ�󣬽���PCB�������������

                    //int id, int arrivalTime, int serveTime, int servedTime, int overTime, int memstartlocation, int memsize, int tapeDrive
                    Pcb pcb = new Pcb(jcb.getId(), (int) jcb.getArrivalTime(), (int) jcb.getserveTime(), 0, 0, 0, jcb.getMemsize(), jcb.getTapeDrive());
                    //�����ڴ������
                    //�ص㣡���úڰ壩��Ҫֱ�ӷ��䣡��Ȼ��ͬ��
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
