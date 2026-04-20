vector<vector<int>> combinationSum3(int k, int n) {
    if (!k || k > 9) return {};
    const vector<vector<int>> REF{{0, 1, 3, 6, 10, 15, 21, 28, 36, 45},
                                  {0, 9,17,24, 30, 35, 39, 42, 44, 45}};
    vector<vector<int>> ans;
    vector<int> buf(k, 0);
    for (int i = 0, sum = 0; i >= 0; ) {
        if (i == k - 1) {
            int r = n - sum;
            if (r > (i ? buf[i-1] : 0) && r < 10) {
                buf[i] = r;
                ans.push_back(buf);
            }
            --i;
            continue;
        }

        sum -= buf[i]++;
        int p = (i ? buf[i-1] : 0), r = n - sum, rc = k - i;
        if (buf[i] <= p) buf[i] = p + 1;
        if (buf[i] > 9 || p + rc > 9 || r < REF[0][p+rc] - REF[0][p] || r > REF[1][rc]) {
            buf[i--] = 0;
            continue;
        }
        sum += buf[i++];
    }
    return ans;
}