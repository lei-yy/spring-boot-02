package com.lyy.springboot02;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot02ApplicationTests {

    @Test
    public void contextLoads() {
    }

}
class  Solution {

    public static void main(String[] args) {
        int n=reverse(1);
        System.out.println(n);
    }
    public static int reverse(int x) {
        int n=0;
        x=1345;
        while (x!=0){
            int num=x%10;
            x=x/10;

            n=n*10+num;

        }
        return n;
    }
}
