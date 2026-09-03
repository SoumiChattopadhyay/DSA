/*
3568. Minimum Moves to Clean the Classroom

You are given an m x n grid classroom where a student volunteer is tasked with cleaning up litter scattered around the room. Each cell in the grid is one of the following:
'S': Starting position of the student
'L': Litter that must be collected (once collected, the cell becomes empty)
'R': Reset area that restores the student's energy to full capacity, regardless of their current energy level (can be used multiple times)
'X': Obstacle the student cannot pass through
'.': Empty space
You are also given an integer energy, representing the student's maximum energy capacity. The student starts with this energy from the starting position 'S'.
Each move to an adjacent cell (up, down, left, or right) costs 1 unit of energy. If the energy reaches 0, the student can only continue if they are on a reset area 'R', which resets the energy to its maximum capacity energy.
Return the minimum number of moves required to collect all litter items, or -1 if it's impossible.

Example 1:
Input: classroom = ["S.", "XL"], energy = 2
Output: 2
Explanation:
The student starts at cell (0, 0) with 2 units of energy.
Since cell (1, 0) contains an obstacle 'X', the student cannot move directly downward.
A valid sequence of moves to collect all litter is as follows:
Move 1: From (0, 0) → (0, 1) with 1 unit of energy and 1 unit remaining.
Move 2: From (0, 1) → (1, 1) to collect the litter 'L'.
The student collects all the litter using 2 moves. Thus, the output is 2.

Example 2:
Input: classroom = ["LS", "RL"], energy = 4
Output: 3
Explanation:
The student starts at cell (0, 1) with 4 units of energy.
A valid sequence of moves to collect all litter is as follows:
Move 1: From (0, 1) → (0, 0) to collect the first litter 'L' with 1 unit of energy used and 3 units remaining.
Move 2: From (0, 0) → (1, 0) to 'R' to reset and restore energy back to 4.
Move 3: From (1, 0) → (1, 1) to collect the second litter 'L'.
The student collects all the litter using 3 moves. Thus, the output is 3.

Example 3:
Input: classroom = ["L.S", "RXL"], energy = 3
Output: -1
Explanation:
No valid path collects all 'L'.

Constraints:
1 <= m == classroom.length <= 20
1 <= n == classroom[i].length <= 20
classroom[i][j] is one of 'S', 'L', 'R', 'X', or '.'
1 <= energy <= 50
There is exactly one 'S' in the grid.
There are at most 10 'L' cells in the grid.
*/

