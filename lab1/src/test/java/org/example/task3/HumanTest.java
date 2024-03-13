package org.example.task3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HumanTest {

    private Human human1;
    private Human human2;

    @BeforeEach
    void init() {
        human1 = new Human("Форд");
        human2 = new Human("Артур");
    }

    @Test
    void burnMatches() {
        Matchbox matchbox = new Matchbox(5);
        human1.setMatchbox(matchbox);

        human1.lightMatch();
        human1.lightMatch();
        human1.lightMatch();

        assertEquals(2, human1.getMatchbox().getCount());

        human1.lightMatch();
        human1.lightMatch();
        assertThrows(MatchNotFoundException.class, () -> human1.lightMatch());
    }

    @Test
    void MatchboxEmpty() {
        assertAll(
                () -> assertThrows(MatchNotFoundException.class, () -> human1.lightMatch()),

                () -> assertThrows(MatchNotFoundException.class, () -> {
                    human1.setMatchbox(null);
                    human1.lightMatch();
                }),

                () -> assertThrows(MatchNotFoundException.class, () -> {
                    Matchbox matchbox = new Matchbox(0);
                    human1.setMatchbox(matchbox);

                    human1.lightMatch();
                }),

                () -> assertThrows(MatchNotFoundException.class, () -> {
                    Matchbox matchbox = new Matchbox(-20);
                    human1.setMatchbox(matchbox);

                    human1.lightMatch();
                })
        );
    }

    @Test
    void seems() {
        Figure figure1 = new Figure(FigureType.KIND);
        Figure figure2 = new Figure(FigureType.OMINOUS);
        Figure figure3 = new Figure(FigureType.STRANGE);

        assertAll(
                () -> assertEquals(false, human2.getFear()),
                () -> {
                    human2.seems(figure1);
                    assertEquals(false, human2.getFear());
                },
                () -> {
                    human2.seems(figure2);
                    assertEquals(true, human2.getFear());
                },
                () -> {
                    human2.seems(figure3);
                    assertEquals(true, human2.getFear());
                }
        );
    }

    @Test
    void inhales() {
        Air air1 = new Air(AirType.FRESH);
        Air air2 = new Air(AirType.NICE);
        Air air3 = new Air(AirType.ROTTEN);
        Air air4 = new Air(AirType.STAGNANT);

        assertAll(
                () -> assertEquals(false, human2.getLungIrritation()),
                () -> {
                    human2.inhales(air1);
                    assertEquals(false, human2.getLungIrritation());
                },
                () -> {
                    human2.inhales(air2);
                    assertEquals(false, human2.getLungIrritation());
                },
                () -> {
                    human2.inhales(air3);
                    assertEquals(true, human2.getLungIrritation());
                },
                () -> {
                    human2.inhales(air4);
                    assertEquals(true, human2.getLungIrritation());
                }
        );
    }

    @Test
    void hears() {
        Hum hum1 = new Hum(HumType.AVERAGE);
        Hum hum2 = new Hum(HumType.HIGH);
        Hum hum3 = new Hum(HumType.LOW);
        Hum hum4 = new Hum(HumType.QUIET);

        assertAll(
                () -> assertEquals(true, human2.getThoughtsCollected()),
                () -> {
                    human2.hears(hum1);
                    assertEquals(false, human2.getThoughtsCollected());
                },
                () -> {
                    human2.hears(hum2);
                    assertEquals(false, human2.getThoughtsCollected());
                },
                () -> {
                    human2.hears(hum3);
                    assertEquals(false, human2.getThoughtsCollected());
                },
                () -> {
                    human2.hears(hum4);
                    assertEquals(true, human2.getThoughtsCollected());
                }
        );
    }

    @Test
    void condition() {

        assertAll(
                () -> assertEquals(Condition.FINE, human2.getCondition()),
                () -> {
                    human2.setFear(false);
                    human2.setLungIrritation(false);
                    human2.setThoughtsCollected(true);
                    assertEquals(Condition.FINE, human2.getCondition());
                },
                () -> {
                    human2.setFear(true);
                    human2.setLungIrritation(true);
                    human2.setThoughtsCollected(false);
                    assertEquals(Condition.TERRIBLE, human2.getCondition());
                },
                () -> {
                    human2.setFear(true);
                    human2.setLungIrritation(false);
                    human2.setThoughtsCollected(false);
                    assertEquals(Condition.SATISFACTORILY, human2.getCondition());
                },
                () -> {
                    human2.setFear(false);
                    human2.setLungIrritation(true);
                    human2.setThoughtsCollected(false);
                    assertEquals(Condition.SATISFACTORILY, human2.getCondition());
                },
                () -> {
                    human2.setFear(false);
                    human2.setLungIrritation(false);
                    human2.setThoughtsCollected(false);
                    assertEquals(Condition.SATISFACTORILY, human2.getCondition());
                },
                () -> {
                    human2.setFear(true);
                    human2.setLungIrritation(false);
                    human2.setThoughtsCollected(true);
                    assertEquals(Condition.SATISFACTORILY, human2.getCondition());
                }
        );
    }

}
