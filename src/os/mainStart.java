package os;
//数据，操作在mainstart
//界面在main
import java.util.ArrayList;
import java.util.List;


public class mainStart {
    public static int h;                                    //时钟
    public static List<JCB> jcbs = new ArrayList();         //后备作业队列
    public static ArrayList<Node> list = new ArrayList();   //空闲节点链表
    public static List<Pcb> pcbs=new ArrayList();           //进程队列
    public static List<Pcb> done_pcbs=new ArrayList();      //已完成进程队列

//    public static ArrayBlockingQueue<Integer> neicunnum = new ArrayBlockingQueue(5);
    public static final int mem_size = 100;                 //主存空间100KB
    public static final int tapeDrive=4;                    //磁带机总数4台
    public static int tape_Used;                            //已分配磁带机数目
    public static int pcbs_num = 5;//内存只能放2道作业
    public static int jcbs_num = 5;//共有5道作业
    public static int timeSlide=5;//每五分钟刷新一遍pcb和jcb
    public static int tasknum;                              //已进入内存的作业数
    public static int JcbKind;                              //选择的作业调度算法
    public static int PcbKind;                              //选择的进程调度算法
    public static Pcb runningPcb;                           //居于运行状态的进程

    public static void init_jcbs() {
        //初始化后备作业队列，并且按作业到达时间排序
        //调试时先定好，调试好后再写输入函数
        JCB jcb1 = new JCB(1, 0, 25, 15,2);//到达时间以10点为起点，分钟为单位，内存以K为单位
        //jcb1.setFlag(false);
        jcbs.add(jcb1);
        JCB jcb2 = new JCB(2, 20, 30, 60,1);//到达时间以10点为起点，分钟为单位，内存以K为单位
        //jcb2.setFlag(false);
        jcbs.add(jcb2);
        JCB jcb3 = new JCB(3, 30, 10, 50,3);//到达时间以10点为起点，分钟为单位，内存以K为单位
        //jcb3.setFlag(false);
        jcbs.add(jcb3);
        JCB jcb4 = new JCB(4, 35,20,10,2);//到达时间以10点为起点，分钟为单位，内存以K为单位
        //jcb4.setFlag(false);
        jcbs.add(jcb4);
        JCB jcb5 = new JCB(5, 40, 15, 30,2);//到达时间以10点为起点，分钟为单位，内存以K为单位
        //jcb5.setFlag(false);
        jcbs.add(jcb5);
    }

//    public static List<Pcb> creatPcbfromJcb() {
//        int temnum = false;
//        List<Pcb> pcbs = new ArrayList();
//        int temnum;
//        if (jcbs.size() <= 5) {
//            temnum = jcbs.size();
//        } else {
//            temnum = 5;
//        }
//
//        for(int i = 0; i < temnum; ++i) {
//            JCB jcb = (JCB)jcbs.get(i);
//            Pcb pcb = new Pcb(jcb.getId(), jcb.getArrivalTime(), jcb.getRequiredTime(), 0, jcb.getMemsize());
//            pcbs.add(pcb);
//            RR_pcbs.add(pcb);
//            jcbs.remove(i);
//        }
//
//        return pcbs;
//    }

    public static void init_mem() {
        Node first = new Node();
        first.start = 0;
        first.size = 100;
        list.add(first);
    }

//    public static void main(String[] args) {
//
//
////        FCFS_J.startAlloc();
////        FCFS_P.pro_FCFS();
//        init_jcbs();
//        init_mem();
//        while (checkIsNULL()==false){
//            if(h%timeSlide==0)flush();
//           // FCFS_Pcbscheduling();
//            //SJF_Pcbscheduling();
//            RR_P.RR_Pcbscheduling();
//        }
//    }
    public static boolean checkIsNULL(){
        return (jcbs.isEmpty()&&pcbs.isEmpty());
    }

    static {
        tasknum = 0;
        tape_Used=0;
        h=0;
    }


}