/*
Logic: this is a BFS + bitmask problem
    First: what changes as we move?
    At any point, we need to know:
        Where we are → (row, col)
        How much energy we have
        Which litter we've already collected
    The third one is the tricky part.
    There can be at most 10 litter cells.
    So we can represent collected litter using a bitmask.
    For example, if there are 4 litter cells:
    L0  L1  L2  L3
    and we've collected L0 and L2:
    0101
    Each bit tells us whether a particular litter has been collected.

    Now think about BFS
    BFS is perfect because every movement costs exactly 1.
    So the first time we reach a state with all litter collected, we've found the minimum number of moves.
    A state looks like:
    (row, col, energy, mask)
    For example:
    (2, 3, 4, 0101)
    means:
    We're at (2,3), have 4 energy left, and have collected litter 0 and 2.

    One important detail
    Suppose we move onto an L.
    We need to change the mask.
    If litter #2 is at that position:
    mask = mask | (1 << 2);
    Or simply:
    mask |= (1 << 2);

    And if we step onto R:
    newEnergy = energy;
    because it resets to maximum.

    Otherwise:
    newEnergy = energy - 1;

    What is the mask?
        We have at most 10 litter cells. Give each litter a number: L0  L1  L2  L3
        We use a binary number to remember which ones we've collected.
        Initially: 0000
        means nothing collected.
        If we collect L0:
        0001
        If we then collect L2:
        0101
        So each position in the binary number represents one litter:
        L3 L2 L1 L0
        0  1  0  1
        That means:
        L0 → collected ✅
        L1 → not collected ❌
        L2 → collected ✅
        L3 → not collected ❌
        
        Why do we need this?
        Because BFS might reach the same grid cell multiple times, but those situations aren't necessarily the same.
        For example:
            Position = (2,3)
            Energy = 5

            Case 1:
            Mask = 0011
            We've collected L0 and L1.

            Case 2:
            Mask = 1000
            We've collected L3.

            Even though we're at the exact same position with the same energy, these are different situations, because we've collected different litter.
            That's why our BFS state needs:
                (row, col, energy, mask)
            
            And this code:
            mask |= (1 << 2);
            simply means:
            Mark litter #2 as collected.

Now let's build the logic one piece at a time.
Step 1: How many possible masks?
    If there are k litter cells, each litter has 2 possibilities:
    0 → not collected
    1 → collected
    So total combinations are:
    2 × 2 × ... × 2  (k times)
    = 2^k
    Since k ≤ 10:
    2^10 = 1024
    That's tiny enough for BFS.

Step 2: What does BFS store?
    Each BFS state needs:
    (row, col, energy, mask)
    And we need to remember whether we've already visited that exact state.
    So conceptually:
    visited[row][col][energy][mask]
    If we've already been at:
    (2, 3, 4, 0101)
    there's no point processing that exact same state again.

Step 3: What happens when we make a move?
    Suppose we're at:
    (row, col, energy, mask)
    and want to move to (nr, nc).
    First: newEnergy = energy - 1
    because moving costs 1.
    Then check the new cell.
    If it's R
    newEnergy = energy;
    The reset restores it to maximum.
    If it's L
    we mark that litter as collected in mask.

One important edge case
    What if:
    energy = 1
    and we make a move?
    After the move:
    newEnergy = 0
    That's allowed if we land on R, because it immediately resets.
    If we land somewhere else with 0 energy, we can't make another move.

Now here's the key question:
How do we know which bit to set when we land on an L?
    Remember: before BFS starts, we can scan the grid and assign each litter an ID:
    L → ID 0
    L → ID 1
    L → ID 2
    ...
    
How would you store the ID associated with each grid position?
    Think about what data structure you could make alongside the classroom grid.

Step 4 — Give every litter an ID
    Suppose the grid is:
        S . L
        . L .
        R . L
    There are 3 litter cells.
    We assign:
    L → ID 0
    L → ID 1
    L → ID 2

    We need to remember which ID belongs to each grid position.
    That's why we create:
    int[][] id = new int[n][m];

    Initially, every position gets:
    id[i][j] = -1;

    Then while scanning the grid:
    if (ch == 'L') {
        id[i][j] = litterCount;
        litterCount++;
    }

    So we'd have something conceptually like:
    Grid:       S   .   L   .   L
    ID:        -1  -1   0  -1   1

    Now, if BFS reaches the first L, we can look up:
    int idd = id[i][j];
    and know:   
    "This is litter #0."

Step 5 — Mark that litter as collected
    If the litter ID is 2, we want to turn bit 2 ON.
    litter |= (1 << idd);
    For example:
    Before: 0001
    Litter: ID 2
    1 << 2 = 0100
    0001
    OR 0100
    ----
    0101
    Now the mask says:
    L2 → collected ✅
    L0 → collected ✅
    L1 → not collected ❌

Step 6 — How do we know we've collected ALL litter?
    Suppose there are 3 litter cells.
    Then:
    int total = 1 << litterCount;
    gives:
    1 << 3 = 8
    The mask where all 3 bits are ON is:
    111 = 7
    That's why the solution checks:
    if (litter == total - 1)
    Because:
    total     = 1000 (8)
    total - 1 = 0111 (7)
    So:
    litter == 0111
    means every litter has been collected.

So far, the whole idea is:
Grid position → where am I?
Energy         → how much energy do I have?
Mask           → which litter have I collected?
Steps          → how many moves have I made?

Therefore our BFS state is:
(row, col, energy, mask, steps)

Now we get to the most important optimization in the solution you found:
int[][][] visited
instead of the huge 4D visited.
That's the clever part. Let's tackle that next.

Step 7 — Why visited doesn't need energy as a dimension
    You might initially think:
    visited[row][col][energy][mask]
    because energy is part of our state.

    But the optimized solution uses:
    int[][][] visited = new int[n][m][total];
    and stores:
    visited[row][col][mask] = maximum energy we've had
    
    Why is that enough?
    Imagine we reach the same situation twice:
    First time:
    Position = (2,3)
    Litter    = 0101
    Energy    = 8

    Second time:
    Position = (2,3)
    Litter    = 0101
    Energy    = 5

    Which one is better?
    Obviously:
    8 energy > 5 energy
    Both are:
    at the same position,
    have collected the same litter,
    but one has more energy.

    So if we've already explored the state with 8 energy, exploring it again with 5 energy can never give us anything better.
    Therefore we simply remember:
    (2,3,0101) → 8
    and reject any future state that arrives there with ≤ 8 energy.

    That's exactly what this does:
    if (visited[ni][nj][newLiter] >= newEnergy) {
        continue;
    }
    Read it as:
    "If I've already reached this position with this same litter mask and at least as much energy, don't bother exploring this state."

Step 8 — Why can we replace the old value?
    Suppose:
    visited[2][3][0101] = 8
    and now:
    newEnergy = 5

    Then:
    8 >= 5
    so:
    continue;

    But suppose we later reach it with:
    newEnergy = 10
    Then:
    8 >= 10
    is false.
    So we update:
    visited[2][3][0101] = 10;

    This is the important idea:
    For the same (position + collected litter), only the highest energy matters.

    This reduces the state space massively
    Instead of:
    row × col × energy × mask
    we only need:
    row × col × mask
    with the energy value stored inside.

Step 9 — Now BFS
    We start with:
    queue.offer(new Node(sr, sc, 0, 0, e));
    Meaning:
    row       = starting row
    col       = starting column
    step      = 0
    litter    = 0        → nothing collected
    energy    = e        → full energy

    Then:
    Node curr = queue.poll();
    takes one state out.
    From there we try the four directions:
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    These represent:
        (-1,0)
            ↑
    (0,-1) ←     → (0,1)
            ↓
        (1,0)
    For every direction:
    int ni = i + dx[d];
    int nj = j + dy[d];
    we calculate the next cell.
    Then reject it if:
    if (ni < 0 || ni >= n || nj < 0 || nj >= m)
    → outside the grid.
    Or:
    if (classroom[ni].charAt(nj) == 'X')
    → obstacle.
    Then the move happens
    int newEnergy = energy - 1;
    Every movement costs 1 energy.
    Then if the new cell is L:
    newLitter |= (1 << idd);
    If it's R:
    newEnergy = e;
    Then we check our optimized visited.
    If it's a useful new state:
    visited[ni][nj][newLitter] = newEnergy;
    queue.offer(new Node(...));
    And BFS keeps going.
    Finally:
    if (litter == total - 1) {
        return step;
    }
    means:
    We've collected everything, so return the number of moves.

    Because BFS explores states in increasing number of moves, that first answer is guaranteed to be the minimum.

This is simply creating a custom object to represent one BFS state :
class Solution {
    class Node {
        int i, j, step, litter, energy;

        Node(int i, int j, int step, int litter, int energy) {
            this.i = i;
            this.j = j;
            this.step = step;
            this.litter = litter;
            this.energy = energy;
        }
    }
Each Node stores:
i       → row
j       → column
step    → number of moves made
litter  → which litter has been collected
energy  → remaining energy
    */

