package net.mcreator.midnightlurker.util;

import java.util.HashMap;
import java.util.Map;

public class JumpscareFrames {
    public static Map<String, Integer> FRAME_MAP = genFrames();

    private static Map<String, Integer> genFrames() {
        Map<String, Integer> frameMap = new HashMap<>();

        int MAX_FRAMES = 46;
        for (int i = 0; i < MAX_FRAMES; i++) {
            frameMap.put("FRAME_"+(i+1), MAX_FRAMES - (i));
        }
        System.out.println(frameMap);

//        frameMap.put("FRAME_1", 46);
//        frameMap.put("FRAME_2", 45);
//        frameMap.put("FRAME_3", 44);
//        frameMap.put("FRAME_4", 43);
//        frameMap.put("FRAME_5", 42);
//        frameMap.put("FRAME_6", 41);
//        frameMap.put("FRAME_7", 40);
//        frameMap.put("FRAME_8", 39);
//        frameMap.put("FRAME_9", 38);
//        frameMap.put("FRAME_10", 37);
//        frameMap.put("FRAME_11", 36);
//        frameMap.put("FRAME_12", 35);
//        frameMap.put("FRAME_13", 34);
//        frameMap.put("FRAME_14", 33);
//        frameMap.put("FRAME_15", 32);
//        frameMap.put("FRAME_16", 31);
//        frameMap.put("FRAME_17", 30);
//
//        frameMap.put("FRAME_18", 29);
//        frameMap.put("FRAME_19", 28);
//        frameMap.put("FRAME_20", 27);
//        frameMap.put("FRAME_21", 26);
//        frameMap.put("FRAME_22", 25);
//        frameMap.put("FRAME_23", 24);
//        frameMap.put("FRAME_24", 23);
//        frameMap.put("FRAME_25", 22);
//        frameMap.put("FRAME_26", 21);
//        frameMap.put("FRAME_27", 20);
//
//        frameMap.put("FRAME_28", 19);
//        frameMap.put("FRAME_29", 18);
//        frameMap.put("FRAME_30", 17);
//        frameMap.put("FRAME_31", 16);
//        frameMap.put("FRAME_32", 15);
//        frameMap.put("FRAME_33", 14);
//        frameMap.put("FRAME_34", 13);
//        frameMap.put("FRAME_35", 12);
//        frameMap.put("FRAME_36", 11);
//
//        frameMap.put("FRAME_37", 10);
//        frameMap.put("FRAME_38", 9);
//        frameMap.put("FRAME_39", 8);
//        frameMap.put("FRAME_40", 7);
//        frameMap.put("FRAME_41", 6);
//        frameMap.put("FRAME_42", 5);
//        frameMap.put("FRAME_43", 4);
//        frameMap.put("FRAME_44", 3);
//        frameMap.put("FRAME_45", 2);
//        frameMap.put("FRAME_46", 1);
        return frameMap;
    }
}
