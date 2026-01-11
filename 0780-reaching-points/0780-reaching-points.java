class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
         while (tx > sx && ty > sy && tx != ty) {          // [web:7]
        if (tx > ty) tx %= ty;                        // [web:7]
        else ty %= tx;                                // [web:7]
    }

    if (tx == sx && ty == sy) return true;            // exact match [web:7]

    if (tx == sx && ty > sy && (ty - sy) % sx == 0)   // add sx repeatedly to sy [web:7]
        return true;

    if (ty == sy && tx > sx && (tx - sx) % sy == 0)   // add sy repeatedly to sx [web:7]
        return true;

    return false;    
    }
}