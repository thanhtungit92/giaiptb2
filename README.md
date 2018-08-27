package com.tungpt23.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.conn.params.ConnManagerParamBean;

public class CauG {
    String travelPath(String x, String y, String[][] paths)
    {
        List<Distance> lstInput = new ArrayList<>();
        for (int i = 0; i < paths.length; i++) {
            lstInput.add(new Distance(paths[i]));
        }
        
    }
    
    void process(String end, List<Distance> inputList, List<Distance> outputList) {
        
    }
    class Distance implements Comparable<Distance>{
        private String start;
        private String end;
        private Long distance;
        
        public Distance() {
            
        }
        
        public Distance(String[] input) {
            start = input[0];
            end = input[1];
            distance = Long.parseLong(input[2]);
        }
        
        public String getStart() {
            return start;
        }

        public void setStart(String start) {
            this.start = start;
        }

        public String getEnd() {
            return end;
        }

        public void setEnd(String end) {
            this.end = end;
        }

        public Long getDistance() {
            return distance;
        }

        public void setDistance(Long distance) {
            this.distance = distance;
        }

        @Override
        public int compareTo(Distance o) {
            
            return Math.toIntExact(this.distance - o.distance);
        }
        
    }

}

   
