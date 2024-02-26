package com.github.hcsp.polymorphism;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Point {

    private final int x;
    private final int y;

    // 代表笛卡尔坐标系中的一个点
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Point point = (Point) o;

        if (x != point.x) {
            return false;
        }
        return y == point.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public String toString() {
        return String.format("(%d,%d)", x, y);
    }

    public static List<Point> sort(List<Point> points) {
        return points.stream()
                .sorted(Comparator.comparingInt(Point::getX)
                        .thenComparingInt(Point::getY))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Point> points = Arrays.asList(
                new Point(2, 0),
                new Point(-1, 1),
                new Point(1, -1),
                new Point(2, 1),
                new Point(2, -1));
        System.out.println(Point.sort(points));
    }
}
