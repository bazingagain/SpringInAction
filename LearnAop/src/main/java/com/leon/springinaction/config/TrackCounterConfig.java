package com.leon.springinaction.config;

import com.leon.springinaction.CompactDisc;
import com.leon.springinaction.aspect.TrackCounter;
import com.leon.springinaction.impl.BlackDisk;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 21/01/2018.
 *
 * @author Xiaolei-Peng
 */

@Configuration
@EnableAspectJAutoProxy
public class TrackCounterConfig {

    @Bean
    public CompactDisc sgtPeppers() {
        BlackDisk blackDisk = new BlackDisk();
        blackDisk.setTitle("Sgt....");
        blackDisk.setTitle("The Beatles");
        List<String> tracks = new ArrayList<String>();
        tracks.add("sgt. Pe1");
        tracks.add("sgt. Pe2");
        tracks.add("sgt. Pe3");
        blackDisk.setTracks(tracks);
        return blackDisk;
    }

    @Bean
    public TrackCounter trackCounter() {
        return new TrackCounter();
    }

}
