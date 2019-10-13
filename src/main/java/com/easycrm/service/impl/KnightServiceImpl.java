package com.easycrm.service.impl;

import com.easycrm.service.KnightService;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

// Knight
@Service("knightService")
public class KnightServiceImpl implements KnightService {

    // Bard
//    private static Logger logger = LoggerFactory.getLogger(KnightServiceImpl.class);

    public String getAchievement(String enemy) {
        try {
            Thread.sleep(2157);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(enemy.equalsIgnoreCase("dragon")) {
            return "knight is dead in fighting with " + enemy;
        }
        // sing a song
//        logger.info("we fight with " + enemy);
        // sing a song
//        logger.info("knight slave an enemy " + enemy);
        return "I am slave a " + enemy;
    }
}
