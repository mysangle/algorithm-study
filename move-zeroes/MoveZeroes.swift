
func moveZeroes(_ nums: inout [Int]) {
    let count: Int = nums.count - 1
    var zeros = 0
    for index in stride(from: count, to: -1, by: -1) {
        let val = nums[index]
        if val == 0 {
            nums.remove(at: index)
            zeros = zeros + 1
        }
    }
    for _ in 0..<zeros {
        nums.append(0)
    }
}

