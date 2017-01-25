func rotate(_ nums: inout [Int], _ k: Int) {
    guard k > 0 else {
        return
    }

    var c = k
    while c > nums.count {
        c -= nums.count
    }
    reverse(&nums, 0, nums.count - 1)
    reverse(&nums, 0, c - 1)
    reverse(&nums, c, nums.count - 1)
}

func reverse(_ nums: inout [Int], _ start: Int, _ last: Int) {
    var high = last
    var low = start
    while low < high {
        let temp = nums[high]
        nums[high] = nums[low]
        nums[low] = temp
        low += 1
        high -= 1
    }
}
