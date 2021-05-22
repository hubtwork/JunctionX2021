package com.junctionx.pandalion;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class test extends PandalionApplicationTests{

    @Test
    public void random() {
        int personCnt = 10;
        ArrayList result = new ArrayList();
        ArrayList a = new ArrayList();

        while(true){

            Random g = new Random();
            Random c = new Random();

            int groupNumber =  g.nextInt(3)+1;
            int _groupNumber = groupNumber;
            int channelNumber = c.nextInt(16)+1;
            int _channelNumber = channelNumber;
            String temp = Integer.toString(_groupNumber) + Integer.toString(_channelNumber);
            if (!result.contains(temp)){
                result.add(temp);
                a.add(groupNumber);
                a.add(channelNumber);
            }
            if (result.size() >= personCnt){
                break;
            }
        }

        for(int i = 0 ; i< a.size(); i++){
            System.out.println(a.get(i));
        }

    }


}
