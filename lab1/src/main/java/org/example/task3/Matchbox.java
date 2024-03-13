package org.example.task3;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.SneakyThrows;

@AllArgsConstructor
public class Matchbox {
    @Getter
    private int count;


    public void getMatch() throws MatchNotFoundException {
        if (count <= 0) {
            throw new MatchNotFoundException("Спички кончились!");
        }
        count--;
    }
}
