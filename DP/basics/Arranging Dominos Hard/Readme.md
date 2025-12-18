Arranging Dominos – Hard
Problem Summary

You are given a floor of size 5 × N.

Available Tiles

Original tiles:

1 × 5

2 × 5

After rotation:

5 × 1

5 × 2

Rules

The floor must be fully covered.

Tiles cannot be cut.

Tiles must stay inside the floor.

Tiles must be placed parallel to the floor boundaries.

Task

For each test case, compute the number of distinct tilings of the floor.

Return the answer modulo 10⁹ + 7.

Input Format
T
N1
N2
...
NT

Output Format
Answer for N1
Answer for N2
...
Answer for NT

Constraints

1 ≤ T ≤ 10⁴

1 ≤ N ≤ 10⁶

Example
Input
5
2
4
20
120
10

Output
2
5
466098
562804719
457

⚠️ Why Your Current Code Is WRONG for Hard

Your code:

dp[i] = (dp[i-1] + dp[i-2] + 8 * dp[i-5]) % mod;

❌ This recurrence is from Arranging Dominos – Easy

In Easy:

Tiles: 5×1 and 1×5

Only one tile height

Horizontal placements are very limited

So the recurrence:

dp[n] = dp[n-1] + dp[n-2] + 8·dp[n-5]


works only for Easy.

🚫 What Changes in the Hard Version?

In Hard, you introduce new tile types:

Tile	Effect
5×1	Covers 1 column
5×2	Covers 2 columns
1×5	Covers full width (horizontal)
2×5	Covers full width (horizontal)

👉 This creates partial column states that cannot be counted using a single dp[n] formula.

❗ Key Insight (Why Simple DP Fails)

When placing:

5×2 vertically, or

2×5 horizontally,

you do not always complete a full column.

That means:

Some columns are partially filled

Future placements depend on how much of the column is already occupied

👉 A 1D DP (dp[n]) is insufficient

✅ Correct Approach (Conceptual)

You must use DP with states.

State Definition

Let:

dp[n][mask]


n → current column

mask → which rows of column n are already filled
(5 rows → 5-bit mask → 0 to 31)

Transitions

At each column:

Try placing:

5×1

5×2

1×5

2×5

Update the mask and advance columns accordingly

This is a profile DP (bitmask DP).

Complexity

States: N × 2⁵ = 32N

Transitions: constant

Total complexity: O(N × 32)
✔ Works for N ≤ 10⁶

❌ Why Recursion / Your Code Cannot Work
1. Wrong recurrence

Your formula ignores partial fillings, which exist in Hard.

2. Missing state information

You only track n, but the problem needs (n, mask).

3. Example proof

For N = 10:

Your code gives ❌ wrong values

Correct output is 457

🔍 Why Base Values Still Match (Misleading!)
dp[1] = 1
dp[2] = 2
dp[3] = 3
dp[4] = 5


These match by coincidence because:

Larger tiles don’t fit yet

Partial states don’t appear

From N ≥ 5, your logic breaks.