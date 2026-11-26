class Solution {
    public boolean canAliceWin(int n) {
        int remove = 10;
        boolean found = true;

        while (n >= remove) {
            n -= remove;
            found = !found;
            remove--;
        }

        return !found;
    }
}