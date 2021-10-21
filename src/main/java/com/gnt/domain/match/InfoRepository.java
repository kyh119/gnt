package com.gnt.domain.match;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface InfoRepository extends JpaRepository<Info, String> {

    @Query(value = "select match_id from info where match_id in\n" +
            "                                (select p.match_id from participant as p join summoner s on s.puuid = p.puuid)\n" +
            "order by game_creation desc limit 1", nativeQuery = true)
    String findLastMatchIdByPuuid(String puuid);
}
