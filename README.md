# giaiptb2

package com.tungpt23.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CauD {
    boolean cardGroup(String s) {
        List<String> orderList = getOrderList(s);
        if (isForFive(orderList)) {
            return true;
        }

        if (isSixThree(orderList)) {
            return true;
        }

        return false;
    }

    List<String> getOrderList(String s) {
        List<String> out = new ArrayList<>();
        String[] sArr = s.split("[A-Z]");
        for (int i = 0; i < sArr.length; i++) {

            out.add(sArr[i].concat(s.substring(s.indexOf(sArr[i]) + 1, s.indexOf(sArr[i]) + 2)));
            s = s.substring(s.indexOf(sArr[i]) + 2);

        }
        Collections.sort(out);

        return out;
    }

    boolean isForFive(List<String> in) {
        if (in.get(0).substring(0, 1).equals(in.get(1).substring(0, 1))
                && in.get(1).substring(0, 1).equals(in.get(2).substring(0, 1))
                && in.get(2).substring(0, 1).equals(in.get(3).substring(0, 1))) {
            if (in.get(4).substring(1, 2).equals(in.get(5).substring(1, 2))
                    && in.get(5).substring(1, 2).equals(in.get(6).substring(1, 2))
                    && in.get(6).substring(1, 2).equals(in.get(7).substring(1, 2))
                    && in.get(7).substring(1, 2).equals(in.get(8).substring(1, 2))) {
                return true;
            }
        }

        if (in.get(5).substring(0, 1).equals(in.get(6).substring(0, 1))
                && in.get(6).substring(0, 1).equals(in.get(7).substring(0, 1))
                && in.get(7).substring(0, 1).equals(in.get(8).substring(0, 1))) {
            if (in.get(0).substring(1, 2).equals(in.get(1).substring(1, 2))
                    && in.get(1).substring(1, 2).equals(in.get(2).substring(1, 2))
                    && in.get(2).substring(1, 2).equals(in.get(3).substring(1, 2))
                    && in.get(3).substring(1, 2).equals(in.get(4).substring(1, 2))) {
                return true;
            }
        }

        Map<String, List<String>> mapCheck = doGroup(in);

        if (mapCheck.size() == 2) {
            for (Map.Entry<String, List<String>> entry : mapCheck.entrySet()) {
                if (entry.getValue().size() != 4 && entry.getValue().size() != 5) {
                    return false;
                } else {

                    int cur = Integer.parseInt(entry.getValue().get(0)) - 1;
                    for (int i = 0; i < entry.getValue().size(); i++) {
                        if (Integer.parseInt(entry.getValue().get(i)) != ++cur) {
                            return false;
                        }
                    }
                }
            }
        } else {
            return false;
        }

        return true;
    }

    boolean isSixThree(List<String> in) {
        Map<String, List<String>> mapCheck = doGroup(in);
        if (mapCheck.size() == 2) {
            for (Map.Entry<String, List<String>> entry : mapCheck.entrySet()) {
                if (entry.getValue().size() != 3 && entry.getValue().size() != 6) {
                    return false;
                } else {

                    int cur = Integer.parseInt(entry.getValue().get(0)) - 1;
                    for (int i = 0; i < entry.getValue().size(); i++) {
                        if (Integer.parseInt(entry.getValue().get(i)) != ++cur) {
                            return false;
                        }
                    }
                }
            }
        } else {
            List<String> keyCheck = Arrays.asList("C", "T", "R", "B");
            for (Map.Entry<String, List<String>> entry : mapCheck.entrySet()) {
                if (entry.getValue().size() == 6) {
                    keyCheck.remove(entry.getKey());
                    if (mapCheck.get(keyCheck.get(0)) != null && mapCheck.get(keyCheck.get(1)) != null
                            && mapCheck.get(keyCheck.get(2)) != null) {
                        if (mapCheck.get(keyCheck.get(0)).get(0).equals(mapCheck.get(keyCheck.get(1)).get(0))
                                && mapCheck.get(keyCheck.get(1)).get(0).equals(mapCheck.get(keyCheck.get(2)).get(0))) {
                            return true;
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    boolean isTripleT(List<String> in) {
        // 3 cái 3 lá
        if (in.get(0).equals(in.get(1)) && in.get(1).equals(in.get(2)) && in.get(3).equals(in.get(4))
                && in.get(4).equals(in.get(5)) && in.get(6).equals(in.get(7)) && in.get(7).equals(in.get(8))) {
            return true;
        }
        
                
        

        return true;
    }

    Map<String, List<String>> doGroup(List<String> in) {

        Map<String, List<String>> mapOut = new HashMap<>();
        in.forEach(x -> {
            String key = x.substring(x.length() - 1);
            if (mapOut.containsKey(key)) {
                mapOut.get(key).add(x.substring(0, x.length() - 1));
            } else {
                List<String> list = new ArrayList<>();
                list.add(x.substring(0, x.length() - 1));
                mapOut.put(key, list);
            }
        });
        return mapOut;
    }

    public static void main(String[] args) {
        CauD d = new CauD();
        System.out.println(d.cardGroup("2R2B2T3R3B3T4R4B5C"));
    }

}