import java.util.LinkedList;
import java.util.Queue;

public class Day2_Min_Moves_to_Clean_the_Classroom{
    class State{
        int row,col,step,litterCount,energy;
        State(int row,int col,int step,int litterCount,int energy){
            this.row=row;
            this.col=col;
            this.step = step;
            this.litterCount = litterCount;
            this.energy = energy;
        }
    }
    static int minMoves(String[] classroom, int e){
        int n=classroom.length;
        int m=classroom[0].length();
        // Traverse the classroom grid to find starting row and starting col, and to assign litter ids to litters
        int sr=-1,sc=-1;
        int id[][] = new int[n][m];
        int litterCount=0;//initially
        for(int i=0;i<n;i++){//Loop 1
            for(int j=0;j<m;j++){
                id[i][j]=0;
                if(classroom[i].charAt(j)=='S'){
                    sr=i;
                    sc=j;
                }
                else if(classroom[i].charAt(j)=='L'){
                    id[i][j]=litterCount++;
                }
            }
        }
        
        Queue<State> q = new LinkedList<>();
        q.offer(new State(sr,sc,0,0,e));
        
        int[] dRow = {0,-1,0,1};
        int[] dCol = {-1,0,1,0};
        
        while(!q.isEmpty()){
            State currState = q.poll();
            int currRow = currState.row;
            int currCol = currState.col;
            int currStep = currState.step;
            int currLitterCount = currState.litterCount;
            int currEnergy = currState.energy;
            for(int i=0;i<4;i++){
                int neighRow = currRow + dRow[i];
                int neighCol = currCol + dCol[i];
                q.offer(new State(neighRow,neighCol,currStep+1,currLitterCount+1,currEnergy));
            }
        }
    }
    public static void main(String[] args) {
        String[] classroom = {
            "S.",
            "XL"
        };
        int energy = 2;
        System.out.println(minMoves(classroom, energy));
    }
}

//Step by step code logic building :-
// Create Queue for bfs traversal --> Queue stores multiple States --> One State object has (row,col,step,litterCount,energy)
// To store first state in Queue we need starting row and starting col
// So we need to // Traverse the classroom grid to find starting row and starting col in #Loop 1
// Pop state from queue and Visit neighbors of that state(4 directions) and push to Queue only the efficient states
// Now lets say we straightaway add neighbor state to queue q.offer(new State(neighRow,neighCol,currStep+1,currLitterCount+1,currEnergy));❌
// Now lets correct it. We will only add valid neighbor states to queue
// currLitterCount won't increase by +1 rather newLitterCount will be calculated separately - and how?
// 