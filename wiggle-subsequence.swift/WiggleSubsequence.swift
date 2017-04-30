/**
 * wiggleMaxLength: Time Limit Exceeded
 * wiggleMaxLength2: ok 
 */
func wiggleMaxLength(_ nums: [Int]) -> Int {
    return iWiggleMaxLength(nums, 0, 0)
}

func iWiggleMaxLength(_ nums: [Int], _ index: Int, _ maxlen: Int) -> Int {
    if nums.count == index {
        if maxlen >= nums.count {
            return maxlen
        }
        let count = calWiggle(nums)
        print("\(nums): \(count) - \(maxlen)")
        return count
    }
    
    let include = iWiggleMaxLength(nums, index+1, maxlen)
    
    if include >= index {
        var newNums = nums
        newNums.remove(at: index)
        let m = max(include, maxlen)
        let exclude = iWiggleMaxLength(newNums, index, m)
        return max(include, exclude)
    }
    
    return include
}

func calWiggle(_ nums: [Int]) -> Int {
    if nums.count < 2 {
        return nums.count
    }
    if nums.count == 2 {
        if nums[0] != nums[1] {
            return 2
        } else {
            return 1
        }
    }
    
    var count = 1
    var prev = 0
    var middle = 1
    var next = 2
    var f = nums[prev] < nums[middle]
    while nums[prev] != nums[middle] {
        count += 1
        let s = nums[middle] < nums[next]
        if f == s {
            break
        }
        
        prev += 1
        middle += 1
        next += 1
        f = s
        if nums.count == next {
            count += 1
            break
        }
    }
    return count
}

func wiggleMaxLength2(_ nums: [Int]) -> Int {
    if nums.count < 2 {
        return nums.count
    }
    
    var count = 0
    var diff = 0
    for index in 1..<nums.count {
        if nums[index-1] != nums[index] {
            if nums[index-1] < nums[index] {
                if diff <= 0 {
                    count += 1
                }
                diff = 1
            } else {
                if diff >= 0 {
                    count += 1
                }
                diff = -1
            }
        }
    }
    return count + 1
}
