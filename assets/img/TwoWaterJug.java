package bfs;

import java.util.*;

public class TwoWaterJug {

    static class State {
        int[] jugs;
        State previous;

        State(int[] jugs) {
            this.jugs = jugs;
        }

        State(int[] jugs, State previous) {
            this.jugs = jugs;
            this.previous = previous;
        }

        public boolean equals(Object obj) {
            if (obj instanceof State) {
                State s = (State) obj;
                return jugs[0] == s.jugs[0] && jugs[1] == s.jugs[1];
            }
            return false;
        }

        public int hashCode() {
            return Arrays.hashCode(jugs);
        }

        public String toString() {
            return "[" + jugs[0] + ", " + jugs[1] + "]";
        }
    }

    static void bfs(int jug1, int jug2, int target, int[] start) {
        Map<State, State> path = new HashMap<>();
        Queue<State> queue = new LinkedList<>();
        State startState = new State(start);
        queue.add(startState);
        while (!queue.isEmpty()) {
            State currState = queue.poll();
            int[] jugs = currState.jugs;
            if (jugs[0] == target || jugs[1] == target) {
                printPath(path, startState, currState);
                return;
            }
            // Fill jug 1
            State nextState = new State(new int[] {jug1, jugs[1]}, currState);
            if (!path.containsKey(nextState)) {
                path.put(nextState, currState);
                queue.add(nextState);
            }
            // Fill jug 2
            nextState = new State(new int[] {jugs[0], jug2}, currState);
            if (!path.containsKey(nextState)) {
                path.put(nextState, currState);
                queue.add(nextState);
            }
            // Pour jug 1 into jug 2
            if (jugs[0] + jugs[1] <= jug2) {
                nextState = new State(new int[] {0, jugs[0] + jugs[1]}, currState);
                if (!path.containsKey(nextState)) {
                    path.put(nextState, currState);
                    queue.add(nextState);
                }
            } else {
                nextState = new State(new int[] {jugs[0] + jugs[1] - jug2, jug2}, currState);
                if (!path.containsKey(nextState)) {
                    path.put(nextState, currState);
                    queue.add(nextState);
                }
            }
            // Pour jug 2 into jug 1
            if (jugs[0] + jugs[1] <= jug1) {
                nextState = new State(new int[] {jugs[0] + jugs[1], 0}, currState);
                if (!path.containsKey(nextState)) {
                    path.put(nextState, currState);
                    queue.add(nextState);
                }
            } else {
                nextState = new State(new int[] {jug1, jugs[0] + jugs[1] - jug1}, currState);
                if (!path.containsKey(nextState)) {
                    path.put(nextState, currState);
                    queue.add(nextState);
                }
            }
        }
        System.out.println("No solution found");
    }

    static void dfs(int jug1, int jug2, int target, int[] start) {
        Map<State, State> path = new HashMap<>();
        Stack<State> stack = new Stack<>();
        State startState = new State(start);
        stack.push(startState);
        while (!stack.isEmpty()) {
            State currState = stack.pop();
            int[] jugs = currState.jugs;
            if (jugs[0] == target || jugs[1] == target) {
                printPath(path, startState, currState);
                return;
            }
            // Fill jug 1
            State nextState = new State(new int[] {jug1, jugs[1]}, currState);
            if (!path.containsKey(nextState)) {
                path.put(nextState, currState);
                stack.push(nextState);
            }
            // Fill jug 2
            nextState = new State(new int[] {jugs[0], jug2}, currState);
            if (!path.containsKey(nextState)) {
                path.put(nextState, currState);
                stack.push(nextState);
            }
            // Pour jug 1 into jug 2
            if (jugs[0] + jugs[1] <= jug2) {
                nextState = new State(new int[] {0, jugs[0] + jugs[1]}, currState);
                if (!path.containsKey(nextState)) {
                    path.put(nextState, currState);
                    stack.push(nextState);
                }
            } else {
                nextState = new State(new int[] {jugs[0] + jugs[1] - jug2, jug2}, currState);
                if (!path.containsKey(nextState)) {
                    path.put(nextState, currState);
                    stack.push(nextState);
                }
            }
            // Pour jug 2 into jug 1
            if (jugs[0] + jugs[1] <= jug1) {
                nextState = new State(new int[] {jugs[0] + jugs[1], 0}, currState);
                if (!path.containsKey(nextState)) {
                    path.put(nextState, currState);
                    stack.push(nextState);
                }
            } else {
                nextState = new State(new int[] {jug1, jugs[0] + jugs[1] - jug1}, currState);
                if (!path.containsKey(nextState)) {
                    path.put(nextState, currState);
                    stack.push(nextState);
                }
            }
        }
        System.out.println("No solution found");
    }

    static void printPath(Map<State, State> path, State start, State end) {
        List<State> result = new ArrayList<>();
        State curr = end;
        while (curr != start) {
            result.add(curr);
            curr = path.get(curr);
        }
        result.add(start);
        Collections.reverse(result);
        for (State state : result) {
            System.out.println(state);
        }
    }

    public static void main(String[] args) {
        int jug1 = 4;
        int jug2 = 3;
        int target = 2;
        int[] start = {0, 0};
        System.out.println("BFS:");
        bfs(jug1, jug2, target, start);
        System.out.println("DFS:");
        dfs(jug1, jug2, target, start);
    }
}