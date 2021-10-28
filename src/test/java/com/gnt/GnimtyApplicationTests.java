package com.gnt;

import com.gnt.domain.summoner.SummonerRepository;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GnimtyApplicationTests {

    @Autowired
    private SummonerRepository summonerRepository;

    @DisplayName("hello")
    @Test
    public void hello() {
        assertThat(summonerRepository.findById("yNl1AToO5W7q2K8uXkU8UUQW2iEJ4PF1SbPVvAw_4Rkfdw").get().getSummonerLevel()).isGreaterThan(60L);
    }


}
