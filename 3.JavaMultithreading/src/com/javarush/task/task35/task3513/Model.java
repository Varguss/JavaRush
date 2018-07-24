package com.javarush.task.task35.task3513;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Model {
    private static final int FIELD_WIDTH = 4;

    private Tile[][] gameTiles;
    private Stack<Tile[][]> previousStates = new Stack<>();
    private Stack<Integer> previousScores = new Stack<>();

    int score, maxTile;

    public Model() {
        resetGameTiles();
    }

    private List<Tile> getEmptyTiles() {
        return Stream.of(gameTiles).flatMap(Stream::of).filter(Tile::isEmpty).collect(Collectors.toCollection(ArrayList::new));
    }

    public void resetGameTiles() {
        gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        score = 0;
        maxTile = 0;

        for (int i = 0; i < FIELD_WIDTH; i++)
            for (int k = 0; k < FIELD_WIDTH; k++)
                gameTiles[i][k] = new Tile();

        addTile();
        addTile();
    }

    private void addTile() {
        List<Tile> emptyTiles = getEmptyTiles();

        int randomIndex = (int) (emptyTiles.size() * Math.random());

        if (!emptyTiles.isEmpty())
            emptyTiles.get(randomIndex).value = Math.random() < 0.9 ? 2 : 4;
    }

    private boolean compressTiles(Tile[] tiles) {
        boolean hasChanged = false;

        for (int i = 0; i < FIELD_WIDTH - 1; i++) {
            if (tiles[i].value == 0) {
                for (int k = i + 1; k < tiles.length; k++) {
                    if (tiles[k].value != 0) {
                        tiles[i].value = tiles[i].value ^ tiles[k].value;
                        tiles[k].value = tiles[i].value ^ tiles[k].value;
                        tiles[i].value = tiles[i].value ^ tiles[k].value;

                        hasChanged = true;
                        break;
                    }
                }
            }
        }

        return hasChanged;
    }

    private boolean mergeTiles(Tile[] tiles) {
        boolean hasChanged = false;

        for (int i = 0; i < FIELD_WIDTH - 1; i++) {
            if (tiles[i].value == tiles[i + 1].value && tiles[i].value != 0) {
                tiles[i].value += tiles[i + 1].value;

                score += tiles[i].value;

                if (maxTile < tiles[i].value)
                    maxTile = tiles[i].value;

                for (int k = i + 1; k < FIELD_WIDTH - 1; k++)
                    tiles[k].value = tiles[k + 1].value;
                tiles[tiles.length - 1].value = 0;

                hasChanged = true;
            }
        }

        return hasChanged;
    }

    public void left() {
        saveState(gameTiles);
        boolean isChanged = false;

        for (int i = 0; i < FIELD_WIDTH; i++)
            if (compressTiles(gameTiles[i]) | mergeTiles(gameTiles[i]))
                isChanged = true;

        if (isChanged)
            addTile();
    }

    public void right() {
        saveState(gameTiles);
        boolean isChanged = false;

        for (int i = 0; i < FIELD_WIDTH; i++) {
            Tile tiles[] = new Tile[FIELD_WIDTH];

            for (int k = FIELD_WIDTH - 1, index = 0; k >= 0; k--, index++)
                tiles[index] = gameTiles[i][k];

            if (compressTiles(tiles) | mergeTiles(tiles))
                isChanged = true;
        }

        if (isChanged)
            addTile();
    }

    public void up() {
        saveState(gameTiles);
        boolean isChanged = false;

        for (int i = 0; i < FIELD_WIDTH; i++) {
            Tile tiles[] = new Tile[FIELD_WIDTH];

            for (int k = 0; k < FIELD_WIDTH; k++)
                tiles[k] = gameTiles[k][i];

            if (compressTiles(tiles) | mergeTiles(tiles))
                isChanged = true;
        }

        if (isChanged)
            addTile();
    }

    public void down() {
        saveState(gameTiles);
        boolean isChanged = false;

        for (int i = 0; i < FIELD_WIDTH; i++) {
            Tile tiles[] = new Tile[FIELD_WIDTH];

            for (int k = FIELD_WIDTH - 1, index = 0; k >= 0; k--, index++)
                tiles[index] = gameTiles[k][i];

            if (compressTiles(tiles) | mergeTiles(tiles))
                isChanged = true;
        }

        if (isChanged)
            addTile();
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    public boolean canMove() {
        if (!getEmptyTiles().isEmpty())
            return true;

        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int k = 0; k < FIELD_WIDTH; k++) {
                if ((i - 1 >= 0) && (gameTiles[i][k].value == gameTiles[i - 1][k].value))
                    return true;
                if ((i + 1 < gameTiles.length) && (gameTiles[i][k].value == gameTiles[i + 1][k].value))
                    return true;
                if ((k - 1 >= 0) && (gameTiles[i][k].value == gameTiles[i][k - 1].value))
                    return true;
                if ((k + 1 < gameTiles[i].length) && (gameTiles[i][k].value == gameTiles[i][k + 1].value))
                    return true;
            }
        }

        return false;
    }

    private void saveState(Tile[][] state) {
        Tile[][] copyOfState = new Tile[FIELD_WIDTH][FIELD_WIDTH];

        for (int i = 0; i < FIELD_WIDTH; i++)
            for (int k = 0; k < FIELD_WIDTH; k++)
                copyOfState[i][k] = new Tile(state[i][k].value);

        previousStates.push(copyOfState);
        previousScores.push(score);
    }

    public void rollback() {
        if (!previousScores.empty() && !previousStates.empty()) {
            gameTiles = previousStates.pop();
            score = previousScores.pop();
        }
    }

    public void randomMove() {
        int n = ((int) (Math.random() * 100)) % 4;

        switch (n) {
            case 0: {
                left();
            } break;
            case 1: {
                right();
            } break;
            case 2: {
                up();
            } break;
            case 3: {
                down();
            } break;
        }
    }

    public boolean hasBoardChanged() {
        Tile[][] lastSave = previousStates.peek();

        for (int i = 0; i < FIELD_WIDTH; i++)
            for (int k = 0; k < FIELD_WIDTH; k++)
                if (lastSave[i][k].value != gameTiles[i][k].value)
                    return true;

        return false;
    }

    public MoveEfficiency getMoveEfficiency(Move move) {
        move.move();

        if (!hasBoardChanged())
            return new MoveEfficiency(-1, 0, move);

        MoveEfficiency efficiency = new MoveEfficiency(getEmptyTiles().size(), score, move);
        rollback();

        return efficiency;
    }

    public void autoMove() {
        PriorityQueue<MoveEfficiency> queue = new PriorityQueue<>(4, Comparator.reverseOrder());

        queue.offer(getMoveEfficiency(this::left));
        queue.offer(getMoveEfficiency(this::right));
        queue.offer(getMoveEfficiency(this::up));
        queue.offer(getMoveEfficiency(this::down));

        queue.remove().getMove().move();
    }
}
