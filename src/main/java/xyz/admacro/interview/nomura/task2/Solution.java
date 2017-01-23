package xyz.admacro.interview.nomura.task2;

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

import java.util.ArrayList;
import java.util.List;

class Solution {
    public String solution(int N, String S, String T) {
        List<Ship> ships = getShips(S);
        List<Pos> hits = getHits(T);
        int sunk = 0;
        int hit = 0;
        for (Ship ship: ships) {
            int blood = checkBlood(ship, hits);
            if (blood == 0) {
                sunk++;
            } else if (blood < ship.pos.size()) {
                hit++;
            }
        }
        return sunk + "," + hit;
    }

    public int checkBlood(Ship ship, List<Pos> hits) {
        int blood = ship.pos.size();
        if (ship != null && ship.pos != null) {
            for (Pos shipPos: ship.pos) {
                if (hits.contains(shipPos)) {
                    blood--;
                }
            }
        }
        return blood;
    }

    public List<Ship> getShips(String s) {
        List<Ship> shipList = new ArrayList<>();
        String[] shipsPos = s.split(",");
        if (shipsPos.length > 0) {
            for (String shipPos: shipsPos) {
                shipList.add(populateShip(shipPos));
            }
        }
        return shipList;
    }


    public Ship populateShip(String s) {
        List<Pos> posList = new ArrayList<>();
        String[] ship = s.split(" ");
        if (ship.length == 2) {
            String start = ship[0];
            String end = ship[1];
            int rx = Integer.parseInt(start.substring(0, 1), 10);
            int ry = getPos(start.substring(1));
            int cx = Integer.parseInt(end.substring(0, 1), 10);
            int cy = getPos(end.substring(1));
            for (int i = rx; i <= cx; i++) {
                for (int j = ry; j <= cy; j++) {
                    posList.add(new Pos(i, j));
                }
            }
        }
        return new Ship(posList);
    }

    public List<Pos> getHits(String s) {
        List<Pos> posList = new ArrayList<>();
        String[] hits = s.split(" ");
        for (String hit: hits) {
            int x = Integer.parseInt(hit.substring(0, 1), 10);
            int y = getPos(hit.substring(1));
            posList.add(new Pos(x, y));
        }
        return posList;
    }


    public int getPos(String s) {
        if (s.length() > 0) {
            int ascii = (int) s.charAt(0);
            if (ascii >= 65 && ascii <= 90) {
                return ascii - 65 + 1;
            }
        }
        return 0;
    }

    class Ship {
        public Ship(List<Pos> pos) {
            this.pos = pos;
        }

        List<Pos> pos;
    }

    class Pos {
        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int x;
        int y;

        @Override
        public String toString() {
            return "Pos{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pos pos = (Pos) o;

            if (x != pos.x) return false;
            return y == pos.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(0, "1B 2B,1C 1D,2C 3D,4B 4D", "1B 2A 2B 2C 3B 3C 4B"));
    }

}