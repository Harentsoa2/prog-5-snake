package com.hei.school.model;

public record Position(int row, int column) {

    public Position move(Direction direction) {
        return new Position(
                row + direction.getDeltaRow(),
                column + direction.getDeltaColumn()
        );
    }

    @Override
    public String toString() {
        return "Position{row=" + row + ", column=" + column + "}";
    }
}
