func nextGreaterElements(_ nums: [Int]) -> [Int] {
    if nums.count == 0 {
        return nums
    }
    
    var greaterNum:[Int] = Array(repeating: 0, count: nums.count)
    let lastIndex = nums.count - 1
    let v = calGreaterNum(nums, lastIndex)
    greaterNum[lastIndex] = v
    for index in (0..<lastIndex).reversed() {
        if nums[index] < nums[index+1] {
            greaterNum[index] = nums[index+1]
        } else if nums[index] < greaterNum[index+1] {
            greaterNum[index] = greaterNum[index+1]
        } else {
            greaterNum[index] = calGreaterNum(nums, index)
        }
    }
    return greaterNum
}

func calGreaterNum(_ nums: [Int], _ startIndex: Int) -> Int {
    var index = (startIndex + 1) % nums.count
    for _ in 0..<nums.count {
        if nums[index] > nums[startIndex] {
            return nums[index]
        }
        index = (index + 1) % nums.count
    }
    return -1;
}

