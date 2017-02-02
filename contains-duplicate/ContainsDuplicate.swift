func containsDuplicate(_ nums: [Int]) -> Bool {
    if nums.count < 2 {
        return false
    }

    var sorted = nums.sorted { $0 < $1 }
    for i in 1..<sorted.count {
        if sorted[i-1] == sorted[i] {
            return true
        }
    }
    return false
}
