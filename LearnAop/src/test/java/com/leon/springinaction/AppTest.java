package com.leon.springinaction;

import com.leon.springinaction.aspect.EncoreableIntroducer;
import com.leon.springinaction.aspect.TrackCounter;
import com.leon.springinaction.config.ConcertConfig;
import com.leon.springinaction.config.TrackCounterConfig;
import com.leon.springinaction.impl.PerformanceImpl;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Unit test for simple App.
 */

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {ConcertConfig.class, TrackCounterConfig.class})

@ContextConfiguration("classpath:spring.xml")
public class AppTest {
    @Rule
    public final StandardOutputStreamLog log = new StandardOutputStreamLog();

    @Autowired
    private CompactDisc cd;

    @Autowired
    private TrackCounter counter;

    @Autowired
    private Performance performance;



    @Test
    public void testAudience() {
        performance.perform();
    }

    @Test
    public void testTrackCounter() {
        cd.playTrack(1);
        cd.playTrack(2);
        cd.playTrack(3);
        cd.playTrack(3);
        cd.playTrack(3);
        cd.playTrack(3);
        cd.playTrack(7);
        cd.playTrack(7);

        Assert.assertEquals(1, counter.getPlayCount(1));
        Assert.assertEquals(1, counter.getPlayCount(2));
        Assert.assertEquals(4, counter.getPlayCount(3));
        Assert.assertEquals(0, counter.getPlayCount(4));
        Assert.assertEquals(0, counter.getPlayCount(5));
        Assert.assertEquals(0, counter.getPlayCount(6));
        Assert.assertEquals(2, counter.getPlayCount(7));
    }

}
