func checkPerfectNumber(_ num: Int) -> Bool {
    if (num <= 0) {
        return false
    }
    if (num % 2) != 0 {
        return false
    }
    
    var sum = 0
    var current = num
    while current != 1 {
        let remain = current % 2
        current = current / 2
        if remain == 1 {
            current += 1
        }
        sum += current
    }

    if sum != num {
        return false
    }
    return true
}

