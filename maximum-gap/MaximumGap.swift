func maximumGap(_ nums: [Int]) -> Int {
    if nums.count < 2 {
        return 0
    }
    
    var sorted = nums.sorted { $0 < $1}
    
    var maxGap = 0;
    for i in 1..<sorted.count {
        maxGap = max(sorted[i] - sorted[i-1], maxGap)
    }
    
    return maxGap
}

