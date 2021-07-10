package os;
//import static os.Mem_Manage.merge;
import static os.mainStart.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//内存管理，包括内存分配(BF)和回收
public class Mem_Manage {

    public static Node searchMem(int size){
        //        List<Pcb> tempPcbs = new ArrayList<>();
        //        tempPcbs.addAll(Pcbs);
        //list:空闲分区列表
        if(list.size()!=0){
            for(Node n:list){
                if(n.size>=size){
                    return n;
                }
            }
        }
        return null;
    }
    public static boolean allocMem(Pcb pcb){//最佳内存分配
        //函数功能：分配内存，管理list
        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.start<o2.start?-1:(o1.start==o2.start?0:1);
//                return o1.size<o2.size? -1:(o1.size==o2.size? 0:1);
            }
        });
        Node n=null;

        if((n=searchMem(pcb.getMemsize()))!=null){
            //修改Pcb
            pcb.setMemstartlocation(n.start);
            if(pcb.getMemsize()<n.size){
                //需要分割
                n.size-=pcb.getMemsize();
                n.start+=pcb.getMemsize();
            }else {
                list.remove(n);
            }


            return true;
        }else {
            //反馈内存分配失败，空间不够
            return false;
        }

    }
    public static void recoveryMem(Pcb pcb){
        boolean flag=false;//作是否可以合并的标记
        Node node=new Node(pcb.getMemstartlocation(),pcb.getMemsize());
        //先对list按起址排序
        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.start<o2.start? -1:(o1.start==o2.start? 0:1);
            }
        });
        //先遍历是否可以前合并

        for (Node n:list){
            if(n.start+n.size==pcb.getMemstartlocation()){
//                merge(n,node);
                n.size+=pcb.getMemsize();
                flag=true;
            }
        }
        if(flag==false) {
            //再遍历是否可以后合并
            for (Node n : list) {
                if (pcb.getMemstartlocation() + pcb.getMemsize() == n.start) {
                    //                merge(n,node);
                    n.size += pcb.getMemsize();
                    n.start = pcb.getMemstartlocation();
                    flag = true;
                }
            }
        }
        //最后检测list是否有可以连接
        for (int i=0;i<list.size()-1;i++){
            Node n=list.get(i);
            if(n.start+n.size==list.get(i+1).start){
//                merge(n,list.get(i+1));
                n.size+=list.get(i+1).size;
                list.remove(i+1);
                flag=true;
            }
        }
        if(!flag){
            list.add(node);
        }
    }
//    public static void merge(Node n1,Node n2){
//        //合并两个空闲节点
//        if(n1.start<n2.start){//n1在前
//            n1.size+=n2.size;
//            list.add(n1);
//            if(list.contains(n2))
//                list.remove(n2);
//        }else {
//            n2.size+=n1.size;
//            list.add(n2);
//            if(list.contains(n1))
//                list.remove(n1);
//        }
//
//    }
}
