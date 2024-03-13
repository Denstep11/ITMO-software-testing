package org.example.task3;

import lombok.Data;
import lombok.SneakyThrows;

@Data
public class Human {
    private String name;
    private Matchbox matchbox;
    private Boolean fear = false;
    private Boolean lungIrritation = false;
    private Boolean thoughtsCollected = true;
    private Condition condition = Condition.FINE;

    Human(String name){
        this.name = name;
    }

    @SneakyThrows
    public void lightMatch() {
        if(matchbox == null){
            throw new MatchNotFoundException("Коробка со спичками нет!");
        }
        matchbox.getMatch();
        System.out.println(name + " поджег спичку");
    }

    //ему кажется
    public void seems(Figure figure) {
        switch (figure.getFigureType()) {
            case OMINOUS, STRANGE -> fear = true;
            case KIND -> fear = false;
        }
    }

    //он вдыхает
    public void inhales(Air air) {
        switch (air.getAirType()) {
            case NICE, FRESH -> lungIrritation = false;
            case STAGNANT, ROTTEN -> lungIrritation = true;
        }
    }

    //он слышит
    public void hears(Hum hum) {
        switch (hum.getHumType()) {
            case LOW, AVERAGE, HIGH -> thoughtsCollected = false;
            case QUIET -> thoughtsCollected = true;
        }
    }

    //оценка состояния
    private void conditionAssessment(){
        if(!fear&&!lungIrritation&&thoughtsCollected){
            condition = Condition.FINE;
        }
        else if(fear&&lungIrritation&&!thoughtsCollected){
            condition = Condition.TERRIBLE;
        }
        else{
            condition = Condition.SATISFACTORILY;
        }
    }

    public Condition getCondition() {
        conditionAssessment();
        return condition;
    }
}
