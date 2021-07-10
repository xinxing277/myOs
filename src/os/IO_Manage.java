package os;


import static os.mainStart.*;

//外设管理，包括外设分配和回收
public class IO_Manage {
    //该类主要管理tape
//    public static boolean allocIO(Pcb pcb) {
////        List<JCB> tempjcbs = new ArrayList<>();
////        tempjcbs.addAll(jcbs);
//        int size=pcb.gettapeDrive();
//        if(tapeDrive-tape.size()>=size){
//            //可分配
//            for(int i=0;i<size;){
//                for(int j=1;j<=tapeDrive;j++){
//                    //j:设备号
//                    //i:设备数
//                    if(tape.contains(j)==false){
//                        //如果第j台磁带机没有分配
//                        tape.add(j);
//                        i++;
//                    }
//                }
//            }
//            return true;
//        }
//        else return false;
//    }
    public static int searchIO(int size){
        return (tapeDrive-tape_Used)>size?size:(tapeDrive-tape_Used);
    }
    public static boolean allocIO(Pcb pcb){
        int size=pcb.gettapeDrive();
        if(tapeDrive-tape_Used>=size){
            //可分配
            tape_Used+=size;
            return true;
        }
        else  return false;
    }
    public static void recoveryIO(Pcb pcb){
        int size=pcb.gettapeDrive();
        tape_Used-=size;
    }
}
