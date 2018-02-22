//package com.example.alex.collectionsandmap.model;
//
//import com.example.alex.collectionsandmap.utils.Logger;
//
//import java.util.List;
//
//import static com.example.alex.collectionsandmap.view.MainActivity.INPUT_NUMBER;
//
//public class CollectionsProcessor2 implements ICollectionsProcessor{
//
//    private static Logger LOGGER = new Logger(CollectionsProcessor2.class);
//
//     public int addToStart(List<Integer> list) {
//        list.clear();
//        long t1 = System.currentTimeMillis();
//        for (int i = 0; i < INPUT_NUMBER; i++) {
//            list.add(0, i);
//        }
//        int result = (int) (System.currentTimeMillis() - t1);
//        LOGGER.log("addToStart // size " + list.size() + "// result " + result + getClassName(list));
//        return result;
//    }
//
//     public int addToMiddle(List<Integer> list) {
//        list.clear();
//        long t1 = System.currentTimeMillis();
//        for (int i = 0; i < INPUT_NUMBER; i++) {
//            list.add(list.size() / 2, i);
//        }
//        int result = (int) (System.currentTimeMillis() - t1);
//        LOGGER.log("addToMiddle called // size " + list.size() + "// result " + result +getClassName(list));
//        return result;
//    }
//
//     public  int addToEnd(List<Integer> list) {
//        list.clear();
//        long t1 = System.currentTimeMillis();
//        for (int i = 0; i < INPUT_NUMBER; i++) {
//            list.add(i);
//        }
//        int result = (int) (System.currentTimeMillis() - t1);
//        LOGGER.log("addToEnd called // size " + list.size() + "// result " + result + getClassName(list));
//        return result;
//    }
//
//     public  int search(List<Integer> list) {
//        list.clear();
//        addToEnd(list);
//        long t1 = System.currentTimeMillis();
//        int value = INPUT_NUMBER / 2;
//        list.get(value);
//        int result = (int) (System.currentTimeMillis() - t1);
//        LOGGER.log("search called // size " + list.size() + " value " + value + "result " + result + getClassName(list));
//        return result;
//    }
//
//     public  int removeStart(List<Integer> list) {
//         list.clear();
//         addToEnd(list);
//        LOGGER.log("remove start called - 1 // size " + list.size() + getClassName(list));
//        int size = list.size();
//        long t1 = System.currentTimeMillis();
//        for (int i = 0; i < size; i++) {
//            list.remove(0);
//        }
//        int result = (int) (System.currentTimeMillis() - t1);
//        LOGGER.log("remove start called - 2 // size " + list.size() + "// result  " + result + getClassName(list));
//        return result;
//    }
//
//     public  int removeMiddle(List<Integer> list) {
//         list.clear();
//         addToEnd(list);
//        LOGGER.log("remove middle called - 1 // size " + list.size() + getClassName(list));
//        int size = list.size();
//        long t1 = System.currentTimeMillis();
//        for (int i = size; i > 0; i--) {
//            list.remove(list.size() / 2);
//        }
//        int result = (int) (System.currentTimeMillis() - t1);
//        LOGGER.log("remove middle called - 2 // size " + list.size() + "// result " + result + getClassName(list));
//        LOGGER.log(" class " + list.getClass().getSimpleName());
//        return result;
//    }
//
//     public  int removeEnd(List<Integer> list) {
//        list.clear();
//        addToEnd(list);
//        LOGGER.log("remove end called - 1 // size " + list.size() + getClassName(list));
//        long t1 = System.currentTimeMillis();
//        for (int i = list.size() - 1; i >= 0; i--) {
//            list.remove(i);
//        }
//        int result = (int) (System.currentTimeMillis() - t1);
//        LOGGER.log("remove end called - 2 // size " + list.size()+"// result " + result + getClassName(list));
//        return result;
//    }
//
//    private static String getClassName(List list){
//        return " // " + list.getClass().getSimpleName();
//    }
//
//}
//
